package com.searchboard;

public class Cw {
	// 상수로 정의된 문자열 "🐈‍"를 DOT로 사용 (점 대신 고양이 이모티콘 사용)
	private static final String DOT = "🐈‍";
	// 선을 그을 때 사용할 라인의 길이를 32로 설정
	private static final int LINE_LENGTH = 32;

	// 입력된 문자열을 출력하는 함수
	public static void w(String s) {
		System.out.print(s); // 개행 없이 문자열을 출력
	}

	// 입력된 문자열을 출력하고 개행하는 함수
	public static void wn(String s) {
		System.out.println(s); // 문자열을 출력하고 개행
	}

	// 개행만 하는 함수 (오버로딩된 함수)
	public static void wn() {
		System.out.println(); // 아무 내용 없이 줄바꿈
	}

	// 32개의 "🐈‍"를 출력하는 선 긋기 함수
	public static void line() {
		for (int i = 0; i < LINE_LENGTH; i++) {
			w(DOT); // DOT("🐈‍")를 32번 반복해서 출력
		}
		wn(); // 선을 다 그리고 개행
	}

	// 한 번 "🐈‍"을 출력하는 함수
	public static void dot() {
		w(DOT); // DOT("🐈‍")를 한 번 출력
	}

	// 입력된 숫자만큼 공백을 출력하는 함수
	public static void space(int c) {
		for (int i = 0; i < c; i++) {
			w(" "); // 공백 문자를 c번 반복해서 출력
		}
	}
}