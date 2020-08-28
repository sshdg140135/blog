package com.wm.service;

import com.github.pagehelper.PageHelper;
import com.wm.mapper.TagMapper;
import com.wm.po.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> listTag(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> allTag = tagMapper.findAllTag();
        return allTag;
    }

    @Override
    public Integer addTag(Tag tag) {
        return tagMapper.insertTag(tag);
    }

    @Override
    public Tag findById(Long id) {
        return tagMapper.findById(id);
    }

    @Override
    public Integer editById(Tag tag) {
        return tagMapper.updateById(tag);
    }

    @Override
    public Integer deleteById(Long id) {
        return tagMapper.deleteById(id);
    }

    @Override
    public List<Tag> findAllTags() {

        return tagMapper.findAllTag();
    }
}
