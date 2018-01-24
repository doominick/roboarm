import jssc.SerialPort;
import jssc.SerialPortList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class RoboArm {

    static SerialPort serialPort;

    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setTitle("RoboArm");
        FlowLayout windowLayout = new FlowLayout();
        window.setLayout(windowLayout);
//      Dimension windowSize = new Dimension(300, 300);
//      window.setPreferredSize(windowSize);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        JLabel rotationSliderLabel = new JLabel("Rotation");

        MouseListener saveWhenMouseReleased = new saveWhenMouseReleased();

        JSlider rotationSlider = new JSlider();
        rotationSlider.setMaximum(180);
        rotationSlider.addChangeListener(e -> System.out.println(rotationSlider.getValue()));
        rotationSlider.addMouseListener(saveWhenMouseReleased);

        JLabel grabberSliderLabel = new JLabel("Grabber");

        JSlider grabberSlider = new JSlider();
        grabberSlider.setMaximum(180);
        grabberSlider.addChangeListener(changeEvent -> System.out.println(grabberSlider.getValue()+3000));

        JLabel leftArmSliderLabel = new JLabel("Left motor");

        JSlider leftArmSlider = new JSlider();
        leftArmSlider.setMaximum(180);
        leftArmSlider.addChangeListener(changeEvent -> System.out.println(leftArmSlider.getValue()+2000));

        JLabel rightArmSliderLabel = new JLabel("Right motor");

        JSlider rightArmSlider = new JSlider();
        rightArmSlider.setMaximum(180);
        rightArmSlider.addChangeListener(changeEvent -> System.out.println(rightArmSlider.getValue()+1000));

        JComboBox<String> portList = new JComboBox<>();
        JButton connectButton = new JButton("Connect");

        window.add(portList);
        window.add(connectButton);
        window.add(rotationSliderLabel);
        window.add(rotationSlider);
        window.add(rightArmSliderLabel);
        window.add(rightArmSlider);
        window.add(leftArmSliderLabel);
        window.add(leftArmSlider);
        window.add(grabberSliderLabel);
        window.add(grabberSlider);
        window.pack();
        window.setVisible(true);

        String[] portNames = SerialPortList.getPortNames();

        for(String port : portNames){
            System.out.println(port);
            portList.addItem(port);
        }

        if (portNames.length == 0){
            System.out.println("Brak portow");
        }
    }
}