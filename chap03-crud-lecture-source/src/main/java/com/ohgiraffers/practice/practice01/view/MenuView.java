package com.ohgiraffers.practice.practice01.view;

import com.ohgiraffers.practice.practice01.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuView {

    public void display(){

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do{

            System.out.println("===========HiMedia 메뉴 관리 시스템============");
            System.out.println("1.메뉴 전체 조회하기");
            System.out.println("2.메뉴 코드로 메뉴 조회하기");
            System.out.println("3.신규 메뉴 등록하기");
            System.out.println("4.메뉴 수정하기");
            System.out.println("5.메뉴 삭제하기");
            System.out.println("=============================================");
            System.out.print("실행할 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch(no){
                case 1 :
                    menuController.selectAllMenu();
                    break;
                case 2 :
                    menuController.selectByMenuCode(inputCode());
                    break;
                case 3 :
                    menuController.insertNewMenu(insertNewMenu());
            }

        }while(true);

    }

    private Map<String,String> insertNewMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 이름을 적어주세요 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴 가격을 적어주세요 : ");
        String menuPrice = sc.nextLine();
        System.out.print("메뉴 카테고리를 적어주세요 : ");
        String menuCategory = sc.nextLine();

        Map<String , String> inputNewMenu = new HashMap<>();
        inputNewMenu.put("menuName",menuName);
        inputNewMenu.put("menuCode",menuPrice);
        inputNewMenu.put("menuCategory",menuCategory);

        return inputNewMenu;

    }

    private Map<String,String> inputCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력해주세요 : ");
        String menuCode = sc.nextLine();
        Map<String ,String > parameter = new HashMap<>();
        parameter.put("menuCode",menuCode);
        return parameter;



    }
}
