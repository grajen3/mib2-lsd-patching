/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficLightInfoReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.CarBCSpeed;

public class DSIOnlineTrafficLightInfoReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOnlineTrafficLightInfo");
    private static int dynamicHandle = 0;
    private DSIOnlineTrafficLightInfoReply p_DSIOnlineTrafficLightInfoReply;

    public DSIOnlineTrafficLightInfoReplyService(DSIOnlineTrafficLightInfoReply dSIOnlineTrafficLightInfoReply) {
        super(new ServiceInstanceID("76677848-df67-51c7-98b1-d171f27e1ac0", DSIOnlineTrafficLightInfoReplyService.nextDynamicHandle(), "64db6ab0-bf8b-5a8f-bb09-913331a079bb", "dsi.online.DSIOnlineTrafficLightInfo"));
        this.p_DSIOnlineTrafficLightInfoReply = dSIOnlineTrafficLightInfoReply;
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
                case 7: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficLightInfoReply.updateTrafficLightInfo(n, n2, nArray, n3, n4, n5);
                    break;
                }
                case 8: {
                    CarBCSpeed carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficLightInfoReply.updateTrafficLightSpeed(carBCSpeed, n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficLightInfoReply.updateTrafficLightTime(n, n6, n7);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIOnlineTrafficLightInfoReply.asyncException(n, string, n8);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineTrafficLightInfoReply.yyIndication(string, string2);
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

