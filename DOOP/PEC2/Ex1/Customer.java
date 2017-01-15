import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author David Doblas Jiménez
 *
 */
public class Customer {
	
	/** The cip. */
	private String cip;
	
	/** The name. */
	private String name;
	
	/** The bonus level. */
	private String bonus;

	/** The driving licence date. */
	private String dateDrivingLicence;
	
	/**
	 * Instantiates a new Customer.
	 *
	 * @param cip the cip
	 * @param name the name
	 * @param bonus the bonus level
	 * @param date the driving licence date
	 */
	public Customer(String cip, String name, String bonus, String date) {
		this.cip = cip;
		this.name = name;
		this.bonus=bonus;
		this.dateDrivingLicence=date;
	}


	/**
	 * @return the cip
	 */
	public String getCip() {
		return cip;
	}

	/**
	 * @param cip the cip to set
	 */
	public void setCip(String cip) {
		this.cip = cip;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the bonus level
	 */
	public String getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus level to set
	 */
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}


	/**
	 * @return the driving license date
	 */
	public String getDrivingLicenceDate() {
		return dateDrivingLicence;
	}

	/**
	 * @param dateDrivingLicence the date for the driving license to set
	 */
	public void setDrivingLicenceDate(String dateDrivingLicence) {
		this.dateDrivingLicence = dateDrivingLicence;
	}


	/**
	 * Compute bonus.
	 *
	 * @return a float corresponding to the percentage of granted bonus
	 */

	public float computeGrantedBonus(){
		return ((Integer.parseInt(this.getBonus())*100)/360);
	}
	

	/**
	 * Compute ages.
	 *
	 * @return an int corresponding to the number of days since dateDrivingLicence
	 */
	
	 public int computeAges(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date currentDate = new Date();
		int CurrentDateYear = Integer.parseInt((dateFormat.format(currentDate)).substring(0,4));
		int CurrentDateMonth = Integer.parseInt((dateFormat.format(currentDate)).substring(5,7));
		int CurrentDateDay = Integer.parseInt((dateFormat.format(currentDate)).substring(8,10));		

		String pastDate = this.dateDrivingLicence;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dummy = LocalDate.parse(pastDate, formatter);
		int years = Integer.parseInt((formatter.format(dummy)).substring(6));
		int months = Integer.parseInt((formatter.format(dummy)).substring(3,5));
		int days = Integer.parseInt((formatter.format(dummy)).substring(0,2));
		
		int result = CurrentDateDay + CurrentDateMonth * 30 + CurrentDateYear * 365;
		//return result;
		int result2 = days + months * 30 + years * 365;
		//return result2;
		return result - result2;

	 }
		 

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [cip=" + cip + 
			", name=" + name + 
			", numberGrantedBonus=" + this.computeGrantedBonus() + "%" + 
			", days from DrivingLicence=" + this.computeAges() + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cip == null) {
			if (other.cip != null)
				return false;
		} else if (!cip.equals(other.cip))
			return false;		
		return true;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   Customer est_1=null;
		   boolean w=false;
			// check arguments length
			    if ((args.length < 2)||(args.length%4!=0)) {
			        System.out.println("ERROR. Application needs almost two arguments for each Customer to be created");
			        System.out.println("Usage:");
			        System.out.println(" java Customer <arg1> <arg2> ... <argn>");
			        System.out.println(" arg1 cip and arg2 name for each new Customer.");

			        System.out.println();
			        return;
			    }
			    else{
			    	int i=0;
			    	while (i<args.length){
			    		// get arguments from command line
			
			    		// create Customer
			    		est_1= new Customer(args[i],args[i+1],args[i+2],args[i+3]);
		      
			    		if (est_1.getCip().equals("X")){
			    			System.out.println("Wrong Customer detected --> "+est_1);
			    			w=true;
			  
			    		}
			    		if (!w){
			    			System.out.println("New Customer info: "+est_1);
			    		}
			    		w=false;
			    	
			    		i+=4;
			    	}
		    
			    }	
			  String search="Charles";
			  Customer est_2=new Customer("4",search, "200", "01/01/1950");	  
		
		      if (est_1.equals(est_2)) {
		         System.out.println("Last Customer has the same cip than the pattern "+ search);
		      } else System.out.println("Last Customer not matching pattern");  
		      
		  
		}
	}