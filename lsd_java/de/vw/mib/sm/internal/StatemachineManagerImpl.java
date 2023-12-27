/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.event.Event;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.AppHmiEnvironment;
import de.vw.mib.sm.StatemachineManager;
import de.vw.mib.sm.internal.CurrentHMIEvent;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.SpecialEventIds;
import de.vw.mib.sm.internal.statemachine.MainStatemachineOrder;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;

public class StatemachineManagerImpl
implements StatemachineManager {
    private static final int NO_STATEMACHINE;
    private static final AppDefinition GLOBAL_EVENT;
    private static final AppDefinition BROADCAST;
    private final TopStatemachine[] statemachines;
    private final AppHmiEnvironment[] appHmiEnvironments;
    private final int permanentTopStatemachineFirstId;
    private final SpecialEventIds specialEventIds;
    private final MainStatemachineOrder mainStatemachineOrder;
    private Logger logger;
    private int activeStatemachineId = -1;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$sm$internal$StatemachineManagerImpl;

    public StatemachineManagerImpl(TopStatemachine[] topStatemachineArray, MainStatemachineOrder mainStatemachineOrder, SpecialEventIds specialEventIds) {
        if (!$assertionsDisabled && topStatemachineArray == null) {
            throw new AssertionError((Object)"Pre-Condition");
        }
        this.statemachines = topStatemachineArray;
        this.appHmiEnvironments = new AppHmiEnvironment[topStatemachineArray.length];
        this.mainStatemachineOrder = mainStatemachineOrder;
        this.permanentTopStatemachineFirstId = StatemachineManagerImpl.computePermanentStatemachineFirstId(topStatemachineArray);
        this.specialEventIds = specialEventIds;
        this.logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
    }

    private static int computePermanentStatemachineFirstId(TopStatemachine[] topStatemachineArray) {
        for (int i2 = topStatemachineArray.length - 1; i2 >= 0; --i2) {
            if (!StatemachineManagerImpl.isSet(topStatemachineArray[i2].getKind(), 2)) continue;
            return i2 + 1;
        }
        return 0;
    }

    private static boolean isSet(int n, int n2) {
        return (n & n2) == n2;
    }

    public void start() {
        if (!$assertionsDisabled && ServiceManagerStatemachine.journalEx == null) {
            throw new AssertionError();
        }
        ServiceManagerStatemachine.journalEx.managerStarted();
    }

    public void activateMainStatemachines(AppHmiEnvironment appHmiEnvironment, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            this.activateStatemachine(n, appHmiEnvironment);
        }
    }

    public void defineAppLayerEnvironmentForDynamicStatemachines(AppHmiEnvironment appHmiEnvironment, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            this.appHmiEnvironments[n] = appHmiEnvironment;
        }
    }

    @Override
    public void activatePopup(int n) {
        AppHmiEnvironment appHmiEnvironment = this.appHmiEnvironments[n];
        Preconditions.checkState(appHmiEnvironment != null, "App for popup not started (ready).");
        this.activateStatemachine(n, appHmiEnvironment);
    }

    @Override
    public void deactivatePopup(int n) {
        if (!this.statemachines[n].livesIn(1)) {
            this.deactiveStatemachine(n);
        }
        ServiceManagerStatemachine.dynamicStatemachineTrigger.closed(n);
    }

    @Override
    public void suspendPopup(int n) {
        this.statemachines[n].suspend();
    }

    @Override
    public void resumePopup(int n) {
        this.statemachines[n].resume();
    }

    @Override
    public void focusGainedPopup(int n) {
        this.statemachines[n].focusGained();
    }

    @Override
    public void focusLostPopup(int n) {
        this.statemachines[n].focusLost();
    }

    private void activateStatemachine(int n, AppHmiEnvironment appHmiEnvironment) {
        if (!$assertionsDisabled && !this.statemachines[n].livesIn(1)) {
            throw new AssertionError((Object)this.statemachines[n].toString());
        }
        ServiceManagerStatemachine.journalEx.statemachineActivating(n);
        this.statemachines[n].start(appHmiEnvironment);
        ServiceManagerStatemachine.journalEx.statemachineActivated(n);
        if (this.statemachines[n].livesIn(8)) {
            this.deactiveStatemachine(n);
            ServiceManagerStatemachine.dynamicStatemachineTrigger.selfClosing(n);
        }
    }

    private void deactiveStatemachine(int n) {
        if (!$assertionsDisabled && !this.statemachines[n].livesIn(14)) {
            throw new AssertionError((Object)this.statemachines[n].toString());
        }
        ServiceManagerStatemachine.journalEx.statemachineDeactivating(n);
        this.statemachines[n].finish();
        ServiceManagerStatemachine.journalEx.statemachineDeactivated(n);
        if (!$assertionsDisabled && !this.statemachines[n].livesIn(1)) {
            throw new AssertionError((Object)this.statemachines[n].toString());
        }
    }

    public void handleHMIEvent() {
        this.log("SM_SPLIT_INFO: Dispatching an HMI event to main statemachines.", -1);
        int n = this.mainStatemachineOrder.firstId(this.activeStatemachineId);
        while (n != -1) {
            if (this.consumedByStatemachine(n)) {
                if (n == this.activeStatemachineId) {
                    this.log("SM_SPLIT_INFO: HMI event has been consumed by a passive main statemachine: ", n);
                } else {
                    this.log("SM_SPLIT_INFO: HMI event has been consumed by an active main statemachine: ", n);
                }
                return;
            }
            n = this.mainStatemachineOrder.nextId();
        }
        this.log("SM_SPLIT_INFO: HMI event has not been consumed by a main statemachine.", -1);
    }

    private boolean consumedByStatemachine(int n) {
        TopStatemachine topStatemachine = this.statemachines[n];
        if (!$assertionsDisabled && !topStatemachine.livesIn(3)) {
            throw new AssertionError((Object)topStatemachine.toString());
        }
        if (!topStatemachine.livesIn(2)) {
            return false;
        }
        if (topStatemachine.canResponseToHMIEvent()) {
            boolean bl = topStatemachine.handleHMIEvent();
            return bl;
        }
        return false;
    }

    public void setActiveStatemachine(int n) {
        if (this.activeStatemachineId == n) {
            return;
        }
        this.log("SM_SPLIT_INFO: Active statemachine has changed to: ", n);
        this.activeStatemachineId = n;
    }

    private void log(String string, int n) {
        if (this.logger.isTraceEnabled(3)) {
            LogMessage logMessage = this.logger.trace(3);
            logMessage.append(string);
            if (n != -1) {
                this.statemachines[n].appendToLog(logMessage);
            }
            logMessage.log();
        }
    }

    public final void consumeEventForActiveDynamicStatemachines_forTestOnly(HMIEvent hMIEvent) {
        for (int i2 = 0; i2 < this.permanentTopStatemachineFirstId; ++i2) {
            if (!this.statemachines[i2].livesIn(2)) continue;
            this.consumeEvent(i2, hMIEvent);
        }
    }

    @Override
    public boolean consumeEvent(int n, HMIEvent hMIEvent) {
        TopStatemachine topStatemachine = this.statemachines[n];
        if (!$assertionsDisabled && !topStatemachine.livesIn(3)) {
            throw new AssertionError((Object)topStatemachine.toString());
        }
        if (!topStatemachine.livesIn(2)) {
            return false;
        }
        if (hMIEvent.isConsumed()) {
            return true;
        }
        int n2 = hMIEvent.getId();
        ServiceManagerStatemachine.journalEx.eventProcessing(n2, (short)1);
        CurrentHMIEvent.set(hMIEvent);
        if (topStatemachine.canResponseToHMIEvent()) {
            topStatemachine.handleHMIEvent();
            if (topStatemachine.livesIn(8)) {
                this.deactiveStatemachine(n);
                ServiceManagerStatemachine.dynamicStatemachineTrigger.selfClosing(n);
            }
            CurrentHMIEvent.reset();
            ServiceManagerStatemachine.journalEx.eventProcessed(n2, hMIEvent.isConsumed());
            return hMIEvent.isConsumed();
        }
        CurrentHMIEvent.reset();
        ServiceManagerStatemachine.journalEx.eventSkipped(n2);
        return hMIEvent.isConsumed();
    }

    @Override
    public void setDriverDistractionPrevention(int n) {
        switch (n) {
            case 1: {
                this.fireSpecialEvent(this.specialEventIds.ddpActive);
                break;
            }
            case 0: {
                this.fireSpecialEvent(this.specialEventIds.ddpInactive);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Statemachine DriverDistractionPrevention ActivationState is unknown: ").append(n).toString());
            }
        }
    }

    @Override
    public void veryImportantPopup(int n) {
        switch (n) {
            case 1: {
                this.fireSpecialEvent(this.specialEventIds.vipPresent);
                break;
            }
            case 0: {
                this.fireSpecialEvent(this.specialEventIds.vipAbsent);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Very important popup info is unknown: ").append(n).toString());
            }
        }
    }

    private void fireSpecialEvent(int n) {
        if (n != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitHMIEvent(GLOBAL_EVENT, BROADCAST, n);
        }
    }

    public void cycleDetected(Event event) {
        LogMessage logMessage = this.logger.error(1);
        logMessage.append("Cycle detected: Excessive firing of high priority HMIEvents into statemachines.\n");
        logMessage.append(" - Event: ").append(event).append("\n");
        for (int i2 = 0; i2 < this.statemachines.length; ++i2) {
            if (!this.statemachines[i2].livesIn(2)) continue;
            this.statemachines[i2].appendToLog(logMessage);
        }
        logMessage.log();
    }

    @Override
    public int getStatemachineCount() {
        return this.statemachines.length;
    }

    @Override
    public int getCurrentMainId(int n) {
        TopStatemachine topStatemachine = this.getTopStatemachine(n);
        return topStatemachine.getId();
    }

    private TopStatemachine getTopStatemachine(int n) {
        Preconditions.checkState(this.statemachines != null, "Statemachine array is null. This should not happen.");
        Preconditions.checkArgument(n < this.statemachines.length && n >= 0, new StringBuffer().append("Top statemachine cannot be found. Wanted index '").append(n).append("' is not between 0 and ").append(this.statemachines.length).toString());
        TopStatemachine topStatemachine = this.statemachines[n];
        Preconditions.checkState(topStatemachine != null, new StringBuffer().append("Found a null object in the top statemachine array at index ").append(n).toString());
        return topStatemachine;
    }

    @Override
    public int getCurrentSubSmIdForTopSmId(int n) {
        TopStatemachine topStatemachine = this.getTopStatemachine(n);
        return topStatemachine.getCurrentSubStatemachine();
    }

    @Override
    public int getCurrentStateIdForTopSmId(int n) {
        TopStatemachine topStatemachine = this.getTopStatemachine(n);
        return topStatemachine.getCurrentState();
    }

    @Override
    public int[] getCurrentlyActiveMainStatemachineIDs() {
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        for (int i2 = 0; i2 < this.statemachines.length; ++i2) {
            TopStatemachine topStatemachine = this.statemachines[i2];
            if (topStatemachine.getCurrentState() == -1) continue;
            intOptHashSet.add(topStatemachine.getId());
        }
        return intOptHashSet.toArray();
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
        $assertionsDisabled = !(class$de$vw$mib$sm$internal$StatemachineManagerImpl == null ? (class$de$vw$mib$sm$internal$StatemachineManagerImpl = StatemachineManagerImpl.class$("de.vw.mib.sm.internal.StatemachineManagerImpl")) : class$de$vw$mib$sm$internal$StatemachineManagerImpl).desiredAssertionStatus();
        GLOBAL_EVENT = null;
        BROADCAST = null;
    }
}

