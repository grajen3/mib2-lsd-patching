/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes.impl;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvPointList;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

public class RdvPointListSerializer {
    public static void putOptionalRdvPointList(ISerializer iSerializer, RdvPointList rdvPointList) {
        boolean bl = rdvPointList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavLocationWgs84[] navLocationWgs84Array = rdvPointList.getPoints();
            NavLocationWgs84Serializer.putOptionalNavLocationWgs84VarArray(iSerializer, navLocationWgs84Array);
        }
    }

    public static void putOptionalRdvPointListVarArray(ISerializer iSerializer, RdvPointList[] rdvPointListArray) {
        boolean bl = rdvPointListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rdvPointListArray.length);
            for (int i2 = 0; i2 < rdvPointListArray.length; ++i2) {
                RdvPointListSerializer.putOptionalRdvPointList(iSerializer, rdvPointListArray[i2]);
            }
        }
    }

    public static RdvPointList getOptionalRdvPointList(IDeserializer iDeserializer) {
        RdvPointList rdvPointList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            rdvPointList = new RdvPointList();
            NavLocationWgs84[] navLocationWgs84Array = NavLocationWgs84Serializer.getOptionalNavLocationWgs84VarArray(iDeserializer);
            rdvPointList.points = navLocationWgs84Array;
        }
        return rdvPointList;
    }

    public static RdvPointList[] getOptionalRdvPointListVarArray(IDeserializer iDeserializer) {
        RdvPointList[] rdvPointListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rdvPointListArray = new RdvPointList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rdvPointListArray[i2] = RdvPointListSerializer.getOptionalRdvPointList(iDeserializer);
            }
        }
        return rdvPointListArray;
    }
}

