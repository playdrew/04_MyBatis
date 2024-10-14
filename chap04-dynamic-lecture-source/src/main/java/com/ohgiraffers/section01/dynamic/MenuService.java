package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    // dao 계층 호출을 위한 변수
    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();
        
        // dao 계층 호출 getMapper(DynamicSqlMapper.class) 를 꺼내오려면 등록이 되어 있어야 해요 <-- remix 방식으로 하므로 이건 안함?
        // xml 방식으로 설정은 하지만 패키지를 동일하게 설정을 해서 알아서 인식하게 만들거에요
        // sqlSession 통로를 만들고 어떠한 매핑을 가져갈꺼냐 DynamicSqlMapper을 객체화 시켜서 .class 매핑한것
        // mapper : 데이터베이스 접근을 위한 완성된 객체
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /*comment.
        *   우리가 지금 하려고 하는 것이 price 를 query 문에 전달해서
        *   금액에 따라 적합한 메뉴를 추천을 해 줄 것이다.
        *   기본 자료형으로는 조건문의 값을 비교할 수 없으며
        *   따라서 인스턴스화를 진행해야한다.
        *   hashmap 을 사용해서 key 값으로 접근,
        *   dto 를 사용해서 getter 메소드로 접근
        * */

        // 조건문을 쓸건데 자료형이 int 인데.. 가장 많이쓰이는 두방식 해쉬맵과 DTO 사용

        // int 의 wrapper 클래스
        Map<String,Integer> map = new HashMap<>();
        // 오토박싱되면서 매개변수를 값으로 price 라고 대입한다.
        map.put("price",price);
        
        // 맵에다 값을 집어넣은 다음에 mapper에 전달
        // 값을 맵에다 전달했기에 맵을 전달
        // 우리가 전달한 값에 해당하는 메뉴들이 조회 타입을 여러개의 메뉴인 리스트로 만들어요
        // 매퍼들이 명령들(메소드)을 가지고 있는데 selectMenuByPrice 라는 명령을 실행하겠다. 인자를 맵으로 받아서
        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        // MVC(학습상) 패턴이 아니라서 여기다가 출력문작성
        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색결과가 없습니다.");
        }
        
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // 위에선 값을 map으로 넘겼는데 이번엔 클래스로 넘겼어요
        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색결과가 없습니다.");
        }

        sqlSession.close();

    }

    public void searchMenuBySubCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);


        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색결과가 없습니다.");
        }

        sqlSession.close();

        }

    public void searchMenuByRandomCode(List<Integer> randomCodeList) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();
        // Map 형식으로 우리가 만든 5개의 랜덤코드 리스트 집어넣기
        criteria.put("randomCodeList",randomCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomCode(criteria);

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색결과가 없습니다.");
        }

        sqlSession.close();

    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색결과가 없습니다.");
        }

        sqlSession.close();

    }

    public void modifyMenu(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);

        if(result>0){
            System.out.println("메뉴 정보 변경에 성공!!");
            sqlSession.commit();
        }else{
            System.out.println("메뉴 변경에 실패...");
            sqlSession.rollback();
        }
    }
}

// 데이터베이스 접근시 기본자료형은 사용못해서 래퍼된 값을 넘긴다.
// 서비스에서 dao 으로 넘길때 객체화 시켜서 넘겼지 기본자료형으로 넘긴 적 없음
// 다른 방식으론 컨트롤러에서 객체화 한 후 서비스쪽에 넘겨 줌
// 서비스쪽이 값이 제대로 왔는지 확인하는 역할