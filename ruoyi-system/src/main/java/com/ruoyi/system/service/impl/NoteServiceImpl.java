package com.ruoyi.system.service.impl;

import java.util.Collections;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.NoteMapper;
import com.ruoyi.system.domain.Note;
import com.ruoyi.system.service.INoteService;
import com.ruoyi.common.core.text.Convert;

/**
 * 便签记录发展过程Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
@Service
public class NoteServiceImpl implements INoteService 
{
    @Autowired
    private NoteMapper noteMapper;

    /**
     * 查询便签记录发展过程
     * 
     * @param id 便签记录发展过程主键
     * @return 便签记录发展过程
     */
    @Override
    public Note selectNoteById(Long id)
    {
        return noteMapper.selectNoteById(id);
    }

    /**
     * 查询便签记录发展过程列表
     * 
     * @param note 便签记录发展过程
     * @return 便签记录发展过程
     */
    @Override
    public List<Note> selectNoteList(Note note)
    {
        return noteMapper.selectNoteList(note);
    }

    @Override
    public List<Note> selectNoteByafterSalesID(Long afterSalesID) {
        //return Collections.emptyList();
        List<Note> notes = noteMapper.selectNoteByafterSalesID(afterSalesID);
        return notes;
    }

    /**
     * 新增便签记录发展过程
     * 
     * @param note 便签记录发展过程
     * @return 结果
     */
    @Override
    public int insertNote(Note note)
    {
        note.setCreateTime(DateUtils.getNowDate());
        return noteMapper.insertNote(note);
    }

    /**
     * 修改便签记录发展过程
     * 
     * @param note 便签记录发展过程
     * @return 结果
     */
    @Override
    public int updateNote(Note note)
    {
        return noteMapper.updateNote(note);
    }

    /**
     * 批量删除便签记录发展过程
     * 
     * @param ids 需要删除的便签记录发展过程主键
     * @return 结果
     */
    @Override
    public int deleteNoteByIds(String ids)
    {
        return noteMapper.deleteNoteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除便签记录发展过程信息
     * 
     * @param id 便签记录发展过程主键
     * @return 结果
     */
    @Override
    public int deleteNoteById(Long id)
    {
        return noteMapper.deleteNoteById(id);
    }
}
