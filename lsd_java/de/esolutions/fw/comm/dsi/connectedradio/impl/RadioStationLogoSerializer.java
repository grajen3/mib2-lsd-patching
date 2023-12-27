/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.connectedradio.RadioStationLogo;
import org.dsi.ifc.global.ResourceLocator;

public class RadioStationLogoSerializer {
    public static void putOptionalRadioStationLogo(ISerializer iSerializer, RadioStationLogo radioStationLogo) {
        boolean bl = radioStationLogo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = radioStationLogo.getWidth();
            iSerializer.putInt32(n);
            int n2 = radioStationLogo.getHeight();
            iSerializer.putInt32(n2);
            ResourceLocator resourceLocator = radioStationLogo.getPathToFile();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalRadioStationLogoVarArray(ISerializer iSerializer, RadioStationLogo[] radioStationLogoArray) {
        boolean bl = radioStationLogoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationLogoArray.length);
            for (int i2 = 0; i2 < radioStationLogoArray.length; ++i2) {
                RadioStationLogoSerializer.putOptionalRadioStationLogo(iSerializer, radioStationLogoArray[i2]);
            }
        }
    }

    public static RadioStationLogo getOptionalRadioStationLogo(IDeserializer iDeserializer) {
        RadioStationLogo radioStationLogo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            int n;
            int n2;
            radioStationLogo = new RadioStationLogo();
            radioStationLogo.width = n2 = iDeserializer.getInt32();
            radioStationLogo.height = n = iDeserializer.getInt32();
            radioStationLogo.pathToFile = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return radioStationLogo;
    }

    public static RadioStationLogo[] getOptionalRadioStationLogoVarArray(IDeserializer iDeserializer) {
        RadioStationLogo[] radioStationLogoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationLogoArray = new RadioStationLogo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationLogoArray[i2] = RadioStationLogoSerializer.getOptionalRadioStationLogo(iDeserializer);
            }
        }
        return radioStationLogoArray;
    }
}

