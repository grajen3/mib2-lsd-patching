/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.tmc;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tmc.TmcPhoneme;
import org.dsi.ifc.tmc.TrafficSource;

public final class DSITmcTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AREAWARNINGINFO;
    private static final int ID_LOCALHAZARDINFORMATION;
    private static final int ID_SPEEDANDFLOWSEGMENT;
    private static final int ID_TMCLISTELEMENT;
    private static final int ID_TMCMESSAGE;
    private static final int ID_TMCPHONEME;
    private static final int ID_TRAFFICSOURCE;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$AreaWarningInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$LocalHazardInformation;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$SpeedAndFlowSegment;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$TmcListElement;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$TmcMessage;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$TmcPhoneme;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$TrafficSource;

    public DSITmcTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tmc$AreaWarningInfo == null ? (class$org$dsi$ifc$tmc$AreaWarningInfo = DSITmcTracer.class$("org.dsi.ifc.tmc.AreaWarningInfo")) : class$org$dsi$ifc$tmc$AreaWarningInfo, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tmc$LocalHazardInformation == null ? (class$org$dsi$ifc$tmc$LocalHazardInformation = DSITmcTracer.class$("org.dsi.ifc.tmc.LocalHazardInformation")) : class$org$dsi$ifc$tmc$LocalHazardInformation, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tmc$SpeedAndFlowSegment == null ? (class$org$dsi$ifc$tmc$SpeedAndFlowSegment = DSITmcTracer.class$("org.dsi.ifc.tmc.SpeedAndFlowSegment")) : class$org$dsi$ifc$tmc$SpeedAndFlowSegment, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tmc$TmcListElement == null ? (class$org$dsi$ifc$tmc$TmcListElement = DSITmcTracer.class$("org.dsi.ifc.tmc.TmcListElement")) : class$org$dsi$ifc$tmc$TmcListElement, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tmc$TmcMessage == null ? (class$org$dsi$ifc$tmc$TmcMessage = DSITmcTracer.class$("org.dsi.ifc.tmc.TmcMessage")) : class$org$dsi$ifc$tmc$TmcMessage, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tmc$TmcPhoneme == null ? (class$org$dsi$ifc$tmc$TmcPhoneme = DSITmcTracer.class$("org.dsi.ifc.tmc.TmcPhoneme")) : class$org$dsi$ifc$tmc$TmcPhoneme, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tmc$TrafficSource == null ? (class$org$dsi$ifc$tmc$TrafficSource = DSITmcTracer.class$("org.dsi.ifc.tmc.TrafficSource")) : class$org$dsi$ifc$tmc$TrafficSource, 7);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAreaWarningInfo(printWriter, (AreaWarningInfo)object);
                break;
            }
            case 2: {
                this.traceLocalHazardInformation(printWriter, (LocalHazardInformation)object);
                break;
            }
            case 3: {
                this.traceSpeedAndFlowSegment(printWriter, (SpeedAndFlowSegment)object);
                break;
            }
            case 4: {
                this.traceTmcListElement(printWriter, (TmcListElement)object);
                break;
            }
            case 5: {
                this.traceTmcMessage(printWriter, (TmcMessage)object);
                break;
            }
            case 6: {
                this.traceTmcPhoneme(printWriter, (TmcPhoneme)object);
                break;
            }
            case 7: {
                this.traceTrafficSource(printWriter, (TrafficSource)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAreaWarningInfo(PrintWriter printWriter, AreaWarningInfo areaWarningInfo) {
        if (areaWarningInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(areaWarningInfo.type);
        printWriter.print(areaWarningInfo.reserved);
    }

    private void traceLocalHazardInformation(PrintWriter printWriter, LocalHazardInformation localHazardInformation) {
        if (localHazardInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(localHazardInformation.eventID);
        printWriter.print(localHazardInformation.eventType);
        printWriter.print(localHazardInformation.eventQuality);
        printWriter.print(localHazardInformation.distance);
    }

    private void traceSpeedAndFlowSegment(PrintWriter printWriter, SpeedAndFlowSegment speedAndFlowSegment) {
        if (speedAndFlowSegment == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(speedAndFlowSegment.id);
        printWriter.print(speedAndFlowSegment.severity);
        printWriter.print(speedAndFlowSegment.distance);
        printWriter.print(speedAndFlowSegment.destinationIndex);
    }

    private void traceTmcListElement(PrintWriter printWriter, TmcListElement tmcListElement) {
        if (tmcListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tmcListElement.streetSignId);
        this.trace(printWriter, tmcListElement.message);
        printWriter.print(tmcListElement.type);
        printWriter.print(tmcListElement.description);
        printWriter.print(tmcListElement.hasChild);
        printWriter.print(tmcListElement.uID);
        printWriter.print(tmcListElement.parentID);
        printWriter.print(tmcListElement.numberOfMessagesInNode);
        printWriter.print(tmcListElement.positionInCompleteList);
        printWriter.print(tmcListElement.directionOfRoad1);
        printWriter.print(tmcListElement.directionOfRoad2);
        printWriter.print(tmcListElement.isBidirectional);
        printWriter.print(tmcListElement.roadName);
        printWriter.print(tmcListElement.roadNumber);
        if (tmcListElement.iconIdList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = tmcListElement.iconIdList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(tmcListElement.iconIdList[i2]);
            }
        }
    }

    private void traceTmcMessage(PrintWriter printWriter, TmcMessage tmcMessage) {
        int n;
        int n2;
        if (tmcMessage == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tmcMessage.messageID);
        printWriter.print(tmcMessage.streetSignId);
        printWriter.print(tmcMessage.directionOfRoad1);
        printWriter.print(tmcMessage.directionOfRoad2);
        printWriter.print(tmcMessage.startLocation);
        printWriter.print(tmcMessage.endLocation);
        if (tmcMessage.eventText == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = tmcMessage.eventText.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(tmcMessage.eventText[n]);
            }
        }
        if (tmcMessage.iconListId == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = tmcMessage.iconListId.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(tmcMessage.iconListId[n]);
            }
        }
        printWriter.print(tmcMessage.routeRelevance);
        printWriter.print(tmcMessage.eventAverageSpeed);
        printWriter.print(tmcMessage.eventDuration);
        printWriter.print(tmcMessage.isBidirectional);
        printWriter.print(tmcMessage.hasGeoPos);
        printWriter.print(tmcMessage.geoPosLongitude);
        printWriter.print(tmcMessage.geoPosLatitude);
        printWriter.print(tmcMessage.eventDelay);
        printWriter.print(tmcMessage.distanceToEvent);
        printWriter.print(tmcMessage.messageCount);
        printWriter.print(tmcMessage.versionInfo);
        printWriter.print(tmcMessage.attentionPoint1);
        printWriter.print(tmcMessage.attentionPoint2);
        printWriter.print(tmcMessage.attentionPoint1Announcment);
        printWriter.print(tmcMessage.attentionPoint2Announcment);
        printWriter.print(tmcMessage.providerName);
        printWriter.print(tmcMessage.timeStamp);
        printWriter.print(tmcMessage.roadName);
        printWriter.print(tmcMessage.isArea);
        printWriter.print(tmcMessage.shouldBeAnnounced);
        printWriter.print(tmcMessage.roadNumber);
        printWriter.print(tmcMessage.urbanFlag);
        printWriter.print(tmcMessage.reserved);
        printWriter.print(tmcMessage.locationID);
        printWriter.print(tmcMessage.urgent);
        printWriter.print(tmcMessage.countryCodeTMC);
        printWriter.print(tmcMessage.countryAbbreviation);
        printWriter.print(tmcMessage.roadClass);
        if (tmcMessage.eventCode == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = tmcMessage.eventCode.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(tmcMessage.eventCode[n]);
            }
        }
        printWriter.print(tmcMessage.rawData);
        printWriter.print(tmcMessage.affectedRoadLength);
        this.trace(printWriter, tmcMessage.phoneme);
        printWriter.print(tmcMessage.routeDeviationIndication);
        printWriter.print(tmcMessage.startTime);
        printWriter.print(tmcMessage.endTime);
        printWriter.print(tmcMessage.estimaedLastingTime);
        printWriter.print(tmcMessage.affectsHOVLane);
        printWriter.print(tmcMessage.messageSource);
        printWriter.print(tmcMessage.destinationIndex);
        printWriter.print(tmcMessage.startTimeToDestination);
        printWriter.print(tmcMessage.exitNumber);
        printWriter.print(tmcMessage.exitIconId);
        printWriter.print(tmcMessage.streetCardinalDirection);
        printWriter.print(tmcMessage.affectedLengthOnRoute);
        printWriter.print(tmcMessage.eventDelayOnRoute);
        printWriter.print(tmcMessage.eventType);
    }

    private void traceTmcPhoneme(PrintWriter printWriter, TmcPhoneme tmcPhoneme) {
        if (tmcPhoneme == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tmcPhoneme.roadName);
        printWriter.print(tmcPhoneme.directionOfRoad1);
        printWriter.print(tmcPhoneme.directionOfRoad2);
        printWriter.print(tmcPhoneme.startLocation);
        printWriter.print(tmcPhoneme.endLocation);
        printWriter.print(tmcPhoneme.phonemeAlphabet);
    }

    private void traceTrafficSource(PrintWriter printWriter, TrafficSource trafficSource) {
        if (trafficSource == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficSource.trafficSourceType);
        printWriter.print(trafficSource.trafficSourceName);
        printWriter.print(trafficSource.trafficSourceState);
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

