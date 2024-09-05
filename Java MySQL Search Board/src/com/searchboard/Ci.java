package com.searchboard;

import java.io.BufferedReader; // BufferedReader 클래스를 사용하기 위해 import
// BuffedReader = 버퍼를 이용해서 읽는 함수
import java.io.InputStreamReader; // InputStreamReader 클래스를 사용하기 위해 import
//InputStream = 자바에서 가장 기본이 되는 입출력시스템
import java.util.Scanner; // Scanner 클래스를 사용하기 위해 import
//Scanner = 메소드를 이용해서 입력을 받는 함수(키보드 입력)

public class Ci {
	// 클래스 변수로 Scanner 객체를 생성 (키보드 입력을 받기 위한 도구)
	static Scanner sc = new Scanner(System.in);

	// BufferedReader 객체를 생성하여 표준 입력을 받기 위한 도구로 사용
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// 사용자가 입력한 한 단어를 반환하는 메서드
	static public String r() {
		return sc.next(); // sc(Scanner 객체)를 통해 입력된 단어를 반환
	}

	// 메서드 오버로딩: 매개변수로 받은 comment를 출력한 후 사용자가 입력한 단어를 반환
	static public String r(String comment) {
		Cw.w(comment + ":"); // 주어진 comment에 ":"를 추가하여 출력
		return sc.next(); // sc(Scanner 객체)를 통해 입력된 단어를 반환
	}

	// 매개변수로 받은 comment를 출력한 후 사용자가 입력한 문자열을 반환 (엔터키로 끝나는 한 줄을 읽음)
	static public String rl(String comment) {
		Cw.w(comment + ":"); // 주어진 comment에 ":"를 추가하여 출력
		try {
			// reader(BufferedReader)를 통해 한 줄의 입력을 받아 반환
			return reader.readLine();
		} catch (Exception e) { // 입력 중 예외가 발생했을 때 예외 처리
			e.printStackTrace(); // 예외가 발생하면 스택 트레이스를 출력
			return null; // 예외가 발생한 경우 null을 반환
		}
	}
}
