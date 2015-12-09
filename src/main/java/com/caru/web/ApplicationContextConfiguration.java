package com.caru.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;



@Configuration
@ComponentScan(basePackageClasses = PackageRootMarker.class, useDefaultFilters = true, excludeFilters = {
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class ApplicationContextConfiguration {

}
