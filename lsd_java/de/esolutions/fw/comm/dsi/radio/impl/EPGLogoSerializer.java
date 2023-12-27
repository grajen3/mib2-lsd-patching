/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.radio.impl.EPGLogoDescriptorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGLogoDescriptor;

public class EPGLogoSerializer {
    public static void putOptionalEPGLogo(ISerializer iSerializer, EPGLogo ePGLogo) {
        boolean bl = ePGLogo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = ePGLogo.getSID();
            iSerializer.putInt32(n);
            int n2 = ePGLogo.getEnsID();
            iSerializer.putInt32(n2);
            int n3 = ePGLogo.getEnsECC();
            iSerializer.putInt32(n3);
            int n4 = ePGLogo.getSCIDI();
            iSerializer.putInt32(n4);
            EPGLogoDescriptor[] ePGLogoDescriptorArray = ePGLogo.getEpgDescriptorList();
            EPGLogoDescriptorSerializer.putOptionalEPGLogoDescriptorVarArray(iSerializer, ePGLogoDescriptorArray);
        }
    }

    public static void putOptionalEPGLogoVarArray(ISerializer iSerializer, EPGLogo[] ePGLogoArray) {
        boolean bl = ePGLogoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGLogoArray.length);
            for (int i2 = 0; i2 < ePGLogoArray.length; ++i2) {
                EPGLogoSerializer.putOptionalEPGLogo(iSerializer, ePGLogoArray[i2]);
            }
        }
    }

    public static EPGLogo getOptionalEPGLogo(IDeserializer iDeserializer) {
        EPGLogo ePGLogo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            ePGLogo = new EPGLogo();
            ePGLogo.sID = n4 = iDeserializer.getInt32();
            ePGLogo.ensID = n3 = iDeserializer.getInt32();
            ePGLogo.ensECC = n2 = iDeserializer.getInt32();
            ePGLogo.sCIDI = n = iDeserializer.getInt32();
            EPGLogoDescriptor[] ePGLogoDescriptorArray = EPGLogoDescriptorSerializer.getOptionalEPGLogoDescriptorVarArray(iDeserializer);
            ePGLogo.epgDescriptorList = ePGLogoDescriptorArray;
        }
        return ePGLogo;
    }

    public static EPGLogo[] getOptionalEPGLogoVarArray(IDeserializer iDeserializer) {
        EPGLogo[] ePGLogoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGLogoArray = new EPGLogo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGLogoArray[i2] = EPGLogoSerializer.getOptionalEPGLogo(iDeserializer);
            }
        }
        return ePGLogoArray;
    }
}

