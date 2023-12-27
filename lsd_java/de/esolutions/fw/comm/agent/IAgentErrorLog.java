/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.diag.IInfoBase;

public interface IAgentErrorLog {
    default public IInfoBase[] getProxyErrors() {
    }

    default public int getNumDroppedProxyErrors() {
    }

    default public IInfoBase[] getClientErrors() {
    }

    default public int getNumDroppedClientErrors() {
    }

    default public IInfoBase[] getStubErrors() {
    }

    default public int getNumDroppedStubErrors() {
    }
}

