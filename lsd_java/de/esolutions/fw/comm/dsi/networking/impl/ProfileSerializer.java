/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.Profile;

public class ProfileSerializer {
    public static void putOptionalProfile(ISerializer iSerializer, Profile profile) {
        boolean bl = profile == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = profile.getIdentifier();
            iSerializer.putInt32(n);
            String string = profile.getName();
            iSerializer.putOptionalString(string);
            String[] stringArray = profile.getKeys();
            iSerializer.putOptionalStringVarArray(stringArray);
            short s = profile.getKeyNumber();
            iSerializer.putInt16(s);
            boolean bl2 = profile.isSSIDBroadcast();
            iSerializer.putBool(bl2);
            String string2 = profile.getSSID();
            iSerializer.putOptionalString(string2);
            int n2 = profile.getCryptoModel();
            iSerializer.putInt32(n2);
            int n3 = profile.getAuthenticationModel();
            iSerializer.putInt32(n3);
            boolean bl3 = profile.isActive();
            iSerializer.putBool(bl3);
            int n4 = profile.getChannel();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalProfileVarArray(ISerializer iSerializer, Profile[] profileArray) {
        boolean bl = profileArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(profileArray.length);
            for (int i2 = 0; i2 < profileArray.length; ++i2) {
                ProfileSerializer.putOptionalProfile(iSerializer, profileArray[i2]);
            }
        }
    }

    public static Profile getOptionalProfile(IDeserializer iDeserializer) {
        Profile profile = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            int n2;
            int n3;
            String string;
            boolean bl3;
            short s;
            String string2;
            int n4;
            profile = new Profile();
            profile.identifier = n4 = iDeserializer.getInt32();
            profile.name = string2 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            profile.keys = stringArray;
            profile.keyNumber = s = iDeserializer.getInt16();
            profile.sSIDBroadcast = bl3 = iDeserializer.getBool();
            profile.sSID = string = iDeserializer.getOptionalString();
            profile.cryptoModel = n3 = iDeserializer.getInt32();
            profile.authenticationModel = n2 = iDeserializer.getInt32();
            profile.active = bl2 = iDeserializer.getBool();
            profile.channel = n = iDeserializer.getInt32();
        }
        return profile;
    }

    public static Profile[] getOptionalProfileVarArray(IDeserializer iDeserializer) {
        Profile[] profileArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            profileArray = new Profile[n];
            for (int i2 = 0; i2 < n; ++i2) {
                profileArray[i2] = ProfileSerializer.getOptionalProfile(iDeserializer);
            }
        }
        return profileArray;
    }
}

