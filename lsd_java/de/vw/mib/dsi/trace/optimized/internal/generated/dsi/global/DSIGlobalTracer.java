/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.global;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.global.CarArrayListTransmittableElements;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCAcceleration;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;
import org.dsi.ifc.global.CarBCVolume;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.global.StringAttribute;

public final class DSIGlobalTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CARARRAYLISTTRANSMITTABLEELEMENTS;
    private static final int ID_CARARRAYLISTUPDATEINFO;
    private static final int ID_CARBCACCELERATION;
    private static final int ID_CARBCCONSUMPTION;
    private static final int ID_CARBCCURRENTRANGE;
    private static final int ID_CARBCDISTANCE;
    private static final int ID_CARBCSPEED;
    private static final int ID_CARBCTEMPERATURE;
    private static final int ID_CARBCTIME;
    private static final int ID_CARBCVOLUME;
    private static final int ID_CARVIEWOPTION;
    private static final int ID_CHARACTERINFO;
    private static final int ID_DATETIME;
    private static final int ID_NAVLOCATION;
    private static final int ID_NAVLOCATIONDESCRIPTOR;
    private static final int ID_NAVLOCATIONWGS84;
    private static final int ID_NAVPRICEINFO;
    private static final int ID_NAVRECTANGLE;
    private static final int ID_NAVSEGMENTID;
    private static final int ID_RESOURCELOCATOR;
    private static final int ID_STRINGATTRIBUTE;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarArrayListTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarArrayListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCAcceleration;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCConsumption;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCCurrentRange;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCDistance;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCSpeed;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCTemperature;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCTime;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarBCVolume;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarViewOption;
    static /* synthetic */ Class class$org$dsi$ifc$global$CharacterInfo;
    static /* synthetic */ Class class$org$dsi$ifc$global$DateTime;
    static /* synthetic */ Class class$org$dsi$ifc$global$NavLocation;
    static /* synthetic */ Class class$org$dsi$ifc$global$NavLocationDescriptor;
    static /* synthetic */ Class class$org$dsi$ifc$global$NavLocationWgs84;
    static /* synthetic */ Class class$org$dsi$ifc$global$NavPriceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$global$NavRectangle;
    static /* synthetic */ Class class$org$dsi$ifc$global$NavSegmentID;
    static /* synthetic */ Class class$org$dsi$ifc$global$ResourceLocator;
    static /* synthetic */ Class class$org$dsi$ifc$global$StringAttribute;

    public DSIGlobalTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarArrayListTransmittableElements == null ? (class$org$dsi$ifc$global$CarArrayListTransmittableElements = DSIGlobalTracer.class$("org.dsi.ifc.global.CarArrayListTransmittableElements")) : class$org$dsi$ifc$global$CarArrayListTransmittableElements, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarArrayListUpdateInfo == null ? (class$org$dsi$ifc$global$CarArrayListUpdateInfo = DSIGlobalTracer.class$("org.dsi.ifc.global.CarArrayListUpdateInfo")) : class$org$dsi$ifc$global$CarArrayListUpdateInfo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCAcceleration == null ? (class$org$dsi$ifc$global$CarBCAcceleration = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCAcceleration")) : class$org$dsi$ifc$global$CarBCAcceleration, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCConsumption == null ? (class$org$dsi$ifc$global$CarBCConsumption = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCConsumption")) : class$org$dsi$ifc$global$CarBCConsumption, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCCurrentRange == null ? (class$org$dsi$ifc$global$CarBCCurrentRange = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCCurrentRange")) : class$org$dsi$ifc$global$CarBCCurrentRange, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCDistance == null ? (class$org$dsi$ifc$global$CarBCDistance = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCDistance")) : class$org$dsi$ifc$global$CarBCDistance, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCSpeed == null ? (class$org$dsi$ifc$global$CarBCSpeed = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCSpeed")) : class$org$dsi$ifc$global$CarBCSpeed, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCTemperature == null ? (class$org$dsi$ifc$global$CarBCTemperature = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCTemperature")) : class$org$dsi$ifc$global$CarBCTemperature, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCTime == null ? (class$org$dsi$ifc$global$CarBCTime = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCTime")) : class$org$dsi$ifc$global$CarBCTime, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarBCVolume == null ? (class$org$dsi$ifc$global$CarBCVolume = DSIGlobalTracer.class$("org.dsi.ifc.global.CarBCVolume")) : class$org$dsi$ifc$global$CarBCVolume, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CarViewOption == null ? (class$org$dsi$ifc$global$CarViewOption = DSIGlobalTracer.class$("org.dsi.ifc.global.CarViewOption")) : class$org$dsi$ifc$global$CarViewOption, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$CharacterInfo == null ? (class$org$dsi$ifc$global$CharacterInfo = DSIGlobalTracer.class$("org.dsi.ifc.global.CharacterInfo")) : class$org$dsi$ifc$global$CharacterInfo, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$DateTime == null ? (class$org$dsi$ifc$global$DateTime = DSIGlobalTracer.class$("org.dsi.ifc.global.DateTime")) : class$org$dsi$ifc$global$DateTime, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$NavLocation == null ? (class$org$dsi$ifc$global$NavLocation = DSIGlobalTracer.class$("org.dsi.ifc.global.NavLocation")) : class$org$dsi$ifc$global$NavLocation, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$NavLocationDescriptor == null ? (class$org$dsi$ifc$global$NavLocationDescriptor = DSIGlobalTracer.class$("org.dsi.ifc.global.NavLocationDescriptor")) : class$org$dsi$ifc$global$NavLocationDescriptor, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$NavLocationWgs84 == null ? (class$org$dsi$ifc$global$NavLocationWgs84 = DSIGlobalTracer.class$("org.dsi.ifc.global.NavLocationWgs84")) : class$org$dsi$ifc$global$NavLocationWgs84, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$NavPriceInfo == null ? (class$org$dsi$ifc$global$NavPriceInfo = DSIGlobalTracer.class$("org.dsi.ifc.global.NavPriceInfo")) : class$org$dsi$ifc$global$NavPriceInfo, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$NavRectangle == null ? (class$org$dsi$ifc$global$NavRectangle = DSIGlobalTracer.class$("org.dsi.ifc.global.NavRectangle")) : class$org$dsi$ifc$global$NavRectangle, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$NavSegmentID == null ? (class$org$dsi$ifc$global$NavSegmentID = DSIGlobalTracer.class$("org.dsi.ifc.global.NavSegmentID")) : class$org$dsi$ifc$global$NavSegmentID, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$ResourceLocator == null ? (class$org$dsi$ifc$global$ResourceLocator = DSIGlobalTracer.class$("org.dsi.ifc.global.ResourceLocator")) : class$org$dsi$ifc$global$ResourceLocator, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$global$StringAttribute == null ? (class$org$dsi$ifc$global$StringAttribute = DSIGlobalTracer.class$("org.dsi.ifc.global.StringAttribute")) : class$org$dsi$ifc$global$StringAttribute, 21);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceCarArrayListTransmittableElements(printWriter, (CarArrayListTransmittableElements)object);
                break;
            }
            case 2: {
                this.traceCarArrayListUpdateInfo(printWriter, (CarArrayListUpdateInfo)object);
                break;
            }
            case 3: {
                this.traceCarBCAcceleration(printWriter, (CarBCAcceleration)object);
                break;
            }
            case 4: {
                this.traceCarBCConsumption(printWriter, (CarBCConsumption)object);
                break;
            }
            case 5: {
                this.traceCarBCCurrentRange(printWriter, (CarBCCurrentRange)object);
                break;
            }
            case 6: {
                this.traceCarBCDistance(printWriter, (CarBCDistance)object);
                break;
            }
            case 7: {
                this.traceCarBCSpeed(printWriter, (CarBCSpeed)object);
                break;
            }
            case 8: {
                this.traceCarBCTemperature(printWriter, (CarBCTemperature)object);
                break;
            }
            case 9: {
                this.traceCarBCTime(printWriter, (CarBCTime)object);
                break;
            }
            case 10: {
                this.traceCarBCVolume(printWriter, (CarBCVolume)object);
                break;
            }
            case 11: {
                this.traceCarViewOption(printWriter, (CarViewOption)object);
                break;
            }
            case 12: {
                this.traceCharacterInfo(printWriter, (CharacterInfo)object);
                break;
            }
            case 13: {
                this.traceDateTime(printWriter, (DateTime)object);
                break;
            }
            case 14: {
                this.traceNavLocation(printWriter, (NavLocation)object);
                break;
            }
            case 15: {
                this.traceNavLocationDescriptor(printWriter, (NavLocationDescriptor)object);
                break;
            }
            case 16: {
                this.traceNavLocationWgs84(printWriter, (NavLocationWgs84)object);
                break;
            }
            case 17: {
                this.traceNavPriceInfo(printWriter, (NavPriceInfo)object);
                break;
            }
            case 18: {
                this.traceNavRectangle(printWriter, (NavRectangle)object);
                break;
            }
            case 19: {
                this.traceNavSegmentID(printWriter, (NavSegmentID)object);
                break;
            }
            case 20: {
                this.traceResourceLocator(printWriter, (ResourceLocator)object);
                break;
            }
            case 21: {
                this.traceStringAttribute(printWriter, (StringAttribute)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceCarArrayListTransmittableElements(PrintWriter printWriter, CarArrayListTransmittableElements carArrayListTransmittableElements) {
        if (carArrayListTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carArrayListTransmittableElements.ra0);
        printWriter.print(carArrayListTransmittableElements.ra1);
        printWriter.print(carArrayListTransmittableElements.ra2);
        printWriter.print(carArrayListTransmittableElements.ra3);
        printWriter.print(carArrayListTransmittableElements.ra4);
        printWriter.print(carArrayListTransmittableElements.ra5);
        printWriter.print(carArrayListTransmittableElements.ra6);
        printWriter.print(carArrayListTransmittableElements.ra7);
        printWriter.print(carArrayListTransmittableElements.ra8);
        printWriter.print(carArrayListTransmittableElements.ra9);
        printWriter.print(carArrayListTransmittableElements.raA);
        printWriter.print(carArrayListTransmittableElements.raB);
        printWriter.print(carArrayListTransmittableElements.raC);
        printWriter.print(carArrayListTransmittableElements.raD);
        printWriter.print(carArrayListTransmittableElements.raE);
        printWriter.print(carArrayListTransmittableElements.raF);
    }

    private void traceCarArrayListUpdateInfo(PrintWriter printWriter, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        if (carArrayListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carArrayListUpdateInfo.asgID);
        printWriter.print(carArrayListUpdateInfo.transactionID);
        printWriter.print(carArrayListUpdateInfo.recordContent);
        printWriter.print(carArrayListUpdateInfo.arrayContent);
        printWriter.print(carArrayListUpdateInfo.startElement);
        printWriter.print(carArrayListUpdateInfo.numOfElements);
    }

    private void traceCarBCAcceleration(PrintWriter printWriter, CarBCAcceleration carBCAcceleration) {
        if (carBCAcceleration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCAcceleration.state);
        printWriter.print(carBCAcceleration.accelerationValue);
        printWriter.print(carBCAcceleration.accelerationUnit);
    }

    private void traceCarBCConsumption(PrintWriter printWriter, CarBCConsumption carBCConsumption) {
        if (carBCConsumption == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCConsumption.state);
        printWriter.print(carBCConsumption.consumptionValue);
        printWriter.print(carBCConsumption.consumptionUnit);
    }

    private void traceCarBCCurrentRange(PrintWriter printWriter, CarBCCurrentRange carBCCurrentRange) {
        if (carBCCurrentRange == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCCurrentRange.state);
        printWriter.print(carBCCurrentRange.currentRangeValue);
        printWriter.print(carBCCurrentRange.currentRangeUnit);
    }

    private void traceCarBCDistance(PrintWriter printWriter, CarBCDistance carBCDistance) {
        if (carBCDistance == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCDistance.distanceValueState);
        printWriter.print(carBCDistance.distanceValue);
        printWriter.print(carBCDistance.distanceUnit);
    }

    private void traceCarBCSpeed(PrintWriter printWriter, CarBCSpeed carBCSpeed) {
        if (carBCSpeed == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCSpeed.speedValueState);
        printWriter.print(carBCSpeed.speedValue);
        printWriter.print(carBCSpeed.speedUnit);
    }

    private void traceCarBCTemperature(PrintWriter printWriter, CarBCTemperature carBCTemperature) {
        if (carBCTemperature == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCTemperature.state);
        printWriter.print(carBCTemperature.temperatureValue);
        printWriter.print(carBCTemperature.temperatureUnit);
    }

    private void traceCarBCTime(PrintWriter printWriter, CarBCTime carBCTime) {
        if (carBCTime == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCTime.state);
        printWriter.print(carBCTime.timeValue);
    }

    private void traceCarBCVolume(PrintWriter printWriter, CarBCVolume carBCVolume) {
        if (carBCVolume == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carBCVolume.state);
        printWriter.print(carBCVolume.volumeValue);
        printWriter.print(carBCVolume.volumeUnit);
    }

    private void traceCarViewOption(PrintWriter printWriter, CarViewOption carViewOption) {
        if (carViewOption == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(carViewOption.state);
        printWriter.print(carViewOption.reason);
    }

    private void traceCharacterInfo(PrintWriter printWriter, CharacterInfo characterInfo) {
        if (characterInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(characterInfo.value);
        printWriter.print(characterInfo.index);
    }

    private void traceDateTime(PrintWriter printWriter, DateTime dateTime) {
        if (dateTime == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dateTime.time);
    }

    private void traceNavLocation(PrintWriter printWriter, NavLocation navLocation) {
        if (navLocation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navLocation.version);
        printWriter.print(navLocation.versionOfLocationStructureValid);
        printWriter.print(navLocation.positionValid);
        printWriter.print(navLocation.longitude);
        printWriter.print(navLocation.latitude);
        printWriter.print(navLocation.altitude);
        printWriter.print(navLocation.country);
        printWriter.print(navLocation.countryAbbreviation);
        printWriter.print(navLocation.housenumber);
        printWriter.print(navLocation.junction);
        printWriter.print(navLocation.street);
        printWriter.print(navLocation.streetRefinement);
        printWriter.print(navLocation.town);
        printWriter.print(navLocation.towncenter);
        printWriter.print(navLocation.townRefinement);
        printWriter.print(navLocation.zipCode);
        if (navLocation.proprietaryData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navLocation.proprietaryData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, navLocation.proprietaryData[i2]);
            }
        }
    }

    private void traceNavLocationDescriptor(PrintWriter printWriter, NavLocationDescriptor navLocationDescriptor) {
        if (navLocationDescriptor == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navLocationDescriptor.selectionCriterion);
        printWriter.print(navLocationDescriptor.data);
    }

    private void traceNavLocationWgs84(PrintWriter printWriter, NavLocationWgs84 navLocationWgs84) {
        if (navLocationWgs84 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navLocationWgs84.longitude);
        printWriter.print(navLocationWgs84.latitude);
    }

    private void traceNavPriceInfo(PrintWriter printWriter, NavPriceInfo navPriceInfo) {
        if (navPriceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navPriceInfo.currency);
        printWriter.print(navPriceInfo.amount);
    }

    private void traceNavRectangle(PrintWriter printWriter, NavRectangle navRectangle) {
        if (navRectangle == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(navRectangle.xLeft);
        printWriter.print(navRectangle.xRight);
        printWriter.print(navRectangle.yBottom);
        printWriter.print(navRectangle.yUp);
        printWriter.print(navRectangle.rectangleInvalid);
    }

    private void traceNavSegmentID(PrintWriter printWriter, NavSegmentID navSegmentID) {
        if (navSegmentID == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (navSegmentID.elements == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = navSegmentID.elements.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(navSegmentID.elements[i2]);
            }
        }
    }

    private void traceResourceLocator(PrintWriter printWriter, ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(resourceLocator.id);
        printWriter.print(resourceLocator.url);
    }

    private void traceStringAttribute(PrintWriter printWriter, StringAttribute stringAttribute) {
        if (stringAttribute == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(stringAttribute.key);
        printWriter.print(stringAttribute.value);
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

