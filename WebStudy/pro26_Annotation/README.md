# 🐫 Spring Annotation

* XML에 작성했던 설정정보를 **에너테이션**으로 설정할 수 있다.


---


## 🐫 컨트롤러 설정하기

* 스프링의 에너테이션을 읽기 위한 빈(Bean)을 설정해야 한다.

    ```xml
        <!-- base-package하위의 에너테이션을 찾아서 빈으로 만든다. -->
        <context:component-scan base-package="com.spring"/>

        <!-- 클래스의 @RequestMapping을 처리하는 빈 설정 : DefaultAnnotationHandlerMapping -->
        <bean class="org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping"/>

        <!-- 메서드의 @RequestMapping을 처리하는 빈 설정 : AnnotationMethodHandlerAdapter -->
        <bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter"/>

        <!-- ModelAndView의 setViewName 처리용 빈 (선택사항) -->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/views/test"/>
            <property name="suffix" value=".jsp"/>
        </bean>
    ```

    ```java
        @RequestMapping("/test") // 또는 @RequestMapping(value="/test")
        public class test {
            @RequestMapping(value="/main1.do", method=RequestMethod.GET)
            public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {
                ModelAndView mav = new ModelAndView();
                mav.addObject("msg", "main1 page");
                mav.setViewName("/main1");

                return mav;
            }
        }
    ```