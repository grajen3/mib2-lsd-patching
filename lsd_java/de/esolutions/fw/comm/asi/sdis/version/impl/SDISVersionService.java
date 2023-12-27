/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version.impl;

import de.esolutions.fw.comm.asi.sdis.version.SDISVersionReply;
import de.esolutions.fw.comm.asi.sdis.version.SDISVersionS;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SDISVersionService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.sdis.version.SDISVersion");
    private SDISVersionS p_SDISVersion;

    public SDISVersionService(int n, SDISVersionS sDISVersionS) {
        super(new ServiceInstanceID("9f423a8a-9d3b-11e3-8d05-425861b86ab6", n, "e18d49e8-df08-5653-82f0-9f73b0153623", "asi.sdis.version.SDISVersion"));
        this.p_SDISVersion = sDISVersionS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new SDISVersionReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 3: {
                    this.p_SDISVersion.setNotification((SDISVersionReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_SDISVersion.setNotification(l, (SDISVersionReply)((SDISVersionReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_SDISVersion.setNotification(lArray, (SDISVersionReply)((SDISVersionReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_SDISVersion.clearNotification((SDISVersionReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_SDISVersion.clearNotification(l, (SDISVersionReply)((SDISVersionReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_SDISVersion.clearNotification(lArray, (SDISVersionReply)((SDISVersionReplyProxy)iProxyFrontend));
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

