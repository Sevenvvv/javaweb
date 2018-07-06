'use strict';

$(function(){

    $('.Lmenu a').hover(function() {
        if($(this).hasClass('active')){
            $(this).prop('class','btn btn-info active');
        }else{
            $(this).prop('class','btn btn-info');
        }
    }, function() {
        if($(this).hasClass('active')){
            $(this).prop('class','btn btn-info active');
        }else{
            $(this).prop('class','btn');
        }
    });

})