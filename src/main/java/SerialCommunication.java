import jssc.SerialPort;
import jssc.SerialPortList;

public class SerialCommunication {

    private SerialPort serialPort;


    public SerialCommunication(){}

    public String[] getSerialPortList(){
        return SerialPortList.getPortNames();

    }

    public void sendCommand(int command){
        System.out.println(command);
    }

}