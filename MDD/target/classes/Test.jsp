<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="cache-control" content="no-cache">
		<title>
			test
		</title>
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="jquery-easyui/demo/demo.css">
		
		<!-- JS -->
		<script type="text/javascript" src="jquery-easyui/jquery-2.0.0.js"></script>
		<script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="./js/Test.js" charset=“utf-8”></script>
		
	</head>
	
	<body style="width:100%;height:100%;margin:0;padding:0;overflow:hidden">
		<!--  -->
		<table id="test_display">
			<thead>
				<tr>
					
					<th data-options="field:'id',width:100,align:'center', rowspan:2">
						id
					</th>
					
					<th data-options="field:'cl1',width:100,align:'center', rowspan:2">
						cl1
					</th>
					
					<th data-options="field:'cl2',width:100,align:'center', rowspan:2">
						cl2
					</th>
					
					<th data-options="field:'cl3',width:100,align:'center', rowspan:2">
						cl3
					</th>
					
				</tr>
			</thead>
		</table>
		
		
		<div id="tb" style="padding:5px;height:auto">
			<div style="margin-bottom:5px">
				<a href="#" onclick="newTest()" class="easyui-linkbutton" iconCls="icon-add"
					plain="true">
					添加
				</a>
				<a href="#" onclick="editTest()" class="easyui-linkbutton" iconCls="icon-edit"
					plain="true">
					编辑
				</a>
				<a href="#" onclick="destroyTest()" class="easyui-linkbutton" iconCls="icon-remove"
					plain="true">
					删除
				</a>

			</div>
			<div>
				添加时间
				<input class="easyui-datebox" style="width:80px">
				-
				<input class="easyui-datebox" style="width:80px">
					类型
				<select class="easyui-combobox" panelHeight="auto" style="width:100px">
					<option value="java">
						admin	
					</option>
					<option value="c">
						editor
					</option>
					<option value="basic">
						all
					</option>
				</select>
				
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="query('cl','li')">
					搜索
				</a>
			</div>
		</div>
		

		<div id="testDlg" buttons="#testDlg-buttons" class="easyui-dialog" title="editTest"
			style="width:280px;height:210px;padding:15px" closed="true">

			
			<form id="fm" name="fm" action="admin/Test-inseart">
				
				<table>
					<tr style="display:none">
						<td>
							id
						</td>
						<td>
							<input name="id" style="width:155px" >
						</td>
					</tr>
					
					
					<tr>
						<td>
							cl1
						</td>
						<td>
							<input name="cl1" style="width:155px" >
						</td>
					</tr>
					
					<tr>
						<td>
							cl2
						</td>
						<td>
							<input name="cl2" style="width:155px" >
						</td>
					</tr>
					
					<tr>
						<td>
							cl3
						</td>
						<td>
							<input name="cl3" style="width:155px" >
						</td>
					</tr>
					
					
				
				</table>
				
			</form>
			
			
			<div id="testDlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
					onclick="saveTest()">
					确定
				</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
					onclick="cancel()">
					取消
				</a>
			</div>
			
			
		</div>
	</body>

</html>