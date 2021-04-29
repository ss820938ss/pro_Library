package pro_Library.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.swing.table.DefaultTableModel;
 
public class UserDefaultJTableDAO {
   
    /**
     * 필요한 변수선언
     * */
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
 
    /**
     * 검색단어에 해당하는 레코드 검색하기 (like연산자를 사용하여 _, %를 사용할때는 PreparedStatemnet안된다. 반드시
     * Statement객체를 이용함)
     * */
    public void getUserSearch(DefaultTableModel dt, String fieldName, String word) {
        String sql = "SELECT * FROM Book_Information WHERE " 
        			+ fieldName.trim()
        			+ " LIKE '%" 
        			+ word.trim() 
        			+ "%'";
 
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
 
            // DefaultTableModel에 있는 기존 데이터 지우기
            for (int i = 0; i < dt.getRowCount();) {
                dt.removeRow(0);
            }
 
            while (rs.next()) {
                Object data[] = { rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4) };
 
                dt.addRow(data);
            }
 
        } catch (SQLException e) {
            System.out.println(e + "=> getUserSearch fail");
        } finally {
            dbClose();
        }
 
    }//getUserSearch()

	private void dbClose() {
		// TODO Auto-generated method stub
		
	}
 
}