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
import com.ruoyi.system.domain.Dispatch;
import com.ruoyi.system.service.IDispatchService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 派工单Controller
 * 
 * @author pengweitao
 * @date 2026-01-20
 */
@Controller
@RequestMapping("/system/dispatch")
public class DispatchController extends BaseController
{
    private String prefix = "system/dispatch";

    @Autowired
    private IDispatchService dispatchService;

    @RequiresPermissions("system:dispatch:view")
    @GetMapping()
    public String dispatch()
    {
        return prefix + "/dispatch";
    }

    /**
     * 查询派工单列表
     */
    @RequiresPermissions("system:dispatch:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dispatch dispatch)
    {
        startPage();
        List<Dispatch> list = dispatchService.selectDispatchList(dispatch);
        return getDataTable(list);
    }

    /**
     * 导出派工单列表
     */
    @RequiresPermissions("system:dispatch:export")
    @Log(title = "派工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dispatch dispatch)
    {
        List<Dispatch> list = dispatchService.selectDispatchList(dispatch);
        ExcelUtil<Dispatch> util = new ExcelUtil<Dispatch>(Dispatch.class);
        return util.exportExcel(list, "派工单数据");
    }

    /**
     * 新增派工单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存派工单
     */
    @RequiresPermissions("system:dispatch:add")
    @Log(title = "派工单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dispatch dispatch)
    {
        return toAjax(dispatchService.insertDispatch(dispatch));
    }

    /**
     * 修改派工单
     */
    @RequiresPermissions("system:dispatch:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Dispatch dispatch = dispatchService.selectDispatchById(id);
        mmap.put("dispatch", dispatch);
        return prefix + "/edit";
    }

    /**
     * 修改保存派工单
     */
    @RequiresPermissions("system:dispatch:edit")
    @Log(title = "派工单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dispatch dispatch)
    {
        return toAjax(dispatchService.updateDispatch(dispatch));
    }

    /**
     * 删除派工单
     */
    @RequiresPermissions("system:dispatch:remove")
    @Log(title = "派工单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dispatchService.deleteDispatchByIds(ids));
    }
}
