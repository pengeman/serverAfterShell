package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.DevInfo;
import com.ruoyi.system.service.IDevInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 设备档案Controller
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
@Controller
@RequestMapping("/system/devInfo")
public class DevInfoController extends BaseController
{
    private String prefix = "system/devInfo";

    @Autowired
    private IDevInfoService devInfoService;

    @RequiresPermissions("system:devInfo:view")
    @GetMapping()
    public String devInfo()
    {
        return prefix + "/devInfo";
    }

    /**
     * 查询设备档案列表
     */
    @RequiresPermissions("system:devInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DevInfo devInfo)
    {
        startPage();
        List<DevInfo> list = devInfoService.selectDevInfoList(devInfo);
        return getDataTable(list);
    }

    /**
     * 导出设备档案列表
     */
    @RequiresPermissions("system:devInfo:export")
    @Log(title = "设备档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DevInfo devInfo)
    {
        List<DevInfo> list = devInfoService.selectDevInfoList(devInfo);
        ExcelUtil<DevInfo> util = new ExcelUtil<DevInfo>(DevInfo.class);
        return util.exportExcel(list, "设备档案数据");
    }

    /**
     * 新增设备档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备档案
     */
    @RequiresPermissions("system:devInfo:add")
    @Log(title = "设备档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DevInfo devInfo)
    {
        return toAjax(devInfoService.insertDevInfo(devInfo));
    }

    //devinfogroupaddsave
    /**
     * 新增保存设备信息，同时保存buyerinfo， userinfo
     */
    @RequiresPermissions("system:devInfo:add")
    @Log(title = "设备档案", businessType = BusinessType.INSERT)
    @PostMapping("/devinfogroupaddSave")
    @ResponseBody
    public AjaxResult devinfogroupaddSave(HttpServletRequest request)
    {

        //return toAjax("devInfoService.insertDevInfo(devInfo)");
        return toAjax(0);
    }


    /**
     * 修改设备档案
     */
    @RequiresPermissions("system:devInfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DevInfo devInfo = devInfoService.selectDevInfoById(id);
        mmap.put("devInfo", devInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备档案
     */
    @RequiresPermissions("system:devInfo:edit")
    @Log(title = "设备档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DevInfo devInfo)
    {
        return toAjax(devInfoService.updateDevInfo(devInfo));
    }

    /**
     * 删除设备档案
     */
    @RequiresPermissions("system:devInfo:remove")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(devInfoService.deleteDevInfoByIds(ids));
    }


    /**
     * 新增设备信息档案
     */
    @GetMapping("/autoadd")
    public String autoadd()
    {
        return prefix + "/autoadd";
    }
    @GetMapping("/frame1")
    public String frame1()
    {
        return prefix + "/demo/frame1";
    }


    /**
     * devserialid
     * 获得设备出厂编号
     */
    @RequiresPermissions("system:devInfo:remove")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/devserialid")
    @ResponseBody
    public AjaxResult devserialid(String ids)
    {
        AjaxResult ajaxresule = new AjaxResult();
        List devInfoList = getdevInfoListFromDevDetail();

        ajaxresule.put("devInfoList" , devInfoList);
        return ajaxresule;
    }


    private List getdevInfoListFromDevDetail(){
        // 得到出厂编号，从设备明细表里
        List  devInfoList = null;
        String[] array = { "ruoyi 1", "ruoyi 2", "ruoyi 3", "ruoyi 4", "ruoyi 5", "peng 6 " };

        return devInfoList;
    }

    /**
     * 查询设备档案列表
     */
    @RequiresPermissions("system:devInfo:list")
    @PostMapping("/listfix")
    @ResponseBody
    public TableDataInfo listfix(DevInfo devInfo)
    {
        startPage();
        List<DevInfo> list = devInfoService.selectDevInfoList(devInfo);
        return getDataTable(list);
    }
    @RequiresPermissions("system:devInfo:view")
    @GetMapping("/fix")
    public String devInfofix()
    {
        return prefix + "/devInfofix";
    }
    @GetMapping("/addfix")
    public String addfix()
    {
        return prefix + "/addfix";
    }
}
