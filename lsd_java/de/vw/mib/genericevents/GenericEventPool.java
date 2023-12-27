/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.ArrayDeque;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventFactory;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.util.NoSuchElementException;

final class GenericEventPool {
    public static final int POOL_SIZE = Integer.getInteger("GenericEventPool.poolSize", 1024);
    public static final int REMAINING_ELEMENTS = Integer.getInteger("GenericEventPool.remainingElements", 64);
    public static final int POOL_PREFILL = Integer.getInteger("GenericEventPool.poolPreFill", 128);
    private static final long DUMP_INTERVAL;
    private static final int MAXIMUM_NUMBER_OF_USED_DEQUES;
    private static Logger logger;
    private boolean useDeque;
    private int counter_newEvents = 0;
    private int counter_releasedEvents = 0;
    private int counter_reusedEvents = 0;
    private int counter_droppedEvents = 0;
    private int maxPoolSize = 0;
    private ArrayDeque elements;
    private int nrOfUsedDeques;
    private final GenericEventFactory factory;
    private long next;

    GenericEventPool(GenericEventFactory genericEventFactory) {
        logger.normal(64).append("Initialize GenericEventPool - size: ").append(POOL_SIZE).append(", prefill: ").append(POOL_PREFILL).append(", remaining elements: ").append(REMAINING_ELEMENTS).log();
        this.factory = genericEventFactory;
        this.useDeque = true;
        this.counter_releasedEvents = 0;
        this.counter_reusedEvents = 0;
        this.nrOfUsedDeques = 0;
        this.createElements();
    }

    private void createElements() {
        this.elements = new ArrayDeque(POOL_SIZE);
        for (int i2 = POOL_PREFILL; i2 > 0; --i2) {
            this.release(new EventGeneric(this.factory));
        }
        ++this.nrOfUsedDeques;
        this.counter_releasedEvents -= POOL_PREFILL;
    }

    synchronized EventGeneric borrow() {
        long l;
        EventGeneric eventGeneric;
        block8: {
            eventGeneric = null;
            if (this.useDeque && REMAINING_ELEMENTS < this.elements.size()) {
                ++this.counter_reusedEvents;
                try {
                    eventGeneric = (EventGeneric)this.elements.pollFirst();
                }
                catch (NoSuchElementException noSuchElementException) {
                    if (this.nrOfUsedDeques >= 4) {
                        logger.warn(64).append("Too many deque fails. Deque usage has been turned off.").attachThrowable(noSuchElementException).log();
                        this.useDeque = false;
                        ++this.counter_newEvents;
                        eventGeneric = new EventGeneric(this.factory);
                        break block8;
                    }
                    logger.warn(64).attachThrowable(noSuchElementException).log();
                    this.createElements();
                    logger.info(64).append("Opening deque number ").append(this.nrOfUsedDeques).log();
                    try {
                        eventGeneric = (EventGeneric)this.elements.pollFirst();
                    }
                    catch (NoSuchElementException noSuchElementException2) {
                        logger.warn(64).append("Two consecutive deque fails. Deque usage has been turned off.").attachThrowable(noSuchElementException2).log();
                        this.useDeque = false;
                        ++this.counter_newEvents;
                        eventGeneric = new EventGeneric(this.factory);
                    }
                }
            } else {
                ++this.counter_newEvents;
                eventGeneric = new EventGeneric(this.factory);
            }
        }
        if ((l = ServiceManager.mTimerManager.getSystemTimeMillis()) > this.next) {
            this.next = l + 0;
            logger.normal(64).append("GenericEventPool - new events: ").append(this.counter_newEvents).append(", released events: ").append(this.counter_releasedEvents).append(", reused events: ").append(this.counter_reusedEvents).append(", dropped events: ").append(this.counter_droppedEvents).append(", current pool size: ").append(this.elements.size()).append(", max pool size: ").append(this.maxPoolSize).append(", used deques: ").append(this.nrOfUsedDeques).log();
        }
        return eventGeneric;
    }

    synchronized void release(EventGeneric eventGeneric) {
        if (this.useDeque && POOL_SIZE > this.elements.size()) {
            ++this.counter_releasedEvents;
            this.elements.offerLast(eventGeneric);
            if (this.elements.size() > this.maxPoolSize) {
                this.maxPoolSize = this.elements.size();
            }
        } else {
            ++this.counter_droppedEvents;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GenericEventPool - ");
        stringBuilder.append("new events: ").append(this.counter_newEvents);
        stringBuilder.append(", released events: ").append(this.counter_releasedEvents);
        stringBuilder.append(", reused events: ").append(this.counter_reusedEvents);
        stringBuilder.append(", dropped events: ").append(this.counter_droppedEvents);
        stringBuilder.append(", current pool size: ").append(this.elements.size());
        stringBuilder.append(", max pool size: ").append(this.maxPoolSize);
        stringBuilder.append(", used deques: ").append(this.nrOfUsedDeques);
        stringBuilder.append("\n\t").append(this.elements);
        return stringBuilder.toString();
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(128);
    }
}

