package es.netmind.mypersonalbankapi.exceptions;

public class ClientNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClientNotfoundException(String message) {
        super(message);
    }
}
