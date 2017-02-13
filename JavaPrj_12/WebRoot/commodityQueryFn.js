function commodityQuery(){
	
	//������¼����
	var commodity = new Ext.data.Record.create([
		{name:"commodityId",mapping:"commodityId"},
		{name:"commodityName",mapping:"commodityName"},
		{name:"price",mapping:"price"},
		{name:"agio",mapping:"agio"}
	]);
	
	//�洢��
	var store = new Ext.data.Store({
		url:"commodityQuery.action",  //��ַ
		reader:new Ext.data.JsonReader({
			root:"allCommodity",
			id:"commodityId",
			totalProperty:"recordeSize"
		},commodity)
	});
	
	var gridPanel = new Ext.grid.GridPanel({
		width:586,
		height:375,
		frame:true,
		store:store,
		columns:[
			{header:"��ƷId",dateIndex:"commodityId",sortable:true},
			{header:"��Ʒ����",dateIndex:"commodityName",sortable:true},
			{header:"�۸�",dateIndex:"price",sortable:true},
			{header:"�ۿ�",dateIndex:"agio",sortable:true}
		],
		autoExpandColumn:2,
		selModel:new Ext.grid.RowSelectionModel({singleSelect:true}),
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
	store.load({params:{start:0, limit:10}});
	
	//�½�һ��window
	var commodityQueryWindow = new Ext.Window({
		width:600,
		height:400,
		title:"��Ʒ��Ϣ��ѯ",
		resizable:false,
		modal:true,
		items:gridPanel
	});
	
	commodityQueryWindow.show();
};