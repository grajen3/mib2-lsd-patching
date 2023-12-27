/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.diag.EventQueueMonitor;
import de.vw.mib.event.internal.dispatcher.EventQueue$1;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBThread;

final class EventQueue
implements HMIDumpInformationProvider,
Loggable {
    private static final int MAX_EVENTS_TO_SHOW_FOR_HMIDUMP;
    private static Logger logger;
    private static final int MIN_INITIAL_CAPACITY;
    private AbstractEvent[] elements;
    private int exceedThresholdCounter = 0;
    private int head;
    private int maxQueueSize;
    private EventQueueMonitor monitor;
    private final String name;
    private final byte queueId;
    private int printContent = -1;
    private int tail;
    private MIBThread thread;
    private int warnThreshold;
    private final int initialCapacity;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$event$internal$dispatcher$EventQueue;

    EventQueue(String string, byte by, int n) {
        this(string, by, n, -1);
    }

    EventQueue(String string, byte by, int n, int n2) {
        this.name = string;
        this.queueId = by;
        this.warnThreshold = n2;
        this.allocateElements(n);
        this.initialCapacity = this.elements.length;
        this.registerEventQueueMonitor(null);
    }

    @Override
    public void clearDumpInformation() {
    }

    @Override
    public synchronized String[] getDumpInformation() {
        if (this.size() == 0) {
            return new String[]{"<empty>"};
        }
        int n = this.size() < 10 ? this.size() : 10;
        String[] stringArray = new String[n];
        int n2 = this.head;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            AbstractEvent abstractEvent = this.elements[(n2 + i2) % this.elements.length];
            if (abstractEvent == null) continue;
            stringArray[i2] = new StringBuffer().append(i2 + 1).append(". ").append(abstractEvent.toString()).toString();
        }
        return stringArray;
    }

    @Override
    public String getName() {
        String string = new StringBuffer().append(this.name).append(" - initial capacity: ").append(this.initialCapacity).append(" - current capacity: ").append(this.elements.length).append(" - max size: ").append(this.maxQueueSize).append(" - ").append(this.size()).append(" events in queue").toString();
        if (this.size() > 10) {
            string = new StringBuffer().append(string).append(" (show top 10)").toString();
        }
        return string;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append(this.name).append(" - size: ").append(this.size());
        if (this.maxQueueSize > 0) {
            logMessage.append(", max size: ").append(this.maxQueueSize);
        }
    }

    private void addLast(AbstractEvent abstractEvent) {
        if (abstractEvent == null) {
            throw new NullPointerException();
        }
        this.elements[this.tail] = abstractEvent;
        this.tail = this.tail + 1 & this.elements.length - 1;
        if (this.tail == this.head) {
            logger.warn(4096).append(this.name).append(" is full: double capacity!").append(" New capacity: ").append(this.elements.length << 1).log();
            this.doubleCapacity();
        }
    }

    private void allocateElements(int n) {
        int n2 = 8;
        if (n >= n2) {
            n2 = n;
            n2 |= n2 >>> 1;
            n2 |= n2 >>> 2;
            n2 |= n2 >>> 4;
            n2 |= n2 >>> 8;
            n2 |= n2 >>> 16;
            if (++n2 < 0) {
                n2 >>>= 1;
            }
        }
        this.elements = new AbstractEvent[n2];
    }

    private void doubleCapacity() {
        if (!$assertionsDisabled && this.head != this.tail) {
            throw new AssertionError();
        }
        int n = this.head;
        int n2 = this.elements.length;
        int n3 = n2 - n;
        int n4 = n2 << 1;
        if (n4 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        AbstractEvent[] abstractEventArray = new AbstractEvent[n4];
        System.arraycopy((Object)this.elements, n, (Object)abstractEventArray, 0, n3);
        System.arraycopy((Object)this.elements, 0, (Object)abstractEventArray, n3, n);
        this.elements = abstractEventArray;
        this.head = 0;
        this.tail = n2;
    }

    private AbstractEvent pollFirst() {
        int n = this.head;
        AbstractEvent abstractEvent = this.elements[n];
        if (abstractEvent == null) {
            return null;
        }
        this.elements[n] = null;
        this.head = n + 1 & this.elements.length - 1;
        return abstractEvent;
    }

    synchronized void add(AbstractEvent abstractEvent) {
        abstractEvent.traceEnqueue(this.queueId);
        this.addLast(abstractEvent);
        int n = this.size();
        if (n > this.maxQueueSize) {
            this.maxQueueSize = n;
        }
        if (logger.isTraceEnabled(8192) && this.warnThreshold > 0 && n > this.warnThreshold) {
            logger.warn(4096).append("queue is running full - ").append(this).append(" - add event: ").append(abstractEvent).log();
            if (this.printContent > 0 && this.exceedThresholdCounter % this.printContent == 0) {
                this.appendQueueContent(logger.warn(4096)).log();
                ++this.exceedThresholdCounter;
            }
        }
        this.monitor.updateQueue(n);
        this.thread.resume();
    }

    synchronized LogMessage appendQueueContent(LogMessage logMessage) {
        if (this.size() == 0) {
            logMessage.append("[]");
            return logMessage;
        }
        int n = this.head;
        int n2 = this.tail;
        logMessage.append("[ ");
        logMessage.append(this.elements[n]);
        n = this.head + 1;
        while (n != n2) {
            logMessage.append(" | ");
            logMessage.append(this.elements[n]);
            n = n + 1 & this.elements.length - 1;
        }
        logMessage.append(" ]");
        return logMessage;
    }

    synchronized void clear() {
        int n = this.head;
        int n2 = this.tail;
        if (n != n2) {
            this.tail = 0;
            this.head = 0;
            int n3 = n;
            int n4 = this.elements.length - 1;
            do {
                this.elements[n3] = null;
            } while ((n3 = n3 + 1 & n4) != n2);
        }
    }

    synchronized AbstractEvent poll() {
        AbstractEvent abstractEvent = this.pollFirst();
        this.monitor.updateQueue(this.size());
        if (abstractEvent != null) {
            abstractEvent.traceDequeue(this.queueId);
        }
        return abstractEvent;
    }

    void registerEventQueueMonitor(EventQueueMonitor eventQueueMonitor) {
        this.monitor = eventQueueMonitor != null ? eventQueueMonitor : new EventQueue$1(this);
    }

    void resetCounters(int n, int n2) {
        this.maxQueueSize = 0;
        this.exceedThresholdCounter = 0;
        this.warnThreshold = n;
        this.printContent = n2;
    }

    void setThread(MIBThread mIBThread) {
        this.thread = mIBThread;
    }

    int size() {
        return this.tail - this.head & this.elements.length - 1;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$event$internal$dispatcher$EventQueue == null ? (class$de$vw$mib$event$internal$dispatcher$EventQueue = EventQueue.class$("de.vw.mib.event.internal.dispatcher.EventQueue")) : class$de$vw$mib$event$internal$dispatcher$EventQueue).desiredAssertionStatus();
        logger = ServiceManager.loggerFactory.getLogger(64);
    }
}

