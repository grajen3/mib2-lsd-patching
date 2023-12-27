/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureViewerReply;
import de.esolutions.fw.comm.dsi.picturestore.impl.PictureEntryInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public class DSIPictureViewerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.picturestore.DSIPictureViewer");
    private static int dynamicHandle = 0;
    private DSIPictureViewerReply p_DSIPictureViewerReply;

    public DSIPictureViewerReplyService(DSIPictureViewerReply dSIPictureViewerReply) {
        super(new ServiceInstanceID("b0372b7e-61ec-51fc-95c5-9262597c39d8", DSIPictureViewerReplyService.nextDynamicHandle(), "eb80de47-8f4f-5dfa-adf6-4f2ff55d4a1b", "dsi.picturestore.DSIPictureViewer"));
        this.p_DSIPictureViewerReply = dSIPictureViewerReply;
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
                case 49: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.updateViewerState(n, n2);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.updateScrollMode(n, n3);
                    break;
                }
                case 45: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.updateListPosition(l, n, n4);
                    break;
                }
                case 46: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.updateNumEntries(l, n);
                    break;
                }
                case 47: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.updateNumSelectedEntries(l, n);
                    break;
                }
                case 42: {
                    long l = iDeserializer.getInt64();
                    PictureEntryInfo pictureEntryInfo = PictureEntryInfoSerializer.getOptionalPictureEntryInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.getPictureInfoResult(l, pictureEntryInfo, n);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.selectionResult(n);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.createFilterSetResult(n, n5);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.deleteFilterSetResult(n, n6);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.changedFilterSetResult(n, n7);
                    break;
                }
                case 41: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.getAvailableYearsResult(nArray, n);
                    break;
                }
                case 40: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.getAvailableMonthsResult(nArray, n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.listForContextWithFilterResult(n, resourceLocatorArray, n8, n9);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.deletePicturesWithFilterSetResult(n, n10);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIPictureViewerReply.asyncException(n, string, n11);
                    break;
                }
                case 50: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPictureViewerReply.yyIndication(string, string2);
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

