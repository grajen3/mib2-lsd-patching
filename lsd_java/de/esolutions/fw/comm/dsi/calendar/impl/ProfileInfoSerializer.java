/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.ProfileInfo;

public class ProfileInfoSerializer {
    public static void putOptionalProfileInfo(ISerializer iSerializer, ProfileInfo profileInfo) {
        boolean bl = profileInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = profileInfo.getNumProfile();
            iSerializer.putInt32(n);
            String string = profileInfo.getName();
            iSerializer.putOptionalString(string);
            long l = profileInfo.getHomeId();
            iSerializer.putInt64(l);
            String string2 = profileInfo.getPairingCode();
            iSerializer.putOptionalString(string2);
            boolean bl2 = profileInfo.isPublicProfileVisibility();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalProfileInfoVarArray(ISerializer iSerializer, ProfileInfo[] profileInfoArray) {
        boolean bl = profileInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(profileInfoArray.length);
            for (int i2 = 0; i2 < profileInfoArray.length; ++i2) {
                ProfileInfoSerializer.putOptionalProfileInfo(iSerializer, profileInfoArray[i2]);
            }
        }
    }

    public static ProfileInfo getOptionalProfileInfo(IDeserializer iDeserializer) {
        ProfileInfo profileInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            long l;
            String string2;
            int n;
            profileInfo = new ProfileInfo();
            profileInfo.numProfile = n = iDeserializer.getInt32();
            profileInfo.name = string2 = iDeserializer.getOptionalString();
            profileInfo.homeId = l = iDeserializer.getInt64();
            profileInfo.pairingCode = string = iDeserializer.getOptionalString();
            profileInfo.publicProfileVisibility = bl2 = iDeserializer.getBool();
        }
        return profileInfo;
    }

    public static ProfileInfo[] getOptionalProfileInfoVarArray(IDeserializer iDeserializer) {
        ProfileInfo[] profileInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            profileInfoArray = new ProfileInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                profileInfoArray[i2] = ProfileInfoSerializer.getOptionalProfileInfo(iDeserializer);
            }
        }
        return profileInfoArray;
    }
}

