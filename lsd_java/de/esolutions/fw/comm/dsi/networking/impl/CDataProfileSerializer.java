/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.CDataProfile;

public class CDataProfileSerializer {
    public static void putOptionalCDataProfile(ISerializer iSerializer, CDataProfile cDataProfile) {
        boolean bl = cDataProfile == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = cDataProfile.getProfileID();
            iSerializer.putInt32(n);
            String string = cDataProfile.getDataProfileName();
            iSerializer.putOptionalString(string);
            String string2 = cDataProfile.getDataAPN();
            iSerializer.putOptionalString(string2);
            String string3 = cDataProfile.getDataUserName();
            iSerializer.putOptionalString(string3);
            String string4 = cDataProfile.getDataPassword();
            iSerializer.putOptionalString(string4);
            int n2 = cDataProfile.getDataAuthentication();
            iSerializer.putInt32(n2);
            String string5 = cDataProfile.getProvider();
            iSerializer.putOptionalString(string5);
            boolean bl2 = cDataProfile.isIsAPNvisible();
            iSerializer.putBool(bl2);
            String string6 = cDataProfile.getDataAPN2();
            iSerializer.putOptionalString(string6);
            String string7 = cDataProfile.getDataUserName2();
            iSerializer.putOptionalString(string7);
            String string8 = cDataProfile.getDataPassword2();
            iSerializer.putOptionalString(string8);
            boolean bl3 = cDataProfile.isIsAPN2visible();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalCDataProfileVarArray(ISerializer iSerializer, CDataProfile[] cDataProfileArray) {
        boolean bl = cDataProfileArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(cDataProfileArray.length);
            for (int i2 = 0; i2 < cDataProfileArray.length; ++i2) {
                CDataProfileSerializer.putOptionalCDataProfile(iSerializer, cDataProfileArray[i2]);
            }
        }
    }

    public static CDataProfile getOptionalCDataProfile(IDeserializer iDeserializer) {
        CDataProfile cDataProfile = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            String string3;
            boolean bl3;
            String string4;
            int n;
            String string5;
            String string6;
            String string7;
            String string8;
            int n2;
            cDataProfile = new CDataProfile();
            cDataProfile.profileID = n2 = iDeserializer.getInt32();
            cDataProfile.dataProfileName = string8 = iDeserializer.getOptionalString();
            cDataProfile.dataAPN = string7 = iDeserializer.getOptionalString();
            cDataProfile.dataUserName = string6 = iDeserializer.getOptionalString();
            cDataProfile.dataPassword = string5 = iDeserializer.getOptionalString();
            cDataProfile.dataAuthentication = n = iDeserializer.getInt32();
            cDataProfile.provider = string4 = iDeserializer.getOptionalString();
            cDataProfile.isAPNvisible = bl3 = iDeserializer.getBool();
            cDataProfile.dataAPN2 = string3 = iDeserializer.getOptionalString();
            cDataProfile.dataUserName2 = string2 = iDeserializer.getOptionalString();
            cDataProfile.dataPassword2 = string = iDeserializer.getOptionalString();
            cDataProfile.isAPN2visible = bl2 = iDeserializer.getBool();
        }
        return cDataProfile;
    }

    public static CDataProfile[] getOptionalCDataProfileVarArray(IDeserializer iDeserializer) {
        CDataProfile[] cDataProfileArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            cDataProfileArray = new CDataProfile[n];
            for (int i2 = 0; i2 < n; ++i2) {
                cDataProfileArray[i2] = CDataProfileSerializer.getOptionalCDataProfile(iDeserializer);
            }
        }
        return cDataProfileArray;
    }
}

