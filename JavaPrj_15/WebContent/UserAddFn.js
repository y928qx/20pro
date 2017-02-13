function userAddFn(){
	
	Ext.form.VTypes.repetitionText="�����ȷ�����벻һ��";
	
	var userAddForm = new Ext.FormPanel({
		bodyStyle:"padding-left:230px",
		width:800,
		frame:true,
		labelAlign:"right",
		monitorValid:true,
		items:[
			new Ext.form.TextField({
				id:"username",
				name:"username",
				fieldLabel:"�û���",
				minLength:3,
				minLengthText:"�û������Ȳ���С��3���ַ�",
				maxLength:12,
				maxLengthText:"�û������Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"�û�������Ϊ��"
				
			}),
			new Ext.form.TextField({
				id:"password",
				name:"password",
				fieldLabel:"����",
				inputType:"password",
				minLength:3,
				minLengthText:"���볤�Ȳ���С��3���ַ�",
				maxLength:12,
				maxLengthText:"���볤�Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"���벻��Ϊ��"
			}),
			new Ext.form.TextField({
				id:"repassword",
				name:"repassword",
				fieldLabel:"ȷ������",
				inputType:"password",
				minLength:3,
				minLengthText:"ȷ�����볤�Ȳ���С��3���ַ�",
				maxLength:12,
				maxLengthText:"ȷ�����볤�Ȳ��ܴ���12���ַ�",
				allowBlank:false,
				blankText:"ȷ�����벻��Ϊ��",
				vtype:"repetition",
				repetition:{targetCmpId:"password"}
			})
		],
		buttons:[
			{text:"���",formBind:true,handler:function(){
				userAddForm.getForm().submit({
					url:"userAdd.action",
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
				userAddForm.getForm().reset();
			}}
		]
	});
	
	if(!userAddPageIsOpen){
		var tabPage = tabPanel.add({
						title:"�û����",
						height:150,
						layout:"fit",
						closable:true,
						items:[
							userAddForm	
						],
						listeners:{
							beforedestroy:function(){
								userAddPageIsOpen = false;
							}
						}
			});
		tabPanel.setActiveTab(tabPage);
		//���ø�ҳ���Ѿ���
		userAddPageIsOpen = true;
	}
}