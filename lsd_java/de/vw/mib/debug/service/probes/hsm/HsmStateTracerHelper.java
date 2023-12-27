/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.hsm;

import de.vw.mib.debug.service.probes.hsm.HsmCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.genericevents.diag.HsmStateTracer;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import java.io.IOException;

public class HsmStateTracerHelper
implements HsmStateTracer {
    private ProbeSystemServices probeSystemServices;
    private Logger logger;

    public HsmStateTracerHelper(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
        this.logger = probeSystemServices.getLogger(64);
    }

    @Override
    public void traceGotEvent(String string, HsmState hsmState, int n) {
        try {
            HsmCodec hsmCodec = (HsmCodec)this.probeSystemServices.borrowCodec();
            hsmCodec.encodeGotEvent(string, this.getFullQualifiedStateName(hsmState), n);
            this.probeSystemServices.releaseCodec(hsmCodec);
        }
        catch (IOException iOException) {
            this.logger.error(4, "[HsmProbeInformation] error while encoding got event", iOException);
        }
    }

    @Override
    public void traceTrigger(String string, HsmState hsmState, int n) {
        try {
            HsmCodec hsmCodec = (HsmCodec)this.probeSystemServices.borrowCodec();
            hsmCodec.encodeTrigger(string, this.getFullQualifiedStateName(hsmState), n);
            this.probeSystemServices.releaseCodec(hsmCodec);
        }
        catch (IOException iOException) {
            this.logger.error(4, "[HsmProbeInformation] error while encoding trigger", iOException);
        }
    }

    @Override
    public void traceTransition(String string, HsmState hsmState, HsmState hsmState2) {
        try {
            HsmCodec hsmCodec = (HsmCodec)this.probeSystemServices.borrowCodec();
            hsmCodec.encodeTransition(string, this.getFullQualifiedStateName(hsmState), this.getFullQualifiedStateName(hsmState2));
            this.probeSystemServices.releaseCodec(hsmCodec);
        }
        catch (IOException iOException) {
            this.logger.error(4, "[HsmProbeInformation] error while encoding transition", iOException);
        }
    }

    private String getFullQualifiedStateName(HsmState hsmState) {
        if (hsmState == null) {
            return "HSM not initialized";
        }
        String string = hsmState.getName();
        for (HsmState hsmState2 = hsmState.getParent(); hsmState2 != null; hsmState2 = hsmState2.getParent()) {
            string = new StringBuffer().append(hsmState2.getName()).append(":").append(string).toString();
        }
        return string;
    }
}

