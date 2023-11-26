package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.mapping.PayloadRootAnnotationMethodEndpointMapping;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Arrays;

@EnableWs
@Configuration
public class WebServiceConfig {

    private static final String NAMESPACE_BOOK_URI = "http://www.example.com/book";
    private static final String NAMESPACE_PEN_URI = "http://www.example.com/pen";


    @Bean
    public XsdSchema bookSchema() {
        return new SimpleXsdSchema(new ClassPathResource("book.xsd"));
    }
    @Bean
    public XsdSchema penSchema() {
        return new SimpleXsdSchema(new ClassPathResource("pen.xsd"));
    }


    @Bean
    public DefaultWsdl11Definition bookDefinition(XsdSchema bookSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BookPort");
        wsdl11Definition.setLocationUri("/bookServiceAAAAAAAAAAAAAAAAA");
        wsdl11Definition.setTargetNamespace(NAMESPACE_BOOK_URI);
        wsdl11Definition.setSchema(bookSchema);
        return wsdl11Definition;
    }
    @Bean
    public DefaultWsdl11Definition penDefinition(XsdSchema bookSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PenPort");
        wsdl11Definition.setLocationUri("/penService");
        wsdl11Definition.setTargetNamespace(NAMESPACE_PEN_URI);
        wsdl11Definition.setSchema(bookSchema);
        return wsdl11Definition;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        ServletRegistrationBean<MessageDispatcherServlet> registrationBean = new ServletRegistrationBean<>(servlet);
        registrationBean.setUrlMappings(Arrays.asList("/bookService", "/penService"));
        return registrationBean;
    }
}