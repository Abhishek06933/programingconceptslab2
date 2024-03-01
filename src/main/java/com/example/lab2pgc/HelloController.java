package com.example.lab2pgc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public static class HelloController implements Initializable {

    @FXML
    public TextField Aid;

    @FXML
    public TextField Aguestname;

    @FXML
    public TextField Aroom;

    @FXML
    public TextField Apayment;

    @FXML
    public Label User__Name;

    @FXML
    public Button Load;


    @FXML
    private TableColumn<hotel, Integer> id;

    @FXML
    private TableColumn<hotel, String> guestname;

    @FXML
    private TableColumn<hotel, Integer> room;

    @FXML
    private TableColumn<hotel, Integer> payment;

    @FXML
    private TableView<hotel> tableView;

    private final ObservableList<hotel> list = FXCollections.observableArrayList();
    private ActionEvent actionEvent;


    public HelloController() {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        guestname.setCellValueFactory(new PropertyValueFactory<>("guestname"));
        room.setCellValueFactory(new PropertyValueFactory<>("room"));
        payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        tableView.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        this.populateTable();
    }

    public void populateTable() {
        list.clear();
        String jdbcUrl = "jdbc:mysql://localhost:3306/assignment2";
        String dbUser = "root";
        String dbPassword = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            try {
                String query = "SELECT * FROM ` lab2__pc2`";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String guestname = resultSet.getString("guestname");
                    int room = resultSet.getInt("room");
                    int payment = resultSet.getInt("payment");
                    this.tableView.getItems().add(new hotel(id, guestname, room, payment));
                }
            } catch (Throwable var14) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var13) {
                        var14.addSuppressed(var13);
                    }
                }

                throw var14;
            }

            connection.close();
        } catch (SQLException var15) {
            var15.printStackTrace();
        }
    }
    public void InsertTable(String Aid, String Aguestname, String Aroom, String Apayment) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/assignment2";
        String dbUser = "root";
        String dbPassword = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            try {
                String query = "INSERT INTO `lab2__pc2`( `id`, `guestname`, `room`, `payment`) VALUES ('" + Aid + "','" + Aguestname + "','" + Aroom + "','" + Apayment+ "')";
                Statement statement = connection.createStatement();
                statement.execute(query);
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var11) {
                        var12.addSuppressed(var11);
                    }
                }

                throw var12;
            }

            connection.close();
        } catch (SQLException var13) {
            var13.printStackTrace();
        }

    }

    @FXML
    private void DeleteData(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
        String Aid = this.Aid.getText();
        String jdbcUrl = "jdbc:mysql://localhost:3306/assignment2";
        String dbUser = "root";
        String dbPassword = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            try {
                String query = "DELETE FROM `lab2__pc2` WHERE id='" + Aid + "'";
                Statement statement = connection.createStatement();
                statement.execute(query);
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                    }
                }

                throw var10;
            }

            connection.close();
        } catch (SQLException var11) {
            var11.printStackTrace();
        }

    }
}
public void UpdateData() {
    UpdateData(null);
}

public void UpdateData(ActionEvent actionEvent) {
    String Aid = this.Aid.getText();
    String Aguestname = this.Aguestname.getText();
    String Aroom = this.Aroom.getText();
    String Apayment = this.Apayment.getText();
    String jdbcUrl = "jdbc:mysql://localhost:3306/assignment2";
    String dbUser = "root";
    String dbPassword = "";

    try {
        Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

        try {
            String query = STR."UPDATE `lab2__pc2` SET `guestname`='\{Aguestname}',`room`='\{Aroom}',`payment`='\{Apayment}' WHERE id='\{Aid}'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            this.populateTable();
        } catch (Throwable var14) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var13) {
                    var14.addSuppressed(var13);
                }
            }

            throw var14;
        }

        connection.close();
    } catch (SQLException var15) {
        var15.printStackTrace();
    }

}

public void main() {
}

private class Aid {
}

