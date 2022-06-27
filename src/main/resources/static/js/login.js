var naver_id_login = new naver_id_login("gk853E_mlwkUP8w3K0Zg", "http://localhost:8080/callback");
var state = naver_id_login.getUniqState();
naver_id_login.setButton("black", 2,40);
naver_id_login.setDomain("http://localhost:8080/login");
naver_id_login.setState(state);
naver_id_login.setPopup();
naver_id_login.init_naver_id_login();