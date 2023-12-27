/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NetworkingServiceReplyProxy$6
implements ISerializable {
    private final /* synthetic */ String val$imei;
    private final /* synthetic */ String val$euiccid;
    private final /* synthetic */ String val$iccid;
    private final /* synthetic */ String val$imsi;
    private final /* synthetic */ NetworkingServiceReplyProxy this$0;

    NetworkingServiceReplyProxy$6(NetworkingServiceReplyProxy networkingServiceReplyProxy, String string, String string2, String string3, String string4) {
        this.this$0 = networkingServiceReplyProxy;
        this.val$imei = string;
        this.val$euiccid = string2;
        this.val$iccid = string3;
        this.val$imsi = string4;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$imei);
        iSerializer.putOptionalString(this.val$euiccid);
        iSerializer.putOptionalString(this.val$iccid);
        iSerializer.putOptionalString(this.val$imsi);
    }
}

