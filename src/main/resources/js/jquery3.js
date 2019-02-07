$(document).ready(function(){

    $(".submenu1").click(function() {
        $("#submenu1").slideToggle("slow");
    });
    $(".submenu2").click(function() {
        $("#submenu2").slideToggle(50, function() {
            alert("KONIEC!");
        });
    });
    $(".submenu3").click(function() {
        $("#submenu3").slideToggle("fast");
    });
});

