/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.configuration.internal.ConfigurationManagerImpl;

class ConfigurationManagerImpl$1
implements Runnable {
    private final /* synthetic */ int val$newSkinmode;
    private final /* synthetic */ ConfigurationManagerImpl this$0;

    ConfigurationManagerImpl$1(ConfigurationManagerImpl configurationManagerImpl, int n) {
        this.this$0 = configurationManagerImpl;
        this.val$newSkinmode = n;
    }

    @Override
    public void run() {
        this.this$0.executeOnNewSkinmode(this.val$newSkinmode);
    }
}

