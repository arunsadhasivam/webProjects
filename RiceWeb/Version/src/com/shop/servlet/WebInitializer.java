package com.shop.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.shop.config.AppConfig;
import com.shop.config.WebConfig;

@PropertySource("classpath:env.properties")
public class WebInitializer implements WebApplicationInitializer {
    @Autowired Environment env;
	@Override
	public void onStartup(ServletContext context) throws ServletException {
		
		//like context-param> available throughout webapp , available to
		//all servlet, filter
		AnnotationConfigWebApplicationContext appContext =
			      new AnnotationConfigWebApplicationContext();
		appContext.register(AppConfig.class);
		registerDispatcherServlet(context);
		context.addListener(new ContextLoaderListener(appContext));
		
	}
	
	
	private void registerDispatcherServlet(ServletContext servletContext) {

		AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebConfig.class);
		ServletRegistration.Dynamic dispatcher;
		dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.htm");
		//if not added this line BeanFactory not initialized or already closed - call 'refresh' before accessing beans via the ApplicationContext
		//dispatcherContext.refresh();
		//dispatcher.setMultipartConfig(dispatcherContext.getBean(MultipartConfigElement.class));
 
	}

    private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(annotatedClasses);
        return context;
    }
}
