/**
 * Test class of Exercise 1
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */
public class Main1 {
  private static final int N = 5; // dimension of array

  private static void admit(Visit[] visits,String patID) {
	  for (int i=0; i<visits.length; i++){
		  if (visits[i].getPatientID().equals(patID)){
			  if (visits[i].scheduledForToday()){
				  visits[i].setStatus(Visit.STATUS_ADMITTED);
			  }  
		  }
	  }
  }

  private static void printAdmittedVisits(Visit[] visits,String patID) {
	  boolean patientHasVisit=false;
	  for (int i=0; i<visits.length; i++){
		  if (visits[i].getPatientID().equals(patID)){
			  if (visits[i].getStatus() == Visit.STATUS_ADMITTED){
				  patientHasVisit=true;
				  System.out.println (visits[i]);
			  }
			  //else
			//	  System.out.println("You don't have any scheduled visit today");
		  }
	  }
	  if (patientHasVisit == false){
		  System.out.println("You don't have any scheduled visit today");
	  }
  }

  private static boolean serviceHasVisits(Visit[] visits,String serviceID) {
	  for (int i=0; i<visits.length; i++){
		  if (visits[i].getServiceID().equals(serviceID)){
			  if (visits[i].scheduledForToday()){
				  return true;
			  }
		  }
	  }
	  return false;
  }

  public static void main(String[] args) {
    Visit[] visits = new Visit[N];

    visits[0] = new Visit("0000000001","1000000001","CARSRV","Cardiology Door 1","2016-11-03 10:00","Dr. John Heart",Visit.TYPE_FIRST_VISIT);
    visits[1] = new Visit("0000000002","1000000002","CARSRV","Cardiology Door 1","2016-11-03 10:15","Dr. John Heart",Visit.TYPE_FIRST_VISIT);
    visits[2] = new Visit("0000000003","1000000001","RADSRV","Radiology Door 25","2016-11-03 08:00","Ms. Uranium",Visit.TYPE_FIRST_VISIT);
    visits[3] = new Visit("0000000004","1000000003","TRASRV","Traumatology Door 10","2016-11-03 10:00","Dr. Joe Bones",Visit.TYPE_FIRST_VISIT);
    visits[4] = new Visit("0000000005","1000000001","TRASRV","Traumatology Door 11","2016-10-31 10:00","Dr. Mary Legs",Visit.TYPE_FIRST_VISIT);

    System.out.println("Service CARSRV has scheduled visits? "+(serviceHasVisits(visits,"CARSRV")?"YES":"NO"));
    System.out.println("Service TRASRV has scheduled visits? "+(serviceHasVisits(visits,"TRASRV")?"YES":"NO"));
    System.out.println("Service RADSRV has scheduled visits? "+(serviceHasVisits(visits,"RADSRV")?"YES":"NO"));
    System.out.println("Service NEUSRV has scheduled visits? "+(serviceHasVisits(visits,"NEUSRV")?"YES":"NO"));

    System.out.println("PATID: 1000000001");
    admit(visits,"1000000001");
    printAdmittedVisits(visits,"1000000001");

    System.out.println("PATID: 1000000002");
    admit(visits,"1000000002");
    printAdmittedVisits(visits,"1000000002");

    System.out.println("PATID: 1000000003");
    admit(visits,"1000000003");
    printAdmittedVisits(visits,"1000000003");

    System.out.println("PATID: 1000000004");
    admit(visits,"1000000004");
    printAdmittedVisits(visits,"1000000004");

    System.out.println("PATID: 1000000005");
    admit(visits,"1000000005");
    printAdmittedVisits(visits,"1000000005");
  }
}
