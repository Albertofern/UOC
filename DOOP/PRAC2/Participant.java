package edu.uoc.dpoo;

import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a message
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 * @modified David Doblas Jiménez
 */

public class Participant extends User {

    private List<Submission> submissions;
    
    public Participant(User user) {
        super(user);
        
        /**
         * PR2 Ex 3.1: Initialize the list of submissions
        */
        submissions = new ArrayList<Submission>();
    }

    public Submission submitPrediction(Competition competition, float prediction) {
        /**
         * PR2 Ex 3.1: Create a submission
        */
        Submission subm = new Submission(this, competition, prediction);
        
        // Add to associative fields
        this.submissions.add(subm);
        competition.getSubmissions().add(subm);
                
        return subm;
    }
    
    public List<Submission> getSubmissions() {
        /**
         * PR2 Ex 3.1: Required by tests
        */
        return submissions;
    }
}
