/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerStreetViewCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.PosInfoSerializer;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.comm.dsi.map.impl.StreetViewThumbnailSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public class DSIMapViewerStreetViewCtrlReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.map.DSIMapViewerStreetViewCtrl");
    private static int dynamicHandle = 0;
    private DSIMapViewerStreetViewCtrlReply p_DSIMapViewerStreetViewCtrlReply;

    public DSIMapViewerStreetViewCtrlReplyService(DSIMapViewerStreetViewCtrlReply dSIMapViewerStreetViewCtrlReply) {
        super(new ServiceInstanceID("4c3800c3-44b1-546a-8e1a-10175e766248", DSIMapViewerStreetViewCtrlReplyService.nextDynamicHandle(), "d48f38d9-e846-5a2d-9a56-a69068d291b5", "dsi.map.DSIMapViewerStreetViewCtrl"));
        this.p_DSIMapViewerStreetViewCtrlReply = dSIMapViewerStreetViewCtrlReply;
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
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateStreetViewLoadStatus(n, n2);
                    break;
                }
                case 35: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateStreetViewAvailable(bl, n);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateStreetViewZoomListIndex(n, n3);
                    break;
                }
                case 38: {
                    float[] fArray = iDeserializer.getOptionalFloatVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateStreetViewZoomList(fArray, n);
                    break;
                }
                case 37: {
                    StreetViewThumbnail[] streetViewThumbnailArray = StreetViewThumbnailSerializer.getOptionalStreetViewThumbnailVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateStreetViewThumbnails(streetViewThumbnailArray, n);
                    break;
                }
                case 24: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMapViewerStreetViewCtrlReply.streetViewEnabled(bl);
                    break;
                }
                case 29: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMapViewerStreetViewCtrlReply.streetViewVisible(bl);
                    break;
                }
                case 26: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMapViewerStreetViewCtrlReply.streetViewFreeze(bl);
                    break;
                }
                case 32: {
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updatePosition(navLocationWgs84, n);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateRotation(n, n4, n5);
                    break;
                }
                case 4: {
                    PosInfo[] posInfoArray = PosInfoSerializer.getOptionalPosInfoVarArray(iDeserializer);
                    this.p_DSIMapViewerStreetViewCtrlReply.getInfoForPosition(posInfoArray);
                    break;
                }
                case 21: {
                    StreetViewThumbnail streetViewThumbnail = StreetViewThumbnailSerializer.getOptionalStreetViewThumbnail(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.snapshotResult(streetViewThumbnail, n);
                    break;
                }
                case 45: {
                    Rect rect = RectSerializer.getOptionalRect(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateScreenViewPort(rect, n);
                    break;
                }
                case 47: {
                    float f2 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateStreetViewZoomLevel(f2, n);
                    break;
                }
                case 48: {
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.updateStreetViewPosition(navLocationWgs84, bl, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMapViewerStreetViewCtrlReply.asyncException(n, string, n6);
                    break;
                }
                case 40: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMapViewerStreetViewCtrlReply.yyIndication(string, string2);
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

