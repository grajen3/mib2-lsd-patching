/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.organizer.impl.AddressDataSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.EmailDataSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.PersonalDataSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.PhoneDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class AdbEntrySerializer {
    public static void putOptionalAdbEntry(ISerializer iSerializer, AdbEntry adbEntry) {
        boolean bl = adbEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = adbEntry.getEntryId();
            iSerializer.putInt64(l);
            int n = adbEntry.getEntryType();
            iSerializer.putInt32(n);
            String string = adbEntry.getCombinedName();
            iSerializer.putOptionalString(string);
            int n2 = adbEntry.getPreferredNumberIdx();
            iSerializer.putInt32(n2);
            int n3 = adbEntry.getVoiceTagId();
            iSerializer.putInt32(n3);
            PhoneData[] phoneDataArray = adbEntry.getPhoneData();
            PhoneDataSerializer.putOptionalPhoneDataVarArray(iSerializer, phoneDataArray);
            AddressData[] addressDataArray = adbEntry.getAddressData();
            AddressDataSerializer.putOptionalAddressDataVarArray(iSerializer, addressDataArray);
            EmailData[] emailDataArray = adbEntry.getEmailData();
            EmailDataSerializer.putOptionalEmailDataVarArray(iSerializer, emailDataArray);
            String[] stringArray = adbEntry.getUrlData();
            iSerializer.putOptionalStringVarArray(stringArray);
            PersonalData personalData = adbEntry.getPersonalData();
            PersonalDataSerializer.putOptionalPersonalData(iSerializer, personalData);
            String string2 = adbEntry.getReferenceId();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalAdbEntryVarArray(ISerializer iSerializer, AdbEntry[] adbEntryArray) {
        boolean bl = adbEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(adbEntryArray.length);
            for (int i2 = 0; i2 < adbEntryArray.length; ++i2) {
                AdbEntrySerializer.putOptionalAdbEntry(iSerializer, adbEntryArray[i2]);
            }
        }
    }

    public static AdbEntry getOptionalAdbEntry(IDeserializer iDeserializer) {
        AdbEntry adbEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            PersonalData personalData;
            int n;
            int n2;
            String string2;
            int n3;
            long l;
            adbEntry = new AdbEntry();
            adbEntry.entryId = l = iDeserializer.getInt64();
            adbEntry.entryType = n3 = iDeserializer.getInt32();
            adbEntry.combinedName = string2 = iDeserializer.getOptionalString();
            adbEntry.preferredNumberIdx = n2 = iDeserializer.getInt32();
            adbEntry.voiceTagId = n = iDeserializer.getInt32();
            PhoneData[] phoneDataArray = PhoneDataSerializer.getOptionalPhoneDataVarArray(iDeserializer);
            adbEntry.phoneData = phoneDataArray;
            AddressData[] addressDataArray = AddressDataSerializer.getOptionalAddressDataVarArray(iDeserializer);
            adbEntry.addressData = addressDataArray;
            EmailData[] emailDataArray = EmailDataSerializer.getOptionalEmailDataVarArray(iDeserializer);
            adbEntry.emailData = emailDataArray;
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            adbEntry.urlData = stringArray;
            adbEntry.personalData = personalData = PersonalDataSerializer.getOptionalPersonalData(iDeserializer);
            adbEntry.referenceId = string = iDeserializer.getOptionalString();
        }
        return adbEntry;
    }

    public static AdbEntry[] getOptionalAdbEntryVarArray(IDeserializer iDeserializer) {
        AdbEntry[] adbEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            adbEntryArray = new AdbEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                adbEntryArray[i2] = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
            }
        }
        return adbEntryArray;
    }
}

