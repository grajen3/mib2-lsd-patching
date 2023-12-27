/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.organizer;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.Highlight;
import org.dsi.ifc.organizer.IndexInformation;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.organizer.ProfileInfo;

public final class DSIOrganizerTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ADBENTRY;
    private static final int ID_ADBVIEWSIZE;
    private static final int ID_ADDRESSDATA;
    private static final int ID_DATASET;
    private static final int ID_DOWNLOADINFO;
    private static final int ID_EMAILDATA;
    private static final int ID_ENTRYMETER;
    private static final int ID_HIGHLIGHT;
    private static final int ID_INDEXINFORMATION;
    private static final int ID_PERSONALDATA;
    private static final int ID_PHONEDATA;
    private static final int ID_PROFILEINFO;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$AdbEntry;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$AdbViewSize;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$AddressData;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DataSet;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DownloadInfo;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$EmailData;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$EntryMeter;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$Highlight;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$IndexInformation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$PersonalData;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$PhoneData;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$ProfileInfo;

    public DSIOrganizerTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$AdbEntry == null ? (class$org$dsi$ifc$organizer$AdbEntry = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.AdbEntry")) : class$org$dsi$ifc$organizer$AdbEntry, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$AdbViewSize == null ? (class$org$dsi$ifc$organizer$AdbViewSize = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.AdbViewSize")) : class$org$dsi$ifc$organizer$AdbViewSize, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$AddressData == null ? (class$org$dsi$ifc$organizer$AddressData = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.AddressData")) : class$org$dsi$ifc$organizer$AddressData, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$DataSet == null ? (class$org$dsi$ifc$organizer$DataSet = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.DataSet")) : class$org$dsi$ifc$organizer$DataSet, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$DownloadInfo == null ? (class$org$dsi$ifc$organizer$DownloadInfo = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.DownloadInfo")) : class$org$dsi$ifc$organizer$DownloadInfo, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$EmailData == null ? (class$org$dsi$ifc$organizer$EmailData = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.EmailData")) : class$org$dsi$ifc$organizer$EmailData, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$EntryMeter == null ? (class$org$dsi$ifc$organizer$EntryMeter = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.EntryMeter")) : class$org$dsi$ifc$organizer$EntryMeter, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$Highlight == null ? (class$org$dsi$ifc$organizer$Highlight = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.Highlight")) : class$org$dsi$ifc$organizer$Highlight, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$IndexInformation == null ? (class$org$dsi$ifc$organizer$IndexInformation = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.IndexInformation")) : class$org$dsi$ifc$organizer$IndexInformation, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$PersonalData == null ? (class$org$dsi$ifc$organizer$PersonalData = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.PersonalData")) : class$org$dsi$ifc$organizer$PersonalData, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$PhoneData == null ? (class$org$dsi$ifc$organizer$PhoneData = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.PhoneData")) : class$org$dsi$ifc$organizer$PhoneData, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$organizer$ProfileInfo == null ? (class$org$dsi$ifc$organizer$ProfileInfo = DSIOrganizerTracer.class$("org.dsi.ifc.organizer.ProfileInfo")) : class$org$dsi$ifc$organizer$ProfileInfo, 12);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAdbEntry(printWriter, (AdbEntry)object);
                break;
            }
            case 2: {
                this.traceAdbViewSize(printWriter, (AdbViewSize)object);
                break;
            }
            case 3: {
                this.traceAddressData(printWriter, (AddressData)object);
                break;
            }
            case 4: {
                this.traceDataSet(printWriter, (DataSet)object);
                break;
            }
            case 5: {
                this.traceDownloadInfo(printWriter, (DownloadInfo)object);
                break;
            }
            case 6: {
                this.traceEmailData(printWriter, (EmailData)object);
                break;
            }
            case 7: {
                this.traceEntryMeter(printWriter, (EntryMeter)object);
                break;
            }
            case 8: {
                this.traceHighlight(printWriter, (Highlight)object);
                break;
            }
            case 9: {
                this.traceIndexInformation(printWriter, (IndexInformation)object);
                break;
            }
            case 10: {
                this.tracePersonalData(printWriter, (PersonalData)object);
                break;
            }
            case 11: {
                this.tracePhoneData(printWriter, (PhoneData)object);
                break;
            }
            case 12: {
                this.traceProfileInfo(printWriter, (ProfileInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAdbEntry(PrintWriter printWriter, AdbEntry adbEntry) {
        int n;
        int n2;
        if (adbEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(adbEntry.entryId);
        printWriter.print(adbEntry.entryType);
        printWriter.print(adbEntry.combinedName);
        printWriter.print(adbEntry.preferredNumberIdx);
        printWriter.print(adbEntry.voiceTagId);
        if (adbEntry.phoneData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = adbEntry.phoneData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, adbEntry.phoneData[n]);
            }
        }
        if (adbEntry.addressData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = adbEntry.addressData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, adbEntry.addressData[n]);
            }
        }
        if (adbEntry.emailData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = adbEntry.emailData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, adbEntry.emailData[n]);
            }
        }
        if (adbEntry.urlData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = adbEntry.urlData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(adbEntry.urlData[n]);
            }
        }
        this.trace(printWriter, adbEntry.personalData);
        printWriter.print(adbEntry.referenceId);
    }

    private void traceAdbViewSize(PrintWriter printWriter, AdbViewSize adbViewSize) {
        if (adbViewSize == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(adbViewSize.all);
        printWriter.print(adbViewSize.phone);
        printWriter.print(adbViewSize.navi);
        printWriter.print(adbViewSize.topDestinations);
        printWriter.print(adbViewSize.speedDials);
        printWriter.print(adbViewSize.voiceTags);
        printWriter.print(adbViewSize.usbStick);
        printWriter.print(adbViewSize.sd1);
        printWriter.print(adbViewSize.sd2);
        printWriter.print(adbViewSize.publicProfileEntries);
        printWriter.print(adbViewSize.publicTopDestinations);
        printWriter.print(adbViewSize.onlineDestination);
    }

    private void traceAddressData(PrintWriter printWriter, AddressData addressData) {
        if (addressData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(addressData.addressType);
        printWriter.print(addressData.street);
        printWriter.print(addressData.locality);
        printWriter.print(addressData.localitySound);
        printWriter.print(addressData.country);
        printWriter.print(addressData.region);
        printWriter.print(addressData.postalCode);
        printWriter.print(addressData.topDestination);
        printWriter.print(addressData.geoPosition);
        printWriter.print(addressData.navLocationVersion);
        if (addressData.navLocation == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = addressData.navLocation.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(addressData.navLocation[i2]);
            }
        }
        this.trace(printWriter, addressData.navPicture);
    }

    private void traceDataSet(PrintWriter printWriter, DataSet dataSet) {
        if (dataSet == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataSet.entryId);
        printWriter.print(dataSet.entryPosition);
        printWriter.print(dataSet.entryType);
        printWriter.print(dataSet.generalDescription1);
        printWriter.print(dataSet.generalDescription2);
        printWriter.print(dataSet.voiceTagId);
        printWriter.print(dataSet.phoneCount);
        printWriter.print(dataSet.probNavigable);
        printWriter.print(dataSet.navigable);
        printWriter.print(dataSet.topDestination);
        this.trace(printWriter, dataSet.contactPicture);
        printWriter.print(dataSet.webAddressCount);
        printWriter.print(dataSet.emailCount);
        printWriter.print(dataSet.numberType);
        if (dataSet.highlight == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = dataSet.highlight.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, dataSet.highlight[i2]);
            }
        }
    }

    private void traceDownloadInfo(PrintWriter printWriter, DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(downloadInfo.count);
        printWriter.print(downloadInfo.numberOfItems);
    }

    private void traceEmailData(PrintWriter printWriter, EmailData emailData) {
        if (emailData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(emailData.preferred);
        printWriter.print(emailData.emailType);
        printWriter.print(emailData.emailAddr);
    }

    private void traceEntryMeter(PrintWriter printWriter, EntryMeter entryMeter) {
        if (entryMeter == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(entryMeter.profile);
        printWriter.print(entryMeter.localEntries);
        printWriter.print(entryMeter.meEntries);
        printWriter.print(entryMeter.simEntries);
        printWriter.print(entryMeter.oppEntries);
    }

    private void traceHighlight(PrintWriter printWriter, Highlight highlight) {
        if (highlight == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(highlight.gendescription);
        printWriter.print(highlight.highlightStart);
        printWriter.print(highlight.highlightEnd);
    }

    private void traceIndexInformation(PrintWriter printWriter, IndexInformation indexInformation) {
        if (indexInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(indexInformation.viewtype);
        if (indexInformation.characterInfo == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = indexInformation.characterInfo.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, indexInformation.characterInfo[i2]);
            }
        }
    }

    private void tracePersonalData(PrintWriter printWriter, PersonalData personalData) {
        if (personalData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(personalData.lastName);
        printWriter.print(personalData.lastNameSound);
        printWriter.print(personalData.firstName);
        printWriter.print(personalData.firstNameSound);
        this.trace(printWriter, personalData.birthday);
        printWriter.print(personalData.organization);
        printWriter.print(personalData.organizationSound);
        this.trace(printWriter, personalData.contactPicture);
    }

    private void tracePhoneData(PrintWriter printWriter, PhoneData phoneData) {
        if (phoneData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(phoneData.number);
        printWriter.print(phoneData.numberType);
        printWriter.print(phoneData.speedDialKey);
    }

    private void traceProfileInfo(PrintWriter printWriter, ProfileInfo profileInfo) {
        if (profileInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(profileInfo.num);
        printWriter.print(profileInfo.name);
        printWriter.print(profileInfo.homeId);
        printWriter.print(profileInfo.pairingCode);
        printWriter.print(profileInfo.publicProfileVisibility);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

