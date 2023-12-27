/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.SeekInformation;

public class SeekInformationSerializer {
    public static void putOptionalSeekInformation(ISerializer iSerializer, SeekInformation seekInformation) {
        boolean bl = seekInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seekInformation.getSeekInfo();
            iSerializer.putInt32(n);
            String string = seekInformation.getSeekText();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalSeekInformationVarArray(ISerializer iSerializer, SeekInformation[] seekInformationArray) {
        boolean bl = seekInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seekInformationArray.length);
            for (int i2 = 0; i2 < seekInformationArray.length; ++i2) {
                SeekInformationSerializer.putOptionalSeekInformation(iSerializer, seekInformationArray[i2]);
            }
        }
    }

    public static SeekInformation getOptionalSeekInformation(IDeserializer iDeserializer) {
        SeekInformation seekInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            seekInformation = new SeekInformation();
            seekInformation.seekInfo = n = iDeserializer.getInt32();
            seekInformation.seekText = string = iDeserializer.getOptionalString();
        }
        return seekInformation;
    }

    public static SeekInformation[] getOptionalSeekInformationVarArray(IDeserializer iDeserializer) {
        SeekInformation[] seekInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seekInformationArray = new SeekInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seekInformationArray[i2] = SeekInformationSerializer.getOptionalSeekInformation(iDeserializer);
            }
        }
        return seekInformationArray;
    }
}

