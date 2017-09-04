<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <div class="container">
   <div class="row">
     <div class="col-md-3">
       <%@ include file="./shared/sidebar.jsp" %>
     </div>
     <div class="col-md-9">
        <div class="row">
           <div class="col-lg-12">
            <c:if test="${userClickAllProducts==true}">
            <script>
            window.categoryId = '${category.id}';
            </script>
             <ol class="breadcrumb">
                <li><a href="${contextRoot}/home">Home</a></li> 
                <li class="active">All Products</li>
           </ol>
           </c:if>
           <c:if test="${userClickCategoryProducts==true}">
             <ol class="breadcrumb">
                <li><a href="${contextRoot}/home">Home</a></li> 
                <li>Category</li>
                <li class="active">${category.name}</li>
           </ol>
           </c:if>
        </div>
     </div>
     
     <div class="row">
      <div class="col-xs-12">
           <table id="productListTable" class="table table-striped tabled-bordered">
               <thead>
                  <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>UnitPrice</th>
                    <th>Quantity</th>
                    <th></th>
                  </tr>
               </thead>
           </table>
      </div>
     </div>
   </div>
 </div>
 </div>
</body>
</html>