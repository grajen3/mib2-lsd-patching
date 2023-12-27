/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class StartUpConfigHandler {
    private StartUpConfig lastStartupConfig = new StartUpConfig();

    public void updateStartUpConfig(StartUpConfig startUpConfig) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("StartUpConfigHandler#updateStartUpConfig called");
        }
        this.lastStartupConfig = startUpConfig;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option tv norm area available = ").append(startUpConfig.isTvNormAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option service linking available = ").append(startUpConfig.isLinkingAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option arrow buttons available = ").append(startUpConfig.isSkipBehaviourAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option subtitle available = ").append(startUpConfig.isSubtitleAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option aspect ratio available = ").append(startUpConfig.isVideoFormatAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option audio channel available = ").append(startUpConfig.isAudioChannelAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option cas info available = ").append(startUpConfig.isCasAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option visual audio show pictures available = ").append(startUpConfig.isVisualAudioAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode EPG available = ").append(startUpConfig.isTmEPGAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode TXT available = ").append(startUpConfig.isTmTXTAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode Teletext available = ").append(startUpConfig.isTmTeletextAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode ISDB available = ").append(startUpConfig.isTmDatabroadISDBAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode BWS available = ").append(startUpConfig.isTmBWSAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode SLS/DLS available = ").append(startUpConfig.isTmSLSDLSAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode VA available = ").append(startUpConfig.isTmVisualAudioAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode CAS available = ").append(startUpConfig.isTmCASAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode DB1 available = ").append(startUpConfig.isTmDatabroad1Avail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode DB2 available = ").append(startUpConfig.isTmDatabroad2Avail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode ATSC available = ").append(startUpConfig.isTmDatabroadATSCAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode DMB available = ").append(startUpConfig.isTmDatabroadDMBAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode DTMB available = ").append(startUpConfig.isTmDatabroadDTMBAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Terminal mode DVB available = ").append(startUpConfig.isTmDatabroadDVBAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option av aspect ratio available = ").append(startUpConfig.isAvFormatAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Option av norm available = ").append(startUpConfig.isAvNormAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - Is AV source available = ").append(startUpConfig.isAvSrcAvail()).toString());
            TVTunerHelper.trace("StartUpConfigHandler#updateStartUpConfig - get required key panel list ");
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - is EWS available = ").append(startUpConfig.isEwsAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - is logoList available = ").append(startUpConfig.isLogoListAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - is tpeg available = ").append(startUpConfig.isTpegAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - is browserlistsorting available = ").append(startUpConfig.isBrowserListSortAvail()).toString());
            TVTunerHelper.trace(new StringBuffer().append("StartUpConfigHandler#updateStartUpConfig - is parental control req available = ").append(startUpConfig.isParentalControlReq()).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(2426, startUpConfig.isTvNormAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2516, startUpConfig.isLinkingAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2684, startUpConfig.isSkipBehaviourAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2738, startUpConfig.isSubtitleAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2737, startUpConfig.isVideoFormatAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2818, startUpConfig.isAudioChannelAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2947, startUpConfig.isCasAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3011, startUpConfig.isVisualAudioAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3313, startUpConfig.isTmEPGAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3315, startUpConfig.isTmTXTAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3319, startUpConfig.isTmTeletextAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3321, startUpConfig.isTmDatabroadISDBAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3317, startUpConfig.isTmBWSAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3316, startUpConfig.isTmSLSDLSAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3318, startUpConfig.isTmVisualAudioAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3314, startUpConfig.isTmCASAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3325, startUpConfig.isTmDatabroad1Avail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3326, startUpConfig.isTmDatabroad2Avail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3324, startUpConfig.isTmDatabroadATSCAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3323, startUpConfig.isTmDatabroadDMBAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3322, startUpConfig.isTmDatabroadDTMBAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(3320, startUpConfig.isTmDatabroadDVBAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2866, startUpConfig.isAvFormatAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2867, startUpConfig.isAvNormAvail());
        ServiceManager.aslPropertyManager.valueChangedBoolean(2910, startUpConfig.isAvSrcAvail());
        TVTunerObjectAccessor.getTMHandler().setRequiredKeypanelList(startUpConfig.getRequiredKeypanelList());
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1303632384, startUpConfig.browserListSortAvail);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1202969088, startUpConfig.isEwsAvail());
        TVTunerObjectAccessor.getTileService().updateSourceAvAvailable(startUpConfig.isAvSrcAvail());
    }

    public StartUpConfig getLastStartupConfig() {
        return this.lastStartupConfig;
    }
}

