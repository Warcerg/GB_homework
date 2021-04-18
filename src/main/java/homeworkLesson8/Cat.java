package homeworkLesson8;

public class Cat implements Participants {
    private String name;
    protected int maxRunDistance = 1000;
    protected double maxJumpHeight = 2.5;
    private boolean failState = false;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int maxRunDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void printParticipantInfo(int i) {
        System.out.println(" Participant " + (i+1) + " - Cat " + name);
    }

    @Override
    public void run(int distance) {
        if (maxRunDistance >= distance) {
            System.out.println(" Cat " + name + " ran the whole track");
        } else {
            System.out.println(" Cat " + name + " failed to run the whole track. Better luck next time!");
            failState = true;
        }
    }

    public boolean isFailState() {
        return failState;
    }

    @Override
    public void jump(double height) {
        if (maxJumpHeight >= height) {
            System.out.println(" Cat " + name + " jumped over the wall");
        } else {
            System.out.println(" Cat " + name + " failed to jump over the wall. Better luck next time!");
            failState = true;
        }
    }
}
