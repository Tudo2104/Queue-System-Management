package Business_Logic;

import Model.Server;
import Model.Task;

import javax.lang.model.type.NullType;
import java.util.List;

public class ShortestQueueStrategy implements Strategy{


    @Override
    public void addTask(List<Server> servers, Task task) throws InterruptedException {
        if (servers.isEmpty()) {
            return;
        }

        Server firstServer = servers.get(0);
        if (firstServer == null) {
            throw new IllegalStateException("No servers available to add the task.");
        }

        Server saveServer = firstServer;
        int sizeMin = firstServer.getTasks().length;

        for (int i = 1; i < servers.size(); i++) {
            Server currentServer = servers.get(i);
            int sizeServer = currentServer.getTasks().length;
            if (sizeServer < sizeMin) {
                sizeMin = sizeServer;
                saveServer = currentServer;
            }
        }
        saveServer.addTask(task);
    }
}
