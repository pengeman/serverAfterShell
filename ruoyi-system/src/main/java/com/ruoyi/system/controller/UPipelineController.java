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
import com.ruoyi.system.domain.UPipeline;
import com.ruoyi.system.service.IUPipelineService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 接管类型Controller
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Controller
@RequestMapping("/system/pipeline")
public class UPipelineController extends BaseController
{
    private String prefix = "system/pipeline";

    @Autowired
    private IUPipelineService uPipelineService;

    @RequiresPermissions("system:pipeline:view")
    @GetMapping()
    public String pipeline()
    {
        return prefix + "/pipeline";
    }

    /**
     * 查询接管类型列表
     */
    @RequiresPermissions("system:pipeline:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UPipeline uPipeline)
    {
        startPage();
        List<UPipeline> list = uPipelineService.selectUPipelineList(uPipeline);
        return getDataTable(list);
    }

    /**
     * 导出接管类型列表
     */
    @RequiresPermissions("system:pipeline:export")
    @Log(title = "接管类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UPipeline uPipeline)
    {
        List<UPipeline> list = uPipelineService.selectUPipelineList(uPipeline);
        ExcelUtil<UPipeline> util = new ExcelUtil<UPipeline>(UPipeline.class);
        return util.exportExcel(list, "接管类型数据");
    }

    /**
     * 新增接管类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存接管类型
     */
    @RequiresPermissions("system:pipeline:add")
    @Log(title = "接管类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UPipeline uPipeline)
    {
        return toAjax(uPipelineService.insertUPipeline(uPipeline));
    }

    /**
     * 修改接管类型
     */
    @RequiresPermissions("system:pipeline:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UPipeline uPipeline = uPipelineService.selectUPipelineById(id);
        mmap.put("uPipeline", uPipeline);
        return prefix + "/edit";
    }

    /**
     * 修改保存接管类型
     */
    @RequiresPermissions("system:pipeline:edit")
    @Log(title = "接管类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UPipeline uPipeline)
    {
        return toAjax(uPipelineService.updateUPipeline(uPipeline));
    }

    /**
     * 删除接管类型
     */
    @RequiresPermissions("system:pipeline:remove")
    @Log(title = "接管类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uPipelineService.deleteUPipelineByIds(ids));
    }
}
