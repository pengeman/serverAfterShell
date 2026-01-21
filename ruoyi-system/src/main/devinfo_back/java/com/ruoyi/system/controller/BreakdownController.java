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
import com.ruoyi.system.domain.Breakdown;
import com.ruoyi.system.service.IBreakdownService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 故障类型字典Controller
 * 
 * @author ruoyi
 * @date 2024-04-17
 */
@Controller
@RequestMapping("/system/breakdown")
public class BreakdownController extends BaseController
{
    private String prefix = "system/breakdown";

    @Autowired
    private IBreakdownService breakdownService;

    @RequiresPermissions("system:breakdown:view")
    @GetMapping()
    public String breakdown()
    {
        return prefix + "/breakdown";
    }

    /**
     * 查询故障类型字典列表
     */
    @RequiresPermissions("system:breakdown:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Breakdown breakdown)
    {
        startPage();
        List<Breakdown> list = breakdownService.selectBreakdownList(breakdown);
        return getDataTable(list);
    }

    /**
     * 导出故障类型字典列表
     */
    @RequiresPermissions("system:breakdown:export")
    @Log(title = "故障类型字典", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Breakdown breakdown)
    {
        List<Breakdown> list = breakdownService.selectBreakdownList(breakdown);
        ExcelUtil<Breakdown> util = new ExcelUtil<Breakdown>(Breakdown.class);
        return util.exportExcel(list, "故障类型字典数据");
    }

    /**
     * 新增故障类型字典
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存故障类型字典
     */
    @RequiresPermissions("system:breakdown:add")
    @Log(title = "故障类型字典", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Breakdown breakdown)
    {
        return toAjax(breakdownService.insertBreakdown(breakdown));
    }

    /**
     * 修改故障类型字典
     */
    @RequiresPermissions("system:breakdown:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Breakdown breakdown = breakdownService.selectBreakdownById(id);
        mmap.put("breakdown", breakdown);
        return prefix + "/edit";
    }

    /**
     * 修改保存故障类型字典
     */
    @RequiresPermissions("system:breakdown:edit")
    @Log(title = "故障类型字典", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Breakdown breakdown)
    {
        return toAjax(breakdownService.updateBreakdown(breakdown));
    }

    /**
     * 删除故障类型字典
     */
    @RequiresPermissions("system:breakdown:remove")
    @Log(title = "故障类型字典", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(breakdownService.deleteBreakdownByIds(ids));
    }
}
