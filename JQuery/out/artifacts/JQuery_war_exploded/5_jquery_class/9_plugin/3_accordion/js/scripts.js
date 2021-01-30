$(function () {

    $('.accordion').accordion({
        event: 'mouseover',
        heightStyle: 'content',  // content,fill,auto(defualt)
        animate: { duration: 1000, easing: 'easeInElastic' }
    });

})  // function(){} END