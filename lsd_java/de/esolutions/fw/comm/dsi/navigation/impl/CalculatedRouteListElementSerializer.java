/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class CalculatedRouteListElementSerializer {
    public static void putOptionalCalculatedRouteListElement(ISerializer iSerializer, CalculatedRouteListElement calculatedRouteListElement) {
        boolean bl = calculatedRouteListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = calculatedRouteListElement.getDistance();
            iSerializer.putInt64(l);
            long l2 = calculatedRouteListElement.getEta();
            iSerializer.putInt64(l2);
            long l3 = calculatedRouteListElement.getEtaWithSpeedAndFlow();
            iSerializer.putInt64(l3);
            long l4 = calculatedRouteListElement.getEcologicalFactor();
            iSerializer.putInt64(l4);
            long l5 = calculatedRouteListElement.getMotorwayLength();
            iSerializer.putInt64(l5);
            long l6 = calculatedRouteListElement.getTollLength();
            iSerializer.putInt64(l6);
            long l7 = calculatedRouteListElement.getTollCostAmount();
            iSerializer.putInt64(l7);
            int n = calculatedRouteListElement.getTollCostCurrency();
            iSerializer.putInt32(n);
            boolean bl2 = calculatedRouteListElement.isHasTunnel();
            iSerializer.putBool(bl2);
            boolean bl3 = calculatedRouteListElement.isHasFerry();
            iSerializer.putBool(bl3);
            boolean bl4 = calculatedRouteListElement.isIsTimeRestricted();
            iSerializer.putBool(bl4);
            boolean bl5 = calculatedRouteListElement.isHasCarTrain();
            iSerializer.putBool(bl5);
            boolean bl6 = calculatedRouteListElement.isIsSeasonalRestricted();
            iSerializer.putBool(bl6);
            boolean bl7 = calculatedRouteListElement.isNeedsVignette();
            iSerializer.putBool(bl7);
            NavSegmentID navSegmentID = calculatedRouteListElement.getSegmentIDList();
            NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentID);
            int n2 = calculatedRouteListElement.getCalculationState();
            iSerializer.putInt32(n2);
            int n3 = calculatedRouteListElement.getCalculationPercentage();
            iSerializer.putInt32(n3);
            int n4 = calculatedRouteListElement.getNumberOfTmcMessages();
            iSerializer.putInt32(n4);
            int n5 = calculatedRouteListElement.getEtaWithSpeedAndFlowStatus();
            iSerializer.putInt32(n5);
            int[] nArray = calculatedRouteListElement.getAdditionalRouteDataKeys();
            iSerializer.putOptionalInt32VarArray(nArray);
            String[] stringArray = calculatedRouteListElement.getAdditionalRouteDataValues();
            iSerializer.putOptionalStringVarArray(stringArray);
            boolean bl8 = calculatedRouteListElement.isHasHovLane();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalCalculatedRouteListElementVarArray(ISerializer iSerializer, CalculatedRouteListElement[] calculatedRouteListElementArray) {
        boolean bl = calculatedRouteListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(calculatedRouteListElementArray.length);
            for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                CalculatedRouteListElementSerializer.putOptionalCalculatedRouteListElement(iSerializer, calculatedRouteListElementArray[i2]);
            }
        }
    }

    public static CalculatedRouteListElement getOptionalCalculatedRouteListElement(IDeserializer iDeserializer) {
        CalculatedRouteListElement calculatedRouteListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            int n2;
            int n3;
            int n4;
            NavSegmentID navSegmentID;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            int n5;
            long l;
            long l2;
            long l3;
            long l4;
            long l5;
            long l6;
            long l7;
            calculatedRouteListElement = new CalculatedRouteListElement();
            calculatedRouteListElement.distance = l7 = iDeserializer.getInt64();
            calculatedRouteListElement.eta = l6 = iDeserializer.getInt64();
            calculatedRouteListElement.etaWithSpeedAndFlow = l5 = iDeserializer.getInt64();
            calculatedRouteListElement.ecologicalFactor = l4 = iDeserializer.getInt64();
            calculatedRouteListElement.motorwayLength = l3 = iDeserializer.getInt64();
            calculatedRouteListElement.tollLength = l2 = iDeserializer.getInt64();
            calculatedRouteListElement.tollCostAmount = l = iDeserializer.getInt64();
            calculatedRouteListElement.tollCostCurrency = n5 = iDeserializer.getInt32();
            calculatedRouteListElement.hasTunnel = bl8 = iDeserializer.getBool();
            calculatedRouteListElement.hasFerry = bl7 = iDeserializer.getBool();
            calculatedRouteListElement.isTimeRestricted = bl6 = iDeserializer.getBool();
            calculatedRouteListElement.hasCarTrain = bl5 = iDeserializer.getBool();
            calculatedRouteListElement.isSeasonalRestricted = bl4 = iDeserializer.getBool();
            calculatedRouteListElement.needsVignette = bl3 = iDeserializer.getBool();
            calculatedRouteListElement.segmentIDList = navSegmentID = NavSegmentIDSerializer.getOptionalNavSegmentID(iDeserializer);
            calculatedRouteListElement.calculationState = n4 = iDeserializer.getInt32();
            calculatedRouteListElement.calculationPercentage = n3 = iDeserializer.getInt32();
            calculatedRouteListElement.numberOfTmcMessages = n2 = iDeserializer.getInt32();
            calculatedRouteListElement.etaWithSpeedAndFlowStatus = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            calculatedRouteListElement.additionalRouteDataKeys = nArray;
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            calculatedRouteListElement.additionalRouteDataValues = stringArray;
            calculatedRouteListElement.hasHovLane = bl2 = iDeserializer.getBool();
        }
        return calculatedRouteListElement;
    }

    public static CalculatedRouteListElement[] getOptionalCalculatedRouteListElementVarArray(IDeserializer iDeserializer) {
        CalculatedRouteListElement[] calculatedRouteListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            calculatedRouteListElementArray = new CalculatedRouteListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                calculatedRouteListElementArray[i2] = CalculatedRouteListElementSerializer.getOptionalCalculatedRouteListElement(iDeserializer);
            }
        }
        return calculatedRouteListElementArray;
    }
}

