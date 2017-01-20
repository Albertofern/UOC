package edu.uoc.dpoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a message
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 * @modified David Doblas Jiménez
 */

public class Platform {
    private List<User> users;
    private List<Competition> competitions;
       
    public Platform() {
        /**
         * PR1 Ex 2.1: We need to initialize the list of users
        */
        users = new ArrayList<User>();
        
        /**
         * PR2 Ex 2.1: We need to initialize the list of competitions
        */
        competitions = new ArrayList<Competition>();
    }
    
    private User findUser(String username) { 
        /**
         * PR1 Ex 2.1: Implementation of method findUser to find a user in the list users by username
        */
        User user = null;
        
        Iterator<User> it = this.users.iterator();      
        while(it.hasNext() && user == null) {
            User u = it.next();
            if(u.getUserName().equals(username)) {
                user = u;
            }
        }
        return user;
    }
        
    public User registerUser(String username, String password, String fullname) {        
        /**
         * PR1 Ex 2.1: Register a new user, checking that it does not exist 
        */
        User newUser = null;
        
        // Check if the user is new or already exists
        User queryUser = findUser(username);
        
        if(queryUser==null) {
            newUser = new User(this, username, password, fullname);
            this.users.add(newUser);
        }
        return newUser;
    }

    public User login(String username, String password) {    
        /**
         * PR1 Ex 2.2: Login an already existing user
        */
        User user = null;
        
        // Find the user in the list of registered users
        User queryUser = findUser(username);        
        
        // If the user exists, check the password
        if(queryUser != null && queryUser.checkPassword(password)) {
            user = queryUser;
        }
        return user;        
    }    
        
    public Integer getNumUsers() {
        /**
         * PR1 Ex 2.1: Required for test, to check if a new user is registered 
        */
        return this.users.size();
    }
    
    public Integer getNumCompetitions() {
        /**
         * PR2 Ex 2.1: Required to compute the new competition Id
        */
        return this.competitions.size();
    }
    
    public Message sendMessage(User from, String to, String subject, String message) throws CompetitionException {
        /**
         * PR2 Ex 1.2: Send a message to a user 
        */
    	// check for the addressee   	
    	if ((to == null) || (this.findUser(to) == null)) {
    		throw new CompetitionException(CompetitionException.RECIPIENT_NOT_FOUND);
    	}
    	// check for the sender
    	if (this.findUser(from.getUserName()) == null || !from.equals(findUser(from.getUserName()))) {
    		throw new CompetitionException(CompetitionException.SENDER_NOT_FOUND);
    	}
    	
    	// Create the message
    	Message m = new Message(from, this.findUser(to), subject, message);

        // Store the message in the inputbox of the recipient and the outputbox of the sender
        from.getOutbox().add(m);
        this.findUser(to).getInbox().add(m);
    	
    	return m;
    }
    
    public void registerCompetition(Competition competition) {
        /**
         * PR2 Ex 2.1: Register a new competition
        */
        this.competitions.add(competition);
    }    
    
    public List<Competition> getOpenCompetitions() {
        /**
         * PR2 Ex 2.2: Get open competitions
        */
        ArrayList<Competition> retList = new ArrayList<Competition>();
        
        // Add the "open" competitions to the output list
        for (Iterator<Competition> it = this.competitions.iterator(); it.hasNext(); ) {
            Competition comp = it.next();
            if(comp.isOpen()) {
                retList.add(comp);
            }
        }   
        return retList;
    }
    
    private void evaluateAll() {
        /**
         * PR2 Ex 3.2: Evaluate all pending submissions
        */
        for (Iterator<Competition> it = this.competitions.iterator(); it.hasNext(); ) {
            Competition comp = it.next();
            comp.evaluateAll();
        }    
    }
    
    public void run() {
        // Simulates system call for evaluation
        evaluateAll();
    }
}

