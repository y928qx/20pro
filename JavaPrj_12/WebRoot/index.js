Ext.onReady(function(){
	Ext.BLANK_IMAGE_URL = "Ext/resources/images/default/s.gif";
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget="qtip";
	
	var mainWindow = new Ext.Window({
		width:600,
		height:400,
		title:"�̳�VIP���������ѯϵͳ",
		closable:false,
		resizable:false, //�����Ƿ���Ըı��С
		draggable:false,  //�����Ƿ�����϶�
		tbar:new Ext.Toolbar({
			height:25
		})
	});
	mainWindow.show();
	
	//��Ʒ��Ϣ����˵�
	var commodityMenu = new Ext.menu.Menu({
		items:[
			{text:"��Ʒ��Ϣ¼��",handler:commodityAdd},
			{text:"��Ʒ��Ϣ��ѯ",handler:commodityQuery}
		]
	});
	
	//VIP��Ϣ����˵�
	var vipMenu = new Ext.menu.Menu({
		items:[
			{text:"VIP��Ϣ¼��",handler:vipAdd},
			{text:"VIP��Ϣ��ѯ",handler:vipQuery},
			{text:"VIP������Ϣ¼��",handler:consumeAdd},
			{text:"VIP������Ϣ��ѯ",handler:consumeQuery}
		]	
	});
	
	
	mainWindow.getTopToolbar().add(new Ext.SplitButton({
		text:"��Ʒ��Ϣ����",
		menu:commodityMenu
	}));
	
	
	mainWindow.getTopToolbar().add(new Ext.SplitButton({
		text:"VIP��Ϣ����",
		menu:vipMenu
	}));
	
	mainWindow.getTopToolbar().add(new Ext.Button({
		text:"ϵͳά��"
	}));
	
	mainWindow.getTopToolbar().add(new Ext.Button({
		text:"����",
		handler:function showHelpWindow(){
			var myToolBar = new Ext.Toolbar({
				listeners:
						  {
						    'render':function(t)
						    {
						       t.getEl().child("table").wrap({tag:'center'});
						    }
						},
				items:[
					{text:"�ر�",handler:function helpWindowClose(){
							helpWindow.close();
						}
					}
				]		
						
			});
			
			var helpPanel = new Ext.Panel({
					height:283,
					html:"<center><font size='3'><B>��ϵͳ����Ҫ����</B></font></center>" +
							"<h2>��	��¼</h2>" +
							"��ϵͳΪ�̳�VIP���������ѯϵͳ������һ���ı����ԡ���˱���Ҫ��һ����Ȩ�޲���ʹ�ñ�ϵͳ��ѯ��Ҫ���в�ѯ�ͱ����ȵ�¼����ʹ�ñ�ϵͳ����¼֮�����ϵͳ�������棬�����������ѡ���û���Ҫִ�еĹ���ģ�顣" +
							"<h2>��	��Ʒ��Ϣ¼��</h2>" +
							"��ά����ϵͳʱ��Ҫ���ϸ���ϵͳ�����ݡ�������Ʒ����Ϣ���ڲ������ӵģ����½���Ʒʱ��Ҫ��֤��Ʒ��Ϣ��ͬ�����¡��ڱ�ģ��ɽ��½���Ʒ����Ϣ¼�뱣���ڷ����������ݿ��С�" +
							"<h2>��	��Ʒ��Ϣ��ѯ</h2>" +
							"��ʱ�����˽�ĳ����Ʒ����ϸ��Ϣ���ڱ�ģ����Բ�ѯ����֪������Ʒ����ϸ��Ϣ��",
					bbar:myToolBar
			});
			
			var helpWindow = new Ext.Window({
				width:400,
				height:300,
				items:helpPanel,
				resizable:false,
				draggable:false,
				modal:true
			});
			helpWindow.show();
		}
	}));
	
	mainWindow.getTopToolbar().add(new Ext.Button({
		text:"�˳�",
		handler:function pExit(){
			window.close();
		}
	}));
	
	
	//��¼��
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
						loginWindow.close();
					},
					failure:function(form, action){
						Ext.MessageBox.alert("ʧ��",action.result.msg);
					}
				});
			}},
			{text:"����",handler:function(){
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
		title:"�û���¼",
		items:loginForm,
		resizable:false,
		draggable:false,
		closable:false,
		modal:true
	});
	loginWindow.show();
	
});