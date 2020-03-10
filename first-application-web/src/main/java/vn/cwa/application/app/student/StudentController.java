package vn.cwa.application.app.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.cwa.application.domain.model.Student;
import vn.cwa.application.domain.service.student.StudentService;

@Controller
@RequestMapping(value = "student")
public class StudentController {

	@Inject
	StudentService studentService;

//	@ModelAttribute
//	public StudentForm setupForm() {
//		return new StudentForm();
//	}

	@RequestMapping(value = "insert", params = "form", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("studentForm", new StudentForm());
		return "student/insert";
	}
	
	@RequestMapping(value = "insert", params = "redo", method = RequestMethod.POST)
	public String createRedo(StudentForm studentForm, Model model) {
		model.addAttribute("studentForm", studentForm);
		return "student/insert";
	}

	@RequestMapping(value = "insert", params = "confirm", method = RequestMethod.POST)
	public String createConfirm(@Validated StudentForm studentForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return createRedo(studentForm, model);
		}
		model.addAttribute("studentForm", studentForm);
		Student student = new Student();
		student.setName(studentForm.getName());
		student.setAge(studentForm.getAge());
		student.setDateOfBirth(studentForm.getDateOfBirth());
		Long rs = studentService.register(student);
		System.out.println(rs);
		return "redirect:/?msg=success";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") Long id, Model model) {
		Student student = studentService.findOne(id);
		
		ObjectMapper obj = new ObjectMapper();
		Map<String, Object> map = obj.convertValue(student, Map.class);
		System.out.println(map);
		
		model.addAttribute("model", student);
		return "student/edit";
	}

//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(StudentInput studentIP) {
//		Student student = new Student();
//		student.setId(studentIP.getId());
//		student.setName(studentIP.getName());
//		student.setAge(studentIP.getAge());
//		try {
//			student.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(studentIP.getDateOfBirth()));
//		} catch (ParseException e) {
//			System.out.println(e.getMessage());
//		}
//		studentService.editStudent(student);
//		return "redirect:/";
//	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id) {
		studentService.removeStudent(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "xxxx", method = RequestMethod.GET)
	public String hihi() {
		studentService.getIdByName(null);
		return "";
	}
	
	@RequestMapping(value = "yyyy", method = RequestMethod.GET)
	public String yyyy(@RequestParam("test") String test) {
		
		
		
		return "testMap";
	}
	
	

}
