/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;

public interface GlobalViewHandlerRegister {
    default public void registerRelayFactory(AppDefinition appDefinition, ViewHandlerFactory viewHandlerFactory) {
    }

    default public void unregisterRelayFactory(AppDefinition appDefinition) {
    }
}

