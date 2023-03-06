package our.war.help.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**", "/img/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/js")
                .addResourceLocations("classpath:/img/", "classpath:/db/migration")
                .addResourceLocations("/resources/", "/resources/**");
    }
}
