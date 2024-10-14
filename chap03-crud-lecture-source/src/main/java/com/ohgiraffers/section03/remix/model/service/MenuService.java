package com.ohgiraffers.section03.remix.model.service;

import com.ohgiraffers.section03.remix.common.Template;
import com.ohgiraffers.section03.remix.model.dao.MenuMapper;
import com.ohgiraffers.section03.remix.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.remix.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;
    // menuMapper 인스턴스 생성해야 사용가능한데 인터페이스라서 new 라는 키워드로 인스턴스 직접적 생성 불가
    // 메뉴메퍼를 데이터베이스에 가지고 오려면 실체가 필요한데 실체를 만들어 주는 준비작업


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

    public MenuDTO selectMenuByMenuCode(int code) {

        // 1. SqlSession 생성
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        // 2. DAO 계층 메소드 호출하기
        MenuDTO menu = menuMapper.selectMenuByCode(code);

        // 3. 사용한 통로 닫아주기
        sqlSession.close();

        return menu;

    }

    public boolean insertNewMenu(MenuDTO newMenu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertNewMenu(newMenu);

        if(result>0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0 ? true : false ;
    }

    public boolean modifyMenu(MenuDTO modifyMenu) {

        SqlSession sqlSession = getSqlSession();

        // 객체화된 인터페이스 menuMapper 를 sqlSession 에 꺼내오겠다.
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.modifyMenu(modifyMenu);

        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0? true : false;
    }

    public boolean deleteMenu(MenuDTO deleteMenu){

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(deleteMenu);

        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0? true : false;
    }
}
