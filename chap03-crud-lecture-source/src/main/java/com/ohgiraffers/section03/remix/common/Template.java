package com.ohgiraffers.section03.remix.common;

import com.ohgiraffers.section03.remix.model.dao.MenuMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    // 클래스에 db 정보들이 누출되어 있으니 감추기 위해 property 파일에 넣는 것 어떨까 생각하면 좋음
    private static String Driver = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";
    
    private static SqlSessionFactory sqlSessionFactory;
    
    public static SqlSession getSqlSession(){
        
        if(sqlSessionFactory == null){
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(Driver, URL, USER , PASSWORD)
            );

            Configuration configuration = new Configuration(environment);
            
            // comment. 작성한 MenuMapper 인테페이스 mapper 로 등록
            configuration.addMapper(MenuMapper.class);
            
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }
        return sqlSessionFactory.openSession(false);
    }
}
