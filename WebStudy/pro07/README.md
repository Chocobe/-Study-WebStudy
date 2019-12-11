# pro07 - MySQL 연동 (JDBC, DBCP, JNDI)

>	JNDI를 이용한 MySQL DBCP연동

---

*	``servet.xml`` 설정

	```xml
	<Resource 
		driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://127.0.0.1:3306/SERVLET_PRACTICE"
		sername="root"
		password="1111"
		name="jdbc/study/mysql"
		type="javax.sql.DataSource"
		maxActive="20"
		maxIdle="20"
		maxWait="5000"/>
    ```
	    
---
	    
*	``context.xml`` 설정

	```xml
	<ResourceLink
		global="jdbc/study/mysql"
		name="jdbc/study/mysql"
		type="javax.sql.DataSource"/>
	```

---
		
*	``web.xml`` 설정

	```xml
	<resource-ref>
		<res-ref-name>jdbc/study/mysql</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref>
	```
