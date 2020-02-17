package vn.cwa.application.app.model;

import lombok.Data;

@Data
public class CstDcMYobi {
	
	private Short id;
	
	private Short type;
	
	private String label;
	
	private String masterTable;
	
	private String codeColumn;
	
	private String labelColumn;
}
