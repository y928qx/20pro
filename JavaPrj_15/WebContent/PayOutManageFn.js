
function payOutManageFn(){
	
	//��¼����
	var payOut = Ext.data.Record.create([
		{name:"id",mapping:"id"},
		{name:"payOutName",mapping:"payOutName"},
		{name:"payOutMoney",mapping:"payOutMoney"},
		{name:"payOutDate",mapping:"payOutDate",type:"date",dateFormat:"Y-m-dTH:i:s"}
	]);
	
	//�洢��
	var store = new Ext.data.Store({
		url:"getPayOut.action",
		reader:new Ext.data.JsonReader({
			root:"allPayOut",
			id:"id",
			totalProperty:"recordSize"
		},payOut)
	});
	
	var sm = new Ext.grid.CheckboxSelectionModel();
	var gridPanel = new Ext.grid.EditorGridPanel({
		width:300,
		height:200,
		frame:true,
		store:store,
		columns:[
			sm,
			{header:"֧������",dataIndex:"payOutName",sortable:true,
				editor:new Ext.form.TextField({
					id:"payOutName",
					name:"payOutName",
					fieldLabel:"֧������",
					minLength:2,
					minLengthText:"֧�����Ƴ��Ȳ���С��2���ַ�",
					maxLength:12,
					maxLengthText:"֧�����Ƴ��Ȳ��ܴ���12���ַ�",
					allowBlank:false,
					blankText:"֧�����Ʋ���Ϊ��"
				})
			},
			{header:"֧�����",dataIndex:"payOutMoney",sortable:true,
				editor:new Ext.form.NumberField({
					id:"payOutMoney",
					name:"payOutMoney",
					fieldLabel:"֧�����",
					allowNegative : false,//���������븺��
					nanText :'��������Ч������',//��Ч������ʾ
					allowDecimals : true,//��������С��
					maxValue : 10000,//���ֵ
					minValue : 0,//��Сֵ
					minText:"֧������С��{0}Ԫ",
					maxText:"֧�����ܴ���{0}Ԫ"
				})
			},
			{header:"֧������",dataIndex:"payOutDate",sortable:true,renderer:new Ext.util.Format.dateRenderer("Y��m��d��"),
				editor:new Ext.form.DateField({
				id:"payOutDate",
				name:"payOutDate",
				width:130,
				fieldLabel:"֧������",
				maxValue:"12/31/2009",
				minValue:"01/01/2009",
				maxText:"֧�����ڲ��ܴ���{0}",
				minText:"֧�����ڲ���С��{0}",
				format:"Y��m��d��"
			})
			}
		],
		autoExpandColumn:3,
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
		sm:sm,
		tbar:[
			{
				text:"ɾ��",
				handler:function(){
					//���ѡ����У������Ƕ���
	 				var rows = gridPanel.getSelectionModel().getSelections();
	 				//���û��ѡ���κ��У�����ʾ������Ϥ��
	 				if(rows.length == 0) {
	 					Ext.MessageBox.alert("����","��ѡ��һ�����ݽ���ɾ��");
	 				} else {
	 					//����ȷ����ʾ��
	 					Ext.MessageBox.confirm("��ʾ��","�Ƿ�ȷ��Ҫ����ɾ��!",function(btn){
	 						//ֻ����ȷ�ϵ�����£��Ž���ɾ��
	 						if(btn == "yes") {
	 							//���Ƚ���һ��id��ֵ��ids��
	 							var ids = rows[0].id;
	 							//��������ڶ��У��򶼸�ֵ��ids
	 							for(var i = 1; i < rows.length; i++) {
	 								ids = ids + "," + rows[i].id;
	 							}
	 							//�����첽����
	 							Ext.Ajax.request({
	 								url:"deletePayOut.action",//�����ַ
	 								params:{id:ids},      //������id
	 								success:function(result){  //������������ɹ�
	 									var jsonStr = Ext.util.JSON.decode(result.responseText)
	 									Ext.MessageBox.alert("�ɹ�",jsonStr.msg);
	 								},
	 								failure:function(result){ //��������������ɹ�
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
		//1.֧����Ϣ��id���������������ѯ��id��Ӧ��֧����¼
		var id = obj.record.get("id");
		
		//2.�޸ĵ��ĸ��ֶ�
		var field = obj.field;
		
		//3.�޸ĺ��ֵ�Ƕ���
		var value = obj.value;
		
		if(field == "payOutDate") {
			value = Ext.util.Format.date(value,"Y��m��d��");
		}
		
		//�����첽����
		Ext.Ajax.request({
			//1.����ĵ�ַ
			url:"updatePayOut.action",
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
	
	if(!payOutManagePageIsOpen){
		var tabPage = tabPanel.add({
						title:"֧������",
						height:400,
						closable:true,
						layout:"fit",
						items:[
							gridPanel
						],
						listeners:{
							beforedestroy:function(){
								payOutManagePageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		payOutManagePageIsOpen = true;
	}
}