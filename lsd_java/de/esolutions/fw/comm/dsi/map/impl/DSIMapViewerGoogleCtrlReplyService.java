/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerGoogleCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.LayerPropertySerializer;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerGoogleCtrlReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.map.DSIMapViewerGoogleCtrl");
    private static int dynamicHandle = 0;
    private DSIMapViewerGoogleCtrlReply p_DSIMapViewerGoogleCtrlReply;

    public DSIMapViewerGoogleCtrlReplyService(DSIMapViewerGoogleCtrlReply dSIMapViewerGoogleCtrlReply) {
        super(new ServiceInstanceID("2256d080-8740-5e79-bcc5-6ddcbbeef30e", DSIMapViewerGoogleCtrlReplyService.nextDynamicHandle(), "00946153-2f48-5ed2-bed1-4552535374eb", "dsi.map.DSIMapViewerGoogleCtrl"));
        this.p_DSIMapViewerGoogleCtrlReply = dSIMapViewerGoogleCtrlReply;
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
                case 13: {
                    LayerProperty[] layerPropertyArray = LayerPropertySerializer.getOptionalLayerPropertyVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerGoogleCtrlReply.updateAvailableLayers(layerPropertyArray, n);
                    break;
                }
                case 17: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerGoogleCtrlReply.updateVisibleLayers(nArray, n);
                    break;
                }
                case 12: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerGoogleCtrlReply.updateAvailableLanguages(stringArray, n);
                    break;
                }
                case 14: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerGoogleCtrlReply.updateCurrentLanguage(string, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMapViewerGoogleCtrlReply.updateGoogleDataStatus(n, n2);
                    break;
                }
                case 21: {
                    Rect rect = RectSerializer.getOptionalRect(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMapViewerGoogleCtrlReply.updateCopyrightPosition(rect, n, n3, n4);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMapViewerGoogleCtrlReply.asyncException(n, string, n5);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMapViewerGoogleCtrlReply.yyIndication(string, string2);
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

