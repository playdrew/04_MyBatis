package com.ohgiraffers.practice.practice01.view;

import com.ohgiraffers.practice.practice01.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {
    public void selectAllMenu(List<MenuDTO> menuDTOList) {

        for(MenuDTO menuDTO : menuDTOList ){
            System.out.println(menuDTO);
        }

    }

    public void errorMessage(String errorMessage) {

        switch(errorMessage){
            case "selectAllError" :
                System.out.println("전체 조회가 실패하였습니다");
                break;
            case "selectByCode" :
                System.out.println("메뉴 조회가 실패하였습니다");
                break;
            case "insertNewMenu" :
                System.out.println("새로운 메뉴 추가가 실패하였습니다");
                break;
        }
    }

    public void successMessage(String successMessage){
        switch(successMessage){
            case "insertNewMenu" :
                System.out.println("새로운 메뉴가 추가되었습니다.");
                break;
        }
    }

    public void selectByCode(MenuDTO selectByCode) {

        System.out.println(selectByCode);
    }
}
