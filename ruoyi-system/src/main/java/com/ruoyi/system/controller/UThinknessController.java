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
import com.ruoyi.system.domain.UThinkness;
import com.ruoyi.system.service.IUThinknessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 板片厚度Controller
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Controller
@RequestMapping("/system/thinkness")
public class UThinknessController extends BaseController
{
    private String prefix = "system/thinkness";

    @Autowired
    private IUThinknessService uThinknessService;

    @RequiresPermissions("system:thinkness:view")
    @GetMapping()
    public String thinkness()
    {
        return prefix + "/thinkness";
    }

    /**
     * 查询板片厚度列表
     */
    @RequiresPermissions("system:thinkness:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UThinkness uThinkness)
    {
        startPage();
        List<UThinkness> list = uThinknessService.selectUThinknessList(uThinkness);
        return getDataTable(list);
    }

    /**
     * 导出板片厚度列表
     */
    @RequiresPermissions("system:thinkness:export")
    @Log(title = "板片厚度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UThinkness uThinkness)
    {
        List<UThinkness> list = uThinknessService.selectUThinknessList(uThinkness);
        ExcelUtil<UThinkness> util = new ExcelUtil<UThinkness>(UThinkness.class);
        return util.exportExcel(list, "板片厚度数据");
    }

    /**
     * 新增板片厚度
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存板片厚度
     */
    @RequiresPermissions("system:thinkness:add")
    @Log(title = "板片厚度", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UThinkness uThinkness)
    {
        return toAjax(uThinknessService.insertUThinkness(uThinkness));
    }

    /**
     * 修改板片厚度
     */
    @RequiresPermissions("system:thinkness:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UThinkness uThinkness = uThinknessService.selectUThinknessById(id);
        mmap.put("uThinkness", uThinkness);
        return prefix + "/edit";
    }

    /**
     * 修改保存板片厚度
     */
    @RequiresPermissions("system:thinkness:edit")
    @Log(title = "板片厚度", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UThinkness uThinkness)
    {
        return toAjax(uThinknessService.updateUThinkness(uThinkness));
    }

    /**
     * 删除板片厚度
     */
    @RequiresPermissions("system:thinkness:remove")
    @Log(title = "板片厚度", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uThinknessService.deleteUThinknessByIds(ids));
    }
}
