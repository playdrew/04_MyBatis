package com.ohgiraffers.practice.practice01.model.service;

import com.ohgiraffers.practice.practice01.model.dao.MenuMapper;
import com.ohgiraffers.practice.practice01.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.practice.practice01.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;

    }

    public MenuDTO selectMenuByCode(MenuDTO code) {

        SqlSession sqlsession = getSqlSession();

        menuMapper = sqlsession.getMapper(MenuMapper.class);

        MenuDTO menuList = menuMapper.selectByMenuCode(code);

        return menuList;
    }


    public boolean insertNewMenu(MenuDTO insertMenuList) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertNewMenu(insertMenuList);

        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        return result>0 ? true : false;
    }
}
