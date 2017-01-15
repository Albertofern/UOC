/**
 * @author David_Doblas_Jiménez
 *
 */
public class Message {
	
	/**
	 * The attributes
	 */	
	private String text;
	private Customer sendTo;
	private Customer sendFrom;


	/**
	 * Instantiates a new message.
	 * 
	 * @param sendTo the receiver
	 * @param sendFrom the transmitter
	 * @param text the message
	 */
	public Message(Customer sendTo, Customer sendFrom, String text) {
		this.sendTo = sendTo;
		this.sendFrom = sendFrom;		
		this.text = text;	
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {	
		return "Message [sendTo: " + this.getReceiver().getName() + 
			", sendFrom: " + this.getTransmitter().getName() + 
			", text=" + this.getText() + "]";
	}
}
