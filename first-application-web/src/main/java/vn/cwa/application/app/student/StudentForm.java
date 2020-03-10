package vn.cwa.application.app.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class StudentForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@NotNull
//	@Size(min = 5, max = 20)
	private String name;

//	@NotNull
//	@Min(0) 
//	@Max(110)
	private Integer age;
	
//	@NotNull
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	private List<String> status = new ArrayList<String>();

}
