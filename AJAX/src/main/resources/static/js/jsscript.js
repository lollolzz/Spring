/*헤더 영역*/
  $(function(){

    $('.menu > li > a').mouseenter(function(){                   
        $('header > nav').stop().slideDown(400);
    });

    $('header > nav > div').mouseleave(function(){
        $('header > nav').stop().slideUp(400);
    });
});

/*푸터 영역*/
$(function(){
$(".flex1 > a").click(function(){
$(".popup_bg1").css({"display" : "block"})
})
$(".popup_bg1").click(function(){
$(".popup_bg1").css({"display" : "none"})
})
$(".flex2 > a").click(function(){
$(".popup_bg2").css({"display" : "block"})
})
$(".popup_bg2").click(function(){
$(".popup_bg2").css({"display" : "none"})
})
$(".flex3 > a").click(function(){
$(".popup_bg3").css({"display" : "block"})
})
$(".popup_bg3").click(function(){
$(".popup_bg3").css({"display" : "none"})
})
$(".flex4 > a").click(function(){
$(".popup_bg4").css({"display" : "block"})
})
$(".popup_bg4").click(function(){
$(".popup_bg4").css({"display" : "none"})
})
});

/* about us 영역 */  
$( document ).ready( function() {
    $( 'article[class=smdgks]' ).show("slide", { direction: "right" },700, function() {
      } );
   });


   setInterval(function() { 
    $( 'article[class=dPdms]' ).show("slide", { direction: "right" },700, function() {
      } );
    },200);
    setInterval(function() { 
      $( 'article[class=tlgus]' ).show("slide", { direction: "right" },700, function() {
      } );
    },400);
    setInterval(function() { 
      $( 'article[class=wlsgk]' ).show("slide", { direction: "right" },700, function() {
      } );
    },600);  
