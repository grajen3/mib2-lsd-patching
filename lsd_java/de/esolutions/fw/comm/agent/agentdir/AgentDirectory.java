/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.agentdir;

import java.util.HashMap;
import java.util.Map;

public class AgentDirectory {
    private Map agentMap = new HashMap();
    public static final short EPOCH_NONE;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean updateAgent(short s, short s2) {
        short s3 = this.getAgentEpoch(s);
        if (s3 > s2) {
            return false;
        }
        Map map = this.agentMap;
        synchronized (map) {
            this.agentMap.put(new Short(s), new Short(s2));
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetAgent(short s) {
        Map map = this.agentMap;
        synchronized (map) {
            this.agentMap.put(new Short(s), new Short(0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized short getAgentEpoch(short s) {
        Short s2 = null;
        Map map = this.agentMap;
        synchronized (map) {
            s2 = (Short)this.agentMap.get(new Short(s));
        }
        if (s2 == null) {
            return 0;
        }
        return s2;
    }
}

