package edu.uoc.dpoo;

import java.util.Date;

/**
 * This class represents a message
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 * @modified David Doblas Jiménez
 */

public class Submission implements Comparable<Submission> {
    private Integer id;
    private Participant participant;
    private Competition competition;    
    private SubmissionStatus status;
    private Date submittedAt;
    private float prediction;
    private float error;
    
    /**
     * PR2 Ex 3.1: Class attribute to manage new IDs
    */
    private static Integer lastID = 0;
      
    public Submission(Participant participant, Competition competition, float prediction) {
        /**
         * PR2 Ex 3.1: Create a submission
        */
        this.participant = participant;
        this.competition = competition;
        this.status = SubmissionStatus.PENDING;
        this.submittedAt = new Date();
        this.prediction = prediction;
        this.id=Submission.lastID + 1;
        
        Submission.lastID = this.id;
    }
    
    public SubmissionStatus getStatus() {
        /**
         * PR2 Ex 3.1: Required by tests
        */
        return status;
    }
    
    public float getError() {
        /**
         * PR2 Ex 3.2: Required by tests
        */
        return this.error;
    }
    
    public void setError(float error) {
        /**
         * PR2 Ex 3.2: Set error value
        */
        this.error = error;
        this.status = SubmissionStatus.DONE;
    }
    
    public float getPrediction() {
        /**
         * PR2 Ex 3.1: Required to calculate the error value
        */
        return prediction;
    }
    
    public Participant getParticipant() {
        /**
         * PR2 Ex 3.4: Required to obtain the owner of the submission
        */
        return this.participant;
    }
    
    /**
     * PR2 Ex 3.3: Implement compare to method
    */
    public int compareTo(Submission submission) {
        int retVal;
        if(this.status != submission.status) {
            if(this.status == SubmissionStatus.DONE) {                
                retVal = 1;
            } 
            else {
                retVal=0;
            }
        } 
        else {
            retVal = new Float(this.error).compareTo(submission.getError());
        }
        return retVal;
    }
}
