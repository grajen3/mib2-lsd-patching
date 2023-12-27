/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.ddp20.DSIDDP20Reply;
import de.esolutions.fw.comm.dsi.ddp20.impl.DisplayStatusSerializer;
import de.esolutions.fw.comm.dsi.ddp20.impl.VersionInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;

public class DSIDDP20ReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.ddp20.DSIDDP20");
    private static int dynamicHandle = 0;
    private DSIDDP20Reply p_DSIDDP20Reply;

    public DSIDDP20ReplyService(DSIDDP20Reply dSIDDP20Reply) {
        super(new ServiceInstanceID("2c995119-3a7d-5d8d-844d-975971b37be6", DSIDDP20ReplyService.nextDynamicHandle(), "0f83905d-671b-59bb-bbce-64775a0d8abf", "dsi.ddp20.DSIDDP20"));
        this.p_DSIDDP20Reply = dSIDDP20Reply;
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
                case 29: {
                    VersionInfo versionInfo = VersionInfoSerializer.getOptionalVersionInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDDP20Reply.updateVersionInfo(versionInfo, n);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIDDP20Reply.updatePowerStatus(n, n2);
                    break;
                }
                case 27: {
                    DisplayStatus displayStatus = DisplayStatusSerializer.getOptionalDisplayStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDDP20Reply.updateDisplayStatus(displayStatus, n);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIDDP20Reply.updateBufferStatus(n, n3);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIDDP20Reply.asyncException(n, string, n4);
                    break;
                }
                case 30: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDDP20Reply.yyIndication(string, string2);
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

