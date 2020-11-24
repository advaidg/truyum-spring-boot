<%@ include file="/WEB-INF/views/nav.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="body">
	<h2 class="body-text-heading">Edit Menu Item</h2>
	<form:form method="POST" modelAttribute="menuItem"
		action="/edit-menu-item">
		<form:hidden path = "id" value="${menuItem.id}"/>
		<form:label path="name" name="">Name</form:label>
		<form:input path="name" type="text" />
		<br>
		<form:label path="price">Price (Rs.)</form:label>
		<form:input path="price" type="text" />
		<br>


		<form:label path="active">Active</form:label>
		<form:radiobutton path="active" value="Yes" />Yes
				<form:radiobutton path="active" value="No" />No
				<br>
		<form:label path="dateOfLaunch">Date Of Launch</form:label>
		<form:input path="dateOfLaunch" />
		<br>
		<form:label path="category">Category</form:label>
		<form:select path="category" items="${categoryList}"></form:select>
		<br>
		<form:label path="freeDelivery">Free Delivery</form:label>
		<form:checkbox path="freeDelivery" />
		<br>
		<input type="submit" value="Save" id="submit" class="btn btn-success"/>

	</form:form>
</div>
<footer class="footer">
	<label class="copyright">Copyright © 2020</label>
</footer>
</body>
</html>