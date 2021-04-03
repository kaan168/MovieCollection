function save(){
	var param ={
		
			
			username:$("#username").val(),
			displayname:$("#displayname").val(),
			password:$("#password").val()
	}
	
	var ser_data =JSON.stringify(param);
	
	$.ajax({
		
		type:"POST",
		contentType:'application/json; charset=UTF-8',
		url:"addUser",
		data:ser_data,
		success:function(data){
			 if(data=='ok'){
				alert("OK");
			}else if (data=="Error"){
				alert("Hata oluştu");  
			}
		},error:function(data){
			alert(data);
		}
	});
	
}