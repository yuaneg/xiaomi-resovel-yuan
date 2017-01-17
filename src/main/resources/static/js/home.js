$().ready(function() {
	var uploadValidate = $("#uploadValidate").val();
	if (uploadValidate == 'error') {
		layer.msg('只支持上传*.xls和*.xlsx文件格式', function(){
		});
	}
})
/**
 * 文件上传方法
 */
function upload() {
	form1.submit();
	layer.load();
}
