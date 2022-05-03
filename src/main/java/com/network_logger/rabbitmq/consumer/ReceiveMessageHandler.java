package com.network_logger.rabbitmq.consumer;

import com.network_logger.SQLDatabase.ILogDAO;
import com.network_logger.SQLDatabase.LogDAO;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ReceiveMessageHandler {

    ILogDAO logDAO = new LogDAO();

    public void handleMessage(String messageBody) {
        try {
            JSONObject logJson = new JSONObject(messageBody);
            logDAO.createLog(logJson.getString("input"), logJson.getString("inputTime"),
                    logJson.getString("output"), logJson.getString("outputTime"),
                    logJson.getString("date"), logJson.getString("request"), logJson.getString("httpRequestType"),
                    logJson.getBoolean("isError"));
            System.out.println("log created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
