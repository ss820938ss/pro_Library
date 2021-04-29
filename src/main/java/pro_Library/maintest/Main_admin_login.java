package pro_Library.maintest;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main_admin_login extends JFrame {
    LoginViewA loginViewA;
    ADmain admain;

	public static void main(String[] args) {

		// 메인클래스 실행
		Main_admin_login mainad = new Main_admin_login();
		mainad.loginViewA = new LoginViewA(); // 로그인창 보이기
		mainad.loginViewA.setMain(mainad); // 로그인창에게 메인 클래스보내기
	}
	
    // 테스트프레임창
    public void showFrameTest(){
    	loginViewA.dispose(); // 로그인창닫기
        this.admain = new ADmain(); // 테스트프레임 오픈
    }
 
}
	
