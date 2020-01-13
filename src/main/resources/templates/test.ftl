<#--https://blog.csdn.net/weixin_37194108/article/details/103802651-->


<#if stus??>
    <#list stus as stu>
        <tr>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
        </tr>
    </#list>
</#if>

<#if stus??>
    <#list stus as stu>
        <tr>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
            <td>${(stu.birthday?date)!''}---${(stu.birthday?time)!''}---${(stu.birthday?datetime)!''}
                ---${(stu.birthday?string("yyyy年MM月"))!''}</td>
        </tr>
    </#list>
</#if>
<#assign text="{'bank':'工商银行','account':'10101920201920212'}" />
<#assign data=text?eval />
开户行：${data.bank} 账号：${data.account}

<html>
<head>
    <title>hello world!</title>
</head>
<body>
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
    <#if stus??>
        stus集合的大小是${stus?size}
        <#list stus as stu>
            <tr>
                <td>${stu.name}</td>
                <td>${stu.age}</td>
                <td>${stu.money}</td>
            </tr>
        </#list>
    </#if>
</table>
</body>
</html>

<#--显示年月日: ${today?date}-->
<#--显示时分秒：${today?time}-->
<#--显示日期+时间：${today?datetime} <br>-->
<#--自定义格式化：  ${today?string("yyyy年MM月")}-->