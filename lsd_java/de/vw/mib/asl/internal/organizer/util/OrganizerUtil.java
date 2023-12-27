/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.organizer.util;

import java.util.Arrays;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public final class OrganizerUtil {
    public static final int MAX_ADDRESSES;
    public static final int MAX_PHONE_NUMBERS;

    private OrganizerUtil() {
    }

    public static AdbEntry createNewEntry() {
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.personalData = new PersonalData();
        adbEntry.personalData.contactPicture = new ResourceLocator();
        adbEntry.personalData.birthday = new DateTime();
        adbEntry.personalData.firstName = "";
        adbEntry.personalData.lastName = "";
        adbEntry.personalData.lastNameSound = "";
        adbEntry.personalData.organization = "";
        adbEntry.personalData.organizationSound = "";
        adbEntry.addressData = new AddressData[2];
        Arrays.fill(adbEntry.addressData, new AddressData());
        adbEntry.phoneData = new PhoneData[5];
        Arrays.fill(adbEntry.phoneData, new PhoneData());
        adbEntry.urlData = new String[0];
        adbEntry.emailData = new EmailData[0];
        return adbEntry;
    }
}

