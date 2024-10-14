package com.ohgiraffers.section02.javaconfig.model.service;

import com.ohgiraffers.section02.javaconfig.model.dao.MenuMapper;
import com.ohgiraffers.section02.javaconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;
    // menuMapper 인스턴스 생성해야 사용가능한데 인터페이스라서 new 라는 키워드로 인스턴스 직접적 생성 불가


    public List<MenuDTO> selectAllMenu(){
        
        // 1. sqlSession 생성
        SqlSession sqlSession = getSqlSession();
        
        // 2. dao 클래스 메소드 호출
        // 2. Template 에 등록한 Mapper 파일 사용 준비
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        // 3. 사용할 sqlSession 닫기
        sqlSession.close();

        return menuList;


    }
}
