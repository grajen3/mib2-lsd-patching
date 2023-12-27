/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.sdars;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGProgramInfo;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.SeekState;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public final class DSISdarsTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CATEGORYINFO;
    private static final int ID_EPGDESCRIPTION;
    private static final int ID_EPGPROGRAMINFO;
    private static final int ID_EPGSHORTINFO;
    private static final int ID_IMAGEINFORMATION;
    private static final int ID_LEAGUEENTRY;
    private static final int ID_RADIOTEXT;
    private static final int ID_SEEKALERT;
    private static final int ID_SEEKENTRY;
    private static final int ID_SEEKINFORMATION;
    private static final int ID_SEEKPOSSIBILITY;
    private static final int ID_SEEKSTATE;
    private static final int ID_SERVICESTATUS3;
    private static final int ID_SIGNALQUALITY;
    private static final int ID_STATIONDESCRIPTION;
    private static final int ID_STATIONINFO;
    private static final int ID_SUBSCRIPTIONSTATUS;
    private static final int ID_TEAMENTRY;
    private static final int ID_TRAFFICWXENTRY;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$CategoryInfo;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$EPGDescription;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$EPGProgramInfo;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$EPGShortInfo;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$ImageInformation;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$LeagueEntry;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$RadioText;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$SeekAlert;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$SeekEntry;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$SeekInformation;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$SeekPossibility;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$SeekState;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$ServiceStatus3;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$SignalQuality;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$StationDescription;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$StationInfo;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$SubscriptionStatus;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$TeamEntry;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$TrafficWxEntry;

    public DSISdarsTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$CategoryInfo == null ? (class$org$dsi$ifc$sdars$CategoryInfo = DSISdarsTracer.class$("org.dsi.ifc.sdars.CategoryInfo")) : class$org$dsi$ifc$sdars$CategoryInfo, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$EPGDescription == null ? (class$org$dsi$ifc$sdars$EPGDescription = DSISdarsTracer.class$("org.dsi.ifc.sdars.EPGDescription")) : class$org$dsi$ifc$sdars$EPGDescription, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$EPGProgramInfo == null ? (class$org$dsi$ifc$sdars$EPGProgramInfo = DSISdarsTracer.class$("org.dsi.ifc.sdars.EPGProgramInfo")) : class$org$dsi$ifc$sdars$EPGProgramInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$EPGShortInfo == null ? (class$org$dsi$ifc$sdars$EPGShortInfo = DSISdarsTracer.class$("org.dsi.ifc.sdars.EPGShortInfo")) : class$org$dsi$ifc$sdars$EPGShortInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$ImageInformation == null ? (class$org$dsi$ifc$sdars$ImageInformation = DSISdarsTracer.class$("org.dsi.ifc.sdars.ImageInformation")) : class$org$dsi$ifc$sdars$ImageInformation, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$LeagueEntry == null ? (class$org$dsi$ifc$sdars$LeagueEntry = DSISdarsTracer.class$("org.dsi.ifc.sdars.LeagueEntry")) : class$org$dsi$ifc$sdars$LeagueEntry, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$RadioText == null ? (class$org$dsi$ifc$sdars$RadioText = DSISdarsTracer.class$("org.dsi.ifc.sdars.RadioText")) : class$org$dsi$ifc$sdars$RadioText, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$SeekAlert == null ? (class$org$dsi$ifc$sdars$SeekAlert = DSISdarsTracer.class$("org.dsi.ifc.sdars.SeekAlert")) : class$org$dsi$ifc$sdars$SeekAlert, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$SeekEntry == null ? (class$org$dsi$ifc$sdars$SeekEntry = DSISdarsTracer.class$("org.dsi.ifc.sdars.SeekEntry")) : class$org$dsi$ifc$sdars$SeekEntry, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$SeekInformation == null ? (class$org$dsi$ifc$sdars$SeekInformation = DSISdarsTracer.class$("org.dsi.ifc.sdars.SeekInformation")) : class$org$dsi$ifc$sdars$SeekInformation, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$SeekPossibility == null ? (class$org$dsi$ifc$sdars$SeekPossibility = DSISdarsTracer.class$("org.dsi.ifc.sdars.SeekPossibility")) : class$org$dsi$ifc$sdars$SeekPossibility, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$SeekState == null ? (class$org$dsi$ifc$sdars$SeekState = DSISdarsTracer.class$("org.dsi.ifc.sdars.SeekState")) : class$org$dsi$ifc$sdars$SeekState, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$ServiceStatus3 == null ? (class$org$dsi$ifc$sdars$ServiceStatus3 = DSISdarsTracer.class$("org.dsi.ifc.sdars.ServiceStatus3")) : class$org$dsi$ifc$sdars$ServiceStatus3, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$SignalQuality == null ? (class$org$dsi$ifc$sdars$SignalQuality = DSISdarsTracer.class$("org.dsi.ifc.sdars.SignalQuality")) : class$org$dsi$ifc$sdars$SignalQuality, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$StationDescription == null ? (class$org$dsi$ifc$sdars$StationDescription = DSISdarsTracer.class$("org.dsi.ifc.sdars.StationDescription")) : class$org$dsi$ifc$sdars$StationDescription, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$StationInfo == null ? (class$org$dsi$ifc$sdars$StationInfo = DSISdarsTracer.class$("org.dsi.ifc.sdars.StationInfo")) : class$org$dsi$ifc$sdars$StationInfo, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$SubscriptionStatus == null ? (class$org$dsi$ifc$sdars$SubscriptionStatus = DSISdarsTracer.class$("org.dsi.ifc.sdars.SubscriptionStatus")) : class$org$dsi$ifc$sdars$SubscriptionStatus, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$TeamEntry == null ? (class$org$dsi$ifc$sdars$TeamEntry = DSISdarsTracer.class$("org.dsi.ifc.sdars.TeamEntry")) : class$org$dsi$ifc$sdars$TeamEntry, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$sdars$TrafficWxEntry == null ? (class$org$dsi$ifc$sdars$TrafficWxEntry = DSISdarsTracer.class$("org.dsi.ifc.sdars.TrafficWxEntry")) : class$org$dsi$ifc$sdars$TrafficWxEntry, 19);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceCategoryInfo(printWriter, (CategoryInfo)object);
                break;
            }
            case 2: {
                this.traceEPGDescription(printWriter, (EPGDescription)object);
                break;
            }
            case 3: {
                this.traceEPGProgramInfo(printWriter, (EPGProgramInfo)object);
                break;
            }
            case 4: {
                this.traceEPGShortInfo(printWriter, (EPGShortInfo)object);
                break;
            }
            case 5: {
                this.traceImageInformation(printWriter, (ImageInformation)object);
                break;
            }
            case 6: {
                this.traceLeagueEntry(printWriter, (LeagueEntry)object);
                break;
            }
            case 7: {
                this.traceRadioText(printWriter, (RadioText)object);
                break;
            }
            case 8: {
                this.traceSeekAlert(printWriter, (SeekAlert)object);
                break;
            }
            case 9: {
                this.traceSeekEntry(printWriter, (SeekEntry)object);
                break;
            }
            case 10: {
                this.traceSeekInformation(printWriter, (SeekInformation)object);
                break;
            }
            case 11: {
                this.traceSeekPossibility(printWriter, (SeekPossibility)object);
                break;
            }
            case 12: {
                this.traceSeekState(printWriter, (SeekState)object);
                break;
            }
            case 13: {
                this.traceServiceStatus3(printWriter, (ServiceStatus3)object);
                break;
            }
            case 14: {
                this.traceSignalQuality(printWriter, (SignalQuality)object);
                break;
            }
            case 15: {
                this.traceStationDescription(printWriter, (StationDescription)object);
                break;
            }
            case 16: {
                this.traceStationInfo(printWriter, (StationInfo)object);
                break;
            }
            case 17: {
                this.traceSubscriptionStatus(printWriter, (SubscriptionStatus)object);
                break;
            }
            case 18: {
                this.traceTeamEntry(printWriter, (TeamEntry)object);
                break;
            }
            case 19: {
                this.traceTrafficWxEntry(printWriter, (TrafficWxEntry)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceCategoryInfo(PrintWriter printWriter, CategoryInfo categoryInfo) {
        if (categoryInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(categoryInfo.categoryNumber);
        printWriter.print(categoryInfo.shortLabel);
        printWriter.print(categoryInfo.fullLabel);
    }

    private void traceEPGDescription(PrintWriter printWriter, EPGDescription ePGDescription) {
        if (ePGDescription == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGDescription.sID);
        printWriter.print(ePGDescription.programID);
        printWriter.print(ePGDescription.seriesDescription);
        printWriter.print(ePGDescription.programDescription);
    }

    private void traceEPGProgramInfo(PrintWriter printWriter, EPGProgramInfo ePGProgramInfo) {
        if (ePGProgramInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGProgramInfo.programID);
        printWriter.print(ePGProgramInfo.seriesID);
        printWriter.print(ePGProgramInfo.startTime);
        printWriter.print(ePGProgramInfo.endTime);
        printWriter.print(ePGProgramInfo.shortProgramName);
        printWriter.print(ePGProgramInfo.longProgramName);
        printWriter.print(ePGProgramInfo.epgFlag);
    }

    private void traceEPGShortInfo(PrintWriter printWriter, EPGShortInfo ePGShortInfo) {
        if (ePGShortInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGShortInfo.sID);
        if (ePGShortInfo.epgProgramInfo == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = ePGShortInfo.epgProgramInfo.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, ePGShortInfo.epgProgramInfo[i2]);
            }
        }
    }

    private void traceImageInformation(PrintWriter printWriter, ImageInformation imageInformation) {
        if (imageInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(imageInformation.sID);
        this.trace(printWriter, imageInformation.image);
    }

    private void traceLeagueEntry(PrintWriter printWriter, LeagueEntry leagueEntry) {
        if (leagueEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(leagueEntry.seekID);
        printWriter.print(leagueEntry.contentLink);
        printWriter.print(leagueEntry.leagueName);
        printWriter.print(leagueEntry.leagueNameAbbrevation);
    }

    private void traceRadioText(PrintWriter printWriter, RadioText radioText) {
        if (radioText == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioText.sID);
        printWriter.print(radioText.shortArtistName);
        printWriter.print(radioText.longArtistName);
        printWriter.print(radioText.artistID);
        printWriter.print(radioText.shortProgramTitle);
        printWriter.print(radioText.longProgramTitle);
        printWriter.print(radioText.programID);
        printWriter.print(radioText.composer);
        printWriter.print(radioText.iTunesID);
    }

    private void traceSeekAlert(PrintWriter printWriter, SeekAlert seekAlert) {
        if (seekAlert == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seekAlert.seekID);
        printWriter.print(seekAlert.sID);
        printWriter.print(seekAlert.alertType);
    }

    private void traceSeekEntry(PrintWriter printWriter, SeekEntry seekEntry) {
        if (seekEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seekEntry.seekID);
        printWriter.print(seekEntry.contentLink);
        printWriter.print(seekEntry.typeOfContent);
        printWriter.print(seekEntry.title1);
        printWriter.print(seekEntry.title2);
        printWriter.print(seekEntry.seekActive);
    }

    private void traceSeekInformation(PrintWriter printWriter, SeekInformation seekInformation) {
        if (seekInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seekInformation.seekInfo);
        printWriter.print(seekInformation.seekText);
    }

    private void traceSeekPossibility(PrintWriter printWriter, SeekPossibility seekPossibility) {
        int n;
        int n2;
        if (seekPossibility == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seekPossibility.sID);
        printWriter.print(seekPossibility.typeOfContent);
        if (seekPossibility.seekState == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = seekPossibility.seekState.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, seekPossibility.seekState[n]);
            }
        }
        if (seekPossibility.seekInformation == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = seekPossibility.seekInformation.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, seekPossibility.seekInformation[n]);
            }
        }
    }

    private void traceSeekState(PrintWriter printWriter, SeekState seekState) {
        if (seekState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seekState.seekType);
        printWriter.print(seekState.state);
    }

    private void traceServiceStatus3(PrintWriter printWriter, ServiceStatus3 serviceStatus3) {
        if (serviceStatus3 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceStatus3.audioStatus);
        printWriter.print(serviceStatus3.antennaStatus);
        printWriter.print(serviceStatus3.listUpdateStatus);
        printWriter.print(serviceStatus3.listUpdatePercentage);
        printWriter.print(serviceStatus3.dataUpdateStatus);
        printWriter.print(serviceStatus3.dataSubscription);
        printWriter.print(serviceStatus3.subscriptionUpdateStatus);
    }

    private void traceSignalQuality(PrintWriter printWriter, SignalQuality signalQuality) {
        if (signalQuality == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(signalQuality.compositeQuality);
        printWriter.print(signalQuality.satelliteQuality);
        printWriter.print(signalQuality.terrestrialQuality);
    }

    private void traceStationDescription(PrintWriter printWriter, StationDescription stationDescription) {
        if (stationDescription == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(stationDescription.sID);
        printWriter.print(stationDescription.shortStationDescription);
        printWriter.print(stationDescription.longStationDescription);
        if (stationDescription.relatedStationArray == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = stationDescription.relatedStationArray.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(stationDescription.relatedStationArray[i2]);
            }
        }
    }

    private void traceStationInfo(PrintWriter printWriter, StationInfo stationInfo) {
        if (stationInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(stationInfo.stationNumber);
        printWriter.print(stationInfo.sID);
        printWriter.print(stationInfo.shortLabel);
        printWriter.print(stationInfo.fullLabel);
        printWriter.print(stationInfo.subscription);
        printWriter.print(stationInfo.categoryNumber);
        printWriter.print(stationInfo.mature);
        this.trace(printWriter, stationInfo.channelArt);
    }

    private void traceSubscriptionStatus(PrintWriter printWriter, SubscriptionStatus subscriptionStatus) {
        if (subscriptionStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(subscriptionStatus.subscription);
        printWriter.print(subscriptionStatus.reasonCode);
        printWriter.print(subscriptionStatus.suspendDay);
        printWriter.print(subscriptionStatus.suspendMonth);
        printWriter.print(subscriptionStatus.suspendYear);
        printWriter.print(subscriptionStatus.reasonText);
        printWriter.print(subscriptionStatus.phoneNumber);
    }

    private void traceTeamEntry(PrintWriter printWriter, TeamEntry teamEntry) {
        if (teamEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(teamEntry.seekID);
        printWriter.print(teamEntry.contentLink);
        printWriter.print(teamEntry.leagueLink);
        printWriter.print(teamEntry.teamName);
        printWriter.print(teamEntry.teamNameAbbrevation);
        printWriter.print(teamEntry.teamNameNick);
    }

    private void traceTrafficWxEntry(PrintWriter printWriter, TrafficWxEntry trafficWxEntry) {
        if (trafficWxEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficWxEntry.seekID);
        printWriter.print(trafficWxEntry.contentLink);
        printWriter.print(trafficWxEntry.marketName);
        printWriter.print(trafficWxEntry.marketNameAbbrevation);
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

