/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.VDECapabilities;

public class VDECapabilitiesSerializer {
    public static void putOptionalVDECapabilities(ISerializer iSerializer, VDECapabilities vDECapabilities) {
        boolean bl = vDECapabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = vDECapabilities.getCountryAbbreviation();
            iSerializer.putOptionalString(string);
            boolean bl2 = vDECapabilities.isOneShot();
            iSerializer.putBool(bl2);
            boolean bl3 = vDECapabilities.isFullWord();
            iSerializer.putBool(bl3);
            boolean bl4 = vDECapabilities.isSpelling();
            iSerializer.putBool(bl4);
            boolean bl5 = vDECapabilities.isPoiFuzzy();
            iSerializer.putBool(bl5);
            boolean bl6 = vDECapabilities.isFlexVDE();
            iSerializer.putBool(bl6);
            String[] stringArray = vDECapabilities.getGrammarLanguage();
            iSerializer.putOptionalStringVarArray(stringArray);
            String[] stringArray2 = vDECapabilities.getFlexVDELanguage();
            iSerializer.putOptionalStringVarArray(stringArray2);
        }
    }

    public static void putOptionalVDECapabilitiesVarArray(ISerializer iSerializer, VDECapabilities[] vDECapabilitiesArray) {
        boolean bl = vDECapabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vDECapabilitiesArray.length);
            for (int i2 = 0; i2 < vDECapabilitiesArray.length; ++i2) {
                VDECapabilitiesSerializer.putOptionalVDECapabilities(iSerializer, vDECapabilitiesArray[i2]);
            }
        }
    }

    public static VDECapabilities getOptionalVDECapabilities(IDeserializer iDeserializer) {
        VDECapabilities vDECapabilities = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            String string;
            vDECapabilities = new VDECapabilities();
            vDECapabilities.countryAbbreviation = string = iDeserializer.getOptionalString();
            vDECapabilities.oneShot = bl6 = iDeserializer.getBool();
            vDECapabilities.fullWord = bl5 = iDeserializer.getBool();
            vDECapabilities.spelling = bl4 = iDeserializer.getBool();
            vDECapabilities.poiFuzzy = bl3 = iDeserializer.getBool();
            vDECapabilities.flexVDE = bl2 = iDeserializer.getBool();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            vDECapabilities.grammarLanguage = stringArray;
            String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
            vDECapabilities.flexVDELanguage = stringArray2;
        }
        return vDECapabilities;
    }

    public static VDECapabilities[] getOptionalVDECapabilitiesVarArray(IDeserializer iDeserializer) {
        VDECapabilities[] vDECapabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vDECapabilitiesArray = new VDECapabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vDECapabilitiesArray[i2] = VDECapabilitiesSerializer.getOptionalVDECapabilities(iDeserializer);
            }
        }
        return vDECapabilitiesArray;
    }
}

