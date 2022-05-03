package com.network_logger.SQLDatabase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDAO implements ILogDAO {

    DBConnector connector = new DBConnector();


    @Override
    public void createLog(String input, String inputTime, String output, String outputTime, String date, String request, String httpRequesteType, boolean isError) throws SQLException {

        Connection connection = connector.connectToRemoteDB();

        //Add log to database.
        PreparedStatement addLog = connection.prepareStatement("INSERT INTO account_log (date, input_time, input, output_time, output, request, http_request_type, isError)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
        addLog.setString(1, date);
        addLog.setString(2, inputTime);
        addLog.setString(3, input);
        addLog.setString(4, outputTime);
        addLog.setString(5, output);
        addLog.setString(6, request);
        addLog.setString(7, httpRequesteType);
        addLog.setBoolean(8, isError);
        addLog.execute();
    }
}
