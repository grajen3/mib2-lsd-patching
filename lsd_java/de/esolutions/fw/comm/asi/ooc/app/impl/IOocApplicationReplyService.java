/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IOocApplicationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.ooc.app.IOocApplication");
    private static int dynamicHandle = 0;
    private IOocApplicationReply p_IOocApplicationReply;

    public IOocApplicationReplyService(IOocApplicationReply iOocApplicationReply) {
        super(new ServiceInstanceID("41a9d241-c39d-4427-aafb-b8d8cb9db3a5", IOocApplicationReplyService.nextDynamicHandle(), "60a20cee-c632-5bc3-8a99-ef22ee11b8a8", "asi.ooc.app.IOocApplication"));
        this.p_IOocApplicationReply = iOocApplicationReply;
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
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_IOocApplicationReply.updatePowerState(l);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getEnum();
                    this.p_IOocApplicationReply.updateShutdownRequest(n);
                    break;
                }
                case 4: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    boolean bl4 = iDeserializer.getBool();
                    this.p_IOocApplicationReply.updateClampSignal(bl, bl2, bl3, bl4);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getEnum();
                    this.p_IOocApplicationReply.updateVoltageLevel(n);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getEnum();
                    this.p_IOocApplicationReply.updateRunMode(n);
                    break;
                }
                case 12: {
                    boolean bl = iDeserializer.getBool();
                    this.p_IOocApplicationReply.updateCarLockSignal(bl);
                    break;
                }
                case 13: {
                    boolean bl = iDeserializer.getBool();
                    this.p_IOocApplicationReply.updatePowerOnPinStatus(bl);
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

