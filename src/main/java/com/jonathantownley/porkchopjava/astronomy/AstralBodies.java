package com.jonathantownley.porkchopjava.astronomy;

import java.util.ArrayList;
import java.util.HashMap;

public class AstralBodies {

    private String name;
    private String sourceFile;

    // trajectory is a map where K = time and V = state vector where
    // state vector is a list where element 0 is Double[3] position
    // and element 1 is Double[3] velocity
    private HashMap<Double, ArrayList<Double[]>> trajectory;

    public AstralBodies(String name, String sourceFile) {
        this.name = name;
        this.sourceFile = sourceFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public HashMap<Double, ArrayList<Double[]>> getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(HashMap<Double, ArrayList<Double[]>> trajectory) {
        this.trajectory = trajectory;
    }

    public Double[] getPositionAtEpoch(double epoch)
    {
        ArrayList<Double[]> stateVector = trajectory.get(epoch);
        return stateVector.get(0);
    }

    public void setPositionAtEpoch(double epoch, Double[] position)
    {
        // Get the state vector, velocity for this epoch
        ArrayList<Double[]> stateVector = trajectory.get(epoch);
        Double[] velocity = stateVector.get(1);

        // Reset the state vector with old velocity and new position
        stateVector.clear();
        stateVector.add(0, position);
        stateVector.add(1, velocity);

        // Reset the trajectory with updated state vector
        trajectory.put(epoch,stateVector);
    }

    public Double[] getVelocityAtEpoch(double epoch)
    {
        ArrayList<Double[]> stateVector = trajectory.get(epoch);
        return stateVector.get(1);
    }

    public void setVelocityAtEpoch(double epoch, Double[] velocity)
    {
        // Get the state vector, position for this epoch
        ArrayList<Double[]> stateVector = trajectory.get(epoch);
        Double[] position = stateVector.get(0);

        // Reset the state vector with old position and new velocity
        stateVector.clear();
        stateVector.add(0, position);
        stateVector.add(1, velocity);

        // Reset the trajectory with updated state vector
        trajectory.put(epoch,stateVector);
    }

    public boolean readTrajectoryFromHorizonsFile()
    {
        return false;
    }
}
