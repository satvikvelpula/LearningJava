public interface Vehicle {



    default boolean start() {
        return true;
    }

    default boolean stop() {
        return true;
    }

    default boolean getInfo() {
        return true;
    }


}