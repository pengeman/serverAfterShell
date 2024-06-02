package com.ruoyi.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

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

import javax.servlet.ServletRequest;

/**
 * AfterSalesController
 * 
 * @author ruoyi
 * @date 2024-05-11
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
     * 查询AfterSales列表
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
     * 导出AfterSales列表
     */
    @RequiresPermissions("system:AfterSales:export")
    @Log(title = "AfterSales", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AfterSales afterSales)
    {
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        ExcelUtil<AfterSales> util = new ExcelUtil<AfterSales>(AfterSales.class);
        return util.exportExcel(list, "AfterSales数据");
    }

    /**
     * 新增AfterSales
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 导入售后单据 importJson
     */
    @Log(title = "AfterSales:importJson", businessType = BusinessType.IMPORT)
    @GetMapping("/importJson")
    public String importJson(){
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
    public AjaxResult importSave(ServletRequest request)
    {
        System.out.println("AfterSalesController:importSave");
        String afterSalesJson = request.getParameter("jsonAfterSales");
        System.out.println(afterSalesJson);
        return toAjax(afterSalesService.importAfterSalesFromJson(afterSalesJson));
    }

    /**
     * 新增保存AfterSales
     */
    @RequiresPermissions("system:AfterSales:add")
    @Log(title = "AfterSales", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AfterSales afterSales)
    {
        return toAjax(afterSalesService.insertAfterSales(afterSales));
    }

    /**
     * 修改AfterSales
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
     * 修改保存AfterSales
     */
    @RequiresPermissions("system:AfterSales:edit")
    @Log(title = "AfterSales", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AfterSales afterSales)
    {
        return toAjax(afterSalesService.updateAfterSales(afterSales));
    }

    /**
     * 删除AfterSales
     */
    @RequiresPermissions("system:AfterSales:remove")
    @Log(title = "AfterSales", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(afterSalesService.deleteAfterSalesByIds(ids));
    }
}
