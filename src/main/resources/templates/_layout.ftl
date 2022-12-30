<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Conversation with chatGPT</title>
    </head>
    <body style="text-align: center; font-family: sans-serif">
    <img src="/static/ktor_logo.png">
    <h1>Conversation with chatGPT </h1>
    <p><i>Powered by Ktor, Freemarker, and chatGPT!</i></p>
    <hr>
    <#nested>
    <p>
        <a href="/conversations">Back to the conversation page</a>
    </p>
    <p>
        <a href="/">About chatGPT and Ktor framework</a>
    </p>
    </body>
    </html>
</#macro>