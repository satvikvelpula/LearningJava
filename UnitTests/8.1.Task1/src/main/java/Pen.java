public class Pen {
    private String draw_color;
    private boolean isCapOn;

    public enum Color {

        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;

        Color(String color) {
            this.color = color;
        };

        @Override
        public String toString() { return color; }
    }

    public Pen() {
        this.draw_color = Color.RED.toString();
        this.capOn();
    }

    public Pen(Color provided_color_enum) {
        this.draw_color = provided_color_enum.toString();
        this.capOn();
    }

    public String drawable() {
        return "Drawing " + draw_color;
    }

    public boolean capOn() {
        return isCapOn = true;
    }

    public boolean capOff() {
        return isCapOn = false;
    }

    public String draw() { // main draw method
        if (isCapOn) {
            return "";
        } else {
            return drawable();
        }
    }

    public void changeColor(Color color) {
        if (isCapOn) {
            draw_color = color.color;
        }
    }


    /*


        public String capOff() {
        if (givenColorParameter) {
            draw_color = Color.RED.toString();
        }

        if (!givenColorParameter) {
            printable = "Drawing " + draw_color;
        }

        return printable;
    }


     */
}