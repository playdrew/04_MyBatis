package com.ohgiraffers.common;

import java.util.List;

public class CategoryAndMenuDTO {

    //    지금까진 메뉴의 관점으로 봤어요 메뉴1개 카테고리1개 근데 카테고리는 많은 메뉴를 지닐수 있어요 이기준으로 봐요
    //    하나의 카테고리코드는 여러개의 메뉴를 가질 수 있으니까 List타입필드선언
    private int code;
    private String name;
    private Integer refCategoryCode;
    private List<MenuDTO> menuList;

    public CategoryAndMenuDTO() {
    }

    public CategoryAndMenuDTO(int code, String name, Integer refCategoryCode, List<MenuDTO> menuList) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
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

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
