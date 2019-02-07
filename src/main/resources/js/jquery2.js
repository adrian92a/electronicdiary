$(document).ready(function(){

    $("#zipCode").change(function() {

        $.getJSON( "json/code.json", function( data ) {
            for(i =0; i < data.length; i++) {
                if($("#zipCode").val() == data[i].kod) {
                    $("#city").val(data[i].miejscowosc);
                    return;
                }
            }
            $("#city").val("nie ma miejscowosci");

        });
    });
});

