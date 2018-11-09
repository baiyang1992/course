package com.course.api;

import com.course.config.ApplicationUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 生成接口测试，接口上添加标注@ApiDoc即可
 * @author wu.yy
 *
 */
@RestController
@RequestMapping("/api/")
@Log
public class ApiTestController {
	@Autowired
	private ApplicationUtil applicationUtil;
	@Autowired
	private WebApplicationContext applicationContext;
	private LocalVariableTableParameterNameDiscoverer pd = new LocalVariableTableParameterNameDiscoverer();
	public static List<ApiInfo> apis = null;
	public static HashSet<String> node = null;
	public static HashMap<String,Object> obj = null;

	/**
	 * 获取所有的接口
	 * @return 
	 */
	@RequestMapping("list")
	public HashMap<String,Object> getAllRouter() {
		if (apis == null) {
			obj = new HashMap<String,Object>();
			buildApis();
			obj.put("NODE", node);
			obj.put("APIS", apis);
		}
		
		return obj;
	}

	/**
	 * 生成apidoc
	 */
	private void buildApis() {
		log.info("生成请求文档......");
		apis = new ArrayList<ApiInfo>();
		node = new HashSet<String>();
		//ApplicationContext context = applicationContext.get.getContext();
		Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Controller.class);
		for (Object object : beansWithAnnotation.values()) {
			Class<? extends Object> cl = object.getClass();
			String baseUrl = "";
			String no = cl.getSimpleName();
			RequestMapping baseRequestMapping = cl.getAnnotation(RequestMapping.class);
			//RequestMappingHandlerMapping baseRequestMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
			if (baseRequestMapping != null && baseRequestMapping.value() != null) {
				baseUrl = baseRequestMapping.value()[0];
			}
			Method[] methods = cl.getMethods();
			for (Method method : methods) {
				ApiDoc apiDocAnnotation = method.getAnnotation(ApiDoc.class);
				RequestMapping requestMappingAnnotation = method.getAnnotation(RequestMapping.class);
				GetMapping getMappingAnnotation = method.getAnnotation(GetMapping.class);
				PostMapping postMappingAnnotation = method.getAnnotation(PostMapping.class);
				if (apiDocAnnotation != null && (requestMappingAnnotation != null || getMappingAnnotation != null || postMappingAnnotation != null)) {
					String currentUrl = "/";
					String requestMethod = "";
					if (requestMappingAnnotation != null) {
						currentUrl = requestMappingAnnotation.value()[0];
						//requestMethod
						RequestMethod[] method2 = requestMappingAnnotation.method();
						if(method2 != null && method2.length>0){
							requestMethod = method2[0].name();
						}else{
							requestMethod = "GET/POST";
						}
					} else if (getMappingAnnotation != null) {
						currentUrl = getMappingAnnotation.value()[0];
						requestMethod = "GET";
					} else {
						currentUrl = postMappingAnnotation.value()[0];
						requestMethod = "POST";
					}
					node.add(no);
					addApiDoc(baseUrl + currentUrl, method, apiDocAnnotation.value(),requestMethod,no);
				}
			}

		}
	}

	private void addApiDoc(String baseUrl, Method method, String name,String requestMethod,String node) {
		apis.add(new ApiInfo("/course"+baseUrl, name, pd.getParameterNames(method),requestMethod,node));
	}
}
