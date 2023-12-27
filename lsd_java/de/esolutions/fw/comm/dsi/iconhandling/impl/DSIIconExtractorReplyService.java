/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.iconhandling.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.iconhandling.DSIIconExtractorReply;
import de.esolutions.fw.comm.dsi.iconhandling.impl.TextRenderingInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class DSIIconExtractorReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.iconhandling.DSIIconExtractor");
    private static int dynamicHandle = 0;
    private DSIIconExtractorReply p_DSIIconExtractorReply;

    public DSIIconExtractorReplyService(DSIIconExtractorReply dSIIconExtractorReply) {
        super(new ServiceInstanceID("cd212167-6def-5492-89f4-3fedb1cba37a", DSIIconExtractorReplyService.nextDynamicHandle(), "8f98c5a2-05bd-5f72-8f61-3f1d310579e0", "dsi.iconhandling.DSIIconExtractor"));
        this.p_DSIIconExtractorReply = dSIIconExtractorReply;
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
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIIconExtractorReply.iconResult(n);
                    break;
                }
                case 34: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForTMCEventIcon(resourceLocator);
                    break;
                }
                case 30: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForPOIIcon(resourceLocator);
                    break;
                }
                case 24: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    TextRenderingInfo textRenderingInfo = TextRenderingInfoSerializer.getOptionalTextRenderingInfo(iDeserializer);
                    this.p_DSIIconExtractorReply.renderingInformationForRoadIcon(resourceLocator, textRenderingInfo);
                    break;
                }
                case 36: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForTargetIcon(resourceLocator);
                    break;
                }
                case 32: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForRoadClassIcon(resourceLocator);
                    break;
                }
                case 38: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForTrafficRegulationIcon(resourceLocator);
                    break;
                }
                case 26: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForAdditionalIcon(resourceLocator);
                    break;
                }
                case 20: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    TextRenderingInfo textRenderingInfo = TextRenderingInfoSerializer.getOptionalTextRenderingInfo(iDeserializer);
                    this.p_DSIIconExtractorReply.renderingInformationForExitIcon(resourceLocator, textRenderingInfo);
                    break;
                }
                case 28: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForCountryIcon(resourceLocator);
                    break;
                }
                case 39: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForTrafficRegulationIconWithSubIndex(resourceLocator);
                    break;
                }
                case 22: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    TextRenderingInfo textRenderingInfo = TextRenderingInfoSerializer.getOptionalTextRenderingInfo(iDeserializer);
                    this.p_DSIIconExtractorReply.renderingInformationForExitIconWithVariant(resourceLocator, textRenderingInfo);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIIconExtractorReply.setBrandIconStyleResult(n);
                    break;
                }
                case 61: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForTrafficSourceIconResult(resourceLocator);
                    break;
                }
                case 55: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForAreaWarningIconResult(resourceLocator);
                    break;
                }
                case 53: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForAdditionalTurnListIconResult(resourceLocator);
                    break;
                }
                case 57: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForComposedPOIIconResult(resourceLocator);
                    break;
                }
                case 59: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIIconExtractorReply.resourceIdForPOIIconFromRawDataResult(resourceLocator);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIIconExtractorReply.asyncException(n, string, n2);
                    break;
                }
                case 50: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIIconExtractorReply.yyIndication(string, string2);
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

