package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do{

            System.out.println("================Mapper Element 테스트 메뉴================");
            System.out.println("1. <cache> 테스트");
            System.out.println("2. <resultMap> 서브 메뉴");
            System.out.println("3. <sql> 테스트");
            System.out.println("9. 프로그램 종료");
            System.out.print("원하시는 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 :
                    elementService.selectCacheTest();
                    break;
                case 2 :
                    resultMapSubMenu();
                    break;
                case 3 :
                    elementService.sqlTest();
                    break;
                case 9 :
                    System.out.println("프로그램을 종료합니다..");
                    return;


            }

        }while(true);

    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do{

            System.out.println("================ResultMap 서브 메뉴================");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("2. <constructor> 테스트");
            System.out.println("3. <association> 테스트");
            System.out.println("4. <collection> 테스트");
            System.out.println("9. 이전 메뉴로 가기");
            System.out.print("메뉴 번호를 입력해주세요 : ");
            int no = sc.nextInt();
            
            switch(no){
                case 1 :
                    elementService.selectResultMapService();
                    break;
                case 2 :
                    // resultMap은 필드에 getter와 setter 를 통해 값을 집어넣었다면 컨스트럭터는
                    elementService.selectResultMapConstructor();
                    break;
                case 3 :
                    // association 1:1 관계
                    elementService.selectResultMapAssociation();
                    break;
                case 4 :
                    elementService.selectResultMapCollection();
                    break;
                case 9 :
                    System.out.println("이전 메뉴로 가요..");
                    return;
            }

        }while(true);
    }
}
