package com.practice.model.dao;

import com.practice.model.dto.MenuDTO;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    List<MenuDTO> selectByPrice(Map<String, Integer> map);
}
