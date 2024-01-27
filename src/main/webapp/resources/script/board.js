'use strict';
// 댓글 삭제
function askDelete(target) {
	let targetClass = ".commentContents" + target;
	let targetForm = document.querySelector(targetClass);
	if(confirm("삭제 하시겠습니까?")) {
		targetForm.submit();
	} else {
		return false;
	}
}


function cmtModifySubmit(target) {
	let targetClass = ".modify" + target;
	let targetForm = document.querySelector(targetClass);
	if(confirm("수정 하시겠습니까?")) {
		document.querySelector(targetForm).submit();
	} else {
		return false;
	}
}

function checkValue() {
	if (!document.querySelector(".reply").value) {
		alert("댓글을 작성해주세요.");
		return false;
	}
}