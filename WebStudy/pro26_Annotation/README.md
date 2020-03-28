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


---


## 🐫 @RequestMapping의 메서드 설정

* @RequestMapping을 사용한 메서드에서는 **@RequestParam** 을 사용하여 파라미터를 쉽게 가져올 수 있다.

    ```java
        @RequestMapping(value= "/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
        public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam("userID") String userID,
                                  @RequestParam("userName") String userName) throws Exception {
            ModelAndView mav = new ModelAndView();

            mav.addObject("userID", userID);
            mav.addObject("userName", userName);
            mav.setViewName("/result");

            return mav;
        }
    ```

* @RequestParam의 속성 중, **required**는 파라미터의 필수여부를 설정할 수 있다. (기본값 : true)

* **@RequestParam(value="", required= true)** 로 설정된 파마리터의 전달된 값이 없을 경우, 예외를 발생시킨다.

* **@RequestParam(value="", required= false)** 로 설정된 파라미터의 전달된 값이 없을 경우, null을 할당한다.

    ```java
        @RequestMapping(value= "/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
        public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(value= "userID", required= true) String userID,
                                  @RequestParam(value= "userName", required= false) String userName) throws Exception {
            ModelAndView mav = new ModelAndView();

            mav.addObject("userID", userID);
            mav.addObject("userName", userName);
            mav.setViewName("/result");

            return mav;
        }
    ```

* @RequestParam으로 **Map<String, String>** 타입에 파라미터값을 설정하여 가져올 수 있다.

* 자동 바인딩을 해 주기 때문에, 모든 파라미터를 명시하지 않아도 되는 장점이 있다.

    ```java
        @RequestMapping(value= "/test/login.do" method= {RequestMethod.GET, RequestMethod.POST})
        public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam Map<String, String> info) throws Exception {
            ModelAndView mav = new ModelAndView();

            System.out.println("userID : " + info.get("userID"));
            System.out.println("userName : " + info.get("userName"));

            mav.addObject("info", info);

            return mav;
        }
    ```

* **@ModelAttribute** 를 @RequestParam 대신 사용할 경우, VO객체에 파라미터를 바인딩해주고, ``HttpServletRequest``객체에 ``addAttribute(파라미터명)``을 수행해 준다.

    ```java
        @RequestMapping(value= "/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
        public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                                  @ModelAttribute("info") LoginVO loginVO) throws Exception {
            ModelAndView mav = new ModelAndView();

            System.out.println("userID : " + loginVO.getUserID());
            System.out.println("userName : " + loginVO.getUserName());

            mav.setViewName("/result");

            return mav;
        }
    ```

* **Model** 클래스를 이용한 메서드

    * 메서드의 파라미터에 **Model** 클래스를 인자로 갖도록 만든다.

    * 반환형이 ModelAndView가 아닌, **String** 타입이다.

    * 반환값은 출력하고자 하는 **JSP파일명** 이다.

    ```java
        @RequestMapping(value= "/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
        public String login(HttpServletRequest request, HttpServletResponse response,
                            Model model) throws Exception {
            model.addAttribute("userID", "hong");
            model.addAttribute("userName", "홍길동");

            return "/result";
        }
    ```