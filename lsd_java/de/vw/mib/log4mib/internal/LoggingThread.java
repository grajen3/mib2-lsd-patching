/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.log4mib.Settings;
import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.log4mib.internal.MessageQueue;

final class LoggingThread
implements LogHeartbeatInformationProvider,
Runnable {
    static final String LOGGING_THREAD_PRIORITY;
    private int discardedMessages = 0;
    private boolean discardMessages = false;
    private final int discardMessagesThreshold;
    private final int logAllMessagesThreshold;
    private final MainLogger mainLogger;
    private int heartbeat_discardedMessageCount = 0;
    private int heartbeat_maxQueueSize = 0;
    private int heartbeat_messageCount = 0;
    private int heartbeat_messageDataSize = 0;
    private final MessageQueue queue;
    private final Settings settings;
    private boolean isWorking = true;
    private boolean stopped = false;
    private Thread thread;
    private final int queueCapacity;

    LoggingThread(Settings settings, MainLogger mainLogger) {
        this.settings = settings;
        this.mainLogger = mainLogger;
        this.queueCapacity = settings.getLogMessageQueueSize();
        this.queue = new MessageQueue();
        this.discardMessagesThreshold = (int)((float)this.queueCapacity * 0x6666663F);
        this.logAllMessagesThreshold = (int)((float)this.queueCapacity * -842249153);
        System.out.println(new StringBuffer().append("[Log4MIB] Initializing Log4MIB - queue capacity: ").append(this.queueCapacity).toString());
    }

    @Override
    public String getInformation(String string) {
        if ("logmessage.count".equals(string)) {
            String string2 = new StringBuffer().append(this.heartbeat_messageCount).append("/").append(this.heartbeat_discardedMessageCount).toString();
            this.heartbeat_messageCount = 0;
            this.heartbeat_discardedMessageCount = 0;
            return string2;
        }
        if ("logmessage.queue.size".equals(string)) {
            String string3 = new StringBuffer().append(this.heartbeat_maxQueueSize).append("/").append(this.settings.getLogMessageQueueSize()).toString();
            this.heartbeat_maxQueueSize = 0;
            return string3;
        }
        if ("logmessage.data.size".equals(string)) {
            String string4 = new StringBuffer().append(this.heartbeat_messageDataSize / 1000).append("KB").toString();
            this.heartbeat_messageDataSize = 0;
            return string4;
        }
        return null;
    }

    @Override
    public void run() {
        Thread thread = this.thread;
        System.out.println(new StringBuffer().append("[Log4MIB] logging thread started - ").append(thread.hashCode()).toString());
        try {
            while (thread == this.thread) {
                AbstractMessage abstractMessage = this.poll();
                this.heartbeat_messageDataSize += abstractMessage.getSize();
                abstractMessage.dispatchMessage();
                this.isWorking = true;
            }
            this.isWorking = false;
        }
        catch (InterruptedException interruptedException) {
            if (!this.stopped) {
                System.err.println("[Log4MIB] logging thread was interrupted");
                interruptedException.printStackTrace();
            }
        }
        catch (Throwable throwable) {
            try {
                System.err.println("[Log4MIB] an error occurs in the logging thread");
                throwable.printStackTrace();
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
        }
        System.out.println(new StringBuffer().append("[Log4MIB] logging thread was stopped - ").append(thread.hashCode()).toString());
    }

    void addToQueue(AbstractMessage abstractMessage) {
        if (this.size() > this.heartbeat_maxQueueSize) {
            this.heartbeat_maxQueueSize = this.size();
        }
        ++this.heartbeat_messageCount;
        if (this.discardMessages) {
            if (this.size() < this.logAllMessagesThreshold) {
                this.stopDiscardingMessages();
            } else if (this.size() >= this.queueCapacity || abstractMessage.shouldDiscardMessage()) {
                ++this.discardedMessages;
                ++this.heartbeat_discardedMessageCount;
                return;
            }
            this.offer(abstractMessage);
            return;
        }
        if (this.size() >= this.discardMessagesThreshold) {
            this.startDiscardingMessages();
            if (!abstractMessage.shouldDiscardMessage()) {
                this.offer(abstractMessage);
            }
            return;
        }
        this.offer(abstractMessage);
    }

    boolean isAlive() {
        return this.thread != null && this.thread.isAlive();
    }

    boolean isWorking() {
        if (this.isWorking) {
            this.isWorking = false;
            return true;
        }
        return false;
    }

    void restartLoggingThread() {
        boolean bl = this.mainLogger.onRestartLoggingThread();
        if (this.thread == null) {
            System.err.println("[Log4MIB] Couldn't restart logging thread! Logging thread was already stopped!");
            return;
        }
        if (bl) {
            Thread thread = this.thread;
            this.thread = null;
            thread.interrupt();
            this.createAndStartLoggingThread(thread.getName(), thread.getPriority());
        } else {
            System.err.println("[Log4MIB] Won't restart logging thread! Logging thread has been restarted too often!");
            this.mainLogger.stopLoggingThread();
        }
    }

    void setPriority(int n) {
        if (this.thread != null) {
            if (n < 1) {
                this.thread.setPriority(1);
            } else if (n > 10) {
                this.thread.setPriority(10);
            } else {
                this.thread.setPriority(n);
            }
        }
    }

    void startLoggingThread() {
        this.createAndStartLoggingThread("Logging-Thread", Integer.getInteger("de.vw.mib.log4mib.thread.prio", 5));
    }

    void stopLoggingThread() {
        this.stopped = true;
        if (this.thread != null) {
            Thread thread = this.thread;
            this.thread = null;
            thread.interrupt();
        }
    }

    private void createAndStartLoggingThread(String string, int n) {
        this.thread = new Thread(this);
        this.thread.setName(string);
        this.setPriority(n);
        this.thread.start();
    }

    private void offer(AbstractMessage abstractMessage) {
        this.queue.offer(abstractMessage);
    }

    private AbstractMessage poll() {
        return this.queue.take();
    }

    private int size() {
        return this.queue.size();
    }

    private void startDiscardingMessages() {
        this.discardMessages = true;
        System.err.println("[Log4MIB] The log message queue is running full! Log4MIB traces and debug probe messages will be discarded!");
        this.mainLogger.log(4, 512, 4, "The log message queue is running full! Start discarding Log4MIB traces and debug probe messages!");
    }

    private void stopDiscardingMessages() {
        this.discardMessages = false;
        System.err.println(new StringBuffer().append("[Log4MIB] The log message queue size falls below discarding threshold! Log4MIB traces and debug probe messages will be logged again! ").append(this.discardedMessages).append(" messages have been discarded!").toString());
        this.mainLogger.log(8, 512, 4, new StringBuffer().append("The log message queue size falls below discarding threshold! Log4MIB traces and debug probe messages will be logged again! ").append(this.discardedMessages).append(" messages have been discarded!").toString());
        this.discardedMessages = 0;
    }
}

