/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.event.dispatcher.DatapoolEventDispatcher;
import de.vw.mib.event.internal.DatapoolUpdateEventImpl;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.event.internal.dispatcher.MainDispatcher;
import de.vw.mib.list.update.ListItemControlUpdater;
import de.vw.mib.log4mib.Logger;

final class DatapoolEventDispatcherImpl
implements DatapoolEventDispatcher {
    private static final int DEFAULT_PARAM;
    private static Logger logger;
    private final MainDispatcher dispatchingThread;
    private final EventFactory eventFactory;
    private final EventQueue queue;

    DatapoolEventDispatcherImpl(EventQueue eventQueue, EventFactory eventFactory, MainDispatcher mainDispatcher) {
        this.queue = eventQueue;
        this.eventFactory = eventFactory;
        this.dispatchingThread = mainDispatcher;
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, boolean bl) {
        Object object;
        if (logger.isTraceEnabled(2048)) {
            object = logger.trace(2048);
            object.append("create and submit DatapoolUpdateEvent - id: ").append(n);
            object.append(", new value: ").append(bl).log();
        }
        object = this.eventFactory.createDatapoolUpdateEvent(n, bl);
        this.dispatchingThread.submitDatapoolUpdateEvent((DatapoolUpdateEventImpl)object);
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, float f2) {
        Object object;
        if (logger.isTraceEnabled(2048)) {
            object = logger.trace(2048);
            object.append("create and submit DatapoolUpdateEvent - id: ").append(n);
            object.append(", new value: ").append(f2).log();
        }
        object = this.eventFactory.createDatapoolUpdateEvent(n, f2);
        this.dispatchingThread.submitDatapoolUpdateEvent((DatapoolUpdateEventImpl)object);
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, int n2) {
        Object object;
        if (logger.isTraceEnabled(2048)) {
            object = logger.trace(2048);
            object.append("create and submit DatapoolUpdateEvent - id: ").append(n);
            object.append(", new value: ").append(n2).log();
        }
        object = this.eventFactory.createDatapoolUpdateEvent(n, n2);
        this.dispatchingThread.submitDatapoolUpdateEvent((DatapoolUpdateEventImpl)object);
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, long l) {
        Object object;
        if (logger.isTraceEnabled(2048)) {
            object = logger.trace(2048);
            object.append("create and submit DatapoolUpdateEvent - id: ").append(n);
            object.append(", new value: ").append(l).log();
        }
        object = this.eventFactory.createDatapoolUpdateEvent(n, l);
        this.dispatchingThread.submitDatapoolUpdateEvent((DatapoolUpdateEventImpl)object);
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, Object object) {
        Object object2;
        if (logger.isTraceEnabled(2048)) {
            object2 = logger.trace(2048);
            object2.append("create and submit DatapoolUpdateEvent - id: ").append(n);
            object2.append(", new value: ").append(object).log();
        }
        object2 = this.eventFactory.createDatapoolUpdateEvent(n, object);
        this.dispatchingThread.submitDatapoolUpdateEvent((DatapoolUpdateEventImpl)object2);
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_activatedIndexChanged(ListItemControlUpdater listItemControlUpdater, int n) {
        this.queue.add(this.eventFactory.createListItemControlUpdateEvent(listItemControlUpdater, 0, n, -1, -1));
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_itemsChanged(ListItemControlUpdater listItemControlUpdater, int n, int n2) {
        this.queue.add(this.eventFactory.createListItemControlUpdateEvent(listItemControlUpdater, 1, n, n2, -1));
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_itemsInserted(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3) {
        this.queue.add(this.eventFactory.createListItemControlUpdateEvent(listItemControlUpdater, 2, n, n2, n3));
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_itemsRemoved(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3) {
        this.queue.add(this.eventFactory.createListItemControlUpdateEvent(listItemControlUpdater, 3, n, n2, n3));
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_listChanged(ListItemControlUpdater listItemControlUpdater, int n) {
        this.queue.add(this.eventFactory.createListItemControlUpdateEvent(listItemControlUpdater, 4, n, -1, -1));
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_listContentChanged(ListItemControlUpdater listItemControlUpdater) {
        this.queue.add(this.eventFactory.createListItemControlUpdateEvent(listItemControlUpdater, 5, -1, -1, -1));
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_stringIndexChanged(ListItemControlUpdater listItemControlUpdater) {
        this.queue.add(this.eventFactory.createListItemControlUpdateEvent(listItemControlUpdater, 6, -1, -1, -1));
    }

    @Override
    public void invoke(Runnable runnable) {
        this.queue.add(this.eventFactory.createInvocationEvent(runnable));
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(64);
    }
}

