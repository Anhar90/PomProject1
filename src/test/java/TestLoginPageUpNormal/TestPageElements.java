package TestLoginPageUpNormal;

import Pages22.Point;
import org.testng.annotations.Test;

public class TestPageElements {





    Point p1;
    @Test
    public void validData()
    {
       System.out.println("Valid DAta");
        p1.print();

    }
    @Test
    public void inValidData()
    {
        p1=new Point();
        System.out.println("The inValid DAta");
        p1.print();

    }







}
