function inComeQueryFn(){
	if(!inComeQueryPageIsOpen) {
		var tabPage = tabPanel.add({
						title:" ’»Î≤È—Ø",
						height:600,
						closable:true,
						listeners:{
							beforedestroy:function(){
								inComeQueryPageIsOpen = false;
							}
						}
					});
		tabPanel.setActiveTab(tabPage);
		inComeQueryPageIsOpen = true;
	}
}