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
    <#list stus as stu>
        <tr>
            <td <#if stu.name =='小明'>style="background:red;"</#if>>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
        </tr>
    </#list>
</table>
</body>
</html>
