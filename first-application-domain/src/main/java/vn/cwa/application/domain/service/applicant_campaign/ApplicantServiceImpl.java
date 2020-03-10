package vn.cwa.application.domain.service.applicant_campaign;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;
import vn.cwa.application.domain.model.Applicant;
import vn.cwa.application.domain.model.BaseModel;
import vn.cwa.application.domain.model.Campaign;
import vn.cwa.application.domain.repository.applicant_campaign.ApplicantExportCriteria;
import vn.cwa.application.domain.repository.applicant_campaign.ApplicantRepository;
import vn.cwa.application.domain.repository.applicant_campaign.CampaignRepository;
import vn.cwa.application.domain.utils.DateFormaterUtils;

@Service
public class ApplicantServiceImpl implements ApplicantService {

  @Inject
  ApplicantRepository applicantRepository;

  @Inject
  CampaignRepository campaignRepository;

  @Inject
  DateFormaterUtils dateFormaterUtils;

  final String defaultCsvFilename = "APPLICANT_%s.csv";
  final CsvPreference csvPref =
      new CsvPreference.Builder('"', ',', "\r\n").useQuoteMode(new AlwaysQuoteMode()).build();

  @Override
  public void handlerExportCSV(ApplicantExportCriteria criteria, HttpServletResponse response,
      Pageable page) throws IOException, IllegalArgumentException, IllegalAccessException {

    if (criteria.getPerInfor() || criteria.getNoPerInfor()) {

      List<Applicant> listApplicant = applicantRepository.getApplicantCsvByCriteria(criteria);
      Campaign cam = campaignRepository.findById(criteria.getCampaignId());

      response.setContentType("text/csv");
      response.setHeader("Set-Cookie", "fileDownload=true; path=/");
      response.setHeader("Content-disposition", "attachment;filename="
          + String.format(defaultCsvFilename, dateFormaterUtils.formatCsvTimestamp(new Date())));

      if (criteria.getPerInfor()) {

        List<Campaign> lstCam = Arrays.asList(cam);
        write(response.getOutputStream(), lstCam, listApplicant, mappingCamNames, mappingValues,
            processors);
        /* write(response.getOutputStream(), listApplicant, mappingValues, processors); */

        return;

      } else {

        Class<?> zClass = cam.getClass();
        Field[] fields = zClass.getDeclaredFields();
        String filedName = null;
        Integer index = 1;
        List<String> lstLabelNames = new ArrayList<String>();
        List<String> lstLabelValues = new ArrayList<String>();

        for (Field field : fields) {
          field.setAccessible(true);
          filedName = field.getName();
          if (filedName.equals("label" + index + "Flg")) {
            if ("0".equals(field.get(cam).toString())) {
              lstLabelNames.add("label" + index + "Name");
              lstLabelValues.add("label" + index + "Value");
            }
            index++;
          }
        }

        List<Campaign> lstCam = Arrays.asList(cam);
        List<CellProcessor> lstProcessor = new ArrayList<CellProcessor>();

        String[] arrayNames = lstLabelNames.stream().toArray(String[]::new);
        String[] arrayValues = lstLabelValues.stream().toArray(String[]::new);

        index = arrayNames.length;
        for (int i = 0; i < index; i++) {
          lstProcessor.add(new Optional());
        }

        CellProcessor[] arrProcessors = lstProcessor.stream().toArray(Optional[]::new);
        write(response.getOutputStream(), lstCam, listApplicant, arrayNames, arrayValues,
            arrProcessors);

      }

    } else if (criteria.getMultiplePerInfor()) {
      // loading...

    } else if (criteria.getMultipleNoPerInfor()) {
      // loading...

    }

  }

  final static String[] mappingCamNames = {"label1Name", "label2Name", "label3Name", "label4Name",
      "label5Name", "label6Name", "label7Name", "label8Name", "label9Name", "label10Name",
      "label11Name", "label12Name", "label13Name", "label14Name", "label15Name", "label16Name",
      "label17Name", "label18Name", "label19Name", "label20Name", "label21Name", "label22Name",
      "label23Name", "label24Name", "label25Name", "label26Name", "label27Name", "label28Name",
      "label29Name", "label30Name", "label31Name", "label32Name", "label33Name", "label34Name",
      "label35Name", "label36Name", "label37Name", "label38Name", "label39Name", "label40Name",
      "label41Name", "label42Name", "label43Name", "label44Name", "label45Name", "label46Name",
      "label47Name", "label48Name", "label49Name", "label50Name"};

  final static String[] mappingValues = {"label1Value", "label2Value", "label3Value", "label4Value",
      "label5Value", "label6Value", "label7Value", "label8Value", "label9Value", "label10Value",
      "label11Value", "label12Value", "label13Value", "label14Value", "label15Value",
      "label16Value", "label17Value", "label18Value", "label19Value", "label20Value",
      "label21Value", "label22Value", "label23Value", "label24Value", "label25Value",
      "label26Value", "label27Value", "label28Value", "label29Value", "label30Value",
      "label31Value", "label32Value", "label33Value", "label34Value", "label35Value",
      "label36Value", "label37Value", "label38Value", "label39Value", "label40Value",
      "label41Value", "label42Value", "label43Value", "label44Value", "label45Value",
      "label46Value", "label47Value", "label48Value", "label49Value", "label50Value"};

  final static CellProcessor[] processors =
      {new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
          new Optional(), new Optional(), new Optional(), new Optional(), new Optional()};

  private void write(OutputStream os, List<? extends BaseModel> objects1,
      List<? extends BaseModel> objects2, String[] fieldMappingNames, String[] fieldMappingValues,
      CellProcessor[] processors) {

    try (Writer writer = new OutputStreamWriter(os, "SHIFT-JIS");

        ICsvBeanWriter beanWriter = new CsvBeanWriter(writer, csvPref)) {

      int lengthArray = fieldMappingNames.length;
      for (int i = 0; i < lengthArray; i++) {
        beanWriter.write(objects1.get(i), fieldMappingNames, processors);
        beanWriter.write(objects2.get(i), fieldMappingValues, processors);
      }

      beanWriter.flush();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

}
