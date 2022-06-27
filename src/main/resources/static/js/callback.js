var naver_id_login = new naver_id_login("YOUR_CLIENT_ID", "YOUR_CALLBACK_URL");
// 접근 토큰 값 출력
// alert(naver_id_login.oauthParams.access_token);
// 네이버 사용자 프로필 조회
naver_id_login.get_naver_userprofile("naverSignInCallback()");
// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
function naverSignInCallback() {
    $.ajax({
        type : "POST",
        url:"login",
        data:{"email": naver_id_login.getProfileData('email'),"token":naver_id_login.oauthParams.access_token},
        success: function (data){
            console.log("success 함수실행");
            console.log(data);
            $.ajax({
                type:"GET",
                url:"temp"
                }
            )
        },
        error:function (err){
            console.log(err);
        }
    })

    // console.log(naver_id_login.getProfileData('email'));
}