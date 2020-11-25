<%@ include file="/WEB-INF/views/nav_cust.jspf"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    <div class="body">
        <h1 class="body-text-heading">Cart</h1>
         <c:set  var="removeCart" scope="session" value="${removeFromCart}" />
        <c:if test="${removeCart==true }"  >
   <label class="cust-notif-subheading">Item removed from Cart successfully</label>
  	</c:if>
        
        <div id="menu-item-customer-result">
        	<table class="table table-bordered">
        		<tr>
        			<th>Name</th>
        			<th>Free Delivery</th>
        			<th>Price</th>
        			
        		</tr>
        		<c:forEach var="item" items="${menuItemListCart}">
        			<tr>
        				<td>${item.name}</td>
        				<td>${item.freeDelivery}</td>
        				<td>${item.price}</td>
        				
        				<td><a href="/remove-cart?menuItemId=${item.id}&userId=1 ">Delete</a></td>
        			</tr>
        		
        		</c:forEach>
        	</table>
    </div>
    </div>
    <footer class="footer"><label class="copyright">Copyright © 2020</label></footer>
</body>
</html>
