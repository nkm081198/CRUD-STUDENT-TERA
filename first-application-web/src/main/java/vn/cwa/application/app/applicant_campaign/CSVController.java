package vn.cwa.application.app.applicant_campaign;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.cwa.application.domain.repository.applicant_campaign.ApplicantExportCriteria;
import vn.cwa.application.domain.service.applicant_campaign.ApplicantService;

@Controller
@RequestMapping(value = "/downloadCSV")
public class CSVController {

  @Inject
  ApplicantService applicantService;
  
  private static final String DATE_TYPE = "yyyy/MM/dd";
  
  @RequestMapping(value = "/test1", method = RequestMethod.GET)
  public String downloadCSV(HttpServletResponse response, @RequestParam ExportApplicantCSV formExport, Pageable page) throws IllegalArgumentException, IllegalAccessException, IOException {
    ApplicantExportCriteria criteria = convertToExportApplicant(formExport);
    applicantService.handlerExportCSV(criteria, response, page);
    return null;
  }
  
  
  private ApplicantExportCriteria convertToExportApplicant(ExportApplicantCSV formExport) {
    ApplicantExportCriteria result = new ApplicantExportCriteria();
    
    result.setCampaignId(formExport.getCampaignId());
    result.setCampaignIds(formExport.getCampaignIds());
    result.setStartDate(checkDateInvalid(formExport.getStartDate(), DATE_TYPE));
    result.setEndDate(checkDateInvalid(formExport.getEndDate(), DATE_TYPE));
    result.setPerInfor(formExport.getPerInfor());
    result.setNoPerInfor(formExport.getNoPerInfor());
    result.setMultiplePerInfor(formExport.getMultiplePerInfor());
    result.setMultipleNoPerInfor(formExport.getMultipleNoPerInfor());
    
    return result;
  }
  
  private Date checkDateInvalid(String dateString, String dateType) {

    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat(dateType);
    dateFormat.setLenient(false);
    try {
      date = dateFormat.parse(dateString);
    } catch (ParseException e) {
      date = null;
    }

    return date;
  }
}
