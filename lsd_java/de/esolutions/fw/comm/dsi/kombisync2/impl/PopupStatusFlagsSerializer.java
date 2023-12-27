/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.PopupStatusFlags;

public class PopupStatusFlagsSerializer {
    public static void putOptionalPopupStatusFlags(ISerializer iSerializer, PopupStatusFlags popupStatusFlags) {
        boolean bl = popupStatusFlags == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = popupStatusFlags.getStatusFlags();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalPopupStatusFlagsVarArray(ISerializer iSerializer, PopupStatusFlags[] popupStatusFlagsArray) {
        boolean bl = popupStatusFlagsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(popupStatusFlagsArray.length);
            for (int i2 = 0; i2 < popupStatusFlagsArray.length; ++i2) {
                PopupStatusFlagsSerializer.putOptionalPopupStatusFlags(iSerializer, popupStatusFlagsArray[i2]);
            }
        }
    }

    public static PopupStatusFlags getOptionalPopupStatusFlags(IDeserializer iDeserializer) {
        PopupStatusFlags popupStatusFlags = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            popupStatusFlags = new PopupStatusFlags();
            popupStatusFlags.statusFlags = n = iDeserializer.getInt32();
        }
        return popupStatusFlags;
    }

    public static PopupStatusFlags[] getOptionalPopupStatusFlagsVarArray(IDeserializer iDeserializer) {
        PopupStatusFlags[] popupStatusFlagsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            popupStatusFlagsArray = new PopupStatusFlags[n];
            for (int i2 = 0; i2 < n; ++i2) {
                popupStatusFlagsArray[i2] = PopupStatusFlagsSerializer.getOptionalPopupStatusFlags(iDeserializer);
            }
        }
        return popupStatusFlagsArray;
    }
}

