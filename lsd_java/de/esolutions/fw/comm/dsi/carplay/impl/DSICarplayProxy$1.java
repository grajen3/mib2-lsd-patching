/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy;
import de.esolutions.fw.comm.dsi.carplay.impl.ServiceConfigurationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.ServiceConfiguration;

class DSICarplayProxy$1
implements ISerializable {
    private final /* synthetic */ ServiceConfiguration val$config;
    private final /* synthetic */ DSICarplayProxy this$0;

    DSICarplayProxy$1(DSICarplayProxy dSICarplayProxy, ServiceConfiguration serviceConfiguration) {
        this.this$0 = dSICarplayProxy;
        this.val$config = serviceConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ServiceConfigurationSerializer.putOptionalServiceConfiguration(iSerializer, this.val$config);
    }
}

