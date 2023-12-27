/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag.info;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ServiceLocatorInfo
extends AbstractInfoBase {
    public final ServiceInstanceID svcID;
    public final int svcAgent;

    public ServiceLocatorInfo(int n, DirectoryEntry directoryEntry) {
        super(n);
        this.svcID = directoryEntry.getServiceInstanceID();
        this.svcAgent = directoryEntry.getAgentID();
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return this.svcID;
    }
}

