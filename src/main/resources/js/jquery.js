$(document).ready(function(){
    $(".rectangle-menu").mouseenter(function(){
        $(this).stop();
        $(this).animate({left: 0}, 1000);
    });
    $(".rectangle-menu").mouseleave(function(){
        $(this).stop();
        $(this).animate({left: -280}, 1000);
    });
});