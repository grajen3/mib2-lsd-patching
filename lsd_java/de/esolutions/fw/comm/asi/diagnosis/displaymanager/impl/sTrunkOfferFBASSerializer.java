/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl;

import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTrunkOfferFBASSerializer {
    public static void putOptionalsTrunkOfferFBAS(ISerializer iSerializer, sTrunkOfferFBAS sTrunkOfferFBAS2) {
        boolean bl = sTrunkOfferFBAS2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTrunkOfferFBAS2.getMsg_id();
            iSerializer.putUInt32(l);
            boolean bl2 = sTrunkOfferFBAS2.isSuccessful();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalsTrunkOfferFBASVarArray(ISerializer iSerializer, sTrunkOfferFBAS[] sTrunkOfferFBASArray) {
        boolean bl = sTrunkOfferFBASArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTrunkOfferFBASArray.length);
            for (int i2 = 0; i2 < sTrunkOfferFBASArray.length; ++i2) {
                sTrunkOfferFBASSerializer.putOptionalsTrunkOfferFBAS(iSerializer, sTrunkOfferFBASArray[i2]);
            }
        }
    }

    public static sTrunkOfferFBAS getOptionalsTrunkOfferFBAS(IDeserializer iDeserializer) {
        sTrunkOfferFBAS sTrunkOfferFBAS2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            long l;
            sTrunkOfferFBAS2 = new sTrunkOfferFBAS();
            sTrunkOfferFBAS2.msg_id = l = iDeserializer.getUInt32();
            sTrunkOfferFBAS2.successful = bl2 = iDeserializer.getBool();
        }
        return sTrunkOfferFBAS2;
    }

    public static sTrunkOfferFBAS[] getOptionalsTrunkOfferFBASVarArray(IDeserializer iDeserializer) {
        sTrunkOfferFBAS[] sTrunkOfferFBASArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTrunkOfferFBASArray = new sTrunkOfferFBAS[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTrunkOfferFBASArray[i2] = sTrunkOfferFBASSerializer.getOptionalsTrunkOfferFBAS(iDeserializer);
            }
        }
        return sTrunkOfferFBASArray;
    }
}

