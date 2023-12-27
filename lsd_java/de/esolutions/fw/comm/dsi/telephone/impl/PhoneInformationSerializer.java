/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.PhoneInformation;

public class PhoneInformationSerializer {
    public static void putOptionalPhoneInformation(ISerializer iSerializer, PhoneInformation phoneInformation) {
        boolean bl = phoneInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = phoneInformation.getImsi();
            iSerializer.putOptionalString(string);
            String string2 = phoneInformation.getSimId();
            iSerializer.putOptionalString(string2);
            String string3 = phoneInformation.getNadIMEI();
            iSerializer.putOptionalString(string3);
            String string4 = phoneInformation.getMeIMEI();
            iSerializer.putOptionalString(string4);
            String string5 = phoneInformation.getMeBtAddress();
            iSerializer.putOptionalString(string5);
            String string6 = phoneInformation.getMeFriendlyName();
            iSerializer.putOptionalString(string6);
            int n = phoneInformation.getTelNetIdAvailIMSI();
            iSerializer.putInt32(n);
            int n2 = phoneInformation.getTelNetIdAvailSimId();
            iSerializer.putInt32(n2);
            int n3 = phoneInformation.getTelNetIdAvailNadIMEI();
            iSerializer.putInt32(n3);
            int n4 = phoneInformation.getTelNetIdAvailMeIMEI();
            iSerializer.putInt32(n4);
            int n5 = phoneInformation.getTelNetIdAvailMeBtAddress();
            iSerializer.putInt32(n5);
            int n6 = phoneInformation.getTelNetIdAvailMeFriendlyName();
            iSerializer.putInt32(n6);
            String string7 = phoneInformation.getSimName();
            iSerializer.putOptionalString(string7);
        }
    }

    public static void putOptionalPhoneInformationVarArray(ISerializer iSerializer, PhoneInformation[] phoneInformationArray) {
        boolean bl = phoneInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(phoneInformationArray.length);
            for (int i2 = 0; i2 < phoneInformationArray.length; ++i2) {
                PhoneInformationSerializer.putOptionalPhoneInformation(iSerializer, phoneInformationArray[i2]);
            }
        }
    }

    public static PhoneInformation getOptionalPhoneInformation(IDeserializer iDeserializer) {
        PhoneInformation phoneInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            phoneInformation = new PhoneInformation();
            phoneInformation.imsi = string7 = iDeserializer.getOptionalString();
            phoneInformation.simId = string6 = iDeserializer.getOptionalString();
            phoneInformation.nadIMEI = string5 = iDeserializer.getOptionalString();
            phoneInformation.meIMEI = string4 = iDeserializer.getOptionalString();
            phoneInformation.meBtAddress = string3 = iDeserializer.getOptionalString();
            phoneInformation.meFriendlyName = string2 = iDeserializer.getOptionalString();
            phoneInformation.telNetIdAvailIMSI = n6 = iDeserializer.getInt32();
            phoneInformation.telNetIdAvailSimId = n5 = iDeserializer.getInt32();
            phoneInformation.telNetIdAvailNadIMEI = n4 = iDeserializer.getInt32();
            phoneInformation.telNetIdAvailMeIMEI = n3 = iDeserializer.getInt32();
            phoneInformation.telNetIdAvailMeBtAddress = n2 = iDeserializer.getInt32();
            phoneInformation.telNetIdAvailMeFriendlyName = n = iDeserializer.getInt32();
            phoneInformation.simName = string = iDeserializer.getOptionalString();
        }
        return phoneInformation;
    }

    public static PhoneInformation[] getOptionalPhoneInformationVarArray(IDeserializer iDeserializer) {
        PhoneInformation[] phoneInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            phoneInformationArray = new PhoneInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                phoneInformationArray[i2] = PhoneInformationSerializer.getOptionalPhoneInformation(iDeserializer);
            }
        }
        return phoneInformationArray;
    }
}

