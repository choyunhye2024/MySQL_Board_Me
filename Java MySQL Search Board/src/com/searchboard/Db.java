package com.searchboard;

import java.sql.Connection; // 데이터베이스 연결을 위한 Connection 클래스
import java.sql.DriverManager; // 데이터베이스 드라이버 관리를 위한 DriverManager 클래스
import java.sql.ResultSet; // SQL 쿼리 결과를 저장하는 ResultSet 클래스
import java.sql.Statement; // SQL 쿼리를 실행하는 Statement 클래스

public class Db {

	// 데이터베이스 연결을 위한 기본 설정 (DB명, 사용자 ID, 비밀번호)
	static private String DB_NAME = "my_cat"; // 데이터베이스 이름
	static private String DB_ID = "root"; // 데이터베이스 사용자 ID
	static private String DB_PW = "root"; // 데이터베이스 사용자 비밀번호
	// 전역적으로 사용되는 Statement, Connection, ResultSet 객체
	static public Statement st = null;
	static public Connection con = null;
	static public ResultSet result = null;

	// 데이터베이스 초기화 함수 (연결 설정)
	static public void dbInit() {

		try {
			// 데이터베이스 연결 생성
			Db.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_ID, DB_PW);
			Db.st = Db.con.createStatement(); // 쿼리를 실행하기 위한 Statement 생성
		} catch (Exception e) {
			// 예외 발생 시 예외를 처리하지 않고 넘어감 (이 부분은 개선이 필요할 수 있음)
		}

	}

	// 주어진 SQL 쿼리를 실행하고, 업데이트된 행 수를 출력하는 함수
	static public void dbExecuteUpdate(String query) {

		Cw.wn("전송할 sql" + query); // 실행할 쿼리를 출력
		try {
			// 쿼리를 실행하고 업데이트된 행의 수를 저장
			int resultCount = st.executeUpdate(query);
			Cw.wn("처리된 행 수:" + resultCount); // 업데이트된 행의 수 출력

		} catch (Exception e) {
			// 예외 발생 시 처리하지 않고 넘어감
		}
	}

	// 게시물의 총 수를 출력하는 함수 (원본 게시물만 조회)
	static public void dbPostCount() {

		try {
			// 원본 게시물의 수를 조회하는 쿼리 실행
			Db.result = Db.st.executeQuery("select count(*) from board where_reply_ori is null");
			Db.result.next(); // 결과의 첫 번째 행으로 이동
			String count = Db.result.getString("count(*)"); // 게시물 수를 가져옴
			Cw.wn("글 수:" + count); // 게시물 수를 출력

		} catch (Exception e) {
			// 예외 발생 시 처리하지 않고 넘어감
		}

	}

	// 게시물의 총 수를 반환하는 함수 (원본 게시물만 조회)
	static public int getPostCount() {

		String count = "";
		try {
			// 원본 게시물의 수를 조회하는 쿼리 실행
			Db.result = Db.st.executeQuery("select count(*) from board where b_reply_ori is null");
			Db.result.next(); // 결과의 첫 번째 행으로 이동
			count = Db.result.getString("count(*)"); // 게시물 수를 가져옴

		} catch (Exception e) {
			// 예외 발생 시 처리하지 않고 넘어감
		}

		int intCount = Integer.parseInt(count); // 게시물 수를 정수로 변환
		return intCount; // 게시물 수 반환
	}

	// 검색어가 포함된 게시물 수를 반환하는 함수
	static public int getPostCountSearch(String searchWord) {

		String count = "";
		try {
			// 검색어가 포함된 게시물의 수를 조회하는 쿼리 실행
			Db.result = Db.st.executeQuery(
					"select count(*) from board where b_reply_ori is null" + "and b_title like '%" + searchWord + "%'");
			Db.result.next(); // 결과의 첫 번째 행으로 이동
			count = Db.result.getString("count(*)"); // 검색 결과 게시물 수를 가져옴
			Cw.wn("글 수:" + count); // 게시물 수 출력

		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
		}

		int intCount = Integer.parseInt(count); // 게시물 수를 정수로 변환
		return intCount; // 게시물 수 반환
	}

}
