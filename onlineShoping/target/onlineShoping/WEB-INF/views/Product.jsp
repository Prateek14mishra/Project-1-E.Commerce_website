<%@ page language="java" contentType="text/html"%>
<%@ include file="temp/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>Products</title>

<form:form action="productInsert" modelAttribute="product" method="post">

	<table align="center" cellspacing="3">

		<tr bgcolour="blue">
			<td colspan="2"><center>Product Manager</center></td>
		</tr>

		<tr>
			<td>Product Name</td>
			<td><form:input path="prodName" /></td>
		</tr>

		<tr>
			<td>Product Desc</td>
			<td><form:input path="prodDesc" /></td>
		</tr>

		<tr>
			<td>Price</td>
			<td><form:input path="price" /></td>
		</tr>

		<tr>
			<td>Stock</td>
			<td><form:input path="stock" /></td>
		</tr>

		<tr>
			<th>Category</th>
			<td><form:select path="categoryId">
					<form:option value="0" label="--Select Category--"></form:option>
					<form:options items="${listcategory}" />
				</form:select></td>
		</tr>

		<tr>
			<th>Supplier</th>
			<td><form:select path="supplierId">
					<form:option value="0" label="--Select Supplier--"></form:option>
					<form:options items="${listSupplier}" />
				</form:select></td>
		</tr>
		<tr>
			<td colspan="2">
				<center>
					<input type="Submit" value="save" class="btn btn-primary">
				</center>
			</td>
		</tr>
	</table>

</form:form>
<div class="container">
	<div class="row">
		<div class="col-sm">
			<table align="center">
				<tr bgcolor="blue">

					<td>Product Id</td>
					<td>Product Name</td>
					<td>Product Description</td>
					<td>Product Price</td>
					<td>Stock</td>
					<td>categoryId</td>
					<td>CategoryName</td>
					<td>supplierId</td>
					<td>SupplierName</td>
					<td>Operations</td>


				</tr>
				</div>
				</div>
				</div>

				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.prodId}</td>
						<td>${product.prodName}</td>
						<td>${product.prodDesc}</td>
						<td>${product.price}</td>
						<td>${product.stock}</td>
						<td>${product.categoryId}</td>
						<td>${product.categoryName}</td>
						<td>${product.supplierId}</td>
						<td>${product.supplierName}</td>
						<td><a
							href="<c:url value='/deleteProduct/${product.prodId}'/>">Delete</a>
							<a href="<c:url value='/editProduct/${product.prodId}'/>">Update</a>
						</td>
					</tr>
				</c:forEach>


			</table>