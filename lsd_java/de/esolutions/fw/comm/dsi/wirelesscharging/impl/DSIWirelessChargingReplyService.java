/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.wirelesscharging.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.wirelesscharging.DSIWirelessChargingReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIWirelessChargingReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.wirelesscharging.DSIWirelessCharging");
    private static int dynamicHandle = 0;
    private DSIWirelessChargingReply p_DSIWirelessChargingReply;

    public DSIWirelessChargingReplyService(DSIWirelessChargingReply dSIWirelessChargingReply) {
        super(new ServiceInstanceID("a48e6ab6-c735-5b71-aa35-583b9ab06e12", DSIWirelessChargingReplyService.nextDynamicHandle(), "ed994bd0-c68b-5fe2-9542-a5fa78f087a8", "dsi.wirelesscharging.DSIWirelessCharging"));
        this.p_DSIWirelessChargingReply = dSIWirelessChargingReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIWirelessChargingReply.updateChargingInfo(n, n2);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIWirelessChargingReply.updateBatteryLevel(n, n3);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIWirelessChargingReply.asyncException(n, string, n4);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIWirelessChargingReply.yyIndication(string, string2);
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

