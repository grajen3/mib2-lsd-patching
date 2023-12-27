/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlTransmittableElements;

public class BatteryControlTransmittableElementsSerializer {
    public static void putOptionalBatteryControlTransmittableElements(ISerializer iSerializer, BatteryControlTransmittableElements batteryControlTransmittableElements) {
        boolean bl = batteryControlTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlTransmittableElements.getRa0();
            iSerializer.putInt32(n);
            int n2 = batteryControlTransmittableElements.getRa1();
            iSerializer.putInt32(n2);
            int n3 = batteryControlTransmittableElements.getRa2();
            iSerializer.putInt32(n3);
            int n4 = batteryControlTransmittableElements.getRa3();
            iSerializer.putInt32(n4);
            int n5 = batteryControlTransmittableElements.getRa4();
            iSerializer.putInt32(n5);
            int n6 = batteryControlTransmittableElements.getRa5();
            iSerializer.putInt32(n6);
            int n7 = batteryControlTransmittableElements.getRa6();
            iSerializer.putInt32(n7);
            int n8 = batteryControlTransmittableElements.getRa7();
            iSerializer.putInt32(n8);
            int n9 = batteryControlTransmittableElements.getRa8();
            iSerializer.putInt32(n9);
            int n10 = batteryControlTransmittableElements.getRa9();
            iSerializer.putInt32(n10);
            int n11 = batteryControlTransmittableElements.getRaA();
            iSerializer.putInt32(n11);
            int n12 = batteryControlTransmittableElements.getRaB();
            iSerializer.putInt32(n12);
            int n13 = batteryControlTransmittableElements.getRaC();
            iSerializer.putInt32(n13);
            int n14 = batteryControlTransmittableElements.getRaD();
            iSerializer.putInt32(n14);
            int n15 = batteryControlTransmittableElements.getRaE();
            iSerializer.putInt32(n15);
            int n16 = batteryControlTransmittableElements.getRaF();
            iSerializer.putInt32(n16);
        }
    }

    public static void putOptionalBatteryControlTransmittableElementsVarArray(ISerializer iSerializer, BatteryControlTransmittableElements[] batteryControlTransmittableElementsArray) {
        boolean bl = batteryControlTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlTransmittableElementsArray.length);
            for (int i2 = 0; i2 < batteryControlTransmittableElementsArray.length; ++i2) {
                BatteryControlTransmittableElementsSerializer.putOptionalBatteryControlTransmittableElements(iSerializer, batteryControlTransmittableElementsArray[i2]);
            }
        }
    }

    public static BatteryControlTransmittableElements getOptionalBatteryControlTransmittableElements(IDeserializer iDeserializer) {
        BatteryControlTransmittableElements batteryControlTransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
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
            batteryControlTransmittableElements = new BatteryControlTransmittableElements();
            batteryControlTransmittableElements.ra0 = n16 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra1 = n15 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra2 = n14 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra3 = n13 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra4 = n12 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra5 = n11 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra6 = n10 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra7 = n9 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra8 = n8 = iDeserializer.getInt32();
            batteryControlTransmittableElements.ra9 = n7 = iDeserializer.getInt32();
            batteryControlTransmittableElements.raA = n6 = iDeserializer.getInt32();
            batteryControlTransmittableElements.raB = n5 = iDeserializer.getInt32();
            batteryControlTransmittableElements.raC = n4 = iDeserializer.getInt32();
            batteryControlTransmittableElements.raD = n3 = iDeserializer.getInt32();
            batteryControlTransmittableElements.raE = n2 = iDeserializer.getInt32();
            batteryControlTransmittableElements.raF = n = iDeserializer.getInt32();
        }
        return batteryControlTransmittableElements;
    }

    public static BatteryControlTransmittableElements[] getOptionalBatteryControlTransmittableElementsVarArray(IDeserializer iDeserializer) {
        BatteryControlTransmittableElements[] batteryControlTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlTransmittableElementsArray = new BatteryControlTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlTransmittableElementsArray[i2] = BatteryControlTransmittableElementsSerializer.getOptionalBatteryControlTransmittableElements(iDeserializer);
            }
        }
        return batteryControlTransmittableElementsArray;
    }
}

