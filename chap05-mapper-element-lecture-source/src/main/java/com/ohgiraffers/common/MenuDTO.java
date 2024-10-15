package com.ohgiraffers.common;

public class MenuDTO {

    // 주소값이 나오면 toString 이 없습니다.

    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

    public MenuDTO(){}

    public MenuDTO(int code, String name, int price, int categoryCode, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
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

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    // 우리가 컨트롤러 서비스 dao db 아키텍쳐를 잡았는데 중간중간 dto 가 등장해서 날라주는 역할을 합니다
    // 컨트롤로는 행위중심이고 뷰를 리턴하고 값을 받는 존재 service 값을 처리하는 존재 dao 는 데이터베이스를 연결하는 존재
}
