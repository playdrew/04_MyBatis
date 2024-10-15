package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;

import java.util.List;

public interface ElementMapper {

    // xmlmapper 와 ElementMapper 의 패키지 구조는 동일하며 이름도 동일하다
    // List타입의 String 여러개의 행이 존재하기 때문에
    List<String> selectCacheTest();

    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructor();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();

    List<MenuDTO> selectSqlTest();
}
