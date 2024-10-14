package com.ohgiraffers.section01.xmlconfig;

import static com.ohgiraffers.section01.xmlconfig.MybatisTemplate.getSqlSession;

public class Application {

    public static void main(String[] args) {

        // 팩토리를 만드는 것은 자본이 많이 필요하기 때문에
        // 최초에 딱 한번 생성을 한 뒤에 더이상 만들지 않아요
        // session 을 만들때는 새롭게 만들어주니까 해쉬코드도 계속 달라지는 것을 확인 할 수 있습니다.
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());

    }
}
