package repository;

import config.Mysqlconfig;
import model.UsersModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Userepository {
    public List<UsersModel> findByEmailAndPassword(String email, String password){
        Connection connection = null;
        List<UsersModel> usermodellist = new ArrayList<>();
        try {
            String sql = "select * from users u where u.email = ? and u.password = ?";
            PreparedStatement statement =  Mysqlconfig.getConnection().prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
//                Duyệt từng dòng dữ liệu
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt("id"));
                usersModel.setEmail(resultSet.getString("email"));
                usersModel.setFullname(resultSet.getString("fullname"));
                usersModel.setRoleId(resultSet.getInt("role_id"));
                usermodellist.add(usersModel);
            }
        }catch(Exception e) {
            System.out.print("Error findByEmailAndPassword" + e.getMessage());
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.print("Lỗi đóng kết nối findByEmailAndPassword");
                }
            }
        }
        return usermodellist;
    };
    public List<UsersModel> findUser(){
        Connection connection = null ;
        List<UsersModel> usermodellist = new ArrayList<>();
        try {
            String sql = "select * from users";
            PreparedStatement statement =  Mysqlconfig.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
//                Duyệt từng dòng dữ liệu
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt("id"));
                usersModel.setEmail(resultSet.getString("email"));
                usersModel.setFullname(resultSet.getString("fullname"));
                usersModel.setRoleId(resultSet.getInt("role_id"));
                usermodellist.add(usersModel);
            }
        }catch(Exception e) {
            System.out.print("Error findUser" + e.getMessage());
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.print("Lỗi đóng kết nối findUser");
                }
            }
        }
        return usermodellist;
    }

}
