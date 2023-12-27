/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.online.common.destinationimport;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.online.PortalAddressData;
import org.dsi.ifc.online.PortalLocation;
import org.dsi.ifc.online.PortalMessagingData;
import org.dsi.ifc.online.PortalNavigationData;
import org.dsi.ifc.online.PortalPersonalData;
import org.dsi.ifc.online.PortalPhoneData;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public final class AddressEntry
extends AdbEntry {
    public AddressEntry() {
        this.init();
    }

    void init() {
        this.entryId = 0L;
        this.entryType = 0;
        this.combinedName = null;
        this.preferredNumberIdx = 0;
        this.voiceTagId = 0;
        this.phoneData = null;
        this.addressData = null;
        this.emailData = null;
        this.urlData = null;
        this.personalData = null;
        this.referenceId = null;
    }

    public AdbEntry mapPortalAddressEntry(PortalADBEntry portalADBEntry) {
        if (portalADBEntry != null) {
            this.entryId = 0L;
            this.entryType = (int)portalADBEntry.entryType;
            this.combinedName = null;
            this.preferredNumberIdx = portalADBEntry.preferedNumber;
            this.voiceTagId = portalADBEntry.voiceTagID;
            this.phoneData = this.getPhonedata(portalADBEntry.phoneData);
            this.addressData = this.getAddressdata(portalADBEntry.addressData, portalADBEntry.navigationData);
            this.urlData = null;
            this.emailData = this.getEmailData(portalADBEntry.messagingData, this.urlData);
            this.personalData = this.getPersonalData(portalADBEntry.personalData);
            this.referenceId = null;
            return this;
        }
        return null;
    }

    private PersonalData getPersonalData(PortalPersonalData portalPersonalData) {
        PersonalData personalData = null;
        if (portalPersonalData != null) {
            personalData = new PersonalData();
            personalData.lastName = portalPersonalData.lastName;
            personalData.lastNameSound = portalPersonalData.lastNameSnd;
            personalData.firstName = portalPersonalData.firstName;
            personalData.firstNameSound = portalPersonalData.firstNameSnd;
            personalData.organization = portalPersonalData.organizationName;
        }
        return personalData;
    }

    private EmailData[] getEmailData(PortalMessagingData[] portalMessagingDataArray, String[] stringArray) {
        EmailData[] emailDataArray = null;
        if (!Util.isNullOrEmpty(portalMessagingDataArray)) {
            int n = portalMessagingDataArray.length;
            emailDataArray = new EmailData[n];
            stringArray = new String[n];
            for (int i2 = 0; i2 < n; ++i2) {
                emailDataArray[i2] = new EmailData();
                stringArray[i2] = new String();
                emailDataArray[i2].emailAddr = portalMessagingDataArray[i2].email;
                emailDataArray[i2].emailType = (int)portalMessagingDataArray[i2].messageType;
                stringArray[i2] = portalMessagingDataArray[i2].url;
            }
        }
        return null;
    }

    private AddressData[] getAddressdata(PortalAddressData[] portalAddressDataArray, PortalNavigationData[] portalNavigationDataArray) {
        AddressData[] addressDataArray = null;
        if (!Util.isNullOrEmpty(portalAddressDataArray)) {
            int n = portalAddressDataArray.length;
            addressDataArray = new AddressData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                addressDataArray[i2] = new AddressData();
                addressDataArray[i2].addressType = (int)portalAddressDataArray[i2].addressType;
                addressDataArray[i2].country = portalAddressDataArray[i2].country;
                addressDataArray[i2].locality = portalAddressDataArray[i2].locality;
                addressDataArray[i2].postalCode = portalAddressDataArray[i2].postalCode;
                addressDataArray[i2].region = portalAddressDataArray[i2].region;
                addressDataArray[i2].street = portalAddressDataArray[i2].street;
                addressDataArray[i2].geoPosition = Util.isNullOrEmpty(portalNavigationDataArray) ? "" : this.convertGeoPositionFormat(portalNavigationDataArray[i2]);
            }
        }
        return addressDataArray;
    }

    private PhoneData[] getPhonedata(PortalPhoneData[] portalPhoneDataArray) {
        PhoneData[] phoneDataArray = null;
        if (!Util.isNullOrEmpty(portalPhoneDataArray)) {
            int n = portalPhoneDataArray.length;
            phoneDataArray = new PhoneData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                phoneDataArray[i2] = new PhoneData();
                phoneDataArray[i2].number = portalPhoneDataArray[i2].number;
                phoneDataArray[i2].numberType = (int)portalPhoneDataArray[i2].type;
            }
        }
        return phoneDataArray;
    }

    private String convertGeoPositionFormat(PortalNavigationData portalNavigationData) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append("AddressEntry.convertGeoPositionFormat( ").append(portalNavigationData != null ? portalNavigationData.toString() : "NULL").append(" )").log();
        }
        object = null;
        if (portalNavigationData != null) {
            int n = 1078071040;
            int n2 = 59;
            int n3 = 44;
            PortalLocation portalLocation = portalNavigationData.getNaviLocation();
            if (portalNavigationData.geoPosition != null && portalNavigationData.geoPosition.length() > 0) {
                int n4;
                if (portalNavigationData.geoPosition.indexOf(46) > -1) {
                    object = portalNavigationData.getGeoPosition();
                } else if (portalNavigationData.geoPosition.indexOf(n2) > -1) {
                    n4 = Integer.parseInt(portalNavigationData.geoPosition.substring(0, portalNavigationData.geoPosition.indexOf(n2)));
                    int n5 = Integer.parseInt(portalNavigationData.geoPosition.substring(portalNavigationData.geoPosition.indexOf(n2) + 1));
                    double d2 = (double)n4 / 1000000.0;
                    double d3 = (double)n5 / 1000000.0;
                    object = new StringBuffer().append(Double.toString((double)d2)).append(";").append(Double.toString((double)d3)).toString();
                } else if (portalNavigationData.geoPosition.indexOf(n3) > -1) {
                    n4 = Integer.parseInt(portalNavigationData.geoPosition.substring(0, portalNavigationData.geoPosition.indexOf(n3)));
                    int n6 = Integer.parseInt(portalNavigationData.geoPosition.substring(portalNavigationData.geoPosition.indexOf(n3) + 1));
                    double d4 = (double)n4 / 1000000.0;
                    double d5 = (double)n6 / 1000000.0;
                    object = new StringBuffer().append(Double.toString((double)d4)).append(",").append(Double.toString((double)d5)).toString();
                }
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger2.trace(16384);
                    logMessage.append("AddressEntry.convertGeoPositionFormat( ").append(portalNavigationData.geoPosition).append(") -> ").append((String)(object != null ? object : "NULL")).log();
                }
            } else if (portalLocation != null && portalLocation.getLatitude() > 0 && portalLocation.getLongitude() > 0) {
                double d6 = (double)portalLocation.getLatitude() / 1000000.0;
                double d7 = (double)portalLocation.getLongitude() / 1000000.0;
                object = new StringBuffer().append(Double.toString((double)d6)).append(";").append(Double.toString((double)d7)).toString();
                if (ServiceManager.logger2.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger2.trace(16384);
                    logMessage.append(" Latitude -> ").append(portalLocation.getLatitude()).append(" Logitude -> ").append(portalLocation.getLongitude()).append(" GeoPosition -> ").append((String)(object != null ? object : "NULL")).log();
                }
            }
        }
        return object;
    }
}

