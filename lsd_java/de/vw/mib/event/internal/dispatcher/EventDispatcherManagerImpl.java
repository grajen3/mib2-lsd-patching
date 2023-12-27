/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.event.dispatcher.DatapoolEventDispatcher;
import de.vw.mib.event.dispatcher.EventDispatcherManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.GestureEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.diag.EventDispatcherDiag;
import de.vw.mib.event.internal.dispatcher.DatapoolEventDispatcherImpl;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.event.internal.dispatcher.FrameworkEventDispatcherImpl;
import de.vw.mib.event.internal.dispatcher.GestureEventDispatcherImpl;
import de.vw.mib.event.internal.dispatcher.MainDispatcher;
import de.vw.mib.event.internal.dispatcher.StartupDispatcher;
import de.vw.mib.event.internal.dispatcher.StartupEventDispatcherImpl;
import de.vw.mib.event.internal.dispatcher.StatemachineEventDispatcherImpl;
import de.vw.mib.event.internal.dispatcher.SystemEventDispatcherImpl;
import de.vw.mib.event.internal.dispatcher.ViewEventDispatcherImpl;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.LscUserInteractionFilterService;
import de.vw.mib.threads.MIBThread;

public final class EventDispatcherManagerImpl
implements EventDispatcherManager,
LscUserInteractionFilterService {
    static Logger logger = ServiceManager.loggerFactory.getLogger(64);
    private final DatapoolEventDispatcher datapoolEventDispatcher;
    private final FrameworkEventDispatcher frameworkEventDispatcher;
    private final GestureEventDispatcher gestureEventDispatcher;
    private final MainDispatcher mainDispatcher;
    private final StartupDispatcher startupDispatcher;
    private final StartupEventDispatcher startupEventDispatcher;
    private final EventQueue startupEventQueue = new EventQueue("StartupEventQueue", 0, 3);
    private final StatemachineEventDispatcher statemachineEventDispatcher;
    private final EventQueue statemachineEventQueue;
    private final SystemEventDispatcherImpl systemEventDispatcher;
    private final EventQueue systemEventQueue;
    private final ViewEventDispatcher viewEventDispatcher;
    private final EventQueue viewEventQueue;

    public EventDispatcherManagerImpl(EventFactory eventFactory, int n, int n2, int n3) {
        this.startupEventDispatcher = new StartupEventDispatcherImpl(this.startupEventQueue);
        this.startupDispatcher = new StartupDispatcher(this.startupEventQueue);
        MIBThread mIBThread = ServiceManager.threadManager.createThread(1, this.startupDispatcher);
        this.startupEventQueue.setThread(mIBThread);
        this.systemEventQueue = new EventQueue("SystemEventQueue", 1, n);
        this.statemachineEventQueue = new EventQueue("StatemachineEventQueue", 2, n2, 10);
        this.viewEventQueue = new EventQueue("ViewEventQueue", 3, n3, 10);
        ServiceManager.errorHandler.addHMIDumpInformationProvider(this.systemEventQueue);
        ServiceManager.errorHandler.addHMIDumpInformationProvider(this.statemachineEventQueue);
        ServiceManager.errorHandler.addHMIDumpInformationProvider(this.viewEventQueue);
        this.mainDispatcher = new MainDispatcher(this.statemachineEventQueue, this.systemEventQueue, this.viewEventQueue);
        MIBThread mIBThread2 = ServiceManager.threadManager.createThread(2, this.mainDispatcher);
        this.systemEventQueue.setThread(mIBThread2);
        this.statemachineEventQueue.setThread(mIBThread2);
        this.viewEventQueue.setThread(mIBThread2);
        this.datapoolEventDispatcher = new DatapoolEventDispatcherImpl(this.systemEventQueue, eventFactory, this.mainDispatcher);
        this.frameworkEventDispatcher = new FrameworkEventDispatcherImpl(this.systemEventQueue, this.viewEventQueue, eventFactory);
        this.gestureEventDispatcher = new GestureEventDispatcherImpl(this.systemEventQueue, eventFactory);
        this.statemachineEventDispatcher = new StatemachineEventDispatcherImpl(this.systemEventQueue, this.statemachineEventQueue, eventFactory);
        this.systemEventDispatcher = new SystemEventDispatcherImpl(this.systemEventQueue, eventFactory);
        this.viewEventDispatcher = new ViewEventDispatcherImpl(this.viewEventQueue, eventFactory);
    }

    public DatapoolEventDispatcher getDatapoolEventDispatcher() {
        return this.datapoolEventDispatcher;
    }

    public FrameworkEventDispatcher getFrameworkEventDispatcher() {
        return this.frameworkEventDispatcher;
    }

    public GestureEventDispatcher getGestureEventDispatcher() {
        return this.gestureEventDispatcher;
    }

    public EventDispatcherDiag getMainDispatcher() {
        return this.mainDispatcher;
    }

    public StartupEventDispatcher getStartupEventDispatcher() {
        return this.startupEventDispatcher;
    }

    public StatemachineEventDispatcher getStatemachineEventDispatcher() {
        return this.statemachineEventDispatcher;
    }

    public SystemEventDispatcher getSystemEventDispatcher() {
        return this.systemEventDispatcher;
    }

    public ViewEventDispatcher getViewEventDispatcher() {
        return this.viewEventDispatcher;
    }

    @Override
    public void startLsChangerFilter() {
        logger.normal(16, "Starting LSC filter ...");
        this.systemEventDispatcher.setLsChangeFilter(true);
    }

    @Override
    public void startMainDispatchingThread() {
        logger.normal(16, "Starting main dispatching thread ...");
        this.mainDispatcher.startDispatching();
    }

    @Override
    public void startStartupDispatchingThread() {
        logger.normal(16, "Starting startup dispatching thread ...");
        this.startupDispatcher.startDispatching();
    }

    @Override
    public void stopLsChangerFilter() {
        logger.normal(16, "Stopping LSC filter ...");
        this.systemEventDispatcher.setLsChangeFilter(false);
    }

    @Override
    public void stopMainDispatchingThread() {
        logger.normal(16, "Stopping main dispatching thread ...");
        this.mainDispatcher.stopDispatching();
    }

    @Override
    public void stopStartupDispatchingThread() {
        logger.normal(16, "Stopping startup dispatching thread ...");
        this.startupDispatcher.stopDispatching();
        this.startPerformanceTesting();
    }

    private void startPerformanceTesting() {
        if (!logger.isTraceEnabled(8192)) {
            return;
        }
        logger.normal(8192, "start performance tests for event dispatching");
        this.systemEventQueue.resetCounters(10, 2);
        this.statemachineEventQueue.resetCounters(10, 5);
        this.viewEventQueue.resetCounters(5, 5);
    }
}

