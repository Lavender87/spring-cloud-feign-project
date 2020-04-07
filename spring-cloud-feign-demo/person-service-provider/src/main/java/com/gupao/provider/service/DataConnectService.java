package com.gupao.provider.service;

public class DataConnectService {


  /**
   * 数据库连接方式
   * 必须有这个依赖包
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>


   方式一：与JdbcTemplate集成

   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-jdbc</artifactId>
   </dependency>


   package com.guxf.dao;

   import java.util.List;

   import com.guxf.domain.Author;

   public interface AuthorDao {

   int add(Author author);

   int update(Author author);

   int delete(Long id);

   Author findAuthor(Long id);

   List<Author> findAuthorList();
   }


   ackage com.guxf.impl;

   import java.util.HashMap;
   import java.util.List;
   import java.util.Map;

   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
   import org.springframework.stereotype.Repository;

   import com.guxf.dao.AuthorDao;
   import com.guxf.domain.Author;

   @Repository
   public class AuthorDaoJdbcTemplateImpl implements AuthorDao{

   @Autowired
   private NamedParameterJdbcTemplate jdbcTemplate;

   @Override
   public int add(Author author) {
   String sql = "insert into t_author(id,real_name,nick_name) " +
   "values(:id,:realName,:nickName)";
   Map<String, Object> param = new HashMap<>();
   param.put("id",author.getId());
   param.put("realName", author.getRealName());
   param.put("nickName", author.getNickName());

   return (int) jdbcTemplate.update(sql, param);
   }

   @Override
   public int update(Author author) {
   return 0;
   }

   @Override
   public int delete(Long id) {
   return 0;
   }

   @Override
   public Author findAuthor(Long id) {
   return null;
   }

   @Override
   public List<Author> findAuthorList() {
   return null;
   }
   }



   方式二：与JPA集成
   //参照PersonEntityService  PersonServiceProvider



   方式三：与MyBatis集成
//   <!-- 引入Mybatis -->
   <dependency>
   <groupId>org.mybatis.spring.boot</groupId>
   <artifactId>mybatis-spring-boot-starter</artifactId>
   <version>1.1.1</version>
   </dependency>


   application.yml中
   spring:
   datasource:
   url: jdbc:mysql://127.0.0.1:3306/springboot_db?useUnicode=true&characterEncoding=UTF-8&useSSL=false
   driverClassName: com.mysql.jdbc.Driver
   username: root
   password: root
   type: com.alibaba.druid.pool.DruidDataSource

   mybatis:
   #config-locations: mybatis/mybatis-config.xml
   mapper-locations: com/guxf/mapper/*.xml
   type-aliases-package: com.guxf.mapper.AuthorMapper


   编写mapper对应的接口：

   package com.guxf.mapper;

   import org.apache.ibatis.annotations.Mapper;

   import com.baomidou.mybatisplus.mapper.BaseMapper;
   import com.guxf.domain.Author;
   @Mapper
   public interface AuthorMapper extends BaseMapper<Author> {

   public Long insertAuthor(Author author);

   public void updateAuthor(Author author);

   public Author queryById(Long id);
   }


   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
   <mapper namespace="com.guxf.mapper.AuthorMapper">
   <!-- 此处需要注意的是，由于我们数据库定义的id存储类型为intbig,但是我们的Entity中Id是Long -->
   <!-- 前面的两种方式插入没问题，此处报了数据库类型异常 -->
   <!-- 所以数据库的ID类型改为了Varchar -->
   <resultMap id="authorMap" type="com.guxf.domain.Author">
   <id column="id" property="id" jdbcType="VARCHAR" />
   <result column="real_name" property="realName" jdbcType="VARCHAR" />
   <result column="nick_name" property="nickName" jdbcType="VARCHAR" />
   </resultMap>

   <sql id="base_column">
   id,real_name,nick_name
   </sql>

   <insert id="insertAuthor" parameterType="com.guxf.domain.Author">
   INSERT INTO
   t_author(
   <include refid="base_column" />
   )
   VALUE
   (#{id},#{realName},#{nickName})
   </insert>

   </mapper>

   */
}
