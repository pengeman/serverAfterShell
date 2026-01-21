package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Note;

/**
 * 便签记录发展过程Service接口
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public interface INoteService 
{
    /**
     * 查询便签记录发展过程
     * 
     * @param id 便签记录发展过程主键
     * @return 便签记录发展过程
     */
    public Note selectNoteById(Long id);

    /**
     * 查询便签记录发展过程列表
     * 
     * @param note 便签记录发展过程
     * @return 便签记录发展过程集合
     */
    public List<Note> selectNoteList(Note note);

    /**
     * 查询，根据派工单id
     */
    public List<Note> selectNoteByafterSalesID(Long afterSalesID);

    /**
     * 新增便签记录发展过程
     * 
     * @param note 便签记录发展过程
     * @return 结果
     */
    public int insertNote(Note note);

    /**
     * 修改便签记录发展过程
     * 
     * @param note 便签记录发展过程
     * @return 结果
     */
    public int updateNote(Note note);

    /**
     * 批量删除便签记录发展过程
     * 
     * @param ids 需要删除的便签记录发展过程主键集合
     * @return 结果
     */
    public int deleteNoteByIds(String ids);

    /**
     * 删除便签记录发展过程信息
     * 
     * @param id 便签记录发展过程主键
     * @return 结果
     */
    public int deleteNoteById(Long id);
}
