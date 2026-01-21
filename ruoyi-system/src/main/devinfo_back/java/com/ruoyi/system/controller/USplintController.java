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
import com.ruoyi.system.domain.USplint;
import com.ruoyi.system.service.IUSplintService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 夹板Controller
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Controller
@RequestMapping("/system/splint")
public class USplintController extends BaseController
{
    private String prefix = "system/splint";

    @Autowired
    private IUSplintService uSplintService;

    @RequiresPermissions("system:splint:view")
    @GetMapping()
    public String splint()
    {
        return prefix + "/splint";
    }

    /**
     * 查询夹板列表
     */
    @RequiresPermissions("system:splint:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(USplint uSplint)
    {
        startPage();
        List<USplint> list = uSplintService.selectUSplintList(uSplint);
        return getDataTable(list);
    }

    /**
     * 导出夹板列表
     */
    @RequiresPermissions("system:splint:export")
    @Log(title = "夹板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(USplint uSplint)
    {
        List<USplint> list = uSplintService.selectUSplintList(uSplint);
        ExcelUtil<USplint> util = new ExcelUtil<USplint>(USplint.class);
        return util.exportExcel(list, "夹板数据");
    }

    /**
     * 新增夹板
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存夹板
     */
    @RequiresPermissions("system:splint:add")
    @Log(title = "夹板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(USplint uSplint)
    {
        return toAjax(uSplintService.insertUSplint(uSplint));
    }

    /**
     * 修改夹板
     */
    @RequiresPermissions("system:splint:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        USplint uSplint = uSplintService.selectUSplintById(id);
        mmap.put("uSplint", uSplint);
        return prefix + "/edit";
    }

    /**
     * 修改保存夹板
     */
    @RequiresPermissions("system:splint:edit")
    @Log(title = "夹板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(USplint uSplint)
    {
        return toAjax(uSplintService.updateUSplint(uSplint));
    }

    /**
     * 删除夹板
     */
    @RequiresPermissions("system:splint:remove")
    @Log(title = "夹板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uSplintService.deleteUSplintByIds(ids));
    }
}
