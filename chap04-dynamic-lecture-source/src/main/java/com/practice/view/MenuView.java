package com.practice.view;

import com.practice.controller.MenuController;

import java.util.Scanner;

public class MenuView {

    static Scanner sc = new Scanner(System.in);
    static MenuController menuController = new MenuController();

    public void display() {
        do {

            System.out.println("===마이바티스 동적 SQL 학습 메뉴===");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    subifMenu();
                    break;
                case 2:
                    //subChooseMenu();
                    break;
                case 3:
                    //subForeachMenu();
                    break;
                case 4:
                    //subTrimMenu();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;

            }
        }while (true) ;
    }

    private static void subifMenu() {

        do {
            System.out.println("==========if 서브메뉴==========");
            System.out.println("1. 원하는 금액 대 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카타고리명으로 검색해서 메뉴목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("원하는 메뉴를 선택해주세요 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuController.selectMenuByMenuPrice(inputMenuPrice());
                    break;
                case 2:
                    break;
                case 9:
                    System.out.println("if 서브 메뉴 종료");
                    return;
            }
        }while (true);
    }

    private static int inputMenuPrice() {

        System.out.print("원하는 금액대를 작성해주세요 : ");
        int price = sc.nextInt();
        return price;
    }
}
