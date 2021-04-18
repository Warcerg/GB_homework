package homeworkLesson8;

public class RunningTrack implements Obstacles{
    protected int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public void overcomeObstacle(Participants participants){
        participants.run(getDistance());
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void printInfo(int j){
        System.out.print("Obstacle " + (j + 1) + " - Running track: distance " + distance + " meters.");
    }

}
