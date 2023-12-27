/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.hsm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.internal.ServiceManager;
import java.util.Arrays;

public class Hsm {
    public static final String HSM_LOG_PREFIX;
    private static final int DEPTH;
    private static final EventGeneric MSG_ENTRY;
    private static final EventGeneric MSG_EXIT;
    private static final EventGeneric MSG_START;
    public boolean verbose = false;
    private HsmState currentState = null;
    private EventGeneric externalEvent = null;
    private HsmState lcaState = null;
    private final HsmState[] mEntryPath = new HsmState[20];
    private String name = "";
    private HsmState nextState = null;
    private HsmState previousState = null;
    private HsmState topState;

    public Hsm() {
    }

    public Hsm(String string, HsmState hsmState) {
        this.topState = hsmState;
        this.name = string;
    }

    public final void activateTransition() {
        while (this.nextState != null) {
            this.doTransition(this.lcaState);
        }
    }

    public final EventGeneric getExternalEvent() {
        return this.externalEvent;
    }

    public final String getName() {
        return this.name;
    }

    public final HsmState getNextState() {
        return this.nextState;
    }

    public final HsmState getPreviousState() {
        return this.previousState;
    }

    public final HsmState getState() {
        return this.currentState;
    }

    public final void init(String string, HsmState hsmState) {
        this.name = string;
        this.topState = hsmState;
    }

    public final boolean isActive(HsmState hsmState) {
        return this.isChild(hsmState, this.currentState);
    }

    public final synchronized void onEvent(EventGeneric eventGeneric) {
        ServiceManager.hsmTracer.traceGotEvent(this.getName(), this.currentState, eventGeneric.getReceiverEventId());
        this.nextState = null;
        this.externalEvent = eventGeneric;
        try {
            for (HsmState hsmState = this.currentState; hsmState != null; hsmState = hsmState.getParent()) {
                if (this.trigger(hsmState, eventGeneric) != null) continue;
                this.activateTransition();
                break;
            }
        }
        catch (Exception exception) {
            if (this.nextState != null) {
                if (this.nextState == this.topState || this.isChild(this.topState, this.nextState)) {
                    this.currentState = this.nextState;
                }
                this.nextState = null;
            }
            throw exception;
        }
        this.externalEvent = null;
    }

    public final void onStart() {
        this.currentState = this.topState;
        this.nextState = null;
        this.sendHsmEntry(this.currentState);
        this.trigger(this.currentState, MSG_START);
        while (this.nextState != null) {
            this.doTransition(this.currentState);
        }
    }

    public void sendHsmEntry(HsmState hsmState) {
        this.trigger(hsmState, MSG_ENTRY);
    }

    public final void sendHsmStart() {
        this.previousState = this.currentState;
        this.currentState = this.nextState;
        this.nextState = null;
        this.trigger(this.currentState, MSG_START);
    }

    public String toString() {
        return this.getName();
    }

    public final void trans(HsmState hsmState) {
        ServiceManager.hsmTracer.traceTransition(this.getName(), this.currentState, hsmState);
        if (this.nextState != null) {
            throw new GenericEventException(1, "nextState != null");
        }
        if (this.nextState != hsmState) {
            int n = this.findLCA(hsmState);
            this.exit(n);
            this.nextState = hsmState;
        }
    }

    private void doTransition(HsmState hsmState) {
        Arrays.fill(this.mEntryPath, null);
        int n = -1;
        for (HsmState hsmState2 = this.nextState; hsmState2 != hsmState; hsmState2 = hsmState2.getParent()) {
            this.mEntryPath[++n] = hsmState2;
        }
        while (n >= 0) {
            this.sendHsmEntry(this.mEntryPath[n]);
            --n;
        }
        this.sendHsmStart();
    }

    private void exit(int n) {
        HsmState hsmState = this.currentState;
        for (int i2 = n; i2 > 0; --i2) {
            this.trigger(hsmState, MSG_EXIT);
            hsmState = hsmState.getParent();
        }
    }

    private int findLCA(HsmState hsmState) {
        HsmState hsmState2 = this.currentState;
        int n = 0;
        while (hsmState2 != null) {
            for (HsmState hsmState3 = hsmState; hsmState3 != null; hsmState3 = hsmState3.getParent()) {
                if (hsmState2 != hsmState3) continue;
                this.lcaState = hsmState2;
                return n;
            }
            hsmState2 = hsmState2.getParent();
            ++n;
        }
        return 0;
    }

    private boolean isChild(HsmState hsmState, HsmState hsmState2) {
        try {
            for (HsmState hsmState3 = hsmState2; hsmState3 != null; hsmState3 = hsmState3.getParent()) {
                if (hsmState3 != hsmState) continue;
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    private HsmState trigger(HsmState hsmState, EventGeneric eventGeneric) {
        HsmState hsmState2;
        if (this.verbose && ServiceManager.mLogger != null && ServiceManager.mLogger.isTraceEnabled(32)) {
            ServiceManager.mLogger.trace(32).append("Hsm#trigger:").append(this.name).append(":").append(hsmState.getName()).append(":").append(eventGeneric.getReceiverEventId()).log();
        }
        ServiceManager.hsmTracer.traceTrigger(this.name, hsmState, eventGeneric.getReceiverEventId());
        try {
            hsmState2 = hsmState.handle(eventGeneric);
        }
        catch (Exception exception) {
            if (ServiceManager.mLogger != null) {
                String string = "null-state";
                if (hsmState != null) {
                    string = hsmState.getName();
                }
                String string2 = "null-event";
                if (eventGeneric != null) {
                    string2 = eventGeneric.toString();
                }
                ServiceManager.mLogger.error(32).append("Exception in HSM ").append(this.name).append(" State ").append(string).append(" during processing the event ").append(string2).attachThrowable(exception).log();
            }
            throw exception;
        }
        return hsmState2;
    }

    static {
        MSG_ENTRY = new EventGeneric(0, 0, 2);
        MSG_EXIT = new EventGeneric(0, 0, 4);
        MSG_START = new EventGeneric(0, 0, 3);
    }
}

