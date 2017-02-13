function consumeAdd(){
	//������
	var formPanel = new Ext.form.FormPanel({
		bodyStyle:"padding-left:50px",
		width:400,
		frame:true,
		labelAlign:"right",
		monitorValid:true,
		items:[
			new Ext.form.NumberField({
				id:"vipId",
				name:"vipId",
				fieldLabel:"vip���",
				allowNegative : false,//���������븺��
				allowDecimals : false,//����������С��
				nanText :'��������Ч������',//��Ч������ʾ
				allowBlank:false,
				blankText:"vipId����Ϊ��",
				listeners:{
					"blur":function(field){
						var name = field.ownerCt.findByType("textfield")[0];
						var vipIdValue = field.value;
						if(vipIdValue != undefined) {
							Ext.Ajax.request({
								url:"getVip.action",
								method:"post",
								params:{
									vipId:vipIdValue
								},
								callback:function(options,success,response) {
									var jsonStr = Ext.util.JSON.decode(response.responseText);
									if(jsonStr.success) {
										name.setValue(jsonStr.vip.name);
									}else {
										Ext.MessageBox.alert("ʧ��",jsonStr.msg);
										name.setValue("");
									}
								}
							})
						}
					}
				}
			}),
			new Ext.form.TextField({
				id:"name",
				name:"name",
				fieldLabel:"����",
				minLength:2,
				minLengthText:"�������Ȳ���С��2���ַ�",
				maxLength:12,
				maxLengthText:"�������Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"��������Ϊ��",
				readOnly:true
				
			}),
			new Ext.form.NumberField({
				id:"commodityId",
				name:"commodityId",
				fieldLabel:"��Ʒ���",
				allowNegative : false,//���������븺��
				allowDecimals : false,//����������С��
				nanText :'��������Ч������',//��Ч������ʾ
				allowBlank:false,
				blankText:"commodityId����Ϊ��",
				listeners:{
					"blur":function(field){
						commodityIdValue = field.value
						var commodityName = field.ownerCt.findByType("textfield")[1];
						var price = field.ownerCt.findByType("numberfield")[2];
						var practicePrice = field.ownerCt.findByType("numberfield")[3];
						if(commodityIdValue != undefined) {
							Ext.Ajax.request({
								url:"getCommodity.action",
								method:"post",
								params:{
									commodityId:commodityIdValue
								},
								callback:function(options,success,response) {
									var jsonStr = Ext.util.JSON.decode(response.responseText);
									if(jsonStr.success) {
										commodityName.setValue(jsonStr.commodity.commodityName);
										price.setValue(jsonStr.commodity.price);
										practicePrice.setValue(jsonStr.commodity.price * jsonStr.commodity.agio );
									}else {
										Ext.MessageBox.alert("ʧ��",jsonStr.msg);
										commodityName.setValue("");
										price.setValue("");
										practicePrice.setValue("");
									}
								}
							})
						}
						
					}
				}
			}),
			new Ext.form.TextField({
				id:"commodityName",
				name:"commodityName",
				fieldLabel:"��Ʒ����",
				minLength:2,
				minLengthText:"��Ʒ���Ƴ��Ȳ���С��2���ַ�",
				maxLength:12,
				maxLengthText:"��Ʒ���Ƴ��Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"��Ʒ���Ʋ���Ϊ��",
				readOnly:true
				
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
				blankText:"��Ʒ�۸���Ϊ��",
				readOnly:true
			}),new Ext.form.NumberField({
				id:"practicePrice",
				name:"practicePrice",
				fieldLabel:"��Ʒʵ�ʼ۸�",
				allowNegative : false,//���������븺��
				nanText :'��������Ч������',//��Ч������ʾ
				allowDecimals : true,//��������С��
				maxValue : 10000000,//���ֵ
				minValue : 0,//��Сֵ
				minText:"��Ʒʵ�ʼ۸���С��{0}Ԫ",
				maxText:"��Ʒʵ�ʼ۸��ܴ���{0}Ԫ",
				allowBlank:false,
				blankText:"��Ʒʵ�ʼ۸���Ϊ��",
				readOnly:true
			})
		],buttons:[
			{text:"���",formBind:true,handler:function(){
				formPanel.getForm().submit({
					url:"consumeAdd.action",
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
	
	var consumeAddWindow = new Ext.Window({
		width:400,
		height:230,
		title:"VIP������Ϣ¼��",
		resizable:false,
		modal:true,
		items:formPanel
	});	
	consumeAddWindow.show();
}