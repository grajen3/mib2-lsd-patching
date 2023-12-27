/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.Broker;
import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.impl.InstanceIDSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BrokerService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.comm.broker.Broker");
    private Broker p_Broker;

    public BrokerService(int n, Broker broker) {
        super(new ServiceInstanceID("8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847", n, "8935d19b-313a-5d23-bf1f-64bc869ad5a7", "comm.broker.Broker"));
        this.p_Broker = broker;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 0: {
                    InstanceID instanceID = InstanceIDSerializer.getOptionalInstanceID(iDeserializer);
                    this.p_Broker.announce(instanceID);
                    break;
                }
                case 2: {
                    InstanceID instanceID = InstanceIDSerializer.getOptionalInstanceID(iDeserializer);
                    int n = iDeserializer.getUInt16();
                    this.p_Broker.registerService(instanceID, n);
                    break;
                }
                case 3: {
                    InstanceID instanceID = InstanceIDSerializer.getOptionalInstanceID(iDeserializer);
                    int n = iDeserializer.getUInt16();
                    this.p_Broker.unregisterService(instanceID, n);
                    break;
                }
                case 1: {
                    InstanceID instanceID = InstanceIDSerializer.getOptionalInstanceID(iDeserializer);
                    int n = iDeserializer.getUInt16();
                    this.p_Broker.lookupService(instanceID, n);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

