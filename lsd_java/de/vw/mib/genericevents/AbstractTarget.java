/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractTarget
implements Target {
    private String classShortName = null;
    private Logger logger = null;
    private int targetId = 0;
    protected GenericEvents mEventContext = null;

    public AbstractTarget() {
    }

    public AbstractTarget(GenericEvents genericEvents) {
        this.setEventContext(genericEvents);
    }

    public AbstractTarget(GenericEvents genericEvents, int n) {
        this.setEventContext(genericEvents);
        this.setTargetId(n);
    }

    public AbstractTarget(GenericEvents genericEvents, String string) {
        this.register(genericEvents, this.getDefaultTargetId(), string);
    }

    public AbstractTarget(GenericEvents genericEvents, int n, String string) {
        int n2 = this.getDefaultTargetId();
        this.register(genericEvents, n2 == 0 ? n : n2, string);
    }

    public void addObserver(int n) {
        this.getServiceRegister().addObserver(n, this.getTargetId());
    }

    public void addObserver(int n, int n2) {
        this.getServiceRegister().addObserver(n, this.getTargetId(), n2);
    }

    public final void addObservers(int[] nArray) {
        this.getServiceRegister().addObserver(nArray, this.getTargetId());
    }

    public final void removeObserver(int n) {
        this.getServiceRegister().removeObserver(n, this.getTargetId());
    }

    public final void removeObservers(int[] nArray) {
        this.getServiceRegister().removeObservers(nArray, this.getTargetId());
    }

    public int getDefaultTargetId() {
        return 0;
    }

    public final EventDispatcherHSM getEventDispatcher() {
        return this.mEventContext.getEventDispatcher();
    }

    public final EventFactory getEventFactory() {
        return this.mEventContext.getEventFactory();
    }

    @Override
    public final GenericEvents getMainObject() {
        return this.mEventContext;
    }

    public final ServiceRegister getServiceRegister() {
        return this.mEventContext.getServiceRegister();
    }

    public final String getShortName() {
        if (this.classShortName != null) {
            return this.classShortName;
        }
        String string = super.getClass().getName();
        this.classShortName = string.substring(string.lastIndexOf(".") + 1);
        return this.classShortName;
    }

    @Override
    public final int getTargetId() {
        return this.targetId;
    }

    public final Logger getTextLogger() {
        return this.logger;
    }

    public final TimerServer getTimerServer() {
        return this.mEventContext.getTimerServer();
    }

    public final void register(GenericEvents genericEvents) {
        this.setEventContext(genericEvents);
        this.mEventContext.getEventDispatcher().registerTarget(this);
    }

    public final void register(GenericEvents genericEvents, int n, String string) {
        this.setEventContext(genericEvents);
        this.mEventContext.getEventDispatcher().registerTarget(n, this, string);
    }

    public final void registerService(int n) {
        this.getServiceRegister().registerService(n, this.getTargetId());
    }

    public final void registerService(int n, boolean bl) {
        this.getServiceRegister().registerService(n, 0, this.getTargetId(), 0, bl, false);
    }

    public final void registerServices(int[] nArray, boolean bl) {
        this.mEventContext.getServiceRegister().registerServicesWithoutCheck(nArray, this.getTargetId(), bl);
    }

    public final void restartTimer(int n) {
        this.getTimerServer().restartTimedEvent(this.getTargetId(), n);
    }

    public final void retriggerOrStartTimer(EventGeneric eventGeneric, long l, boolean bl) {
        this.getTimerServer().restartOrStartTimedEvent(eventGeneric, l, bl);
    }

    public final void retriggerOrStartTimer(int n, long l, boolean bl) {
        this.getTimerServer().restartOrStartTimedEvent(this.getTargetId(), n, l, bl);
    }

    public final void retriggerTimer(int n) {
        this.getTimerServer().restartTimedEvent(this.getTargetId(), n);
    }

    public final void resumeTimer(int n) {
        this.getTimerServer().resumeTimedEvent(this.getTargetId(), n);
    }

    public final void suspendTimer(int n) {
        this.getTimerServer().suspendTimedEvent(this.getTargetId(), n);
    }

    public final void send(int n, int n2, int n3) {
        EventGeneric eventGeneric = ServiceManager.mEventFactory.newEvent(this.getTargetId(), n, n3, n2);
        this.getEventDispatcher().send(eventGeneric);
    }

    public final boolean isQueueOverloaded() {
        return this.getEventDispatcher().isQueueOverloaded();
    }

    public final void send(EventGeneric eventGeneric) {
        eventGeneric.setSenderTargetId(this.getTargetId());
        this.getEventDispatcher().send(eventGeneric);
    }

    public final void sendSafe(EventGeneric eventGeneric) {
        eventGeneric.setSenderTargetId(this.getTargetId());
        try {
            this.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.logger.error(this.getSubClassifier()).attachThrowable(genericEventException).log();
        }
    }

    public final void sendBack(EventGeneric eventGeneric) {
        eventGeneric.setBlocked(false);
        this.getEventDispatcher().sendBack(eventGeneric);
    }

    public final void sendBackSafe(EventGeneric eventGeneric) {
        eventGeneric.setBlocked(false);
        try {
            this.getEventDispatcher().sendBack(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.logger.error(this.getSubClassifier()).attachThrowable(genericEventException).log();
        }
    }

    @Override
    public final void setTargetId(int n) {
        this.targetId = n;
    }

    public void signal(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mEventFactory.newEvent(this.targetId, n, 25);
        eventGeneric.setInt(0, n2);
        this.getEventDispatcher().sendSafe(eventGeneric);
    }

    public final void startTimer(EventGeneric eventGeneric, long l, boolean bl) {
        this.startTimer(eventGeneric, l, bl, false);
    }

    public final void startTimer(EventGeneric eventGeneric, long l, boolean bl, boolean bl2) {
        eventGeneric.setReceiverTargetId(this.getTargetId());
        this.getTimerServer().sendTimedEvent(eventGeneric, l, bl, bl2);
    }

    public final void startTimer(int n, long l, boolean bl) {
        this.getTimerServer().sendTimedEvent(this.getTargetId(), n, l, bl);
    }

    public final void stopTimer(int n) {
        this.getTimerServer().stopTimedEvent(this.getTargetId(), n);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("Target ");
        stringBuffer.append(this.targetId);
        if (this.getEventDispatcher() != null) {
            stringBuffer.append(" [task=");
            TaskInterface taskInterface = null;
            try {
                taskInterface = this.getEventDispatcher().getTask(this.targetId);
            }
            catch (GenericEventException genericEventException) {
                // empty catch block
            }
            if (taskInterface != null) {
                stringBuffer.append(taskInterface.getId());
            } else {
                stringBuffer.append("?");
            }
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }

    public final void triggerIt(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mEventFactory.newEvent(this.getTargetId(), n, n2);
        this.getEventDispatcher().sendSafe(eventGeneric);
    }

    public final void triggerMe(EventGeneric eventGeneric, int n) {
        eventGeneric.setReceiverTargetId(this.targetId);
        eventGeneric.setReceiverEventId(n);
        eventGeneric.setSenderTargetId(this.targetId);
        this.getEventDispatcher().sendSafe(eventGeneric);
    }

    public final void triggerMe(int n) {
        EventGeneric eventGeneric = ServiceManager.mEventFactory.newEvent(this.getTargetId(), this.getTargetId(), n);
        this.getEventDispatcher().send(eventGeneric);
    }

    public final void triggerObserver(int n, EventGeneric eventGeneric) {
        if (eventGeneric == null) {
            this.getServiceRegister().triggerObserver(n);
        } else {
            this.getServiceRegister().triggerObserver(n, eventGeneric);
        }
    }

    public final void unregister() {
        this.mEventContext.getEventDispatcher().unregisterTarget(this.targetId);
    }

    public final void unregisterService(int n) {
        this.getServiceRegister().unregisterService(n);
    }

    public final void unregisterServices(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.unregisterService(nArray[i2]);
        }
    }

    public int getClassifier() {
        return 128;
    }

    public int getSubClassifier() {
        return 1;
    }

    public final LogMessage error() {
        return this.logger.error(this.getSubClassifier());
    }

    public final void error(String string) {
        this.logger.error(this.getSubClassifier(), string);
    }

    public final void error(String string, int n) {
        this.logger.error(this.getSubClassifier()).append(string).append(n).log();
    }

    public final void error(String string, String string2) {
        this.logger.error(this.getSubClassifier()).append(string).append(string2).log();
    }

    public final void error(Throwable throwable) {
        if (throwable == null) {
            return;
        }
        this.logger.error(this.getSubClassifier()).attachThrowable(throwable).log();
    }

    public final LogMessage fatal() {
        return this.logger.fatal(this.getSubClassifier());
    }

    public final void fatal(String string) {
        this.logger.fatal(this.getSubClassifier(), string);
    }

    public final LogMessage info() {
        return this.logger.info(this.getSubClassifier());
    }

    public final void info(String string) {
        this.logger.info(this.getSubClassifier(), string);
    }

    public final void info(String string, int n) {
        this.logger.info(this.getSubClassifier()).append(string).append(n).log();
    }

    public final void info(String string, String string2) {
        this.logger.info(this.getSubClassifier()).append(string).append(string2).log();
    }

    public final LogMessage normal() {
        return this.logger.normal(this.getSubClassifier());
    }

    public final void normal(String string) {
        this.logger.normal(this.getSubClassifier(), string);
    }

    public final void normal(String string, int n) {
        this.logger.normal(this.getSubClassifier()).append(string).append(n).log();
    }

    public final void normal(String string, String string2) {
        this.logger.normal(this.getSubClassifier()).append(string).append(string2).log();
    }

    public final boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(this.getSubClassifier());
    }

    public final LogMessage trace() {
        return this.logger.trace(this.getSubClassifier());
    }

    public void trace(String string) {
        this.logger.trace(this.getSubClassifier(), string);
    }

    public final void trace(String string, int n) {
        if (this.isTraceEnabled()) {
            this.logger.trace(this.getSubClassifier()).append(string).append(n).log();
        }
    }

    public final void trace(String string, String string2) {
        if (this.isTraceEnabled()) {
            this.logger.trace(this.getSubClassifier()).append(string).append(string2).log();
        }
    }

    public final LogMessage warn() {
        return this.logger.warn(this.getSubClassifier());
    }

    public final void warn(String string) {
        this.logger.warn(this.getSubClassifier(), string);
    }

    public final void warn(String string, int n) {
        this.logger.warn(this.getSubClassifier()).append(string).append(n).log();
    }

    public final void warn(String string, String string2) {
        this.logger.warn(this.getSubClassifier()).append(string).append(string2).log();
    }

    protected final void setEventContext(GenericEvents genericEvents) {
        if (this.mEventContext == null) {
            this.mEventContext = genericEvents;
            this.logger = genericEvents.getLoggerFactory().getLogger(this.getClassifier());
        }
    }
}

