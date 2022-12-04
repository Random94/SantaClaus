package main.java.totalizator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Randomizer {


    public void randomize(){
        generateTextFiles(assignGiftedToGifter(getParticipantListFromUser()));
    }

    private List<Participant> getParticipantListFromUser(){

        List<Participant> participants = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String newName;
        do{
            newName = scanner.nextLine();
            participants.add(new Participant(newName));
        }while(newName!=null && !newName.equals(""));
        participants.removeIf(r->r.getNameGifter().equals(""));
        return participants;
    }

    private List<Participant> assignGiftedToGifter(List<Participant> participants){

        List<String> giftedPool = new ArrayList<>();
        participants.forEach(r->giftedPool.add(r.getNameGifter()));
        int randomVal;

        for(Participant participant:participants){
            do{
                randomVal = (int) Math.round(Math.random() * giftedPool.size());
            }while(randomVal>=giftedPool.size()||participant.getNameGifter().equals(giftedPool.get(randomVal)));
            participant.setNameGifted(giftedPool.get(randomVal));
            giftedPool.remove(randomVal);
        }
        return participants;
    }

    private void generateTextFiles(List<Participant> participants) {
        for(Participant participant:participants) {
            try (FileWriter writer = new FileWriter("C:\\Users\\pawel\\Desktop\\Wyniki\\"+participant.getNameGifter()+".txt.")) {
                writer.write(participant.getNameGifted());
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
