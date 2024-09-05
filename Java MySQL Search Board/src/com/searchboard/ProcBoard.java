package com.searchboard;

public class ProcBoard {
	// 프로그램의 메인 실행 함수
	void run() {
		// 게시판 타이틀 출력
		Disp.title();

		// 데이터베이스 초기화
		Db.dbInit();

		// 게시물 수를 출력
		Db.dbPostCount();

		// 메인 루프: 사용자가 프로그램을 종료할 때까지 계속 실행
		loop: while (true) {
			// 게시물 수를 다시 출력 (메뉴를 볼 때마다 게시물 수 갱신)
			Db.dbPostCount();

			// 메인 메뉴를 출력
			Disp.menuMain();

			// 사용자로부터 명령 입력을 받음
			String cmd = Ci.r("명령입력");

			// 사용자가 입력한 명령에 따라 기능을 실행
			switch (cmd) {
			case "1": // 글 리스트 보기
				ProcList.run();
				break;
			case "2": // 글 읽기
				ProcRead.run();
				break;
			case "3": // 글 쓰기
				ProcWrite.run();
				break;
			case "4": // 글 삭제
				ProcDel.run();
				break;
			case "5": // 글 수정
				ProcEdit.run();
				break;
			case "6": // 글 검색
				ProcList.search();
				break;
			case "0": // 관리자 모드 (현재 구현되지 않음)
				break;
			case "e": // 프로그램 종료
				Cw.wn("프로그램종료"); // 종료 메시지 출력
				break loop; // 루프 종료, 프로그램 종료
			}
		}
	}
}