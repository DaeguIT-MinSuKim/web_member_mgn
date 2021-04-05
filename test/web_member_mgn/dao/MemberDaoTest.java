package web_member_mgn.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import web_member_mgn.dao.impl.MemberDaoImpl;
import web_member_mgn.ds.JndiDS;
import web_member_mgn.dto.Member;

public class MemberDaoTest {
	private static Connection con;
	private MemberDaoImpl dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//MemberDaoTest.java 가 수행되기 전 호출
		con = getConnection();
	}

	@Before
	public void setUp() throws Exception {
		//Test method가 호출되기 전에 호출
		dao = MemberDaoImpl.getInstance();
		dao.setCon(con);
	}

	@Test
	public void testSelectMemberByIdSuccess() {
		System.out.println("testSelectMemberById()-Success");
		Member member = new Member("1", "1111");
		Member memberLogin = dao.selectMemberById(member);
		System.out.println("memberLogin : " + memberLogin);
		Assert.assertNotNull(memberLogin);
	}

	@Test
	public void testSelectMemberByIdFail() {
		System.out.println("testSelectMemberById()-Fail");
		Member member = new Member("1", "1112");
		Member memberLogin = dao.selectMemberById(member);
		System.out.println("memberLogin : " + memberLogin);
		
		Assert.assertNull(memberLogin);
	}
	
	private static Connection getConnection() {
		Connection con = null;
		try{
			String url = "jdbc:mysql://localhost:3306/native_jdbc?useSSL=false";
			String id = "user_native_jdbc";
			String passwd = "rootroot";
			con = DriverManager.getConnection(url, id, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
