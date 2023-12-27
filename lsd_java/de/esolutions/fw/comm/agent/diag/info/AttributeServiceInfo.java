/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag.info;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class AttributeServiceInfo
extends AbstractInfoBase {
    public final int mapSize;
    public final String name;
    public final String instance;

    public AttributeServiceInfo(int n, int n2, String string, String string2) {
        super(n);
        this.mapSize = n2;
        this.name = string;
        this.instance = string2;
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return null;
    }

    public String toString() {
        return new StringBuffer().append("AttributeServiceInfo::mapSize=").append(this.mapSize).append(";name=").append(this.name).toString();
    }
}

