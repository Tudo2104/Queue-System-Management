package Model;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server implements Runnable {
    private final BlockingQueue<Task> tasks;
    private final AtomicInteger waitingPeriod;
    private final Lock taskLock = new ReentrantLock();

    public Server() {
        this.tasks = new LinkedBlockingQueue<>();
        this.waitingPeriod = new AtomicInteger(0);
    }

    public void addTask(Task newTask) {
        taskLock.lock();
        try {
            tasks.add(newTask);
            int newWaitingTime = waitingPeriod.addAndGet(newTask.getServiceTime());
            if (newWaitingTime < 0) {
                throw new IllegalStateException("Waiting period should never go below zero.");
            }
        } finally {
            taskLock.unlock();
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            taskLock.lock();
            try {
                Task currentTask = tasks.peek();
                if (currentTask != null) {
                    currentTask.decServiceTime();
                    int newWaitingTime = waitingPeriod.decrementAndGet();
                    if (newWaitingTime < 0) {
                        throw new IllegalStateException("Waiting period should never go below zero.");
                    }

                    if (currentTask.getServiceTime() <= 0) {
                        tasks.poll();
                    }
                }
            } finally {
                taskLock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public Task[] getTasks() {
        taskLock.lock();
        try {
            return tasks.toArray(new Task[0]);
        } finally {
            taskLock.unlock();
        }
    }

    public int getNrTasks() {
        taskLock.lock();
        try {
            return tasks.size();
        } finally {
            taskLock.unlock();
        }
    }

    public int getWatingPeriod() {
        return waitingPeriod.get();
    }
}
