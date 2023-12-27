/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.PersonalData;

public class PersonalDataSerializer {
    public static void putOptionalPersonalData(ISerializer iSerializer, PersonalData personalData) {
        boolean bl = personalData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = personalData.getLastName();
            iSerializer.putOptionalString(string);
            String string2 = personalData.getLastNameSound();
            iSerializer.putOptionalString(string2);
            String string3 = personalData.getFirstName();
            iSerializer.putOptionalString(string3);
            String string4 = personalData.getFirstNameSound();
            iSerializer.putOptionalString(string4);
            DateTime dateTime = personalData.getBirthday();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            String string5 = personalData.getOrganization();
            iSerializer.putOptionalString(string5);
            String string6 = personalData.getOrganizationSound();
            iSerializer.putOptionalString(string6);
            ResourceLocator resourceLocator = personalData.getContactPicture();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalPersonalDataVarArray(ISerializer iSerializer, PersonalData[] personalDataArray) {
        boolean bl = personalDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(personalDataArray.length);
            for (int i2 = 0; i2 < personalDataArray.length; ++i2) {
                PersonalDataSerializer.putOptionalPersonalData(iSerializer, personalDataArray[i2]);
            }
        }
    }

    public static PersonalData getOptionalPersonalData(IDeserializer iDeserializer) {
        PersonalData personalData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            String string;
            String string2;
            DateTime dateTime;
            String string3;
            String string4;
            String string5;
            String string6;
            personalData = new PersonalData();
            personalData.lastName = string6 = iDeserializer.getOptionalString();
            personalData.lastNameSound = string5 = iDeserializer.getOptionalString();
            personalData.firstName = string4 = iDeserializer.getOptionalString();
            personalData.firstNameSound = string3 = iDeserializer.getOptionalString();
            personalData.birthday = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            personalData.organization = string2 = iDeserializer.getOptionalString();
            personalData.organizationSound = string = iDeserializer.getOptionalString();
            personalData.contactPicture = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return personalData;
    }

    public static PersonalData[] getOptionalPersonalDataVarArray(IDeserializer iDeserializer) {
        PersonalData[] personalDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            personalDataArray = new PersonalData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                personalDataArray[i2] = PersonalDataSerializer.getOptionalPersonalData(iDeserializer);
            }
        }
        return personalDataArray;
    }
}

