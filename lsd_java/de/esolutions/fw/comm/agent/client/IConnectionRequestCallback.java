/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.client.IClientHandler;

public interface IConnectionRequestCallback {
    default public void connectionEstablished(IClientHandler iClientHandler) {
    }

    default public void connectionFailed(IClientHandler iClientHandler, String string) {
    }
}

