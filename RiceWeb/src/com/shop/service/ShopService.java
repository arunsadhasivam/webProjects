package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shop.dao.ShopDAO;
import com.shop.domain.Shop;

@Service
public class ShopService {

	@Autowired
	ShopDAO shopDAO;
	
	public int insert(Shop shop){
		int result = 0;
		
		try{
		  shopDAO.saveCustomerDetails(shop);
		}catch(DataAccessException e){
			e.printStackTrace();
			result = -1;
		}
		
		return result;
	}
	
	public List<Shop> getCustomerDetails( ){
		return shopDAO.getCustomerDetails();
	}
	
	public List<Shop> searchCustomer(String custNo ){
		return shopDAO.searchCustomer(custNo);
	}
}
