package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.Devinfo2;
import com.ruoyi.system.service.IDevinfo2Service;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备信息明细Controller
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
@Controller
@RequestMapping("/system/devinfo2")
public class Devinfo2Controller extends BaseController
{
    private String prefix = "system/devinfo2";

    @Autowired
    private IDevinfo2Service devinfo2Service;

    @RequiresPermissions("system:devinfo2:view")
    @GetMapping()
    public String devinfo2()
    {
        return prefix + "/devinfo2";
    }

    /**
     * 查询设备信息明细列表
     */
    @RequiresPermissions("system:devinfo2:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Devinfo2 devinfo2)
    {
        startPage();
        List<Devinfo2> list = devinfo2Service.selectDevinfo2List(devinfo2);
        return getDataTable(list);
    }

    /**
     * 导出设备信息明细列表
     */
    @RequiresPermissions("system:devinfo2:export")
    @Log(title = "设备信息明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Devinfo2 devinfo2)
    {
        List<Devinfo2> list = devinfo2Service.selectDevinfo2List(devinfo2);
        ExcelUtil<Devinfo2> util = new ExcelUtil<Devinfo2>(Devinfo2.class);
        return util.exportExcel(list, "设备信息明细数据");
    }

    /**
     * 新增设备信息明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息明细
     */
    @RequiresPermissions("system:devinfo2:add")
    @Log(title = "设备信息明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Devinfo2 devinfo2)
    {
        return toAjax(devinfo2Service.insertDevinfo2(devinfo2));
    }

    /**
     * 修改设备信息明细
     */
    @RequiresPermissions("system:devinfo2:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Devinfo2 devinfo2 = devinfo2Service.selectDevinfo2ById(id);
        mmap.put("devinfo2", devinfo2);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息明细
     */
    @RequiresPermissions("system:devinfo2:edit")
    @Log(title = "设备信息明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Devinfo2 devinfo2)
    {
        return toAjax(devinfo2Service.updateDevinfo2(devinfo2));
    }

    /**
     * 删除设备信息明细
     */
    @RequiresPermissions("system:devinfo2:remove")
    @Log(title = "设备信息明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(devinfo2Service.deleteDevinfo2ByIds(ids));
    }
}
