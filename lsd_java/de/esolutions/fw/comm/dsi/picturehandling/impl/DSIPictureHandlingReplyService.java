/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturehandling.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturehandling.DSIPictureHandlingReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSIPictureHandlingReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.picturehandling.DSIPictureHandling");
    private static int dynamicHandle = 0;
    private DSIPictureHandlingReply p_DSIPictureHandlingReply;

    public DSIPictureHandlingReplyService(DSIPictureHandlingReply dSIPictureHandlingReply) {
        super(new ServiceInstanceID("e7c2f9f0-c6df-58d5-8f32-a9625e4c6cd8", DSIPictureHandlingReplyService.nextDynamicHandle(), "1cd88207-dc63-5080-847c-7abf796ccece", "dsi.picturehandling.DSIPictureHandling"));
        this.p_DSIPictureHandlingReply = dSIPictureHandlingReply;
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
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    ResourceLocator resourceLocator2 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIPictureHandlingReply.indicatePicture(n, n2, resourceLocator, resourceLocator2);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureHandlingReply.finishPictureRequest(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPictureHandlingReply.asyncException(n, string, n3);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPictureHandlingReply.yyIndication(string, string2);
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

