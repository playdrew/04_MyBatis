package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.service.MenuService;
import com.ohgiraffers.section01.xmlconfig.view.PrintResult;

import java.util.List;
import java.util.Map;

// VIEW 에서 CONTROLLER 호출된 뒤 MODEL(SERVICE)에 넘기는 코드
public class MenuController {

    /*comment.
    *   Controller 의 역할
    *   view 에서 사용자가 입력한 정보를 파라미터 형태로 전달 받으면
    *   전달받은 값들을 검증하거나, 추가적인 정보가 필요하면 가공을 한 뒤
    *   service 쪽으로 전달 하기 위한 인스턴스를 생성하여 담고
    *   service 의 비즈니스 로직을 당담하는 메소드를 호출한다
    *   또한 호출한 수행 결과를 반환받아 어떤 view 를 보여줄지
    *   결정하는 역할을 수행하게 된다.
    * */

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
            //System.out.println("조회 결과가 없습니다.");
            //만약적으로 조회안되었으면 팝업같은 걸로 보여줄꺼에요
            printResult.printErrorMessage("selectList");
        }
    }


    public void selectMenuByCode(Map<String, String> parameter) {

        // 나중에 나올 개념이지만, 나중에 화면에서 입력받은 값을
        // 컨트롤러가 전달 받게 되면 String 타입으로 넘어오게 된다
        // 사용자가 입력한 String 타입의 값을 우리가 설계한 자료형에 맞게 parsing
        int code = Integer.parseInt(parameter.get("menuCode"));
        // 메뉴코드로 검색을 하면 유일한 값 한행만 나올거에요

        MenuDTO menu = menuService.selectMenuByMenuCode(code);

        //메뉴가 null 이 아니다 즉 잘 조회되었다면
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
        
        //스캐너로 입력받은 값을 호출된 메소드로 넘겨줌
        //서로 다른 자료형을 가진 연관 있는 값을 클래스로 뭉쳐서 전달
        //menuDTO 클래스 사용
        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);

        // 아래구문이 잘되면 true 안되면 false
        // if로 담아주었는데 에러 안뜨는 이유는 불리언 타입이기 때문
        if(menuService.insertNewMenu(newMenu)){
            printResult.printSuccessMessage("insert");
        }else{
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

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
