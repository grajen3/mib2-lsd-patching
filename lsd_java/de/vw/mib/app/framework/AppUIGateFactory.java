/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework;

import de.vw.mib.app.AppUIGate;
import de.vw.mib.app.framework.AppDefinition;

public interface AppUIGateFactory {
    default public AppUIGate createApp(AppDefinition appDefinition) {
    }
}

