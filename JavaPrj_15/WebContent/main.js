var tabPanel = new Ext.TabPanel({
	activeTab : 0,//Ĭ�ϼ����һ��tabҳ
	animScroll : true,//ʹ�ö�������Ч��
	enableTabScroll : true,//tab��ǩ����ʱ�Զ����ֹ�����ť
	items: [
		{
			title: '��ӭҳ��',
			height:600,
			closable : false,//����ر�
			html : '<div style="height:600px;padding-top:200px;text-align: center;"><font size = 6>��ӭʹ�ø������ϵͳ</font></div>'
		}
	],listeners:{
		"contextmenu":function(tabPanel,myitem,e){
			var menu = new Ext.menu.Menu([
				{text:"�رյ�ǰѡ��ҳ",handler:function(){
					if(myitem != tabPanel.getItem(0)) {
						tabPanel.remove(myitem)
					}
				}},
				{text:"�ر���������ѡ��ҳ",handler:function() {
						tabPanel.items.each(function(item){
							if(item != myitem && item != tabPanel.getItem(0)) {
								tabPanel.remove(item);
							}
						});
					}
				}
			]);
			menu.showAt(e.getPoint());
		}
	}	
});