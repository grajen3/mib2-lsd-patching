/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.statemachine;

import de.vw.mib.debug.service.probes.statemachine.StatemachineCodec;
import de.vw.mib.debug.service.probes.statemachine.StatemachineJournalHelper;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.sm.StatemachineDiagnose;
import de.vw.mib.sm.journal.SmJournals;

public final class StatemachineProbe
extends AbstractDebugProbe {
    private static final int STATEMACHINE_INACTIVE;
    private StatemachineJournalHelper journal;
    private StatemachineDiagnose diag;
    static /* synthetic */ Class class$de$vw$mib$sm$StatemachineDiagnose;

    public StatemachineProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    protected AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new StatemachineCodec(probeSystemServices);
    }

    @Override
    protected boolean deactivateProbe() {
        SmJournals.unregisterSmJournalEx(this.journal);
        return true;
    }

    @Override
    protected boolean initProbe() {
        this.journal = new StatemachineJournalHelper(this.probeSystemServices);
        this.diag = (StatemachineDiagnose)this.probeSystemServices.getService((class$de$vw$mib$sm$StatemachineDiagnose == null ? (class$de$vw$mib$sm$StatemachineDiagnose = StatemachineProbe.class$("de.vw.mib.sm.StatemachineDiagnose")) : class$de$vw$mib$sm$StatemachineDiagnose).getName());
        return true;
    }

    @Override
    protected boolean activateProbe() {
        SmJournals.registerSmJournalEx(this.journal);
        this.getInitialStatemachine();
        return true;
    }

    private void getInitialStatemachine() {
        int[] nArray = this.diag.getCurrentlyActiveMainStatemachineIDs();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            int n2 = this.diag.getCurrentSubSmIdForTopSmId(n);
            if (n2 <= -1) continue;
            int n3 = this.diag.getCurrentStateIdForTopSmId(n);
            StatemachineCodec statemachineCodec = (StatemachineCodec)this.probeSystemServices.borrowCodec();
            statemachineCodec.encodeCurrentStatemachine(n, n2, n3);
            this.probeSystemServices.releaseCodec(statemachineCodec);
        }
    }

    @Override
    protected boolean configureProbe() {
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
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

