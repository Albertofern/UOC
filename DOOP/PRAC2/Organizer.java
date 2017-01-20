package edu.uoc.dpoo;

import java.util.ArrayList;
import java.util.List;

public class Organizer extends User {
    private List<Competition> competitions;
    
    public Organizer(User user) {
        super(user);
        // Initialize the list of competitions
        competitions = new ArrayList<Competition>();
        
        /**
         * PR2 Ex 2.2: When creating a new organizer, we need to update the competitions
        */
        updateCompetitions();
    }

    public void removeSubmission(Submission submission) {
        /* NOT IMPLEMENTED */
    }

    public boolean sendMessage(Competition competition, String subject, String message) {
        /* NOT IMPLEMENTED */
        return false;
    }

    public Competition newCompetition(String title, float target) {
        /**
         * PR2 Ex 2.1: Create a new competition
        */
        Competition newComp = new Competition(this.getPlatform(), this, title, target);
        
        // Register the competition to the platform
        this.getPlatform().registerCompetition(newComp);
             
        // Add to the list of competitions of the user
        this.competitions.add(newComp);
        
        return newComp;
    }

    public void closeCompetition(Competition competition) {
        /**
         * PR2 Ex 2.2: 
        */ 
        competition.close();
        
        /**
         * PR2 Ex 2.3: Update competitions 
        */ 
        // When closing a competition, we need to update the competitions
        updateCompetitions();
        
    }
    
    public List<Competition> getCompetitions() {
        /**
         * PR2 Ex 2.1: Required by test
        */
        return this.competitions;
    }
    
    private void updateCompetitions() {
        /**
         * PR2 Ex 2.3: Update the list of competitions
        */
        competitions.clear();
        
        // Get the list of competitions from the platform
        List<Competition> currentCompetitions = this.getPlatform().getOpenCompetitions();        
        
        // Add the "open" competitions that belong to "this" owner
        for (Iterator<Competition> it = currentCompetitions.iterator(); it.hasNext(); ) {
            Competition c = it.next();
            if(this.equals(c.getOwner())) {
                this.competitions.add(c);
            }
        }   
    }
}
