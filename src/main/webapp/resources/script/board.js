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


// 댓글 수정
function cmtModify(target, url) {
	let targetClass = ".modify" + target;
	let targetForm = document.querySelector(targetClass);
	targetForm.innerHTML =
	"<form method='post' class="+"'modify"+target+"'"+"action='/board/"+url+"/update.do'><input type='hidden' name='id' value=" + target +"><div><span>별점평가 : </span><input type='radio' id='star1' name='star' value='1'><label for='star1'><i class='fas fa-star'></i></label><input type='radio' id='star2' name='star' value='2'><label for='star2'><i class='fas fa-star'></i><i class='fas fa-star'></i></label><input type='radio' id='star3' name='star' value='3'><label for='star3'><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i></label><input type='radio' id='star4' name='star' value='4'><label for='star4'><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i></label><input type='radio' id='star5' name='star' value='5' checked><label for='star5'><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i></label></div><div><textarea class='reply' name='content' placeholder='방문후기를 남겨주세요.'></textarea></div><input type='submit' value='수정완료' onclick='cmtModifySubmit("+target+")'></form>"	
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