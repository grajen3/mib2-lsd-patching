/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner.impl;

import de.esolutions.fw.comm.dsi.tvtuner.impl.TimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.Time;

public class EWSInfoSerializer {
    public static void putOptionalEWSInfo(ISerializer iSerializer, EWSInfo eWSInfo) {
        boolean bl = eWSInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = eWSInfo.getNamePID();
            iSerializer.putInt64(l);
            int n = eWSInfo.getServicePID();
            iSerializer.putInt32(n);
            Time time = eWSInfo.getWarningTime();
            TimeSerializer.putOptionalTime(iSerializer, time);
            int n2 = eWSInfo.getWarningType();
            iSerializer.putInt32(n2);
            int n3 = eWSInfo.getAffectedArea();
            iSerializer.putInt32(n3);
            int n4 = eWSInfo.getWarningPrio();
            iSerializer.putInt32(n4);
            int n5 = eWSInfo.getWarningSrcClass();
            iSerializer.putInt32(n5);
            String string = eWSInfo.getOriginCountry();
            iSerializer.putOptionalString(string);
            long l2 = eWSInfo.getEwsID();
            iSerializer.putInt64(l2);
            Time time2 = eWSInfo.getReceivingTime();
            TimeSerializer.putOptionalTime(iSerializer, time2);
            String string2 = eWSInfo.getMessageText();
            iSerializer.putOptionalString(string2);
            String[] stringArray = eWSInfo.getAreaCodeListNames();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalEWSInfoVarArray(ISerializer iSerializer, EWSInfo[] eWSInfoArray) {
        boolean bl = eWSInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(eWSInfoArray.length);
            for (int i2 = 0; i2 < eWSInfoArray.length; ++i2) {
                EWSInfoSerializer.putOptionalEWSInfo(iSerializer, eWSInfoArray[i2]);
            }
        }
    }

    public static EWSInfo getOptionalEWSInfo(IDeserializer iDeserializer) {
        EWSInfo eWSInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            Time time;
            long l;
            String string2;
            int n;
            int n2;
            int n3;
            int n4;
            Time time2;
            int n5;
            long l2;
            eWSInfo = new EWSInfo();
            eWSInfo.namePID = l2 = iDeserializer.getInt64();
            eWSInfo.servicePID = n5 = iDeserializer.getInt32();
            eWSInfo.warningTime = time2 = TimeSerializer.getOptionalTime(iDeserializer);
            eWSInfo.warningType = n4 = iDeserializer.getInt32();
            eWSInfo.affectedArea = n3 = iDeserializer.getInt32();
            eWSInfo.warningPrio = n2 = iDeserializer.getInt32();
            eWSInfo.warningSrcClass = n = iDeserializer.getInt32();
            eWSInfo.originCountry = string2 = iDeserializer.getOptionalString();
            eWSInfo.ewsID = l = iDeserializer.getInt64();
            eWSInfo.receivingTime = time = TimeSerializer.getOptionalTime(iDeserializer);
            eWSInfo.messageText = string = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            eWSInfo.areaCodeListNames = stringArray;
        }
        return eWSInfo;
    }

    public static EWSInfo[] getOptionalEWSInfoVarArray(IDeserializer iDeserializer) {
        EWSInfo[] eWSInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            eWSInfoArray = new EWSInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                eWSInfoArray[i2] = EWSInfoSerializer.getOptionalEWSInfo(iDeserializer);
            }
        }
        return eWSInfoArray;
    }
}

