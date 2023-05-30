package com.smhrd.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Spring 에게 해당 class가 controller 역할을 한다고 알려주기 위해 사용하는  Annotation
// Cntroller -> view를 반환하는 역할( .jsp, .html ...)
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	// 실제 요청 경로와 value 값이 일치하면 해당 메서드가 실행되도록 만어주는  Annotation
	//value : 요청 경로, method : HTTP Method ( GET, POST ... )
	//context-root(path) : 서버안에서 동작하는 프로젝트를 식별하기 위한 값
	//http://localhost:8085/context-root
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//home -> view
		//ViewResolver  가 view를 찾아줌
		//ViewResolver : webapp/WEB-INF/spring/appServlet-context.xml 에 관련 정보 작성 
		//prefix : /WEB=INF/view
		//seffix : .jsp
		//	-> /WEB=INF/view/home.jsp
		//화면 구성 (.jsp, .js, .csss ...) : 기본경로가 webapp 아래
		
		return "home";
	}
	
	//index.jsp(view) return하는 메서드
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "index";
		
	}
	
	
	
}
