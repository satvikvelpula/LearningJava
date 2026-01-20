public class TelevisionViewer {

    private int channel = 0;
    private boolean isOn;

    public int setChannel(int channel_num) {
        return channel = channel_num;
    }

    public int getChannel() {
        return channel;
    }


    public boolean isOn() {
        return isOn;
    }

    public boolean pressOnOff() {
        if (isOn) {
            isOn = false;
        } else {
            isOn = true;
        }

        return isOn;
    }


    public static void main(String[] args) {
        TelevisionViewer myTV = new TelevisionViewer();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (myTV.isOn() == false) // if myTV is not turned on
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() > 10) {
                    myTV.setChannel(1);
                }
                if (myTV.getChannel() % 4 == 0) {
                    tired = true;
                }

            }

            myTV.pressOnOff();

            System.out.println("Falling asleep");
        }
    }

}