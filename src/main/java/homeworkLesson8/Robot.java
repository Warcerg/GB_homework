package homeworkLesson8;

public class Robot implements Participants{
    private String name;
    protected int maxRunDistance = 400;
    protected double maxJumpHeight = 0.6;
    private boolean failState = false;

    @Override
    public void printParticipantInfo(int i) {
        System.out.println(" Participant " + (i+1) + " - Robot " + name);
    }

    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, int maxRunDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run(int distance) {
        if (maxRunDistance >= distance) {
            System.out.println(" Robot " + name + " ran the whole track");
        } else {
            System.out.println(" Robot " + name + " failed to run the whole track. Better luck next time!");
            failState = true;
        }
    }

    @Override
    public void jump(double height) {
        if (maxJumpHeight >= height) {
            System.out.println(" Robot " + name + " jumped over the wall");
        } else {
            System.out.println(" Robot " + name + " failed to jump over the wall. Better luck next time!");
            failState = true;
        }
    }

    public boolean isFailState() {
        return failState;
    }
}
