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
        <hr>
        <p>
            <a href="/conversations/new">Start a new conversation</a>
        </p>
    </div>
</@layout.header>