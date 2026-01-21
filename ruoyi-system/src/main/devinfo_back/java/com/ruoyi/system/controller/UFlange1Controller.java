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
import com.ruoyi.system.domain.UFlange1;
import com.ruoyi.system.service.IUFlange1Service;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 法兰-HG/T20592-09化工Controller
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
@Controller
@RequestMapping("/system/flange1")
public class UFlange1Controller extends BaseController
{
    private String prefix = "system/flange1";

    @Autowired
    private IUFlange1Service uFlange1Service;

    @RequiresPermissions("system:flange1:view")
    @GetMapping()
    public String flange1()
    {
        return prefix + "/flange1";
    }

    /**
     * 查询法兰-HG/T20592-09化工列表
     */
    @RequiresPermissions("system:flange1:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UFlange1 uFlange1)
    {
        startPage();
        List<UFlange1> list = uFlange1Service.selectUFlange1List(uFlange1);
        return getDataTable(list);
    }

    /**
     * 导出法兰-HG/T20592-09化工列表
     */
    @RequiresPermissions("system:flange1:export")
    @Log(title = "法兰-HG/T20592-09化工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UFlange1 uFlange1)
    {
        List<UFlange1> list = uFlange1Service.selectUFlange1List(uFlange1);
        ExcelUtil<UFlange1> util = new ExcelUtil<UFlange1>(UFlange1.class);
        return util.exportExcel(list, "法兰-HG/T20592-09化工数据");
    }

    /**
     * 新增法兰-HG/T20592-09化工
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存法兰-HG/T20592-09化工
     */
    @RequiresPermissions("system:flange1:add")
    @Log(title = "法兰-HG/T20592-09化工", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UFlange1 uFlange1)
    {
        return toAjax(uFlange1Service.insertUFlange1(uFlange1));
    }

    /**
     * 修改法兰-HG/T20592-09化工
     */
    @RequiresPermissions("system:flange1:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UFlange1 uFlange1 = uFlange1Service.selectUFlange1ById(id);
        mmap.put("uFlange1", uFlange1);
        return prefix + "/edit";
    }

    /**
     * 修改保存法兰-HG/T20592-09化工
     */
    @RequiresPermissions("system:flange1:edit")
    @Log(title = "法兰-HG/T20592-09化工", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UFlange1 uFlange1)
    {
        return toAjax(uFlange1Service.updateUFlange1(uFlange1));
    }

    /**
     * 删除法兰-HG/T20592-09化工
     */
    @RequiresPermissions("system:flange1:remove")
    @Log(title = "法兰-HG/T20592-09化工", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uFlange1Service.deleteUFlange1ByIds(ids));
    }
}
