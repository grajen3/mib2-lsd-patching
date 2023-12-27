/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.PortalAddressDataSerializer;
import de.esolutions.fw.comm.dsi.online.impl.PortalMessagingDataSerializer;
import de.esolutions.fw.comm.dsi.online.impl.PortalNavigationDataSerializer;
import de.esolutions.fw.comm.dsi.online.impl.PortalPersonalDataSerializer;
import de.esolutions.fw.comm.dsi.online.impl.PortalPhoneDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.online.PortalAddressData;
import org.dsi.ifc.online.PortalMessagingData;
import org.dsi.ifc.online.PortalNavigationData;
import org.dsi.ifc.online.PortalPersonalData;
import org.dsi.ifc.online.PortalPhoneData;

public class PortalADBEntrySerializer {
    public static void putOptionalPortalADBEntry(ISerializer iSerializer, PortalADBEntry portalADBEntry) {
        boolean bl = portalADBEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = portalADBEntry.getEntryID();
            iSerializer.putInt64(l);
            long l2 = portalADBEntry.getEntryType();
            iSerializer.putInt64(l2);
            String string = portalADBEntry.getGeneralDescription();
            iSerializer.putOptionalString(string);
            String string2 = portalADBEntry.getAdditionalDescription();
            iSerializer.putOptionalString(string2);
            int n = portalADBEntry.getVoiceTagID();
            iSerializer.putInt32(n);
            int n2 = portalADBEntry.getPreferedNumber();
            iSerializer.putInt32(n2);
            long l3 = portalADBEntry.getOadbHashcode();
            iSerializer.putInt64(l3);
            long l4 = portalADBEntry.getInitialNoNavHashcode();
            iSerializer.putInt64(l4);
            PortalPersonalData portalPersonalData = portalADBEntry.getPersonalData();
            PortalPersonalDataSerializer.putOptionalPortalPersonalData(iSerializer, portalPersonalData);
            PortalPhoneData[] portalPhoneDataArray = portalADBEntry.getPhoneData();
            PortalPhoneDataSerializer.putOptionalPortalPhoneDataVarArray(iSerializer, portalPhoneDataArray);
            PortalAddressData[] portalAddressDataArray = portalADBEntry.getAddressData();
            PortalAddressDataSerializer.putOptionalPortalAddressDataVarArray(iSerializer, portalAddressDataArray);
            PortalNavigationData[] portalNavigationDataArray = portalADBEntry.getNavigationData();
            PortalNavigationDataSerializer.putOptionalPortalNavigationDataVarArray(iSerializer, portalNavigationDataArray);
            PortalMessagingData[] portalMessagingDataArray = portalADBEntry.getMessagingData();
            PortalMessagingDataSerializer.putOptionalPortalMessagingDataVarArray(iSerializer, portalMessagingDataArray);
        }
    }

    public static void putOptionalPortalADBEntryVarArray(ISerializer iSerializer, PortalADBEntry[] portalADBEntryArray) {
        boolean bl = portalADBEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(portalADBEntryArray.length);
            for (int i2 = 0; i2 < portalADBEntryArray.length; ++i2) {
                PortalADBEntrySerializer.putOptionalPortalADBEntry(iSerializer, portalADBEntryArray[i2]);
            }
        }
    }

    public static PortalADBEntry getOptionalPortalADBEntry(IDeserializer iDeserializer) {
        PortalADBEntry portalADBEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            PortalPersonalData portalPersonalData;
            long l;
            long l2;
            int n;
            int n2;
            String string;
            String string2;
            long l3;
            long l4;
            portalADBEntry = new PortalADBEntry();
            portalADBEntry.entryID = l4 = iDeserializer.getInt64();
            portalADBEntry.entryType = l3 = iDeserializer.getInt64();
            portalADBEntry.generalDescription = string2 = iDeserializer.getOptionalString();
            portalADBEntry.additionalDescription = string = iDeserializer.getOptionalString();
            portalADBEntry.voiceTagID = n2 = iDeserializer.getInt32();
            portalADBEntry.preferedNumber = n = iDeserializer.getInt32();
            portalADBEntry.oadbHashcode = l2 = iDeserializer.getInt64();
            portalADBEntry.initialNoNavHashcode = l = iDeserializer.getInt64();
            portalADBEntry.personalData = portalPersonalData = PortalPersonalDataSerializer.getOptionalPortalPersonalData(iDeserializer);
            PortalPhoneData[] portalPhoneDataArray = PortalPhoneDataSerializer.getOptionalPortalPhoneDataVarArray(iDeserializer);
            portalADBEntry.phoneData = portalPhoneDataArray;
            PortalAddressData[] portalAddressDataArray = PortalAddressDataSerializer.getOptionalPortalAddressDataVarArray(iDeserializer);
            portalADBEntry.addressData = portalAddressDataArray;
            PortalNavigationData[] portalNavigationDataArray = PortalNavigationDataSerializer.getOptionalPortalNavigationDataVarArray(iDeserializer);
            portalADBEntry.navigationData = portalNavigationDataArray;
            PortalMessagingData[] portalMessagingDataArray = PortalMessagingDataSerializer.getOptionalPortalMessagingDataVarArray(iDeserializer);
            portalADBEntry.messagingData = portalMessagingDataArray;
        }
        return portalADBEntry;
    }

    public static PortalADBEntry[] getOptionalPortalADBEntryVarArray(IDeserializer iDeserializer) {
        PortalADBEntry[] portalADBEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            portalADBEntryArray = new PortalADBEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                portalADBEntryArray[i2] = PortalADBEntrySerializer.getOptionalPortalADBEntry(iDeserializer);
            }
        }
        return portalADBEntryArray;
    }
}

