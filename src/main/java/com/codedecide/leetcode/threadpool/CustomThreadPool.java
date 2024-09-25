package com.codedecide.leetcode.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author geckostroll
 * @version CustomThreadPool.java 2024年09月25日
 */
public class CustomThreadPool {

    // 线程池初始化时的线程数量
    private int initialSize;
    // 任务队列
    private BlockingQueue<Runnable> taskQueue;
    // 用于存放和管理工作线程的集合
    private List<WorkerThread> threads;
    // 是否已经被shutdown标志
    private volatile boolean isShutdown = false;

    public CustomThreadPool(int initialSize) {
        this.initialSize = initialSize;
        taskQueue = new LinkedBlockingQueue<>();
        threads = new ArrayList<>(initialSize);
        // 初始化方法，创建一定数量的工作线程，并启动它们
        for (int i = 0; i < initialSize; i++) {
            WorkerThread workerThread = new WorkerThread(taskQueue);
            workerThread.start();
            threads.add(workerThread);
        }
    }

    // 实现execute方法，用于将任务加入到任务队列，并通知工作线程来执行
    public void execute(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("ThreadPool is shutdown");
        }
        taskQueue.offer(task);
    }

    // 关闭线程池, 等待所有线程执行完毕
    public void shutdown() {
        // 修改状态
        isShutdown = true;
        for (WorkerThread thread : threads) {
            // 中断线程
            thread.interrupt();
        }
    }

    public List<Runnable> shutdownNow() {
        // 修改状态
        isShutdown = true;
        // 清空队列
        List<Runnable> remainingTasks = new ArrayList<>();
        taskQueue.drainTo(remainingTasks);

        // 中断所有线程
        for (WorkerThread thread : threads) {
            thread.interrupt();
        }
        // 返回未执行任务集合
        return remainingTasks;
    }

    // 定义一个工作线程类
    public static class WorkerThread extends Thread {
        // 用于从任务队列中取出并执行任务
        private BlockingQueue<Runnable> taskQueue;

        // 构造方法，传入任务队列
        public WorkerThread(BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }

        // 重写run方法
        @Override
        public void run() {
            // 循环执行，直到线程被中断
            while (!Thread.currentThread().isInterrupted() && !taskQueue.isEmpty()) {
                try {
                    // 从任务队列中取出一个任务，如果队列为空，则阻塞等待
                    Runnable task = taskQueue.take();
                    // 执行任务
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                    // 如果线程被中断，则退出循环
                    break;
                }
            }
        }
    }
}