/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataRequestSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public class RadioStationLogoRequestSerializer {
    public static void putOptionalRadioStationLogoRequest(ISerializer iSerializer, RadioStationLogoRequest radioStationLogoRequest) {
        boolean bl = radioStationLogoRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            RadioStationDataRequest radioStationDataRequest = radioStationLogoRequest.getRadioStationDataRequest();
            RadioStationDataRequestSerializer.putOptionalRadioStationDataRequest(iSerializer, radioStationDataRequest);
            int[] nArray = radioStationLogoRequest.getPriorities();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalRadioStationLogoRequestVarArray(ISerializer iSerializer, RadioStationLogoRequest[] radioStationLogoRequestArray) {
        boolean bl = radioStationLogoRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationLogoRequestArray.length);
            for (int i2 = 0; i2 < radioStationLogoRequestArray.length; ++i2) {
                RadioStationLogoRequestSerializer.putOptionalRadioStationLogoRequest(iSerializer, radioStationLogoRequestArray[i2]);
            }
        }
    }

    public static RadioStationLogoRequest getOptionalRadioStationLogoRequest(IDeserializer iDeserializer) {
        RadioStationLogoRequest radioStationLogoRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            RadioStationDataRequest radioStationDataRequest;
            radioStationLogoRequest = new RadioStationLogoRequest();
            radioStationLogoRequest.radioStationDataRequest = radioStationDataRequest = RadioStationDataRequestSerializer.getOptionalRadioStationDataRequest(iDeserializer);
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            radioStationLogoRequest.priorities = nArray;
        }
        return radioStationLogoRequest;
    }

    public static RadioStationLogoRequest[] getOptionalRadioStationLogoRequestVarArray(IDeserializer iDeserializer) {
        RadioStationLogoRequest[] radioStationLogoRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationLogoRequestArray = new RadioStationLogoRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationLogoRequestArray[i2] = RadioStationLogoRequestSerializer.getOptionalRadioStationLogoRequest(iDeserializer);
            }
        }
        return radioStationLogoRequestArray;
    }
}

