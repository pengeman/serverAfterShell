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
import com.ruoyi.system.domain.Parrot;
import com.ruoyi.system.service.IParrotService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 鹦鹉财务Controller
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
@Controller
@RequestMapping("/system/parrot")
public class ParrotController extends BaseController
{
    private String prefix = "system/parrot";

    @Autowired
    private IParrotService parrotService;

    @RequiresPermissions("system:parrot:view")
    @GetMapping()
    public String parrot()
    {
        return prefix + "/parrot";
    }

    /**
     * 查询鹦鹉财务列表
     */
    @RequiresPermissions("system:parrot:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Parrot parrot)
    {
        startPage();
        List<Parrot> list = parrotService.selectParrotList(parrot);
        return getDataTable(list);
    }

    /**
     * 导出鹦鹉财务列表
     */
    @RequiresPermissions("system:parrot:export")
    @Log(title = "鹦鹉财务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Parrot parrot)
    {
        List<Parrot> list = parrotService.selectParrotList(parrot);
        ExcelUtil<Parrot> util = new ExcelUtil<Parrot>(Parrot.class);
        return util.exportExcel(list, "鹦鹉财务数据");
    }

    /**
     * 新增鹦鹉财务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存鹦鹉财务
     */
    @RequiresPermissions("system:parrot:add")
    @Log(title = "鹦鹉财务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Parrot parrot)
    {
        return toAjax(parrotService.insertParrot(parrot));
    }

    /**
     * 修改鹦鹉财务
     */
    @RequiresPermissions("system:parrot:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Parrot parrot = parrotService.selectParrotById(id);
        mmap.put("parrot", parrot);
        return prefix + "/edit";
    }

    /**
     * 修改保存鹦鹉财务
     */
    @RequiresPermissions("system:parrot:edit")
    @Log(title = "鹦鹉财务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Parrot parrot)
    {
        return toAjax(parrotService.updateParrot(parrot));
    }

    /**
     * 删除鹦鹉财务
     */
    @RequiresPermissions("system:parrot:remove")
    @Log(title = "鹦鹉财务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(parrotService.deleteParrotByIds(ids));
    }
}
