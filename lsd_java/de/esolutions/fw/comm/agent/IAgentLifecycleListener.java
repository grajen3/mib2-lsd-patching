/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.core.ILifecycleListener;

public interface IAgentLifecycleListener
extends ILifecycleListener {
    default public void brokerLinkStateChanged(boolean bl) {
    }

    default public void brokerConnectRetry(boolean bl) {
    }

    default public void agentIdUpdate(short s) {
    }

    default public Short getAgentIdProposal() {
    }
}

