package vn.cwa.application.app.applicant_campaign;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class ExportApplicantCSV implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String campaignId;

  private String startDate;

  private String endDate;

  private Boolean perInfor = false;

  private Boolean noPerInfor = false;

  private Boolean multiplePerInfor = false;

  private Boolean multipleNoPerInfor = false;
  
  private List<String> campaignIds;

}
