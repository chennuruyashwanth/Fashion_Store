package com.fashionStore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashionStore.dao.UserDAO;
import com.fashionStore.model.User;
import com.fashionStore.utility.DBConnection;

public class UserDAOImpl implements UserDAO {

	private static final String INSERT_USER =
			"INSERT INTO users(name,email,phone,password,address,city,state,pincode,country) VALUES(?,?,?,?,?,?,?,?,?)";

	private static final String GET_USER =
			"SELECT * FROM users WHERE user_id=?";

	private static final String GET_USER_BY_EMAIL =
			"SELECT * FROM users WHERE email=?";

	private static final String GET_ALL_USERS =
			"SELECT * FROM users";

	private static final String UPDATE_USER =
			"UPDATE users SET name=?,email=?,phone=?,password=?,address=?,city=?,state=?,pincode=?,country=? WHERE user_id=?";

	private static final String DELETE_USER =
			"DELETE FROM users WHERE user_id=?";

	@Override
	public int addUser(User user) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(INSERT_USER)) {

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getState());
			pstmt.setString(8, user.getPincode());
			pstmt.setString(9, user.getCountry());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public User getUser(int userId) {

		User user = null;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_USER)) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = extractUser(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserByEmail(String email) {
	    User user = null;
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(GET_USER_BY_EMAIL)) {
	        
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            user = new User(
	                rs.getString("name"),
	                rs.getString("email"),
	                rs.getString("phone"),
	                rs.getString("password"),   // <-- must come from DB
	                rs.getString("address"),
	                rs.getString("city"),
	                rs.getString("state"),
	                rs.getString("pincode"),
	                rs.getString("country"),
	                rs.getTimestamp("created_at")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return user; // null if not found
	}


	@Override
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_ALL_USERS);
			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				users.add(extractUser(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public int updateUser(User user) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(UPDATE_USER)) {

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getState());
			pstmt.setString(8, user.getPincode());
			pstmt.setString(9, user.getCountry());
			pstmt.setInt(10, user.getUserId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteUser(int userId) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(DELETE_USER)) {

			pstmt.setInt(1, userId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	private User extractUser(ResultSet rs) throws SQLException {

		User user = new User();

		user.setUserId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setPassword(rs.getString("password"));
		user.setAddress(rs.getString("address"));
		user.setCity(rs.getString("city"));
		user.setState(rs.getString("state"));
		user.setPincode(rs.getString("pincode"));
		user.setCountry(rs.getString("country"));
		user.setCreatedAt(rs.getTimestamp("created_at"));

		return user;
	}
	
	public User validateUser(String email, String password) {

	    User user = null;

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement pstmt =
	                con.prepareStatement(
	                    "SELECT * FROM users WHERE email=? AND password=?")) {

	        pstmt.setString(1, email);
	        pstmt.setString(2, password);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {

	            user = new User();

	            user.setUserId(rs.getInt("user_id")); // VERY IMPORTANT

	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setPhone(rs.getString("phone"));
	            user.setPassword(rs.getString("password"));
	            user.setAddress(rs.getString("address"));
	            user.setCity(rs.getString("city"));
	            user.setState(rs.getString("state"));
	            user.setPincode(rs.getString("pincode"));
	            user.setCountry(rs.getString("country"));
	            user.setCreatedAt(rs.getTimestamp("created_at"));
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}
}