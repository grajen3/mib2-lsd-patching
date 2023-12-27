/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.connectedradio.RadioStationStream;

public class RadioStationStreamSerializer {
    public static void putOptionalRadioStationStream(ISerializer iSerializer, RadioStationStream radioStationStream) {
        boolean bl = radioStationStream == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = radioStationStream.getRequestURL();
            iSerializer.putOptionalString(string);
            int n = radioStationStream.getQualityType();
            iSerializer.putInt32(n);
            int n2 = radioStationStream.getOffset();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalRadioStationStreamVarArray(ISerializer iSerializer, RadioStationStream[] radioStationStreamArray) {
        boolean bl = radioStationStreamArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationStreamArray.length);
            for (int i2 = 0; i2 < radioStationStreamArray.length; ++i2) {
                RadioStationStreamSerializer.putOptionalRadioStationStream(iSerializer, radioStationStreamArray[i2]);
            }
        }
    }

    public static RadioStationStream getOptionalRadioStationStream(IDeserializer iDeserializer) {
        RadioStationStream radioStationStream = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            radioStationStream = new RadioStationStream();
            radioStationStream.requestURL = string = iDeserializer.getOptionalString();
            radioStationStream.qualityType = n2 = iDeserializer.getInt32();
            radioStationStream.offset = n = iDeserializer.getInt32();
        }
        return radioStationStream;
    }

    public static RadioStationStream[] getOptionalRadioStationStreamVarArray(IDeserializer iDeserializer) {
        RadioStationStream[] radioStationStreamArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationStreamArray = new RadioStationStream[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationStreamArray[i2] = RadioStationStreamSerializer.getOptionalRadioStationStream(iDeserializer);
            }
        }
        return radioStationStreamArray;
    }
}

