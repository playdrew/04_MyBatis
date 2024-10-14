package com.practice.controller;

import com.practice.model.dto.MenuDTO;
import com.practice.model.service.MenuService;
import com.practice.view.PrintResult;

import java.util.List;

public class MenuController {

    private MenuService menuService;
    private PrintResult printResult;

    public MenuController(){
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void selectMenuByMenuPrice(int price) {

        List<MenuDTO> selectMenuByMenuPrice = menuService.selectMenuByMenuPrice(price);

        if(selectMenuByMenuPrice != null && selectMenuByMenuPrice.size()>0){
            printResult.selectByMenuPrice(selectMenuByMenuPrice);
        }else{
            printResult.errorMessage("selectByPrice");
        }

    }
}
