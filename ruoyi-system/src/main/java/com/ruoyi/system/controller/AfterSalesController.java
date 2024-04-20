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
import com.ruoyi.system.domain.AfterSales;
import com.ruoyi.system.service.IAfterSalesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2024-04-20
 */
@Controller
@RequestMapping("/system/AfterSales")
public class AfterSalesController extends BaseController
{
    private String prefix = "system/AfterSales";

    @Autowired
    private IAfterSalesService afterSalesService;

    @RequiresPermissions("system:AfterSales:view")
    @GetMapping()
    public String AfterSales()
    {
        return prefix + "/AfterSales";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:AfterSales:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AfterSales afterSales)
    {
        startPage();
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:AfterSales:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AfterSales afterSales)
    {
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        ExcelUtil<AfterSales> util = new ExcelUtil<AfterSales>(AfterSales.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:AfterSales:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AfterSales afterSales)
    {
        return toAjax(afterSalesService.insertAfterSales(afterSales));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:AfterSales:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AfterSales afterSales = afterSalesService.selectAfterSalesById(id);
        mmap.put("afterSales", afterSales);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:AfterSales:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AfterSales afterSales)
    {
        return toAjax(afterSalesService.updateAfterSales(afterSales));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:AfterSales:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(afterSalesService.deleteAfterSalesByIds(ids));
    }
}
