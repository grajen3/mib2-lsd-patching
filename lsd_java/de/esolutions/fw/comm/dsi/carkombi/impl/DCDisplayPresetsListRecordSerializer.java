/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayPresetsListRecordDisplayDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecordDisplayData;

public class DCDisplayPresetsListRecordSerializer {
    public static void putOptionalDCDisplayPresetsListRecord(ISerializer iSerializer, DCDisplayPresetsListRecord dCDisplayPresetsListRecord) {
        boolean bl = dCDisplayPresetsListRecord == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dCDisplayPresetsListRecord.getPos();
            iSerializer.putInt32(n);
            int n2 = dCDisplayPresetsListRecord.getState();
            iSerializer.putInt32(n2);
            int n3 = dCDisplayPresetsListRecord.getType();
            iSerializer.putInt32(n3);
            int n4 = dCDisplayPresetsListRecord.getInstance();
            iSerializer.putInt32(n4);
            DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData = dCDisplayPresetsListRecord.getDisplay1();
            DCDisplayPresetsListRecordDisplayDataSerializer.putOptionalDCDisplayPresetsListRecordDisplayData(iSerializer, dCDisplayPresetsListRecordDisplayData);
            DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData2 = dCDisplayPresetsListRecord.getDisplay2();
            DCDisplayPresetsListRecordDisplayDataSerializer.putOptionalDCDisplayPresetsListRecordDisplayData(iSerializer, dCDisplayPresetsListRecordDisplayData2);
            DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData3 = dCDisplayPresetsListRecord.getDisplay3();
            DCDisplayPresetsListRecordDisplayDataSerializer.putOptionalDCDisplayPresetsListRecordDisplayData(iSerializer, dCDisplayPresetsListRecordDisplayData3);
        }
    }

    public static void putOptionalDCDisplayPresetsListRecordVarArray(ISerializer iSerializer, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        boolean bl = dCDisplayPresetsListRecordArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCDisplayPresetsListRecordArray.length);
            for (int i2 = 0; i2 < dCDisplayPresetsListRecordArray.length; ++i2) {
                DCDisplayPresetsListRecordSerializer.putOptionalDCDisplayPresetsListRecord(iSerializer, dCDisplayPresetsListRecordArray[i2]);
            }
        }
    }

    public static DCDisplayPresetsListRecord getOptionalDCDisplayPresetsListRecord(IDeserializer iDeserializer) {
        DCDisplayPresetsListRecord dCDisplayPresetsListRecord = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData;
            DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData2;
            DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData3;
            int n;
            int n2;
            int n3;
            int n4;
            dCDisplayPresetsListRecord = new DCDisplayPresetsListRecord();
            dCDisplayPresetsListRecord.pos = n4 = iDeserializer.getInt32();
            dCDisplayPresetsListRecord.state = n3 = iDeserializer.getInt32();
            dCDisplayPresetsListRecord.type = n2 = iDeserializer.getInt32();
            dCDisplayPresetsListRecord.instance = n = iDeserializer.getInt32();
            dCDisplayPresetsListRecord.display1 = dCDisplayPresetsListRecordDisplayData3 = DCDisplayPresetsListRecordDisplayDataSerializer.getOptionalDCDisplayPresetsListRecordDisplayData(iDeserializer);
            dCDisplayPresetsListRecord.display2 = dCDisplayPresetsListRecordDisplayData2 = DCDisplayPresetsListRecordDisplayDataSerializer.getOptionalDCDisplayPresetsListRecordDisplayData(iDeserializer);
            dCDisplayPresetsListRecord.display3 = dCDisplayPresetsListRecordDisplayData = DCDisplayPresetsListRecordDisplayDataSerializer.getOptionalDCDisplayPresetsListRecordDisplayData(iDeserializer);
        }
        return dCDisplayPresetsListRecord;
    }

    public static DCDisplayPresetsListRecord[] getOptionalDCDisplayPresetsListRecordVarArray(IDeserializer iDeserializer) {
        DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCDisplayPresetsListRecordArray = new DCDisplayPresetsListRecord[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCDisplayPresetsListRecordArray[i2] = DCDisplayPresetsListRecordSerializer.getOptionalDCDisplayPresetsListRecord(iDeserializer);
            }
        }
        return dCDisplayPresetsListRecordArray;
    }
}

