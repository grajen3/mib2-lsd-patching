/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.client.IClientHandler;

public interface IClientHandlerListener {
    default public void clientHandlerStateUpdate(IClientHandler iClientHandler, boolean bl) {
    }
}

