/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;

public class RadioStationDataResponseSerializer {
    public static void putOptionalRadioStationDataResponse(ISerializer iSerializer, RadioStationDataResponse radioStationDataResponse) {
        boolean bl = radioStationDataResponse == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = radioStationDataResponse.getTotalItemCount();
            iSerializer.putInt32(n);
            RadioStationData[] radioStationDataArray = radioStationDataResponse.getRadioStationData();
            RadioStationDataSerializer.putOptionalRadioStationDataVarArray(iSerializer, radioStationDataArray);
        }
    }

    public static void putOptionalRadioStationDataResponseVarArray(ISerializer iSerializer, RadioStationDataResponse[] radioStationDataResponseArray) {
        boolean bl = radioStationDataResponseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationDataResponseArray.length);
            for (int i2 = 0; i2 < radioStationDataResponseArray.length; ++i2) {
                RadioStationDataResponseSerializer.putOptionalRadioStationDataResponse(iSerializer, radioStationDataResponseArray[i2]);
            }
        }
    }

    public static RadioStationDataResponse getOptionalRadioStationDataResponse(IDeserializer iDeserializer) {
        RadioStationDataResponse radioStationDataResponse = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            radioStationDataResponse = new RadioStationDataResponse();
            radioStationDataResponse.totalItemCount = n = iDeserializer.getInt32();
            RadioStationData[] radioStationDataArray = RadioStationDataSerializer.getOptionalRadioStationDataVarArray(iDeserializer);
            radioStationDataResponse.radioStationData = radioStationDataArray;
        }
        return radioStationDataResponse;
    }

    public static RadioStationDataResponse[] getOptionalRadioStationDataResponseVarArray(IDeserializer iDeserializer) {
        RadioStationDataResponse[] radioStationDataResponseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationDataResponseArray = new RadioStationDataResponse[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationDataResponseArray[i2] = RadioStationDataResponseSerializer.getOptionalRadioStationDataResponse(iDeserializer);
            }
        }
        return radioStationDataResponseArray;
    }
}

