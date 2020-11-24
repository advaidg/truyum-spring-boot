<%@ include file="/WEB-INF/views/nav.jspf"%>
    <div class="body">
        <h1 class="body-text-heading" id="">Menu Items</h1>
        <div id="menu-Item-List-Result">
        	<table class="table table-striped">
        	
        		<tr>
        			<th>Name</th>
        			<th>Price</th>
        			<th>Active</th>
        			<th>Date of launch</th>
        			<th>Category</th>
        			<th>Free Delivery</th>
        			<th></th>
        		</tr>
        		
        		<c:forEach var="item" items="${menuItemListAdmin}">
        			<tr>
        				<td>${item.name}</td>
        				<td>${item.price}</td>
        				<td>${item.active}</td>
        				<td>${item.dateOfLaunch}</td>
        				<td>${item.category}</td>
        				<td>${item.freeDelivery}</td>
        				<td><a href="/show-edit-menu-item?menuItemId=${item.id}">Edit</a></td>
        			</tr>
        		
        		</c:forEach>
        	</table>
        </div>
    </div>
    <footer class="footer"><label class="copyright">Copyright © 2020</label></footer>
</body>
</html>