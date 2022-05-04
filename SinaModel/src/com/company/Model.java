package com.company;

public class Model {

    public Model(){

    }

    private double neck_x = 0 ;
    private double neck_y = 0 ;
    private double neck_z = 0 ;

    public String getNeck(){
        return this.neck_x + "," + this.neck_y + "," + this.neck_z ;
    }

    public void setNeck(double x , double y , double z){
        this.neck_x = x ;
        this.neck_y = y ;
        this.neck_z = z ;
    }

    private double waist_x = 0 ;
    private double waist_y = 0 ;
    private double waist_z = 0 ;

    public String getWaist(){
        return this.waist_x + "," + this.waist_y + "," + this.waist_z ;
    }

    public void setWaist(double x , double y , double z){
        this.waist_x = x ;
        this.waist_y = y ;
        this.waist_z = z ;
    }

    private double leftShoulder_x = Math.PI / 4  ;
    private double leftShoulder_y = 0 ;
    private double leftShoulder_z = 41.8 ;

    public String getLeftShoulder(){
        return this.leftShoulder_x + "," + this.leftShoulder_y + "," + this.leftShoulder_z ;
    }

    public void setLeftShoulder(double x , double y , double z){
        this.leftShoulder_x = x ;
        this.leftShoulder_y = y ;
        this.leftShoulder_z = z ;
    }


    private double rightShoulder_x = Math.PI / 4  ;
    private double rightShoulder_y = 0 ;
    private double rightShoulder_z = -41.8 ;

    public String getRightShoulder(){
        return this.rightShoulder_x + "," + this.rightShoulder_y + "," + this.rightShoulder_z ;
    }

    public void setRightShoulder(double x , double y , double z){
        this.rightShoulder_x = x ;
        this.rightShoulder_y = y ;
        this.rightShoulder_z = z ;
    }

    private double leftElbow_x = 0 ;
    private double leftElbow_y = 0 ;
    private double leftElbow_z = 0 ;

    public String getLeftElbow(){
        return this.leftElbow_x + "," + this.leftElbow_y + "," + this.leftElbow_z ;
    }

    public void setLeftElbow(double x , double y , double z){
        this.leftElbow_x = x ;
        this.leftElbow_y = y ;
        this.leftElbow_z = z ;
    }



    private double rightElbow_x = 0 ;
    private double rightElbow_y = 0 ;
    private double rightElbow_z = 0 ;

    public String getRightElbow(){
        return this.rightElbow_x + "," + this.rightElbow_y + "," + this.rightElbow_z ;
    }

    public void setRightElbow(double x , double y , double z){
        this.rightElbow_x = x ;
        this.rightElbow_y = y ;
        this.rightElbow_z = z ;
    }


    private double leftWrist_x = 0 ;
    private double leftWrist_y = 0 ;
    private double leftWrist_z = 0 ;

    public String getLeftWrist(){
        return this.leftWrist_x + "," + this.leftWrist_y + "," + this.leftWrist_z ;
    }

    public void setLeftWrist(double x , double y , double z){
        this.leftWrist_x = x ;
        this.leftWrist_y = y ;
        this.leftWrist_z = z ;
    }

    private double rightWrist_x = 0 ;
    private double rightWrist_y = 0 ;
    private double rightWrist_z = 0 ;

    public String getRightWrist(){
        return this.rightWrist_x + "," + this.rightWrist_y + "," + this.rightWrist_z ;
    }

    public void setRightWrist(double x , double y , double z){
        this.rightWrist_x = x ;
        this.rightWrist_y = y ;
        this.rightWrist_z = z ;
    }


    private double leftThigh_x = 0 ;
    private double leftThigh_y = 0 ;
    private double leftThigh_z = Math.PI ;

    public String getLeftThigh(){
        return this.leftThigh_x + "," + this.leftThigh_y + "," + this.leftThigh_z ;
    }

    public void setLeftThigh(double x , double y , double z){
        this.leftThigh_x = x ;
        this.leftThigh_y = y ;
        this.leftThigh_z = z ;
    }


    private double rightThigh_x = 0 ;
    private double rightThigh_y = 0 ;
    private double rightThigh_z = Math.PI  ;

    public String getRightThigh(){
        return this.rightThigh_x + "," + this.rightThigh_y + "," + this.rightThigh_z ;
    }

    public void setRightThigh(double x , double y , double z){
        this.rightThigh_x = x ;
        this.rightThigh_y = y ;
        this.rightThigh_z = z ;
    }


    private double leftKnee_x = 0 ;
    private double leftKnee_y = 0 ;
    private double leftKnee_z = 0 ;

    public String getLeftKnee(){
        return this.leftKnee_x + "," + this.leftKnee_y + "," + this.leftKnee_z ;
    }

    public void setLeftKnee(double x , double y , double z){
        this.leftKnee_x = x ;
        this.leftKnee_y = y ;
        this.leftKnee_z = z ;
    }


    private double rightKnee_x = 0 ;
    private double rightKnee_y = 0 ;
    private double rightKnee_z = 0 ;

    public String getRightKnee(){
        return this.rightKnee_x + "," + this.rightKnee_y + "," + this.rightKnee_z ;
    }

    public void setRightKnee(double x , double y , double z){
        this.rightKnee_x = x ;
        this.rightKnee_y = y ;
        this.rightKnee_z = z ;
    }


    private double leftAnkle_x = Math.PI / 3 ;
    private double leftAnkle_y = 0 ;
    private double leftAnkle_z = 0 ;

    public String getLeftAnkle(){
        return this.leftAnkle_x + "," + this.leftAnkle_y + "," + this.leftAnkle_z ;
    }

    public void setLeftAnkle(double x , double y , double z){
        this.leftAnkle_x = x ;
        this.leftAnkle_y = y ;
        this.leftAnkle_z = z ;
    }


    private double rightAnkle_x = Math.PI / 3 ;
    private double rightAnkle_y = 0 ;
    private double rightAnkle_z = 0 ;

    public String getRightAnkle(){
        return this.rightAnkle_x + "," + this.rightAnkle_y + "," + this.rightAnkle_z ;
    }

    public void setRightAnkle(double x , double y , double z){
        this.rightAnkle_x = x ;
        this.rightAnkle_y = y ;
        this.rightAnkle_z = z ;
    }

















    public String body(){
        String r = "" ;
        r += ( this.getNeck() + ";" ) ;
        r += ( this.getWaist() + ";" ) ;
        r += ( this.getLeftShoulder() + ";" ) ;
        r += ( this.getRightShoulder() + ";" ) ;
        r += ( this.getLeftElbow() + ";" ) ;
        r += ( this.getRightElbow() + ";" ) ;
        r += ( this.getLeftWrist() + ";" ) ;
        r += ( this.getRightWrist() + ";" ) ;
        r += ( this.getLeftThigh() + ";" ) ;
        r += ( this.getRightThigh() + ";" ) ;
        r += ( this.getLeftKnee() + ";" ) ;
        r += ( this.getRightKnee() + ";" ) ;
        r += ( this.getLeftAnkle() + ";" ) ;
        r += ( this.getRightAnkle() + ";" ) ;
        return r ;
    }


}
