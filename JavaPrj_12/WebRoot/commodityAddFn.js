function commodityAdd() {
	//������
	var formPanel = new Ext.form.FormPanel({
		bodyStyle:"padding-left:50px",
		width:400,
		frame:true,
		labelAlign:"right",
		monitorValid:true,
		items:[
			new Ext.form.TextField({
				id:"commodityName",
				name:"commodityName",
				fieldLabel:"��Ʒ����",
				minLength:2,
				minLengthText:"��Ʒ���Ƴ��Ȳ���С��2���ַ�",
				maxLength:12,
				maxLengthText:"��Ʒ���Ƴ��Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"��Ʒ���Ʋ���Ϊ��"
				
			}),
			new Ext.form.NumberField({
				id:"price",
				name:"price",
				fieldLabel:"��Ʒ�۸�",
				allowNegative : false,//���������븺��
				nanText :'��������Ч������',//��Ч������ʾ
				allowDecimals : true,//��������С��
				maxValue : 10000000,//���ֵ
				minValue : 0,//��Сֵ
				minText:"��Ʒ�۸���С��{0}Ԫ",
				maxText:"��Ʒ�۸��ܴ���{0}Ԫ",
				allowBlank:false,
				blankText:"��Ʒ�۸���Ϊ��"
			}),
			new Ext.form.NumberField({
				id:"agio",
				name:"agio",
				fieldLabel:"��Ʒ�ۿ�",
				allowNegative : false,//���������븺��
				nanText :'��������Ч������',//��Ч������ʾ
				allowDecimals : true,//��������С��
				maxValue : 1,//���ֵ
				minValue : 0,//��Сֵ
				minText:"��Ʒ�ۿ۲���С��{0}",
				maxText:"��Ʒ�ۿ۲��ܴ���{0}",
				allowBlank:false,
				blankText:"��Ʒ�ۿ۲���Ϊ��"
			})
		],buttons:[
			{text:"���",formBind:true,handler:function(){
				formPanel.getForm().submit({
					url:"commodityAdd.action",
					waitMsg:"���Ե�,�������!",
					success:function(form, action){
	                        Ext.MessageBox.alert("�ɹ�",action.result.msg); 
	                        formPanel.getForm().reset();
	                 },
					failure:function(form, action){
	                        Ext.MessageBox.alert("ʧ��",action.result.msg);      
	                }
				})

			}},
			{text:"����",handler:function(){
				formPanel.getForm().reset();
			}}
		]
	});
	var commodityAddWindow = new Ext.Window({
		width:400,
		height:150,
		title:"��Ʒ��Ϣ¼��",
		modal:true,
		items:formPanel,
		resizable:false
	});
	
	commodityAddWindow.show();
}