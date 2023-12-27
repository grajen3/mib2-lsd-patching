/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.internal.dispatcher;

import de.vw.mib.asl.api.bap.dispatcher.BAPDispatcher;
import de.vw.mib.asl.api.bap.lcu.BAPFunctionControlUnit;
import de.vw.mib.asl.api.bap.lcu.BAPLogicalControlUnit;
import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.bap.internal.dispatcher.BAPDispatcherTarget$BAPHMIEventConsumer;
import de.vw.mib.bap.internal.dispatcher.BAPDispatcherTarget$TimerProvider;
import de.vw.mib.bap.internal.dispatcher.BAPEventConstants;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.event.SystemEvent;
import de.vw.mib.event.consumer.BAPSystemEventConsumer;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.bap.DSIBAPListener;

public final class BAPDispatcherTarget
extends AbstractTarget
implements BAPDispatcher,
BAPSystemEventConsumer,
DSIBAPListener,
BAPEventConstants,
DSIServiceStateListener {
    private static final int INITIAL_EVENTS_CAPACITY;
    private IntObjectOptHashMap registeredBAPControlUnits = new IntObjectOptHashMap(4);
    private IntObjectOptHashMap registeredHMIEventConsumer = new IntObjectOptHashMap();
    private LinkedHashSet registeredPersistenceChangeListener = new LinkedHashSet();
    private boolean dsiServiceAvailable = false;
    private DSIBAP dsibap = null;
    protected EventFactory genericEventFactory = null;
    static /* synthetic */ Class class$de$vw$mib$bap$internal$dispatcher$BAPDispatcherTarget$BAPHMIEventConsumer;
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAP;
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAPListener;

    @Override
    public void initialize(GenericEvents genericEvents, EventFactory eventFactory) {
        this.genericEventFactory = eventFactory;
        this.register(genericEvents, 1898451456, "hsmtask");
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsibap = (DSIBAP)dSIProxy.getService(this, class$org$dsi$ifc$bap$DSIBAP == null ? (class$org$dsi$ifc$bap$DSIBAP = BAPDispatcherTarget.class$("org.dsi.ifc.bap.DSIBAP")) : class$org$dsi$ifc$bap$DSIBAP);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$bap$DSIBAPListener == null ? (class$org$dsi$ifc$bap$DSIBAPListener = BAPDispatcherTarget.class$("org.dsi.ifc.bap.DSIBAPListener")) : class$org$dsi$ifc$bap$DSIBAPListener, this);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$bap$DSIBAP == null ? (class$org$dsi$ifc$bap$DSIBAP = BAPDispatcherTarget.class$("org.dsi.ifc.bap.DSIBAP")) : class$org$dsi$ifc$bap$DSIBAP, this);
        this.trace("Initialization of BAP dispatcher done");
    }

    private void registerLogicalControlUnits(ArrayList arrayList) {
        this.registerBAPLogicalControlUnits(arrayList);
        if (this.dsiServiceAvailable) {
            this.beginStartOfLogicalControlUnits(arrayList);
        }
    }

    @Override
    public void registerLogicalControlUnits(ArrayList arrayList, boolean bl) {
        if (bl) {
            this.registerLogicalControlUnits(arrayList);
        } else {
            EventGeneric eventGeneric = this.genericEventFactory.newEvent();
            eventGeneric.setObject(0, arrayList);
            this.triggerMe(eventGeneric, -1903558400);
            this.trace("Register logical control units later (a none preload start)");
        }
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        BAPLogicalControlUnit bAPLogicalControlUnit = this.getLogicalControlUnit(n);
        if (bAPLogicalControlUnit != null) {
            bAPLogicalControlUnit.getServiceListener().acknowledge(n, n2, n3);
        } else {
            this.unknownDSIMessageReceived("acknowledge", n, n2, " acknowledgeType=", n3);
        }
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        BAPLogicalControlUnit bAPLogicalControlUnit = this.getLogicalControlUnit(n);
        if (bAPLogicalControlUnit != null) {
            bAPLogicalControlUnit.getServiceListener().bapStateStatus(n, n2);
        } else {
            this.warn().append("Unknown BAPStateStatus for LSG ID:").append(n).log();
        }
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        BAPLogicalControlUnit bAPLogicalControlUnit = this.getLogicalControlUnit(n);
        if (bAPLogicalControlUnit != null) {
            bAPLogicalControlUnit.getServiceListener().indication(n, n2, n3, n4, n5);
        } else {
            this.unknownDSIMessageReceived("indication", n, n2, " indicationType=", n4);
        }
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        BAPLogicalControlUnit bAPLogicalControlUnit = this.getLogicalControlUnit(n);
        if (bAPLogicalControlUnit != null) {
            bAPLogicalControlUnit.getServiceListener().indicationByteSequence(n, n2, n3, byArray);
        } else {
            this.unknownDSIMessageReceived("indicationByteSequence", n, n2, " indicationType=", n3);
        }
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        BAPLogicalControlUnit bAPLogicalControlUnit = this.getLogicalControlUnit(n);
        if (bAPLogicalControlUnit != null) {
            bAPLogicalControlUnit.getServiceListener().indicationError(n, n2, n3);
        } else {
            this.unknownDSIMessageReceived("indicationError", n, n2, " errorCode=", n3);
        }
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        BAPLogicalControlUnit bAPLogicalControlUnit = this.getLogicalControlUnit(n);
        if (bAPLogicalControlUnit != null) {
            bAPLogicalControlUnit.getServiceListener().indicationVoid(n, n2, n3);
        } else {
            this.unknownDSIMessageReceived("indicationVoid", n, n2, " indicationType=", n3);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        StringBuffer stringBuffer = new StringBuffer("asyncException error: requestType=");
        stringBuffer.append(n2);
        stringBuffer.append(" erorCode=");
        stringBuffer.append(n);
        if (string != null) {
            stringBuffer.append(" - Message: ");
            stringBuffer.append(string);
        }
        this.error(stringBuffer.toString());
    }

    @Override
    public void registered(String string, int n) {
        this.dsiServiceAvailable = true;
        this.trace("DSIBAP becomes available");
        this.beginStartOfLogicalControlUnits(this.registeredBAPControlUnits.values());
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public DSIBAP getServiceProvider() {
        return this.dsibap;
    }

    @Override
    public void processStageOutputValue(int n, int n2) {
        BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
        if (bAPFunctionControlUnit != null) {
            bAPFunctionControlUnit.getcurrentState().sendBAPStageOutputValue(n2);
            this.activateTransition(bAPFunctionControlUnit);
        } else {
            this.unknownLsgToProcessReceived("processStageOutputValue", n, n2);
        }
    }

    @Override
    public void processStageOutputValueWithThreadChange(int n, int n2) {
        EventGeneric eventGeneric = this.genericEventFactory.newEvent(1915228672, 1898451456, -2004221696);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendSafe(eventGeneric);
    }

    @Override
    public void processDatapoolChange(int n, int n2, int n3) {
        BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
        if (bAPFunctionControlUnit != null) {
            bAPFunctionControlUnit.getcurrentState().hmiDatapoolValueChanged(n2, n3);
            this.activateTransition(bAPFunctionControlUnit);
        } else {
            this.unknownLsgToProcessReceived("processDatapoolChange", n, n2);
        }
    }

    @Override
    public void processDatapoolChangeWithThreadChange(int n, int n2, int n3) {
        EventGeneric eventGeneric = this.genericEventFactory.newEvent(1881674240, 1898451456, -1987444480);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this.sendSafe(eventGeneric);
    }

    @Override
    public void informThatAllBapDatapoolValuesAreValid(int n) {
        EventGeneric eventGeneric = this.genericEventFactory.newEvent(1915228672, 1898451456, -1953890048);
        eventGeneric.setInt(0, n);
        this.sendSafe(eventGeneric);
    }

    @Override
    public void informHmiLanguageChange(int n, int n2) {
        EventGeneric eventGeneric = this.genericEventFactory.newEvent(1881674240, 1898451456, -1970667264);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendSafe(eventGeneric);
    }

    private void informPersistenceAvailabilityForLsg(int n, int n2) {
        BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
        if (bAPFunctionControlUnit != null) {
            bAPFunctionControlUnit.getcurrentState().persistenceBecomeAvailable(n2);
            this.activateTransition(bAPFunctionControlUnit);
            this.trace("Inform function about persistence availbility with fctID=", n2);
        } else {
            this.unknownLsgToProcessReceived("informPersistenceAvailability", n, n2);
        }
    }

    private void informPersistenceAvailabilityForAllLsgs() {
        Iterator iterator = this.registeredPersistenceChangeListener.iterator();
        while (iterator.hasNext()) {
            BAPDispatcherTarget$BAPHMIEventConsumer bAPDispatcherTarget$BAPHMIEventConsumer = (BAPDispatcherTarget$BAPHMIEventConsumer)iterator.next();
            this.informPersistenceAvailabilityForLsg(bAPDispatcherTarget$BAPHMIEventConsumer.lsgID, bAPDispatcherTarget$BAPHMIEventConsumer.fctID);
        }
        this.registeredPersistenceChangeListener = null;
        this.trace("Persistence becomes available, all bap function informed.");
    }

    @Override
    public void informPersistenceAvailability() {
        if (this.registeredPersistenceChangeListener != null) {
            this.triggerMe(this.genericEventFactory.newEvent(), -1870003968);
        } else {
            this.error().append("Can't inform persistence availability, because availbility already transmitted");
        }
    }

    @Override
    public void registerForPersistenceAvailability(int n, int n2) {
        if (this.registeredPersistenceChangeListener != null) {
            this.registeredPersistenceChangeListener.add(new BAPDispatcherTarget$BAPHMIEventConsumer(n, n2, 0));
            this.trace("Function registered for persistence availbility, with fctID = ", n2);
        } else {
            EventGeneric eventGeneric = this.genericEventFactory.newEvent();
            eventGeneric.setInt(0, n);
            eventGeneric.setInt(1, n2);
            this.triggerMe(eventGeneric, -1886781184);
        }
    }

    private void informTransmitDataForLsg(int n, int n2, int n3, Object object) {
        BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
        if (bAPFunctionControlUnit != null) {
            bAPFunctionControlUnit.getcurrentState().transmitData(n2, n3, object);
        } else {
            this.unknownLsgToProcessReceived("informTransmitDataForLsg", n, n2);
        }
    }

    @Override
    public void transmitData(int n, int n2, int n3, Object object) {
        EventGeneric eventGeneric = this.genericEventFactory.newEvent(1881674240, 1898451456, -1853226752);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setObject(3, object);
        this.sendSafe(eventGeneric);
    }

    @Override
    public void uninitialize(int n) {
        Object object;
        Object object2;
        Iterator iterator = this.registeredHMIEventConsumer.valueIterator();
        while (iterator.hasNext()) {
            object2 = (Set)iterator.next();
            object = object2.iterator();
            while (object.hasNext()) {
                BAPDispatcherTarget$BAPHMIEventConsumer bAPDispatcherTarget$BAPHMIEventConsumer = (BAPDispatcherTarget$BAPHMIEventConsumer)object.next();
                if (bAPDispatcherTarget$BAPHMIEventConsumer.lsgID != n) continue;
                object.remove();
            }
        }
        if (this.registeredPersistenceChangeListener != null) {
            object2 = this.registeredPersistenceChangeListener.iterator();
            while (object2.hasNext()) {
                object = (BAPDispatcherTarget$BAPHMIEventConsumer)object2.next();
                if (((BAPDispatcherTarget$BAPHMIEventConsumer)object).lsgID != n) continue;
                object2.remove();
            }
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 101000: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                this.processStageOutputValue(n, n2);
                break;
            }
            case 101001: {
                int n = eventGeneric.getInt(0);
                int n3 = eventGeneric.getInt(1);
                int n4 = eventGeneric.getInt(2);
                this.processDatapoolChange(n, n3, n4);
                break;
            }
            case 101002: {
                int n = eventGeneric.getInt(0);
                BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
                if (bAPFunctionControlUnit != null) {
                    int n5 = eventGeneric.getInt(1);
                    bAPFunctionControlUnit.getcurrentState().languageChange(n5);
                    this.activateTransition(bAPFunctionControlUnit);
                    break;
                }
                this.unknownLsgToProcessReceived("EV_HMI_LANGUAGE_CHANGED", n, eventGeneric.getInt(1));
                break;
            }
            case 101004: {
                int n = eventGeneric.getInt(0);
                BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
                if (bAPFunctionControlUnit != null) {
                    bAPFunctionControlUnit.getcurrentState().processHMIEvent(eventGeneric.getInt(1), eventGeneric.getInt(2));
                    this.activateTransition(bAPFunctionControlUnit);
                    break;
                }
                this.unknownLsgToProcessReceived("EV_NEW_HMI_EVENT_RECEIVED", n, eventGeneric.getInt(1));
                break;
            }
            case 101003: {
                int n = eventGeneric.getInt(0);
                BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
                if (bAPFunctionControlUnit != null) {
                    bAPFunctionControlUnit.getcurrentState().allDataPoolValuesAreValid();
                    this.activateTransition(bAPFunctionControlUnit);
                    break;
                }
                this.unknownLsgToProcessReceived("EV_ALL_BAP_DATA_POOL_VALUES_VALID", n, 0);
                break;
            }
            case 101006: {
                ArrayList arrayList = (ArrayList)eventGeneric.getObject(0);
                this.registerLogicalControlUnits(arrayList);
                break;
            }
            case 101008: {
                this.informPersistenceAvailabilityForAllLsgs();
                break;
            }
            case 101007: {
                this.informPersistenceAvailabilityForLsg(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 101009: {
                this.informTransmitDataForLsg(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getObject(3));
                break;
            }
            default: {
                if (eventGeneric.getSenderEventId() != -1920335616) break;
                eventGeneric.setSenderEventId(0);
                int n = eventGeneric.getInt(0);
                BAPFunctionControlUnit bAPFunctionControlUnit = this.getFunctionControlUnit(n);
                if (bAPFunctionControlUnit != null) {
                    bAPFunctionControlUnit.getcurrentState().notifyTimer(eventGeneric.getInt(1), (TimerNotifier)eventGeneric.getObject(2), 0);
                    this.activateTransition(bAPFunctionControlUnit);
                    break;
                }
                this.unknownLsgToProcessReceived("EV_TIMER_NOTIFIED", n, eventGeneric.getInt(1));
            }
        }
    }

    private void registerBAPLogicalControlUnits(ArrayList arrayList) {
        int n = arrayList.size();
        for (int i2 = 0; i2 < n; ++i2) {
            BAPLogicalControlUnit bAPLogicalControlUnit = (BAPLogicalControlUnit)arrayList.get(i2);
            int n2 = bAPLogicalControlUnit.getLogicalControlUnitID();
            this.registeredBAPControlUnits.put(n2, bAPLogicalControlUnit);
            bAPLogicalControlUnit.initialize();
            this.trace(new StringBuffer().append("Register logical control unit: ").append(bAPLogicalControlUnit.getLogicalControlUnitName()).toString());
        }
    }

    private void beginStartOfLogicalControlUnits(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            BAPLogicalControlUnit bAPLogicalControlUnit = (BAPLogicalControlUnit)iterator.next();
            if (bAPLogicalControlUnit == null) continue;
            bAPLogicalControlUnit.setService(this.dsibap);
            this.trace("Initialize logical control unit: ", bAPLogicalControlUnit.getLogicalControlUnitName());
        }
    }

    @Override
    public boolean consumeEvent(SystemEvent systemEvent) {
        Set set;
        int n = systemEvent.getType();
        if ((n == 1 || n == 2) && (set = (Set)this.registeredHMIEventConsumer.get(systemEvent.getASLSystemEventId())) != null) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                BAPDispatcherTarget$BAPHMIEventConsumer bAPDispatcherTarget$BAPHMIEventConsumer = (BAPDispatcherTarget$BAPHMIEventConsumer)iterator.next();
                EventGeneric eventGeneric = this.genericEventFactory.newEvent();
                eventGeneric.setInt(0, bAPDispatcherTarget$BAPHMIEventConsumer.lsgID);
                eventGeneric.setInt(1, bAPDispatcherTarget$BAPHMIEventConsumer.fctID);
                eventGeneric.setInt(2, bAPDispatcherTarget$BAPHMIEventConsumer.eventID);
                this.triggerMe(eventGeneric, -1937112832);
            }
        }
        return false;
    }

    @Override
    public void observeHMIEvents(int n, int n2, int[] nArray) {
        for (int n3 : nArray) {
            Set set = (Set)this.registeredHMIEventConsumer.get(n3);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.registeredHMIEventConsumer.put(n3, set);
            }
            set.add(new BAPDispatcherTarget$BAPHMIEventConsumer(n, n2, n3));
        }
    }

    @Override
    public Timer createTimer(TimerNotifier timerNotifier, int n, int n2, int n3, long l) {
        return new BAPDispatcherTarget$TimerProvider(this, n, n2, n3, l, timerNotifier);
    }

    @Override
    public BAPLogicalControlUnit getLogicalControlUnit(int n) {
        return (BAPLogicalControlUnit)this.registeredBAPControlUnits.get(n);
    }

    private BAPFunctionControlUnit getFunctionControlUnit(int n) {
        BAPLogicalControlUnit bAPLogicalControlUnit = this.getLogicalControlUnit(n);
        return bAPLogicalControlUnit != null && !bAPLogicalControlUnit.isDisplayControlUnit() ? (BAPFunctionControlUnit)bAPLogicalControlUnit : null;
    }

    private void activateTransition(BAPFunctionControlUnit bAPFunctionControlUnit) {
        try {
            bAPFunctionControlUnit.activateTransition();
        }
        catch (Exception exception) {
            this.error(exception);
        }
    }

    private void unknownDSIMessageReceived(String string, int n, int n2, String string2, int n3) {
        this.error().append("Discard received unknown BAP call ").append(string).append(" lsgID=").append(n).append(" fctID=").append(n2).append(string2).append(n3).log();
    }

    private void unknownLsgToProcessReceived(String string, int n, int n2) {
        this.error().append("Can't process ").append(string).append(" for lsgID=").append(n).append(" fctID=").append(n2).log();
    }

    @Override
    public int getClassifier() {
        return 2;
    }

    @Override
    public int getSubClassifier() {
        return 2;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

