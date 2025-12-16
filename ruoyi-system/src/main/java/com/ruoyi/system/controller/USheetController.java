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
import com.ruoyi.system.domain.USheet;
import com.ruoyi.system.service.IUSheetService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 板片Controller
 * 
 * @author pengweitao
 * {@code @date} 2025-06-28
 */
@Controller
@RequestMapping("/system/sheet")
public class USheetController extends BaseController
{
    private String prefix = "system/sheet";

    @Autowired
    private IUSheetService uSheetService;

    @RequiresPermissions("system:sheet:view")
    @GetMapping()
    public String sheet()
    {
        return prefix + "/sheet";
    }

    /**
     * 查询板片列表
     */
    @RequiresPermissions("system:sheet:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(USheet uSheet)
    {
        startPage();
        List<USheet> list = uSheetService.selectUSheetList(uSheet);
        return getDataTable(list);
    }

    /**
     * 导出板片列表
     */
    @RequiresPermissions("system:sheet:export")
    @Log(title = "板片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(USheet uSheet)
    {
        List<USheet> list = uSheetService.selectUSheetList(uSheet);
        ExcelUtil<USheet> util = new ExcelUtil<USheet>(USheet.class);
        return util.exportExcel(list, "板片数据");
    }

    /**
     * 新增板片
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存板片
     */
    @RequiresPermissions("system:sheet:add")
    @Log(title = "板片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(USheet uSheet)
    {
        return toAjax(uSheetService.insertUSheet(uSheet));
    }

    /**
     * 修改板片
     */
    @RequiresPermissions("system:sheet:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        USheet uSheet = uSheetService.selectUSheetById(id);
        mmap.put("uSheet", uSheet);
        return prefix + "/edit";
    }

    /**
     * 修改保存板片
     */
    @RequiresPermissions("system:sheet:edit")
    @Log(title = "板片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(USheet uSheet)
    {
        return toAjax(uSheetService.updateUSheet(uSheet));
    }

    /**
     * 删除板片
     */
    @RequiresPermissions("system:sheet:remove")
    @Log(title = "板片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uSheetService.deleteUSheetByIds(ids));
    }
}
