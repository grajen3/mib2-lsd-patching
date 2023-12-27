/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.online;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.online.DictationValueSentence;
import org.dsi.ifc.online.DictationValueSentenceElement;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRPersonalIdentifier;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallData;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.online.PicNavSyncInfo;
import org.dsi.ifc.online.PoiOnlineRecognitionListElement;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.online.PortalAddressData;
import org.dsi.ifc.online.PortalLocation;
import org.dsi.ifc.online.PortalMessagingData;
import org.dsi.ifc.online.PortalNavigationData;
import org.dsi.ifc.online.PortalPersonalData;
import org.dsi.ifc.online.PortalPhoneData;

public final class DSIOnlineTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DICTATIONVALUESENTENCE;
    private static final int ID_DICTATIONVALUESENTENCEELEMENT;
    private static final int ID_FCDPOSITION;
    private static final int ID_LOCATABLEPOSITION;
    private static final int ID_OSRAPPLICATION;
    private static final int ID_OSRAPPLICATIONPROPERTIES;
    private static final int ID_OSRDEVICE;
    private static final int ID_OSRLICENSE;
    private static final int ID_OSRNOTIFYPROPERTIES;
    private static final int ID_OSRNOTIFYPROPERTIESSL;
    private static final int ID_OSRPERSONALIDENTIFIER;
    private static final int ID_OSRSERVICELISTENTRY;
    private static final int ID_OSRSERVICEREGISTRATION;
    private static final int ID_OSRSERVICESTATE;
    private static final int ID_OSRUSER;
    private static final int ID_OPERATORCALLADDRESSENTRY;
    private static final int ID_OPERATORCALLDATA;
    private static final int ID_OPERATORCALLRESULT;
    private static final int ID_PICNAVSYNCINFO;
    private static final int ID_POIONLINERECOGNITIONLISTELEMENT;
    private static final int ID_POIONLINESEARCHVALUELIST;
    private static final int ID_POIONLINESEARCHVALUELISTELEMENT;
    private static final int ID_PORTALADBENTRY;
    private static final int ID_PORTALADDRESSDATA;
    private static final int ID_PORTALLOCATION;
    private static final int ID_PORTALMESSAGINGDATA;
    private static final int ID_PORTALNAVIGATIONDATA;
    private static final int ID_PORTALPERSONALDATA;
    private static final int ID_PORTALPHONEDATA;
    static /* synthetic */ Class class$org$dsi$ifc$online$DictationValueSentence;
    static /* synthetic */ Class class$org$dsi$ifc$online$DictationValueSentenceElement;
    static /* synthetic */ Class class$org$dsi$ifc$online$FCDPosition;
    static /* synthetic */ Class class$org$dsi$ifc$online$LocatablePosition;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRApplication;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRApplicationProperties;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRDevice;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRLicense;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRNotifyProperties;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRNotifyPropertiesSL;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRPersonalIdentifier;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRServiceListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRServiceRegistration;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRServiceState;
    static /* synthetic */ Class class$org$dsi$ifc$online$OSRUser;
    static /* synthetic */ Class class$org$dsi$ifc$online$OperatorCallAddressEntry;
    static /* synthetic */ Class class$org$dsi$ifc$online$OperatorCallData;
    static /* synthetic */ Class class$org$dsi$ifc$online$OperatorCallResult;
    static /* synthetic */ Class class$org$dsi$ifc$online$PicNavSyncInfo;
    static /* synthetic */ Class class$org$dsi$ifc$online$PoiOnlineRecognitionListElement;
    static /* synthetic */ Class class$org$dsi$ifc$online$PoiOnlineSearchValuelist;
    static /* synthetic */ Class class$org$dsi$ifc$online$PoiOnlineSearchValuelistElement;
    static /* synthetic */ Class class$org$dsi$ifc$online$PortalADBEntry;
    static /* synthetic */ Class class$org$dsi$ifc$online$PortalAddressData;
    static /* synthetic */ Class class$org$dsi$ifc$online$PortalLocation;
    static /* synthetic */ Class class$org$dsi$ifc$online$PortalMessagingData;
    static /* synthetic */ Class class$org$dsi$ifc$online$PortalNavigationData;
    static /* synthetic */ Class class$org$dsi$ifc$online$PortalPersonalData;
    static /* synthetic */ Class class$org$dsi$ifc$online$PortalPhoneData;

    public DSIOnlineTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$DictationValueSentence == null ? (class$org$dsi$ifc$online$DictationValueSentence = DSIOnlineTracer.class$("org.dsi.ifc.online.DictationValueSentence")) : class$org$dsi$ifc$online$DictationValueSentence, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$DictationValueSentenceElement == null ? (class$org$dsi$ifc$online$DictationValueSentenceElement = DSIOnlineTracer.class$("org.dsi.ifc.online.DictationValueSentenceElement")) : class$org$dsi$ifc$online$DictationValueSentenceElement, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$FCDPosition == null ? (class$org$dsi$ifc$online$FCDPosition = DSIOnlineTracer.class$("org.dsi.ifc.online.FCDPosition")) : class$org$dsi$ifc$online$FCDPosition, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$LocatablePosition == null ? (class$org$dsi$ifc$online$LocatablePosition = DSIOnlineTracer.class$("org.dsi.ifc.online.LocatablePosition")) : class$org$dsi$ifc$online$LocatablePosition, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRApplication == null ? (class$org$dsi$ifc$online$OSRApplication = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRApplication")) : class$org$dsi$ifc$online$OSRApplication, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRApplicationProperties == null ? (class$org$dsi$ifc$online$OSRApplicationProperties = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRApplicationProperties")) : class$org$dsi$ifc$online$OSRApplicationProperties, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRDevice == null ? (class$org$dsi$ifc$online$OSRDevice = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRDevice")) : class$org$dsi$ifc$online$OSRDevice, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRLicense == null ? (class$org$dsi$ifc$online$OSRLicense = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRLicense")) : class$org$dsi$ifc$online$OSRLicense, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRNotifyProperties == null ? (class$org$dsi$ifc$online$OSRNotifyProperties = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRNotifyProperties")) : class$org$dsi$ifc$online$OSRNotifyProperties, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRNotifyPropertiesSL == null ? (class$org$dsi$ifc$online$OSRNotifyPropertiesSL = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRNotifyPropertiesSL")) : class$org$dsi$ifc$online$OSRNotifyPropertiesSL, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRPersonalIdentifier == null ? (class$org$dsi$ifc$online$OSRPersonalIdentifier = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRPersonalIdentifier")) : class$org$dsi$ifc$online$OSRPersonalIdentifier, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRServiceListEntry == null ? (class$org$dsi$ifc$online$OSRServiceListEntry = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRServiceListEntry")) : class$org$dsi$ifc$online$OSRServiceListEntry, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRServiceRegistration == null ? (class$org$dsi$ifc$online$OSRServiceRegistration = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRServiceRegistration")) : class$org$dsi$ifc$online$OSRServiceRegistration, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRServiceState == null ? (class$org$dsi$ifc$online$OSRServiceState = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRServiceState")) : class$org$dsi$ifc$online$OSRServiceState, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OSRUser == null ? (class$org$dsi$ifc$online$OSRUser = DSIOnlineTracer.class$("org.dsi.ifc.online.OSRUser")) : class$org$dsi$ifc$online$OSRUser, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OperatorCallAddressEntry == null ? (class$org$dsi$ifc$online$OperatorCallAddressEntry = DSIOnlineTracer.class$("org.dsi.ifc.online.OperatorCallAddressEntry")) : class$org$dsi$ifc$online$OperatorCallAddressEntry, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OperatorCallData == null ? (class$org$dsi$ifc$online$OperatorCallData = DSIOnlineTracer.class$("org.dsi.ifc.online.OperatorCallData")) : class$org$dsi$ifc$online$OperatorCallData, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$OperatorCallResult == null ? (class$org$dsi$ifc$online$OperatorCallResult = DSIOnlineTracer.class$("org.dsi.ifc.online.OperatorCallResult")) : class$org$dsi$ifc$online$OperatorCallResult, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PicNavSyncInfo == null ? (class$org$dsi$ifc$online$PicNavSyncInfo = DSIOnlineTracer.class$("org.dsi.ifc.online.PicNavSyncInfo")) : class$org$dsi$ifc$online$PicNavSyncInfo, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PoiOnlineRecognitionListElement == null ? (class$org$dsi$ifc$online$PoiOnlineRecognitionListElement = DSIOnlineTracer.class$("org.dsi.ifc.online.PoiOnlineRecognitionListElement")) : class$org$dsi$ifc$online$PoiOnlineRecognitionListElement, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PoiOnlineSearchValuelist == null ? (class$org$dsi$ifc$online$PoiOnlineSearchValuelist = DSIOnlineTracer.class$("org.dsi.ifc.online.PoiOnlineSearchValuelist")) : class$org$dsi$ifc$online$PoiOnlineSearchValuelist, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PoiOnlineSearchValuelistElement == null ? (class$org$dsi$ifc$online$PoiOnlineSearchValuelistElement = DSIOnlineTracer.class$("org.dsi.ifc.online.PoiOnlineSearchValuelistElement")) : class$org$dsi$ifc$online$PoiOnlineSearchValuelistElement, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PortalADBEntry == null ? (class$org$dsi$ifc$online$PortalADBEntry = DSIOnlineTracer.class$("org.dsi.ifc.online.PortalADBEntry")) : class$org$dsi$ifc$online$PortalADBEntry, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PortalAddressData == null ? (class$org$dsi$ifc$online$PortalAddressData = DSIOnlineTracer.class$("org.dsi.ifc.online.PortalAddressData")) : class$org$dsi$ifc$online$PortalAddressData, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PortalLocation == null ? (class$org$dsi$ifc$online$PortalLocation = DSIOnlineTracer.class$("org.dsi.ifc.online.PortalLocation")) : class$org$dsi$ifc$online$PortalLocation, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PortalMessagingData == null ? (class$org$dsi$ifc$online$PortalMessagingData = DSIOnlineTracer.class$("org.dsi.ifc.online.PortalMessagingData")) : class$org$dsi$ifc$online$PortalMessagingData, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PortalNavigationData == null ? (class$org$dsi$ifc$online$PortalNavigationData = DSIOnlineTracer.class$("org.dsi.ifc.online.PortalNavigationData")) : class$org$dsi$ifc$online$PortalNavigationData, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PortalPersonalData == null ? (class$org$dsi$ifc$online$PortalPersonalData = DSIOnlineTracer.class$("org.dsi.ifc.online.PortalPersonalData")) : class$org$dsi$ifc$online$PortalPersonalData, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$online$PortalPhoneData == null ? (class$org$dsi$ifc$online$PortalPhoneData = DSIOnlineTracer.class$("org.dsi.ifc.online.PortalPhoneData")) : class$org$dsi$ifc$online$PortalPhoneData, 29);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDictationValueSentence(printWriter, (DictationValueSentence)object);
                break;
            }
            case 2: {
                this.traceDictationValueSentenceElement(printWriter, (DictationValueSentenceElement)object);
                break;
            }
            case 3: {
                this.traceFCDPosition(printWriter, (FCDPosition)object);
                break;
            }
            case 4: {
                this.traceLocatablePosition(printWriter, (LocatablePosition)object);
                break;
            }
            case 5: {
                this.traceOSRApplication(printWriter, (OSRApplication)object);
                break;
            }
            case 6: {
                this.traceOSRApplicationProperties(printWriter, (OSRApplicationProperties)object);
                break;
            }
            case 7: {
                this.traceOSRDevice(printWriter, (OSRDevice)object);
                break;
            }
            case 8: {
                this.traceOSRLicense(printWriter, (OSRLicense)object);
                break;
            }
            case 9: {
                this.traceOSRNotifyProperties(printWriter, (OSRNotifyProperties)object);
                break;
            }
            case 10: {
                this.traceOSRNotifyPropertiesSL(printWriter, (OSRNotifyPropertiesSL)object);
                break;
            }
            case 11: {
                this.traceOSRPersonalIdentifier(printWriter, (OSRPersonalIdentifier)object);
                break;
            }
            case 12: {
                this.traceOSRServiceListEntry(printWriter, (OSRServiceListEntry)object);
                break;
            }
            case 13: {
                this.traceOSRServiceRegistration(printWriter, (OSRServiceRegistration)object);
                break;
            }
            case 14: {
                this.traceOSRServiceState(printWriter, (OSRServiceState)object);
                break;
            }
            case 15: {
                this.traceOSRUser(printWriter, (OSRUser)object);
                break;
            }
            case 16: {
                this.traceOperatorCallAddressEntry(printWriter, (OperatorCallAddressEntry)object);
                break;
            }
            case 17: {
                this.traceOperatorCallData(printWriter, (OperatorCallData)object);
                break;
            }
            case 18: {
                this.traceOperatorCallResult(printWriter, (OperatorCallResult)object);
                break;
            }
            case 19: {
                this.tracePicNavSyncInfo(printWriter, (PicNavSyncInfo)object);
                break;
            }
            case 20: {
                this.tracePoiOnlineRecognitionListElement(printWriter, (PoiOnlineRecognitionListElement)object);
                break;
            }
            case 21: {
                this.tracePoiOnlineSearchValuelist(printWriter, (PoiOnlineSearchValuelist)object);
                break;
            }
            case 22: {
                this.tracePoiOnlineSearchValuelistElement(printWriter, (PoiOnlineSearchValuelistElement)object);
                break;
            }
            case 23: {
                this.tracePortalADBEntry(printWriter, (PortalADBEntry)object);
                break;
            }
            case 24: {
                this.tracePortalAddressData(printWriter, (PortalAddressData)object);
                break;
            }
            case 25: {
                this.tracePortalLocation(printWriter, (PortalLocation)object);
                break;
            }
            case 26: {
                this.tracePortalMessagingData(printWriter, (PortalMessagingData)object);
                break;
            }
            case 27: {
                this.tracePortalNavigationData(printWriter, (PortalNavigationData)object);
                break;
            }
            case 28: {
                this.tracePortalPersonalData(printWriter, (PortalPersonalData)object);
                break;
            }
            case 29: {
                this.tracePortalPhoneData(printWriter, (PortalPhoneData)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDictationValueSentence(PrintWriter printWriter, DictationValueSentence dictationValueSentence) {
        if (dictationValueSentence == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dictationValueSentence.voiceSourceID);
        printWriter.print(dictationValueSentence.voiceSourceName);
        printWriter.print(dictationValueSentence.voiceRecognizerAudioFormat);
        printWriter.print(dictationValueSentence.imageVoiceUrl);
        printWriter.print(dictationValueSentence.imageVoiceCheckSum);
        if (dictationValueSentence.list == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = dictationValueSentence.list.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, dictationValueSentence.list[i2]);
            }
        }
    }

    private void traceDictationValueSentenceElement(PrintWriter printWriter, DictationValueSentenceElement dictationValueSentenceElement) {
        if (dictationValueSentenceElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (dictationValueSentenceElement.words == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = dictationValueSentenceElement.words.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(dictationValueSentenceElement.words[i2]);
            }
        }
    }

    private void traceFCDPosition(PrintWriter printWriter, FCDPosition fCDPosition) {
        if (fCDPosition == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(fCDPosition.timestamp);
        printWriter.print(fCDPosition.lon);
        printWriter.print(fCDPosition.lat);
        printWriter.print(fCDPosition.formOfWay);
        printWriter.print(fCDPosition.functionalRoadClass);
        printWriter.print(fCDPosition.roadNumber);
        printWriter.print(fCDPosition.heading);
        printWriter.print(fCDPosition.speed);
        printWriter.print(fCDPosition.temperature);
        printWriter.print(fCDPosition.rain);
        printWriter.print(fCDPosition.validBitArray);
    }

    private void traceLocatablePosition(PrintWriter printWriter, LocatablePosition locatablePosition) {
        if (locatablePosition == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(locatablePosition.longitude);
        printWriter.print(locatablePosition.latitude);
        printWriter.print(locatablePosition.country);
        printWriter.print(locatablePosition.bearing);
        printWriter.print(locatablePosition.roadNumber);
        printWriter.print(locatablePosition.functionalRoadClass);
        printWriter.print(locatablePosition.formOfWay);
        printWriter.print(locatablePosition.isStopOver);
        if (locatablePosition.routeCriteria == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = locatablePosition.routeCriteria.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(locatablePosition.routeCriteria[i2]);
            }
        }
    }

    private void traceOSRApplication(PrintWriter printWriter, OSRApplication oSRApplication) {
        int n;
        int n2;
        if (oSRApplication == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRApplication.id);
        printWriter.print(oSRApplication.state);
        printWriter.print(oSRApplication.demandstate);
        if (oSRApplication.licenseList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = oSRApplication.licenseList.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, oSRApplication.licenseList[n]);
            }
        }
        if (oSRApplication.propertyList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = oSRApplication.propertyList.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, oSRApplication.propertyList[n]);
            }
        }
    }

    private void traceOSRApplicationProperties(PrintWriter printWriter, OSRApplicationProperties oSRApplicationProperties) {
        if (oSRApplicationProperties == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRApplicationProperties.group);
        printWriter.print(oSRApplicationProperties.key);
        printWriter.print(oSRApplicationProperties.value);
    }

    private void traceOSRDevice(PrintWriter printWriter, OSRDevice oSRDevice) {
        if (oSRDevice == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRDevice.name);
        this.trace(printWriter, oSRDevice.pIdentifier);
        printWriter.print(oSRDevice.connectionState);
    }

    private void traceOSRLicense(PrintWriter printWriter, OSRLicense oSRLicense) {
        int n;
        int n2;
        if (oSRLicense == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRLicense.id);
        printWriter.print(oSRLicense.state);
        this.trace(printWriter, oSRLicense.activation);
        this.trace(printWriter, oSRLicense.expires);
        printWriter.print(oSRLicense.duration);
        if (oSRLicense.country == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = oSRLicense.country.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(oSRLicense.country[n]);
            }
        }
        printWriter.print(oSRLicense.serviceID);
        printWriter.print(oSRLicense.warn);
        printWriter.print(oSRLicense.name);
        printWriter.print(oSRLicense.description);
        if (oSRLicense.onlineserviceassignments == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = oSRLicense.onlineserviceassignments.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(oSRLicense.onlineserviceassignments[n]);
            }
        }
        printWriter.print(oSRLicense.type);
    }

    private void traceOSRNotifyProperties(PrintWriter printWriter, OSRNotifyProperties oSRNotifyProperties) {
        if (oSRNotifyProperties == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRNotifyProperties.idonlineapp);
        printWriter.print(oSRNotifyProperties.priority);
        printWriter.print(oSRNotifyProperties.reason);
    }

    private void traceOSRNotifyPropertiesSL(PrintWriter printWriter, OSRNotifyPropertiesSL oSRNotifyPropertiesSL) {
        if (oSRNotifyPropertiesSL == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRNotifyPropertiesSL.serviceID);
        printWriter.print(oSRNotifyPropertiesSL.symbolicName);
        printWriter.print(oSRNotifyPropertiesSL.reasonConnectivity);
        printWriter.print(oSRNotifyPropertiesSL.reasonConfig);
        printWriter.print(oSRNotifyPropertiesSL.reasonLicense);
        printWriter.print(oSRNotifyPropertiesSL.reasonBackend);
        printWriter.print(oSRNotifyPropertiesSL.privacyConflict);
    }

    private void traceOSRPersonalIdentifier(PrintWriter printWriter, OSRPersonalIdentifier oSRPersonalIdentifier) {
        if (oSRPersonalIdentifier == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRPersonalIdentifier.pType);
        printWriter.print(oSRPersonalIdentifier.pIdentifier);
    }

    private void traceOSRServiceListEntry(PrintWriter printWriter, OSRServiceListEntry oSRServiceListEntry) {
        if (oSRServiceListEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRServiceListEntry.serviceID);
        printWriter.print(oSRServiceListEntry.serviceType);
        printWriter.print(oSRServiceListEntry.privacyGroup);
        printWriter.print(oSRServiceListEntry.enableDisableServiceState);
        printWriter.print(oSRServiceListEntry.backendReasons);
        printWriter.print(oSRServiceListEntry.vehicleLocalServiceState);
        printWriter.print(oSRServiceListEntry.licenseRequired);
        printWriter.print(oSRServiceListEntry.blocksDisabling);
        printWriter.print(oSRServiceListEntry.primaryUserRequired);
        printWriter.print(oSRServiceListEntry.termsAndConditionsRequired);
        printWriter.print(oSRServiceListEntry.apn);
        printWriter.print(oSRServiceListEntry.qos);
        printWriter.print(oSRServiceListEntry.authLevel);
        this.trace(printWriter, oSRServiceListEntry.license);
    }

    private void traceOSRServiceRegistration(PrintWriter printWriter, OSRServiceRegistration oSRServiceRegistration) {
        if (oSRServiceRegistration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRServiceRegistration.appID);
        printWriter.print(oSRServiceRegistration.serviceID);
        printWriter.print(oSRServiceRegistration.symbolicName);
        printWriter.print(oSRServiceRegistration.localizedDescription);
        printWriter.print(oSRServiceRegistration.mandatoryFlag);
    }

    private void traceOSRServiceState(PrintWriter printWriter, OSRServiceState oSRServiceState) {
        if (oSRServiceState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRServiceState.serviceID);
        printWriter.print(oSRServiceState.symbolicName);
        printWriter.print(oSRServiceState.errorCode);
        printWriter.print(oSRServiceState.privacyConflict);
        this.trace(printWriter, oSRServiceState.serviceListEntry);
        if (oSRServiceState.onlineserviceassignments == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = oSRServiceState.onlineserviceassignments.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(oSRServiceState.onlineserviceassignments[i2]);
            }
        }
    }

    private void traceOSRUser(PrintWriter printWriter, OSRUser oSRUser) {
        if (oSRUser == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oSRUser.authIdentifier);
        printWriter.print(oSRUser.portalUser);
        printWriter.print(oSRUser.hash1);
        printWriter.print(oSRUser.hash2);
        printWriter.print(oSRUser.name);
        this.trace(printWriter, oSRUser.personalIdentifier);
        if (oSRUser.devicesForAutologin == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = oSRUser.devicesForAutologin.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, oSRUser.devicesForAutologin[i2]);
            }
        }
        printWriter.print(oSRUser.privacyFlag);
        printWriter.print(oSRUser.usertype);
    }

    private void traceOperatorCallAddressEntry(PrintWriter printWriter, OperatorCallAddressEntry operatorCallAddressEntry) {
        if (operatorCallAddressEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(operatorCallAddressEntry.street);
        printWriter.print(operatorCallAddressEntry.zip);
        printWriter.print(operatorCallAddressEntry.city);
        printWriter.print(operatorCallAddressEntry.region);
        printWriter.print(operatorCallAddressEntry.country);
        printWriter.print(operatorCallAddressEntry.phoneNumber);
        printWriter.print(operatorCallAddressEntry.url);
        printWriter.print(operatorCallAddressEntry.statusURL);
    }

    private void traceOperatorCallData(PrintWriter printWriter, OperatorCallData operatorCallData) {
        if (operatorCallData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(operatorCallData.heading);
        printWriter.print(operatorCallData.altitude);
        this.trace(printWriter, operatorCallData.position);
        this.trace(printWriter, operatorCallData.destination);
        printWriter.print(operatorCallData.validBitMask);
    }

    private void traceOperatorCallResult(PrintWriter printWriter, OperatorCallResult operatorCallResult) {
        if (operatorCallResult == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(operatorCallResult.serviceId);
        printWriter.print(operatorCallResult.serviceType);
        printWriter.print(operatorCallResult.name);
        this.trace(printWriter, operatorCallResult.address);
        this.trace(printWriter, operatorCallResult.location);
    }

    private void tracePicNavSyncInfo(PrintWriter printWriter, PicNavSyncInfo picNavSyncInfo) {
        if (picNavSyncInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(picNavSyncInfo.addItemCount);
        printWriter.print(picNavSyncInfo.deleteItemCount);
        printWriter.print(picNavSyncInfo.renameItemCount);
        printWriter.print(picNavSyncInfo.moveItemCount);
    }

    private void tracePoiOnlineRecognitionListElement(PrintWriter printWriter, PoiOnlineRecognitionListElement poiOnlineRecognitionListElement) {
        if (poiOnlineRecognitionListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(poiOnlineRecognitionListElement.recognizedTerm);
        printWriter.print(poiOnlineRecognitionListElement.confidenceLevel);
    }

    private void tracePoiOnlineSearchValuelist(PrintWriter printWriter, PoiOnlineSearchValuelist poiOnlineSearchValuelist) {
        int n;
        int n2;
        if (poiOnlineSearchValuelist == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(poiOnlineSearchValuelist.sourceID);
        printWriter.print(poiOnlineSearchValuelist.sourceName);
        printWriter.print(poiOnlineSearchValuelist.voiceRecognizerSourceID);
        printWriter.print(poiOnlineSearchValuelist.voiceRecognizerSourceName);
        printWriter.print(poiOnlineSearchValuelist.voiceRecognizerAudioFormat);
        if (poiOnlineSearchValuelist.recognitionList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = poiOnlineSearchValuelist.recognitionList.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, poiOnlineSearchValuelist.recognitionList[n]);
            }
        }
        printWriter.print(poiOnlineSearchValuelist.imageUrl);
        printWriter.print(poiOnlineSearchValuelist.imageCheckSum);
        printWriter.print(poiOnlineSearchValuelist.imageVoiceUrl);
        printWriter.print(poiOnlineSearchValuelist.imageVoiceCheckSum);
        printWriter.print(poiOnlineSearchValuelist.imageMapUrl);
        printWriter.print(poiOnlineSearchValuelist.imageMapCheckSum);
        printWriter.print(poiOnlineSearchValuelist.sortKey);
        if (poiOnlineSearchValuelist.list == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = poiOnlineSearchValuelist.list.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, poiOnlineSearchValuelist.list[n]);
            }
        }
    }

    private void tracePoiOnlineSearchValuelistElement(PrintWriter printWriter, PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement) {
        if (poiOnlineSearchValuelistElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(poiOnlineSearchValuelistElement.longitude);
        printWriter.print(poiOnlineSearchValuelistElement.latitude);
        printWriter.print(poiOnlineSearchValuelistElement.name);
        printWriter.print(poiOnlineSearchValuelistElement.street);
        printWriter.print(poiOnlineSearchValuelistElement.postal);
        printWriter.print(poiOnlineSearchValuelistElement.city);
        printWriter.print(poiOnlineSearchValuelistElement.region);
        printWriter.print(poiOnlineSearchValuelistElement.country);
        printWriter.print(poiOnlineSearchValuelistElement.phone);
        printWriter.print(poiOnlineSearchValuelistElement.url);
        printWriter.print(poiOnlineSearchValuelistElement.description);
        printWriter.print(poiOnlineSearchValuelistElement.type);
        printWriter.print(poiOnlineSearchValuelistElement.statusurl);
        printWriter.print(poiOnlineSearchValuelistElement.imageUrl);
        printWriter.print(poiOnlineSearchValuelistElement.category);
        printWriter.print(poiOnlineSearchValuelistElement.additionalData);
    }

    private void tracePortalADBEntry(PrintWriter printWriter, PortalADBEntry portalADBEntry) {
        int n;
        int n2;
        if (portalADBEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(portalADBEntry.entryID);
        printWriter.print(portalADBEntry.entryType);
        printWriter.print(portalADBEntry.generalDescription);
        printWriter.print(portalADBEntry.additionalDescription);
        printWriter.print(portalADBEntry.voiceTagID);
        printWriter.print(portalADBEntry.preferedNumber);
        printWriter.print(portalADBEntry.oadbHashcode);
        printWriter.print(portalADBEntry.initialNoNavHashcode);
        this.trace(printWriter, portalADBEntry.personalData);
        if (portalADBEntry.phoneData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = portalADBEntry.phoneData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, portalADBEntry.phoneData[n]);
            }
        }
        if (portalADBEntry.addressData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = portalADBEntry.addressData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, portalADBEntry.addressData[n]);
            }
        }
        if (portalADBEntry.navigationData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = portalADBEntry.navigationData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, portalADBEntry.navigationData[n]);
            }
        }
        if (portalADBEntry.messagingData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = portalADBEntry.messagingData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, portalADBEntry.messagingData[n]);
            }
        }
    }

    private void tracePortalAddressData(PrintWriter printWriter, PortalAddressData portalAddressData) {
        if (portalAddressData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(portalAddressData.addressType);
        printWriter.print(portalAddressData.street);
        printWriter.print(portalAddressData.locality);
        printWriter.print(portalAddressData.country);
        printWriter.print(portalAddressData.postOfficeBox);
        printWriter.print(portalAddressData.region);
        printWriter.print(portalAddressData.postalCode);
        printWriter.print(portalAddressData.unstructured);
    }

    private void tracePortalLocation(PrintWriter printWriter, PortalLocation portalLocation) {
        if (portalLocation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(portalLocation.longitude);
        printWriter.print(portalLocation.latitude);
        printWriter.print(portalLocation.unstructured);
    }

    private void tracePortalMessagingData(PrintWriter printWriter, PortalMessagingData portalMessagingData) {
        if (portalMessagingData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(portalMessagingData.messageType);
        printWriter.print(portalMessagingData.email);
        printWriter.print(portalMessagingData.url);
    }

    private void tracePortalNavigationData(PrintWriter printWriter, PortalNavigationData portalNavigationData) {
        if (portalNavigationData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(portalNavigationData.naviType);
        printWriter.print(portalNavigationData.topDestination);
        this.trace(printWriter, portalNavigationData.naviLocation);
        printWriter.print(portalNavigationData.version);
        printWriter.print(portalNavigationData.geoPosition);
        printWriter.print(portalNavigationData.street);
        printWriter.print(portalNavigationData.locality);
    }

    private void tracePortalPersonalData(PrintWriter printWriter, PortalPersonalData portalPersonalData) {
        if (portalPersonalData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(portalPersonalData.lastName);
        printWriter.print(portalPersonalData.lastNameSnd);
        printWriter.print(portalPersonalData.firstName);
        printWriter.print(portalPersonalData.firstNameSnd);
        printWriter.print(portalPersonalData.organizationName);
        printWriter.print(portalPersonalData.position);
    }

    private void tracePortalPhoneData(PrintWriter printWriter, PortalPhoneData portalPhoneData) {
        if (portalPhoneData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(portalPhoneData.number);
        printWriter.print(portalPhoneData.type);
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

