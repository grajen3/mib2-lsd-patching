/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.SIAServiceAttributesSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.SIAServiceTypesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAServiceAttributes;
import org.dsi.ifc.carkombi.SIAServiceTypes;

public class SIAHistoryListRecordSerializer {
    public static void putOptionalSIAHistoryListRecord(ISerializer iSerializer, SIAHistoryListRecord sIAHistoryListRecord) {
        boolean bl = sIAHistoryListRecord == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sIAHistoryListRecord.getPos();
            iSerializer.putInt32(n);
            SIAServiceTypes sIAServiceTypes = sIAHistoryListRecord.getServiceTypes();
            SIAServiceTypesSerializer.putOptionalSIAServiceTypes(iSerializer, sIAServiceTypes);
            SIAServiceAttributes sIAServiceAttributes = sIAHistoryListRecord.getServiceAttributes();
            SIAServiceAttributesSerializer.putOptionalSIAServiceAttributes(iSerializer, sIAServiceAttributes);
            int n2 = sIAHistoryListRecord.getYear();
            iSerializer.putInt32(n2);
            int n3 = sIAHistoryListRecord.getMonth();
            iSerializer.putInt32(n3);
            int n4 = sIAHistoryListRecord.getDay();
            iSerializer.putInt32(n4);
            String string = sIAHistoryListRecord.getOrderCode();
            iSerializer.putOptionalString(string);
            int n5 = sIAHistoryListRecord.getMileage();
            iSerializer.putInt32(n5);
            int n6 = sIAHistoryListRecord.getMileageUnit();
            iSerializer.putInt32(n6);
            String string2 = sIAHistoryListRecord.getDealerName();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalSIAHistoryListRecordVarArray(ISerializer iSerializer, SIAHistoryListRecord[] sIAHistoryListRecordArray) {
        boolean bl = sIAHistoryListRecordArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAHistoryListRecordArray.length);
            for (int i2 = 0; i2 < sIAHistoryListRecordArray.length; ++i2) {
                SIAHistoryListRecordSerializer.putOptionalSIAHistoryListRecord(iSerializer, sIAHistoryListRecordArray[i2]);
            }
        }
    }

    public static SIAHistoryListRecord getOptionalSIAHistoryListRecord(IDeserializer iDeserializer) {
        SIAHistoryListRecord sIAHistoryListRecord = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            String string2;
            int n3;
            int n4;
            int n5;
            SIAServiceAttributes sIAServiceAttributes;
            SIAServiceTypes sIAServiceTypes;
            int n6;
            sIAHistoryListRecord = new SIAHistoryListRecord();
            sIAHistoryListRecord.pos = n6 = iDeserializer.getInt32();
            sIAHistoryListRecord.serviceTypes = sIAServiceTypes = SIAServiceTypesSerializer.getOptionalSIAServiceTypes(iDeserializer);
            sIAHistoryListRecord.serviceAttributes = sIAServiceAttributes = SIAServiceAttributesSerializer.getOptionalSIAServiceAttributes(iDeserializer);
            sIAHistoryListRecord.year = n5 = iDeserializer.getInt32();
            sIAHistoryListRecord.month = n4 = iDeserializer.getInt32();
            sIAHistoryListRecord.day = n3 = iDeserializer.getInt32();
            sIAHistoryListRecord.orderCode = string2 = iDeserializer.getOptionalString();
            sIAHistoryListRecord.mileage = n2 = iDeserializer.getInt32();
            sIAHistoryListRecord.mileageUnit = n = iDeserializer.getInt32();
            sIAHistoryListRecord.dealerName = string = iDeserializer.getOptionalString();
        }
        return sIAHistoryListRecord;
    }

    public static SIAHistoryListRecord[] getOptionalSIAHistoryListRecordVarArray(IDeserializer iDeserializer) {
        SIAHistoryListRecord[] sIAHistoryListRecordArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAHistoryListRecordArray = new SIAHistoryListRecord[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAHistoryListRecordArray[i2] = SIAHistoryListRecordSerializer.getOptionalSIAHistoryListRecord(iDeserializer);
            }
        }
        return sIAHistoryListRecordArray;
    }
}

