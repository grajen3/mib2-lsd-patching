/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.swdl.impl;

import de.esolutions.fw.comm.asi.diagnosis.swdl.sModuleVersionNumbers;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sModuleVersionNumbersSerializer {
    public static void putOptionalsModuleVersionNumbers(ISerializer iSerializer, sModuleVersionNumbers sModuleVersionNumbers2) {
        boolean bl = sModuleVersionNumbers2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sModuleVersionNumbers2.getMsg_id();
            iSerializer.putUInt32(l);
            long l2 = sModuleVersionNumbers2.getBluetooth_parrot_stack();
            iSerializer.putUInt32(l2);
            long l3 = sModuleVersionNumbers2.getPhone_module();
            iSerializer.putUInt32(l3);
            long l4 = sModuleVersionNumbers2.getLanguages_voices();
            iSerializer.putUInt32(l4);
            long l5 = sModuleVersionNumbers2.getCodec_media_driver();
            iSerializer.putUInt32(l5);
            long l6 = sModuleVersionNumbers2.getGracenote_database();
            iSerializer.putUInt32(l6);
            long l7 = sModuleVersionNumbers2.getRadio_tv_station_list();
            iSerializer.putUInt32(l7);
        }
    }

    public static void putOptionalsModuleVersionNumbersVarArray(ISerializer iSerializer, sModuleVersionNumbers[] sModuleVersionNumbersArray) {
        boolean bl = sModuleVersionNumbersArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sModuleVersionNumbersArray.length);
            for (int i2 = 0; i2 < sModuleVersionNumbersArray.length; ++i2) {
                sModuleVersionNumbersSerializer.putOptionalsModuleVersionNumbers(iSerializer, sModuleVersionNumbersArray[i2]);
            }
        }
    }

    public static sModuleVersionNumbers getOptionalsModuleVersionNumbers(IDeserializer iDeserializer) {
        sModuleVersionNumbers sModuleVersionNumbers2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            long l3;
            long l4;
            long l5;
            long l6;
            long l7;
            sModuleVersionNumbers2 = new sModuleVersionNumbers();
            sModuleVersionNumbers2.msg_id = l7 = iDeserializer.getUInt32();
            sModuleVersionNumbers2.bluetooth_parrot_stack = l6 = iDeserializer.getUInt32();
            sModuleVersionNumbers2.phone_module = l5 = iDeserializer.getUInt32();
            sModuleVersionNumbers2.languages_voices = l4 = iDeserializer.getUInt32();
            sModuleVersionNumbers2.codec_media_driver = l3 = iDeserializer.getUInt32();
            sModuleVersionNumbers2.gracenote_database = l2 = iDeserializer.getUInt32();
            sModuleVersionNumbers2.radio_tv_station_list = l = iDeserializer.getUInt32();
        }
        return sModuleVersionNumbers2;
    }

    public static sModuleVersionNumbers[] getOptionalsModuleVersionNumbersVarArray(IDeserializer iDeserializer) {
        sModuleVersionNumbers[] sModuleVersionNumbersArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sModuleVersionNumbersArray = new sModuleVersionNumbers[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sModuleVersionNumbersArray[i2] = sModuleVersionNumbersSerializer.getOptionalsModuleVersionNumbers(iDeserializer);
            }
        }
        return sModuleVersionNumbersArray;
    }
}

