function payOutAddFn(){
	var payOutAddForm = new Ext.FormPanel({
		bodyStyle:"padding-left:230px",
		width:800,
		frame:true,
		labelAlign:"right",
		monitorValid:true,
		items:[
			new Ext.form.TextField({
				id:"payOutName",
				name:"payOutName",
				fieldLabel:"֧������",
				minLength:2,
				minLengthText:"֧�����Ƴ��Ȳ���С��2���ַ�",
				maxLength:12,
				maxLengthText:"֧�����Ƴ��Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"֧�����Ʋ���Ϊ��"
				
			}),
			new Ext.form.NumberField({
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
			}),
			new Ext.form.DateField({
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
		],
		buttons:[
			{text:"���",formBind:true,handler:function(){
				payOutAddForm.getForm().submit({
					url:"addPayOut.action",
					waitMsg:"���Ե�,�������!",
					success:function(form, action){
	                        Ext.MessageBox.alert("�ɹ�",action.result.msg); 
	                    },
					failure:function(form, action){
	                        Ext.MessageBox.alert("ʧ��",action.result.msg);      
	                   }
				})
			}},
			{text:"����",handler:function(){
				payOutAddForm.getForm().reset();
			}}
		]
	});
	
	if(!payOutAddPageIsOpen){
		var tabPage = tabPanel.add({
						title:"֧�����",
						height:150,
						closable:true,
						layout:"fit",
						items:[
							payOutAddForm
						],
						listeners:{
							beforedestroy:function(){
								payOutAddPageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		payOutAddPageIsOpen = true;
	}
}