/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.SeekAlert;

public class SeekAlertSerializer {
    public static void putOptionalSeekAlert(ISerializer iSerializer, SeekAlert seekAlert) {
        boolean bl = seekAlert == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seekAlert.getSeekID();
            iSerializer.putInt32(n);
            int n2 = seekAlert.getSID();
            iSerializer.putInt32(n2);
            int n3 = seekAlert.getAlertType();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSeekAlertVarArray(ISerializer iSerializer, SeekAlert[] seekAlertArray) {
        boolean bl = seekAlertArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seekAlertArray.length);
            for (int i2 = 0; i2 < seekAlertArray.length; ++i2) {
                SeekAlertSerializer.putOptionalSeekAlert(iSerializer, seekAlertArray[i2]);
            }
        }
    }

    public static SeekAlert getOptionalSeekAlert(IDeserializer iDeserializer) {
        SeekAlert seekAlert = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            seekAlert = new SeekAlert();
            seekAlert.seekID = n3 = iDeserializer.getInt32();
            seekAlert.sID = n2 = iDeserializer.getInt32();
            seekAlert.alertType = n = iDeserializer.getInt32();
        }
        return seekAlert;
    }

    public static SeekAlert[] getOptionalSeekAlertVarArray(IDeserializer iDeserializer) {
        SeekAlert[] seekAlertArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seekAlertArray = new SeekAlert[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seekAlertArray[i2] = SeekAlertSerializer.getOptionalSeekAlert(iDeserializer);
            }
        }
        return seekAlertArray;
    }
}

