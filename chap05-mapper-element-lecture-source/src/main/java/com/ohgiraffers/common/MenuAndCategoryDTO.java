package com.ohgiraffers.common;

public class MenuAndCategoryDTO {

    // menu 관점에서 바라본 menu -> category 클래스 메뉴는 하나 카테고리도 하나
    // join을 했을때를 위한 클래스 입니다
    // 메뉴테이블에서는 카테고리 코드를 전달함으로서 카테고리정보를 가지고 있어요
    // 하나의 메뉴는 1번이란 코드와 붕어빵 가격 주문상태 카테고리코드를 1이라고 가지고 있지만
    // 실제적으론 1과 한식 null 이런 식으로 정보들이 들어가 있게 됨입니다.
    // 테이블을 나누는 이유는 중복의 최소화 비슷한 것들을 모으고 연관관계를 위한 선을 만들어요
    // 1이란 정보를 가지게 되면 한식과 null 을 딸려오는 것이에요
    // 객체관점에서 수정하고 변형하고 싶으면 객체관점에서 해야해요

    private int code;
    private String name;
    private int price;
    private CategoryDTO categoryDTO;
    private String orderableStatus;

    public MenuAndCategoryDTO(){}

    public MenuAndCategoryDTO(int code, String name, int price, CategoryDTO categoryDTO, String orederableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryDTO = categoryDTO;
        this.orderableStatus = orederableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryDTO=" + categoryDTO +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
