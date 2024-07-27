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
import com.ruoyi.system.domain.AftersalesBack;
import com.ruoyi.system.service.IAftersalesBackService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 售后派工单备份Controller
 * 
 * @author peng
 * @date 2024-07-27
 */
@Controller
@RequestMapping("/system/afterSalesBack")
public class AftersalesBackController extends BaseController
{
    private String prefix = "system/afterSalesBack";

    @Autowired
    private IAftersalesBackService aftersalesBackService;

    @RequiresPermissions("system:afterSalesBack:view")
    @GetMapping()
    public String afterSalesBack()
    {
        return prefix + "/afterSalesBack";
    }

    /**
     * 查询售后派工单备份列表
     */
    @RequiresPermissions("system:afterSalesBack:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AftersalesBack aftersalesBack)
    {
        startPage();
        List<AftersalesBack> list = aftersalesBackService.selectAftersalesBackList(aftersalesBack);
        return getDataTable(list);
    }

    /**
     * 导出售后派工单备份列表
     */
    @RequiresPermissions("system:afterSalesBack:export")
    @Log(title = "售后派工单备份", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AftersalesBack aftersalesBack)
    {
        List<AftersalesBack> list = aftersalesBackService.selectAftersalesBackList(aftersalesBack);
        ExcelUtil<AftersalesBack> util = new ExcelUtil<AftersalesBack>(AftersalesBack.class);
        return util.exportExcel(list, "售后派工单备份数据");
    }

    /**
     * 新增售后派工单备份
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存售后派工单备份
     */
    @RequiresPermissions("system:afterSalesBack:add")
    @Log(title = "售后派工单备份", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AftersalesBack aftersalesBack)
    {
        return toAjax(aftersalesBackService.insertAftersalesBack(aftersalesBack));
    }

    /**
     * 修改售后派工单备份
     */
    @RequiresPermissions("system:afterSalesBack:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AftersalesBack aftersalesBack = aftersalesBackService.selectAftersalesBackById(id);
        mmap.put("aftersalesBack", aftersalesBack);
        return prefix + "/edit";
    }

    /**
     * 修改保存售后派工单备份
     */
    @RequiresPermissions("system:afterSalesBack:edit")
    @Log(title = "售后派工单备份", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AftersalesBack aftersalesBack)
    {
        return toAjax(aftersalesBackService.updateAftersalesBack(aftersalesBack));
    }

    /**
     * 删除售后派工单备份
     */
    @RequiresPermissions("system:afterSalesBack:remove")
    @Log(title = "售后派工单备份", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aftersalesBackService.deleteAftersalesBackByIds(ids));
    }
}
