/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.comm.dsi.androidauto2.impl.DSIAndroidAuto2Proxy;
import de.esolutions.fw.comm.dsi.androidauto2.impl.ServiceConfigurationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto2.ServiceConfiguration;

class DSIAndroidAuto2Proxy$1
implements ISerializable {
    private final /* synthetic */ ServiceConfiguration val$config;
    private final /* synthetic */ DSIAndroidAuto2Proxy this$0;

    DSIAndroidAuto2Proxy$1(DSIAndroidAuto2Proxy dSIAndroidAuto2Proxy, ServiceConfiguration serviceConfiguration) {
        this.this$0 = dSIAndroidAuto2Proxy;
        this.val$config = serviceConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ServiceConfigurationSerializer.putOptionalServiceConfiguration(iSerializer, this.val$config);
    }
}

