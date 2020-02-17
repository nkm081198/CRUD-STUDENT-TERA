package vn.cwa.application.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idT;
	private String name;
	private Integer age;
	private Date dateOfBirth;
	private List<Subject> subject;
	private Map<String, String> maps;
	
	
	public Student() {
		maps = getMaps();
	}
	
	public static Map<String, String> getMaps(){
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("1", "mot");
		return maps;
	}
}
