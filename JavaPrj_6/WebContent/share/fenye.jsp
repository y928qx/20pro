<%@ page language="java" pageEncoding="GB18030"%>
<font color="blue">
    ��ǰҳ:��${pageView.currentpage}ҳ | �ܼ�¼��:${pageView.totalrecord}�� | ÿҳ��ʾ:${pageView.maxresult}�� | ��ҳ��:${pageView.totalpage}ҳ</font>��
<c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
    <c:if test="${pageView.currentpage==wp}"><b><font color="red">��${wp}ҳ</font></b></c:if>
    <c:if test="${pageView.currentpage!=wp}"><a href="javascript:topage('${wp}')" class="a03">��${wp}ҳ</a></c:if>
</c:forEach>