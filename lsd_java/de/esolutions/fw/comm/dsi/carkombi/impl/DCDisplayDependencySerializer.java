/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCDisplayDependency;

public class DCDisplayDependencySerializer {
    public static void putOptionalDCDisplayDependency(ISerializer iSerializer, DCDisplayDependency dCDisplayDependency) {
        boolean bl = dCDisplayDependency == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = dCDisplayDependency.isDrivingProfile();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalDCDisplayDependencyVarArray(ISerializer iSerializer, DCDisplayDependency[] dCDisplayDependencyArray) {
        boolean bl = dCDisplayDependencyArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCDisplayDependencyArray.length);
            for (int i2 = 0; i2 < dCDisplayDependencyArray.length; ++i2) {
                DCDisplayDependencySerializer.putOptionalDCDisplayDependency(iSerializer, dCDisplayDependencyArray[i2]);
            }
        }
    }

    public static DCDisplayDependency getOptionalDCDisplayDependency(IDeserializer iDeserializer) {
        DCDisplayDependency dCDisplayDependency = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            dCDisplayDependency = new DCDisplayDependency();
            dCDisplayDependency.drivingProfile = bl2 = iDeserializer.getBool();
        }
        return dCDisplayDependency;
    }

    public static DCDisplayDependency[] getOptionalDCDisplayDependencyVarArray(IDeserializer iDeserializer) {
        DCDisplayDependency[] dCDisplayDependencyArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCDisplayDependencyArray = new DCDisplayDependency[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCDisplayDependencyArray[i2] = DCDisplayDependencySerializer.getOptionalDCDisplayDependency(iDeserializer);
            }
        }
        return dCDisplayDependencyArray;
    }
}

