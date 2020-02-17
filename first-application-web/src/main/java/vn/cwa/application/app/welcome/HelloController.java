package vn.cwa.application.app.welcome;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.cwa.application.domain.model.Student;
import vn.cwa.application.domain.service.student.StudentService;


@Controller
@RequestMapping("/")
public class HelloController {
	
	@Inject
	StudentService studentService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) {
		List<Student> lst = studentService.getAllStudent();
		model.addAttribute("listStudent", lst);
		return "welcome/home";
	}

}
