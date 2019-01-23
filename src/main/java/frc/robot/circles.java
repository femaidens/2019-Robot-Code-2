package frc.robot;

import java.util.ArrayList;
import java.util.List;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class circles {
    public static void main(String[] args) {
        System.load("C:\\Users\\Robotics\\Desktop\\frc\\opencv\\build\\java\\x64\\opencv_java400.dll");
   
        Mat mat = new Mat();
        Mat mat2 = new Mat();
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        List <MatOfPoint> contours = new ArrayList<>();

        mat = Imgcodecs.imread("C:\\Users\\Robotics\\Downloads\\circles.jpg");
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2HSV);
        Core.inRange(mat, new Scalar(105,100,100), new Scalar(135, 255,255), mat2); 
        //hsv range depends on hue value. Hue values are given on stack overflow
        Core.inRange(mat, new Scalar(0, 100, 100), new Scalar(15,255,255), mat4);
        Core.add(mat2, mat4, mat3);
        Imgproc.findContours(mat3, contours , new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        
        Imgproc.cvtColor(mat3, mat3, Imgproc.COLOR_GRAY2BGR);
        Imgproc.cvtColor(mat3, mat3, Imgproc.COLOR_BGR2HSV);
        Imgproc.drawContours(mat3, contours, -1, new Scalar(60,255,255), 2);
        Imgcodecs.imwrite("C:\\Users\\Robotics\\Desktop\\circles1.jpg", mat3);
        
    }
}
