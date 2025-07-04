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

    @Value("${POD_NAME:unknown}")
    private String podName2;

    @Value("${POD_NAMESPACE:default}")
    private String podNamespace;

    @Value("${NODE_NAME:unknown}")
    private String nodeName;

    @GetMapping("/")
    public String welcome(Model model) throws UnknownHostException {
        String podIp = InetAddress.getLocalHost().getHostAddress();
        if (podName == null || podName.equals("unknown")) {
            podName = InetAddress.getLocalHost().getHostName();
        }
        model.addAttribute("podName", podName);
        model.addAttribute("podIp", podIp);
        model.addAttribute("podName2", podName2);
        model.addAttribute("podNamespace", podNamespace);
        model.addAttribute("nodeName", nodeName);
        return "welcome";
    }
}
