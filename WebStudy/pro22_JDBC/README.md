# 🐫 xml설정파일 분리하기

* web.xml에서 각각의 xml설정파일들의 경로를 지정한다.

    ```xml
        <!-- 지정한 경로의 설정파일을 읽는 역할 -->
        <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>

        <!-- 설정파일의 실제 경로 지정 -->
        <context-param>
            <param-name>contextConfigLocation</param-name>

            <param-value>
                /WEB-INF/config/action-service.xml
                /WEB-INF/config/action-dataSource.xml
            </param-value>
        </context-param>
    ```


* web.xml에서 지정한 경로의 xml설정파일을 생성한다.


# 🐫 .properties 파일로 DB설정 분리하기

* .properties 파일 생성

    ```properties
        jdbc.driverClassName = com.mysql.jdbc.Driver
        jdbc.url = jdbc:mysql://localhost:3306/tobySpring
        jdbc.username = root
        jdbc.password = 1111
    ```

* .properties 파일 불러오기

    ```xml
        <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
            <property name="locations">
                <list>
                    <value>/WEB-INF/config/jdbc.properties</value>
                </list>
            </property>
        </bean>
    ```