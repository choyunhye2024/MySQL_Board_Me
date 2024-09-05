package com.searchboard;

public class Disp {
	// 게시판 제목, 버전, 제작자 정보를 상수로 설정
	static private String TITLE = "고양이 게시판"; // 게시판 제목
	static private String VERSION = " v0.0.7"; // 버전 정보
	static private String FEAT = " sm.ahn"; // 제작자 이름

	// 게시판의 타이틀을 출력하는 함수
	public static void title() {
		Cw.line(); // 선 긋기
		Cw.dot(); // 시작 고양이 이모티콘 출력
		Cw.space(20); // 20칸의 공백 출력
		Cw.w(TITLE); // 게시판 제목 출력
		Cw.w(VERSION); // 버전 정보 출력
		Cw.w(FEAT); // 제작자 정보 출력
		Cw.space(20); // 20칸의 공백 출력
		Cw.dot(); // 끝 고양이 이모티콘 출력
		Cw.wn(); // 개행
		Cw.line(); // 선 긋기
	}

	// 메인 메뉴를 출력하는 함수
	public static void menuMain() {
		Cw.dot(); // 시작 고양이 이모티콘 출력
		// 메뉴 항목 출력
		Cw.w("[1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정 [6]검색 [0]관리자 [e]프로그램종료");
		Cw.dot(); // 끝 고양이 이모티콘 출력
		Cw.wn(); // 개행
	}

	// 글 목록을 출력할 때의 헤더를 출력하는 함수
	static public void titleList() {
		// 글 목록의 구분선을 출력
		Cw.wn("==========================================");
		Cw.wn("================= 글리스트 ==================");
		Cw.wn("==========================================");
		// 글 목록의 제목, 작성자, 작성 시간 등의 헤더를 출력
		Cw.wn("글번호 글제목 작성자id 작성시간");
	}

	// 댓글 리스트 구분선을 출력하는 함수
	public static void replyBar() {
		Cw.wn("================= 댓글 리스트 ==================");
	}
}
