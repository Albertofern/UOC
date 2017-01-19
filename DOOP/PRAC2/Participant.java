package edu.uoc.dpoo;

import java.util.List;

public class Participant extends User {

    private List<Submission> submissions;
    
    public Participant(User user) {
        super(user);      
    }

    public Submission submitPrediction(Competition competition, float prediction) {
        return null;
    }
    
    public List<Submission> getSubmissions() {        
        return submissions;
    }

}
