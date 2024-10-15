package com.ohgiraffers.common;

public class CategoryDTO {

    // MenuDTO 에 넣으면 객체와 객체와의 연관성이 있다고 볼수없어요
    // DTO를 어떤 식으로 작성하냐 DB에 맞춰서 클래스를 2개 예로 만들어두어요
    // 필요시에 JOIN 을 하는거지 항상 JOIN하는 건 아니지만 JOIN 하고 싶으면 클래스를 하나 만들어요

    private int code; // not null unique 없으면 기본값이 0
    private String name;
    private Integer refCategoryCode; // 상위 카테고리 코드 얘는 왜 Integer 일까요 db테이블을 보면 null 값을 허용하기 때문입니다 기본값이 null 입니다.

    public CategoryDTO(){}

    public CategoryDTO(int code, String name, Integer refCategoryCode) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
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

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
