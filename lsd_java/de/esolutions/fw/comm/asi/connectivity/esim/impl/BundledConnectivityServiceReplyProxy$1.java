/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.esim.impl;

import de.esolutions.fw.comm.asi.connectivity.esim.impl.BundledConnectivityServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BundledConnectivityServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$type;
    private final /* synthetic */ BundledConnectivityServiceReplyProxy this$0;

    BundledConnectivityServiceReplyProxy$1(BundledConnectivityServiceReplyProxy bundledConnectivityServiceReplyProxy, int n) {
        this.this$0 = bundledConnectivityServiceReplyProxy;
        this.val$type = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$type);
    }
}

