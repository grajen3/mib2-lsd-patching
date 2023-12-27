/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.app.framework;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.app.framework.AppLifecycleCio;

public interface AppLifecycleCioExecutor {
    default public void execute(AppLifecycleCio appLifecycleCio, CioActionParameters cioActionParameters) {
    }
}

