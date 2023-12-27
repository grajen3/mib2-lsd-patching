/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.fw.util.commons.job.CheckBlockedInterceptor;
import de.esolutions.fw.util.commons.job.DispatcherBase$FinishedNowInterceptor;
import de.esolutions.fw.util.commons.job.IBlockedJobHandler;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.job.RunInterceptor;
import de.esolutions.fw.util.commons.job.StatisticData;
import de.esolutions.fw.util.commons.job.StatisticInterceptor;
import de.esolutions.fw.util.commons.job.TimedJobQueue;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.PrintStream;

public class DispatcherBase
implements Runnable,
DumpInfoProvider {
    private static final long WAIT_FOR_THREAD_SHUTDOWN;
    private final String name;
    private final ITimeSource timeSource;
    private final IJobLogger log;
    private final JobQueue queue;
    private final ThreadPool threadPool;
    private volatile int priority = 5;
    private volatile boolean started = false;
    private volatile boolean threadActive = false;
    private volatile Thread workerThread = null;
    private volatile Thread pendingThread = null;
    private volatile IInterceptor interceptors;
    private volatile CheckBlockedInterceptor checker;
    private volatile StatisticInterceptor statistic;

    public DispatcherBase(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, ThreadPool threadPool) {
        this(string, iTimeSource, iJobLogger, new TimedJobQueue(iTimeSource), threadPool);
    }

    public DispatcherBase(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, JobQueue jobQueue, ThreadPool threadPool) {
        this(string, iTimeSource, iJobLogger, jobQueue, new RunInterceptor(), threadPool);
    }

    public DispatcherBase(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, JobQueue jobQueue, IInterceptor iInterceptor, ThreadPool threadPool) {
        this.name = string;
        this.timeSource = iTimeSource;
        this.log = iJobLogger;
        this.queue = jobQueue;
        this.threadPool = threadPool;
        this.statistic = null;
        this.setBlockedHandler(0L, null);
        this.addInterceptor(iInterceptor);
        this.addInterceptor(new DispatcherBase$FinishedNowInterceptor(iTimeSource));
    }

    public DispatcherBase(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, JobQueue jobQueue, IInterceptor iInterceptor, Job job, ThreadPool threadPool) {
        this(string, iTimeSource, iJobLogger, jobQueue, iInterceptor, threadPool);
    }

    public final String getDispatcherName() {
        return this.name;
    }

    public final ITimeSource getTimeSource() {
        return this.timeSource;
    }

    public final JobQueue getQueue() {
        return this.queue;
    }

    public final IJobLogger getLog() {
        return this.log;
    }

    public final void setPriority(int n) {
        if (this.log != null) {
            this.log.log(1078071040, "%1 set priority to %2", (Object)this, n);
        }
        this.priority = n;
        Thread thread = this.workerThread;
        if (thread != null) {
            thread.setPriority(n);
        }
    }

    protected final int getPriority() {
        return this.priority;
    }

    public Job executeJob(Job job) {
        if (this.checker != null && !this.isDispatchThread()) {
            this.checker.checkJobBlocked();
        }
        this.queue.enqueue(job);
        return job;
    }

    public Job execute(Object object) {
        return this.executeJob(new Job(object));
    }

    public Job execute(Object object, long l) {
        return this.executeJob(new Job(object, this.timeSource.getCurrentTime() + l));
    }

    public synchronized void start() {
        if (!this.isActive()) {
            this.setStarted(true);
            this.startThread();
        }
    }

    public synchronized void stop() {
        this.stopThread();
        this.setStarted(false);
    }

    public synchronized void shutdown(boolean bl) {
        this.getQueue().shutdown(bl || this.isDispatchThread());
        this.stop();
    }

    protected final void setStarted(boolean bl) {
        this.started = bl;
    }

    public final boolean isActive() {
        return this.started;
    }

    private final void setThreadActive(boolean bl) {
        this.threadActive = bl;
    }

    public final boolean isThreadActive() {
        return this.threadActive;
    }

    public final void addInterceptor(IInterceptor iInterceptor) {
        if (iInterceptor.getNext() != null) {
            throw new IllegalArgumentException("JobInterceptor to add is already added to a JobDispatcher!");
        }
        iInterceptor.setNext(this.interceptors);
        this.interceptors = iInterceptor;
        if (iInterceptor instanceof StatisticInterceptor) {
            this.statistic = (StatisticInterceptor)iInterceptor;
        }
    }

    public final boolean removeInterceptor(IInterceptor iInterceptor) {
        IInterceptor iInterceptor2 = this.interceptors;
        if (iInterceptor2 == iInterceptor) {
            this.interceptors = this.interceptors.getNext();
            iInterceptor.setNext(null);
            return true;
        }
        while (iInterceptor2.getNext() != null) {
            IInterceptor iInterceptor3 = iInterceptor2.getNext();
            if (iInterceptor3 == iInterceptor) {
                iInterceptor2.setNext(iInterceptor3.getNext());
                iInterceptor.setNext(null);
                return true;
            }
            iInterceptor2 = iInterceptor3;
        }
        return false;
    }

    public final void setBlockedHandler(long l, IBlockedJobHandler iBlockedJobHandler) {
        if (this.checker != null) {
            this.removeInterceptor(this.checker);
            this.checker = null;
        }
        if (iBlockedJobHandler != null) {
            this.checker = new CheckBlockedInterceptor(this.timeSource, l, iBlockedJobHandler);
            this.addInterceptor(this.checker);
        }
    }

    protected Job getNextJob() {
        return this.queue.getNextJob();
    }

    public void suspend() {
        this.getQueue().suspend();
    }

    public void resume() {
        this.getQueue().resume();
    }

    protected synchronized void startThread() {
        if (this.isActive() && !this.isThreadActive()) {
            this.setThreadActive(true);
            this.threadPool.execute(this);
        }
    }

    protected synchronized void stopThread() {
        this.setThreadActive(false);
        this.pendingThread = null;
        if (!this.isDispatchThread() && !this.getQueue().isDead()) {
            this.getQueue().wakeup();
        }
    }

    public boolean isDispatchThread() {
        return Thread.currentThread() == this.workerThread;
    }

    private void waitForDetach() {
        if (this.workerThread != null) {
            Thread thread = this.workerThread;
            if (this.log != null) {
                this.log.log(-1601830656, "%1 Worker Thread %2 still active! Wait for it to terminate", (Object)this, this.workerThread);
            }
            try {
                super.wait(0);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
            if (this.log != null) {
                if (this.workerThread != null) {
                    this.log.log(1000, "%1 Worker Thread %2 still active! Discarding it!", (Object)this, thread);
                    System.err.println(new StringBuffer().append("Something interesting has happened: ").append(this).append(" Worker Thread ").append(thread).append(" is still active! It is discarded and replaced by a new thread! The old thread might cause trouble!").toString());
                } else {
                    this.log.log(-1601830656, "%1 old Worker Thread %2 terminated!", (Object)this, thread);
                }
            }
        }
    }

    private synchronized void attachWorkerThread() {
        this.pendingThread = Thread.currentThread();
        this.waitForDetach();
        this.workerThread = Thread.currentThread();
        this.workerThread.setPriority(this.priority);
        if (this.log != null) {
            this.log.log(1078071040, "%1 processing started!", this);
        }
        this.workerThread.setName(new StringBuffer().append(Thread.currentThread().getName()).append(this.toString()).toString());
        if (this.log != null) {
            this.log.log(-2137614336, "%1 WorkerThread: %2 running with priority: %3", (Object)this, Thread.currentThread().getName(), this.priority);
        }
    }

    private synchronized void detachWorkerThread() {
        if (this.isDispatchThread()) {
            this.workerThread = null;
        } else if (this.log != null) {
            this.log.log(10000, "%1 Worker Thread %2 was replaced by other thread!", (Object)this, Thread.currentThread());
        }
        super.notifyAll();
    }

    @Override
    public void run() {
        this.attachWorkerThread();
        while (this.workerThread == this.pendingThread) {
            Job job = this.getNextJob();
            try {
                if (job.isCanceled()) continue;
                job.setStarted(this.timeSource.getCurrentTime());
                this.interceptors.execute(job);
            }
            catch (Exception exception) {
                if (this.log == null) continue;
                this.log.log(10000, "%1: Job %2 failed!", (Object)this, job);
                this.log.logException(exception);
            }
            catch (Error error) {
                if (this.log == null) continue;
                this.log.log(10000, "%1: Job %2 failed!", (Object)this, job);
                error.printStackTrace();
            }
        }
        if (this.log != null) {
            this.log.log(1078071040, "%1 processing stopped!", this);
        }
        this.detachWorkerThread();
    }

    public String toString() {
        return new Buffer(50).append("Dispatcher-").append(this.name).toString();
    }

    public void dump(PrintStream printStream) {
        printStream.print("ThreadPool: ");
        printStream.println(this.threadPool);
        printStream.print("Thread: ");
        printStream.println(this.workerThread);
        printStream.print("Priority: ");
        printStream.println(this.priority);
        printStream.println();
        this.queue.dump(printStream);
        printStream.println();
        this.interceptors.dump(printStream);
    }

    StatisticInterceptor getStatisticInterceptor() {
        return this.statistic;
    }

    public String[] getStatisticData() {
        String[] stringArray = new String[3];
        Buffer buffer = new Buffer(40);
        buffer.append("Events queued: ").append(this.getQueue().length()).append(" due: ").append(this.getQueue().getDueJobs());
        stringArray[0] = buffer.toString();
        if (this.statistic != null) {
            stringArray[1] = new StringBuffer().append("Events per second: ").append(this.statistic.getCurrentJobRate()).append("/s").toString();
            stringArray[2] = new StringBuffer().append("Events busy: ").append(this.statistic.getCurrentJobLoad()).append("% delay: ").append(this.statistic.getCurrentDelay()).append("ms").toString();
        } else {
            stringArray[1] = "Events per second: --";
            stringArray[2] = "Events busy: --";
        }
        return stringArray;
    }

    public StatisticData getStatistics() {
        return new StatisticData(this);
    }

    @Override
    public String getName() {
        return this.toString();
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        this.dump(printStream);
    }
}

