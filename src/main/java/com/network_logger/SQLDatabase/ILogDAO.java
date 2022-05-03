package com.network_logger.SQLDatabase;

import java.sql.SQLException;

public interface ILogDAO {

    void createLog(String input, String inputTime, String output, String outputTime, String date, String request, String httpRequestType, boolean isError) throws SQLException;




    // ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
    // Exceptions

    class DALException extends Exception {
        public DALException(String msg){ super(msg); }
    }

    class WrongPasswordException extends DALException {
        private final String username;

        public WrongPasswordException(String username){
            super("Wrong password for user '" + username + "'");
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }


    class UserExistsException extends DALException {
        private final String username;

        public UserExistsException(String username){
            super("Unknown user '" + username + "'");
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }


    class UnknownUserException extends DALException {
        private final String username;

        public UnknownUserException(String username){
            super("Unknown user '" + username + "'");
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}
