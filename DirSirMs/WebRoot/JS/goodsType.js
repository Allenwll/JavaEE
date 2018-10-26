$(function(){
	$.ajax({
		type:'POST',
		url:'../typeServlet?action=super',
		success:function(data){
			var json=eval(data);
			for(var i=0;i<json.length;i++){
			$("#supertype").append("<option value='"+json[i].id+"' >"+json[i].typeName+"</option>");
			}
		},
	});


	$("#supertype").bind("change",function(){
		var sid= $(this).val();
		$.ajax({
			type:'POST',
			url:'../typeServlet?action=sub&sid='+sid,
			dataType:'json',
			success:function(data){
				$("#typeID").html("");
				for(var i=0;i<data.length;i++){
					$("#typeID").append("<option value='"+data[i].id+"'>"+data[i].typeName+"</option>");
				}
			},
		});
	});
});