//package Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadRespond implements Runnable{
    
    private ServerSocket server;
    private int port;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public MultiThreadRespond(int port){
        this.port = port;
        try{
           server = new ServerSocket(port);
        }catch(Exception e){
            
        }

    }

    @Override
    public void run(){
        while(true){
            try{
                Socket socket = server.accept();
                //read from socket to ObjectInputStream object
                ois = new ObjectInputStream(socket.getInputStream());
                //convert ObjectInputStream object to String

                //create ObjectOutputStream object
                oos = new ObjectOutputStream(socket.getOutputStream());
                //write object to Socket

                //close resources
                ois.close();
                oos.close();
                socket.close();
                //terminate the server if client sends exit request

            }catch(Exception e){

            }

        }
    }

}
