package com.ohgiraffers.section03.remix.controller;

import com.ohgiraffers.section03.remix.model.dto.MenuDTO;
import com.ohgiraffers.section03.remix.model.service.MenuService;
import com.ohgiraffers.section03.remix.view.PrintResult;

import java.util.List;
import java.util.Map;

public class MenuController {


    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController(){
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void selectAllMenu() {
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null){
            printResult.printMenuList(menuList);
        }else{
            printResult.printErrorMessage("selectList");
        }
    }


    public void selectMenuByCode(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.selectMenuByMenuCode(code);

        if(menu != null){
            printResult.printMenu(menu);
        }else{
            printResult.printErrorMessage("selectOne");
        }

    }

    public void insertNewMenu(Map<String, String> parameter) {

        String menuName = parameter.get("name");
        int menuPrice = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("category"));

        // 데이터베이스 접근할때는 무조건 객체로 접근해야한다.
        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);

        if(menuService.insertNewMenu(newMenu)){
            printResult.printSuccessMessage("insert");
        }else{
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {

        //String 타입으로 사용자들이 입력하므로 int 형으로 파싱해준다.
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        //위의 변수들을 하나로 묶어주기 위한 객체를 선언한다
        MenuDTO modifyMenu = new MenuDTO();

        modifyMenu.setMenuName(name);
        modifyMenu.setMenuPrice(price);
        modifyMenu.setMenuCode(code);
        modifyMenu.setCategoryCode(categoryCode);

        menuService.modifyMenu(modifyMenu);

        if(menuService.modifyMenu(modifyMenu)){
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }

    }


    public void deleteMenu(Map<String, String> stringStringMap) {

        int code = Integer.parseInt(stringStringMap.get("code"));

        MenuDTO deleteMenu = new MenuDTO();

        deleteMenu.setMenuCode(code);

        if(menuService.deleteMenu(deleteMenu)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("delete");
        }
    }
}
