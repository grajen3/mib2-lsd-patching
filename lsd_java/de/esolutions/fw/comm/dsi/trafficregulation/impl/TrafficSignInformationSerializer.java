/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation.impl;

import de.esolutions.fw.comm.dsi.trafficregulation.impl.SpeedLimitInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.trafficregulation.SpeedLimitInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class TrafficSignInformationSerializer {
    public static void putOptionalTrafficSignInformation(ISerializer iSerializer, TrafficSignInformation trafficSignInformation) {
        boolean bl = trafficSignInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = trafficSignInformation.getHighestPrioritySign();
            iSerializer.putInt32(n);
            int n2 = trafficSignInformation.getSecondHighestPrioritySign();
            iSerializer.putInt32(n2);
            int n3 = trafficSignInformation.getInformationText();
            iSerializer.putInt32(n3);
            int n4 = trafficSignInformation.getTrafficSignOne();
            iSerializer.putInt32(n4);
            int n5 = trafficSignInformation.getTrafficSignTwo();
            iSerializer.putInt32(n5);
            int n6 = trafficSignInformation.getTrafficSignThree();
            iSerializer.putInt32(n6);
            int n7 = trafficSignInformation.getWarningSignOne();
            iSerializer.putInt32(n7);
            int n8 = trafficSignInformation.getWarningSignTwo();
            iSerializer.putInt32(n8);
            int n9 = trafficSignInformation.getWarningSignThree();
            iSerializer.putInt32(n9);
            int n10 = trafficSignInformation.getAdditionalSignOne();
            iSerializer.putInt32(n10);
            int n11 = trafficSignInformation.getAdditionalSignTwo();
            iSerializer.putInt32(n11);
            int n12 = trafficSignInformation.getAdditionalSignThree();
            iSerializer.putInt32(n12);
            int n13 = trafficSignInformation.getVariant();
            iSerializer.putInt32(n13);
            SpeedLimitInfo speedLimitInfo = trafficSignInformation.getHighestPrioritySpeedLimit();
            SpeedLimitInfoSerializer.putOptionalSpeedLimitInfo(iSerializer, speedLimitInfo);
            int n14 = trafficSignInformation.getTrafficSignOneSource();
            iSerializer.putInt32(n14);
            int n15 = trafficSignInformation.getTrafficSignTwoSource();
            iSerializer.putInt32(n15);
            int n16 = trafficSignInformation.getTrafficSignThreeSource();
            iSerializer.putInt32(n16);
        }
    }

    public static void putOptionalTrafficSignInformationVarArray(ISerializer iSerializer, TrafficSignInformation[] trafficSignInformationArray) {
        boolean bl = trafficSignInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficSignInformationArray.length);
            for (int i2 = 0; i2 < trafficSignInformationArray.length; ++i2) {
                TrafficSignInformationSerializer.putOptionalTrafficSignInformation(iSerializer, trafficSignInformationArray[i2]);
            }
        }
    }

    public static TrafficSignInformation getOptionalTrafficSignInformation(IDeserializer iDeserializer) {
        TrafficSignInformation trafficSignInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            SpeedLimitInfo speedLimitInfo;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            trafficSignInformation = new TrafficSignInformation();
            trafficSignInformation.highestPrioritySign = n16 = iDeserializer.getInt32();
            trafficSignInformation.secondHighestPrioritySign = n15 = iDeserializer.getInt32();
            trafficSignInformation.informationText = n14 = iDeserializer.getInt32();
            trafficSignInformation.trafficSignOne = n13 = iDeserializer.getInt32();
            trafficSignInformation.trafficSignTwo = n12 = iDeserializer.getInt32();
            trafficSignInformation.trafficSignThree = n11 = iDeserializer.getInt32();
            trafficSignInformation.warningSignOne = n10 = iDeserializer.getInt32();
            trafficSignInformation.warningSignTwo = n9 = iDeserializer.getInt32();
            trafficSignInformation.warningSignThree = n8 = iDeserializer.getInt32();
            trafficSignInformation.additionalSignOne = n7 = iDeserializer.getInt32();
            trafficSignInformation.additionalSignTwo = n6 = iDeserializer.getInt32();
            trafficSignInformation.additionalSignThree = n5 = iDeserializer.getInt32();
            trafficSignInformation.variant = n4 = iDeserializer.getInt32();
            trafficSignInformation.highestPrioritySpeedLimit = speedLimitInfo = SpeedLimitInfoSerializer.getOptionalSpeedLimitInfo(iDeserializer);
            trafficSignInformation.trafficSignOneSource = n3 = iDeserializer.getInt32();
            trafficSignInformation.trafficSignTwoSource = n2 = iDeserializer.getInt32();
            trafficSignInformation.trafficSignThreeSource = n = iDeserializer.getInt32();
        }
        return trafficSignInformation;
    }

    public static TrafficSignInformation[] getOptionalTrafficSignInformationVarArray(IDeserializer iDeserializer) {
        TrafficSignInformation[] trafficSignInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficSignInformationArray = new TrafficSignInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficSignInformationArray[i2] = TrafficSignInformationSerializer.getOptionalTrafficSignInformation(iDeserializer);
            }
        }
        return trafficSignInformationArray;
    }
}

