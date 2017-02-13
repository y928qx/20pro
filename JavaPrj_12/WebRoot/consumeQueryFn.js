function consumeQuery(){
	//������������
	var consume = new Ext.data.Record.create([
		{name:"consumeId",mapping:"consumeId"},
		{name:"vipId",mapping:"vip.vipId"},
		{name:"name",mapping:"name"},
		{name:"commodityId",mapping:"commodity.commodityId"},
		{name:"commodityName",mapping:"commodityName"},
		{name:"price",mapping:"price"},
		{name:"practicePrice",mapping:"practicePrice"}
	]);
	
	//�洢��
	var store = new Ext.data.Store({
		url:"consumeQuery.action",
		reader:new Ext.data.JsonReader({
			id:"consumeId",
			root:"allConsume",
			totalProperty:"recordSize"
		},consume)
	});
	
	var gridPanel = new Ext.grid.GridPanel({
		width:585,
		height:375,
		frame:true,
		store:store,
		columns:[
			{header:"vipId",dataIndex:"vipId",sortable:true},
			{header:"����",dataIndex:"name",sortable:true},
			{header:"��ƷId",dataIndex:"commodityId",sortable:true},
			{header:"��ƷName",dataIndex:"commodityName",sortable:true},
			{header:"�۸�",dataIndex:"price",sortable:true},
			{header:"ʵ�ʼ۸�",dataIndex:"practicePrice",sortable:true}
		],
		autoExpandColumn:2,
		selModel:new Ext.grid.RowSelectionModel({singleSelect:true}),
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
		})
	});
	
	store.load({params:{start:0,limit:10}});
	
	//�½�һ��window
	consumeQueryWindow = new Ext.Window({
		width:600,
		height:400,
		title:"VIP������Ϣ��ѯ",
		modal:true,
		resizable:false,
		items:gridPanel
	});
	consumeQueryWindow.show();
}