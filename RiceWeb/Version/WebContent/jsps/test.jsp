
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>

<head>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/defaultTheme.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/layout.css">


</head> 

<div class="grid_10 push_1 alpha omega"  id="tableBlock">
	<div class="fht-table-wrapper fancyTable" style="width: 100%; height: 600px;">
	 
	 
		<div class="fht-thead">
			<table class="fht-table">
				<thead>
					<tr>
						<th>CustomerID<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>Customer No<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>FirstName
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>Last Name
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>Phone NO
							<div class="fht-cell" style="width: 30px;"></div>
						</th>
						<th style="padding-right: 27px;">Remarks
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
					</tr>
				</thead>

			</table>
		</div>


		<div class="fht-tbody" style="height: 522px;">
			<table class="myTable fht-table fht-table-init"
				style="width: 721px;margin-top: -39px;">

				<thead>
					<tr class="fht-table">
						<th>CustomerID
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>Customer No
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>FirstName
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>Last Name
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
						<th>Phone NO
							<div class="fht-cell" style="width: 30px;"></div>
						</th>
						<th>Remarks
							<div class="fht-cell" style="width: 100px;"></div>
						</th>
					</tr>
				</thead>


			<tbody>
					<c:forEach  var="shop" items="${shopList }">
									<tr>
										<td>${shop.customerId}</td>
										<td>${shop.customerNo}</td>
										<td>${shop.firstName}</td>
										<td>${shop.lastName}</td>
										<td>${shop.phoneNumber}</td>
										<td>${shop.remarks}</td>
									</tr>
					</c:forEach>
				</tbody>
		 	</table>
		</div>
  </div>
</div>
 		