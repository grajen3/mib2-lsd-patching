/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.IAgentLifecycleListener;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.Lifecycle;
import java.util.ArrayList;

public class AgentLifecycleDispatcher
implements IAgentLifecycleListener {
    private final ArrayList compatListener = new ArrayList();
    private final ArrayList agentListener = new ArrayList();

    public synchronized void register(ILifecycleListener iLifecycleListener) {
        this.compatListener.add(iLifecycleListener);
        if (iLifecycleListener instanceof IAgentLifecycleListener) {
            this.agentListener.add(iLifecycleListener);
        }
    }

    public synchronized void unregister(ILifecycleListener iLifecycleListener) {
        this.compatListener.remove(iLifecycleListener);
        if (iLifecycleListener instanceof IAgentLifecycleListener) {
            this.agentListener.remove(iLifecycleListener);
        }
    }

    private synchronized ILifecycleListener[] getCompatList() {
        int n = this.compatListener.size();
        Object[] objectArray = new ILifecycleListener[n];
        this.compatListener.toArray(objectArray);
        return objectArray;
    }

    private synchronized IAgentLifecycleListener[] getAgentList() {
        int n = this.agentListener.size();
        Object[] objectArray = new IAgentLifecycleListener[n];
        this.agentListener.toArray(objectArray);
        return objectArray;
    }

    @Override
    public void lifecycleChanged(Lifecycle lifecycle, Object object) {
        ILifecycleListener[] iLifecycleListenerArray = this.getCompatList();
        for (int i2 = 0; i2 < iLifecycleListenerArray.length; ++i2) {
            iLifecycleListenerArray[i2].lifecycleChanged(lifecycle, object);
        }
    }

    @Override
    public void brokerLinkStateChanged(boolean bl) {
        IAgentLifecycleListener[] iAgentLifecycleListenerArray = this.getAgentList();
        for (int i2 = 0; i2 < iAgentLifecycleListenerArray.length; ++i2) {
            iAgentLifecycleListenerArray[i2].brokerLinkStateChanged(bl);
        }
    }

    @Override
    public void brokerConnectRetry(boolean bl) {
        IAgentLifecycleListener[] iAgentLifecycleListenerArray = this.getAgentList();
        for (int i2 = 0; i2 < iAgentLifecycleListenerArray.length; ++i2) {
            iAgentLifecycleListenerArray[i2].brokerConnectRetry(bl);
        }
    }

    @Override
    public void agentIdUpdate(short s) {
        IAgentLifecycleListener[] iAgentLifecycleListenerArray = this.getAgentList();
        for (int i2 = 0; i2 < iAgentLifecycleListenerArray.length; ++i2) {
            iAgentLifecycleListenerArray[i2].agentIdUpdate(s);
        }
    }

    @Override
    public Short getAgentIdProposal() {
        IAgentLifecycleListener[] iAgentLifecycleListenerArray = this.getAgentList();
        for (int i2 = 0; i2 < iAgentLifecycleListenerArray.length; ++i2) {
            Short s = iAgentLifecycleListenerArray[i2].getAgentIdProposal();
            if (s == null) continue;
            return s;
        }
        return null;
    }
}

