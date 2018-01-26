import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
import java.lang.Thread;

public class SerialCommunication {

    private SerialPort serialPort;


    public SerialCommunication(){}

    public void connect(String portName){
        serialPort = new SerialPort(portName);
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            Thread.sleep(1500);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void disconnect(){
        try {
            System.out.println("Port closed: " + serialPort.closePort());
        } catch (SerialPortException e) {
            System.out.println(e);
        }
    }

    public String[] getSerialPortList(){
        return SerialPortList.getPortNames();

    }

    public void sendCommand(int command){
        try {
            System.out.println(command + " sent: " + serialPort.writeInt(command));
        } catch (SerialPortException e){
            System.out.println(e);
        }
    }

}