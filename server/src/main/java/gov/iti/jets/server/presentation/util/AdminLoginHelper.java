package gov.iti.jets.server.presentation.util;

import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.util.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginHelper {
    private final static AdminLoginHelper adminLoginHelper = new AdminLoginHelper();
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private Connection connection;
    private String phone;

    private AdminLoginHelper(){
        try {
            connection = DataSourceFactory.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AdminLoginHelper getInstance() {
        return adminLoginHelper;
    }

    public boolean changeAdminPassword(String password){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update admin_login set password = ? where phone = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, phone);
            preparedStatement.executeUpdate();
            stageCoordinator.switchToLoginScene();
        }catch(SQLException e){
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean getAdmin(String phone , String password){
        this.phone=phone;
        String defaultPassword = "123456";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from admin_login where phone = ?");
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                if(phone.equals(resultSet.getString(1)) && password.equals(resultSet.getString(2))){
                    if(password.equals(defaultPassword)){
                        stageCoordinator.switchToChangePasswordScene();
                    }else{
                        stageCoordinator.switchToDashboardScene();
                    }
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }




}
