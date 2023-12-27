/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.EPGDescription;

public class EPGDescriptionSerializer {
    public static void putOptionalEPGDescription(ISerializer iSerializer, EPGDescription ePGDescription) {
        boolean bl = ePGDescription == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = ePGDescription.getSID();
            iSerializer.putInt32(n);
            int n2 = ePGDescription.getProgramID();
            iSerializer.putInt32(n2);
            String string = ePGDescription.getSeriesDescription();
            iSerializer.putOptionalString(string);
            String string2 = ePGDescription.getProgramDescription();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalEPGDescriptionVarArray(ISerializer iSerializer, EPGDescription[] ePGDescriptionArray) {
        boolean bl = ePGDescriptionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGDescriptionArray.length);
            for (int i2 = 0; i2 < ePGDescriptionArray.length; ++i2) {
                EPGDescriptionSerializer.putOptionalEPGDescription(iSerializer, ePGDescriptionArray[i2]);
            }
        }
    }

    public static EPGDescription getOptionalEPGDescription(IDeserializer iDeserializer) {
        EPGDescription ePGDescription = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            int n2;
            ePGDescription = new EPGDescription();
            ePGDescription.sID = n2 = iDeserializer.getInt32();
            ePGDescription.programID = n = iDeserializer.getInt32();
            ePGDescription.seriesDescription = string2 = iDeserializer.getOptionalString();
            ePGDescription.programDescription = string = iDeserializer.getOptionalString();
        }
        return ePGDescription;
    }

    public static EPGDescription[] getOptionalEPGDescriptionVarArray(IDeserializer iDeserializer) {
        EPGDescription[] ePGDescriptionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGDescriptionArray = new EPGDescription[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGDescriptionArray[i2] = EPGDescriptionSerializer.getOptionalEPGDescription(iDeserializer);
            }
        }
        return ePGDescriptionArray;
    }
}

