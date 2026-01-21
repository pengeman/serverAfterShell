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
import com.ruoyi.system.domain.Plate;
import com.ruoyi.system.service.IPlateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 板片信息Controller
 * 
 * @author pengweitao
 * @date 2025-12-16
 */
@Controller
@RequestMapping("/system/plate")
public class PlateController extends BaseController
{
    private String prefix = "system/plate";

    @Autowired
    private IPlateService plateService;

    @RequiresPermissions("system:plate:view")
    @GetMapping()
    public String plate()
    {
        return prefix + "/plate";
    }

    /**
     * 查询板片信息列表
     */
    @RequiresPermissions("system:plate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Plate plate)
    {
        startPage();
        List<Plate> list = plateService.selectPlateList(plate);
        return getDataTable(list);
    }

    /**
     * 导出板片信息列表
     */
    @RequiresPermissions("system:plate:export")
    @Log(title = "板片信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Plate plate)
    {
        List<Plate> list = plateService.selectPlateList(plate);
        ExcelUtil<Plate> util = new ExcelUtil<Plate>(Plate.class);
        return util.exportExcel(list, "板片信息数据");
    }

    /**
     * 新增板片信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存板片信息
     */
    @RequiresPermissions("system:plate:add")
    @Log(title = "板片信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Plate plate)
    {
        return toAjax(plateService.insertPlate(plate));
    }

    /**
     * 修改板片信息
     */
    @RequiresPermissions("system:plate:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Plate plate = plateService.selectPlateById(id);
        mmap.put("plate", plate);
        return prefix + "/edit";
    }

    /**
     * 修改保存板片信息
     */
    @RequiresPermissions("system:plate:edit")
    @Log(title = "板片信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Plate plate)
    {
        return toAjax(plateService.updatePlate(plate));
    }

    /**
     * 删除板片信息
     */
    @RequiresPermissions("system:plate:remove")
    @Log(title = "板片信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(plateService.deletePlateByIds(ids));
    }
}
