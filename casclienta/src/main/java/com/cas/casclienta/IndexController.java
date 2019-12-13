package com.cas.casclienta;

import lombok.extern.slf4j.Slf4j;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@Controller
public class IndexController
{
    @RequestMapping("/login")
    public ModelAndView auth(HttpServletRequest request) {
        AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
        String loginName2 = principal.getName();
        log.info("获取到用户名称为："+loginName2);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
