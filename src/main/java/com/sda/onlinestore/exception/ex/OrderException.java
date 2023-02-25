package com.sda.onlinestore.exception.ex;

public class OrderException extends RuntimeException {
    public OrderException(String message){
        super(message);
    }

    public static class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(String message)
        {
            super(message);
        }
    }

    public static class UserAlreadyTakenException extends RuntimeException {
        public UserAlreadyTakenException(String message)
        {
            super(message);
        }

    }
}
