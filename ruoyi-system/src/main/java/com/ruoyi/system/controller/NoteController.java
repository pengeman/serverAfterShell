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
import com.ruoyi.system.domain.Note;
import com.ruoyi.system.service.INoteService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 便签记录发展过程Controller
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
@Controller
@RequestMapping("/system/note")
public class NoteController extends BaseController
{
    private String prefix = "system/note";

    @Autowired
    private INoteService noteService;

    @RequiresPermissions("system:note:view")
    @GetMapping()
    public String note()
    {
        return prefix + "/note";
    }

    /**
     * 查询便签记录发展过程列表
     */
    @RequiresPermissions("system:note:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Note note)
    {
        startPage();
        List<Note> list = noteService.selectNoteList(note);
        return getDataTable(list);
    }

    /**
     * 导出便签记录发展过程列表
     */
    @RequiresPermissions("system:note:export")
    @Log(title = "便签记录发展过程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Note note)
    {
        List<Note> list = noteService.selectNoteList(note);
        ExcelUtil<Note> util = new ExcelUtil<Note>(Note.class);
        return util.exportExcel(list, "便签记录发展过程数据");
    }

    /**
     * 新增便签记录发展过程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存便签记录发展过程
     */
    @RequiresPermissions("system:note:add")
    @Log(title = "便签记录发展过程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Note note)
    {

        return toAjax(noteService.insertNote(note));
    }

    @RequiresPermissions("system:note:edit")
    @GetMapping("/gonote/{id}")
    public ModelAndView gonote(@PathVariable("id") Long id ){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName(prefix+"/add");
        return mv;
    }

    @RequiresPermissions("system:note:edit")
    @GetMapping("/shownote/{id}")
    public ModelAndView shownote(@PathVariable("id") Long id ){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        List<Note> notes = noteService.selectNoteByafterSalesID(id);

        mv.addObject("notes", notes);
        mv.setViewName(prefix+"/view");

        return mv;
    }


    /**
     * 修改便签记录发展过程
     */
    @RequiresPermissions("system:note:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Note note = noteService.selectNoteById(id);
        mmap.put("note", note);
        return prefix + "/edit";
    }

    /**
     * 修改保存便签记录发展过程
     */
    @RequiresPermissions("system:note:edit")
    @Log(title = "便签记录发展过程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Note note)
    {
        return toAjax(noteService.updateNote(note));
    }

    /**
     * 删除便签记录发展过程
     */
    @RequiresPermissions("system:note:remove")
    @Log(title = "便签记录发展过程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(noteService.deleteNoteByIds(ids));
    }
}
