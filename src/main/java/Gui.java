import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

 class Gui {

    private JFrame window = new JFrame();

    private FlowLayout windowLayout = new FlowLayout();

    private JLabel rotationSliderLabel = new JLabel("Rotation");

    private JLabel grabberSliderLabel = new JLabel("Grabber");

    private JSlider rotationSlider = new JSlider();

    private JSlider grabberSlider = new JSlider();

    private JLabel leftArmSliderLabel = new JLabel("Left motor");

    private JSlider leftArmSlider = new JSlider();

    private JLabel rightArmSliderLabel = new JLabel("Right motor");

    private JSlider rightArmSlider = new JSlider();

    private JComboBox<String> portList = new JComboBox<>();

    private JButton connectButton = new JButton("Connect");

    private MouseListener saveWhenMouseReleased = new saveWhenMouseReleased();

    private Arm arm = new Arm();

    private SerialCommunication serial = new SerialCommunication();

    public Gui(){}

    public void draw(){

        window.setTitle("RoboArm");
        window.setLayout(windowLayout);
//      Dimension windowSize = new Dimension(300, 300);
//      window.setPreferredSize(windowSize);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (connectButton.getText().equals("Connect")){
                    serial.connect(portList.getSelectedItem().toString());
                }
            }
        });

        rotationSlider.setMaximum(180);
        rotationSlider.addChangeListener(changeEvent -> serial.sendCommand(arm.setRotationPosition(rotationSlider.getValue())));
        rotationSlider.addMouseListener(saveWhenMouseReleased);

        grabberSlider.setMaximum(180);
        grabberSlider.addChangeListener(changeEvent -> serial.sendCommand(arm.setGrabberPosition(grabberSlider.getValue())));
        grabberSlider.addMouseListener(saveWhenMouseReleased);

        leftArmSlider.setMaximum(180);
        leftArmSlider.addChangeListener(changeEvent -> serial.sendCommand(arm.setLeftMotorPosition(leftArmSlider.getValue())));
        leftArmSlider.addMouseListener(saveWhenMouseReleased);

        rightArmSlider.setMaximum(180);
        rightArmSlider.addChangeListener(changeEvent -> serial.sendCommand(arm.setRightMotorPosition(rightArmSlider.getValue())));
        rightArmSlider.addMouseListener(saveWhenMouseReleased);

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
    }

    public void addPortToList(String portName){
        this.portList.addItem(portName);
    }
}