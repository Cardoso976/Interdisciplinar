(function () {
    $("#logar").click(function () {
        $("#login").toggle();
    });

    $("#registro").click(function () {
        //$("#login").modal('hide');				
        $("#registrar").toggle();
    });

    $("#confimar-login").click(function () {        
        var param = {
            usuario: $("#usrname").val(),
            senha: $("#psw").val()
        }
        $.post('/login', param, function () {
            if (response == true) {
                $("#login").toggle();
                bootbox.alert("Bem Vindo" + response);
            } else {
                bootbox.alert("ERRO ao efetuar login");
            }
        });

        bootbox.alert("Olá " + usuario);
        $("#login").modal('toggle');
    });

    $("#cart").click(function () {
        $(".shopping-cart").fadeToggle("fast");
    });
})();