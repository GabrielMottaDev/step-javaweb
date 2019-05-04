<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb</title>
        <style>
            * {
                text-align: center;
            }
            body {
                margin: 50px;
                background-color: white;
            }

            h1 {
                color: seagreen;
            }

            h1,h2,h3 {
                margin: 0px 0px 5px 0px;
            }

            br {
                margin-bottom: 20px;
            }

            @media(prefers-color-scheme: dark) {
                body{
                    background-color: graytext;
                }

                h1 {
                    color: palegreen;
                }

                * {
                    color: snow;
                }
            }
            
            .divM {
                width: 500px;
                height: 500px;
                background-color: red;
            }
            
            .divC {
                width: 100%;
                height: 100%;
                background-color: green;
            }
            
        </style>
    </head>

    <body>
        <h1>AppWeb</h1>
        <br/>
        <h2>Hello World!</h2>
        <h3>Olá Mundo!</h3>
        
        <div class="divM">
            teste
            <div class="divC">
                
            </div>
        </div>
    </body>
</html>
