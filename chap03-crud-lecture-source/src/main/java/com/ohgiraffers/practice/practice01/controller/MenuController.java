package com.ohgiraffers.practice.practice01.controller;

import com.ohgiraffers.practice.practice01.model.dto.MenuDTO;
import com.ohgiraffers.practice.practice01.model.service.MenuService;
import com.ohgiraffers.practice.practice01.view.PrintResult;

import java.util.List;
import java.util.Map;

public class MenuController {

    private MenuService menuService;
    private PrintResult printResult;

    public MenuController(){
        this.menuService=new MenuService();
        this.printResult=new PrintResult();
    }
    public void selectAllMenu() {
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null){
            printResult.selectAllMenu(menuList);
        }else{
            printResult.errorMessage("selectAllError");
        }

    }

    public void selectByMenuCode(Map<String,String> parameter) {

        // 맵형식으로 어플리케이션으로 키값과 값을 보냈는데 묶어서 보낸게 parameter 안에 있는데
        // 보냈으니까 같은 형태로 받아야 하므로 map이라는 자료형에 파라미터로 받아준거고
        // 데이터베이스 타입이 int 형이라서 int 타입으로 만들고 맵형태의 코드를
        // 데이터베이스에 담아주기 위한 형태로 담아준다.
        int code = Integer.parseInt(parameter.get("code"));

        // 서비스 쪽에 넘길 것이면 객체형태로 만들어서 보내주어야 하기 때문에 이 코드다 필요하다.
        MenuDTO selectMenuByCode = new MenuDTO();
        selectMenuByCode.setMenuCode(code);

        // 서비스쪽에 메소드 구현
        MenuDTO selectByCode = menuService.selectMenuByCode(selectMenuByCode);

        if(selectByCode != null){
            printResult.selectByCode(selectByCode);
        }else{
            printResult.errorMessage("selectByCode");
        }

    }

    public void insertNewMenu(Map<String, String> parameter) {

        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO insertMenuList = new MenuDTO();
        insertMenuList.setMenuName(menuName);
        insertMenuList.setMenuPrice(menuPrice);
        insertMenuList.setCategoryCode(categoryCode);

        if(menuService.insertNewMenu(insertMenuList)){
            printResult.successMessage("insertNewMenu");
        }else{
            printResult.errorMessage("insertNewMenu");
        }


    }
}
