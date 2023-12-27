/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.impl.BrokerProxy;
import de.esolutions.fw.comm.comm.broker.v4.impl.InstanceIDSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BrokerProxy$4
implements ISerializable {
    private final /* synthetic */ InstanceID val$svc_id;
    private final /* synthetic */ int val$caller_id;
    private final /* synthetic */ BrokerProxy this$0;

    BrokerProxy$4(BrokerProxy brokerProxy, InstanceID instanceID, int n) {
        this.this$0 = brokerProxy;
        this.val$svc_id = instanceID;
        this.val$caller_id = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        InstanceIDSerializer.putOptionalInstanceID(iSerializer, this.val$svc_id);
        iSerializer.putUInt16(this.val$caller_id);
    }
}

