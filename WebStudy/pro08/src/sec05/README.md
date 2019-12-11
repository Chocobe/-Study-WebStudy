# sec05.ex03 - ``InputStream``을 사용한 파일의 문자열 사용하기

*	``.txt`` 파일의 문자열 읽어오기

	```java
	ServletContext context = getServletContext();
	InputStream inputStream = context.getResourceAsStream("/WEB-INF/bin/init.txt");
	BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
	
	String currentLine = null;
	
	while((currentLine = buffer.readLine()) != null) {
		StringTokenizer tokens = new StringTokenizer(currentLine, ",");
		
		while(tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
		}
	}
	```
	