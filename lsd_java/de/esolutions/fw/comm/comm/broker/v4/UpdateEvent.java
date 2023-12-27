/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;

public class UpdateEvent {
    public int action;
    public int reason;
    public InstanceID svc_id;
    public int home_agent_id;

    public int getAction() {
        return this.action;
    }

    public void setAction(int n) {
        this.action = n;
    }

    public int getReason() {
        return this.reason;
    }

    public void setReason(int n) {
        this.reason = n;
    }

    public InstanceID getSvc_id() {
        return this.svc_id;
    }

    public void setSvc_id(InstanceID instanceID) {
        this.svc_id = instanceID;
    }

    public int getHome_agent_id() {
        return this.home_agent_id;
    }

    public void setHome_agent_id(int n) {
        this.home_agent_id = n;
    }

    public UpdateEvent() {
        this.svc_id = null;
    }

    public UpdateEvent(int n, int n2, InstanceID instanceID, int n3) {
        this.action = n;
        this.reason = n2;
        this.svc_id = instanceID;
        this.home_agent_id = n3;
    }

    public String toString() {
        return new StringBuffer("UpdateEvent{").append("action=").append(this.action).append(", reason=").append(this.reason).append(", svc_id=").append(this.svc_id).append(", home_agent_id=").append(this.home_agent_id).append("}").toString();
    }
}

