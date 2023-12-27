/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.internal.impl.homescreen.TileInstallerImpl;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;

class TileInstallerImpl$1
implements CioRegistrationListener {
    private final /* synthetic */ TileInstallerImpl this$0;

    TileInstallerImpl$1(TileInstallerImpl tileInstallerImpl) {
        this.this$0 = tileInstallerImpl;
    }

    @Override
    public void cioRegistered(String string, CioIntent cioIntent) {
        if ("TileHeaderButtonAction".equals(string)) {
            this.this$0.updateHeaders();
        }
    }

    @Override
    public void cioUnregistered(String string, CioIntent cioIntent) {
    }
}

