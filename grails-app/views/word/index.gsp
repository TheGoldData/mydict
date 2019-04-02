<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>我的单词</title>
</head>
<body>
    <content tag="nav">


    </content>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>我的单词</h1>
            <div class="pagination">
                <g:if test="${cmd.pageNum>1}">
                    <span>
                        <a href="${ctx}/word/index?pageNum=${cmd.pageNum-1}">上一页</a>
                    </span>
                </g:if>
                <g:if test="${cmd.pageNum<pages}">
                    <span>
                        <a href="${ctx}/word/index?pageNum=${cmd.pageNum+1}">下一页</a>
                    </span>
                </g:if>
            </div>

            <ul>
                <g:each in="${page}" var="item" >
                    <li> <h5>${item.word}</h5>
                        <span class="uk">uk: ${item.ukDecoded}</span>

                        <span class="us">us:  ${item.usDecoded}</span></li>
                </g:each>

            </ul>

            <div class="pagination">
                <g:if test="${cmd.pageNum>1}">
                <span>
                    <a href="${ctx}/word/index?pageNum=${cmd.pageNum-1}">上一页</a>
                </span>
                </g:if>
<g:if test="${cmd.pageNum<pages}">
                <span>
                    <a href="${ctx}/word/index?pageNum=${cmd.pageNum+1}">下一页</a>
                </span>
</g:if>
            </div>
        </section>
    </div>

</body>
</html>
