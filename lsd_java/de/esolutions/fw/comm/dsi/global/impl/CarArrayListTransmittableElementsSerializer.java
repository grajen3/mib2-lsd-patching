/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class CarArrayListTransmittableElementsSerializer {
    public static void putOptionalCarArrayListTransmittableElements(ISerializer iSerializer, CarArrayListTransmittableElements carArrayListTransmittableElements) {
        boolean bl = carArrayListTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carArrayListTransmittableElements.getRa0();
            iSerializer.putInt32(n);
            int n2 = carArrayListTransmittableElements.getRa1();
            iSerializer.putInt32(n2);
            int n3 = carArrayListTransmittableElements.getRa2();
            iSerializer.putInt32(n3);
            int n4 = carArrayListTransmittableElements.getRa3();
            iSerializer.putInt32(n4);
            int n5 = carArrayListTransmittableElements.getRa4();
            iSerializer.putInt32(n5);
            int n6 = carArrayListTransmittableElements.getRa5();
            iSerializer.putInt32(n6);
            int n7 = carArrayListTransmittableElements.getRa6();
            iSerializer.putInt32(n7);
            int n8 = carArrayListTransmittableElements.getRa7();
            iSerializer.putInt32(n8);
            int n9 = carArrayListTransmittableElements.getRa8();
            iSerializer.putInt32(n9);
            int n10 = carArrayListTransmittableElements.getRa9();
            iSerializer.putInt32(n10);
            int n11 = carArrayListTransmittableElements.getRaA();
            iSerializer.putInt32(n11);
            int n12 = carArrayListTransmittableElements.getRaB();
            iSerializer.putInt32(n12);
            int n13 = carArrayListTransmittableElements.getRaC();
            iSerializer.putInt32(n13);
            int n14 = carArrayListTransmittableElements.getRaD();
            iSerializer.putInt32(n14);
            int n15 = carArrayListTransmittableElements.getRaE();
            iSerializer.putInt32(n15);
            int n16 = carArrayListTransmittableElements.getRaF();
            iSerializer.putInt32(n16);
        }
    }

    public static void putOptionalCarArrayListTransmittableElementsVarArray(ISerializer iSerializer, CarArrayListTransmittableElements[] carArrayListTransmittableElementsArray) {
        boolean bl = carArrayListTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carArrayListTransmittableElementsArray.length);
            for (int i2 = 0; i2 < carArrayListTransmittableElementsArray.length; ++i2) {
                CarArrayListTransmittableElementsSerializer.putOptionalCarArrayListTransmittableElements(iSerializer, carArrayListTransmittableElementsArray[i2]);
            }
        }
    }

    public static CarArrayListTransmittableElements getOptionalCarArrayListTransmittableElements(IDeserializer iDeserializer) {
        CarArrayListTransmittableElements carArrayListTransmittableElements = null;
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
            carArrayListTransmittableElements = new CarArrayListTransmittableElements();
            carArrayListTransmittableElements.ra0 = n16 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra1 = n15 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra2 = n14 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra3 = n13 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra4 = n12 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra5 = n11 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra6 = n10 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra7 = n9 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra8 = n8 = iDeserializer.getInt32();
            carArrayListTransmittableElements.ra9 = n7 = iDeserializer.getInt32();
            carArrayListTransmittableElements.raA = n6 = iDeserializer.getInt32();
            carArrayListTransmittableElements.raB = n5 = iDeserializer.getInt32();
            carArrayListTransmittableElements.raC = n4 = iDeserializer.getInt32();
            carArrayListTransmittableElements.raD = n3 = iDeserializer.getInt32();
            carArrayListTransmittableElements.raE = n2 = iDeserializer.getInt32();
            carArrayListTransmittableElements.raF = n = iDeserializer.getInt32();
        }
        return carArrayListTransmittableElements;
    }

    public static CarArrayListTransmittableElements[] getOptionalCarArrayListTransmittableElementsVarArray(IDeserializer iDeserializer) {
        CarArrayListTransmittableElements[] carArrayListTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carArrayListTransmittableElementsArray = new CarArrayListTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carArrayListTransmittableElementsArray[i2] = CarArrayListTransmittableElementsSerializer.getOptionalCarArrayListTransmittableElements(iDeserializer);
            }
        }
        return carArrayListTransmittableElementsArray;
    }
}

