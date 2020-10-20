'use strict'

function checkValue() {
  if (!document.querySelector(".inputId").value) {
    alert("아이디를 입력하세요.");
    return false;
  }

  if (!document.querySelector(".inputPw").value) {
    alert("비밀번호를 입력하세요.");
    return false;
  }

  if (
    document.querySelector(".inputPw").value !=
    document.querySelector(".inputPwc").value
  ) {
    alert("비밀번호가 일치하지 않습니다.");
    return false;
  }

  if (!document.querySelector(".inputNic").value) {
    alert("닉네임을 입력하세요.");
    return false;
  }

  if (!document.querySelector(".inputName").value) {
    alert("이름을 입력하세요.");
    return false;
  }

  if (!document.querySelector(".inputEmail").value) {
    alert("이메일을 입력하세요.");
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

