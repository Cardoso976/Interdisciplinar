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
        };
        $.ajax({
            type: "POST", 
            url: '/login',
            dataType: 'JSON',
            data: {
                login: 1,
                param: JSON.stringify(param) // look here!
            },
            success: function (response) {
                alert('sucess');
            },
            error: function (response) {
                alert('fail');
            }
        });

        bootbox.alert("Olá " + usuario);
        $("#login").modal('toggle');
    });

    $("#cart").click(function () {
        $(".shopping-cart").fadeToggle("fast");
    });
})();