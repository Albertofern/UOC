package edu.uoc.dpoo;

import java.util.ArrayList;
import java.util.List;

public class Organizer extends User {
    private List<Competition> competitions;
    
    public Organizer(User user) {
        super(user);
        // Initialize the list of competitions
        competitions = new ArrayList<Competition>();                
    }

    public void removeSubmission(Submission submission) {
        /* NOT IMPLEMENTED */
    }

    public boolean sendMessage(Competition competition, String subject, String message) {
        /* NOT IMPLEMENTED */
        return false;
    }

    public Competition newCompetition(String title, float target) {        
        return null;
    }

    public void closeCompetition(Competition competition) {
        
    }
    
    public List<Competition> getCompetitions() {        
        return this.competitions;
    }
    
    private void updateCompetitions() {
        
    }
}
