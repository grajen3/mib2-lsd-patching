/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanDevice;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanDeviceSerializer;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class WlanServiceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ WlanDevice val$device;
    private final /* synthetic */ WlanServiceReplyProxy this$0;

    WlanServiceReplyProxy$2(WlanServiceReplyProxy wlanServiceReplyProxy, WlanDevice wlanDevice) {
        this.this$0 = wlanServiceReplyProxy;
        this.val$device = wlanDevice;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        WlanDeviceSerializer.putOptionalWlanDevice(iSerializer, this.val$device);
    }
}

