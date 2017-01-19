package edu.uoc.dpoo;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private String subject;
    private String message;
    private MessageStatus status;
    private Date createdAt;
    private User to;
    private User from;
    
    public Message (User from, User to, String subject, String message) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
		long now = System.currentTimeMillis();
		this.createdAt = new java.util.Date(now);
		this.status = MessageStatus.PENDING;
    }


	public void read() {
        this.status = MessageStatus.READ;
    }
    
    public MessageStatus getStatus() {        
        return this.status;
    }

    public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("{date: " + format.format(this.createdAt) + ", ");
        sb.append("from: " + this.from.getFullName() + " <" + this.from.getUserName() + ">, ");
        sb.append("to: " + this.to.getFullName() + " <" + this.to.getUserName() + ">, ");
        sb.append("subject: " + this.subject + ", ");
        sb.append("status: " + this.status + "}");
        
        return sb.toString();
    	//return "";
    }
    
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }        
        if (obj instanceof Message) {
            Message m = (Message) obj;
            if (!this.from.equals(m.from) || 
            	!this.to.equals(m.to) || 
            	!this.subject.equals(m.subject) ||
            	!this.message.equals(m.message) ||
            	!this.createdAt.equals(m.createdAt)) 
            {
                return false;
            }        
            // Additional checks can be added
        } else {
            return false;
        }   
        return true;
	}
}
