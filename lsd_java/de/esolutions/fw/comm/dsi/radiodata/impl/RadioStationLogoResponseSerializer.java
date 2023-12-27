/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class RadioStationLogoResponseSerializer {
    public static void putOptionalRadioStationLogoResponse(ISerializer iSerializer, RadioStationLogoResponse radioStationLogoResponse) {
        boolean bl = radioStationLogoResponse == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = radioStationLogoResponse.getTotalItemCount();
            iSerializer.putInt32(n);
            ResourceLocator[] resourceLocatorArray = radioStationLogoResponse.getResourceLocators();
            ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
            RadioStationData[] radioStationDataArray = radioStationLogoResponse.getRadioStationData();
            RadioStationDataSerializer.putOptionalRadioStationDataVarArray(iSerializer, radioStationDataArray);
        }
    }

    public static void putOptionalRadioStationLogoResponseVarArray(ISerializer iSerializer, RadioStationLogoResponse[] radioStationLogoResponseArray) {
        boolean bl = radioStationLogoResponseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationLogoResponseArray.length);
            for (int i2 = 0; i2 < radioStationLogoResponseArray.length; ++i2) {
                RadioStationLogoResponseSerializer.putOptionalRadioStationLogoResponse(iSerializer, radioStationLogoResponseArray[i2]);
            }
        }
    }

    public static RadioStationLogoResponse getOptionalRadioStationLogoResponse(IDeserializer iDeserializer) {
        RadioStationLogoResponse radioStationLogoResponse = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            radioStationLogoResponse = new RadioStationLogoResponse();
            radioStationLogoResponse.totalItemCount = n = iDeserializer.getInt32();
            ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
            radioStationLogoResponse.resourceLocators = resourceLocatorArray;
            RadioStationData[] radioStationDataArray = RadioStationDataSerializer.getOptionalRadioStationDataVarArray(iDeserializer);
            radioStationLogoResponse.radioStationData = radioStationDataArray;
        }
        return radioStationLogoResponse;
    }

    public static RadioStationLogoResponse[] getOptionalRadioStationLogoResponseVarArray(IDeserializer iDeserializer) {
        RadioStationLogoResponse[] radioStationLogoResponseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationLogoResponseArray = new RadioStationLogoResponse[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationLogoResponseArray[i2] = RadioStationLogoResponseSerializer.getOptionalRadioStationLogoResponse(iDeserializer);
            }
        }
        return radioStationLogoResponseArray;
    }
}

