function vipAdd(){
	//����¼���
	var formPanel = new Ext.FormPanel({
		bodyStyle:"padding-left:50px",
		width:400,
		frame:true,
		labelAlign:"right",
		monitorValid:true,
		items:[
			new Ext.form.TextField({
				id:"name",
				name:"name",
				fieldLabel:"����",
				minLength:2,
				minLengthText:"�������Ȳ���С��2���ַ�",
				maxLength:12,
				maxLengthText:"�������Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"��������Ϊ��"
			}),
			new Ext.form.NumberField({
				id:"age",
				name:"age",
				fieldLabel:"����",
				allowNegative : false,//���������븺��
				allowDecimals : false,//����������С��
				nanText :'��������Ч������',//��Ч������ʾ
				maxValue : 100,//���ֵ
				minValue : 1,//��Сֵ
				minText:"���䲻��С��{0}��",
				maxText:"���䲻�ܴ���{0}��",
				allowBlank:false,
				blankText:"���䲻��Ϊ��"
			}),
			new Ext.form.TextField({
				id:"profession",
				name:"profession",
				fieldLabel:"ְҵ",
				minLength:2,
				minLengthText:"ְҵ����С��2���ַ�",
				maxLength:12,
				maxLengthText:"ְҵ���ܴ���12���ַ�",
				allowBlank:false,
				blankText:"ְҵ����Ϊ��"

			}),
			new Ext.form.DateField({
				id:"joinTime",
				name:"joinTime",
				width:130,
				fieldLabel:"���ʱ��",
				maxValue:"12/31/2010",
				minValue:"01/01/2001",
				maxText:"֧�����ڲ��ܴ���{0}",
				minText:"֧�����ڲ���С��{0}",
				format:"Y��m��d��",
				allowBlank:false,
				blankText:"���ʱ�䲻��Ϊ��"
			})
		],buttons:[
			{text:"���",formBind:true,handler:function(){
					formPanel.getForm().submit({
					url:"vipAdd.action",
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
	
	
	//����һ��window
	var vipAddWindow = new Ext.Window({
		width:400,
		height:180,
		title:"VIP��Ϣ¼��",
		modal:true,
		resizable:false,
		items:formPanel
	});
	
	vipAddWindow.show();
}