Ext.BLANK_IMAGE_URL = "Ext/resources/images/default/s.gif";
	//һ������
	var root = new Ext.tree.TreeNode({
		id:"root",
		text:"���ڵ�"
	});
	
	var quanxian;
	DWREngine.setAsync(false);
	Quanxian.getQuanxian(load);
	DWREngine.setAsync(true);
	function load(data) {
		quanxian = data;	
	}
	
	if(quanxian == 1) {
		//�û�����
		var menuUserManager = new Ext.tree.TreeNode({
			id:"MenuUserManager",
			text:"�û�����",
			expanded:true
		});
		
		//�û����
		var userAddMenu = new Ext.tree.TreeNode({
			id:"userAddMenu",
			text:"�û����",
			listeners:{
				"click":userAddFn
			}
		});
		
		//�û�����
		var userManageMenu = new Ext.tree.TreeNode({
			id:"userManageMenu",
			text:"�û�����",
			listeners:{
				"click":userManageFn
			}
		});
		
		//�û���ѯ
		var userQueryMenu = new Ext.tree.TreeNode({
			id:"userQueryMenu",
			text:"�û���ѯ",
			listeners:{
				"click":userQueryFn
			}
		});
		menuUserManager.appendChild(userAddMenu);
		menuUserManager.appendChild(userManageMenu);
		menuUserManager.appendChild(userQueryMenu);
		
		root.appendChild(menuUserManager);
	}
	
	//֧������
	var menuPayOut = new Ext.tree.TreeNode({
		id:"menuPayOut",
		text:"֧������",
		expanded:true
	});
	
	var payOutAddMenu = new Ext.tree.TreeNode({
		id:"payOutAddMenu",
		text:"֧�����",
		listeners:{
			"click":payOutAddFn
		}
	});
	
	var payOutManageMenu = new Ext.tree.TreeNode({
		id:"payOutManageMenu",
		text:"֧������",
		listeners:{
			"click":payOutManageFn
		}
	});
	
	var payOutQueryMenu = new Ext.tree.TreeNode({
		id:"payOutQueryMenu",
		text:"֧����ѯ",
		listeners:{
			"click":payOutQueryFn
		}
	});
	menuPayOut.appendChild(payOutAddMenu);
	menuPayOut.appendChild(payOutManageMenu);
	menuPayOut.appendChild(payOutQueryMenu);
	
	//�������
	var menuIncome = new Ext.tree.TreeNode({
		id:"menuIncome",
		text:"�������",
		expanded:true
	});
	
	var incomeAddMenu = new Ext.tree.TreeNode({
		id:"incomeAddMenu",
		text:"�������",
		listeners:{
			"click":inComeAddFn
		}
	});
	
	var incomeManageMenu = new Ext.tree.TreeNode({
		id:"incomeManageMenu",
		text:"�������",
		listeners:{
			"click":inComeManageFn
		}
	});
	
	var incomeQueryMenu = new Ext.tree.TreeNode({
		id:"incomeQueryMenu",
		text:"�����ѯ",
		listeners:{
			"click":inComeQueryFn
		}
	});
	menuIncome.appendChild(incomeAddMenu);
	menuIncome.appendChild(incomeManageMenu);
	menuIncome.appendChild(incomeQueryMenu);
	
	
	root.appendChild(menuPayOut);
	root.appendChild(menuIncome);
	
	var menu = new Ext.tree.TreePanel({
		border:false,
		rootVisible:false,
		root:root
	});
	
	
	//��Ӳ������͵ı����������жϸ�ҳ���Ƿ��
	var userAddPageIsOpen = false;
	var userManagePageIsOpen = false;
	var userQueryPageIsOpen = false;
	var payOutAddPageIsOpen = false;
	var payOutManagePageIsOpen = false;
	var payOutQueryPageIsOpen = false;
	var inComeAddPageIsOpen = false;
	var inComeManagePageIsOpen = false;
	var inComeQueryPageIsOpen = false;