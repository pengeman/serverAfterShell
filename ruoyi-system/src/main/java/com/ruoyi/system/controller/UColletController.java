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
import com.ruoyi.system.domain.UCollet;
import com.ruoyi.system.service.IUColletService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 底托Controller
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
@Controller
@RequestMapping("/system/collet")
public class UColletController extends BaseController
{
    private String prefix = "system/collet";

    @Autowired
    private IUColletService uColletService;

    @RequiresPermissions("system:collet:view")
    @GetMapping()
    public String collet()
    {
        return prefix + "/collet";
    }

    /**
     * 查询底托列表
     */
    @RequiresPermissions("system:collet:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UCollet uCollet)
    {
        startPage();
        List<UCollet> list = uColletService.selectUColletList(uCollet);
        return getDataTable(list);
    }

    /**
     * 导出底托列表
     */
    @RequiresPermissions("system:collet:export")
    @Log(title = "底托", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UCollet uCollet)
    {
        List<UCollet> list = uColletService.selectUColletList(uCollet);
        ExcelUtil<UCollet> util = new ExcelUtil<UCollet>(UCollet.class);
        return util.exportExcel(list, "底托数据");
    }

    /**
     * 新增底托
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存底托
     */
    @RequiresPermissions("system:collet:add")
    @Log(title = "底托", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UCollet uCollet)
    {
        return toAjax(uColletService.insertUCollet(uCollet));
    }

    /**
     * 修改底托
     */
    @RequiresPermissions("system:collet:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UCollet uCollet = uColletService.selectUColletById(id);
        mmap.put("uCollet", uCollet);
        return prefix + "/edit";
    }

    /**
     * 修改保存底托
     */
    @RequiresPermissions("system:collet:edit")
    @Log(title = "底托", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UCollet uCollet)
    {
        return toAjax(uColletService.updateUCollet(uCollet));
    }

    /**
     * 删除底托
     */
    @RequiresPermissions("system:collet:remove")
    @Log(title = "底托", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uColletService.deleteUColletByIds(ids));
    }
}
