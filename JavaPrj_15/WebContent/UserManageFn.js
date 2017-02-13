function userManageFn(){
	//��¼����
	var user = Ext.data.Record.create([
		{name:"id",mapping:"id"},
		{name:"username",mapping:"username"},
		{name:"password",mapping:"password"}
	]);
	
	//�洢��
	var store = new Ext.data.Store({
		url:"getUsers.action",
		reader:new Ext.data.JsonReader({
			root:"allUser",
			id:"id",
			totalProperty:"recordSize"
		},user)
	});
	
	var gridPanel = new Ext.grid.EditorGridPanel({
		width:300,
		height:200,
		frame:true,
		store:store,
		columns:[
			{header:"id",dataIndex:"id",sortable:true},
			{header:"�û���",dataIndex:"username",sortable:true,
				editor:new Ext.form.TextField({
					minLength:3,
					minLengthText:"�û������Ȳ���С��3���ַ�",
					maxLength:12,
					maxLengthText:"�û������Ȳ��ܴ���12���ַ�",
					allowBlank:false,
					blankText:"�û�������Ϊ��"
				})
			},
			{header:"����",dataIndex:"password",sortable:true,
				editor:new Ext.form.TextField({
					minLength:3,
					minLengthText:"���볤�Ȳ���С��3���ַ�",
					maxLength:12,
					maxLengthText:"���볤�Ȳ��ܴ���12���ַ�",
					allowBlank:false,
					blankText:"���벻��Ϊ��"
				})
			}
		],
		autoExpandColumn:1,
		//��ҳ������
		bbar:new Ext.PagingToolbar({
			pageSize:10,//ÿҳ��ʾ��������¼
			store:store,//����Դ
			displayInfo:true,
			displayMsg:"��ǰ��ʾ��{0}����{1}����¼��һ����{2}����¼",
			emptyMsg:"û���κμ�¼",
			firstText:"��ҳ",
			prevText:"��һҳ",
			nextText:"��һҳ",
			lastText:"βҳ",
			refreshText:"ˢ��"
		}),
		selModel:new Ext.grid.RowSelectionModel({singleSelect:false}),
		tbar:[
			{
				text:"ɾ��",
				handler:function(){
	 				var rows = gridPanel.getSelectionModel().getSelections();
	 				if(rows.length == 0) {
	 					Ext.MessageBox.alert("����","��ѡ��һ�����ݽ���ɾ��");
	 				} else {
	 					Ext.MessageBox.confirm("��ʾ��","�Ƿ�ȷ��Ҫ����ɾ��!",function(btn){
	 						if(btn == "yes") {
	 							var ids = rows[0].id;
	 							for(var i = 1; i < rows.length; i++) {
	 								ids = ids + "," + rows[i].id;
	 							}
	 							Ext.Ajax.request({
	 								url:"deleteUser.action",//�����ַ
	 								params:{id:ids},
	 								success:function(result){
	 									var jsonStr = Ext.util.JSON.decode(result.responseText)
	 									Ext.MessageBox.alert("�ɹ�",jsonStr.msg);
	 								},
	 								failure:function(result){
	 									var jsonStr = Ext.util.JSON.decode(result.responseText)
	 									Ext.MessageBox.alert("ʧ��",jsonStr.msg);
	 								}
	 							});
	 							
	 							//����ɾ������
	 							for(var i = 0; i < rows.length; i++) {
	 								store.remove(rows[i]);
	 							}
	 						}
	 					});
	 				}
				}
			}
		]
	});
	
	store.load({params:{start:0, limit:10}});
	
	//��EditorGridPanel���afteredit�¼��������
	gridPanel.on("afteredit",function(obj){
		//����֪������Ϣ
		//1.�û���Ϣ��id���������������ѯ��id��Ӧ���û���¼
		var id = obj.record.get("id");
		
		//2.�޸ĵ��ĸ��ֶ�
		var field = obj.field;
		
		//3.�޸ĺ��ֵ�Ƕ���
		var value = obj.value;
		
		//�����첽����
		Ext.Ajax.request({
			//1.����ĵ�ַ
			url:"updateUser.action",
			//2.����ķ�ʽ
			method:"post",
			//3.�������
			params:{
				id:id,
				field:field,
				value:value
			},
			callback:function(options,success,response) {
				var jsonStr = Ext.util.JSON.decode(response.responseText);
				if(jsonStr.success) {
					obj.record.commit();
				}else {
					Ext.MessageBox.alert("ʧ��",jsonStr.msg);
					obj.record.reject();
				}
			}
			
			
		});
	});
	
	if(!userManagePageIsOpen){
		var tabPage = tabPanel.add({
						title:"�û�����",
						height:400,
						closable:true,
						layout:"fit",
						items:[
							gridPanel
						],
						listeners:{
							beforedestroy:function(){
								userManagePageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		userManagePageIsOpen = true;
	}
}