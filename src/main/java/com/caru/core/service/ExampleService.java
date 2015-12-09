package com.caru.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.caru.core.model.ExampleModel;

@Service
public class ExampleService {

	private String URL = "http://kr.searchgw.nhncorp.com:20334/krdic/search";
	
	
	@Autowired
	private RestTemplate rt;
	
	public ExampleModel.Result getWordExample(String q, String display, String hl, String r_psglen) throws Exception{
		UriComponentsBuilder ub = UriComponentsBuilder.fromUriString(this.URL);
		ub.queryParams(this.getWordExampleQueryParam(q, display, hl, r_psglen));
		
		ExampleModel ex = rt.getForObject(ub.toUriString(),ExampleModel.class);
		return ex.result;
	}
	
	public MultiValueMap<String,String> getWordExampleQueryParam(String q, String display, String hl, String r_psglen){
		MultiValueMap<String,String> paramMap =  new LinkedMultiValueMap<String,String>();		
		paramMap.add("version", "3.0.0");
		paramMap.add("q", q);
		paramMap.add("pr", "kin");
		paramMap.add("r_format", "xml");
		paramMap.add("start", "1");
		paramMap.add("display", display);
		paramMap.add("q_enc", "UTF-8");
		paramMap.add("r_enc", "UTF-8");
		paramMap.add("hl", hl);
		paramMap.add("r_psglen", r_psglen);
		paramMap.add("rp", "none");
		paramMap.add("st", "example");
		paramMap.add("so", "rel.dsc");
		paramMap.add("ic", "service");
		paramMap.add("sm", "all.basic");	
			
		return paramMap;
	}
}
