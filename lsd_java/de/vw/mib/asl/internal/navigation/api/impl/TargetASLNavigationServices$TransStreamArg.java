/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl;

import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.internal.navigation.api.impl.TargetASLNavigationServices;
import org.dsi.ifc.organizer.AdbEntry;

class TargetASLNavigationServices$TransStreamArg {
    private final AdbEntry entry;
    private final ASLNavigationServicesListener listener;
    private final /* synthetic */ TargetASLNavigationServices this$0;

    public TargetASLNavigationServices$TransStreamArg(TargetASLNavigationServices targetASLNavigationServices, ASLNavigationServicesListener aSLNavigationServicesListener, AdbEntry adbEntry) {
        this.this$0 = targetASLNavigationServices;
        this.listener = aSLNavigationServicesListener;
        this.entry = adbEntry;
    }

    public AdbEntry getEntry() {
        return this.entry;
    }

    public ASLNavigationServicesListener getListener() {
        return this.listener;
    }
}

