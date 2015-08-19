package com.vmware.talentboost.spring.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.data.UserAccount;

@Component
public class JdbcRepository implements IRepository{
	
	private Connection connection;
	
	private JdbcTemplate jdbcTemplate;
	
	
	// Task 0: Setup your database.
	//			- Create a local database.
	//			- Populate it using the provided script.
	//			- Put your specific values to the database.properties files.
	// Task 1: Take a short look at how currently data retrieval is done.
	// Task 2: Switch to using Spring's database support.
	//			- In the XML create a bean to serve as a data source.
	//			- (optional) Use the database.properties for your strings.
	//			- Add the data source as an argument to the constructor.
	//			- Use Spring's JdbcTemplate instead of Connection.
	//			- Re-factor the methods to work with this JdbcTemplate.
	@Autowired
	public JdbcRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
//		try {
//			Properties properties = new Properties();
//			FileInputStream fis = new FileInputStream("C:\\JavaProjects\\week5_day3_SpringFramework\\spring-database\\src\\main\\resources\\database.properties");
//			properties.load(fis);
//			String user = properties.getProperty("db.user");
//			String pass = properties.getProperty("db.pass");
//			String driver = properties.getProperty("db.driver");
//			String url = properties.getProperty("db.url");
//			Class.forName(driver);
//			connection = DriverManager.getConnection(url, user, pass);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public String getCapitalOf(String country) {
//		String sql = "select capital from capitals where country like ?";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, country);
//			ResultSet rs = stmt.executeQuery();
//			if (rs.next()) {
//				return rs.getString("capital");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
		return this.jdbcTemplate.queryForObject("select capital from capitals where country like ?", String.class, country);
	}
	
	public List<String> getCountries() {
//		String sql = "select country from capitals";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			List<String> countries = new ArrayList<String>();
//			while (rs.next()) {
//				String country = rs.getString("country");
//				countries.add(country);
//			}
//			return countries;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;

		
		return this.jdbcTemplate.queryForList("select country from capitals", String.class);
	}
		
//	}

	public List<UserAccount> getAccounts() {
//		String sql = "select name, role from users, roles where users.role_id=roles.id";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			List<UserAccount> accounts = new ArrayList<UserAccount>();
//			while (rs.next()) {
//				String username = rs.getString("name");
//				String role = rs.getString("role");
//				accounts.add(new UserAccount(username, role));
//			}
//			return accounts;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
		return this.jdbcTemplate.query("select name, role from users, roles where users.role_id=roles.id", new RowMapper<UserAccount>(){
			public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new UserAccount(rs.getString("name"), rs.getString("role"));
			}
		});
		
	}

}
