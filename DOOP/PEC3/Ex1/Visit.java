/**
 * Visit class of Exercise 1
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.lang.StringBuffer;

public class Visit {

  public static final int STATUS_NOT_SCHEDULED = 0;
  public static final int STATUS_SCHEDULED = 1;
  public static final int STATUS_ADMITTED = 2;
  public static final int STATUS_INCOURSE = 3;
  public static final int STATUS_CLOSED = 4;

  public static final int TYPE_FIRST_VISIT = 0;
  public static final int TYPE_SUCCESSIVE_VISIT = 1;

  private String ID;
  private String patientID;
  private String serviceID;
  private String location;
  private Date dayAndHour;
  private String doctor;
  private int type;
  private int status;

  /**
   * Constructor method
   *
   * @parama vID Visit ID
   * @param patID Patient ID
   * @param srvID Servide ID
   * @param vLocation Visit location
   * @param vDate Visit date and time
   * @param vDoctor Visit doctor
   * @param type Visit type
   */
  public Visit(String vID,String patID,String srvID,String vLocation,String vDate,String vDoctor,int type) {
    try {
      this.ID = vID;
      this.patientID = patID;
      this.serviceID = srvID;
      this.location = vLocation;
      SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      this.dayAndHour = (Date)dateFormatter.parse(vDate);
      this.doctor = vDoctor;
      this.type = type;
    } catch (ParseException ex) {

    }
  }

  public String getID() {
    return this.ID;
  }

  public String getPatientID() {
    return this.patientID;
  }

  public String getServiceID() {
    return this.serviceID;
  }

  public String getLocation() {
    return this.location;
  }

  public Date getDate() {
    return this.dayAndHour;
  }

  public String getDoctor() {
    return this.doctor;
  }

  public int getType() {
    return this.type;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public boolean scheduledForToday() {
    Calendar cal = Calendar.getInstance();
    int today_day = cal.get(Calendar.DAY_OF_MONTH);
    int today_month = cal.get(Calendar.MONTH);
    int today_year = cal.get(Calendar.YEAR);
    cal.setTime(this.dayAndHour);
    return today_day==cal.get(Calendar.DAY_OF_MONTH) && today_month==cal.get(Calendar.MONTH) && today_year==cal.get(Calendar.YEAR);
  }

  public String toString() {
    SimpleDateFormat dateFormatter = new SimpleDateFormat();
    Calendar cal = Calendar.getInstance();
    cal.setTime(this.dayAndHour);
    String hours = cal.get(Calendar.HOUR)<10?"0"+cal.get(Calendar.HOUR):""+cal.get(Calendar.HOUR);
    String minutes = cal.get(Calendar.MINUTE)<10?"0"+cal.get(Calendar.MINUTE):""+cal.get(Calendar.MINUTE);
    String visitDate = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)+" "+hours+":"+minutes;
    return "ID: "+this.ID+", PATIENT: "+this.patientID+", SERVICE: "+this.serviceID+", LOCATION: "+this.location+", DOCTOR: "+this.doctor+", DATE: "+visitDate;
  }
}
