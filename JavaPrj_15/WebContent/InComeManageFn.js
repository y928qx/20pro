function inComeManageFn(){
	if(!inComeManagePageIsOpen) {
		var tabPage = tabPanel.add({
						title:"�������",
						height:600,
						closable:true,
						listeners:{
							beforedestroy:function(){
								inComeManagePageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		inComeManagePageIsOpen = true;
	}
}