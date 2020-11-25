<%@ include file="/WEB-INF/views/nav_cust.jspf"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
   
   <c:set  var="addcart" scope="session" value="${successCart}" />
   <c:if test="${addcart==true }"  >
  	<label for="addedSuccessfully" class="cust-notif-subheading">Item added to Cart successfully</label>
  	</c:if>
    <div class="body">
        <h1 class="body-text-heading">Products</h1>
        <div id="menu-item-customer-result">
        	<table class="table table-bordered">
        		<tr>
        			<th>Name</th>
        			<th>Free Delivery</th>
        			<th>Price</th>
        			<th>Category</th>
        			<th>Action</th>
        		</tr>
        		<c:forEach var="item" items="${menuItemListCustomer}">
        			<tr>
        				<td>${item.name}</td>
        				<td>${item.freeDelivery}</td>
        				<td>${item.price}</td>
        				<td>${item.category}</td>
        				<td><a href="/add-to-cart?menuItemId=${item.id}">Add to Cart</a></td>
        			</tr>
        		
        		</c:forEach>
        	</table>
        </div>
    </div>
    <footer class="footer"><label class="copyright">Copyright © 2020</label></footer>
</body>
</html>