/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.komoview.ManeuverElement;

public class ManeuverElementSerializer {
    public static void putOptionalManeuverElement(ISerializer iSerializer, ManeuverElement maneuverElement) {
        boolean bl = maneuverElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = maneuverElement.getElement();
            iSerializer.putInt32(n);
            short s = maneuverElement.getDirection();
            iSerializer.putInt16(s);
            int n2 = maneuverElement.getAttribute();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalManeuverElementVarArray(ISerializer iSerializer, ManeuverElement[] maneuverElementArray) {
        boolean bl = maneuverElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(maneuverElementArray.length);
            for (int i2 = 0; i2 < maneuverElementArray.length; ++i2) {
                ManeuverElementSerializer.putOptionalManeuverElement(iSerializer, maneuverElementArray[i2]);
            }
        }
    }

    public static ManeuverElement getOptionalManeuverElement(IDeserializer iDeserializer) {
        ManeuverElement maneuverElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            int n2;
            maneuverElement = new ManeuverElement();
            maneuverElement.element = n2 = iDeserializer.getInt32();
            maneuverElement.direction = s = iDeserializer.getInt16();
            maneuverElement.attribute = n = iDeserializer.getInt32();
        }
        return maneuverElement;
    }

    public static ManeuverElement[] getOptionalManeuverElementVarArray(IDeserializer iDeserializer) {
        ManeuverElement[] maneuverElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            maneuverElementArray = new ManeuverElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                maneuverElementArray[i2] = ManeuverElementSerializer.getOptionalManeuverElement(iDeserializer);
            }
        }
        return maneuverElementArray;
    }
}

