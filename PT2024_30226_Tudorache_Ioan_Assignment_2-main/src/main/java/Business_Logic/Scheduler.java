package Business_Logic;

import Model.Server;
import Model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler  {

    private List<Server> servers;
    private int maxNrServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNrServers,int maxTasksPerServer){
        servers = new ArrayList<>();
        for(int i = 0; i < maxNrServers;i++){
            Server ser = new Server();
            servers.add(ser);
            Thread serverThread = new Thread(ser);
            serverThread.start();
        }
    }
    public void changeStrategy(SelectionPolicy policy){

        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ShortestQueueStrategy();
        }
        else if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new TimeStrategy();
        }
    }

    public synchronized void dispatchTask(Task task) throws InterruptedException {
        strategy.addTask(servers,task);
    }
    public enum SelectionPolicy{
        SHORTEST_TIME,SHORTEST_QUEUE;
    }
    public int getNumberOfClients(){
        int count = 0;
        for(Server server: servers){
            count+= server.getNrTasks();
        }
        return count;
    }

    public synchronized int getWaitingPeriod(Task task){

        int count = 0;
        for(Server server: servers){
            for(Task t: server.getTasks()){
                if(t.equals(task)){
                    count+= server.getWatingPeriod();
                    return count;
                }
            }
        }
        return count;
    }

    public boolean verify(){
        if(servers.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean verifyQueues(){
        boolean ver = false;
        for(Server server: servers){
            if(server.getNrTasks() > 0){
                ver = true;
            }
        }
        return ver;
    }
    public synchronized String toString(){
        String fullString = "";
        int numberQueue = 0;
        for(Server server: servers){
            fullString+="Queue "+ numberQueue + ":";
            for(Task task:server.getTasks()){
                if(task != null && server.getNrTasks() !=0){
                    fullString+=  task.toString();
                }
            }
            fullString+= "\n";
            numberQueue++;
        }
        return fullString;
    }
}
