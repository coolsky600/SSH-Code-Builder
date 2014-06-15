$(function() {
	$('#test_display').datagrid({
		title: 'test',
		iconCls: 'icon-edit',
		//图标  
		width: 'auto',
		height: 'auto',
		nowrap: false,
		striped: true,
		border: true,
		collapsible: false,
		//是否可折叠的  
		fit: true,
		//自动大小  
		url: 'admin/Test-findByPage',
		onRowContextMenu: onRowContextMenu, 
		//sortName: 'code',  
		//sortOrder: 'desc',  
		remoteSort: false,
		idField: 'id',
		singleSelect: false,
		//是否单选  
		pagination: true,
		//分页控件  
		rownumbers: true,
		//行号
		loadMsg: '数据加载中，请稍后...',
		toolbar: '#tb',
		singleSelect: 'true'
	});
	var p = $('#test_display').datagrid('getPager');
	//设置分页控件  
	$(p).pagination({
		pageSize: 10,
		//每页显示的记录条数，默认为10  
		pageList: [5, 10, 15, 20, 40],
		//每页显示几条记录  
		beforePageText: '第',
		//页数文本框前显示的汉字   
		afterPageText: '页    共 {pages} 页',
		displayMsg: '当前显示 {from} - {to} 条记录    共 {total} 条记录',
		onBeforeRefresh: function() {
			$(this).pagination('数据加载中'); //正在加载数据中...  
			$(this).pagination('加载完毕'); //数据加载完毕  
		}

	});
});


function onRowContextMenu(e, rowIndex, rowData) { //右键时触发事件
    //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
    e.preventDefault(); //阻止浏览器捕获右键事件
    $(this).datagrid("clearSelections"); //取消所有选中项
    $(this).datagrid("selectRow", rowIndex); //根据索引选中该行
    $('#menu').menu('show', {
		//显示右键菜单
        left: e.pageX,//在鼠标点击处显示菜单
            top: e.pageY
        });
}

var url; 
function newTest() {

	$('#testDlg').dialog('open').dialog('setTitle', 'new Test');
	$('#fm').form('clear');
	url = 'admin/Test-insert';
}

function cancel() {

	$('#testDlg').dialog('close');
}

	
function editTest() {
	var row = $('#test_display').datagrid('getSelected');
	if (row) {
		$('#testDlg').dialog('open').dialog('setTitle', '修改');
		$('#fm').form('load', row);
		url = 'admin/Test-update';
	}
}

function saveTest() {
	
	$('#fm').form('submit', {
		url: url,
		onSubmit: function() {
			return $(this).form('validate');
		},
		success: function(result) {
			$.messager.progress('close');
			result =  $.parseJSON(result);
			
			if (result.errorMsg == "0"){
				$('#testDlg').dialog('close');
				$('#test_display').datagrid('reload'); // reload the test data
				$.messager.show({
				 	title:'提示',
					msg:'操作成功',
					showType:'slide'
				 });
			} else {
				$.messager.show({ // show error message
					title: '提示',
					msg: '操作失败'
				});
			}
		}
	});
	 
}

function destroyTest() {
	var row = $('#test_display').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '删除当前条目?',
		function(r) {
			if (r) {
				$.post('admin/Test-delete', {
					id: row.id
				},
				function(data) {
					if (data.errorMsg == "0"){
						$('#testDlg').dialog('close');
						$('#test_display').datagrid('reload'); // reload the test data
						$.messager.show({
						 	title:'提示',
							msg:'删除成功',
							showType:'slide'
						 });
					} else {
						$.messager.show({ // show error message
							title: '提示',
							msg: '删除失败'
						});
					}
				},
				'json');
			}
		});
	}
}


 

