/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy;
import de.esolutions.fw.comm.dsi.androidauto.impl.ServiceConfigurationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.ServiceConfiguration;

class DSIAndroidAutoProxy$1
implements ISerializable {
    private final /* synthetic */ ServiceConfiguration val$config;
    private final /* synthetic */ DSIAndroidAutoProxy this$0;

    DSIAndroidAutoProxy$1(DSIAndroidAutoProxy dSIAndroidAutoProxy, ServiceConfiguration serviceConfiguration) {
        this.this$0 = dSIAndroidAutoProxy;
        this.val$config = serviceConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ServiceConfigurationSerializer.putOptionalServiceConfiguration(iSerializer, this.val$config);
    }
}

