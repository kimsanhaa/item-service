function clickEle(){
    const data = document.getElementById("letter").value;
    console.log(data);
    $.ajax({
        type : "GET",
        url:"transForm",
        data:{"data":data},
        ContentType: "text/html; charset=UTF-8",
        success: function (data){
            console.log(data);
            $("#jpTran").attr('value',data.jpLetter);
            $('input[name=enTran]').attr('value',data.enLetter);
        }
    })
}

$("#letter").keyup(function() {
    var letterLength = $(this).val().length;
    var remain = 500-letterLength;
    console.log(letterLength);
    $("#length").html(remain+'/500');
});

document.getElementById("btn_textarea_copy").onclick = function(){
    const textArea = document.getElementById("letter");
    textArea.select();
    document.execCommand('copy');
}

document.getElementById("btn_enTran_copy").onclick = function(){
    const textArea = document.getElementById("enTran");
    textArea.select();
    document.execCommand('copy');
}
