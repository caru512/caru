package com.caru.core;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.caru.core.util.MapperFactory;


@Configuration
@ComponentScan(basePackageClasses = CorePackageRootMarker.class, useDefaultFilters = true, excludeFilters = {
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class CoreApplicationContextConfiguration {

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate() {{
            setMessageConverters(new ArrayList<HttpMessageConverter<?>>() {{
                add(new FormHttpMessageConverter());
                add(new MappingJackson2HttpMessageConverter(MapperFactory.json()));
                add(new Jaxb2RootElementHttpMessageConverter() {{
                    setSupportedMediaTypes(new ArrayList<MediaType>() {{
                        add(MediaType.TEXT_XML);
                        add(MediaType.TEXT_HTML);
                        add(MediaType.APPLICATION_XML);
                    }});
                }});
            }});
        }};
    }
}
