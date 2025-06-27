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
import com.ruoyi.system.domain.UArea;
import com.ruoyi.system.service.IUAreaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单板面积Controller
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
@Controller
@RequestMapping("/system/area")
public class UAreaController extends BaseController
{
    private String prefix = "system/area";

    @Autowired
    private IUAreaService uAreaService;

    @RequiresPermissions("system:area:view")
    @GetMapping()
    public String area()
    {
        return prefix + "/area";
    }

    /**
     * 查询单板面积列表
     */
    @RequiresPermissions("system:area:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UArea uArea)
    {
        startPage();
        List<UArea> list = uAreaService.selectUAreaList(uArea);
        return getDataTable(list);
    }

    /**
     * 导出单板面积列表
     */
    @RequiresPermissions("system:area:export")
    @Log(title = "单板面积", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UArea uArea)
    {
        List<UArea> list = uAreaService.selectUAreaList(uArea);
        ExcelUtil<UArea> util = new ExcelUtil<UArea>(UArea.class);
        return util.exportExcel(list, "单板面积数据");
    }

    /**
     * 新增单板面积
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存单板面积
     */
    @RequiresPermissions("system:area:add")
    @Log(title = "单板面积", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UArea uArea)
    {
        return toAjax(uAreaService.insertUArea(uArea));
    }

    /**
     * 修改单板面积
     */
    @RequiresPermissions("system:area:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UArea uArea = uAreaService.selectUAreaById(id);
        mmap.put("uArea", uArea);
        return prefix + "/edit";
    }

    /**
     * 修改保存单板面积
     */
    @RequiresPermissions("system:area:edit")
    @Log(title = "单板面积", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UArea uArea)
    {
        return toAjax(uAreaService.updateUArea(uArea));
    }

    /**
     * 删除单板面积
     */
    @RequiresPermissions("system:area:remove")
    @Log(title = "单板面积", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uAreaService.deleteUAreaByIds(ids));
    }
}
