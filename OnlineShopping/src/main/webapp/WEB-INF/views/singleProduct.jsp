<div class="container">

<div class="row">
  <div class="col-xs-12">
    <ol class="breadcrumb">
      <li><a href="${contextRoot}/home">Home</a></li>
      <li><a href="${contextRoot}/show/all/products">Products</a></li>
      <li class="active">${product.name}</li>
    </ol>
  </div>
</div>

<div class="row">
 <div class="col-sm-4">
     <h3>${product.name}</h3>
     <hr>
     <h3>${product.description}</h3>
     <hr>
     <h4>${product.unitPrice}</h4>
     
     <c:choose>
       <c:when test ="${product.quantity < 1}">
           <h6>Qty Available <span color="red">Out of Stock</span></h6>
       </c:when>
       <c:otherwise>
          <h6>Qty Available ${product.quantity}</h6>
       </c:otherwise>
     </c:choose>
     
     <c:choose>
      <c:when test ="${product.quantity > 1}">
           <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">Add to Cart</a>
       </c:when>
     </c:choose>
     
     
     <a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>
 </div>
</div>
</div>

