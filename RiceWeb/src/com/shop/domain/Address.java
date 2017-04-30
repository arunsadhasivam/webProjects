package com.shop.domain;

public class Address extends DomainObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String streetName="";

	private String aptNo="";

	private String city="";

	private String pincode="";

	private String district="";

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

		/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the aptNo
	 */
	public String getAptNo() {
		return aptNo;
	}

	/**
	 * @param aptNo the aptNo to set
	 */
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("\naptNo:"+aptNo);
		buffer.append("\nstreetName:"+streetName);
		buffer.append("\ndistrict:"+district);
		
		return buffer.toString();
		
	}
}
