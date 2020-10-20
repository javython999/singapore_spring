'use strict';

window.onload  = function() {
	const videos = document.getElementsByTagName("video");
	for(let i=0;  i<videos.length; i++) {
		let target = ".vid"+String(i);
		document.querySelector(target).play();
	}
}