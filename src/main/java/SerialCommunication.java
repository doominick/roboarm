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
            System.out.println("Params set: " + serialPort.setParams(9600, 8, 1, 0));
            Thread.sleep(2000);
            System.out.println(serialPort.readString());
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
            System.out.println(serialPort.readString());
        } catch (SerialPortException e){
            System.out.println(e);
        }
    }

    public void sendString(String string){
        try {
            System.out.println(string + " sent: " + serialPort.writeBytes(string.getBytes()));
            System.out.println(serialPort.readString());
        } catch (SerialPortException e){
            System.out.println(e);
        }
    }

}