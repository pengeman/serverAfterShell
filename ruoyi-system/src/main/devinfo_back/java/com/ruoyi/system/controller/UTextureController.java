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
import com.ruoyi.system.domain.UTexture;
import com.ruoyi.system.service.IUTextureService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 材质Controller
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Controller
@RequestMapping("/system/texture")
public class UTextureController extends BaseController
{
    private String prefix = "system/texture";

    @Autowired
    private IUTextureService uTextureService;

    @RequiresPermissions("system:texture:view")
    @GetMapping()
    public String texture()
    {
        return prefix + "/texture";
    }

    /**
     * 查询材质列表
     */
    @RequiresPermissions("system:texture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UTexture uTexture)
    {
        startPage();
        List<UTexture> list = uTextureService.selectUTextureList(uTexture);
        return getDataTable(list);
    }

    /**
     * 导出材质列表
     */
    @RequiresPermissions("system:texture:export")
    @Log(title = "材质", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UTexture uTexture)
    {
        List<UTexture> list = uTextureService.selectUTextureList(uTexture);
        ExcelUtil<UTexture> util = new ExcelUtil<UTexture>(UTexture.class);
        return util.exportExcel(list, "材质数据");
    }

    /**
     * 新增材质
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材质
     */
    @RequiresPermissions("system:texture:add")
    @Log(title = "材质", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UTexture uTexture)
    {
        return toAjax(uTextureService.insertUTexture(uTexture));
    }

    /**
     * 修改材质
     */
    @RequiresPermissions("system:texture:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UTexture uTexture = uTextureService.selectUTextureById(id);
        mmap.put("uTexture", uTexture);
        return prefix + "/edit";
    }

    /**
     * 修改保存材质
     */
    @RequiresPermissions("system:texture:edit")
    @Log(title = "材质", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UTexture uTexture)
    {
        return toAjax(uTextureService.updateUTexture(uTexture));
    }

    /**
     * 删除材质
     */
    @RequiresPermissions("system:texture:remove")
    @Log(title = "材质", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uTextureService.deleteUTextureByIds(ids));
    }
}
