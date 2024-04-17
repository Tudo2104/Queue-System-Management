package Business_Logic;

import Model.Server;
import Model.Task;

import java.util.List;

public class TimeStrategy implements Strategy {

    public void addTask(List<Server> servers, Task task) throws InterruptedException {
        Server firstServer;
        if (servers.isEmpty()) {
            firstServer = null;
        } else {
            firstServer = servers.get(0);
        }
        if (firstServer == null) {
            throw new IllegalStateException("No servers available to add the task.");
        }

        Server saveServer = firstServer;
        int timeMin = firstServer.getWatingPeriod();

        for (int i = 1; i < servers.size(); i++) {
            Server currentServer = servers.get(i);
            int timeServer = currentServer.getWatingPeriod();
            if (timeServer < timeMin) {
                timeMin = timeServer;
                saveServer = currentServer;
            }
        }
        saveServer.addTask(task);
    }
}
