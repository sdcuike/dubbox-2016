package com.doctor.dubbo.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doctor.dubbo.threadPool.ThreadPoolExecutorUtil.ThreadPoolExecutorInfo;

/**
 * @author sdcuike
 *
 *         Created on 2016年7月17日 下午4:15:11
 */
public class DubboThreadPoolExecutor extends ThreadPoolExecutor {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public DubboThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public DubboThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public DubboThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public DubboThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        ThreadPoolExecutorInfo threadPoolExecutorInfo = ThreadPoolExecutorUtil.getInfo(this);
        log.info("threadPoolExecutorInfo:" + threadPoolExecutorInfo);
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        ThreadPoolExecutorInfo threadPoolExecutorInfo = ThreadPoolExecutorUtil.getInfo(this);
        log.info("threadPoolExecutorInfo:" + threadPoolExecutorInfo);

    }

}
