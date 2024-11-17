package com.project.imdying;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.project.leebugzz.dao.UserEntityDaoImpl;
import com.project.leebugzz.model.UserEntity;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTests {

	@InjectMocks
	private UserEntityDaoImpl dao;
	
	 @Mock
	    private DataSource ds;
	 
	 @Mock
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	    @Mock
	    private Connection c;

	    @Mock
	    private PreparedStatement stmt;

	    @Mock
	    private ResultSet rs;
	    @Before
	    public void setUp() throws Exception {
	        assertNotNull(ds);
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	@Transactional
    @Rollback(true)
	public void testAddUser() {
		Date date = Date.valueOf("2013-05-06");
		UserEntity user = new UserEntity(1, "first", "last", "abc@gmail.com", date, "female", "role",
				Long.parseLong("986798767"), "cat", "pass", "a", "b", "c");
		Assert.assertEquals(1, user.getUserId());
	}
	
	@Test
	public void testSetLoggedUser() {
		Date date = Date.valueOf("2020-07-16");
		UserEntity loggeduser = new UserEntity(1, "first", "last", "abc@gmail.com", date, "female", "role",
				Long.parseLong("986798767"), "cat", "pass", "a", "b", "c");
		Assert.assertEquals(1, loggeduser.getUserId());
		}
}
