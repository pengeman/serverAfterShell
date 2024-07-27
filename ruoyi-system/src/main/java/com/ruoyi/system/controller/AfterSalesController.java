package com.ruoyi.system.controller;

import java.io.*;
import java.util.List;

import com.ruoyi.system.domain.AftersalesBack;
import com.ruoyi.system.service.IAftersalesBackService;
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

            Part file = request.getPart("dispatchfile");
            System.out.println("file: " + file);
            String filename = file.getSubmittedFileName();
            System.out.println("filename : " + filename);
            InputStream is = file.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(filename);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            return toAjax(afterSalesService.importAfterSalesFromJson(afterSalesJson));
        } catch (IOException | ServletException e) {
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
     */
    @RequiresPermissions("system:AfterSales:edit")
    @Log(title = "afterSales", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(
            AfterSales afterSales,
            @RequestPart("front") MultipartFile front,
            HttpServletRequest request) throws ServletException, IOException {

        //System.out.println("editSave+++++++++++++++++++++++++++++++++++++++");

        String filename = request.getPart("front").getSubmittedFileName();
        System.out.println(" path : " + path);
        File uploadfile = new File(path);
        if (uploadfile.exists()) {
        } else {
            uploadfile.mkdir();
        }
        filename = path + filename;
        System.out.println("filename : " + filename);
        request.getPart("front").write(filename);
        return toAjax(afterSalesService.updateAfterSales(afterSales));
    }


    /**
     * 通过afterSales，显示通过售后单页面
     */
    @RequiresPermissions("system:AfterSales:edit")
    @GetMapping("/gopass/{id}")
    public String gopass(@PathVariable("id") Long id, ModelMap mmap) {
        System.out.println("gopass++++++++++++++++++++++++++++++++" + id);
        AfterSales afterSales = afterSalesService.selectAfterSalesById(id);
        mmap.put("afterSales", afterSales);
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
            int afterSalesID,
            AftersalesBack afterSalesBack,
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

       // return toAjax(afterSalesService.updateAfterSales(afterSales));
        afterSalesService.go
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
