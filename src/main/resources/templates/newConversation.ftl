<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Start a new conversation</h3>
        <form action="/conversations" method="post">
            <p>
                <input type="text" name="userQuestion">
            </p>
            <p>
                <textarea name="chatGPTResponse"></textarea>
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>