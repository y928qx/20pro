function inComeAddFn(){
	if(!inComeAddPageIsOpen){
		var tabPage = tabPanel.add({
						title:"�������",
						height:600,
						closable:true,
						listeners:{
							beforedestroy:function(){
								inComeAddPageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		inComeAddPageIsOpen = true;
	}
}