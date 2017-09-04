$(function() {
	switch (menu) {

	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if(menu == "Home") 
		break;
		$('#listProducts').addClass('active');
	    $('#a_'+menu).addClass('active');
		break;
	}

	
	
	var $table = $('#productListTable');
	if ($table.length){
	//	console.log('Inside the Table');
		var jsonurl='';
		if(window.categoryId==''){
			jsonurl = window.contextRoot+'/json/data/all/products';
		}
		else{
			jsonurl = window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records', '10 Records', 'All']],
			pageLength:5,
			ajax:{
				url:jsonurl,
				dataSrc:''},
				columns:[
				         {
				        	 data:'code',
				        	 bSortable:false,
				        	 mRender:function(data,type,row){
				        		 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg"/>';
				        	 }
				         },
				         
				         {
				        	 data:'name'
				         },
				         {
				        	 data:'brand'
				         },
				         {
				        	 data:'unitPrice',
				        	 mRender: function(data,type,row){
				        		 return '&#8377;  '+data
				        	 }
				         },
				         {
				        	 data:'quantity',
				        	 mRender: function(data,type,row){
				        		 if(data<1){ return '<span style="color:red">Out of Stock</span>'; }
				        		 return data;
				        	 }
				            
				         },
				         {
				        	 data:'id',
				        	 bSortable:false,
				             mRender: function(data,type,row){
				            	 var str = '';
				            	 str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&#160;' ;
				            	 if(row.quantity>1)
				            	 {str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>' ;}
				            	 return str;
				             }
				         
				         }
				         ]
			
		}
				);
	}
});