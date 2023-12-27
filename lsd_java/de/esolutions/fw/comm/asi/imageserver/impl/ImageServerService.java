/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;
import de.esolutions.fw.comm.asi.imageserver.ImageServerS;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageServerReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ImageServerService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.imageserver.ImageServer");
    private ImageServerS p_ImageServer;

    public ImageServerService(int n, ImageServerS imageServerS) {
        super(new ServiceInstanceID("8d042df8-ec1b-43d0-a72b-371a030c1d6f", n, "6043b5ea-f526-5902-8f8e-a258f712dd76", "asi.imageserver.ImageServer"));
        this.p_ImageServer = imageServerS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ImageServerReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 13: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    byte by = iDeserializer.getInt8();
                    boolean bl = iDeserializer.getBool();
                    this.p_ImageServer.requestImage(stringArray, by, bl, (ImageServerReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_ImageServer.requestImageInformation(stringArray, (ImageServerReplyProxy)iProxyFrontend);
                    break;
                }
                case 20: {
                    this.p_ImageServer.setNotification((ImageServerReplyProxy)iProxyFrontend);
                    break;
                }
                case 22: {
                    long l = iDeserializer.getUInt32();
                    this.p_ImageServer.setNotification(l, (ImageServerReply)((ImageServerReplyProxy)iProxyFrontend));
                    break;
                }
                case 21: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ImageServer.setNotification(lArray, (ImageServerReply)((ImageServerReplyProxy)iProxyFrontend));
                    break;
                }
                case 17: {
                    this.p_ImageServer.clearNotification((ImageServerReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getUInt32();
                    this.p_ImageServer.clearNotification(l, (ImageServerReply)((ImageServerReplyProxy)iProxyFrontend));
                    break;
                }
                case 18: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ImageServer.clearNotification(lArray, (ImageServerReply)((ImageServerReplyProxy)iProxyFrontend));
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

