/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.EventRouter;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import de.vw.mib.genericevents.impl.IdGenerator;
import de.vw.mib.genericevents.impl.TargetEntry;
import de.vw.mib.genericevents.impl.TargetIdMaker;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class EventDispatcherImpl
implements EventDispatcherHSM,
HMIDumpInformationProvider {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(128);
    private final GenericEvents eventContext;
    private final TargetIdMaker targetIdMaker = new TargetIdMaker(this);
    private final IdGenerator routerIdMaker = new IdGenerator(-1601830656, -129);
    private final IntObjectOptHashMap targetMap = new IntObjectOptHashMap();
    private final HashMap taskMap = new HashMap();
    private final CowArray routers = new CowArray();
    private boolean queueOverloaded = false;
    private TaskInterface overloadedTask;
    private String[] dumpInfo;

    EventDispatcherImpl(GenericEvents genericEvents) {
        this.eventContext = genericEvents;
        if (ServiceManager.errorHandler != null) {
            ServiceManager.errorHandler.addHMIDumpInformationProvider(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerTask(String string, TaskInterface taskInterface) {
        HashMap hashMap = this.taskMap;
        synchronized (hashMap) {
            if (this.taskMap.containsKey(string)) {
                throw new GenericEventException(new StringBuffer().append("Task ").append(string).append(" already exists.").toString());
            }
            this.taskMap.put(string, taskInterface);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isTargetRegistered(int n) {
        IntObjectOptHashMap intObjectOptHashMap = this.targetMap;
        synchronized (intObjectOptHashMap) {
            return this.targetMap.containsKey(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerTarget(int n, Target target, String string, boolean bl) {
        if (this.isTargetRegistered(n)) {
            throw new GenericEventException(new StringBuffer().append("Target ").append(n).append(" already exists.").toString());
        }
        target.setTargetId(n);
        TaskInterface taskInterface = this.getTaskEx(string);
        Object object = this.targetMap;
        synchronized (object) {
            this.targetMap.put(n, new TargetEntry(n, target, taskInterface));
        }
        if (bl) {
            object = ServiceManager.mEventFactory.newEvent(5001, n, 0, 8);
            ((EventGeneric)object).setObject(0, this.eventContext);
            ((EventGeneric)object).setObject(1, target);
            ((EventGeneric)object).setInt(2, n);
            target.gotEvent((EventGeneric)object);
            ServiceManager.mEventFactory.freeEvent((EventGeneric)object);
        }
    }

    @Override
    public void registerTarget(int n, Target target, String string) {
        this.registerTarget(n, target, string, true);
    }

    @Override
    public int registerTarget(Target target) {
        int n = this.getNextTargetId();
        String string = this.getRandomTaskId();
        this.registerTarget(n, target, string, true);
        return n;
    }

    @Override
    public int registerTarget(Target target, String string) {
        int n = this.getNextTargetId();
        this.registerTarget(n, target, string, true);
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String getRandomTaskId() {
        String string = null;
        HashMap hashMap = this.taskMap;
        synchronized (hashMap) {
            if (this.taskMap.size() > 0) {
                String string2 = "hsmtask";
                TaskInterface taskInterface = (TaskInterface)this.taskMap.get("hsmtask");
                if (taskInterface != null) {
                    return "hsmtask";
                }
                Iterator iterator = this.taskMap.keySet().iterator();
                if (iterator.hasNext()) {
                    string = (String)iterator.next();
                }
            }
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TargetEntry getTargetEntry(int n) {
        IntObjectOptHashMap intObjectOptHashMap = this.targetMap;
        synchronized (intObjectOptHashMap) {
            return (TargetEntry)this.targetMap.get(n);
        }
    }

    private TargetEntry getTargetEntryEx(int n) {
        TargetEntry targetEntry = this.getTargetEntry(n);
        if (targetEntry == null) {
            throw new GenericEventException(new StringBuffer().append("Target ").append(n).append(" is unknown.").toString());
        }
        return targetEntry;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Target getTarget(int n) {
        Target target = null;
        IntObjectOptHashMap intObjectOptHashMap = this.targetMap;
        synchronized (intObjectOptHashMap) {
            TargetEntry targetEntry = (TargetEntry)this.targetMap.get(n);
            if (targetEntry != null) {
                target = targetEntry.getTarget();
            }
        }
        return target;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TaskInterface getTaskEx(String string) {
        HashMap hashMap = this.taskMap;
        synchronized (hashMap) {
            TaskInterface taskInterface = (TaskInterface)this.taskMap.get(string);
            if (taskInterface == null) {
                throw new GenericEventException(new StringBuffer().append("Task ").append(string).append(" is unknown.").toString());
            }
            return taskInterface;
        }
    }

    @Override
    public TaskInterface getTask(int n) {
        TargetEntry targetEntry = this.getTargetEntryEx(n);
        return targetEntry.getTask();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String getTaskId(int n) {
        IntObjectOptHashMap intObjectOptHashMap = this.targetMap;
        synchronized (intObjectOptHashMap) {
            TargetEntry targetEntry = (TargetEntry)this.targetMap.get(n);
            if (targetEntry != null) {
                return targetEntry.getTask().getId();
            }
        }
        return null;
    }

    @Override
    public Collection getTasks() {
        return this.taskMap.values();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public TaskInterface getTask(String string) {
        HashMap hashMap = this.taskMap;
        synchronized (hashMap) {
            return (TaskInterface)this.taskMap.get(string);
        }
    }

    @Override
    public boolean isQueueOverloaded() {
        return this.queueOverloaded;
    }

    @Override
    public void send(EventGeneric eventGeneric) {
        if (eventGeneric.isPooled()) {
            throw new GenericEventException("try to send a pooled EventGeneric");
        }
        if (eventGeneric.getReceiverRouterId() != 0 && this.invokeRouter(eventGeneric) == null) {
            return;
        }
        if (eventGeneric.isAnswer()) {
            if (eventGeneric.getReceiverTargetId() == 0 || eventGeneric.getReceiverEventId() == 0) {
                ServiceManager.mEventFactory.freeEvent(eventGeneric);
                return;
            }
            eventGeneric.setBlocked(false);
            this.dispatch(eventGeneric);
            return;
        }
        if ((eventGeneric.getReceiverTargetId() == 0 || eventGeneric.getReceiverEventId() == 0) && eventGeneric.getServiceId() == 0) {
            logger.error(4).append("Invalid event address: ").append(eventGeneric).log();
            ServiceManager.mEventFactory.freeEvent(eventGeneric);
            return;
        }
        if (eventGeneric.getReceiverTargetId() != 0 && eventGeneric.getReceiverEventId() != 0) {
            eventGeneric.setBlocked(false);
            this.dispatch(eventGeneric);
        } else if (eventGeneric.getServiceId() != 0) {
            if (!this.eventContext.getServiceRegister().existService(eventGeneric.getServiceId())) {
                eventGeneric.setResult(8);
                this.sendBack(eventGeneric);
                return;
            }
            this.eventContext.getServiceRegister().triggerObserver(eventGeneric.getServiceId(), eventGeneric);
        } else {
            ServiceManager.mEventFactory.freeEvent(eventGeneric);
        }
    }

    @Override
    public void sendSafe(EventGeneric eventGeneric) {
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            logger.error(4).append("Exception sending an event.").attachThrowable(genericEventException).log();
        }
    }

    void dispatch(EventGeneric eventGeneric, byte by) {
        if (eventGeneric.isPooled()) {
            throw new GenericEventException("try to send a pooled EventGeneric");
        }
        InvocationContext.startInvocationBranch(eventGeneric.getInvocationContext(), null);
        ServiceManager.eventTracer.trace((byte)1, by, 0, eventGeneric);
        TargetEntry targetEntry = this.getTargetEntryEx(eventGeneric.getReceiverTargetId());
        Target target = targetEntry.getTarget();
        if (logger.isTraceEnabled(256) && logger.isTraceEnabled(4)) {
            long l = ServiceManager.mTimerManager.getSystemTimeMicros();
            target.gotEvent(eventGeneric);
            long l2 = ServiceManager.mTimerManager.getSystemTimeMicros();
            long l3 = l2 - l;
            LogMessage logMessage = null;
            if (l3 < 0) {
                if (!logger.isTraceEnabled(512)) {
                    logMessage = logger.trace(4);
                }
            } else {
                logMessage = logger.warn(4);
            }
            if (logMessage != null) {
                logMessage.append(" & ");
                logMessage.append("Dispatched generic event ");
                logMessage.append(eventGeneric);
                logMessage.append(" to target ");
                logMessage.append(target);
                logMessage.append(" : ");
                logMessage.append(l3);
                logMessage.append(" & ");
                logMessage.log();
            }
        } else {
            targetEntry.getTarget().gotEvent(eventGeneric);
        }
    }

    @Override
    public void sendBack(EventGeneric eventGeneric) {
        if (eventGeneric.isPooled()) {
            throw new GenericEventException("try to send a pooled EventGeneric");
        }
        if (eventGeneric.isBlocked()) {
            return;
        }
        if (eventGeneric.swap()) {
            EventGeneric eventGeneric2 = eventGeneric;
            eventGeneric2.setAnswer(true);
            if (eventGeneric2.getReceiverRouterId() != 0) {
                eventGeneric2 = this.invokeRouter(eventGeneric2);
            }
            if (eventGeneric2 != null) {
                this.dispatch(eventGeneric2);
            }
        } else {
            ServiceManager.mEventFactory.freeEvent(eventGeneric);
        }
    }

    private void dispatch(EventGeneric eventGeneric) {
        EventGeneric eventGeneric2 = eventGeneric;
        TaskInterface taskInterface = this.getTask(eventGeneric2.getReceiverTargetId());
        if (this.queueOverloaded) {
            if (taskInterface == this.overloadedTask) {
                this.queueOverloaded = taskInterface.isQueueOverloaded();
            }
        } else {
            this.queueOverloaded = taskInterface.isQueueOverloaded();
            if (this.queueOverloaded) {
                this.overloadedTask = taskInterface;
            }
        }
        if (eventGeneric2.getReceiverRouterId() != 0) {
            eventGeneric2 = this.invokeRouter(eventGeneric2);
        }
        if (eventGeneric2 != null) {
            if (taskInterface != null) {
                taskInterface.dispatch(eventGeneric2);
            } else {
                ServiceManager.mEventFactory.freeEvent(eventGeneric2);
            }
        }
    }

    private EventGeneric invokeRouter(EventGeneric eventGeneric) {
        Object[] objectArray = this.routers.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            try {
                if (((EventRouter)objectArray[i2]).routeEvent(eventGeneric) != null) continue;
                return null;
            }
            catch (GenericEventException genericEventException) {
                logger.error(4).append("Exception routing an event.").attachThrowable(genericEventException).log();
            }
        }
        return eventGeneric;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterTarget(int n, boolean bl) {
        TargetEntry targetEntry;
        Object object = this.targetMap;
        synchronized (object) {
            targetEntry = (TargetEntry)this.targetMap.get(n);
            if (targetEntry != null) {
                this.targetMap.remove(n);
            }
        }
        if (bl && targetEntry != null) {
            object = ServiceManager.mEventFactory.newEvent(5001, n, 0, 9);
            targetEntry.getTarget().gotEvent((EventGeneric)object);
            ServiceManager.mEventFactory.freeEvent((EventGeneric)object);
        }
    }

    @Override
    public void unregisterTarget(int n) {
        this.unregisterTarget(n, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterTask(String string) {
        IntObjectOptHashMap intObjectOptHashMap = this.targetMap;
        synchronized (intObjectOptHashMap) {
            Iterator iterator = this.targetMap.values().iterator();
            while (iterator.hasNext()) {
                TargetEntry targetEntry = (TargetEntry)iterator.next();
                if (!targetEntry.getTask().getId().equals(string)) continue;
                try {
                    this.unregisterTarget(targetEntry.getTargetId());
                }
                catch (Exception exception) {}
            }
            this.taskMap.remove(string);
        }
    }

    @Override
    public void registerRouter(EventRouter eventRouter) {
        this.routers.add(eventRouter);
    }

    @Override
    public void unregisterRouter(EventRouter eventRouter) {
        this.routers.remove(eventRouter);
    }

    @Override
    public int getNextTargetId() {
        return this.targetIdMaker.next();
    }

    @Override
    public int getNextRouterId() {
        return this.routerIdMaker.next();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void dispose() {
        HashMap hashMap = this.taskMap;
        synchronized (hashMap) {
            Iterator iterator = this.taskMap.keySet().iterator();
            if (iterator.hasNext()) {
                String string = (String)iterator.next();
                TaskInterface taskInterface = (TaskInterface)this.taskMap.get(string);
                taskInterface.stop();
                this.taskMap.remove(string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public HashMap getTargets() {
        logger.warn(4, "The method getTargets() is not longer supported!");
        HashMap hashMap = new HashMap();
        IntObjectOptHashMap intObjectOptHashMap = this.targetMap;
        synchronized (intObjectOptHashMap) {
            Iterator iterator = this.targetMap.entrySet().iterator();
            while (iterator.hasNext()) {
                IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
                int n = intObjectMap$Entry.getKey();
                TargetEntry targetEntry = (TargetEntry)intObjectMap$Entry.getValue();
                hashMap.put(new Integer(n), super.getClass().getName());
            }
            return hashMap;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(70);
        stringBuffer.append("EventDispatcher(");
        stringBuffer.append(System.identityHashCode(this.eventContext));
        stringBuffer.append("): ");
        stringBuffer.append(this.taskMap.size());
        stringBuffer.append(" Tasks, ");
        stringBuffer.append(this.targetMap.size());
        stringBuffer.append(" Targets, ");
        stringBuffer.append(this.routers.size());
        stringBuffer.append(" Router");
        return stringBuffer.toString();
    }

    @Override
    public void clearDumpInformation() {
        this.dumpInfo = null;
    }

    @Override
    public String[] getDumpInformation() {
        return this.dumpInfo;
    }

    @Override
    public String getName() {
        if (this.dumpInfo == null) {
            this.dumpInfo = this.createDumpInfo();
        }
        return new StringBuffer().append("HSMs - ").append(this.dumpInfo.length).append(" hsms registered:").toString();
    }

    private String[] createDumpInfo() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.targetMap.valueIterator();
        while (iterator.hasNext()) {
            TargetEntry targetEntry = (TargetEntry)iterator.next();
            Target target = targetEntry.getTarget();
            if (!(target instanceof TargetHsmImpl)) continue;
            Hsm hsm = ((TargetHsmImpl)target).getHsm();
            arrayList.add(new StringBuffer().append(target.getTargetId()).append("\t - ").append(hsm.getName()).append(" @ ").append(hsm.getState() != null ? hsm.getState().getName() : "no state").toString());
        }
        return (String[])arrayList.toArray(new String[0]);
    }
}

