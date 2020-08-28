package com.wm.service;

import com.wm.po.Tag;

import java.util.List;

public interface TagService {

    List<Tag> listTag(Integer pageNum, Integer pageSize);
    Integer addTag(Tag tag);
    Tag findById(Long id);
    Integer editById(Tag tag);
    Integer deleteById(Long id);
    List<Tag> findAllTags();
}
