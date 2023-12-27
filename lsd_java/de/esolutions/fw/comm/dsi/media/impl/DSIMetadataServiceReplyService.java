/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.media.DSIMetadataServiceReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSIMetadataServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.media.DSIMetadataService");
    private static int dynamicHandle = 0;
    private DSIMetadataServiceReply p_DSIMetadataServiceReply;

    public DSIMetadataServiceReplyService(DSIMetadataServiceReply dSIMetadataServiceReply) {
        super(new ServiceInstanceID("f6b540c6-1df4-506e-b46d-38dea7ff77d9", DSIMetadataServiceReplyService.nextDynamicHandle(), "167d2975-e7a8-5eb9-b571-06f8ba0a537d", "dsi.media.DSIMetadataService"));
        this.p_DSIMetadataServiceReply = dSIMetadataServiceReply;
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
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMetadataServiceReply.updateOnlineLookupStatus(n, n2);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIMetadataServiceReply.responseCoverArt(n, resourceLocator);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMetadataServiceReply.asyncException(n, string, n3);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMetadataServiceReply.yyIndication(string, string2);
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

