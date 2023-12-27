/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.attributes;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.IAgentInfoProvider;
import de.esolutions.fw.comm.agent.IAgentStateListener;
import de.esolutions.fw.comm.agent.diag.AgentInfoMap;
import de.esolutions.fw.comm.agent.diag.WeakRefAgentInfoProvider;
import de.esolutions.fw.comm.agent.diag.info.AttributeServiceInfo;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class AttributesBaseService
implements IAgentInfoProvider,
IProxyListener,
IAgentStateListener {
    private final String name;
    private final Map notificationMap;
    private static WeakRefAgentInfoProvider weakRefInfoProvider;
    private final IAttributeBitMapProvider attributeMap;
    public static final TraceChannel TRACE;

    public AttributesBaseService(String string, IAttributeBitMapProvider iAttributeBitMapProvider) {
        this.name = string;
        this.notificationMap = new HashMap();
        this.attributeMap = iAttributeBitMapProvider;
        weakRefInfoProvider = new WeakRefAgentInfoProvider();
        weakRefInfoProvider.registerIAgentInfoProvider(this);
        Agent.registerAgentStateListener(this);
    }

    @Override
    public void agentStarted(Agent agent) {
        agent.getAgentDiagnosis().registerInfoProvider(weakRefInfoProvider);
    }

    @Override
    public void agentAboutToStop(Agent agent) {
        agent.getAgentDiagnosis().unregisterInfoProvider(weakRefInfoProvider);
    }

    @Override
    public AgentInfoMap getAgentInfoMap() {
        AgentInfoMap agentInfoMap = new AgentInfoMap();
        AttributeServiceInfo attributeServiceInfo = new AttributeServiceInfo(0, this.notificationMap.size(), this.name, "Instance");
        agentInfoMap.add(this.name, attributeServiceInfo);
        return agentInfoMap;
    }

    public synchronized List getNotifications(int n) {
        int n2 = this.attributeMap.getAttributeBit(n);
        Set set = this.notificationMap.entrySet();
        Iterator iterator = set.iterator();
        ArrayList arrayList = new ArrayList();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            BitSet bitSet = (BitSet)map$Entry.getValue();
            if (!bitSet.get(n2)) continue;
            arrayList.add(map$Entry.getKey());
        }
        return arrayList;
    }

    public synchronized void setNotification(long l, Object object) {
        if (object instanceof IProxyFrontend) {
            IProxyFrontend iProxyFrontend = (IProxyFrontend)object;
            int n = this.attributeMap.getAttributeBit(l);
            if (this.notificationMap.containsKey(iProxyFrontend)) {
                BitSet bitSet = (BitSet)this.notificationMap.get(iProxyFrontend);
                bitSet.set(n);
            } else {
                BitSet bitSet = new BitSet(this.attributeMap.getAttributesCount());
                bitSet.set(n);
                this.notificationMap.put(iProxyFrontend, bitSet);
                this.registerProxyListener(iProxyFrontend);
            }
        } else {
            TRACE.log((short)5, "setNotification failed: ReplyProxy is no instance of IProxyFrontend!");
        }
    }

    public synchronized void setNotification(Object object) {
        if (object instanceof IProxyFrontend) {
            IProxyFrontend iProxyFrontend = (IProxyFrontend)object;
            if (this.notificationMap.containsKey(iProxyFrontend)) {
                BitSet bitSet = (BitSet)this.notificationMap.get(iProxyFrontend);
                bitSet.set(0, bitSet.size());
            } else {
                BitSet bitSet = new BitSet(this.attributeMap.getAttributesCount());
                bitSet.set(0, bitSet.size());
                this.notificationMap.put(iProxyFrontend, bitSet);
                this.registerProxyListener(iProxyFrontend);
            }
        } else {
            TRACE.log((short)5, "setNotification failed: ReplyProxy is no instance of IProxyFrontend!");
        }
    }

    public synchronized void setNotification(long[] lArray, Object object) {
        if (object instanceof IProxyFrontend) {
            IProxyFrontend iProxyFrontend = (IProxyFrontend)object;
            int[] nArray = new int[lArray.length];
            for (int i2 = 0; i2 < lArray.length; ++i2) {
                nArray[i2] = this.attributeMap.getAttributeBit(lArray[i2]);
            }
            if (this.notificationMap.containsKey(iProxyFrontend)) {
                BitSet bitSet = (BitSet)this.notificationMap.get(iProxyFrontend);
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    bitSet.set(nArray[i3]);
                }
            } else {
                BitSet bitSet = new BitSet(this.attributeMap.getAttributesCount());
                for (int i4 = 0; i4 < nArray.length; ++i4) {
                    bitSet.set(nArray[i4]);
                }
                this.notificationMap.put(iProxyFrontend, bitSet);
                this.registerProxyListener(iProxyFrontend);
            }
        } else {
            TRACE.log((short)5, "setNotification failed: ReplyProxy is no instance of IProxyFrontend!");
        }
    }

    public synchronized void clearNotification(long l, Object object) {
        if (object instanceof IProxyFrontend) {
            IProxyFrontend iProxyFrontend = (IProxyFrontend)object;
            int n = this.attributeMap.getAttributeBit(l);
            if (this.notificationMap.containsKey(iProxyFrontend)) {
                BitSet bitSet = (BitSet)this.notificationMap.get(iProxyFrontend);
                bitSet.clear(n);
            }
        } else {
            TRACE.log((short)5, "clearNotification failed: ReplyProxy is no instance of IProxyFrontend!");
        }
    }

    public synchronized void clearNotification(Object object) {
        if (object instanceof IProxyFrontend) {
            IProxyFrontend iProxyFrontend = (IProxyFrontend)object;
            if (this.notificationMap.containsKey(iProxyFrontend)) {
                BitSet bitSet = (BitSet)this.notificationMap.get(iProxyFrontend);
                bitSet.clear();
            }
        } else {
            TRACE.log((short)5, "clearNotification failed: ReplyProxy is no instance of IProxyFrontend!");
        }
    }

    public synchronized void clearNotification(long[] lArray, Object object) {
        if (object instanceof IProxyFrontend) {
            IProxyFrontend iProxyFrontend = (IProxyFrontend)object;
            int[] nArray = new int[lArray.length];
            for (int i2 = 0; i2 < lArray.length; ++i2) {
                nArray[i2] = this.attributeMap.getAttributeBit(lArray[i2]);
            }
            if (this.notificationMap.containsKey(iProxyFrontend)) {
                BitSet bitSet = (BitSet)this.notificationMap.get(iProxyFrontend);
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    bitSet.clear(nArray[i3]);
                }
            }
        } else {
            TRACE.log((short)5, "clearNotification failed: ReplyProxy is no instance of IProxyFrontend!");
        }
    }

    @Override
    public synchronized void proxyStateChanged(Proxy proxy, int n) {
        IProxyFrontend iProxyFrontend;
        if ((n == 2 || n == 3) && (iProxyFrontend = this.findReplyByProxy(proxy)) != null) {
            this.clearNotification(iProxyFrontend);
            this.notificationMap.remove(iProxyFrontend);
        }
    }

    private IProxyFrontend findReplyByProxy(Proxy proxy) {
        Set set = this.notificationMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object instanceof IProxyFrontend) {
                IProxyFrontend iProxyFrontend = (IProxyFrontend)object;
                if (proxy != iProxyFrontend.getProxy()) continue;
                return iProxyFrontend;
            }
            TRACE.log((short)5, "findReplyByProxy failed: ReplyProxy is no instance of IProxyFrontend!");
        }
        return null;
    }

    private void registerProxyListener(IProxyFrontend iProxyFrontend) {
        Proxy proxy = iProxyFrontend.getProxy();
        if (proxy != null) {
            proxy.registerProxyListener(this);
        }
    }

    static {
        TRACE = TraceClient.createTraceChannel("comm.attributes.baseservice");
    }
}

