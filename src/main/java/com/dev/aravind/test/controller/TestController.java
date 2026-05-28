package com.dev.aravind.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/devops")
    public String devops() {
        return """
        <html>
            <body style="
                margin:0;
                display:flex;
                justify-content:center;
                align-items:center;
                height:100vh;
                background: linear-gradient(135deg, #0f172a, #1e293b, #312e81);
                font-family: Arial, sans-serif;
            ">

                <div style="
                    text-align:center;
                    padding:40px;
                    border-radius:20px;
                    background: rgba(255,255,255,0.08);
                    backdrop-filter: blur(10px);
                    box-shadow: 0 8px 32px rgba(0,0,0,0.3);
                ">
                    
                    <h1 style="
                        color:#f8fafc;
                        font-size:55px;
                        margin-bottom:10px;
                        text-shadow: 2px 2px 10px rgba(0,0,0,0.5);
                    ">
                        Welcome Onboard DevOps Engineer
                    </h1>

                    <h2 style="
                        color:#38bdf8;
                        font-size:30px;
                        margin-top:0;
                        letter-spacing:3px;
                    ">
                        DevOps L2
                    </h2>

                </div>

            </body>
        </html>
        """;
    }
}
