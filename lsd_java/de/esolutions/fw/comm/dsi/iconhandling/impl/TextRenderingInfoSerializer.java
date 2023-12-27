/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.iconhandling.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class TextRenderingInfoSerializer {
    public static void putOptionalTextRenderingInfo(ISerializer iSerializer, TextRenderingInfo textRenderingInfo) {
        boolean bl = textRenderingInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = textRenderingInfo.getFontReference();
            iSerializer.putInt32(n);
            int n2 = textRenderingInfo.getFontSize();
            iSerializer.putInt32(n2);
            int n3 = textRenderingInfo.getFontColor();
            iSerializer.putInt32(n3);
            int n4 = textRenderingInfo.getDeltaX();
            iSerializer.putInt32(n4);
            int n5 = textRenderingInfo.getDeltaY();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalTextRenderingInfoVarArray(ISerializer iSerializer, TextRenderingInfo[] textRenderingInfoArray) {
        boolean bl = textRenderingInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(textRenderingInfoArray.length);
            for (int i2 = 0; i2 < textRenderingInfoArray.length; ++i2) {
                TextRenderingInfoSerializer.putOptionalTextRenderingInfo(iSerializer, textRenderingInfoArray[i2]);
            }
        }
    }

    public static TextRenderingInfo getOptionalTextRenderingInfo(IDeserializer iDeserializer) {
        TextRenderingInfo textRenderingInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            textRenderingInfo = new TextRenderingInfo();
            textRenderingInfo.fontReference = n5 = iDeserializer.getInt32();
            textRenderingInfo.fontSize = n4 = iDeserializer.getInt32();
            textRenderingInfo.fontColor = n3 = iDeserializer.getInt32();
            textRenderingInfo.deltaX = n2 = iDeserializer.getInt32();
            textRenderingInfo.deltaY = n = iDeserializer.getInt32();
        }
        return textRenderingInfo;
    }

    public static TextRenderingInfo[] getOptionalTextRenderingInfoVarArray(IDeserializer iDeserializer) {
        TextRenderingInfo[] textRenderingInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            textRenderingInfoArray = new TextRenderingInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                textRenderingInfoArray[i2] = TextRenderingInfoSerializer.getOptionalTextRenderingInfo(iDeserializer);
            }
        }
        return textRenderingInfoArray;
    }
}

