'use strict'

function checkValue() {
  if (!document.querySelector(".loginId").value) {
    alert("아이디를 입력하세요.");
    return false;
  }

  if (!document.querySelector(".loginPw").value) {
    alert("비밀번호를 입력하세요.");
    return false;
  }

  if (
    document.querySelector(".loginPw").value !==
    document.querySelector(".pwCheck").value
  ) {
    alert("비밀번호가 일치하지 않습니다.");
    return false;
  }

  if (!document.querySelector(".nickname").value) {
    alert("닉네임을 입력하세요.");
    return false;
  }
}


const upbtn = document.querySelector('.upbtn');
// 맨 위로 버튼 보이기/감추기
document.addEventListener('scroll', ()=>{
	const page = document.querySelector('#wrap');
	const pageHeight = page.getBoundingClientRect().height;
	if(window.scrollY > (pageHeight/2)) {
		upbtn.classList.add('visible');
	} else {
		upbtn.classList.remove('visible');
	}
});

// 맨 위로 버튼 클릭시 이동
upbtn.addEventListener('click', ()=>{
	window.scrollTo({top:0, left:0, behavior:'smooth'});
});

