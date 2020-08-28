package com.wm.service;

import com.wm.mapper.TypeMapper;
import com.wm.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    List<Type> listType(Integer pageNum, Integer pageSize);
    Integer addType(Type type);
    Type findById(Long id);
    Integer editById(Type type);
    Integer deleteById(Long id);
    List<Type> findAllTypes();

}
