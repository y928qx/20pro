function check(){
	//����
	if(news.headTitle.value == ""){
		alert("���������");
		news.HeadTitle.focus();
		return false;
	}
	if(news.headTitle.value.length > 50){
		alert("���ⲻ�ܶ���50���ַ���");
		news.headTitle.focus();
		return false;
	}
	//��������
	if(news.content.value == ""){
		alert("���ݲ���Ϊ��");
		news.content.focus();
		return false;
	}
	return true;
}