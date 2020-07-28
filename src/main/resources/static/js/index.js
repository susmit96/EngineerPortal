 var formParams = $("#register-form").serialize();

 $(document).ready(function(){
    $(".btn-submit").on("click",function(){
        $.ajax({
            url:"/",
            type:"POST",
            dataType: 'json',
            data:formParams
        }).done(function(){
            alert("success");
        }).fail(function(){
            alert("fail");
        });
    });
 });