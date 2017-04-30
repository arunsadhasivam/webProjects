package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shop.domain.Address;
import com.shop.domain.Shop;
import com.shop.service.ShopService;

/**
 * To get the Patient details.
 * @author arunkumar sadhasivam
 *
 */
@Controller
@SessionAttributes({"shop","custNo"})
public class ShopController {
	
	List<Address> addresslist = new ArrayList<Address>();
	@Autowired
	ShopService shopService;
	public ShopController(){
		System.out.println("PatientController.PatientController()");
	}
	 

	
	
	

	/**
	 * To get the Customer Master Main Entry screen.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/main")
	public ModelAndView main(Model model,@ModelAttribute("shop") Shop shop,HttpServletRequest req) {
		
		ModelAndView mv = new ModelAndView();

		model.addAttribute("shop", shop);
		mv.addObject("shop", shop);//session object

		mv.setViewName("/main.jsp");
		
		return mv;
	}
	

	/**
	 * To search the customer
	 * @param model
	 * @param shop
	 * @param req
	 * @return
	 */
	@RequestMapping("/search")
	public ModelAndView search(Model model,@ModelAttribute("shop") Shop shop,HttpServletRequest req) {
		System.out.println("ShopController.search()");
		ModelAndView mv = new ModelAndView();
		String custNo = req.getParameter("custNo");
		List<Shop> shopList = shopService.searchCustomer(custNo);
		mv.addObject("shopList", shopList);

		model.addAttribute("shop", shop);
		mv.setViewName("/jsps/CustomerDetails.jsp");
		
		return mv;
	}
	
	
	

	/**
	 * To get the Customer Master Main Entry screen.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/customerMaster")
	public ModelAndView customerMaster(Model model) {
		Shop shop  = new Shop();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "");
		model.addAttribute("shop", shop);
		mv.setViewName("/jsps/CustomerMaster.jsp");
		
		return mv;
	}


	/**
	 * To save patient Details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveCustomerDetails")
	public ModelAndView saveCustomerDetails(Model model,HttpServletRequest request,@ModelAttribute("shop") Shop shop) {
		System.out.println("saveCustomerDetails: BEGIN");
		int resut = shopService.insert(shop);
		String message ="Error in insertion...";
		request.setAttribute("savedStatus", 0);
		
		if(resut == 0){
			message ="Customer details inserted Sucessfully";
		}

		request.setAttribute("savedStatus", resut);
		shop.setMessage(message);
		request.setAttribute("message", message);
		//addresslist.clear();//clear after insertion.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/jsps/CustomerMaster.jsp");
		mv.addObject("shop",shop);
		mv.addObject("custNo",shop.getCustomerNo());
		
		return mv;
	}

	
	/**
	 * To Address to customer
	 * @param model
	 * @param shop
	 * @param req
	 * @return
	 */
	@RequestMapping("/addAddress")
	public ModelAndView addAddress(Model model,@ModelAttribute("shop") Shop shop,
			HttpServletRequest request,
			@ModelAttribute("custNo") String custNo,
			HttpServletRequest req) {
		System.out.println("ShopController.Add()");
		ModelAndView mv = new ModelAndView();
		System.out.println("ShopController.addAddress()"+shop.getCustomerNo());
		System.out.println("ShopController.custNo()"+custNo);

		request.setAttribute("savedStatus", 0);

		Address address = new Address();
		shop.getAddressList().add(address);
		model.addAttribute("shop", shop);
		mv.addObject("shop",shop);

		mv.setViewName("/jsps/CustomerMaster.jsp");
		
		return mv;
	}

	
	/**
	 * To Address to customer
	 * @param model
	 * @param shop
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveAddress")
	public ModelAndView saveAddress(Model model,@ModelAttribute("shop") Shop shop,
			HttpServletRequest request) {
		System.out.println("ShopController.Add()"+request.getParameter("addressList[0].streetName"));
		setFormBackingValues(request,shop);
		int resut = shopService.insertAddress(shop);
		String message ="Error in Customer Address details insertion...";
		
		if(resut == 0){

			message ="Customer Address details inserted Sucessfully";
		}else{

		}

		shop.setMessage(message);
		request.setAttribute("message", message);
		//addresslist.clear();//clear after insertion.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/jsps/CustomerMaster.jsp");
		mv.addObject("shop",shop);
		mv.addObject("custNo",shop.getCustomerNo());
		
		return mv;
	}
	
	
	/**
	 * Update values from jsp.
	 * @param request
	 * @param shop
	 * @return
	 */
	private Shop setFormBackingValues(HttpServletRequest request,Shop shop){
   	 
	 int size = shop.getAddressList().size();
	 String streetName = request.getParameter("streetName");
   	 String aptNo = request.getParameter("aptNo");
   	 String city = request.getParameter("city");
   	 String pincode = request.getParameter("pincode");
   	 String district = request.getParameter("district");
   	 
   	 
   	 int sindex= streetName.lastIndexOf(",");
   	 int aptindex= aptNo.lastIndexOf(",");
   	 int cityindex= city.lastIndexOf(",");
   	 int pincodeindex= pincode.lastIndexOf(",");
   	 int districtindex= district.lastIndexOf(",");

   	 
   	 streetName = streetName.substring(0, sindex);
  	 aptNo = request.getParameter("aptNo").substring(0, aptindex);
  	 city = request.getParameter("city").substring(0, cityindex);
  	 pincode = request.getParameter("pincode").substring(0, pincodeindex);
  	 district = request.getParameter("district").substring(0, districtindex);
  	 
   	 	
  	 
  	 String streetNameArr[] = streetName.split(",");
  	 String aptNoArr[] = aptNo.split(",");
  	 String cityArr[] = city.split(",");
  	 String pincodeArr[] = pincode.split(",");
  	 String districtArr[] = district.split(",");;
  	 
   	 
	 for(int i =0;i<size;i++){
		
	   	 
		 Address address = shop.getAddressList().get(i);	
		 address.setStreetName(streetNameArr[i]);
		 address.setAptNo(aptNoArr[i]);
		 address.setCity(cityArr[i]);
		 address.setPincode(pincodeArr[i]);
		 address.setDistrict(districtArr[i]);

	 }
		
		return shop;
	}


	
	/**
	 * To get the Patient details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/getCustomerDetails")
	public ModelAndView getCustomerDetails(Model model,HttpServletRequest req) {
		System.out.println("ShopController.getCustomerDetails()");
		List<Shop> shopList = shopService.getCustomerDetails();

		ModelAndView mv = new ModelAndView();
		mv.addObject("status", 1);
		mv.addObject("shopList", shopList);
		mv.setViewName("/jsps/CustomerDetails.jsp");
		
		return mv;
	}

	

	
	/**
	 * To get the Patient Insurance details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/contact")
	public ModelAndView getInsuranceDetails(Model model,HttpServletRequest req) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/jsps/contact.jsp");
		
		return mv;
	}
}
