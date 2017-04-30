package com.shop.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.shop.domain.Shop;

/**
 * 
 * Class Responsible for Abstracting dao operations
 * 
 * @version 1.0
 *
 */

public abstract class AbstractDAO implements InitializingBean, DisposableBean {

	public JdbcTemplate jdbcTemplate;
	public Shop shop;
	public AbstractDAO() {
		super();
	}


	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}





	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		//Assert.notNull(this.jdbcTemplate, "JDBC must be provided");
		
	
	}

	public void destroy() throws Exception {
		//Assert.notNull(this.mongoTemplate, "DataSource must be provided");
	}


	/**
	 * @return the shop
	 */
	public Shop getShop() {
		return shop;
	}


	/**
	 * @param shop the shop to set
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
