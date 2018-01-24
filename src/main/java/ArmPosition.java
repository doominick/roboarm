public class ArmPosition {

    private int rotationPosition;

    private int leftMotorPosition;

    private int rightMotorPosition;

    private int grabberPosition;

    public ArmPosition(int rotationPosition, int leftMotorPosition, int rightMotorPosition, int grabberPosition){
        this.rotationPosition = rotationPosition;
        this.leftMotorPosition = leftMotorPosition;
        this.rightMotorPosition = rightMotorPosition;
        this.grabberPosition = grabberPosition;
    }

    public int getRotationPosition() {
        return rotationPosition;
    }

    public void setRotationPosition(int rotationPosition) {
        this.rotationPosition = rotationPosition;
    }

    public int getLeftMotorPosition() {
        return leftMotorPosition;
    }

    public void setLeftMotorPosition(int leftMotorPosition) {
        this.leftMotorPosition = leftMotorPosition;
    }

    public int getRightMotorPosition() {
        return rightMotorPosition;
    }

    public void setRightMotorPosition(int rightMotorPosition) {
        this.rightMotorPosition = rightMotorPosition;
    }

    public int getGrabberPosition() {
        return grabberPosition;
    }

    public void setGrabberPosition(int grabberPosition) {
        this.grabberPosition = grabberPosition;
    }
}