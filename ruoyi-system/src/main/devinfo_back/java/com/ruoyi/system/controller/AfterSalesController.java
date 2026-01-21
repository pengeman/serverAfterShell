package com.ruoyi.system.controller;

import java.io.*;
import java.util.List;

import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.AftersalesBack;
import com.ruoyi.system.domain.Fixreport;
import com.ruoyi.system.domain.SysFileInfo;
import com.ruoyi.system.service.IAftersalesBackService;
import com.ruoyi.system.service.INoteService;
import com.ruoyi.system.service.ISysFileInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AfterSales;
import com.ruoyi.system.service.IAfterSalesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

/**
 * afterSalesController
 *
 * @author peng
 * @date 2024-07-04
 */
@Controller
@RequestMapping("/system/AfterSales")
public class AfterSalesController extends BaseController {
    private String prefix = "system/AfterSales";
    @Value("${server.servlet.upload-path}")
    public String path;

    @Autowired
    private IAfterSalesService afterSalesService;
    @Autowired
    private IAftersalesBackService aftersalesBackService;
    @Autowired
    private ISysFileInfoService sysFileInfoService;
    @Autowired
    private INoteService noteService;

    @RequiresPermissions("system:AfterSales:view")
    @GetMapping()
    public String AfterSales() {
        return prefix + "/AfterSales";
    }

    /**
     * 查询afterSales列表
     */
    @RequiresPermissions("system:AfterSales:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AfterSales afterSales) {
        startPage();
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        return getDataTable(list);
    }

    /**
     * 导出afterSales列表
     */
    @RequiresPermissions("system:AfterSales:export")
    @Log(title = "afterSales", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AfterSales afterSales) {
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        ExcelUtil<AfterSales> util = new ExcelUtil<AfterSales>(AfterSales.class);
        return util.exportExcel(list, "afterSales数据");
    }

    /**
     * 新增afterSales
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存afterSales
     */
    @RequiresPermissions("system:AfterSales:add")
    @Log(title = "afterSales", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AfterSales afterSales) {
        return toAjax(afterSalesService.insertAfterSales(afterSales));
    }

    /**
     * 导入售后单据 importJson
     */
    @Log(title = "AfterSales:importJson", businessType = BusinessType.IMPORT)
    @GetMapping("/importJson")
    public String importJson() {
        //String afterSalesJson = request.getParameter("afterSalesJson");
        //afterSalesService.importAfterSalesFromJson(afterSalesJson);
        System.out.println("AfterSalesComntroller:importJson");
        return prefix + "/importJson";
    }

    /**
     * 保存导入的AfterSales
     */
    @RequiresPermissions("system:AfterSales:add")
    @Log(title = "AfterSales:importSave", businessType = BusinessType.INSERT)
    @PostMapping("/importJson")
    @ResponseBody
    public AjaxResult importSave(HttpServletRequest request) {
        try {
            System.out.println("AfterSalesController:importSave");
            String afterSalesJson = request.getParameter("jsonAfterSales");
            //System.out.println(afterSalesJson);

            //Part file = request.getPart("dispatchfile");
            //System.out.println("file: " + file);
            //String filename = file.getSubmittedFileName();
            //System.out.println("filename : " + filename);
            //InputStream is = file.getInputStream();
            //FileOutputStream outputStream = new FileOutputStream(filename);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = is.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, length);
//            }
            return toAjax(afterSalesService.importAfterSalesFromJson(afterSalesJson));
        } catch (Exception e) {
            e.printStackTrace();
            return toAjax(false);
        }


    }

    /**
     * 修改afterSales
     */
    @RequiresPermissions("system:AfterSales:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        System.out.println("edit++++++++++++++++++++++++++++++++");
        AfterSales afterSales = afterSalesService.selectAfterSalesById(id);
        mmap.put("afterSales", afterSales);
        return prefix + "/edit";
    }

    /**
     * 修改保存afterSales
     * <p>
     * // 上传文件路径
     * String filePath = RuoYiConfig.getUploadPath();
     * // 上传并返回新文件名称
     * String fileName = FileUploadUtils.upload(filePath, file);
     * fileInfo.setFilePath(fileName);
     * return toAjax(sysFileInfoService.insertSysFileInfo(fileInfo));
     */
    @RequiresPermissions("system:AfterSales:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(
            AfterSales afterSales,
            @RequestPart("filePath") MultipartFile front,
            HttpServletRequest request) throws ServletException, IOException {

//        String filename = request.getPart("filePath").getSubmittedFileName();
//        System.out.println(" path : " + path);
//        File uploadfile = new File(path);
//        if (uploadfile.exists()) {
//        } else {
//            uploadfile.mkdir();
//        }

//        String fileName = front.getOriginalFilename();
//        String filePath = RuoYiConfig.getUploadPath();
//        System.out.println("fileName : " + fileName);
        // 获得上传文件信息 fileInfo
        SysFileInfo fileInfo = new SysFileInfo();
//        fileInfo.setFileName(fileName);
//        fileInfo.setFilePath(filePath);
        //sysFileInfoService.insertSysFileInfo(fileInfo);
//        System.out.println(id);
        Long id = fileInfo.getFileId();
        afterSales.setAttachment(id + "");

//        // 获得note,并保存
//        String snote = request.getParameter("note");
//        com.ruoyi.system.domain.Note note = new com.ruoyi.system.domain.Note();
//        note.setNote(snote);
        //noteService.insertNote(note);
        int r = afterSalesService.editSales(afterSales, fileInfo, front);
        return toAjax(r);
    }

