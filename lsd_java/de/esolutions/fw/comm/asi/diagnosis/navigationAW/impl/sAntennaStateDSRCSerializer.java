/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateDSRC;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sAntennaStateDSRCSerializer {
    public static void putOptionalsAntennaStateDSRC(ISerializer iSerializer, sAntennaStateDSRC sAntennaStateDSRC2) {
        boolean bl = sAntennaStateDSRC2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sAntennaStateDSRC2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sAntennaStateDSRC2.getAntennaState();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsAntennaStateDSRCVarArray(ISerializer iSerializer, sAntennaStateDSRC[] sAntennaStateDSRCArray) {
        boolean bl = sAntennaStateDSRCArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sAntennaStateDSRCArray.length);
            for (int i2 = 0; i2 < sAntennaStateDSRCArray.length; ++i2) {
                sAntennaStateDSRCSerializer.putOptionalsAntennaStateDSRC(iSerializer, sAntennaStateDSRCArray[i2]);
            }
        }
    }

    public static sAntennaStateDSRC getOptionalsAntennaStateDSRC(IDeserializer iDeserializer) {
        sAntennaStateDSRC sAntennaStateDSRC2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sAntennaStateDSRC2 = new sAntennaStateDSRC();
            sAntennaStateDSRC2.msg_id = l = iDeserializer.getUInt32();
            sAntennaStateDSRC2.antennaState = n = iDeserializer.getEnum();
        }
        return sAntennaStateDSRC2;
    }

    public static sAntennaStateDSRC[] getOptionalsAntennaStateDSRCVarArray(IDeserializer iDeserializer) {
        sAntennaStateDSRC[] sAntennaStateDSRCArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sAntennaStateDSRCArray = new sAntennaStateDSRC[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sAntennaStateDSRCArray[i2] = sAntennaStateDSRCSerializer.getOptionalsAntennaStateDSRC(iDeserializer);
            }
        }
        return sAntennaStateDSRCArray;
    }
}

