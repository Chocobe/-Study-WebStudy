# 🐫 기본 틀 설정

1. web.xml 에서 ``<servlet>``으로 **DispatcherServlet** 객체를 설정한다.

    ```xml
        <servlet>
            <servlet-name>dispatcherServlet</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        </servlet>

        <servlet-mapping>
            <servlet-name>dispatcherServlet</servlet-name>
            <url-pattern>*.do</url-pattern>
        </servlet-mapping>
    ```


1. web.xml 에서 등록한 ``dispatcherServlet``의 설정xml을 작성한다.

    * web.xml과 동일한 폴더에 **서블릿이름-servlet.xml** 형식으로 파일 생성 (예 : dispatcherServlet-servlet.xml)

    ```xml
        <!-- ModelAndView에서 설정할 view이름의 접두사/접미사 설정 -->
        <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
            <property name="prefix" value="/WEB-INF/views"/>
            <property name="suffix" value=".jsp"/>
        </bean>

        <!-- dispatcherServlet에서 사용할, URL Resolver 등록 -->
        <bean id="urlResolver" class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
            <property name="mappings">
                <props>
                    <prop key="/member/*.do">memberController</prop>
                </props>
            </property>
        </bean>

        <!-- url에 따라서 호출될 컨트롤러 빈 등록 -->
        <!-- MultiActionController 상속, 또는 Controller 구현 객체 -->
        <bean id="memberController" class="com.spring.member.controller.MemberControllerImpl">
            <property name="methodNameResolver" ref="methodNameResolver"/>
        </bean>

        <!-- url에 따라서 호출될 메서드를 지정해줄 빈 설정 -->
        <bean id="methodNameResolver" class="org.springframework.web.servlet.mvc.multiaction.PropertiesMethodNameResolver">
            <property name="mappings">
                <props>
                    <prop key="/member/login.do">login</prop>
                </props>
            </property>
        </bean>
    ```