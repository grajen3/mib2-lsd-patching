/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor;

import de.esolutions.fw.comm.agent.IAgentDiagnosis;
import de.esolutions.fw.comm.agent.IAgentSnapshot;
import java.util.HashMap;

public class DoctorShellState {
    private HashMap map = new HashMap();
    private IAgentSnapshot snapshot;

    public void setKey(String string, Object object) {
        this.map.put(string, object);
    }

    public Object getKey(String string) {
        return this.map.get(string);
    }

    public IAgentSnapshot getSnapshot() {
        return this.snapshot;
    }

    public void setSnapshot(IAgentSnapshot iAgentSnapshot) {
        this.snapshot = iAgentSnapshot;
    }

    public IAgentSnapshot ensureSnapshot(IAgentDiagnosis iAgentDiagnosis) {
        if (this.snapshot == null) {
            this.snapshot = iAgentDiagnosis.createSnapshot();
        }
        return this.snapshot;
    }
}

