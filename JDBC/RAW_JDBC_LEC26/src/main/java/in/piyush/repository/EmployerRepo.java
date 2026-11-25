package in.piyush.repository;

import in.piyush.model.Employer;

import java.sql.*;

public class EmployerRepo {


    String url = "jdbc:mysql://localhost:3306/JDBCdemo";
    String name = "root";
    String password = "root";


    public void createEmployer(){
        try{
            Connection connection = DriverManager.getConnection(url,name,password);

            //------------------------------------------------------------

            Statement statement = connection.createStatement();

            String query = "Insert INTO employer(name, email, age) VALUES ('piyush' , 'piy123@gmail.com' , 21)";

            int result = statement.executeUpdate(query);

            if (result == 1) System.out.println("Employer registerd sucessfully");

            else System.out.println("something went wrong!! TRY AGAIN");

            //------------------------------------------------------------

            connection.close();
        }




        catch (Exception e){
            System.out.println("connection to database is failed!!");
            System.out.println(e.getMessage());
        }

    }


    public void createEmployer1(Employer employer){
        try{
            Connection connection = DriverManager.getConnection(url,name,password);

            //------------------------------------------------------------


            String query = """
                            Insert INTO employer(name, email, age) VALUES (?,?,?)
                            """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1 , employer.getName());
            preparedStatement.setString(2 , employer.getEmail());
            preparedStatement.setInt(3 , employer.getAge());


            int result = preparedStatement.executeUpdate();

            if (result == 1) System.out.println("Employer registerd sucessfully");

            else System.out.println("something went wrong!! TRY AGAIN");

            //------------------------------------------------------------

            connection.close();
        }


        catch (Exception e){
            System.out.println("connection to database is failed!!");
            System.out.println(e.getMessage());
        }

    }



    public void updateEmployer(){
        try{
            Connection connection = DriverManager.getConnection(url,name,password);
            //------------------------------------------------------------

            Statement statement = connection.createStatement();

            String query = "UPDATE employer SET age = 22 where id = 1";

            int result = statement.executeUpdate(query);

            if (result == 1) System.out.println("Employer updated sucessfully");

            else System.out.println("something went wrong!! TRY AGAIN");

            //------------------------------------------------------------

            connection.close();
        }


        catch (Exception e){
            System.out.println("connection to database is failed!!");
            System.out.println(e.getMessage());
        }

    }





    public void deleteEmployer(){
        try{
            Connection connection = DriverManager.getConnection(url,name,password);
            //------------------------------------------------------------

            Statement statement = connection.createStatement();

            String query = "DELETE from employer where id = 2";

            int result = statement.executeUpdate(query);

            if (result == 1) System.out.println("Employer deleted sucessfully");

            else System.out.println("something went wrong!! TRY AGAIN");

            //------------------------------------------------------------

            connection.close();
        }


        catch (Exception e){
            System.out.println("connection to database is failed!!");
            System.out.println(e.getMessage());
        }

    }



    public void getEmployerByID(){
        try{
            Connection connection = DriverManager.getConnection(url,name,password);
            //------------------------------------------------------------

            Statement statement = connection.createStatement();

            String query = "Select id,name,email,age from employer where id = 3";

            ResultSet result = statement.executeQuery(query);

            result.next();

            Employer emp = maptostd(result);

            System.out.println(emp);

            //------------------------------------------------------------

            connection.close();
        }


        catch (Exception e){
            System.out.println("connection to database is failed!!");
            System.out.println(e.getMessage());
        }

    }


    private Employer maptostd(ResultSet resultSet) throws SQLException {

        Employer employer = new Employer();

        employer.setId(resultSet.getLong(1));
        employer.setName(resultSet.getString(2));
        employer.setEmail(resultSet.getString(3));
        employer.setAge(resultSet.getInt(4));


        return employer;

    }




    public void getAllEmployer(){
        try{
            Connection connection = DriverManager.getConnection(url,name,password);
            //------------------------------------------------------------

            Statement statement = connection.createStatement();

            String query = "Select id,name,email,age from employer";

            ResultSet result = statement.executeQuery(query);

            while (result.next()){

                result.next();

                Employer emp = maptostd(result);

                System.out.println(emp);
            }

            //------------------------------------------------------------

            connection.close();
        }


        catch (Exception e){
            System.out.println("connection to database is failed!!");
            System.out.println(e.getMessage());
        }

    }

}
