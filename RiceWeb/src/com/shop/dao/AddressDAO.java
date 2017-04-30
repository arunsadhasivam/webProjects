package com.shop.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.shop.domain.Address;
import com.shop.domain.Shop;

@Repository
public class AddressDAO extends AbstractDAO {
	
	

/*	create table tmp_cust_address(

			streetName varchar(125),
			aptno varchar(10),
			district varchar(10),
			pincode  varchar(10),
			city varchar(10)


			)*/
	public synchronized void  saveCustomerAddress(Shop shop) {
		String sql = "INSERT INTO tmp_cust_address "
				+ "(custNO,"
				+ "streetName,"
				+ "aptno,"
				+ " district, "
				+ "pincode ,"
				+ "city"
				+ ") VALUES (?,?,?,?,?,?)";
		
		final List<Address> addressList= shop.getAddressList();

		try{
			getJdbcTemplate().batchUpdate(sql,new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement prepSt, int index) throws SQLException {
					// TODO Auto-generated method stub
					prepSt.setString(1, shop.getCustomerNo());

					prepSt.setString(2, addressList.get(index).getStreetName());
					prepSt.setString(3, addressList.get(index).getAptNo());
					prepSt.setString(4, addressList.get(index).getDistrict());
					prepSt.setString(5, addressList.get(index).getPincode());
					prepSt.setString(6, addressList.get(index).getCity());


				}
				
				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					return addressList.size();
				}
			});
		}catch(DataAccessException e){
			System.out.println("AddressDAO.saveCustomerDetails()"+e);
		}
	}
	


}
