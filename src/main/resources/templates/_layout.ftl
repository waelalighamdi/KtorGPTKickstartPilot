<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Conversation with chatGPT</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    margin: 0;
                    padding: 0;
                    text-align: center;
                }
                .container {
                    max-width: 600px;
                    margin: 0 auto;
                    padding: 20px;
                }
                form {
                    display: flex;
                    flex-direction: column;
                }
                label {
                    font-size: 16px;
                    margin-bottom: 5px;
                }
                input, textarea {
                    font-size: 14px;
                    padding: 10px;
                    border: 1px solid #ccc;
                    border-radius: 5px;
                    margin-bottom: 20px;
                }
                button {
                    font-size: 16px;
                    background-color: #333;
                    color: #fff;
                    padding: 10px 20px;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                }
            </style>
    </head>
    <body>
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