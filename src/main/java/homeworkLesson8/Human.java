package homeworkLesson8;

public class Human implements Participants{
    private String name;
    protected int maxRunDistance = 3000;
    protected double maxJumpHeight = 1.5;
    private boolean failState = false;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int maxRunDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void printParticipantInfo(int i) {
        System.out.println(" Participant " + (i+1) + " - Human " + name );
    }

    public void run(int distance) {
        if (maxRunDistance >= distance) {
            System.out.println(" Human " + name + " ran the whole track");
        } else {
            System.out.println(" Human " + name + " failed to run the whole track. Better luck next time!");
            failState = true;
        }
    }

    @Override
    public void jump(double height) {
        if (maxJumpHeight >= height) {
            System.out.println(" Human " + name + " jumped over the wall");
        } else {
            System.out.println(" Human " + name + " failed to jump over the wall. Better luck next time!");
            failState = true;
        }
    }

    public boolean isFailState() {
        return failState;
    }
}
