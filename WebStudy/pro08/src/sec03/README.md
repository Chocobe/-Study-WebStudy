# sec03 - 바인딩

*	바인딩이란, 이름/값 으로 묶는 방식을 말한다.

*	``HttpServletRequest``, ``HttpSession``, ``ServletContext`` 객체에 값을 넘길 때 사용한다.

*	``바인딩된 값은 외부에서 접근이 안되기 때문에, 보안이 좋다``

*	``Redirect`` 방식의 포워딩으로는 바인딩을 할 수 없다.

*	``Rediect`` 방식의 ``HttpServletRequest``객체는 새로운 객체가 전달되기 때문에 바인딩된 값을 전달 할 수 없다.

*	``Dispatch`` 방식의 ``HttpServletRequest``객체는 현재의 객체를 전달하므로, 바인딩된 값을 전달 할 수 있다.