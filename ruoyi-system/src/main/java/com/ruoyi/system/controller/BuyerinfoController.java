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
import com.ruoyi.system.domain.Buyerinfo;
import com.ruoyi.system.service.IBuyerinfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 购买方档案Controller
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
@Controller
@RequestMapping("/system/buyerinfo")
public class BuyerinfoController extends BaseController
{
    private String prefix = "system/buyerinfo";

    @Autowired
    private IBuyerinfoService buyerinfoService;

    @RequiresPermissions("system:buyerinfo:view")
    @GetMapping()
    public String buyerinfo()
    {
        return prefix + "/buyerinfo";
    }

    /**
     * 查询购买方档案列表
     */
    @RequiresPermissions("system:buyerinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Buyerinfo buyerinfo)
    {
        startPage();
        List<Buyerinfo> list = buyerinfoService.selectBuyerinfoList(buyerinfo);
        return getDataTable(list);
    }

    /**
     * 导出购买方档案列表
     */
    @RequiresPermissions("system:buyerinfo:export")
    @Log(title = "购买方档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Buyerinfo buyerinfo)
    {
        List<Buyerinfo> list = buyerinfoService.selectBuyerinfoList(buyerinfo);
        ExcelUtil<Buyerinfo> util = new ExcelUtil<Buyerinfo>(Buyerinfo.class);
        return util.exportExcel(list, "购买方档案数据");
    }

    /**
     * 新增购买方档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存购买方档案
     */
    @RequiresPermissions("system:buyerinfo:add")
    @Log(title = "购买方档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Buyerinfo buyerinfo)
    {
        return toAjax(buyerinfoService.insertBuyerinfo(buyerinfo));
    }

    /**
     * 修改购买方档案
     */
    @RequiresPermissions("system:buyerinfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Buyerinfo buyerinfo = buyerinfoService.selectBuyerinfoById(id);
        mmap.put("buyerinfo", buyerinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存购买方档案
     */
    @RequiresPermissions("system:buyerinfo:edit")
    @Log(title = "购买方档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Buyerinfo buyerinfo)
    {
        return toAjax(buyerinfoService.updateBuyerinfo(buyerinfo));
    }

    /**
     * 删除购买方档案
     */
    @RequiresPermissions("system:buyerinfo:remove")
    @Log(title = "购买方档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(buyerinfoService.deleteBuyerinfoByIds(ids));
    }
}
