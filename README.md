# 🐫 Spring 설정을 위한 XML namespace

* XML에서 특정 스키마를 사용하기 위해서는 **namespace**를 지정해 줘야한다.

* **root** 태그의 namespace는 **prefix**를 **생략**할 수 있다.

* namespace는 중복 되어선 않된다.

    ```xml
        <!-- beans를 root로 namespace지정 -->
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               
               xmlns="http://www.springframework.org/schema/beans"
               xsi:schemaLocation="http://www.springframework.org/schema/beans
                                   https://www.springframework.org/schema/beans/spring-beans.xsd">

        </beans>
    ```

    * ``<xmlns:xsi>``는 가져올 스키마들의 유효성 검사를 해주며, 관습적으로 **xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"** 로 사용한다.

    * **xsi:schemaLocation** 에 사용할 namespace의 소스위치를 설정해야 한다.

    * **xsi:schemaLocation="{네임스페이스} {위치경로}"**의 형식으로 설정한다.

    * **{위치경로}** 값은 **네임스페이스/artifactId.xsd** 형식으로 설정한다.

* 아래는 beans태그를 root로 하고, aop, tx, mvc의 namespace를 추가한 예이다.

    ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            
               xmlns="http://www.springframework.org/schema/beans"
               xmlns:aop="http://www.springframework.org/schema/aop"
               xmlns:tx="http://www.springframework.org/schema/tx"
               xmlns:mvc="http://www.springframework.org/schema/mvc"
               
               xsi:schemaLocation="http://www.springframework.org/schema/beans
                                   http://www.springframework.org/schema/beans/spring-beans.xsd
                                   
                                   http://www.springframework.org/schema/aop
                                   http://www.springframework.org/schema/aop/spring-aop.xsd
                                   
                                   http://www.springframework.org/schema/tx
                                   http://www.springframework.org/schema/tx/spring-tx.xsd
                                   
                                   http://www.springframework.org/schema/mvc
                                   http://www.springframework.org/schema/mvc/spring-mvc.xsd">

        </beans>
    ```