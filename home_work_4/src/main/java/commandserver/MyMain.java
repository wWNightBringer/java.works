package commandserver;

import java.util.Map;

public class MyMain {
    public static void main(String[] args) {
        Server server=new Server(8080);
        server.start(100);
    }
}
