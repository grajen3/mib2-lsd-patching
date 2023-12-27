/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.genericevents;

import de.vw.mib.debug.service.probes.genericevents.GenericEventCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.diag.GenericEventTracer;
import java.io.IOException;

public class GenericEventTracerHelper
implements GenericEventTracer {
    public static final int PROXY_T_ID;
    public static final int SKELETON_T_ID;
    private ProbeSystemServices probeSystemServices;

    public GenericEventTracerHelper(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void trace(byte by, byte by2, int n, EventGeneric eventGeneric) {
        if (eventGeneric.getSenderRouterId() != 0 || eventGeneric.getReceiverRouterId() != 0) {
            return;
        }
        if (eventGeneric.getSenderTargetId() == 560271616 || eventGeneric.getSenderTargetId() == 577048832) {
            return;
        }
        try {
            GenericEventCodec genericEventCodec = (GenericEventCodec)this.probeSystemServices.borrowCodec();
            genericEventCodec.encode(by, by2, n, eventGeneric);
            this.probeSystemServices.releaseCodec(genericEventCodec);
        }
        catch (IOException iOException) {
            this.probeSystemServices.getLogger(64).error(4, "error while encoding GenericEvent", iOException);
        }
    }
}

