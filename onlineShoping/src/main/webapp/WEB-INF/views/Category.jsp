<%@ page language="java" contentType="text/html"%>
<%@ include file ="temp/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Category</title>

<c:if test="${flag}">

	<form action="${pageContext.request.contextPath}/updateCategory" method="post">
		<table>
			<tr>
				<td>Categeory Id</td>
				<td><input type="text" readonly="readonly" name="catId"
					value="${categoryData.categoryId}" /></td>
			</tr>

			<tr>
				<td>Categeory Name</td>
				<td><input type="text" name="catName"
					value="${categoryData.categoryName}" /></td>
			</tr>
			<tr>
				<td>Categeory Description</td>
				<td><input type="text" name="catDesc"
					value="${categoryData.categoryDesc}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="Update Category" />
					</center>
				</td>
			</tr>
		</table>
	</form>


</c:if>

<c:if test="${!flag}">
	<form action="InsertCategory" method="post">
		<table>
			<tr>
				<td>Categeory Name</td>
				<td><input type="text" name="catName" /></td>
			</tr>
			<tr>
				<td>Categeory Description</td>
				<td><input type="text" name="catDesc" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="Insert Category" />
					</center>
				</td>
			</tr>
		</table>
	</form>


	<table align="center">
		<tr bgcolor="blue">
			<td>Category Id</td>
			<td>Category Name</td>
			<td>Category Description</td>
			<td>Operations</td>
		</tr>
		<c:forEach items="${categorylist}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.categoryDesc}</td>
				<td><a
					href="<c:url value='/deleteCategory/${category.categoryId}'/>">Delete</a>
					<a href="<c:url value='/editCategory/${category.categoryId}'/>">Update</a>
				</td>
			</tr>
		</c:forEach>


	</table>
</c:if>
</body>
</html>