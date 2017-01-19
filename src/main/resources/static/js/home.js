/**
 * 初始化layer
 */
layui.use([ 'layer', 'form' ], function() {
	var layer = layui.layer, 
	form = layui.form();
});

/**
 * 文件上传方法
 */
layui.use('upload', function() {
	layui.upload({
		url : 'uploadfile',
		before : function(input) {
			layer.msg('文件上传中......', {
				  icon: 0,
				  time: 2000 
				}, function(){
				  layer.load();
				});
		},
		success : function(res) {
			layer.closeAll('loading');
			if(res = 'true'){
				layer.msg('上传文件成功');
			} else {
				layer.msg('上传文件失败');
			}
			
		}
	});
});

/**
 * 合并数据下载
 * 
 * @returns
 */
function combine() {
	form2.submit();
	layer.load(0, {
		time : 5 * 1000
	});
}
/**
 * 删除所有数据
 * @returns
 */
function deleteData() {
	$.ajax({  
		url:"delete",
		success:function(ms){
			layer.msg(ms);
		}
	});
}

