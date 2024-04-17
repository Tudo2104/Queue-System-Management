package Model;

public class Task {

    private int ID;
    private int arrivalTime;
    private int serviceTime;


    public Task(int ID,int arrivalTime,int serviceTime){

        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime =serviceTime;

    }

    public int getID(){

            return this.ID;
    }
    public  synchronized int getArrivalTime(){

        return this.arrivalTime;
    }

    public  synchronized int getServiceTime(){

        return this.serviceTime;
    }

    public synchronized void decServiceTime(){
        this.serviceTime--;
    }

    public  synchronized String toString() {
        return  "(" +"I: "+ID +"," + "A: "+arrivalTime +","+"S: "+ serviceTime + ")";
    }

}
