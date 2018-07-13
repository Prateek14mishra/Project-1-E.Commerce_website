<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="temp/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Supplier</title>

<body>

<c:if test="${flag}">

	<form action="${pageContext.request.contextPath}/updateSupplier" method="post">
		<table>
			<tr>
				<td>Supplier Id</td>
				<td><input type="text" readonly="readonly" name="supplierId"
					value="${supplierData.supplierId}" /></td>
			</tr>

			<tr>
				<td>Supplier Name</td>
				<td><input type="text" name="supplierName"
					value="${supplierData.supplierName}" /></td>
			</tr>
			<tr>
				<td>Supplier Address</td>
				<td><input type="text" name="supplierAdd"
					value="${supplierData.supplierAdd}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="Update Supplier" />
					</center>
				</td>
			</tr>
		</table>
	</form>


</c:if>




	<c:if test="${!flag}">
		<form action="InsertSupplier" method="post">
			<table>
				<tr>
					<td>Supplier Name</td>
					<td><input type="text" name="supplierName" /></td>
				</tr>
				<tr>
					<td>Supplier Address</td>
					<td><input type="text" name="supplierAdd" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<input type="submit" value="Insert Supplier" />
						</center>
					</td>
				</tr>
			</table>
		</form>


		<table align="center">
			<tr bgcolor="blue">
				<td>Supplier Id</td>
				<td>Supplier Name</td>
				<td>Supplier Address</td>
				<td>Operations</td>
			</tr>
			<c:forEach items="${supplierlist}" var="supplier">
				<tr>
					<td>${supplier.supplierId}</td>
					<td>${supplier.supplierName}</td>
					<td>${supplier.supplierAdd}</td>
					<td><a
						href="<c:url value='/deleteSupplier/${supplier.supplierId}'/>">Delete</a>
						<a href="<c:url value='/editSupplier/${supplier.supplierId}'/>">Update</a>
					</td>
				</tr>
			</c:forEach>


		</table>
	</c:if>