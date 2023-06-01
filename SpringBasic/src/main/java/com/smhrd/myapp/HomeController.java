package com.smhrd.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.myapp.domain.WebMember;
import com.smhrd.myapp.mapper.MemberMapper;

//Spring 에게 해당 Class가 Controller 역할을 한다고 알려주기 위해 사용하는 Annotation
//Controller -> view 를 반환하는 역할 (.jsp, .html ..)
@Controller
public class HomeController {
   
	@Autowired
	private MemberMapper mapper;
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   //실제 요청 경로와 value값이 일치하면 해당 메서드가 실행되도록 만들어주는 Annotation
   //value : 요청 경로, method : HTTP Method(GET, POST ...)
   //context-root(path) : 서버안에서 동작하는 프로젝트를 식별하기 위한 값
   //http://localhost:8085/myapp(context-root)/
   @RequestMapping(value = "/home", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      // "home" -> view
      // ViewResolver 가 view 찾아줌
      // ViewResolver : webapp/WEB-INF/spring/appServlet/servlet-context.xml 에 관련 정보 작성
      // prefix : /WEB-INF/views/
      // suffix : .jsp
      // -> /WEB-INF/views/home.jsp
      //화면 구성(.jsp, .js, .css ...) : 기본경로가 webapp아래
      
      return "home";
   }
   
   //index.jsp return하는 메서드
   @RequestMapping(value="/", method=RequestMethod.GET)
   public String index() {
      
      return "index";
   }
   
   //GET 요청 받아줄떄에는 Method 생략가능
   @RequestMapping(value="/joinsuccess")
   public String joinSuccess(@RequestParam("email") String email, Model model) {
      //email 값을 view에 출력해주려면 ~~~ 저장이 되어있어야함
      //forward : request 영역에 값 저장
      //Model : 데이터를 저장할 수 있는 공간, request랑 비슷하게 쓰임
      model.addAttribute("joinEmail",email);
      //request.setAttribute()랑 비슷한 역할
      return "joinSuccess"; //view 만 반환 (데이터 x)
   }
   
   @RequestMapping(value = "/select")
   public String select(Model model) {
	  List<WebMember> list = mapper.select();
	  model.addAttribute("list",list);
	  return "select";
   }
   
   
}