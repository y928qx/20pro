function payOutQueryFn(){
	
	//��¼����
	var payOut = Ext.data.Record.create([
		{name:"id",mapping:"id"},
		{name:"payOutName",mapping:"payOutName"},
		{name:"payOutMoney",mapping:"payOutMoney"},
		{name:"payOutDate",mapping:"payOutDate",type:"date",dateFormat:"Y-m-dTH:i:s"}
	]);
	
	//�洢��
	var store = new Ext.data.Store({
		url:"queryPayOut.action",
		reader:new Ext.data.JsonReader({
			root:"allPayOut",
			id:"id",
			totalProperty:"recordSize"
		},payOut)
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
								["֧������","payOutName"],
								["֧�����","payOutMoney"]
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
	var gridPanel = new Ext.grid.GridPanel({
		width:300,
		height:200,
		frame:true,
		store:store,
		columns:[
			{header:"֧������",dataIndex:"payOutName",sortable:true
			},
			{header:"֧�����",dataIndex:"payOutMoney",sortable:true
			},
			{header:"֧������",dataIndex:"payOutDate",sortable:true,renderer:new Ext.util.Format.dateRenderer("Y��m��d��")
			}
		],
		autoExpandColumn:2,
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
							queryCondition:Ext.get("queryCondition").dom.value, //��ѯ����
							queryValue:Ext.get("queryValue").dom.value   //��ѯֵ
						}});
			}}
		]
	});
	
	store.load({params:{start:0, limit:10}});
	if(!payOutQueryPageIsOpen) {
		var tabPage = tabPanel.add({
						title:"֧����ѯ",
						height:400,
						closable:true,
						layout:"fit",
						items:[
							gridPanel
						],
						listeners:{
							beforedestroy:function(){
								payOutQueryPageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		payOutQueryPageIsOpen = true;
	}
}