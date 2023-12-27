/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCMainItemsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecordDisplayData;
import org.dsi.ifc.carkombi.DCMainItems;

public class DCDisplayPresetsListRecordDisplayDataSerializer {
    public static void putOptionalDCDisplayPresetsListRecordDisplayData(ISerializer iSerializer, DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData) {
        boolean bl = dCDisplayPresetsListRecordDisplayData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            DCMainItems dCMainItems = dCDisplayPresetsListRecordDisplayData.getMainSelection();
            DCMainItemsSerializer.putOptionalDCMainItems(iSerializer, dCMainItems);
            DCAdditionalInfo dCAdditionalInfo = dCDisplayPresetsListRecordDisplayData.getAdditionalInfo1();
            DCAdditionalInfoSerializer.putOptionalDCAdditionalInfo(iSerializer, dCAdditionalInfo);
            DCAdditionalInfo dCAdditionalInfo2 = dCDisplayPresetsListRecordDisplayData.getAdditionalInfo2();
            DCAdditionalInfoSerializer.putOptionalDCAdditionalInfo(iSerializer, dCAdditionalInfo2);
        }
    }

    public static void putOptionalDCDisplayPresetsListRecordDisplayDataVarArray(ISerializer iSerializer, DCDisplayPresetsListRecordDisplayData[] dCDisplayPresetsListRecordDisplayDataArray) {
        boolean bl = dCDisplayPresetsListRecordDisplayDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCDisplayPresetsListRecordDisplayDataArray.length);
            for (int i2 = 0; i2 < dCDisplayPresetsListRecordDisplayDataArray.length; ++i2) {
                DCDisplayPresetsListRecordDisplayDataSerializer.putOptionalDCDisplayPresetsListRecordDisplayData(iSerializer, dCDisplayPresetsListRecordDisplayDataArray[i2]);
            }
        }
    }

    public static DCDisplayPresetsListRecordDisplayData getOptionalDCDisplayPresetsListRecordDisplayData(IDeserializer iDeserializer) {
        DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DCAdditionalInfo dCAdditionalInfo;
            DCAdditionalInfo dCAdditionalInfo2;
            DCMainItems dCMainItems;
            dCDisplayPresetsListRecordDisplayData = new DCDisplayPresetsListRecordDisplayData();
            dCDisplayPresetsListRecordDisplayData.mainSelection = dCMainItems = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
            dCDisplayPresetsListRecordDisplayData.additionalInfo1 = dCAdditionalInfo2 = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
            dCDisplayPresetsListRecordDisplayData.additionalInfo2 = dCAdditionalInfo = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
        }
        return dCDisplayPresetsListRecordDisplayData;
    }

    public static DCDisplayPresetsListRecordDisplayData[] getOptionalDCDisplayPresetsListRecordDisplayDataVarArray(IDeserializer iDeserializer) {
        DCDisplayPresetsListRecordDisplayData[] dCDisplayPresetsListRecordDisplayDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCDisplayPresetsListRecordDisplayDataArray = new DCDisplayPresetsListRecordDisplayData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCDisplayPresetsListRecordDisplayDataArray[i2] = DCDisplayPresetsListRecordDisplayDataSerializer.getOptionalDCDisplayPresetsListRecordDisplayData(iDeserializer);
            }
        }
        return dCDisplayPresetsListRecordDisplayDataArray;
    }
}

