package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro_Library.dao.BookDeinfoDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.BookDeinfo;

public class BookDeinfoDaoImpl implements BookDeinfoDao {
	private static BookDeinfoDaoImpl instance = new BookDeinfoDaoImpl();

	public static BookDeinfoDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<BookDeinfo> selectBookDeinfoByAll() {
		String sql = "selct B_NO, B_NAME, B_DIVISION, B_IMG from Book_Dinfo";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<BookDeinfo> list = new ArrayList<BookDeinfo>();
				do {
					list.add(getBookDeinfo(rs));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	////// List<BookDeinfo> selectBookDeinfoByAll() >> getBookDeinfo
	private BookDeinfo getBookDeinfo(ResultSet rs) throws SQLException {
		int bNo = rs.getInt("B_NO");
		String bName = rs.getString("B_NAME");
		String bDivision = rs.getString("B_DIVISION");
		String bImg = rs.getString("bImg");

		return new BookDeinfo(bNo, bName, bDivision, bImg);
	}

	////// list
	@Override
	public List<BookDeinfo> selectBookDeinfoBybNo(BookDeinfo bookbeinfo) {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_IMG from Book_Dinfo" + 
					 " where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookbeinfo.getbNo());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookDeinfo> list = new ArrayList<BookDeinfo>();
					do {
						list.add(getBookDeinfo(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookDeinfo> selectBookDeinfoBybName(BookDeinfo bookbeinfo) {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_IMG from Book_Dinfo" + 
					 " where B_NAME = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, bookbeinfo.getbName());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookDeinfo> list = new ArrayList<BookDeinfo>();
					do {
						list.add(getBookDeinfo(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookDeinfo> selectBookDeinfoBybDivision(BookDeinfo bookbeinfo) {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_IMG from Book_Dinfo" + 
					 " where B_DIVISION = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, bookbeinfo.getbDivision());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookDeinfo> list = new ArrayList<BookDeinfo>();
					do {
						list.add(getBookDeinfo(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookDeinfo> selectBookDeinfoBybImg(BookDeinfo bookbeinfo) {
		String sql = "selct B_NO, B_NAME, B_DIVISION, B_IMG from Book_Dinfo" + 
				 	 "where B_IMG = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, bookbeinfo.getbImg());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookDeinfo> list = new ArrayList<BookDeinfo>();
					do {
						list.add(getBookDeinfo(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	////// bNo
	@Override
	public BookDeinfo selectBookDeinfoBybbNo(int bNo) {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_IMG from Book_Dinfo" + 
				 	 "where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bNo);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBookDeinfo(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	////// inset, update, delete
	@Override
	public int insertBookDeinfo(BookDeinfo bookdeinfo) {
		String sql = "insert into Book_Dinfo(B_NO, B_NAME, B_DIVISION, B_IMG) values(?, ?, ?, ?)";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookdeinfo.getbNo());
			pstmt.setString(2, bookdeinfo.getbName());
			pstmt.setString(3, bookdeinfo.getbDivision());
			pstmt.setString(4, bookdeinfo.getbImg());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBookDeinfo(BookDeinfo bookdeinfo) {
		String sql = "update Book_Dinfo" + 
					 "   set B_NO = ?, B_NAME = ?, B_DIVISION = ?, B_IMG = ?" + 
					 " where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookdeinfo.getbNo());
			pstmt.setString(2, bookdeinfo.getbName());
			pstmt.setString(3, bookdeinfo.getbDivision());
			pstmt.setString(4, bookdeinfo.getbImg());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBookDeinfo(int bNo) {
		String sql = "delete from Book_Dinfo where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}