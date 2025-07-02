package org.example.practice.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class WelcomeController {

    @Value("${HOSTNAME:unknown}")
    private String podName;

    @GetMapping("/")
    public String welcome(Model model) throws UnknownHostException {
        String podIp = InetAddress.getLocalHost().getHostAddress();
        if(podName.equals("unknown")) podName = InetAddress.getLocalHost().getHostName();
        model.addAttribute("podName MJ: ", podName);
        model.addAttribute("podIp: ", podIp);
        return "welcome";
    }
}
