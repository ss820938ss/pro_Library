package pro_Library.maintest;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main_user_login extends JFrame {
	LoginViewU loginViewU;
	USmain usmain;

	public Main_user_login() {
		// 메인클래스 실행
		Main_user_login mainus = new Main_user_login();
		mainus.loginViewU = new LoginViewU(); // 로그인창 보이기
		mainus.loginViewU.setMain(mainus); // 로그인창에게 메인 클래스보내기
	}

	// 테스트프레임창
	public void showFrameTest() {
		loginViewU.dispose(); // 로그인창닫기
		this.usmain = new USmain(); // 테스트프레임 오픈
	}

}