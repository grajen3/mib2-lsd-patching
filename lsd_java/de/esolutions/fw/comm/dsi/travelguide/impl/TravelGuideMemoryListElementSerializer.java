/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public class TravelGuideMemoryListElementSerializer {
    public static void putOptionalTravelGuideMemoryListElement(ISerializer iSerializer, TravelGuideMemoryListElement travelGuideMemoryListElement) {
        boolean bl = travelGuideMemoryListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = travelGuideMemoryListElement.getUID();
            iSerializer.putInt64(l);
            ResourceLocator resourceLocator = travelGuideMemoryListElement.getIcon();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            String string = travelGuideMemoryListElement.getTitle();
            iSerializer.putOptionalString(string);
            int n = travelGuideMemoryListElement.getStatus();
            iSerializer.putInt32(n);
            int n2 = travelGuideMemoryListElement.getProgress();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalTravelGuideMemoryListElementVarArray(ISerializer iSerializer, TravelGuideMemoryListElement[] travelGuideMemoryListElementArray) {
        boolean bl = travelGuideMemoryListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(travelGuideMemoryListElementArray.length);
            for (int i2 = 0; i2 < travelGuideMemoryListElementArray.length; ++i2) {
                TravelGuideMemoryListElementSerializer.putOptionalTravelGuideMemoryListElement(iSerializer, travelGuideMemoryListElementArray[i2]);
            }
        }
    }

    public static TravelGuideMemoryListElement getOptionalTravelGuideMemoryListElement(IDeserializer iDeserializer) {
        TravelGuideMemoryListElement travelGuideMemoryListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            ResourceLocator resourceLocator;
            long l;
            travelGuideMemoryListElement = new TravelGuideMemoryListElement();
            travelGuideMemoryListElement.uID = l = iDeserializer.getInt64();
            travelGuideMemoryListElement.icon = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            travelGuideMemoryListElement.title = string = iDeserializer.getOptionalString();
            travelGuideMemoryListElement.status = n2 = iDeserializer.getInt32();
            travelGuideMemoryListElement.progress = n = iDeserializer.getInt32();
        }
        return travelGuideMemoryListElement;
    }

    public static TravelGuideMemoryListElement[] getOptionalTravelGuideMemoryListElementVarArray(IDeserializer iDeserializer) {
        TravelGuideMemoryListElement[] travelGuideMemoryListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            travelGuideMemoryListElementArray = new TravelGuideMemoryListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                travelGuideMemoryListElementArray[i2] = TravelGuideMemoryListElementSerializer.getOptionalTravelGuideMemoryListElement(iDeserializer);
            }
        }
        return travelGuideMemoryListElementArray;
    }
}

