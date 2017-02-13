Ext.onReady(function(){
	Ext.BLANK_IMAGE_URL = "../Ext/resources/images/default/s.gif";
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget="qtip";
	
	var loginForm = new Ext.FormPanel({
		renderTo:"loginForm",
		id:"loginForm1",
		width:340,
		height:150,
		frame:true,
		labelAlign:"right",
		monitorValid:true,
		items:[
			new Ext.form.TextField({
				id:"username",
				name:"username",
				fieldLabel:"�û���",
				minLength:3,
				minLengthText:"�û������Ȳ���С��{0}",
				maxLength:12,
				maxLengthText:"�û������Ȳ��ܴ���{0}",
				allowBlank:false,
				blankText:"�û�����������"
			}),
			new Ext.form.TextField({
				id:"password",
				name:"password",
				fieldLabel:"����",
				inputType:"password",
				allowBlank:false,
				blankText:"�����������"
			}),
			new Ext.form.TextField({
				id:"randCode",
				name:"randCode",
				width:70,
				fieldLabel:"��֤��",
				allowBlank:false,
				blankText:"��֤���������"
			})
		],
		buttons:[
			{text:"��¼",formBind:true,handler:function(){
				loginForm.getForm().submit({
					url:"login.action",
					waitMsg:"���Եȣ�ϵͳ���ڽ��е�¼!",
					success:function(form, action){
						Ext.MessageBox.alert("�ɹ�",action.result.msg);
						window.location.href="index.html";
					},
					failure:function(form, action){
						Ext.MessageBox.alert("ʧ��",action.result.msg);
					}
				});
			}},
			{text:"����",handler:function(){
//				loginForm.items.itemAt(0).setValue("");
//				loginForm.items.itemAt(1).setValue("");
				loginForm.form.reset();
			}}
		]
	});
	
	var rc = Ext.getDom("randCode");
	var rcp = Ext.get(rc.parentNode);
	rcp.createChild({tag: 'img', src: 'image.jsp',align:'absbottom'});
	
	
	var loginWindow = new Ext.Window({
		width:340,
		height:180,
		title:"������ƹ���ϵͳ�û���¼",
		items:loginForm,
		resizable:false,
		draggable:false,
		closable:false
	});
	loginWindow.show();

});