package edu.uoc.dpoo;

/**
 * This class represents a message
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 * @modified David Doblas Jiménez
 */

public interface CompetitionListener {
    public void onNewEvaluation();
    public void onCompetitionClosed();
}
