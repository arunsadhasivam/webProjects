package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.shop.domain.Shop;

/**
 * Class Responsible for CRUD operations
 * @author Arunkumar sadhasivam
 *
 */
@Repository
public class ShopDAO extends AbstractDAO {
	
	/*
	CUSTOMER_ID                               NOT NULL NUMBER
	CUSTOMER_NO                               NOT NULL VARCHAR2(10)
	FIRST_NAME                                         VARCHAR2(50)
	LAST_NAME                                          VARCHAR2(50)
	NOTED_NAME                                         VARCHAR2(30)
	FATHER_NAME                                        VARCHAR2(30)
	PHONE_NUMBER                                       NUMBER(12)
	GENDER                                             CHAR(1)
	MOBILE_NUMBER                                      NUMBER(10)
	MOBILE_NUMBER2                                     NUMBER(10)
	EMAIL_ID                                           VARCHAR2(30)
	REMARKS                                            VARCHAR2(200)
	CREATED_BY                                         VARCHAR2(20)
	CREATION_DATE                                      DATE
	LAST_UPDATED_BY                                    VARCHAR2(20)
	LAST_UPDATE_DATE                                   DATE*/
	
	private static final String SELECT_QUERY= "SELECT * FROM XX_customer_headers order by CUSTOMER_ID";
	
	private static  final String SEARCH= "SELECT * FROM XX_customer_headers where CUSTOMER_NO=? order by CUSTOMER_ID";

	
	public List<Shop> getCustomerDetails(){
		List<Shop> shopList = getJdbcTemplate().query(SELECT_QUERY,new ShopRowMapper());
		if(shopList==null){
			System.out.println("result is null");
		}
		
		
		return shopList;
	}
	
	public synchronized void  saveCustomerDetails(Shop shop) {
//		Integer result = getJdbcTemplate().queryForObject("select xx_cust_addr_id_seq.nextval from dual ",Integer.class);
		String sql = "INSERT INTO XX_customer_headers "
				+ "(CUSTOMER_ID,"
				+ "CUSTOMER_NO,"
				+ " FIRST_NAME, "
				+ "LAST_NAME,"
				+ "NOTED_NAME,"
				+ "FATHER_NAME,"
				+ "PHONE_NUMBER,"
				+ "GENDER,"
				+ "MOBILE_NUMBER,"
				+ "MOBILE_NUMBER2,"
				+ "EMAIL_ID,"
				+ "REMARKS,"
				+ "CREATED_BY,"
				+ "CREATION_DATE,"
				+ "LAST_UPDATED_BY,"
				+ "LAST_UPDATE_DATE"
				+ ") VALUES (xx_cust_addr_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE)";

		try{
			getJdbcTemplate().update(new PreparedStatementCreator() {           
	
	            @Override
	            public PreparedStatement createPreparedStatement(Connection connection)
	                    throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(sql.toString());
	                ps.setString(1, shop.getCustomerNo());
	                ps.setString(2, shop.getFirstName());
	                ps.setString(3, shop.getLastName());
	                ps.setString(4, shop.getNotedName());
	                ps.setString(5, shop.getFatherName());
	                ps.setString(6, shop.getPhoneNumber());
	                ps.setString(7, shop.getGender());
	                ps.setString(8, shop.getMobileNo());
	                ps.setString(9, shop.getAddMobileNumber());
	                ps.setString(10, shop.getEmailID());
	                ps.setString(11, shop.getRemarks());
	                ps.setString(12, "SYSADMIN");
	                ps.setString(13, "ADMIN");
	                return ps;
	            }
			});
		}catch(DataAccessException e ){
			e.printStackTrace();

			throw e;
		}
		
		System.out.println("ShopDAO.saveCustomerDetails():END");
	}
	
	
	
	class ShopRowMapper implements RowMapper<Shop>{

		@Override
		public Shop mapRow(ResultSet rs, int arg1) throws SQLException {
			Shop shop = new Shop ();
			shop.setCustomerId(rs.getString("CUSTOMER_ID"));
			shop.setCustomerNo(rs.getString("CUSTOMER_NO"));
			shop.setFirstName(rs.getString("FIRST_NAME"));
			shop.setFirstName(rs.getString("FIRST_NAME"));
			shop.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			shop.setRemarks(rs.getString("REMARKS"));

			
			return shop;
		}
		
	}
	
	
	
	public List<Shop> searchCustomer(String custNo ){
		List<Shop> shopList= getJdbcTemplate().query(SEARCH,
				new Object[]{custNo},
				new ShopRowMapper());
		
		System.out.println("ShopDAO.searchCustomer()"+shopList.size());
		
		return shopList;
		
	}
	
}
