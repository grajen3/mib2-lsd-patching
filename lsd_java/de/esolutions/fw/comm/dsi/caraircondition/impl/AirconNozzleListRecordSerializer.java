/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconNozzleListCapabilitiesSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconNozzleListStylesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconNozzleListCapabilities;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public class AirconNozzleListRecordSerializer {
    public static void putOptionalAirconNozzleListRecord(ISerializer iSerializer, AirconNozzleListRecord airconNozzleListRecord) {
        boolean bl = airconNozzleListRecord == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconNozzleListRecord.getPos();
            iSerializer.putInt32(n);
            int n2 = airconNozzleListRecord.getHorizontalPosition();
            iSerializer.putInt32(n2);
            int n3 = airconNozzleListRecord.getVerticalPosition();
            iSerializer.putInt32(n3);
            AirconNozzleListCapabilities airconNozzleListCapabilities = airconNozzleListRecord.getCapabilities();
            AirconNozzleListCapabilitiesSerializer.putOptionalAirconNozzleListCapabilities(iSerializer, airconNozzleListCapabilities);
            int n4 = airconNozzleListRecord.getHorizontal();
            iSerializer.putInt32(n4);
            int n5 = airconNozzleListRecord.getVertical();
            iSerializer.putInt32(n5);
            int n6 = airconNozzleListRecord.getAirflow();
            iSerializer.putInt32(n6);
            AirconNozzleListStyles airconNozzleListStyles = airconNozzleListRecord.getStyle();
            AirconNozzleListStylesSerializer.putOptionalAirconNozzleListStyles(iSerializer, airconNozzleListStyles);
            int n7 = airconNozzleListRecord.getIntervalHorizontal();
            iSerializer.putInt32(n7);
            int n8 = airconNozzleListRecord.getIntervalVertical();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalAirconNozzleListRecordVarArray(ISerializer iSerializer, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        boolean bl = airconNozzleListRecordArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconNozzleListRecordArray.length);
            for (int i2 = 0; i2 < airconNozzleListRecordArray.length; ++i2) {
                AirconNozzleListRecordSerializer.putOptionalAirconNozzleListRecord(iSerializer, airconNozzleListRecordArray[i2]);
            }
        }
    }

    public static AirconNozzleListRecord getOptionalAirconNozzleListRecord(IDeserializer iDeserializer) {
        AirconNozzleListRecord airconNozzleListRecord = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            AirconNozzleListStyles airconNozzleListStyles;
            int n3;
            int n4;
            int n5;
            AirconNozzleListCapabilities airconNozzleListCapabilities;
            int n6;
            int n7;
            int n8;
            airconNozzleListRecord = new AirconNozzleListRecord();
            airconNozzleListRecord.pos = n8 = iDeserializer.getInt32();
            airconNozzleListRecord.horizontalPosition = n7 = iDeserializer.getInt32();
            airconNozzleListRecord.verticalPosition = n6 = iDeserializer.getInt32();
            airconNozzleListRecord.capabilities = airconNozzleListCapabilities = AirconNozzleListCapabilitiesSerializer.getOptionalAirconNozzleListCapabilities(iDeserializer);
            airconNozzleListRecord.horizontal = n5 = iDeserializer.getInt32();
            airconNozzleListRecord.vertical = n4 = iDeserializer.getInt32();
            airconNozzleListRecord.airflow = n3 = iDeserializer.getInt32();
            airconNozzleListRecord.style = airconNozzleListStyles = AirconNozzleListStylesSerializer.getOptionalAirconNozzleListStyles(iDeserializer);
            airconNozzleListRecord.intervalHorizontal = n2 = iDeserializer.getInt32();
            airconNozzleListRecord.intervalVertical = n = iDeserializer.getInt32();
        }
        return airconNozzleListRecord;
    }

    public static AirconNozzleListRecord[] getOptionalAirconNozzleListRecordVarArray(IDeserializer iDeserializer) {
        AirconNozzleListRecord[] airconNozzleListRecordArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconNozzleListRecordArray = new AirconNozzleListRecord[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconNozzleListRecordArray[i2] = AirconNozzleListRecordSerializer.getOptionalAirconNozzleListRecord(iDeserializer);
            }
        }
        return airconNozzleListRecordArray;
    }
}

