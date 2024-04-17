package Business_Logic;

import GUI.SimulationFrame;
import Model.Task;

import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class SimulationManager implements Runnable{

    public static int timeLimit ;
    public static int maxProcessingTime;
    public static int minProcessingTime;
    public static int maxArrivalTime;
    public static int minArrivalTime;
    public static int numberOfServers;
    public static int numberofClients;
    private String out = "";
    public static Scheduler.SelectionPolicy selectionPolicy;
    private Scheduler scheduler;
    private  SimulationFrame frame ;
    private List<Task> generatedTasks;
    private final Object fileLock = new Object();

    public SimulationManager(SimulationFrame frame){
        this.frame = frame;
        scheduler = new Scheduler(numberOfServers,numberofClients);
        scheduler.changeStrategy(selectionPolicy);
        generatedTasks = new ArrayList<>();
        generateNRandomTasks();

    }


    private void generateNRandomTasks(){
        int processingTime;
        int arrivalTime;
        Random random = new Random();
        for(int i = 0; i < numberofClients; i++){
            processingTime = random.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime;
            arrivalTime = random.nextInt(maxArrivalTime-minArrivalTime) + minArrivalTime;
            generatedTasks.add(new Task(i+1,arrivalTime,processingTime));
        }
        Comparator<Task> timeComparator = Comparator.comparing(Task::getArrivalTime);
        generatedTasks.sort(timeComparator);

    }
    public void writerFile(String output,boolean app){
        synchronized (fileLock){

            String fName = "output.txt";
            try {
                FileWriter fWriter = new FileWriter(fName,app);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                bWriter.write(output);
                bWriter.close();
            } catch (IOException e) {
                System.err.println("Error writing to the file: " + e.getMessage());
            }
        }
    }
    @Override
    public void run() {
        int currentTime = 0;
        int peekHour = -1;
        int maxPeekHour = -1;
        int maxTime = 0;
        int serviceAvgTime = 0;
        int curWaitingPer = 0;
        boolean remainingClients = true;
        writerFile("",false);
        while(currentTime <= timeLimit && remainingClients){
            out+="Time: "+currentTime +"\n";
            List<Task> removeTask = new ArrayList<>();
            if(generatedTasks.isEmpty() && !scheduler.verifyQueues()){
                remainingClients = false;
            }
            else{
                out+="Waiting: ";

                for(Task task: generatedTasks){

                    if(task.getArrivalTime() == currentTime){

                        serviceAvgTime+=task.getServiceTime();
                        try {
                            scheduler.dispatchTask(task);
                            curWaitingPer += scheduler.getWaitingPeriod(task);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        removeTask.add(task);
                    }
                    else{

                            out+=task.toString()+"  ";

                    }

                }
                peekHour = scheduler.getNumberOfClients();
                if(peekHour > maxPeekHour){
                    maxPeekHour = peekHour;
                    maxTime =  currentTime;

                }
                out+="\n";
                if(scheduler.verify()){
                        out+=scheduler.toString()+"\n";

                }

                frame.setjOutputText(out);
                writerFile(out,true);

                generatedTasks.removeAll(removeTask);
                currentTime++;
                out="";
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        String output = "Finished\n" +
                "Peak Time: " + maxTime + "\n" +
                "Average Service Time: " + String.format("%.2f", (double) serviceAvgTime / numberofClients) + "\n" +
                "Average Waiting Time: " + String.format("%.2f", (double) curWaitingPer / numberofClients);

        writerFile(output,true);
        frame.setjOutputText(output);
    }

}
