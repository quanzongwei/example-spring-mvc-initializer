package eu.kielczewski.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
class WebMvcConfig extends WebMvcConfigurerAdapter {
//    @Bean
//    public ViewResolver getViewResolver(ResourceLoader resourceLoader) {
//
//        InternalResourceViewResolver InternalResolver = new InternalResourceViewResolver();
//        InternalResolver.setPrefix("/html/");
//        InternalResolver.setSuffix(".html");
//        InternalResolver.setCache(false);
//        InternalResolver.setContentType("text/html;charset=ISO-8859-1");
//
//        return InternalResolver;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("/");
//    }
}