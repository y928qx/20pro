Ext.onReady(function(){
	Ext.BLANK_IMAGE_URL = "Ext/resources/images/default/s.gif";
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget="qtip";
	
	Ext.apply(Ext.form.VTypes,{
		//field��ʾ�����������val�Ǹ�������ֵ
		repetition:function(val,field) {
			//�Ƿ���������Ƚϵ�Ŀ�����
			if(field.repetition){
				//��ø�Ŀ�����
				var cmp = Ext.getCmp(field.repetition.targetCmpId);
				if(Ext.isEmpty(cmp)){
					Ext.MessageBox.show({
						title: '����',
                     	msg: '�����쳣����ָ�������δ�ҵ�',
                      	icon: Ext.Msg.ERROR,
                      	buttons: Ext.Msg.OK
					});
				}
				//�Ƚ�������Ŀ������ֵ
				if(val == cmp.getValue()) {
					return true;
				} else {
					return false;
				}
			}
		},
		repetitionText:"���������ֵ����ͬ"
	});
	
	var viewPort = new Ext.Viewport({
		title:"�������ϵͳ",
		layout:"border",
		items:[
			{
				title:"������",
				region:"north",
				height:100,
				collapsible:true,
				html:"<br><center><font size = 6>�������ϵͳ</font></center>"
			},
			{
				title:"������",
				region:"west",
				width:200,
				items:menu,
				collapsible:true,
				split:true
			},
			{
				title:"������",
				region:"center",
				items:tabPanel,
				collapsible:true
			}
		]
	});
});