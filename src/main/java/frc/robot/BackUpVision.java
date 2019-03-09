/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import org.opencv.imgcodecs.Imgcodecs;
import java.util.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;


/**
 * Add your docs here.
 */
public class BackUpVision {
    public static void main(String[] args){
        System.load("C:\\Users\\Robotics\\Desktop\\frc\\opencv\\build\\java\\x64\\opencv_java400.dll");
        Mat img1 = new Mat();
        img1 = Imgcodecs.imread("C:\\Users\\Robotics\\Desktop\\pastedimage0.png");
        Mat img2 = new Mat();
        //Core.inRange(img1, new Scalar(0, 155, 0), new Scalar(15, 255, 15), img2);
        Core.inRange(img1, new Scalar(0, 75, 0), new Scalar(75, 255, 10), img2);
        List<MatOfPoint> contours = new ArrayList<>();
        MatOfPoint2f approxCurve = new MatOfPoint2f();
        Imgproc.findContours(img2, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);  
        Imgproc.cvtColor(img2, img2, Imgproc.COLOR_GRAY2BGR);
        Imgproc.drawContours(img2, contours, -1, new Scalar (0,255,0), 3);
        

        for (int i = 0; i<contours.size(); i++) {
          Imgproc.drawContours(img1, contours, i, new Scalar (255,255,0), 5);
          MatOfPoint2f contours2f = new MatOfPoint2f(contours.get(i).toArray());
          double approxDistance = Imgproc.arcLength(contours2f, true)*0.03;
          Imgproc.approxPolyDP(contours2f, approxCurve, approxDistance, true);
          MatOfPoint points = new MatOfPoint(approxCurve.toArray());
          Rect rect = Imgproc.boundingRect(points);
          Imgproc.rectangle(img2, new Point(rect.x,rect.y), new Point(rect.x+rect.width, rect.y+rect.height), new Scalar(255,0,255), 3);
        }
        Imgcodecs.imwrite("C:\\Users\\Robotics\\Desktop\\final.png", img2);
      }
    }
    //
    

