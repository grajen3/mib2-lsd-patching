/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version.impl;

import de.esolutions.fw.comm.asi.sdis.version.SDISVersionReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SDISVersionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.sdis.version.SDISVersion");
    private static int dynamicHandle = 0;
    private SDISVersionReply p_SDISVersionReply;

    public SDISVersionReplyService(SDISVersionReply sDISVersionReply) {
        super(new ServiceInstanceID("af682e42-9d3b-11e3-8d05-425861b86ab6", SDISVersionReplyService.nextDynamicHandle(), "d416a5aa-8b20-525c-a84a-e810898c7325", "asi.sdis.version.SDISVersion"));
        this.p_SDISVersionReply = sDISVersionReply;
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
                case 6: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_SDISVersionReply.updateASIVersion(string, bl);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_SDISVersionReply.updateSDISInterfaceVersion(string, bl);
                    break;
                }
                case 8: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_SDISVersionReply.updateMMXSWVersion(string, bl);
                    break;
                }
                case 7: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_SDISVersionReply.updateMMXSKUVersion(string, bl);
                    break;
                }
                case 9: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_SDISVersionReply.updateMUDetailedVersion(string, bl);
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

