$(function(){
	$("#logar").click(function(){	
		$("#login").toggle();		
	});

	$("#registro").click(function(){
		//$("#login").modal('hide');				
		$("#registrar").toggle();				
	});

	$("#confimar-login").click(function(){

		var senha = $("#psw").val();
		var usuario = $("#usrname").val();

		bootbox.alert("Olá " + usuario);
		$("#login").modal('toggle');	
	});

	$("#cart").click(function() {
		$(".shopping-cart").fadeToggle("fast");
	});	
})();