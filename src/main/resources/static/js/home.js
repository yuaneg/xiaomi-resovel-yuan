$().ready(function() {
	var uploadValidate = $("#validate").val();
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
/**
 * 合并数据下载
 * @returns
 */
function combine(){
	form2.submit();
	layer.load(0,{time: 5*1000});
}
