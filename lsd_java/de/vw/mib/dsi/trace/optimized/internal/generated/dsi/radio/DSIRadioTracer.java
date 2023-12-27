/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.radio;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGExtendedFullProgramInfo;
import org.dsi.ifc.radio.EPGExtendedShortProgramInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGFullProgramInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGLogoDescriptor;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EPGShortProgramInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.IntellitextSubmenu;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;
import org.dsi.ifc.radio.WavebandInfo;

public final class DSIRadioTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AMFMRADIOTEXT;
    private static final int ID_AUDIOSTATUS;
    private static final int ID_COMPONENTINFO;
    private static final int ID_DABRADIOTEXT;
    private static final int ID_DABRADIOTEXTPLUSINFO;
    private static final int ID_DABSLIDESHOWINFO;
    private static final int ID_DATASERVICEINFO;
    private static final int ID_EPGEXTENDEDFULLPROGRAMINFO;
    private static final int ID_EPGEXTENDEDSHORTPROGRAMINFO;
    private static final int ID_EPGFULLINFO;
    private static final int ID_EPGFULLPROGRAMINFO;
    private static final int ID_EPGLOGO;
    private static final int ID_EPGLOGODESCRIPTOR;
    private static final int ID_EPGSHORTINFO;
    private static final int ID_EPGSHORTPROGRAMINFO;
    private static final int ID_ENSEMBLEINFO;
    private static final int ID_FREQUENCYINFO;
    private static final int ID_HDSTATIONINFO;
    private static final int ID_INTELLITEXTMENU;
    private static final int ID_INTELLITEXTSUBMENU;
    private static final int ID_SERVICEINFO;
    private static final int ID_STATION;
    private static final int ID_TIMMEMOUSAGE;
    private static final int ID_TIMMESSAGE;
    private static final int ID_TIMSTATUS;
    private static final int ID_UNIFIEDRADIOTEXT;
    private static final int ID_UNIFIEDRADIOTEXTPLUS;
    private static final int ID_UNIFIEDSTATION;
    private static final int ID_WAVEBANDINFO;
    static /* synthetic */ Class class$org$dsi$ifc$radio$AMFMRadioText;
    static /* synthetic */ Class class$org$dsi$ifc$radio$AudioStatus;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ComponentInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DABRadioText;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DABRadioTextPlusInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DABSlideShowInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DataServiceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGExtendedFullProgramInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGExtendedShortProgramInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGFullInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGFullProgramInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGLogo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGLogoDescriptor;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGShortInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EPGShortProgramInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EnsembleInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$FrequencyInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$HdStationInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$IntellitextMenu;
    static /* synthetic */ Class class$org$dsi$ifc$radio$IntellitextSubmenu;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ServiceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$Station;
    static /* synthetic */ Class class$org$dsi$ifc$radio$TIMMemoUsage;
    static /* synthetic */ Class class$org$dsi$ifc$radio$TIMMessage;
    static /* synthetic */ Class class$org$dsi$ifc$radio$TIMStatus;
    static /* synthetic */ Class class$org$dsi$ifc$radio$UnifiedRadioText;
    static /* synthetic */ Class class$org$dsi$ifc$radio$UnifiedRadioTextPlus;
    static /* synthetic */ Class class$org$dsi$ifc$radio$UnifiedStation;
    static /* synthetic */ Class class$org$dsi$ifc$radio$WavebandInfo;

    public DSIRadioTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$AMFMRadioText == null ? (class$org$dsi$ifc$radio$AMFMRadioText = DSIRadioTracer.class$("org.dsi.ifc.radio.AMFMRadioText")) : class$org$dsi$ifc$radio$AMFMRadioText, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$AudioStatus == null ? (class$org$dsi$ifc$radio$AudioStatus = DSIRadioTracer.class$("org.dsi.ifc.radio.AudioStatus")) : class$org$dsi$ifc$radio$AudioStatus, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$DABRadioText == null ? (class$org$dsi$ifc$radio$DABRadioText = DSIRadioTracer.class$("org.dsi.ifc.radio.DABRadioText")) : class$org$dsi$ifc$radio$DABRadioText, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$DABRadioTextPlusInfo == null ? (class$org$dsi$ifc$radio$DABRadioTextPlusInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.DABRadioTextPlusInfo")) : class$org$dsi$ifc$radio$DABRadioTextPlusInfo, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$DABSlideShowInfo == null ? (class$org$dsi$ifc$radio$DABSlideShowInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.DABSlideShowInfo")) : class$org$dsi$ifc$radio$DABSlideShowInfo, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$DataServiceInfo == null ? (class$org$dsi$ifc$radio$DataServiceInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.DataServiceInfo")) : class$org$dsi$ifc$radio$DataServiceInfo, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGExtendedFullProgramInfo == null ? (class$org$dsi$ifc$radio$EPGExtendedFullProgramInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGExtendedFullProgramInfo")) : class$org$dsi$ifc$radio$EPGExtendedFullProgramInfo, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGExtendedShortProgramInfo == null ? (class$org$dsi$ifc$radio$EPGExtendedShortProgramInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGExtendedShortProgramInfo")) : class$org$dsi$ifc$radio$EPGExtendedShortProgramInfo, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGFullInfo == null ? (class$org$dsi$ifc$radio$EPGFullInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGFullInfo")) : class$org$dsi$ifc$radio$EPGFullInfo, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGFullProgramInfo == null ? (class$org$dsi$ifc$radio$EPGFullProgramInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGFullProgramInfo")) : class$org$dsi$ifc$radio$EPGFullProgramInfo, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGLogo == null ? (class$org$dsi$ifc$radio$EPGLogo = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGLogo")) : class$org$dsi$ifc$radio$EPGLogo, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGLogoDescriptor == null ? (class$org$dsi$ifc$radio$EPGLogoDescriptor = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGLogoDescriptor")) : class$org$dsi$ifc$radio$EPGLogoDescriptor, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGShortInfo == null ? (class$org$dsi$ifc$radio$EPGShortInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGShortInfo")) : class$org$dsi$ifc$radio$EPGShortInfo, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EPGShortProgramInfo == null ? (class$org$dsi$ifc$radio$EPGShortProgramInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.EPGShortProgramInfo")) : class$org$dsi$ifc$radio$EPGShortProgramInfo, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$FrequencyInfo == null ? (class$org$dsi$ifc$radio$FrequencyInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.FrequencyInfo")) : class$org$dsi$ifc$radio$FrequencyInfo, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$HdStationInfo == null ? (class$org$dsi$ifc$radio$HdStationInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.HdStationInfo")) : class$org$dsi$ifc$radio$HdStationInfo, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$IntellitextMenu == null ? (class$org$dsi$ifc$radio$IntellitextMenu = DSIRadioTracer.class$("org.dsi.ifc.radio.IntellitextMenu")) : class$org$dsi$ifc$radio$IntellitextMenu, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$IntellitextSubmenu == null ? (class$org$dsi$ifc$radio$IntellitextSubmenu = DSIRadioTracer.class$("org.dsi.ifc.radio.IntellitextSubmenu")) : class$org$dsi$ifc$radio$IntellitextSubmenu, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$Station == null ? (class$org$dsi$ifc$radio$Station = DSIRadioTracer.class$("org.dsi.ifc.radio.Station")) : class$org$dsi$ifc$radio$Station, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$TIMMemoUsage == null ? (class$org$dsi$ifc$radio$TIMMemoUsage = DSIRadioTracer.class$("org.dsi.ifc.radio.TIMMemoUsage")) : class$org$dsi$ifc$radio$TIMMemoUsage, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$TIMMessage == null ? (class$org$dsi$ifc$radio$TIMMessage = DSIRadioTracer.class$("org.dsi.ifc.radio.TIMMessage")) : class$org$dsi$ifc$radio$TIMMessage, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$TIMStatus == null ? (class$org$dsi$ifc$radio$TIMStatus = DSIRadioTracer.class$("org.dsi.ifc.radio.TIMStatus")) : class$org$dsi$ifc$radio$TIMStatus, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$UnifiedRadioText == null ? (class$org$dsi$ifc$radio$UnifiedRadioText = DSIRadioTracer.class$("org.dsi.ifc.radio.UnifiedRadioText")) : class$org$dsi$ifc$radio$UnifiedRadioText, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$UnifiedRadioTextPlus == null ? (class$org$dsi$ifc$radio$UnifiedRadioTextPlus = DSIRadioTracer.class$("org.dsi.ifc.radio.UnifiedRadioTextPlus")) : class$org$dsi$ifc$radio$UnifiedRadioTextPlus, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$UnifiedStation == null ? (class$org$dsi$ifc$radio$UnifiedStation = DSIRadioTracer.class$("org.dsi.ifc.radio.UnifiedStation")) : class$org$dsi$ifc$radio$UnifiedStation, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radio$WavebandInfo == null ? (class$org$dsi$ifc$radio$WavebandInfo = DSIRadioTracer.class$("org.dsi.ifc.radio.WavebandInfo")) : class$org$dsi$ifc$radio$WavebandInfo, 29);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAMFMRadioText(printWriter, (AMFMRadioText)object);
                break;
            }
            case 2: {
                this.traceAudioStatus(printWriter, (AudioStatus)object);
                break;
            }
            case 3: {
                this.traceComponentInfo(printWriter, (ComponentInfo)object);
                break;
            }
            case 4: {
                this.traceDABRadioText(printWriter, (DABRadioText)object);
                break;
            }
            case 5: {
                this.traceDABRadioTextPlusInfo(printWriter, (DABRadioTextPlusInfo)object);
                break;
            }
            case 6: {
                this.traceDABSlideShowInfo(printWriter, (DABSlideShowInfo)object);
                break;
            }
            case 7: {
                this.traceDataServiceInfo(printWriter, (DataServiceInfo)object);
                break;
            }
            case 8: {
                this.traceEPGExtendedFullProgramInfo(printWriter, (EPGExtendedFullProgramInfo)object);
                break;
            }
            case 9: {
                this.traceEPGExtendedShortProgramInfo(printWriter, (EPGExtendedShortProgramInfo)object);
                break;
            }
            case 10: {
                this.traceEPGFullInfo(printWriter, (EPGFullInfo)object);
                break;
            }
            case 11: {
                this.traceEPGFullProgramInfo(printWriter, (EPGFullProgramInfo)object);
                break;
            }
            case 12: {
                this.traceEPGLogo(printWriter, (EPGLogo)object);
                break;
            }
            case 13: {
                this.traceEPGLogoDescriptor(printWriter, (EPGLogoDescriptor)object);
                break;
            }
            case 14: {
                this.traceEPGShortInfo(printWriter, (EPGShortInfo)object);
                break;
            }
            case 15: {
                this.traceEPGShortProgramInfo(printWriter, (EPGShortProgramInfo)object);
                break;
            }
            case 16: {
                this.traceEnsembleInfo(printWriter, (EnsembleInfo)object);
                break;
            }
            case 17: {
                this.traceFrequencyInfo(printWriter, (FrequencyInfo)object);
                break;
            }
            case 18: {
                this.traceHdStationInfo(printWriter, (HdStationInfo)object);
                break;
            }
            case 19: {
                this.traceIntellitextMenu(printWriter, (IntellitextMenu)object);
                break;
            }
            case 20: {
                this.traceIntellitextSubmenu(printWriter, (IntellitextSubmenu)object);
                break;
            }
            case 21: {
                this.traceServiceInfo(printWriter, (ServiceInfo)object);
                break;
            }
            case 22: {
                this.traceStation(printWriter, (Station)object);
                break;
            }
            case 23: {
                this.traceTIMMemoUsage(printWriter, (TIMMemoUsage)object);
                break;
            }
            case 24: {
                this.traceTIMMessage(printWriter, (TIMMessage)object);
                break;
            }
            case 25: {
                this.traceTIMStatus(printWriter, (TIMStatus)object);
                break;
            }
            case 26: {
                this.traceUnifiedRadioText(printWriter, (UnifiedRadioText)object);
                break;
            }
            case 27: {
                this.traceUnifiedRadioTextPlus(printWriter, (UnifiedRadioTextPlus)object);
                break;
            }
            case 28: {
                this.traceUnifiedStation(printWriter, (UnifiedStation)object);
                break;
            }
            case 29: {
                this.traceWavebandInfo(printWriter, (WavebandInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAMFMRadioText(PrintWriter printWriter, AMFMRadioText aMFMRadioText) {
        if (aMFMRadioText == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aMFMRadioText.pi);
        printWriter.print(aMFMRadioText.text);
    }

    private void traceAudioStatus(PrintWriter printWriter, AudioStatus audioStatus) {
        if (audioStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(audioStatus.sID);
        printWriter.print(audioStatus.sCIDI);
        printWriter.print(audioStatus.dRCStatus);
        printWriter.print(audioStatus.musicSpeech);
        printWriter.print(audioStatus.audioMode);
        printWriter.print(audioStatus.decodingAlgorithm);
        printWriter.print(audioStatus.audioBitrate);
        printWriter.print(audioStatus.originalStatus);
        printWriter.print(audioStatus.copyrightStatus);
        printWriter.print(audioStatus.samplingRate);
    }

    private void traceComponentInfo(PrintWriter printWriter, ComponentInfo componentInfo) {
        if (componentInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(componentInfo.ensID);
        printWriter.print(componentInfo.ensECC);
        printWriter.print(componentInfo.sID);
        printWriter.print(componentInfo.sCIDI);
        printWriter.print(componentInfo.shortName);
        printWriter.print(componentInfo.fullName);
        printWriter.print(componentInfo.primaryService);
        printWriter.print(componentInfo.radiotext);
    }

    private void traceDABRadioText(PrintWriter printWriter, DABRadioText dABRadioText) {
        if (dABRadioText == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dABRadioText.ensID);
        printWriter.print(dABRadioText.ensECC);
        printWriter.print(dABRadioText.sID);
        printWriter.print(dABRadioText.sCIDI);
        printWriter.print(dABRadioText.text);
    }

    private void traceDABRadioTextPlusInfo(PrintWriter printWriter, DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        int n;
        int n2;
        if (dABRadioTextPlusInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dABRadioTextPlusInfo.ensID);
        printWriter.print(dABRadioTextPlusInfo.ensECC);
        printWriter.print(dABRadioTextPlusInfo.sID);
        printWriter.print(dABRadioTextPlusInfo.sCIDI);
        if (dABRadioTextPlusInfo.tags == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = dABRadioTextPlusInfo.tags.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(dABRadioTextPlusInfo.tags[n]);
            }
        }
        if (dABRadioTextPlusInfo.content == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = dABRadioTextPlusInfo.content.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(dABRadioTextPlusInfo.content[n]);
            }
        }
    }

    private void traceDABSlideShowInfo(PrintWriter printWriter, DABSlideShowInfo dABSlideShowInfo) {
        if (dABSlideShowInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dABSlideShowInfo.ensID);
        printWriter.print(dABSlideShowInfo.ensECC);
        printWriter.print(dABSlideShowInfo.sID);
        printWriter.print(dABSlideShowInfo.sCIDI);
        this.trace(printWriter, dABSlideShowInfo.slideshowImage);
        printWriter.print(dABSlideShowInfo.category);
    }

    private void traceDataServiceInfo(PrintWriter printWriter, DataServiceInfo dataServiceInfo) {
        if (dataServiceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataServiceInfo.ensID);
        printWriter.print(dataServiceInfo.ensECC);
        printWriter.print(dataServiceInfo.sID);
        printWriter.print(dataServiceInfo.sCIDI);
        printWriter.print(dataServiceInfo.type);
        printWriter.print(dataServiceInfo.serviceAbbreviationMatrix);
        printWriter.print(dataServiceInfo.serviceShortName);
        printWriter.print(dataServiceInfo.serviceFullName);
        printWriter.print(dataServiceInfo.componentAbbreviationMatrix);
        printWriter.print(dataServiceInfo.componentShortName);
        printWriter.print(dataServiceInfo.componentFullName);
        printWriter.print(dataServiceInfo.uRL);
    }

    private void traceEPGExtendedFullProgramInfo(PrintWriter printWriter, EPGExtendedFullProgramInfo ePGExtendedFullProgramInfo) {
        if (ePGExtendedFullProgramInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (ePGExtendedFullProgramInfo.fullProgramInfoList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = ePGExtendedFullProgramInfo.fullProgramInfoList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, ePGExtendedFullProgramInfo.fullProgramInfoList[i2]);
            }
        }
    }

    private void traceEPGExtendedShortProgramInfo(PrintWriter printWriter, EPGExtendedShortProgramInfo ePGExtendedShortProgramInfo) {
        if (ePGExtendedShortProgramInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (ePGExtendedShortProgramInfo.shortProgramInfoList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = ePGExtendedShortProgramInfo.shortProgramInfoList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, ePGExtendedShortProgramInfo.shortProgramInfoList[i2]);
            }
        }
    }

    private void traceEPGFullInfo(PrintWriter printWriter, EPGFullInfo ePGFullInfo) {
        if (ePGFullInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGFullInfo.ensID);
        printWriter.print(ePGFullInfo.ensECC);
        printWriter.print(ePGFullInfo.sID);
        printWriter.print(ePGFullInfo.sCIDI);
        this.trace(printWriter, ePGFullInfo.nowProgramInfo);
        this.trace(printWriter, ePGFullInfo.nextProgramInfo);
        this.trace(printWriter, ePGFullInfo.extendedProgramInfo);
    }

    private void traceEPGFullProgramInfo(PrintWriter printWriter, EPGFullProgramInfo ePGFullProgramInfo) {
        if (ePGFullProgramInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, ePGFullProgramInfo.shortInfo);
        printWriter.print(ePGFullProgramInfo.contentGroup);
        printWriter.print(ePGFullProgramInfo.detailProgramInfo);
    }

    private void traceEPGLogo(PrintWriter printWriter, EPGLogo ePGLogo) {
        if (ePGLogo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGLogo.sID);
        printWriter.print(ePGLogo.ensID);
        printWriter.print(ePGLogo.ensECC);
        printWriter.print(ePGLogo.sCIDI);
        if (ePGLogo.epgDescriptorList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = ePGLogo.epgDescriptorList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, ePGLogo.epgDescriptorList[i2]);
            }
        }
    }

    private void traceEPGLogoDescriptor(PrintWriter printWriter, EPGLogoDescriptor ePGLogoDescriptor) {
        if (ePGLogoDescriptor == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGLogoDescriptor.logoType);
        printWriter.print(ePGLogoDescriptor.mimeType);
        printWriter.print(ePGLogoDescriptor.widthX);
        printWriter.print(ePGLogoDescriptor.heightY);
        this.trace(printWriter, ePGLogoDescriptor.picture);
    }

    private void traceEPGShortInfo(PrintWriter printWriter, EPGShortInfo ePGShortInfo) {
        if (ePGShortInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGShortInfo.ensID);
        printWriter.print(ePGShortInfo.ensECC);
        printWriter.print(ePGShortInfo.sID);
        printWriter.print(ePGShortInfo.sCIDI);
        this.trace(printWriter, ePGShortInfo.nowProgramInfo);
        this.trace(printWriter, ePGShortInfo.nextProgramInfo);
        this.trace(printWriter, ePGShortInfo.extendedProgramInfo);
    }

    private void traceEPGShortProgramInfo(PrintWriter printWriter, EPGShortProgramInfo ePGShortProgramInfo) {
        if (ePGShortProgramInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ePGShortProgramInfo.programInfo);
        this.trace(printWriter, ePGShortProgramInfo.startTime);
        this.trace(printWriter, ePGShortProgramInfo.endTime);
    }

    private void traceEnsembleInfo(PrintWriter printWriter, EnsembleInfo ensembleInfo) {
        if (ensembleInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(ensembleInfo.ensID);
        printWriter.print(ensembleInfo.ensECC);
        printWriter.print(ensembleInfo.shortName);
        printWriter.print(ensembleInfo.fullName);
        printWriter.print(ensembleInfo.frequencyLabel);
        printWriter.print(ensembleInfo.frequencyValue);
        printWriter.print(ensembleInfo.tp);
        printWriter.print(ensembleInfo.potentiallyReceivable);
    }

    private void traceFrequencyInfo(PrintWriter printWriter, FrequencyInfo frequencyInfo) {
        if (frequencyInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(frequencyInfo.frequency);
        printWriter.print(frequencyInfo.label);
    }

    private void traceHdStationInfo(PrintWriter printWriter, HdStationInfo hdStationInfo) {
        if (hdStationInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hdStationInfo.artistName);
        printWriter.print(hdStationInfo.albumTitle);
        printWriter.print(hdStationInfo.songTitle);
        printWriter.print(hdStationInfo.genre);
        this.trace(printWriter, hdStationInfo.stationArt);
        this.trace(printWriter, hdStationInfo.coverArt);
        printWriter.print(hdStationInfo.language);
        printWriter.print(hdStationInfo.shortDescription);
        printWriter.print(hdStationInfo.contentField);
        printWriter.print(hdStationInfo.price);
        printWriter.print(hdStationInfo.validUntil);
        printWriter.print(hdStationInfo.contactURL);
        printWriter.print(hdStationInfo.receivedAs);
        printWriter.print(hdStationInfo.nameOfSeller);
        printWriter.print(hdStationInfo.comrDescription);
        printWriter.print(hdStationInfo.mimeType);
        if (hdStationInfo.binaryData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = hdStationInfo.binaryData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(hdStationInfo.binaryData[i2]);
            }
        }
        printWriter.print(hdStationInfo.affiliateID);
        printWriter.print(hdStationInfo.iTunesID);
        printWriter.print(hdStationInfo.iTunesFrontID);
        printWriter.print(hdStationInfo.podcastFeedURL);
        printWriter.print(hdStationInfo.unknownData);
        printWriter.print(hdStationInfo.frequency);
        printWriter.print(hdStationInfo.pi);
        printWriter.print(hdStationInfo.serviceId);
        printWriter.print(hdStationInfo.stationURL);
    }

    private void traceIntellitextMenu(PrintWriter printWriter, IntellitextMenu intellitextMenu) {
        if (intellitextMenu == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intellitextMenu.name);
        if (intellitextMenu.submenuList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = intellitextMenu.submenuList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, intellitextMenu.submenuList[i2]);
            }
        }
    }

    private void traceIntellitextSubmenu(PrintWriter printWriter, IntellitextSubmenu intellitextSubmenu) {
        if (intellitextSubmenu == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intellitextSubmenu.name);
        if (intellitextSubmenu.dataList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = intellitextSubmenu.dataList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(intellitextSubmenu.dataList[i2]);
            }
        }
    }

    private void traceServiceInfo(PrintWriter printWriter, ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceInfo.ensID);
        printWriter.print(serviceInfo.ensECC);
        printWriter.print(serviceInfo.sID);
        printWriter.print(serviceInfo.shortName);
        printWriter.print(serviceInfo.fullName);
        if (serviceInfo.ptyCodes == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = serviceInfo.ptyCodes.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(serviceInfo.ptyCodes[i2]);
            }
        }
        printWriter.print(serviceInfo.tp);
        printWriter.print(serviceInfo.radiotext);
    }

    private void traceStation(PrintWriter printWriter, Station station) {
        if (station == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(station.name);
        printWriter.print(station.frequency);
        printWriter.print(station.pi);
        printWriter.print(station.receptionQuality);
        printWriter.print(station.ptyCode);
        printWriter.print(station.waveband);
        printWriter.print(station.rds);
        printWriter.print(station.tp);
        printWriter.print(station.ta);
        printWriter.print(station.tmc);
        printWriter.print(station.scrollingPS);
        printWriter.print(station.radioText);
        printWriter.print(station.realPS);
        printWriter.print(station.hd);
        printWriter.print(station.shortNameHD);
        printWriter.print(station.longNameHD);
        printWriter.print(station.fullDigital);
        printWriter.print(station.serviceId);
        printWriter.print(station.subscription);
        printWriter.print(station.eon);
        printWriter.print(station.coChannel);
        this.trace(printWriter, station.stationArt);
    }

    private void traceTIMMemoUsage(PrintWriter printWriter, TIMMemoUsage tIMMemoUsage) {
        if (tIMMemoUsage == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tIMMemoUsage.memoUsage);
        printWriter.print(tIMMemoUsage.freeListRows);
    }

    private void traceTIMMessage(PrintWriter printWriter, TIMMessage tIMMessage) {
        if (tIMMessage == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tIMMessage.name);
        printWriter.print(tIMMessage.pi);
        printWriter.print(tIMMessage.frequency);
        printWriter.print(tIMMessage.messageID);
        printWriter.print(tIMMessage.lengthSeconds);
        printWriter.print(tIMMessage.lengthMinutes);
        printWriter.print(tIMMessage.recordTimeSeconds);
        printWriter.print(tIMMessage.recordTimeMinutes);
        printWriter.print(tIMMessage.recordTimeHour);
        printWriter.print(tIMMessage.recordTimeDay);
        printWriter.print(tIMMessage.recordTimeMonth);
        printWriter.print(tIMMessage.recordTimeYear);
    }

    private void traceTIMStatus(PrintWriter printWriter, TIMStatus tIMStatus) {
        if (tIMStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tIMStatus.status);
        printWriter.print(tIMStatus.timePosition);
    }

    private void traceUnifiedRadioText(PrintWriter printWriter, UnifiedRadioText unifiedRadioText) {
        if (unifiedRadioText == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(unifiedRadioText.piSId);
        printWriter.print(unifiedRadioText.ensId);
        printWriter.print(unifiedRadioText.ecc);
        printWriter.print(unifiedRadioText.sCIDI);
        printWriter.print(unifiedRadioText.radioText);
        printWriter.print(unifiedRadioText.source);
    }

    private void traceUnifiedRadioTextPlus(PrintWriter printWriter, UnifiedRadioTextPlus unifiedRadioTextPlus) {
        int n;
        int n2;
        if (unifiedRadioTextPlus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(unifiedRadioTextPlus.piSId);
        printWriter.print(unifiedRadioTextPlus.ensId);
        printWriter.print(unifiedRadioTextPlus.ecc);
        printWriter.print(unifiedRadioTextPlus.sCIDI);
        if (unifiedRadioTextPlus.tags == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = unifiedRadioTextPlus.tags.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(unifiedRadioTextPlus.tags[n]);
            }
        }
        if (unifiedRadioTextPlus.content == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = unifiedRadioTextPlus.content.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(unifiedRadioTextPlus.content[n]);
            }
        }
        printWriter.print(unifiedRadioTextPlus.source);
    }

    private void traceUnifiedStation(PrintWriter printWriter, UnifiedStation unifiedStation) {
        if (unifiedStation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(unifiedStation.shortName);
        printWriter.print(unifiedStation.longName);
        printWriter.print(unifiedStation.frequency);
        printWriter.print(unifiedStation.piSId);
        printWriter.print(unifiedStation.ensId);
        printWriter.print(unifiedStation.ecc);
        printWriter.print(unifiedStation.sCIDI);
        printWriter.print(unifiedStation.scrollingPS);
        printWriter.print(unifiedStation.rds);
        printWriter.print(unifiedStation.audioQuality);
        printWriter.print(unifiedStation.tpAvailability);
        if (unifiedStation.ptyCodes == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = unifiedStation.ptyCodes.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(unifiedStation.ptyCodes[i2]);
            }
        }
        printWriter.print(unifiedStation.radioText);
        printWriter.print(unifiedStation.radioTextPlus);
        printWriter.print(unifiedStation.enhancedRadioText);
        printWriter.print(unifiedStation.slideshow);
        this.trace(printWriter, unifiedStation.stationLogo);
        printWriter.print(unifiedStation.coChannel);
    }

    private void traceWavebandInfo(PrintWriter printWriter, WavebandInfo wavebandInfo) {
        if (wavebandInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wavebandInfo.waveband);
        printWriter.print(wavebandInfo.lowerLimit);
        printWriter.print(wavebandInfo.upperLimit);
        printWriter.print(wavebandInfo.stepWidth);
        printWriter.print(wavebandInfo.multiplier);
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

