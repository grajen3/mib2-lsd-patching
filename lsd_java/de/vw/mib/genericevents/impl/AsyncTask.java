/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.impl.EventDispatcherImpl;
import de.vw.mib.genericevents.impl.EventGenericDump;
import de.vw.mib.genericevents.impl.GenericEventQueue;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;

final class AsyncTask
implements HMIDumpInformationProvider,
LogHeartbeatInformationProvider,
MIBRunnable,
TaskInterface {
    private static final int EVENT_QUEUE_SIZE = Integer.getInteger("GenericEvents.queueSize", 150);
    private static final int EVENTS_TO_STORE_FOR_HMIDUMP = Integer.getInteger("GenericEvents.hmiDumpSize", 10);
    private static Logger logger = ServiceManager.loggerFactory.getLogger(128);
    private static final int QUEUE_OVERLOAD_RESUME = Integer.getInteger("GenericEvents.queueOverloadResume", 150);
    private static final int QUEUE_OVERLOAD_THRESHOLD = Integer.getInteger("GenericEvents.queueOverloadThreshold", 300);
    private final EventDispatcherImpl eventDispatcher;
    private int heartbeat_maxQueueSize = 0;
    private int heartbeat_messageCount = 0;
    private final EventGenericDump[] lastEvents;
    private int lastEventsIndex = 0;
    private final GenericEventQueue messageQueue;
    private boolean queueOverloaded = false;
    private final byte taskId;
    private final String taskName;
    private MIBThread thread;

    AsyncTask(GenericEvents genericEvents, String string, byte by) {
        this.eventDispatcher = (EventDispatcherImpl)genericEvents.getEventDispatcher();
        this.taskName = string;
        this.taskId = by;
        this.lastEvents = this.createDumpMem();
        this.messageQueue = new GenericEventQueue(this, EVENT_QUEUE_SIZE);
        ServiceManager.errorHandler.addHMIDumpInformationProvider(this.messageQueue);
        ServiceManager.errorHandler.addHMIDumpInformationProvider(this);
        ServiceManager.logManager.addHeartbeatInformationProvider("generic.event.count", this);
        ServiceManager.logManager.addHeartbeatInformationProvider("generic.event.queue.size", this);
    }

    @Override
    public void clearDumpInformation() {
    }

    @Override
    public void dispatch(EventGeneric eventGeneric) {
        if (this.messageQueue.size() > this.heartbeat_maxQueueSize) {
            this.heartbeat_maxQueueSize = this.messageQueue.size();
        }
        ++this.heartbeat_messageCount;
        this.messageQueue.add(eventGeneric);
        int n = this.messageQueue.size();
        if (this.queueOverloaded && n < QUEUE_OVERLOAD_RESUME) {
            this.queueOverloaded = false;
        } else if (n > QUEUE_OVERLOAD_THRESHOLD) {
            this.queueOverloaded = true;
        }
    }

    @Override
    public String[] getDumpInformation() {
        String[] stringArray = new String[EVENTS_TO_STORE_FOR_HMIDUMP];
        for (int i2 = 0; i2 < EVENTS_TO_STORE_FOR_HMIDUMP; ++i2) {
            stringArray[i2] = this.lastEvents[(i2 + this.lastEventsIndex) % EVENTS_TO_STORE_FOR_HMIDUMP].toString();
        }
        return stringArray;
    }

    @Override
    public String getId() {
        return this.taskName;
    }

    @Override
    public String getInformation(String string) {
        if ("generic.event.count".equals(string)) {
            String string2 = new StringBuffer().append("").append(this.heartbeat_messageCount).toString();
            this.heartbeat_messageCount = 0;
            return string2;
        }
        if ("generic.event.queue.size".equals(string)) {
            String string3 = new StringBuffer().append("").append(this.heartbeat_maxQueueSize).toString();
            this.heartbeat_maxQueueSize = 0;
            return string3;
        }
        return null;
    }

    public byte getTaskId() {
        return this.taskId;
    }

    @Override
    public String getName() {
        return new StringBuffer().append("GenericEventsTask ").append(this.taskName).append(" - last dispatched events:").toString();
    }

    @Override
    public int getQueueSize() {
        return this.messageQueue.size();
    }

    @Override
    public boolean isInCurrentMIBThread() {
        return this.thread.isInCurrentMIBThread();
    }

    @Override
    public boolean isQueueOverloaded() {
        return this.queueOverloaded;
    }

    @Override
    public void operate() {
        EventGeneric eventGeneric = this.messageQueue.poll();
        if (eventGeneric == null) {
            this.thread.suspend();
            return;
        }
        this.storeEventForHMIDump(-1L, eventGeneric);
        try {
            block9: {
                try {
                    this.eventDispatcher.dispatch(eventGeneric, this.taskId);
                }
                catch (GenericEventException genericEventException) {
                    logger.error(16).append("Uncaught generic event exception in EventDispatcher with ").append(eventGeneric).append("!").attachThrowable(genericEventException).log();
                    if (!eventGeneric.isPooled()) {
                        eventGeneric.setResult(genericEventException.getCode());
                    }
                }
                catch (Exception exception) {
                    logger.error(16).append("Uncaught exception in EventDispatcher with ").append(eventGeneric).append("!").attachThrowable(exception).log();
                    if (eventGeneric.isPooled()) break block9;
                    eventGeneric.setResult(3);
                }
            }
            try {
                this.eventDispatcher.sendBack(eventGeneric);
            }
            catch (Exception exception) {
                logger.error(16).append("Uncaught exception in EventDispatcher.sendBack() with ").append(eventGeneric).append("!").attachThrowable(exception).log();
            }
        }
        catch (Throwable throwable) {
            logger.error(16).append("error in async task ").append(this.taskName).attachThrowable(throwable).log();
        }
    }

    @Override
    public void setThread(MIBThread mIBThread) {
        this.thread = mIBThread;
        this.messageQueue.setThread(mIBThread);
    }

    @Override
    public void start() {
        this.thread.start();
        this.eventDispatcher.registerTask(this.taskName, this);
    }

    @Override
    public void stop() {
        this.thread.stop();
    }

    @Override
    public void threadDeathDetected() {
        logger.error(16, "thread death detected!");
    }

    @Override
    public void timeoutDetected() {
        logger.error(16, "timeout detected!");
    }

    private EventGenericDump[] createDumpMem() {
        EventGenericDump[] eventGenericDumpArray = new EventGenericDump[EVENTS_TO_STORE_FOR_HMIDUMP];
        for (int i2 = eventGenericDumpArray.length - 1; i2 >= 0; --i2) {
            eventGenericDumpArray[i2] = new EventGenericDump();
        }
        return eventGenericDumpArray;
    }

    private void storeEventForHMIDump(long l, EventGeneric eventGeneric) {
        this.lastEvents[this.lastEventsIndex].fromEvent(l, eventGeneric);
        this.lastEventsIndex = (this.lastEventsIndex + 1) % EVENTS_TO_STORE_FOR_HMIDUMP;
    }
}

