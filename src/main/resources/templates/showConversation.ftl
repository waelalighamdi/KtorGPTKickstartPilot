<#-- @ftlvariable name="conversation" type="com.example.models.Conversation" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${conversation.userQuestion}
        </h3>
        <p>
            ${conversation.chatGPTResponse}
        </p>
    </div>
    <hr>
    <div>
        <form action="/conversations/${conversation.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
    <hr>
    <div>
        <p>
            <a href="/conversations/new">Start a new conversation</a>
        </p>
    </div>
</@layout.header>