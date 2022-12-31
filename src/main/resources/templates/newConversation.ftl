<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container">
        <h2>What is in your mind? </h2>
        <form action="/conversations" method="post">
                <input type="text" name="userQuestion">
                <button type="submit">Ask</button>
        </form>
    </div>
</@layout.header>