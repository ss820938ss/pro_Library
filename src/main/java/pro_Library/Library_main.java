package pro_Library;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Library_main extends JFrame {

	LoginView loginView;
	Main_master testFrm;
	Main_guest guest;

	public static void main(String[] args) {

		// 메인클래스 실행
		Library_main main = new Library_main();
		main.loginView = new LoginView(); // 로그인창 보이기
		main.loginView.setMain(main); // 로그인창에게 메인 클래스보내기
	}

	// 테스트프레임창
	public void showFrameTest() {
		loginView.dispose(); // 로그인창닫기
		this.testFrm = new Main_master(); // 테스트프레임 오픈
	}

}