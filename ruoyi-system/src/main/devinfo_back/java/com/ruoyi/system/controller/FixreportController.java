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
import com.ruoyi.system.domain.Fixreport;
import com.ruoyi.system.service.IFixreportService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修分析报告Controller
 * 
 * @author pengweitao
 * @date 2024-07-28
 */
@Controller
@RequestMapping("/system/fixreport")
public class FixreportController extends BaseController
{
    private String prefix = "system/fixreport";

    @Autowired
    private IFixreportService fixreportService;

    @RequiresPermissions("system:fixreport:view")
    @GetMapping()
    public String fixreport()
    {
        return prefix + "/fixreport";
    }

    /**
     * 查询维修分析报告列表
     */
    @RequiresPermissions("system:fixreport:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fixreport fixreport)
    {
        startPage();
        List<Fixreport> list = fixreportService.selectFixreportList(fixreport);
        return getDataTable(list);
    }

    /**
     * 导出维修分析报告列表
     */
    @RequiresPermissions("system:fixreport:export")
    @Log(title = "维修分析报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fixreport fixreport)
    {
        List<Fixreport> list = fixreportService.selectFixreportList(fixreport);
        ExcelUtil<Fixreport> util = new ExcelUtil<Fixreport>(Fixreport.class);
        return util.exportExcel(list, "维修分析报告数据");
    }

    /**
     * 新增维修分析报告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存维修分析报告
     */
    @RequiresPermissions("system:fixreport:add")
    @Log(title = "维修分析报告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fixreport fixreport)
    {
        return toAjax(fixreportService.insertFixreport(fixreport));
    }

    /**
     * 修改维修分析报告
     */
    @RequiresPermissions("system:fixreport:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Fixreport fixreport = fixreportService.selectFixreportById(id);
        mmap.put("fixreport", fixreport);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修分析报告
     */
    @RequiresPermissions("system:fixreport:edit")
    @Log(title = "维修分析报告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fixreport fixreport)
    {
        return toAjax(fixreportService.updateFixreport(fixreport));
    }

    /**
     * 删除维修分析报告
     */
    @RequiresPermissions("system:fixreport:remove")
    @Log(title = "维修分析报告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fixreportService.deleteFixreportByIds(ids));
    }
}
