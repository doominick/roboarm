class Arm {

    Arm(){}

    int setRotationPosition(int degree){
        return degree;
    }

    int setLeftMotorPosition(int degree){
        return degree+2000;
    }

    int setRightMotorPosition(int degree){
        return degree+1000;
    }

    int setGrabberPosition(int degree){
        return degree+3000;
    }

    public int closeGrabber(){
        return 3180;
    }

    public int openGrabber(){
        return 3000;
    }
}