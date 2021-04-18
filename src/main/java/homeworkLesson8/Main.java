package homeworkLesson8;

public class Main {
    public static void main(String[] args) {
        Participants[] participants = {new Cat("Sosiska"), new Human("Oleg"), new Robot("R2PO"), new Cat("Leopold", 1250, 1.7), new Human("Xavier Kipchoge", 42195,2.45), new Robot("TAUB-Xin", 134030, 3.2)};
        Obstacles[] obstacles = {new RunningTrack(250), new Wall(1), new RunningTrack(500), new Wall(1.5), new RunningTrack(1000), new Wall(2), new RunningTrack(2000), new Wall(2.5)};

        for (int i = 0; i < participants.length; i++) {
            participants[i].printParticipantInfo(i);
            for (int j = 0; j < obstacles.length; j++) {
                obstacles[j].printInfo(j);
                obstacles[j].overcomeObstacle(participants[i]);
                if( participants[i].isFailState()){
                    break;
                }
            }
        }
        System.out.println();
    }

}




