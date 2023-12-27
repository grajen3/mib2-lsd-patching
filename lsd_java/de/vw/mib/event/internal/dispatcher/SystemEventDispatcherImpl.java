/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.coreapi.asl.SystemEventSender;
import de.vw.mib.coreapi.client.SystemEventListener;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class SystemEventDispatcherImpl
implements SystemEventDispatcher,
SystemEventListener,
SystemEventSender {
    private static final int EMPTY_GESTURE_PARAM;
    private static Logger logger;
    private final EventFactory eventFactory;
    private boolean lsChangeFilter;
    private final EventQueue queue;

    SystemEventDispatcherImpl(EventQueue eventQueue, EventFactory eventFactory) {
        this.queue = eventQueue;
        this.eventFactory = eventFactory;
    }

    @Override
    public void createAndSubmitDisplayEvent(int n) {
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit DisplayEvent - displayState: ").append(n).log();
        }
        this.queue.add(this.eventFactory.createDisplayEvent(n));
    }

    @Override
    public void createAndSubmitHardkeyEvent(int n) {
        int n2 = ServiceManager.systemEventIdMap.getInternalSystemEventId(n);
        if (n2 == -1) {
            this.queue.add(this.eventFactory.createHardkeyEvent(n, n));
            return;
        }
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit hardkey HMIEvent - id: ").append(n).append(", internal id: ").append(n2).log();
        }
        this.queue.add(this.eventFactory.createHardkeyEvent(n2, n));
    }

    @Override
    public void createAndSubmitHMIEvent(int n) {
        ServiceManager.systemEventSender.fireSystemEvent(n);
    }

    @Override
    public void createAndSubmitPowerStateEvent(int n) {
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit PowerStateEvent - powerState: ").append(n).log();
        }
        this.queue.add(this.eventFactory.createPowerStateEvent(n));
    }

    @Override
    public void createAndSubmitProximityEvent(boolean bl, int n) {
        int n2 = ServiceManager.systemEventIdMap.getInternalSystemEventId(n);
        if (n2 == -1) {
            logger.warn(512).append("unknown asl system event id ").append(n).log();
            this.queue.add(this.eventFactory.createHardkeyEvent(n, n));
            return;
        }
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit ProximityEvent - approach: ").append(bl);
            logMessage.append(", id: ").append(n).append(", internal id: ").append(n2).log();
        }
        this.queue.add(this.eventFactory.createProximityEvent(bl, n2));
    }

    @Override
    public void createAndSubmitRestoreFactorySettingsEvent() {
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit RestoreFactorySettingsEvent").log();
        }
        this.queue.add(this.eventFactory.createRestoreFactorySettingsEvent());
    }

    public void createAndSubmitRotationEvent(int n, int n2) {
        this.createAndSubmitRotationEvent(n, n2, -1);
    }

    @Override
    public void createAndSubmitRotationEvent(int n, int n2, int n3) {
        if (this.lsChangeFilter) {
            logger.warn(512, "discard rotation event while performing language/skin change");
            return;
        }
        int n4 = ServiceManager.systemEventIdMap.getInternalSystemEventId(n);
        if (n4 == -1) {
            logger.warn(512).append("unknown asl system event id ").append(n).log();
            this.queue.add(this.eventFactory.createHardkeyEvent(n, n));
            return;
        }
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit RotationEvent - id: ").append(n);
            logMessage.append(", ticks: ").append(n2).append(", internal id: ").append(n4).log();
        }
        this.queue.add(this.eventFactory.createRotationEvent(null, null, n4, n2, n3));
    }

    @Override
    public void createAndSubmitSpeechCommandEvent(int n) {
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("createSpeechCommandEvent - command: ").append(n).log();
        }
        this.queue.add(this.eventFactory.createSpeechCommandEvent(n));
    }

    @Override
    public void createAndSubmitSpeechEvent(int n, long l, int n2, String string, int n3) {
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit SpeechEvent - ruleId: ").append(n);
            logMessage.append(", objectId: ").append(l);
            logMessage.append(", index: ").append(n2);
            logMessage.append(", tag: ").append(string);
            logMessage.append(", slotId: ").append(n3).log();
        }
        this.queue.add(this.eventFactory.createSpeechEvent(n, l, n2, string, n3));
    }

    @Override
    public void createAndSubmitSpeechStateEvent(int n) {
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit SpeechStateEvent - state: ").append(n).log();
        }
        this.queue.add(this.eventFactory.createSpeechStateEvent(n));
    }

    public void createAndSubmitTouchEventClick(int n, int n2, int n3) {
        this.createAndSubmitTouchEventClick(n, n2, n3, -1);
    }

    @Override
    public void createAndSubmitTouchEventClick(int n, int n2, int n3, int n4) {
        this.createAndSubmitTouchEvent(2, n, n2, 0, n3, 0, n4);
    }

    public void createAndSubmitTouchEventDrag(int n, int n2, int n3, int n4) {
        this.createAndSubmitTouchEventDrag(n, n2, n3, n4, -1);
    }

    @Override
    public void createAndSubmitTouchEventDrag(int n, int n2, int n3, int n4, int n5) {
        this.createAndSubmitTouchEvent(3, n, n2, 0, n3, n4, n5);
    }

    public void createAndSubmitTouchEventDrag2(int n, int n2, int n3, int n4, int n5) {
        this.createAndSubmitTouchEventDrag2(n, n2, n3, n4, n5, -1);
    }

    @Override
    public void createAndSubmitTouchEventDrag2(int n, int n2, int n3, int n4, int n5, int n6) {
        this.createAndSubmitTouchEvent(7, n, n2, n3, n4, n5, n6);
    }

    public void createAndSubmitTouchEventFlick(int n, int n2, int n3, int n4) {
        this.createAndSubmitTouchEventFlick(n, n2, n3, n4, -1);
    }

    @Override
    public void createAndSubmitTouchEventFlick(int n, int n2, int n3, int n4, int n5) {
        this.createAndSubmitTouchEvent(4, n, n2, 0, n3, n4, n5);
    }

    public void createAndSubmitTouchEventFlick2(int n, int n2, int n3, int n4, int n5) {
        this.createAndSubmitTouchEventFlick2(n, n2, n3, n4, n5, -1);
    }

    @Override
    public void createAndSubmitTouchEventFlick2(int n, int n2, int n3, int n4, int n5, int n6) {
        this.createAndSubmitTouchEvent(8, n, n2, n3, n4, n5, n6);
    }

    public void createAndSubmitTouchEventMousePosition(int n, int n2) {
        this.createAndSubmitTouchEventMousePosition(n, n2, -1);
    }

    @Override
    public void createAndSubmitTouchEventMousePosition(int n, int n2, int n3) {
        this.createAndSubmitTouchEvent(99, n, n2, 0, 0, 0, n3);
    }

    public void createAndSubmitTouchEventPress(int n, int n2) {
        this.createAndSubmitTouchEventPress(n, n2, -1);
    }

    @Override
    public void createAndSubmitTouchEventPress(int n, int n2, int n3) {
        this.createAndSubmitTouchEvent(1, n, n2, 0, 0, 0, n3);
    }

    public void createAndSubmitTouchEventPress2(int n, int n2, int n3) {
        this.createAndSubmitTouchEventPress2(n, n2, n3, -1);
    }

    @Override
    public void createAndSubmitTouchEventPress2(int n, int n2, int n3, int n4) {
        this.createAndSubmitTouchEvent(6, n, n2, n3, 0, 0, n4);
    }

    public void createAndSubmitTouchEventRelease(int n, int n2) {
        this.createAndSubmitTouchEventRelease(n, n2, -1);
    }

    @Override
    public void createAndSubmitTouchEventRelease(int n, int n2, int n3) {
        this.createAndSubmitTouchEvent(0, n, n2, 0, 0, 0, n3);
    }

    public void createAndSubmitTouchEventRightClick(int n, int n2) {
        this.createAndSubmitTouchEventRightClick(n, n2, -1);
    }

    @Override
    public void createAndSubmitTouchEventRightClick(int n, int n2, int n3) {
        this.createAndSubmitTouchEvent(10, n, n2, 0, 0, 0, n3);
    }

    public void createAndSubmitTouchEventRotation(int n) {
        this.createAndSubmitTouchEventRotation(n, -1);
    }

    @Override
    public void createAndSubmitTouchEventRotation(int n, int n2) {
        this.createAndSubmitTouchEvent(5, 0, 0, 0, n, 0, n2);
    }

    public void createAndSubmitTouchEventZoom(int n, int n2, int n3, int n4) {
        this.createAndSubmitTouchEventZoom(n, n2, n3, n4, -1);
    }

    @Override
    public void createAndSubmitTouchEventZoom(int n, int n2, int n3, int n4, int n5) {
        this.createAndSubmitTouchEvent(9, n, n2, n3, n4, 0, n5);
    }

    @Override
    public void fireSystemEvent(int n) {
        this.onSystemEvent(n);
    }

    @Override
    public void onSystemEvent(int n) {
        int n2 = ServiceManager.systemEventIdMap.getInternalSystemEventId(n);
        if (n2 == -1) {
            this.queue.add(this.eventFactory.createSystemEvent(null, null, n, n));
            return;
        }
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit HMIEvent - id: ").append(n).append(", internal id: ").append(n2).log();
        }
        this.queue.add(this.eventFactory.createSystemEvent(null, null, n2, n));
    }

    void createAndSubmitTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.lsChangeFilter) {
            logger.warn(512, "discard touch event while performing language/skin change");
            return;
        }
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit TouchEvent - type: ").append(n);
            logMessage.append(", x: ").append(n2);
            logMessage.append(", y: ").append(n3);
            logMessage.append(", zDelta: ").append(n4);
            logMessage.append(", param1: ").append(n5);
            logMessage.append(", param2: ").append(n6).log();
        }
        this.queue.add(this.eventFactory.createTouchEvent(n, n2, n3, n4, n5, n6, n7));
    }

    void setLsChangeFilter(boolean bl) {
        this.lsChangeFilter = bl;
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(64);
    }
}

