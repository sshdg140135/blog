package com.wm.service;

import com.github.pagehelper.PageHelper;
import com.wm.mapper.TypeMapper;
import com.wm.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;
    @Override
    public List<Type> listType(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Type> allType = typeMapper.findAllType();
        return allType;
    }

    @Override
    public Integer addType(Type type) {
        Integer integer = typeMapper.insertType(type);
        return integer;
    }

    @Override
    public Type findById(Long id) {
        Type type = typeMapper.findById(id);
        return type;
    }

    @Override
    public Integer editById(Type type) {
        Integer i = typeMapper.updateById(type);
        return i;
    }

    @Override
    public Integer deleteById(Long id) {
        Integer i = typeMapper.deleteById(id);
        return i;
    }

    @Override
    public List<Type> findAllTypes() {
        return typeMapper.findAllType();
    }


}
