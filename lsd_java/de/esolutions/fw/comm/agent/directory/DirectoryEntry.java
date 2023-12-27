/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.core.ServiceInstanceID;

public class DirectoryEntry {
    protected final ServiceInstanceID instanceID;
    protected final short agentID;

    public DirectoryEntry(ServiceInstanceID serviceInstanceID, short s) {
        this.instanceID = serviceInstanceID;
        this.agentID = s;
    }

    public ServiceInstanceID getServiceInstanceID() {
        return this.instanceID;
    }

    public short getAgentID() {
        return this.agentID;
    }

    public boolean equals(Object object) {
        if (object instanceof DirectoryEntry) {
            DirectoryEntry directoryEntry = (DirectoryEntry)object;
            return this.instanceID.equals(directoryEntry.instanceID) && this.agentID == directoryEntry.agentID;
        }
        return false;
    }

    public int hashCode() {
        int n = 1;
        n += 17 * this.agentID;
        if (this.instanceID != null) {
            n += 61 * this.instanceID.hashCode();
        }
        return n;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.instanceID.toString()).append("@agent=").append(this.agentID).append("]").toString();
    }
}

