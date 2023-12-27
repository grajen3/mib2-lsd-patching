/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.BapManeuverDescriptor;

public class BapManeuverDescriptorSerializer {
    public static void putOptionalBapManeuverDescriptor(ISerializer iSerializer, BapManeuverDescriptor bapManeuverDescriptor) {
        boolean bl = bapManeuverDescriptor == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bapManeuverDescriptor.getMainElement();
            iSerializer.putInt32(n);
            int n2 = bapManeuverDescriptor.getDirection();
            iSerializer.putInt32(n2);
            int n3 = bapManeuverDescriptor.getZLevelGuidance();
            iSerializer.putInt32(n3);
            byte[] byArray = bapManeuverDescriptor.getSideStreets();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalBapManeuverDescriptorVarArray(ISerializer iSerializer, BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        boolean bl = bapManeuverDescriptorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bapManeuverDescriptorArray.length);
            for (int i2 = 0; i2 < bapManeuverDescriptorArray.length; ++i2) {
                BapManeuverDescriptorSerializer.putOptionalBapManeuverDescriptor(iSerializer, bapManeuverDescriptorArray[i2]);
            }
        }
    }

    public static BapManeuverDescriptor getOptionalBapManeuverDescriptor(IDeserializer iDeserializer) {
        BapManeuverDescriptor bapManeuverDescriptor = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            bapManeuverDescriptor = new BapManeuverDescriptor();
            bapManeuverDescriptor.mainElement = n3 = iDeserializer.getInt32();
            bapManeuverDescriptor.direction = n2 = iDeserializer.getInt32();
            bapManeuverDescriptor.zLevelGuidance = n = iDeserializer.getInt32();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            bapManeuverDescriptor.sideStreets = byArray;
        }
        return bapManeuverDescriptor;
    }

    public static BapManeuverDescriptor[] getOptionalBapManeuverDescriptorVarArray(IDeserializer iDeserializer) {
        BapManeuverDescriptor[] bapManeuverDescriptorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bapManeuverDescriptorArray = new BapManeuverDescriptor[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bapManeuverDescriptorArray[i2] = BapManeuverDescriptorSerializer.getOptionalBapManeuverDescriptor(iDeserializer);
            }
        }
        return bapManeuverDescriptorArray;
    }
}

