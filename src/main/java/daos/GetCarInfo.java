package daos;

import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetCarInfo implements Tools{
    private Connection connection;
    private Statement stmt;

    public GetCarInfo() throws SQLException {
        this.connection = DatabaseConn.getConnection();
        this.stmt = connection.createStatement();

    }

    public Object findbyId(int id) {

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM new_table WHERE id=" + id);
            //ResultSet rs = stmt.executeQuery("SELECT * FROM new_table WHERE id=7");

                if(rs.next()){

                    return new Car(
                            rs.getInt("id"),
                            rs.getString("make"),
                            rs.getString("model"),
                            rs.getInt("year"),
                            rs.getString("color"),
                            rs.getString("vin"));

                }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public List findAll() throws SQLException {
        List<Car> listCars = new ArrayList<Car>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM new_table");
        while(rs.next()){
            listCars.add(
                    new Car(
                            rs.getInt("id"),
                            rs.getString("make"),
                            rs.getString("model"),
                            rs.getInt("year"),
                            rs.getString("color"),
                            rs.getString("vin")
                    )
            );
        }

        return listCars;




    }

    public Object update(Object Car) {
        return null;
    }

    public Car update(Car updateCar) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("UPDATE new_table SET make=?, model=?, year=?,color=?,vin=? WHERE id=?");

        ps.setString(1, updateCar.getMake());
        ps.setString(2, updateCar.getModel());
        ps.setInt(3, updateCar.getYear());
        ps.setString(4, updateCar.getColor());
        ps.setString(5, updateCar.getVin());
        ps.setInt(6,updateCar.getId());
        int i = ps.executeUpdate();




        return null;
    }

    public Object create(Object Car) {

        return null;
    }

    public void  create(Car car) throws SQLException {

        StringBuilder a = new StringBuilder();
        a.append("INSERT INTO new_table(id,make, model, year, color, vin) VALUES ('");
        a.append(car.getId() + "', '");
        a.append(car.getMake() + "', '");
        a.append(car.getModel() + "', '");
        a.append(car.getYear() + "', '");
        a.append(car.getColor() + "', '");
        a.append(car.getVin() + "')");



        stmt.execute(a.toString());
    }

    public void delete(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate("DELETE FROM new_table WHERE id=" + id);


    }
}
