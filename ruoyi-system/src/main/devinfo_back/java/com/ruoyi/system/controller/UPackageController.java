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
import com.ruoyi.system.domain.UPackage;
import com.ruoyi.system.service.IUPackageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 包装箱Controller
 * 
 * @author pengweitao
 * {@code @date} 2025-06-28
 */
@Controller
@RequestMapping("/system/package")
public class UPackageController extends BaseController
{
    private String prefix = "system/package";

    @Autowired
    private IUPackageService uPackageService;

    @RequiresPermissions("system:package:view")
    @GetMapping()
    public String package_()
    {
        return prefix + "/package";
    }

    /**
     * 查询包装箱列表
     */
    @RequiresPermissions("system:package:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UPackage uPackage)
    {
        startPage();
        List<UPackage> list = uPackageService.selectUPackageList(uPackage);
        return getDataTable(list);
    }

    /**
     * 导出包装箱列表
     */
    @RequiresPermissions("system:package:export")
    @Log(title = "包装箱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UPackage uPackage)
    {
        List<UPackage> list = uPackageService.selectUPackageList(uPackage);
        ExcelUtil<UPackage> util = new ExcelUtil<UPackage>(UPackage.class);
        return util.exportExcel(list, "包装箱数据");
    }

    /**
     * 新增包装箱
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存包装箱
     */
    @RequiresPermissions("system:package:add")
    @Log(title = "包装箱", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UPackage uPackage)
    {
        return toAjax(uPackageService.insertUPackage(uPackage));
    }

    /**
     * 修改包装箱
     */
    @RequiresPermissions("system:package:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UPackage uPackage = uPackageService.selectUPackageById(id);
        mmap.put("uPackage", uPackage);
        return prefix + "/edit";
    }

    /**
     * 修改保存包装箱
     */
    @RequiresPermissions("system:package:edit")
    @Log(title = "包装箱", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UPackage uPackage)
    {
        return toAjax(uPackageService.updateUPackage(uPackage));
    }

    /**
     * 删除包装箱
     */
    @RequiresPermissions("system:package:remove")
    @Log(title = "包装箱", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uPackageService.deleteUPackageByIds(ids));
    }
}
