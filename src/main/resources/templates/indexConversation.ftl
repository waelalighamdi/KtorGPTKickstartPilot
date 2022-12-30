<#-- @ftlvariable name="conversations" type="kotlin.collections.List<com.example.models.Conversation>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
<#list conversations?reverse as conversation>
<div>
    <h3>
        <a href="/conversations/${conversation.id}">${conversation.userQuestion}</a>
    </h3>
    <p>
        ${conversation.chatGPTResponse}
    </p>
</div>
</#list>
<hr>
<p>
    <a href="/conversations/new">Start a new conversation</a>
</p>
</@layout.header>