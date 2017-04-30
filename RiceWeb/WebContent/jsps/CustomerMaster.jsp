<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />

<form:form name='frmCustMaster' method="POST" modelAttribute="shop"
	action="/RiceWeb/saveCustomerDetails.htm">

	<table style="width: 100%">
		<tr>
			<td>
				<table style="width: 80%;" class="hl7table">
					<tr>
						<td nowrap="nowrap" width="30%" class="tdLabel">Customer No</td>
						<td><form:input width="70%" type="text" path="customerNo" /></td>
					</tr>

					<tr>
						<td class="tdLabel">First Name</td>
						<td><form:input type="text" path="firstName" /></td>
					</tr>

					<tr>
						<td class="tdLabel">Last Name</td>
						<td><form:input type="text" path="lastName" /></td>

					</tr>

					<tr>
						<td class="tdLabel">Noted Name</td>
						<td><form:input type="text" path="notedName" /></td>

					</tr>

					<tr>
						<td class="tdLabel">Father Name</td>
						<td><form:input type="text" path="fatherName" /></td>

					</tr>

					<tr>
						<td class="tdLabel">Phone No</td>
						<td><form:input type="text" path="phoneNumber" /></td>

					</tr>

					<tr>
						<td class="tdLabel">Gender</td>
						<td><form:input type="text" path="gender" /></td>

					</tr>

					<tr>
						<td class="tdLabel">Mobile No</td>
						<td><form:input type="text" path="mobileNo" /></td>

					</tr>

					<tr>
						<td class="tdLabel">Additional Mobile No</td>
						<td><form:input type="text" path="addMobileNumber" /></td>

					</tr>


					<tr>
						<td class="tdLabel">Email ID</td>
						<td><form:input type="text" path="emailID" /></td>

					</tr>


					<tr>
						<td class="tdLabel">Remarks</td>
						<td><form:textarea path="remarks" value="" /></td>
					</tr>
				</table>
			</td>
		</tr>




		<tr>
			<td>
				<table style="width: 50%;" class="hl7table">

					<tr>
						<td colspan="2" align="center"><input type="button" onclick="render('4')"
							name="submit" value="submit" /></td>

						<td colspan="2" align="center"><input type="button"
							name="submit" value="AddAddress" onclick="render('6')" /></td>
					</tr>


					<tr>
						<td colspan="2" align="center"><form:input type="hidden"
								path="message" /> <c:if test="${not empty message}">
								<div id="divMessage">${message}</div>

							</c:if></td>
					</tr>

				</table>
			</td>
		</tr>
	</table>

	<table border="1">
		<tr>
			<td>Street No</td>
			<td>Apt No</td>
			<td>city</td>
			<td>Pincode</td>
			<td>District</td>
		</tr>

		<c:forEach var="address" items="${shop.addressList}" varStatus="result">
			<tr>
				<td><form:input type="text" id="streetName${result.index}"   path="addressList[${result.index}].streetName"  /></td>
				 <td><form:input type="text" id="aptNo${result.index}"  path="addressList[${result.index}].aptNo"  /></td>
				<td><form:input type="text" id="city${result.index}" path="addressList[${result.index}].city"  /></td>
				<td><form:input	  type="text" id ="pincode${result.index}" path="addressList[${result.index}].pincode"/></td>
				<td><form:input type="text" id="district${result.index}" path="addressList[${result.index}].district"/></td>  
			</tr>
			
			
		</c:forEach>
		
		<tr>
		
						<td colspan="5" align="center">
						
						
						<input type="button" onclick="alert('1');render('7')"
							name="Add" value="saveAddress" /></td>
							
		   </tr>
		<%-- <c:forEach var="address" items="${addresslist}" varStatus="result">
				<tr>
					<td> <input type="text"  value="${address.streetName}" /></td>
 					<td><input type="text" value="${address.aptNo}" /></td>
				  <td><input type="text" value="${address.city}" /></td>
					<td><input type="text" value="${address.pincode}" /></td>
					<td><input type="text" value="${address.district}" /></td> 
				</tr>
		</c:forEach> --%>
		
		<tr>
		 <td><input type="text"  id="custSize" value="${shop.addressList.size()}" /></td>
		</tr>
	</table>
</form:form>

