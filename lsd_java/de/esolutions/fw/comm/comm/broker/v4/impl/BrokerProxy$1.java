/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.impl.BrokerProxy;
import de.esolutions.fw.comm.comm.broker.v4.impl.InstanceIDSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BrokerProxy$1
implements ISerializable {
    private final /* synthetic */ InstanceID val$agent_interface_id;
    private final /* synthetic */ BrokerProxy this$0;

    BrokerProxy$1(BrokerProxy brokerProxy, InstanceID instanceID) {
        this.this$0 = brokerProxy;
        this.val$agent_interface_id = instanceID;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        InstanceIDSerializer.putOptionalInstanceID(iSerializer, this.val$agent_interface_id);
    }
}

