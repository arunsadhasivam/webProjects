 
 
 var xmlhttp =null;
 
 function getxmlRequest(){
	   try{
		   xmlhttp = new XMLHttpRequest();
	   }catch (e){
	      try{
	    	  xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	      }catch (e) {
	         
	         try{
	        	 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	         }catch (e){
	         
	            // Something went wrong
	            alert("Your browser broke!");
	            return false;
	         }
	      }
	   }
	   
	   return xmlhttp;
 }  
 
 
 function renderResponse(url){
	 xmlhttp = getxmlRequest();
	 xmlhttp.onreadystatechange = statechanged;
	 xmlhttp.open('GET', url);
	 xmlhttp.send(null);
	 
 }
 
 function renderMessage(url,message){
	 xmlhttp = getxmlRequest();
	 xmlhttp.onreadystatechange = statechanged;
	 xmlhttp.open('GET', url);
	 xmlhttp.send(null);
	 
 }
 

 
 function statechanged() { 
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		document.getElementById("content").innerHTML = xmlhttp.responseText;
	}
}
 
 
  
 function render(val){
	 var context = document.getElementById('context').value;
	 var url ='';
	 if(val==0){
		 url = context+'/main.jsp';
    	 renderResponse(url);
	 }else if (val ==1 ){
    	 url = context+'/customerMaster.htm';
    	 renderResponse(url);
     }else if (val==2){
    	 url =context +'/getCustomerDetails.htm';	 
    	 renderResponse(url);
     }else if (val==3){
    	 url =context +'/contact.htm';	 
    	 renderResponse(url);
     }else if (val==4){
    	 var message= document.getElementById('message').value;
    	 //param=param+'&load='+ document.getElementById('load').value;;
    	// renderResponse(url+'?status='+param +'&message='+message);
    	 var customerNo = document.getElementById('customerNo').value;
    	 var firstName = document.getElementById('firstName').value;
    	 var lastName = document.getElementById('lastName').value;
    	 var phoneNumber = document.getElementById('phoneNumber').value;
    	 var remarks = document.getElementById('remarks').value;
    	 
    	 
    	 
    	 var param = '&customerNo='+customerNo;
    	 param += '&firstName='+firstName;
    	 param += '&lastName='+lastName;
    	 param += '&phoneNumber='+phoneNumber;
    	 param += '&remarks='+remarks;
    	 
    	 url =context +'/saveCustomerDetails.htm?message='+message+param;	
    	 renderMessage(url);
     }else if(val==5){ 
    	 var custNo= document.getElementById('searchKey').value;
    	 url =context +'/search.htm?custNo='+custNo;	 
    	 renderResponse(url);
     }else {
    	 url =context +'/jsps/error.jsp';	 
    	 renderResponse(url);
     }
	 
 } 
 