    @RequiresPermissions("system:AfterSales:edit")
    @PostMapping("/edit2")
    @ResponseBody
    public AjaxResult editSave2(
            AfterSales afterSales,
            HttpServletRequest request) throws ServletException, IOException {

        //System.out.println("editSave+++++++++++++++++++++++++++++++++++++++");

        Part part = request.getPart("filePath");
        String filename = part.getSubmittedFileName();

        System.out.println(" path : " + path);
        File uploadfile = new File(path);
        if (uploadfile.exists()) {
        } else {
            uploadfile.mkdir();
        }
        filename = path + filename;
        System.out.println("filename : " + filename);
        part.write(filename);
        afterSales.setAttachment(filename);
        int r = afterSalesService.updateAfterSales(afterSales);
        return toAjax(r);
    }

    /**
     * 通过afterSales，显示通过售后单页面
     */
    @RequiresPermissions("system:AfterSales:edit")
    @GetMapping("/gopass/{id}")
    public String gopass(@PathVariable("id") Long id, ModelMap mmap) {
        System.out.println("gopass++++++++++++++++++++++++++++++++" + id);
        AfterSales afterSales = afterSalesService.selectAfterSalesById(id);
        Fixreport fixreport = new Fixreport();
        fixreport.setAfterSalesID(id);
        fixreport.setCustomer(afterSales.getCustomer());
        fixreport.setCustomerAddr(afterSales.getCustomerAddr());
        fixreport.setDeviceType(afterSales.getDeviceType());
        fixreport.setPerson("");
        fixreport.setProductionID(afterSales.getProductionID());
        fixreport.setQuetion(afterSales.getQuetion());
        fixreport.setWorkcase(afterSales.getCondition());
        fixreport.setDispatchfile(afterSales.getAttachment());

        mmap.put("fixreport", fixreport);
        return prefix + "/gopass";
    }

    /**
     * 通过售后单，保存售后分析单
     */
    @RequiresPermissions("system:AfterSales:edit")
    @Log(title = "afterSales", businessType = BusinessType.UPDATE)
    @PostMapping("/gopass")
    @ResponseBody
    public AjaxResult gopasssave(
            Long afterSalesID,
            //AftersalesBack afterSalesBack,

            //@RequestPart("front") MultipartFile front,
            HttpServletRequest request) throws ServletException, IOException {

        //System.out.println("editSave+++++++++++++++++++++++++++++++++++++++");

        String filename = request.getPart("front").getSubmittedFileName();
        //System.out.println(" path : " + path);
        File uploadfile = new File(path);
        if (uploadfile.exists()) {
        } else {
            uploadfile.mkdir();
        }
        filename = path + filename;
        System.out.println("filename : " + filename);
        request.getPart("front").write(filename);
        AfterSales afterSales = afterSalesService.selectAfterSalesById(afterSalesID);
        int r = afterSalesService.gopassSales(afterSales, filename);
        return toAjax(r);

    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // 本地资源路径
        String localPath = RuoYiConfig.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }

    /**
     * 删除afterSales
     */
    @RequiresPermissions("system:AfterSales:remove")
    @Log(title = "afterSales", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(afterSalesService.deleteAfterSalesByIds(ids));
    }


    /**
     * 查看售后派工单备份
     */
    @RequiresPermissions("system:afterSalesBack:edit")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap) {
        String url = "";
        javax.servlet.ServletContext context = this.getRequest().getServletContext();
        url = this.getRequest().getContextPath();
        System.out.println("servlet context url : " + url);
        url = context.getRealPath("/WEB-INF/uploads");
        System.out.println(" url : " + url);
        System.out.println("view++++++++++++++++++++++++++++++++");
        AfterSales afterSales = afterSalesService.selectAfterSalesById(id);
        String attachmentid = afterSales.getAttachment();

        mmap.put("afterSales", afterSales);

        return prefix + "/view";
    }

    @RequestMapping(value = "/dispatchSheet", method = RequestMethod.GET)
    public ModelAndView upDrugImg(@RequestParam(value = "imgFile", required = false) MultipartFile file, HttpServletRequest request) {
        //file是imgFile的别名，只能上传一张图
        String path = request.getSession().getServletContext().getRealPath("drugIMG");
        String fileName = file.getOriginalFilename();
        // 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        // 对扩展名进行小写转换
        ext = ext.toLowerCase();
        // 定义一个数组，用于保存可上传的文件类型
        List<String> fileTypes = new java.util.ArrayList();
        fileTypes.add("jpg");
        fileTypes.add("jpeg");
        fileTypes.add("bmp");
        fileTypes.add("gif");
        if (!fileTypes.contains(ext)) { // 如果扩展名属于允许上传的类型，则创建文件
            System.out.println("文件类型不允许");
            return new ModelAndView("errorpage/404");
        }
        // String fileName = new Date().getTime()+".jpg";
        java.io.File targetFile = new java.io.File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        try {
            //使用此方法保存必须要绝对路径且文件夹必须已存在,否则报错
            file.transferTo(targetFile);
        } catch (Exception e) {
            // e.printStackTrace();
            return new ModelAndView("errorpage/500");
        }

//******************这部分根据自己需求写******************
        //将图片名存入数据库

        int flag = 1;//drugService.upDrugImg(drug);
        if (flag != 1) {
            // System.out.println("info:upload image failed!");
            return new ModelAndView("redirect:./goUpDrugImg.htm");
        }
        return new ModelAndView("redirect:./goAllDrugByHouse.htm", "updown", "down");
    }

}
