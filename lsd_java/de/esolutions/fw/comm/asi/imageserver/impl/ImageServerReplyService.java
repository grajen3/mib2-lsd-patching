/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.Image;
import de.esolutions.fw.comm.asi.imageserver.ImageInfo;
import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageInfoSerializer;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ImageServerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.imageserver.ImageServer");
    private static int dynamicHandle = 0;
    private ImageServerReply p_ImageServerReply;

    public ImageServerReplyService(ImageServerReply imageServerReply) {
        super(new ServiceInstanceID("4859e928-623e-4248-8210-d55453bef3a4", ImageServerReplyService.nextDynamicHandle(), "b9a016f3-d0ec-5bf0-bc90-42549185f0a0", "asi.imageserver.ImageServer"));
        this.p_ImageServerReply = imageServerReply;
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
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    Image image = ImageSerializer.getOptionalImage(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_ImageServerReply.responseImage(string, image, n);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    ImageInfo imageInfo = ImageInfoSerializer.getOptionalImageInfo(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_ImageServerReply.responseImageInformation(string, imageInfo, n);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ImageServerReply.updateASIVersion(string, bl);
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

