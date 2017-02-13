function vipQuery(){
	//��¼����
	var vip = new Ext.data.Record.create([
		{name:"vipId",mapping:"vipId"},
		{name:"name",mapping:"name"},
		{name:"age",mapping:"age"},
		{name:"profession",mapping:"profession"},
		{name:"joinTime",mapping:"joinTime",type:"date",dateFormat:"Y-m-dTH:i:s"}
	]);
	
	//�洢��
	var store = new Ext.data.Store({
		url:"vipQuery.action",
		reader:new Ext.data.JsonReader({
			id:"vipId",
			root:"allVip",
			totalProperty:"recordSize"
		},vip)
	});
	
	var gridPanel = new Ext.grid.GridPanel({
		width:585,
		height:375,
		frame:true,
		store:store,
		columns:[
			{header:"VIPID",dataIndex:"vipId",sortable:true},
			{header:"����",dataIndex:"name",sortable:true},
			{header:"����",dataIndex:"age",sortable:true},
			{header:"ְҵ",dataIndex:"profession",sortable:true},
			{header:"���ʱ��",dataIndex:"joinTime",sortable:true,renderer:new Ext.util.Format.dateRenderer("Y��m��d��")}
		],
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
	
	var vipQueryWindow = new Ext.Window({
		width:600,
		height:400,
		title:"VIP��Ϣ��ѯ",
		modal:true,
		resizable:false,
		items:gridPanel
	});	
	
	vipQueryWindow.show();
};