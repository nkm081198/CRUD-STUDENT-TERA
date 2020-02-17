package vn.cwa.application.domain.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DateCustome implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Min(1)
	@Max(31)
	private Integer day;
	
	@Min(1)
	@Max(12)
	private Integer month;
	
	@Size(min = 4, max = 4)
	private Integer year;
}
