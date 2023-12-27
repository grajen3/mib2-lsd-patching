/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.base.IProvider;

public interface IProviderStateListener {
    default public void onConnecting(IProvider iProvider) {
    }

    default public void onConnected(IProvider iProvider) {
    }

    default public void onConnectionFailed(IProvider iProvider) {
    }

    default public void onConnectionLost(IProvider iProvider) {
    }

    default public void onDisconnected(IProvider iProvider) {
    }

    default public void onDisconnecting(IProvider iProvider) {
    }
}

