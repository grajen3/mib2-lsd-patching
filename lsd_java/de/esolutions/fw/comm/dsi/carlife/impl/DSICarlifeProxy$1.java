/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeProxy;
import de.esolutions.fw.comm.dsi.carlife.impl.ServiceConfigurationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.ServiceConfiguration;

class DSICarlifeProxy$1
implements ISerializable {
    private final /* synthetic */ ServiceConfiguration val$config;
    private final /* synthetic */ DSICarlifeProxy this$0;

    DSICarlifeProxy$1(DSICarlifeProxy dSICarlifeProxy, ServiceConfiguration serviceConfiguration) {
        this.this$0 = dSICarlifeProxy;
        this.val$config = serviceConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ServiceConfigurationSerializer.putOptionalServiceConfiguration(iSerializer, this.val$config);
    }
}

