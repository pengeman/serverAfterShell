package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.USheet;
import com.ruoyi.system.service.IUSheetService;
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
import com.ruoyi.system.domain.UFlange2;
import com.ruoyi.system.service.IUFlange2Service;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 法兰-JB/T81-94国标Controller
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Controller
@RequestMapping("/system/flange2")
public class UFlange2Controller extends BaseController
{
    private String prefix = "system/flange2";

    @Autowired
    private IUFlange2Service uFlange2Service;
    @Autowired
    private IUSheetService uSheetService;

    @RequiresPermissions("system:flange2:view")
    @GetMapping()
    public String flange2()
    {
        return prefix + "/flange2";
    }

    /**
     * 查询法兰-JB/T81-94国标列表
     */
    @RequiresPermissions("system:flange2:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UFlange2 uFlange2)
    {
        startPage();
        List<UFlange2> list = uFlange2Service.selectUFlange2List(uFlange2);
        return getDataTable(list);
    }

    /**
     * 导出法兰-JB/T81-94国标列表
     */
    @RequiresPermissions("system:flange2:export")
    @Log(title = "法兰-JB/T81-94国标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UFlange2 uFlange2)
    {
        List<UFlange2> list = uFlange2Service.selectUFlange2List(uFlange2);
        ExcelUtil<UFlange2> util = new ExcelUtil<UFlange2>(UFlange2.class);
        return util.exportExcel(list, "法兰-JB/T81-94国标数据");
    }

    /**
     * 新增法兰-JB/T81-94国标
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存法兰-JB/T81-94国标
     */
    @RequiresPermissions("system:flange2:add")
    @Log(title = "法兰-JB/T81-94国标", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UFlange2 uFlange2)
    {
        return toAjax(uFlange2Service.insertUFlange2(uFlange2));
    }

    /**
     * 修改法兰-JB/T81-94国标
     */
    @RequiresPermissions("system:flange2:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UFlange2 uFlange2 = uFlange2Service.selectUFlange2ById(id);
        mmap.put("uFlange2", uFlange2);
        return prefix + "/edit";
    }

    /**
     * 修改保存法兰-JB/T81-94国标
     */
    @RequiresPermissions("system:flange2:edit")
    @Log(title = "法兰-JB/T81-94国标", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UFlange2 uFlange2)
    {
        return toAjax(uFlange2Service.updateUFlange2(uFlange2));
    }

    /**
     * 删除法兰-JB/T81-94国标
     */
    @RequiresPermissions("system:flange2:remove")
    @Log(title = "法兰-JB/T81-94国标", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uFlange2Service.deleteUFlange2ByIds(ids));
    }

    /**
     * 获得板型型号
     */
    @RequiresPermissions("system:flange2:remove")
    @Log(title = "法兰-JB/T81-94国标,获得板型型号")
    @PostMapping( "/getSheetType")
    @ResponseBody
    public AjaxResult getSheetType(String ids)
    {
        AjaxResult ajax = new AjaxResult();
        USheet uSheet = new USheet();
        List<USheet> uSheets = this.uSheetService.selectUSheetList(uSheet);
        for (int i = 0 ; i < uSheets.size() ; i ++){
            long id = uSheets.get(i).getId();
            String type = uSheets.get(i).getType();
            ajax.put("id",id);
            ajax.put("type",type);
        }
        return ajax;
    }

}
