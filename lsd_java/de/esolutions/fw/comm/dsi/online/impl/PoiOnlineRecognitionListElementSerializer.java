/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PoiOnlineRecognitionListElement;

public class PoiOnlineRecognitionListElementSerializer {
    public static void putOptionalPoiOnlineRecognitionListElement(ISerializer iSerializer, PoiOnlineRecognitionListElement poiOnlineRecognitionListElement) {
        boolean bl = poiOnlineRecognitionListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = poiOnlineRecognitionListElement.getRecognizedTerm();
            iSerializer.putOptionalString(string);
            float f2 = poiOnlineRecognitionListElement.getConfidenceLevel();
            iSerializer.putFloat(f2);
        }
    }

    public static void putOptionalPoiOnlineRecognitionListElementVarArray(ISerializer iSerializer, PoiOnlineRecognitionListElement[] poiOnlineRecognitionListElementArray) {
        boolean bl = poiOnlineRecognitionListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(poiOnlineRecognitionListElementArray.length);
            for (int i2 = 0; i2 < poiOnlineRecognitionListElementArray.length; ++i2) {
                PoiOnlineRecognitionListElementSerializer.putOptionalPoiOnlineRecognitionListElement(iSerializer, poiOnlineRecognitionListElementArray[i2]);
            }
        }
    }

    public static PoiOnlineRecognitionListElement getOptionalPoiOnlineRecognitionListElement(IDeserializer iDeserializer) {
        PoiOnlineRecognitionListElement poiOnlineRecognitionListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            String string;
            poiOnlineRecognitionListElement = new PoiOnlineRecognitionListElement();
            poiOnlineRecognitionListElement.recognizedTerm = string = iDeserializer.getOptionalString();
            poiOnlineRecognitionListElement.confidenceLevel = f2 = iDeserializer.getFloat();
        }
        return poiOnlineRecognitionListElement;
    }

    public static PoiOnlineRecognitionListElement[] getOptionalPoiOnlineRecognitionListElementVarArray(IDeserializer iDeserializer) {
        PoiOnlineRecognitionListElement[] poiOnlineRecognitionListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            poiOnlineRecognitionListElementArray = new PoiOnlineRecognitionListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                poiOnlineRecognitionListElementArray[i2] = PoiOnlineRecognitionListElementSerializer.getOptionalPoiOnlineRecognitionListElement(iDeserializer);
            }
        }
        return poiOnlineRecognitionListElementArray;
    }
}

