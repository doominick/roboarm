import jssc.SerialPortList;

public class RoboArm {

    public static void main(String[] args){
        Gui gui = new Gui();
        gui.draw();

        String[] portNames = SerialPortList.getPortNames();

        for(String port : portNames){
            System.out.println(port);
            gui.addPortToList(port);
        }

        if (portNames.length == 0){
            System.out.println("Brak portow");
        }
    }
}