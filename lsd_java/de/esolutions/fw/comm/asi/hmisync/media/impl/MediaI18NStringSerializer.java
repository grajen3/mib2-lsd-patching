/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class MediaI18NStringSerializer {
    public static void putOptionalMediaI18NString(ISerializer iSerializer, MediaI18NString mediaI18NString) {
        boolean bl = mediaI18NString == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mediaI18NString.getI18nKey();
            iSerializer.putInt32(n);
            String string = mediaI18NString.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalMediaI18NStringVarArray(ISerializer iSerializer, MediaI18NString[] mediaI18NStringArray) {
        boolean bl = mediaI18NStringArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaI18NStringArray.length);
            for (int i2 = 0; i2 < mediaI18NStringArray.length; ++i2) {
                MediaI18NStringSerializer.putOptionalMediaI18NString(iSerializer, mediaI18NStringArray[i2]);
            }
        }
    }

    public static MediaI18NString getOptionalMediaI18NString(IDeserializer iDeserializer) {
        MediaI18NString mediaI18NString = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            mediaI18NString = new MediaI18NString();
            mediaI18NString.i18nKey = n = iDeserializer.getInt32();
            mediaI18NString.name = string = iDeserializer.getOptionalString();
        }
        return mediaI18NString;
    }

    public static MediaI18NString[] getOptionalMediaI18NStringVarArray(IDeserializer iDeserializer) {
        MediaI18NString[] mediaI18NStringArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaI18NStringArray = new MediaI18NString[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaI18NStringArray[i2] = MediaI18NStringSerializer.getOptionalMediaI18NString(iDeserializer);
            }
        }
        return mediaI18NStringArray;
    }
}

