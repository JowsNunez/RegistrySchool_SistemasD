
package com.registryschool.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Objects;

/**
 *
 * @author el_fr
 */
public class Client {

    private String idClient;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public Client() {
       
    }

    public Client(String idClient) {
        this.idClient = idClient;
    }

   

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
     public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Client{" + "socket=" + socket + ", idClient=" + idClient + '}';
    }

}
