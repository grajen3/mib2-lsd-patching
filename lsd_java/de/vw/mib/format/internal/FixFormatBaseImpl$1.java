/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format.internal;

import de.vw.mib.configuration.NvListener;
import de.vw.mib.format.internal.FixFormatBaseImpl;
import de.vw.mib.format.internal.ServiceManager;

class FixFormatBaseImpl$1
implements NvListener {
    private final /* synthetic */ FixFormatBaseImpl this$0;

    FixFormatBaseImpl$1(FixFormatBaseImpl fixFormatBaseImpl) {
        this.this$0 = fixFormatBaseImpl;
    }

    @Override
    public void notifyNvListener(int n) {
        this.this$0.setNewGuiLanguage(ServiceManager.configurationManager.getCurrentGuiLanguage());
    }
}

