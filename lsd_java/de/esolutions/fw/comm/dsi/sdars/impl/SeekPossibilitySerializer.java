/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.comm.dsi.sdars.impl.SeekInformationSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.SeekStateSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.SeekState;

public class SeekPossibilitySerializer {
    public static void putOptionalSeekPossibility(ISerializer iSerializer, SeekPossibility seekPossibility) {
        boolean bl = seekPossibility == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seekPossibility.getSID();
            iSerializer.putInt32(n);
            int n2 = seekPossibility.getTypeOfContent();
            iSerializer.putInt32(n2);
            SeekState[] seekStateArray = seekPossibility.getSeekState();
            SeekStateSerializer.putOptionalSeekStateVarArray(iSerializer, seekStateArray);
            SeekInformation[] seekInformationArray = seekPossibility.getSeekInformation();
            SeekInformationSerializer.putOptionalSeekInformationVarArray(iSerializer, seekInformationArray);
        }
    }

    public static void putOptionalSeekPossibilityVarArray(ISerializer iSerializer, SeekPossibility[] seekPossibilityArray) {
        boolean bl = seekPossibilityArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seekPossibilityArray.length);
            for (int i2 = 0; i2 < seekPossibilityArray.length; ++i2) {
                SeekPossibilitySerializer.putOptionalSeekPossibility(iSerializer, seekPossibilityArray[i2]);
            }
        }
    }

    public static SeekPossibility getOptionalSeekPossibility(IDeserializer iDeserializer) {
        SeekPossibility seekPossibility = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            seekPossibility = new SeekPossibility();
            seekPossibility.sID = n2 = iDeserializer.getInt32();
            seekPossibility.typeOfContent = n = iDeserializer.getInt32();
            SeekState[] seekStateArray = SeekStateSerializer.getOptionalSeekStateVarArray(iDeserializer);
            seekPossibility.seekState = seekStateArray;
            SeekInformation[] seekInformationArray = SeekInformationSerializer.getOptionalSeekInformationVarArray(iDeserializer);
            seekPossibility.seekInformation = seekInformationArray;
        }
        return seekPossibility;
    }

    public static SeekPossibility[] getOptionalSeekPossibilityVarArray(IDeserializer iDeserializer) {
        SeekPossibility[] seekPossibilityArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seekPossibilityArray = new SeekPossibility[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seekPossibilityArray[i2] = SeekPossibilitySerializer.getOptionalSeekPossibility(iDeserializer);
            }
        }
        return seekPossibilityArray;
    }
}

