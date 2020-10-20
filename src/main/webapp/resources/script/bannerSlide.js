'use strict'

const bannerImg = $("#banner > img");
let current = 0;


setInterval(function(){
	if(current < 4) {
		current++;
	} else {
		current = 0;
	}
	
	bannerImg.eq(current).siblings().fadeOut(1000);
	bannerImg.eq(current).fadeIn(1000);
}, 2500);