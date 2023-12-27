/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.model.list;

import de.vw.mib.asl.internal.mirrorlink.model.list.MirrorlinkElementFetcher;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import generated.de.vw.mib.asl.internal.ListManager;

public class MirrorlinkAppListFetcher
extends MirrorlinkElementFetcher {
    public MirrorlinkAppListFetcher(int n, MirrorLinkTarget mirrorLinkTarget) {
        super(ListManager.getGenericASLList(n), mirrorLinkTarget);
    }

    @Override
    void getWindow(int n, int n2) {
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestAvailableApplicationsWindow(n, n2);
        }
    }
}

