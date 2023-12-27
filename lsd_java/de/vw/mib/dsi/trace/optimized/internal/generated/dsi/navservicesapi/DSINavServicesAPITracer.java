/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.navservicesapi;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.navservicesapi.ADBAddressData;
import org.dsi.ifc.navservicesapi.ADBPersonalData;
import org.dsi.ifc.navservicesapi.ADBPhoneData;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.AddressDataSDIS;
import org.dsi.ifc.navservicesapi.BapManeuverDescriptor;
import org.dsi.ifc.navservicesapi.LDListElement;
import org.dsi.ifc.navservicesapi.NavLaneGuidanceData;
import org.dsi.ifc.navservicesapi.NavPhoneData;
import org.dsi.ifc.navservicesapi.ProfileInfo;
import org.dsi.ifc.navservicesapi.TrafficInfo;
import org.dsi.ifc.navservicesapi.TryMatchLocationData;
import org.dsi.ifc.navservicesapi.TunerData;

public final class DSINavServicesAPITracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ADBADDRESSDATA;
    private static final int ID_ADBPERSONALDATA;
    private static final int ID_ADBPHONEDATA;
    private static final int ID_ADDRESSDATA;
    private static final int ID_ADDRESSDATASDIS;
    private static final int ID_BAPMANEUVERDESCRIPTOR;
    private static final int ID_LDLISTELEMENT;
    private static final int ID_NAVLANEGUIDANCEDATA;
    private static final int ID_NAVPHONEDATA;
    private static final int ID_PROFILEINFO;
    private static final int ID_TRAFFICINFO;
    private static final int ID_TRYMATCHLOCATIONDATA;
    private static final int ID_TUNERDATA;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$ADBAddressData;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$ADBPersonalData;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$ADBPhoneData;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$AddressData;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$AddressDataSDIS;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$BapManeuverDescriptor;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$LDListElement;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$NavLaneGuidanceData;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$NavPhoneData;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$ProfileInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$TrafficInfo;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$TryMatchLocationData;
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$TunerData;

    public DSINavServicesAPITracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$ADBAddressData == null ? (class$org$dsi$ifc$navservicesapi$ADBAddressData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.ADBAddressData")) : class$org$dsi$ifc$navservicesapi$ADBAddressData, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$ADBPersonalData == null ? (class$org$dsi$ifc$navservicesapi$ADBPersonalData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.ADBPersonalData")) : class$org$dsi$ifc$navservicesapi$ADBPersonalData, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$ADBPhoneData == null ? (class$org$dsi$ifc$navservicesapi$ADBPhoneData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.ADBPhoneData")) : class$org$dsi$ifc$navservicesapi$ADBPhoneData, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$AddressData == null ? (class$org$dsi$ifc$navservicesapi$AddressData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.AddressData")) : class$org$dsi$ifc$navservicesapi$AddressData, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$AddressDataSDIS == null ? (class$org$dsi$ifc$navservicesapi$AddressDataSDIS = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.AddressDataSDIS")) : class$org$dsi$ifc$navservicesapi$AddressDataSDIS, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$BapManeuverDescriptor == null ? (class$org$dsi$ifc$navservicesapi$BapManeuverDescriptor = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.BapManeuverDescriptor")) : class$org$dsi$ifc$navservicesapi$BapManeuverDescriptor, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$LDListElement == null ? (class$org$dsi$ifc$navservicesapi$LDListElement = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.LDListElement")) : class$org$dsi$ifc$navservicesapi$LDListElement, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$NavLaneGuidanceData == null ? (class$org$dsi$ifc$navservicesapi$NavLaneGuidanceData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.NavLaneGuidanceData")) : class$org$dsi$ifc$navservicesapi$NavLaneGuidanceData, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$NavPhoneData == null ? (class$org$dsi$ifc$navservicesapi$NavPhoneData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.NavPhoneData")) : class$org$dsi$ifc$navservicesapi$NavPhoneData, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$ProfileInfo == null ? (class$org$dsi$ifc$navservicesapi$ProfileInfo = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.ProfileInfo")) : class$org$dsi$ifc$navservicesapi$ProfileInfo, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$TrafficInfo == null ? (class$org$dsi$ifc$navservicesapi$TrafficInfo = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.TrafficInfo")) : class$org$dsi$ifc$navservicesapi$TrafficInfo, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$TryMatchLocationData == null ? (class$org$dsi$ifc$navservicesapi$TryMatchLocationData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.TryMatchLocationData")) : class$org$dsi$ifc$navservicesapi$TryMatchLocationData, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$navservicesapi$TunerData == null ? (class$org$dsi$ifc$navservicesapi$TunerData = DSINavServicesAPITracer.class$("org.dsi.ifc.navservicesapi.TunerData")) : class$org$dsi$ifc$navservicesapi$TunerData, 13);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceADBAddressData(printWriter, (ADBAddressData)object);
                break;
            }
            case 2: {
                this.traceADBPersonalData(printWriter, (ADBPersonalData)object);
                break;
            }
            case 3: {
                this.traceADBPhoneData(printWriter, (ADBPhoneData)object);
                break;
            }
            case 4: {
                this.traceAddressData(printWriter, (AddressData)object);
                break;
            }
            case 5: {
                this.traceAddressDataSDIS(printWriter, (AddressDataSDIS)object);
                break;
            }
            case 6: {
                this.traceBapManeuverDescriptor(printWriter, (BapManeuverDescriptor)object);
                break;
            }
            case 7: {
                this.traceLDListElement(printWriter, (LDListElement)object);
                break;
            }
            case 8: {
                this.traceNavLaneGuidanceData(printWriter, (NavLaneGuidanceData)object);
                break;
            }
            case 9: {
                this.traceNavPhoneData(printWriter, (NavPhoneData)object);
                break;
            }
            case 10: {
                this.traceProfileInfo(printWriter, (ProfileInfo)object);
                break;
            }
            case 11: {
                this.traceTrafficInfo(printWriter, (TrafficInfo)object);
                break;
            }
            case 12: {
                this.traceTryMatchLocationData(printWriter, (TryMatchLocationData)object);
                break;
            }
            case 13: {
                this.traceTunerData(printWriter, (TunerData)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceADBAddressData(PrintWriter printWriter, ADBAddressData aDBAddressData) {
        if (aDBAddressData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aDBAddressData.country);
        printWriter.print(aDBAddressData.region);
        printWriter.print(aDBAddressData.locality);
        printWriter.print(aDBAddressData.postalCode);
        printWriter.print(aDBAddressData.street);
        printWriter.print(aDBAddressData.plaintextAddress);
        printWriter.print(aDBAddressData.addressType);
    }

    private void traceADBPersonalData(PrintWriter printWriter, ADBPersonalData aDBPersonalData) {
        if (aDBPersonalData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aDBPersonalData.name);
        printWriter.print(aDBPersonalData.firstName);
        printWriter.print(aDBPersonalData.soundName);
        printWriter.print(aDBPersonalData.soundFirstName);
    }

    private void traceADBPhoneData(PrintWriter printWriter, ADBPhoneData aDBPhoneData) {
        if (aDBPhoneData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aDBPhoneData.phoneNumber);
        printWriter.print(aDBPhoneData.phoneType);
    }

    private void traceAddressData(PrintWriter printWriter, AddressData addressData) {
        if (addressData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(addressData.key);
        printWriter.print(addressData.value);
    }

    private void traceAddressDataSDIS(PrintWriter printWriter, AddressDataSDIS addressDataSDIS) {
        if (addressDataSDIS == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(addressDataSDIS.longitude);
        printWriter.print(addressDataSDIS.latitude);
        if (addressDataSDIS.addressData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = addressDataSDIS.addressData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, addressDataSDIS.addressData[i2]);
            }
        }
        printWriter.print(addressDataSDIS.distanceFromThisDestinationToFinalDestination);
        printWriter.print(addressDataSDIS.remainingTravelTimeToFinalDestination);
    }

    private void traceBapManeuverDescriptor(PrintWriter printWriter, BapManeuverDescriptor bapManeuverDescriptor) {
        if (bapManeuverDescriptor == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bapManeuverDescriptor.mainElement);
        printWriter.print(bapManeuverDescriptor.direction);
        printWriter.print(bapManeuverDescriptor.zLevelGuidance);
        if (bapManeuverDescriptor.sideStreets == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = bapManeuverDescriptor.sideStreets.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(bapManeuverDescriptor.sideStreets[i2]);
            }
        }
    }

    private void traceLDListElement(PrintWriter printWriter, LDListElement lDListElement) {
        if (lDListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lDListElement.id);
        printWriter.print(lDListElement.title);
    }

    private void traceNavLaneGuidanceData(PrintWriter printWriter, NavLaneGuidanceData navLaneGuidanceData) {
        if (navLaneGuidanceData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navLaneGuidanceData.pos);
        printWriter.print(navLaneGuidanceData.laneDirection);
        if (navLaneGuidanceData.laneSideStreets == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navLaneGuidanceData.laneSideStreets.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(navLaneGuidanceData.laneSideStreets[i2]);
            }
        }
        printWriter.print(navLaneGuidanceData.laneType);
        printWriter.print(navLaneGuidanceData.laneMarkingLeft);
        printWriter.print(navLaneGuidanceData.laneMarkingRight);
        printWriter.print(navLaneGuidanceData.laneDescription);
        printWriter.print(navLaneGuidanceData.guidanceInfo);
    }

    private void traceNavPhoneData(PrintWriter printWriter, NavPhoneData navPhoneData) {
        if (navPhoneData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navPhoneData.number);
        printWriter.print(navPhoneData.numberType);
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
        printWriter.print(profileInfo.publicProfileVisible);
    }

    private void traceTrafficInfo(PrintWriter printWriter, TrafficInfo trafficInfo) {
        if (trafficInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficInfo.messageID);
        printWriter.print(trafficInfo.priority);
        printWriter.print(trafficInfo.streetName);
        printWriter.print(trafficInfo.location);
        printWriter.print(trafficInfo.infoText);
        printWriter.print(trafficInfo.length);
        printWriter.print(trafficInfo.unit);
    }

    private void traceTryMatchLocationData(PrintWriter printWriter, TryMatchLocationData tryMatchLocationData) {
        if (tryMatchLocationData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tryMatchLocationData.latitude);
        printWriter.print(tryMatchLocationData.longitude);
        printWriter.print(tryMatchLocationData.houseNumber);
        printWriter.print(tryMatchLocationData.junction);
        printWriter.print(tryMatchLocationData.street);
        printWriter.print(tryMatchLocationData.town);
        printWriter.print(tryMatchLocationData.country);
        if (tryMatchLocationData.phoneNumbers == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = tryMatchLocationData.phoneNumbers.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, tryMatchLocationData.phoneNumbers[i2]);
            }
        }
        printWriter.print(tryMatchLocationData.state);
        printWriter.print(tryMatchLocationData.poiName);
        printWriter.print(tryMatchLocationData.poiCategory);
        printWriter.print(tryMatchLocationData.postalCode);
        printWriter.print(tryMatchLocationData.unstructured);
        printWriter.print(tryMatchLocationData.origin);
        printWriter.print(tryMatchLocationData.dbVersion);
        printWriter.print(tryMatchLocationData.townPart);
    }

    private void traceTunerData(PrintWriter printWriter, TunerData tunerData) {
        if (tunerData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tunerData.stationName);
        printWriter.print(tunerData.frequency);
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

