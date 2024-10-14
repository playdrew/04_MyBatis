package com.practice.model.service;


import com.practice.model.dao.DynamicSqlMapper;
import com.practice.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.practice.common.Template.getSqlSession;


public class MenuService {


    private DynamicSqlMapper dynamicSqlMapper;

    public List<MenuDTO> selectMenuByMenuPrice(int price) {

        SqlSession sqlSession = getSqlSession();

        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String,Integer> map = new HashMap<>();
        map.put("price",price);

        List<MenuDTO> menuDTOList = dynamicSqlMapper.selectByPrice(map);

        sqlSession.close();

        return menuDTOList;
    }
}