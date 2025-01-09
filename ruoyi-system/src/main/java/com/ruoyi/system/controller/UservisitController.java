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
import com.ruoyi.system.domain.Uservisit;
import com.ruoyi.system.service.IUservisitService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户访问记录，展现末尾记录Controller
 * 
 * @author pengweitao
 * @date 2025-01-09
 */
@Controller
@RequestMapping("/system/uservisit")
public class UservisitController extends BaseController
{
    private String prefix = "system/uservisit";

    @Autowired
    private IUservisitService uservisitService;

    @RequiresPermissions("system:uservisit:view")
    @GetMapping()
    public String uservisit()
    {
        return prefix + "/uservisit";
    }

    /**
     * 查询用户访问记录，展现末尾记录列表
     */
    @RequiresPermissions("system:uservisit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Uservisit uservisit)
    {
        startPage();
        List<Uservisit> list = uservisitService.selectUservisitList(uservisit);
        return getDataTable(list);
    }

    /**
     * 导出用户访问记录，展现末尾记录列表
     */
    @RequiresPermissions("system:uservisit:export")
    @Log(title = "用户访问记录，展现末尾记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Uservisit uservisit)
    {
        List<Uservisit> list = uservisitService.selectUservisitList(uservisit);
        ExcelUtil<Uservisit> util = new ExcelUtil<Uservisit>(Uservisit.class);
        return util.exportExcel(list, "用户访问记录，展现末尾记录数据");
    }

    /**
     * 新增用户访问记录，展现末尾记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户访问记录，展现末尾记录
     */
    @RequiresPermissions("system:uservisit:add")
    @Log(title = "用户访问记录，展现末尾记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Uservisit uservisit)
    {
        return toAjax(uservisitService.insertUservisit(uservisit));
    }

    /**
     * 修改用户访问记录，展现末尾记录
     */
    @RequiresPermissions("system:uservisit:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Uservisit uservisit = uservisitService.selectUservisitById(id);
        mmap.put("uservisit", uservisit);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户访问记录，展现末尾记录
     */
    @RequiresPermissions("system:uservisit:edit")
    @Log(title = "用户访问记录，展现末尾记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Uservisit uservisit)
    {
        return toAjax(uservisitService.updateUservisit(uservisit));
    }

    /**
     * 删除用户访问记录，展现末尾记录
     */
    @RequiresPermissions("system:uservisit:remove")
    @Log(title = "用户访问记录，展现末尾记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uservisitService.deleteUservisitByIds(ids));
    }
}
