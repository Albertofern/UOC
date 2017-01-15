import java.util.Date;
/**
 * @author David_Doblas_Jiménez
 *
 */
public class Message {
	
	/**
	 * The attributes
	 */	
	private Customer sendTo;
	private Customer sendFrom;
	private String text;
	private String summary;
	private int priority;
	private Date date;
	private boolean read;


	/**
	 * Instantiates a new message.
	 * 
	 * @param sendTo the receiver
	 * @param sendFrom the transmitter
	 * @param text the message
	 * @param summary the summary of the message 
	 * @param priority the priority given value
	 */
	public Message(Customer sendTo, Customer sendFrom, int priority, String text) {
		this.sendTo = sendTo;
		this.sendFrom = sendFrom;		
		this.text = text;
		this.priority = priority;
		if (priority > 10) {
			this.priority = 10;
		}
		this.read = false;
		long now = System.currentTimeMillis();
		this.date = new java.util.Date(now);
		int pos = text.indexOf(".");
		if (pos > 0) {
			this.summary = text.substring(0, pos);
		}
		else this.summary = text;
	}
	
	// CONSTRUCTOR Overload
	public Message(Customer sendTo, Customer sendFrom){
		this.sendTo = sendTo;
		this.sendFrom = sendFrom;		
		this.text = "NA";
		this.priority = 0;
		this.read = false;
		this.summary = "NA";
	}

	/**
	 * @return receiver
	 */
	public Customer getReceiver() {
		return sendTo;
	}

	/**
	 * @param sendTo the receiver to set
	 */
	public void setReceiver(Customer sendTo) {
		this.sendTo = sendTo;
	}

	/**
	 * @return transmitter
	 */
	public Customer getTransmitter() {
		return sendFrom;
	}

	/**
	 * @param sendFrom the transmitter to set
	 */
	public void setTransmitter(Customer sendFrom) {
		this.sendFrom = sendFrom;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	/**
	 * @return priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority level to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @return the read
	 */
	public boolean isRead() {
		return read;
	}

	/**
	 * @param read the read to set
	 */
	public void setRead(boolean read) {
		this.read = read;
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
		if (!(obj instanceof Message))
			return false;
		Message other = (Message) obj;
		if (sendTo == null) {
			if (other.sendTo != null)
				return false;
		} else if (!sendTo.equals(other.sendTo))
			return false;
		if (sendFrom == null) {
			if (other.sendFrom != null)
				return false;
		} else if (!sendFrom.equals(other.sendFrom))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {	
		return "Message [sendTo: " + this.getReceiver().getName() + 
		       ", sendFrom: " + this.getTransmitter().getName() + 
		       ", summary=" + this.getSummary() + 
		       ", priority=" + this.getPriority() + 
		       ", text=" + this.getText() + 
		       ", date=" + this.getDate() + 
		       ", read=" + this.isRead() + "]";
	}
}
