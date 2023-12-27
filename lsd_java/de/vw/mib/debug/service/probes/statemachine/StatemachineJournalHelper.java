/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.statemachine;

import de.vw.mib.debug.common.probes.statemachine.StatemachineProbeConfiguration;
import de.vw.mib.debug.service.probes.statemachine.StatemachineCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.sm.journal.SmJournalExEmpty;

final class StatemachineJournalHelper
extends SmJournalExEmpty {
    private final StatemachineProbeConfiguration config;
    private ProbeSystemServices probeSystemServices;

    public StatemachineJournalHelper(ProbeSystemServices probeSystemServices) {
        this.config = (StatemachineProbeConfiguration)probeSystemServices.getConfiguration();
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void eventProcessing(int n, short s) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeEventProcessing(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void eventProcessed(int n, boolean bl) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeEventProcessed(n, bl);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void eventSkipped(int n) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeEventProcessed(n, false);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void eventForwardingToStatemachine(int n, int n2) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeEventForwardingToSelectedStatemachine(n, n2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void checkpoint(char c2) {
    }

    @Override
    public void fatalError(int n, int n2, short s, RuntimeException runtimeException) {
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeFatalError(n, n2, s, runtimeException);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void activatorChecking(int n) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeActivatorChecking(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void activatorChecked(int n) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeActivatorChecked(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void deactivatorChecking(int n) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeDeactivatorChecking(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void deactivatorChecked(int n) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeDeactivatorChecked(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void statemachineActivating(int n) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStatemachineActivating(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void statemachineActivated(int n) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStatemachineActivated(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void statemachineDeactivating(int n) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStatemachineDeactivating(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void statemachineDeactivated(int n) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStatemachineDeactivated(n);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void internalTransitionPerforming(int n, int n2, short s, short s2) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeInternalTransitionPerforming(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void internalTransitionActing(int n, int n2, short s, short s2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeInternalTransitionActing(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void internalTransitionActed(int n, int n2, short s, short s2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeInternalTransitionActed(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void internalTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeInternalTransitionPerformed(n, n2, s, s2, bl);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void triggeredTransitionPerforming(int n, int n2, short s, short s2) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeTriggeredTransitionPerforming(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void triggeredTransitionActing(int n, int n2, short s, short s2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeTriggeredTransitionActing(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void triggeredTransitionActed(int n, int n2, short s, short s2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeTriggeredTransitionActed(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void triggeredTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeTriggeredTransitionPerformed(n, n2, s, s2, bl);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void untriggeredTransitionPerforming(int n, int n2, short s, short s2) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeUntriggeredTransitionPerforming(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void untriggeredTransitionActing(int n, int n2, short s, short s2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeUntriggeredTransitionActing(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void untriggeredTransitionActed(int n, int n2, short s, short s2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeUntriggeredTransitionActed(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void untriggeredTransitionPerformed(int n, int n2, short s, short s2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeUntriggeredTransitionPerformed(n, n2, s, s2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void subStatemachineActivating(int n, int n2) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeSubStatemachineActivating(n, n2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void subStatemachineActivated(int n, int n2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeSubStatemachineActivated(n, n2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void subStatemachineDeactivating(int n, int n2) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeSubStatemachineDeactivating(n, n2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void subStatemachineDeactivated(int n, int n2) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeSubStatemachineDeactivated(n, n2);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateEntryActing(int n, int n2, short s, boolean bl) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateEntryActing(n, n2, s, bl);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateEntryActed(int n, int n2, short s) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateEntryActed(n, n2, s);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateExitActing(int n, int n2, short s) {
        if (!this.config.isInfoEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateExitActing(n, n2, s);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateExitActed(int n, int n2, short s) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateExitActed(n, n2, s);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateFocusGainedActing(int n, int n2, short s) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateFocusGainedActing(n, n2, s);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateFocusGainedActed(int n, int n2, short s) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateFocusGainedActed(n, n2, s);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateFocusLostActing(int n, int n2, short s) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateFocusLostActing(n, n2, s);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }

    @Override
    public void stateFocusLostActed(int n, int n2, short s) {
        if (!this.config.isTraceEnabled()) {
            return;
        }
        StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
        statemachineCodec.encodeStateFocusLostActed(n, n2, s);
        this.probeSystemServices.releaseCodec(statemachineCodec);
    }
}

