# 🐫 MyBatis

* SQL문의 가독성을 높여 사용하기 편하게 만든 프레임워크

* 필요 라이브러리 : **mybatis-3.5.4.jar**

* MyBatis를 사용하기 위한 설정방법

    * MyBatis설정

    ```xml
        <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE configuration
                PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
                "http://mybatis.org/dtd/mybatis-3-config.dtd">

        <configuration>
            <!-- 1. typeAliases - 사용할 VO객체 설정 -->
            <typeAliases>
                <typeAlias type="com.spring.ex01.MemberVO" alias="memberVO"/>
            </typeAliases>

            <!-- 2. environments - DB설정 -->
            <environments default="development">
                <environment id="development">
                    <transactionManager type="JDBC"/>

                    <dataSource type="POOLED">
                        <property name="driver" value="com.mysql.jdbc.Driver"/>
                        <property name="url" value="jdbc:mysql://localhost:3306/tobySpring"/>
                        <property name="username" value="root"/>
                        <property name="password" value="1111"/>
                    </dataSource>
                </environment>
            </environments>

            <!-- 3. mappers - 사용할 쿼리xml파일의 경로 설정 -->
            <mappers>
                <mapper resource="/mybatis/mappers/member.xml"/>
            </mappers>
        </configuration>
    ```

    * SQL을 작성할 xml 작성

    ```xml
        <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE mapper
                PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

        <!-- 쿼리 호출용 namespace설정 -->
        <mapper namespace="mapper.member">
            <!-- 결과값 반환을 위한 VO객체 mapping설정 -->
            <resultMap id="memResult" type="memberVO">
                <result property="id" column="id"/>
                <result property="pwd" column="pwd"/>
                <result property="name" column="name"/>
                <result property="email" column="email"/>
                <result property="joinDate" column="joinDate"/>
            </resultMap>

            <!-- 쿼리 작성 -->
            <select id="selectAllMemberList" resultMap="memResult">
                <![CDATA[
                    SELECT * FROM t_member ORDER BY joinDate DESC
                ]]>
            </select>
        </mapper>
    ```    

    * 설정한 MyBatis 사용하기

    ```java
        public class MemberService {
            // MyBatis 세션을 열기위한 팩토리 객체
            private SqlSessionFactory sqlSessionFactory;

            public SqlSessionFactory getInstance() {
                if(sqlSessionFactory == null) {
                    Reader reader = null;

                    try {
                        String resource = "/mybatis/SqlMapCofing.xml";
                        reader = Resources.getResourceAsReader(resource);
                        sqlSessionFactory = new SqlSessionFactory().build(reader);

                        reader.close();

                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }

                return sqlSessionFactory;
            }
            
            public List<MemberVO> selectAllMemberList() {
                sqlSessionFactory = getInstance();
                SqlSession sqlSession = sqlSessionFactory.openSession();

                return sqlSession.selectList("mapper.member.selectAllMemberList");
            }
        }
    ```