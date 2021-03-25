$(function(){


    
    $('.header__slider').slick({
        infinite: true,
        fade: true, 
        prevArrow: '<img class="slider-arrow slider-arrow__left" src="stylesAndSettings/go-surf/images/arrow-left.svg" alt=""></img>',
        nextArrow: '<img class="slider-arrow slider-arrow__right" src="stylesAndSettings/go-surf/images/arrow-right.svg" alt=""></img>',
        asNavFor: '.slider-dots'
    });


    $('.slider-dots').slick({
        slidesToShow: 4,
        slidesToScroll: 4,
        asNavFor: '.header__slider'
    });


    $('.surf-map').slick({
        slidesToShow: 8,
        slidesToScroll: 1,
        arrows: false,
        focusOnSelect: true,
        asNavFor: '.surf-slider'
    });


    $('.surf-slider').slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        prevArrow: '<img class="slider-arrow slider-arrow__left" src="stylesAndSettings/go-surf/images/arrow-left.svg" alt=""></img>',
        nextArrow: '<img class="slider-arrow slider-arrow__right" src="stylesAndSettings/go-surf/images/arrow-right.svg" alt=""></img>',
        asNavFor: '.surf-map'
    }); 


  
});

