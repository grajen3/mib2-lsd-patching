/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PoiListElement;

public class PoiListElementSerializer {
    public static void putOptionalPoiListElement(ISerializer iSerializer, PoiListElement poiListElement) {
        boolean bl = poiListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = poiListElement.getPoiUniqueId();
            iSerializer.putInt64(l);
            int n = poiListElement.getCriteriaNumber();
            iSerializer.putInt32(n);
            NavLocationWgs84 navLocationWgs84 = poiListElement.getPosition();
            NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
            String string = poiListElement.getCountryAbbreviation();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalPoiListElementVarArray(ISerializer iSerializer, PoiListElement[] poiListElementArray) {
        boolean bl = poiListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(poiListElementArray.length);
            for (int i2 = 0; i2 < poiListElementArray.length; ++i2) {
                PoiListElementSerializer.putOptionalPoiListElement(iSerializer, poiListElementArray[i2]);
            }
        }
    }

    public static PoiListElement getOptionalPoiListElement(IDeserializer iDeserializer) {
        PoiListElement poiListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            NavLocationWgs84 navLocationWgs84;
            int n;
            long l;
            poiListElement = new PoiListElement();
            poiListElement.poiUniqueId = l = iDeserializer.getInt64();
            poiListElement.criteriaNumber = n = iDeserializer.getInt32();
            poiListElement.position = navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
            poiListElement.countryAbbreviation = string = iDeserializer.getOptionalString();
        }
        return poiListElement;
    }

    public static PoiListElement[] getOptionalPoiListElementVarArray(IDeserializer iDeserializer) {
        PoiListElement[] poiListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            poiListElementArray = new PoiListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                poiListElementArray[i2] = PoiListElementSerializer.getOptionalPoiListElement(iDeserializer);
            }
        }
        return poiListElementArray;
    }
}

