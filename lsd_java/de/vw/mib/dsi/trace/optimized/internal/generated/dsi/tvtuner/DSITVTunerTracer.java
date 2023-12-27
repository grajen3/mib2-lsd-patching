/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.tvtuner;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;
import org.dsi.ifc.tvtuner.Time;

public final class DSITVTunerTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AUDIOCHANNEL;
    private static final int ID_EWSINFO;
    private static final int ID_LOGOINFO;
    private static final int ID_PROGRAMINFO;
    private static final int ID_SERVICEINFO;
    private static final int ID_STARTUPCONFIG;
    private static final int ID_TIME;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$AudioChannel;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$EWSInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$LogoInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$ProgramInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$ServiceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$StartUpConfig;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$Time;

    public DSITVTunerTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tvtuner$AudioChannel == null ? (class$org$dsi$ifc$tvtuner$AudioChannel = DSITVTunerTracer.class$("org.dsi.ifc.tvtuner.AudioChannel")) : class$org$dsi$ifc$tvtuner$AudioChannel, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tvtuner$EWSInfo == null ? (class$org$dsi$ifc$tvtuner$EWSInfo = DSITVTunerTracer.class$("org.dsi.ifc.tvtuner.EWSInfo")) : class$org$dsi$ifc$tvtuner$EWSInfo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tvtuner$LogoInfo == null ? (class$org$dsi$ifc$tvtuner$LogoInfo = DSITVTunerTracer.class$("org.dsi.ifc.tvtuner.LogoInfo")) : class$org$dsi$ifc$tvtuner$LogoInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tvtuner$ProgramInfo == null ? (class$org$dsi$ifc$tvtuner$ProgramInfo = DSITVTunerTracer.class$("org.dsi.ifc.tvtuner.ProgramInfo")) : class$org$dsi$ifc$tvtuner$ProgramInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tvtuner$ServiceInfo == null ? (class$org$dsi$ifc$tvtuner$ServiceInfo = DSITVTunerTracer.class$("org.dsi.ifc.tvtuner.ServiceInfo")) : class$org$dsi$ifc$tvtuner$ServiceInfo, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tvtuner$StartUpConfig == null ? (class$org$dsi$ifc$tvtuner$StartUpConfig = DSITVTunerTracer.class$("org.dsi.ifc.tvtuner.StartUpConfig")) : class$org$dsi$ifc$tvtuner$StartUpConfig, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tvtuner$Time == null ? (class$org$dsi$ifc$tvtuner$Time = DSITVTunerTracer.class$("org.dsi.ifc.tvtuner.Time")) : class$org$dsi$ifc$tvtuner$Time, 7);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAudioChannel(printWriter, (AudioChannel)object);
                break;
            }
            case 2: {
                this.traceEWSInfo(printWriter, (EWSInfo)object);
                break;
            }
            case 3: {
                this.traceLogoInfo(printWriter, (LogoInfo)object);
                break;
            }
            case 4: {
                this.traceProgramInfo(printWriter, (ProgramInfo)object);
                break;
            }
            case 5: {
                this.traceServiceInfo(printWriter, (ServiceInfo)object);
                break;
            }
            case 6: {
                this.traceStartUpConfig(printWriter, (StartUpConfig)object);
                break;
            }
            case 7: {
                this.traceTime(printWriter, (Time)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAudioChannel(PrintWriter printWriter, AudioChannel audioChannel) {
        if (audioChannel == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(audioChannel.channelID);
        printWriter.print(audioChannel.audioLanguage);
        printWriter.print(audioChannel.audioFormat);
        printWriter.print(audioChannel.audioDescription);
    }

    private void traceEWSInfo(PrintWriter printWriter, EWSInfo eWSInfo) {
        if (eWSInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(eWSInfo.namePID);
        printWriter.print(eWSInfo.servicePID);
        this.trace(printWriter, eWSInfo.warningTime);
        printWriter.print(eWSInfo.warningType);
        printWriter.print(eWSInfo.affectedArea);
        printWriter.print(eWSInfo.warningPrio);
        printWriter.print(eWSInfo.warningSrcClass);
        printWriter.print(eWSInfo.originCountry);
        printWriter.print(eWSInfo.ewsID);
        this.trace(printWriter, eWSInfo.receivingTime);
        printWriter.print(eWSInfo.messageText);
        if (eWSInfo.areaCodeListNames == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = eWSInfo.areaCodeListNames.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(eWSInfo.areaCodeListNames[i2]);
            }
        }
    }

    private void traceLogoInfo(PrintWriter printWriter, LogoInfo logoInfo) {
        if (logoInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(logoInfo.namePID);
        this.trace(printWriter, logoInfo.channelLogo);
    }

    private void traceProgramInfo(PrintWriter printWriter, ProgramInfo programInfo) {
        if (programInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, programInfo.serviceInfo);
        printWriter.print(programInfo.channelName);
        printWriter.print(programInfo.normArea);
        printWriter.print(programInfo.videoFormat);
        if (programInfo.availableAudioChannels == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = programInfo.availableAudioChannels.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, programInfo.availableAudioChannels[i2]);
            }
        }
        printWriter.print(programInfo.selectedAudioChannel);
        printWriter.print(programInfo.epgFlag);
        printWriter.print(programInfo.teletextFlag);
        printWriter.print(programInfo.variantDatabroadcastFlag);
        printWriter.print(programInfo.databroadcastFlag1);
        printWriter.print(programInfo.databroadcastFlag2);
        printWriter.print(programInfo.bwsFlag);
        printWriter.print(programInfo.slsFlag);
        printWriter.print(programInfo.txtFlag);
        printWriter.print(programInfo.casFlag);
        printWriter.print(programInfo.visAudioFlag);
        printWriter.print(programInfo.announcement);
        printWriter.print(programInfo.caDescriptor);
        printWriter.print(programInfo.casStatus);
        printWriter.print(programInfo.parentalRating);
        this.trace(printWriter, programInfo.nowStartTime);
        this.trace(printWriter, programInfo.nowEndTime);
        printWriter.print(programInfo.nowProgramInfo);
        this.trace(printWriter, programInfo.nextStartTime);
        this.trace(printWriter, programInfo.nextEndTime);
        printWriter.print(programInfo.nextProgramInfo);
        printWriter.print(programInfo.subtitleFlag);
    }

    private void traceServiceInfo(PrintWriter printWriter, ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceInfo.namePID);
        printWriter.print(serviceInfo.servicePID);
        printWriter.print(serviceInfo.name);
        printWriter.print(serviceInfo.sType);
        printWriter.print(serviceInfo.contentGroup);
    }

    private void traceStartUpConfig(PrintWriter printWriter, StartUpConfig startUpConfig) {
        if (startUpConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(startUpConfig.systemID);
        printWriter.print(startUpConfig.oemCodingVar);
        printWriter.print(startUpConfig.linkingAvail);
        printWriter.print(startUpConfig.avSrcAvail);
        printWriter.print(startUpConfig.tvNormAvail);
        printWriter.print(startUpConfig.audioChannelAvail);
        printWriter.print(startUpConfig.videoFormatAvail);
        printWriter.print(startUpConfig.avNormAvail);
        printWriter.print(startUpConfig.avFormatAvail);
        printWriter.print(startUpConfig.subtitleAvail);
        printWriter.print(startUpConfig.ewsAvail);
        printWriter.print(startUpConfig.logoListAvail);
        printWriter.print(startUpConfig.tpegAvail);
        printWriter.print(startUpConfig.casAvail);
        printWriter.print(startUpConfig.skipBehaviourAvail);
        printWriter.print(startUpConfig.visualAudioAvail);
        printWriter.print(startUpConfig.tmTeletextAvail);
        printWriter.print(startUpConfig.tmDatabroadDVBAvail);
        printWriter.print(startUpConfig.tmDatabroadISDBAvail);
        printWriter.print(startUpConfig.tmDatabroadDTMBAvail);
        printWriter.print(startUpConfig.tmDatabroadDMBAvail);
        printWriter.print(startUpConfig.tmDatabroadATSCAvail);
        printWriter.print(startUpConfig.tmDatabroad1Avail);
        printWriter.print(startUpConfig.tmDatabroad2Avail);
        printWriter.print(startUpConfig.tmBWSAvail);
        printWriter.print(startUpConfig.tmSLSDLSAvail);
        printWriter.print(startUpConfig.tmTXTAvail);
        printWriter.print(startUpConfig.tmCASAvail);
        printWriter.print(startUpConfig.tmEPGAvail);
        printWriter.print(startUpConfig.tmVisualAudioAvail);
        if (startUpConfig.requiredKeypanelList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = startUpConfig.requiredKeypanelList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(startUpConfig.requiredKeypanelList[i2]);
            }
        }
        printWriter.print(startUpConfig.browserListSortAvail);
        printWriter.print(startUpConfig.parentalControlReq);
    }

    private void traceTime(PrintWriter printWriter, Time time) {
        if (time == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(time.hour);
        printWriter.print(time.minute);
        printWriter.print(time.second);
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

