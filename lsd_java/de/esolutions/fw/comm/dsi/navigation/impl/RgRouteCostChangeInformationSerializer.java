/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.CalculatedRouteListElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSectionInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RouteSectionInfo;

public class RgRouteCostChangeInformationSerializer {
    public static void putOptionalRgRouteCostChangeInformation(ISerializer iSerializer, RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        boolean bl = rgRouteCostChangeInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CalculatedRouteListElement calculatedRouteListElement = rgRouteCostChangeInformation.getOldRoute();
            CalculatedRouteListElementSerializer.putOptionalCalculatedRouteListElement(iSerializer, calculatedRouteListElement);
            CalculatedRouteListElement calculatedRouteListElement2 = rgRouteCostChangeInformation.getNewRoute();
            CalculatedRouteListElementSerializer.putOptionalCalculatedRouteListElement(iSerializer, calculatedRouteListElement2);
            boolean bl2 = rgRouteCostChangeInformation.isNewRouteRecommended();
            iSerializer.putBool(bl2);
            int n = rgRouteCostChangeInformation.getTmcMsgId();
            iSerializer.putInt32(n);
            int[] nArray = rgRouteCostChangeInformation.getTmcMsgIds();
            iSerializer.putOptionalInt32VarArray(nArray);
            NavRectangle navRectangle = rgRouteCostChangeInformation.getBoundingRectangle();
            NavRectangleSerializer.putOptionalNavRectangle(iSerializer, navRectangle);
            RouteSectionInfo[] routeSectionInfoArray = rgRouteCostChangeInformation.getDetours();
            RouteSectionInfoSerializer.putOptionalRouteSectionInfoVarArray(iSerializer, routeSectionInfoArray);
        }
    }

    public static void putOptionalRgRouteCostChangeInformationVarArray(ISerializer iSerializer, RgRouteCostChangeInformation[] rgRouteCostChangeInformationArray) {
        boolean bl = rgRouteCostChangeInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rgRouteCostChangeInformationArray.length);
            for (int i2 = 0; i2 < rgRouteCostChangeInformationArray.length; ++i2) {
                RgRouteCostChangeInformationSerializer.putOptionalRgRouteCostChangeInformation(iSerializer, rgRouteCostChangeInformationArray[i2]);
            }
        }
    }

    public static RgRouteCostChangeInformation getOptionalRgRouteCostChangeInformation(IDeserializer iDeserializer) {
        RgRouteCostChangeInformation rgRouteCostChangeInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            NavRectangle navRectangle;
            int n;
            boolean bl2;
            CalculatedRouteListElement calculatedRouteListElement;
            CalculatedRouteListElement calculatedRouteListElement2;
            rgRouteCostChangeInformation = new RgRouteCostChangeInformation();
            rgRouteCostChangeInformation.oldRoute = calculatedRouteListElement2 = CalculatedRouteListElementSerializer.getOptionalCalculatedRouteListElement(iDeserializer);
            rgRouteCostChangeInformation.newRoute = calculatedRouteListElement = CalculatedRouteListElementSerializer.getOptionalCalculatedRouteListElement(iDeserializer);
            rgRouteCostChangeInformation.newRouteRecommended = bl2 = iDeserializer.getBool();
            rgRouteCostChangeInformation.tmcMsgId = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            rgRouteCostChangeInformation.tmcMsgIds = nArray;
            rgRouteCostChangeInformation.boundingRectangle = navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
            RouteSectionInfo[] routeSectionInfoArray = RouteSectionInfoSerializer.getOptionalRouteSectionInfoVarArray(iDeserializer);
            rgRouteCostChangeInformation.detours = routeSectionInfoArray;
        }
        return rgRouteCostChangeInformation;
    }

    public static RgRouteCostChangeInformation[] getOptionalRgRouteCostChangeInformationVarArray(IDeserializer iDeserializer) {
        RgRouteCostChangeInformation[] rgRouteCostChangeInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rgRouteCostChangeInformationArray = new RgRouteCostChangeInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rgRouteCostChangeInformationArray[i2] = RgRouteCostChangeInformationSerializer.getOptionalRgRouteCostChangeInformation(iDeserializer);
            }
        }
        return rgRouteCostChangeInformationArray;
    }
}

