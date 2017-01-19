package edu.uoc.dpoo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class User implements CompetitionListener {
    private Platform platform;
    private String username;
    private String password;
    private String fullName;
    private List<Message> inbox;
    private List<Message> outbox;
    private List<Submission> submissions;
    
    /**
     * This atribute stores the list of non-read messages
     */
    private ArrayList<Message> nonread;

    public User (Platform platform, String username, String password, String fullName) {
        /**
         * PR1 Ex 2.1: User constructor needed for user registration
         */
        this.platform = platform;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.inbox = new ArrayList<Message>();
        this.outbox = new ArrayList<Message>();
        this.submissions = new ArrayList<Submission>();
    }

    public User (User obj) {
        /**
         * PR1 Ex 2.3: Implementation of the copy constructor
         */
        this.platform = obj.platform;
        this.username = obj.username;
        this.password = obj.password;
        this.fullName = obj.fullName;
        this.inbox = obj.inbox;
        this.outbox = obj.outbox;
        this.submissions = obj.submissions;
    }
                
    public Boolean checkPassword(String password) {   
        /**
         * PR1 Ex 2.2: Implementation of checkPassword, required by login
        */
        return this.password.equals(password);        
    }

    public Organizer asOrganizer() {   
        /**
         * PR1 Ex 2.3: Create a new object for the Organizer Role
         */
        return new Organizer(this);
    }

    public Participant asParticipant() {
        /**
         * PR1 Ex 2.3: Create a new object for the Participant Role
         */
        return new Participant(this);
    }

    public String getUserName() {
        /**
         * PR1 Ex 2.1: Required by method findUser
         */
        return this.username;
    }

    public String getFullName() {
        /**
         * PR1 Ex 2.1: Required by test
         */
        return this.fullName;
    }

    public String toString() {
        /**
         * PR2 Ex 1.1: Required for Message toString
         */
        StringBuilder sb = new StringBuilder();
        sb.append("" + this.fullName + ""); 
        sb.append("<" + this.username + ">");  
        return sb.toString();
    }

    public boolean equals(Object obj) {
        /**
         * PR1 Ex 2.2: Required by test
        */
        if(obj==null) {
            return false;
        }        
        if (obj instanceof User) {
            User user = (User) obj;
            if (!this.username.equals(user.username) ||
                !this.password.equals(user.password) || 
                !this.fullName.equals(user.fullName)) 
            {
                return false;
            }        
        // Additional checks can be added
        }
        else {
            return false;
        }
        return true;
    }

    public List<Message> getMessages() {
        /**
         * PR2 Ex 1.3: Get unread messages
        */
        for (Iterator<Message> it = inbox.iterator(); it.hasNext();) {
            Message m = (Message) it.next();
            if (m.getStatus().equals(MessageStatus.PENDING)) {
                nonread.add(m);
            }
        }
        return nonread;
    }

    public Message sendMessage(String to, String subject, String message) throws CompetitionException {
        /**
         * PR2 Ex 1.2: Send a message to a user 
         */        
        return this.getPlatform().sendMessage(this, to, subject, message);
    }
        
    public List<Competition> myCompetitions() {
       /* NOT IMPLEMENTED */
        return null;
    }

    public List<Message> getInbox() {
        /**
         * PR2 Ex 1.2: Required by tests
        */
        return this.inbox;
    }

    public List<Message> getOutbox() {
        /**
         * PR2 Ex 1.2: Required by tests
        */
        return this.outbox;
    }    
    
    public Platform getPlatform() {
        /**
         * PR2 Ex 2.1: Required by Organizer.newCompetition
        */
        return this.platform;
    }
    
    public void onNewEvaluation() {

    }
    public void onCompetitionClosed() {

    }
}
