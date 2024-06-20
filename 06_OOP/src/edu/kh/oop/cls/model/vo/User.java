package edu.kh.oop.cls.model.vo;

public class User {
	// 속성(== 필드)

	// 아이디, 비밀번호, 이름, 나이, 성별 (추상화 진행)
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender;

	// 기능(== 생성자 + 메소드)

	// 생성자 : new연산자를 통해서 객체가 생성될 때
	//		  생성된 객체의 필드 값 초기화 + 기능 수행 역할
	
	// 기본 생성자
	public User() {
		// 기능
		System.out.println("기본 생성자로 User 객체 생성");
		
		// 필드 초기화
		userId = "user01";
		userPw = "pass01";
		userName = "홍길동";
		userAge = 20;
		userGender = '남';
				
	}
	
	// 매개변수 생성자
	// ** 사용되는 기술, 변수 : 매개변수, 오버로딩(Overloading), this
	
	// ** 매개변수 : 생성자나 메소드 호출 시 ()안에 작성되어
	// 			   전달되어지는 값을 저장하는 변수
	// -> 전달 받은 값을 저장하고 있는 매개체(지니고 있는) 역할의 변수
	public User(String userId, String userPw) {
				  // 매개변수      // 매개변수
		System.out.println("매개변수 생성자를 이용해서 User 객체 생성");
		System.out.println(userId + " / "+ userPw);
		
		
		// 전달 받은 값을 필드에 초기화(this 참조변수)
		
		// *** this 참조 변수 ***
		// - 객체가 자기 자신을 참조할 수 있도록 하는 변수
		// - 모든 객체 내부에 숨겨져 있다.
		// 왜 사용하는가?
		// -> 필드명과 매개변수명이 같을 경우
		//	  이를 구분하기 위해서 주로 사용
		
		this.userId = userId;
		// 필드 = 매개변수
		// 전달받은 userId를 필드의 userId로 저장하겠다
		
		this.userPw = userPw;
		
	}

	// 필드를 전부 초기화 하는 목적의 매개변수 생성자
	public User(String userId, String userPw, String userName, 
			int userAge, char userGender) {

		// 매개변수로 전달 받은 값으로 필드 초기화
		// this.userId = userId; // 현재 객체가 가지고 있는 필드 userId에
							  // 매개변수 userId 값을 대입
		// this.userPw = userPw;
		
		// User(userId, userPw); // 오류발생 : The method User(String, String) is undefined for the type User
		this(userId, userPw); // this() 생성자
		// - 같은 클래스의 다른 생성자를 호출할 때 사용
		// - 생성자 내에서 반드시 첫 번째 줄에 작성 되어야 한다!!
		
		// 왜 사용? 1) 중복 코드 제거, 2) 코드 길이 감소, 3) 재사용성 증가
		// (가독성이 어려운 경우가 생길 수 있어서 많이 사용되진 않음)
		
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;

	}
	
	// 자바는 기본적으로 필드명, 생성자명, 메소드명, 변수명의
	// 중복을 허용하지 않음
	
	/*
	private String userId; // 오류 발생 : Duplicate field User.userId
	public User() {} // 오류 발생 : Duplicate method User() in type User
	public String getUserId() {} // 오류 발생 : This method must return a result of type String
	public void ex() {
		int num = 10;
		int num = 20; // 오류 발생 : Duplicate local variable num
	}
	*/
	
	// 위에서 본 것처럼 자바는 중복되면 오류가 발생하는데, public User 중복 안 됨
	// -> 오버로딩 특징 덕분에 오류 나지 않음
	
	// *** 오버로딩(Over Loading) ***
	// - 클래스 내에 동일한 이름의 메소드(생성자도 포함)를
	// 	 여러 개 작성하는 기법
	
	// --> 하나의 이름으로 여러 기능을 수행할 수 있게 하는 것
	
	// [오버로딩 조건]
	// 1) 메소드(생성자 포함)의 이름이 동일
	// 2) 매개변수의 개수, 타입, 순서 중 1개라도 달라야 함!!
	
	// public User() {} : // 오류발생 : 매개변수가 하나도 없음(기본 생성자)
						  // 위에 있음 = 기본 생성자가 이미 작성되어 있어서 중복
	
	public User(String userId) {} // 매개변수의 개수가 같은 생성자 없음
								  // -> 오버로딩 성립
	
	public User(int userAge) {} // 매개변수의 개수는 같지만 타입이 다름
								  // -> 오버로딩 성립
	public User(int userAge, String userId) {}
	// 매개변수의 개수는 같지만 타입이 다름 -> 오버로딩 성립
	
	public User(String userId, int userAge) {}
	// 매개변수의 개수, 타입은 같지만 순서가 다름 -> 오버로딩 성립
	
	public User(String userId, String userPw, String userName) {}
	
	// public User(String userName, String userId, String userPw) {} 
	// 오류 발생 : 115과 변수명 순서는 다른데 왜 오류? 
	// 			매개변수의 개수, 타입, 순서가 모두 같아서 오버로딩 불가
	// 			-> 변수명은 신경쓰지 않는다!!!
	
	
	
	// 캡슐화로 인한 간접 접근 기능(getter / setter
	// private으로 만드니깐 나도 접근못해서 비밀통로 만들기
	public String getUserId() { // userId의 getter
		return userId;
	}
	public void setUserId(String userId) { // userId의 setter
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
}

