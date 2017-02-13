function userQueryFn(){
	//��¼����
	var user = Ext.data.Record.create([
		{name:"id",mapping:"id"},
		{name:"username",mapping:"username"},
		{name:"password",mapping:"password"}
	]);
	
	//�洢��
	var store = new Ext.data.Store({
		url:"queryUser.action",
		reader:new Ext.data.JsonReader({
			root:"allUser",
			id:"id",
			totalProperty:"recordSize"
		},user)
	});
	
	//��ѯ��
	var queryForm = new Ext.FormPanel({
		labelAlign:"right",
		baseCls: 'x-plain',
		layout:"column",
		items:[
			new Ext.form.Label({
				text:"��ѯ����:"
			}),
			new Ext.form.ComboBox({
				store:new Ext.data.SimpleStore({
							fields:["queryL","queryV"],
							data:[
								["id","id"],
								["�û���","username"],
								["����","password"]
							]
				}),
				triggerAction:"all",
				selectOnFocus:true,
				typeAhead : true,
				displayField:"queryL",
				hiddenName:"queryCondition",
				valueField:"queryV",
				mode:"local",
				readOnly: true
			}),
			new Ext.form.Label({
				text:"��ѯֵ"
			}),
			new Ext.form.TextField({
				id:"queryValue",
				name:"queryValue"
			})
		]
	})
	
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
			queryForm,
			{text:"��ѯ",handler:function(){
				store.load({
					params:
						{
							start:0, limit:10,
							queryCondition:Ext.get("queryCondition").dom.value,
							queryValue:Ext.get("queryValue").dom.value
						}});
			}}
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
	if(!userQueryPageIsOpen){
		var tabPage = tabPanel.add({
						title:"�û���ѯ",
						height:400,
						closable:true,
						layout:"fit",
						items:[
							gridPanel
						],
						listeners:{
							beforedestroy:function(){
								userQueryPageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		userQueryPageIsOpen= true;
	}
}