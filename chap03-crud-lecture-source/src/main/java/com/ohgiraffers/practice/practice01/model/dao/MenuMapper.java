package com.ohgiraffers.practice.practice01.model.dao;

import com.ohgiraffers.practice.practice01.model.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> selectAllMenu();

    MenuDTO selectByMenuCode(MenuDTO code);

    int insertNewMenu(MenuDTO insertMenuList);
}
