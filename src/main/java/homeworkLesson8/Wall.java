package homeworkLesson8;

public class Wall implements Obstacles{
    protected double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public void overcomeObstacle(Participants participants) {
        participants.jump(getHeight());
    }

    public void printInfo(int j){
        System.out.print("Obstacle " + (j + 1) + " - Wall: height " + height + " meters.");
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
