/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.comm.dsi.global.impl.NavPriceInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfo;

public class TCPaymentInfoSerializer {
    public static void putOptionalTCPaymentInfo(ISerializer iSerializer, TCPaymentInfo tCPaymentInfo) {
        boolean bl = tCPaymentInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tCPaymentInfo.getPaymentInfoID();
            iSerializer.putInt32(n);
            DateTime dateTime = tCPaymentInfo.getTimeStamp();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            NavPriceInfo navPriceInfo = tCPaymentInfo.getTollAmount();
            NavPriceInfoSerializer.putOptionalNavPriceInfo(iSerializer, navPriceInfo);
        }
    }

    public static void putOptionalTCPaymentInfoVarArray(ISerializer iSerializer, TCPaymentInfo[] tCPaymentInfoArray) {
        boolean bl = tCPaymentInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tCPaymentInfoArray.length);
            for (int i2 = 0; i2 < tCPaymentInfoArray.length; ++i2) {
                TCPaymentInfoSerializer.putOptionalTCPaymentInfo(iSerializer, tCPaymentInfoArray[i2]);
            }
        }
    }

    public static TCPaymentInfo getOptionalTCPaymentInfo(IDeserializer iDeserializer) {
        TCPaymentInfo tCPaymentInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            NavPriceInfo navPriceInfo;
            DateTime dateTime;
            int n;
            tCPaymentInfo = new TCPaymentInfo();
            tCPaymentInfo.paymentInfoID = n = iDeserializer.getInt32();
            tCPaymentInfo.timeStamp = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            tCPaymentInfo.tollAmount = navPriceInfo = NavPriceInfoSerializer.getOptionalNavPriceInfo(iDeserializer);
        }
        return tCPaymentInfo;
    }

    public static TCPaymentInfo[] getOptionalTCPaymentInfoVarArray(IDeserializer iDeserializer) {
        TCPaymentInfo[] tCPaymentInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tCPaymentInfoArray = new TCPaymentInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tCPaymentInfoArray[i2] = TCPaymentInfoSerializer.getOptionalTCPaymentInfo(iDeserializer);
            }
        }
        return tCPaymentInfoArray;
    }
}

