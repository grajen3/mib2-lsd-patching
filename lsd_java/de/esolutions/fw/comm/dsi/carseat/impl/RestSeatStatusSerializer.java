/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.RestSeatStatus;

public class RestSeatStatusSerializer {
    public static void putOptionalRestSeatStatus(ISerializer iSerializer, RestSeatStatus restSeatStatus) {
        boolean bl = restSeatStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = restSeatStatus.isDisplayDown();
            iSerializer.putBool(bl2);
            boolean bl3 = restSeatStatus.isDisplayRestSeatMoving();
            iSerializer.putBool(bl3);
            boolean bl4 = restSeatStatus.isRestSeatPosition();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalRestSeatStatusVarArray(ISerializer iSerializer, RestSeatStatus[] restSeatStatusArray) {
        boolean bl = restSeatStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(restSeatStatusArray.length);
            for (int i2 = 0; i2 < restSeatStatusArray.length; ++i2) {
                RestSeatStatusSerializer.putOptionalRestSeatStatus(iSerializer, restSeatStatusArray[i2]);
            }
        }
    }

    public static RestSeatStatus getOptionalRestSeatStatus(IDeserializer iDeserializer) {
        RestSeatStatus restSeatStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            restSeatStatus = new RestSeatStatus();
            restSeatStatus.displayDown = bl4 = iDeserializer.getBool();
            restSeatStatus.displayRestSeatMoving = bl3 = iDeserializer.getBool();
            restSeatStatus.restSeatPosition = bl2 = iDeserializer.getBool();
        }
        return restSeatStatus;
    }

    public static RestSeatStatus[] getOptionalRestSeatStatusVarArray(IDeserializer iDeserializer) {
        RestSeatStatus[] restSeatStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            restSeatStatusArray = new RestSeatStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                restSeatStatusArray[i2] = RestSeatStatusSerializer.getOptionalRestSeatStatus(iDeserializer);
            }
        }
        return restSeatStatusArray;
    }
}

