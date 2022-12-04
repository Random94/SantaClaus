package main.java.totalizator;



public class Participant {

    private String nameGifter;
    private String nameGifted;

    public Participant(String nameGifter) {
        this.nameGifter = nameGifter;
    }

    public String getNameGifter() {
        return nameGifter;
    }

    public void setNameGifter(String nameGifter) {
        this.nameGifter = nameGifter;
    }

    public String getNameGifted() {
        return nameGifted;
    }

    public void setNameGifted(String nameGifted) {
        this.nameGifted = nameGifted;
    }
}
