/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app;

import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

public interface AppLifecycleService {
    default public void started(ModelApiUpEventHandler modelApiUpEventHandler) {
    }

    default public void stopped() {
    }
}

