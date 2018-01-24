import java.util.ArrayList;

public class ArmSequence {

    private ArrayList<ArmPosition> sequence = new ArrayList<>();

    public ArmSequence(ArrayList<ArmPosition> sequence){
        this.sequence=sequence;
    }

    public void add(ArmPosition position){
        this.sequence.add(position);
    }

    public void add(int rotationPosition, int leftMotorPosition, int rightMotorPosition, int grabberPosition){
        ArmPosition position = new ArmPosition(rotationPosition, leftMotorPosition, rightMotorPosition, grabberPosition);
        this.sequence.add(position);
    }

    public void remove(int positionIndex){
        this.sequence.remove(positionIndex);
    }

    public void update(int positionIndex, ArmPosition position){
        this.sequence.set(positionIndex, position);
    }

    public void update(int positionIndex, int rotationPosition, int leftMotorPosition, int rightMotorPosition, int grabberPosition){
        ArmPosition position = new ArmPosition(rotationPosition, leftMotorPosition, rightMotorPosition, grabberPosition);
        this.sequence.set(positionIndex, position);
    }

    public ArmPosition get(int positionIndex){
        return this.sequence.get(positionIndex);
    }

}