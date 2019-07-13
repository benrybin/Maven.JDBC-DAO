package daos;

import models.Car;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class GetCarInfoTest {
    GetCarInfo test;

    @Test
    public void findbyId() throws SQLException {
        GetCarInfo temp = new GetCarInfo();
       System.out.println(temp.findbyId(8));
    }

    @Test
    public void findAll() throws SQLException {
        GetCarInfo temp = new GetCarInfo();
        System.out.println(temp.findAll().toString());
    }

    @Test
    public void update() throws SQLException {
        GetCarInfo temp = new GetCarInfo();
        temp.update(new Car(8,"Honda","CRV",1997,"Red","3V47865"));
        System.out.println(temp.findbyId(8).toString());

    }

    @Test
    public void create() throws SQLException {
        Car temp = new Car(7,"Honda","CRV",1995,"Red","3V47865");
        GetCarInfo test = new GetCarInfo();
        test.create(temp);


    }

    @Test
    public void delete() throws SQLException {
        GetCarInfo temp = new GetCarInfo();
        System.out.println(temp.findAll().toString());
        temp.delete(7);
        System.out.println(temp.findAll().toString());


    }
}