package com.zcr.config;

import com.zcr.component.LoginHandlerInterceptor;
import com.zcr.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
//@EnableWebMvc自动配置就失效了,现在我们全面接管了MVC
//@EnableWebMvc
/*public class MyMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/zcr请求来到success页面
        //一般用于只是发送一个请求来页面，只要不发送数据，没必要像hello()一样，写这些空方法了，直接来做视图映射
        registry.addViewController("/zcr").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("login.html").setViewName("login");
    }

    //静态文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}*/


    /*//所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean//将组件注册在容器中
    public WebMvcConfigurationSupport webMvcConfigurationSupport() {
        WebMvcConfigurationSupport support = new WebMvcConfigurationSupport() {
            @Override
            protected void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("login.html").setViewName("login");
            }
        };
        return support;
    }*/

/**
 *
 关于P34，WebMvcConfigurationAdapter被弃用，使用WebMvcConfigurationSupptor，自动配置不生效，no mapping for /的问题。
 应该写成，实现webmvcConfifurer的addViewControllers方法：
 public class MyMvcConfig implements WebMvcConfigurer {
@Override
public void addViewControllers(ViewControllerRegistry registry) {
registry.addViewController("/").setViewName("login");
}
}
 详见：https://www.cnblogs.com/deng720/p/8989388.html

 */



public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //静态资源，css js 以前我们注册拦截器，还要排除掉静态资源的访问
        //现在Spring Boot我们已经做好了静态资源映射，我们不需要管他了
       /* registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/user/login","/asserts/**","/webjars/**");
    */
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }



}





