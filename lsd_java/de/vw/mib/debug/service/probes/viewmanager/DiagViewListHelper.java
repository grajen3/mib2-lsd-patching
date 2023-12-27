/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.viewmanager;

import de.vw.mib.debug.service.probes.viewmanager.ViewManagerCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.viewmanager.internal.DiagViewListListener;
import java.util.ArrayList;

public class DiagViewListHelper
implements DiagViewListListener {
    private ProbeSystemServices probeSystemServices;

    public DiagViewListHelper(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void notifyVisibleViewsChange(ArrayList arrayList) {
        ViewManagerCodec viewManagerCodec = (ViewManagerCodec)this.probeSystemServices.borrowCodec();
        viewManagerCodec.encodeVisibleViewsChange(arrayList);
        this.probeSystemServices.releaseCodec(viewManagerCodec);
    }

    @Override
    public void notifyNewMainViewActive(String string) {
    }
}

