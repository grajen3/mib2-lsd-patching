/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util;

import de.vw.mib.asl.internal.system.util.VersionNumberUpdater;
import de.vw.mib.configuration.NvListener;

class VersionNumberUpdater$1
implements NvListener {
    private final /* synthetic */ VersionNumberUpdater this$0;

    VersionNumberUpdater$1(VersionNumberUpdater versionNumberUpdater) {
        this.this$0 = versionNumberUpdater;
    }

    @Override
    public void notifyNvListener(int n) {
        this.this$0.updateVersionInformation();
    }
}

