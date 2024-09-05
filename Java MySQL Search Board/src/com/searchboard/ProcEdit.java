package com.searchboard;

public class ProcEdit {

	// 글 수정을 처리하는 메서드
	static public void run() {

		// 수정할 글 번호를 입력받음
		String editNo = Ci.r("수정할 글 번호를 입력해주세요:");

		// 새로운 제목을 입력받음
		String edTitle = Ci.rl("제목을 입력해주세요:");

		// 새로운 작성자 아이디를 입력받음
		String edId = Ci.rl("작성자 아이디를 입력해주세요:");

		// 새로운 글 내용을 입력받음
		String edContent = Ci.rl("글 내용을 입력해주세요:");

		// 입력된 내용을 기반으로 데이터베이스의 해당 글을 업데이트하는 SQL 쿼리를 실행
		// 글 번호에 해당하는 레코드를 찾아 제목, 작성자, 수정일, 글 내용을 업데이트함
		Db.dbExecuteUpdate("update board set b_title='" + edTitle + "',b_id='" + edId + "',b_datetime=now(),b_text='"
				+ edContent + "'where b_no=" + editNo);
	}
}
