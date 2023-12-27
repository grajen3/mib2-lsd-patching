/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.tv;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerConstants;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TVInfo {
    private int currentStationServicePID = 0;
    private long currentStationNamePID = 0L;
    private int currentStationSType = 0;
    private int currentNormArea = 0;
    private ServiceInfo currentServiceInfo = null;
    private int currentVideoFormat;
    private ServiceInfo sTypeDummyService = null;
    private String currentStationName = "";

    public void updateOSDProgramInfo(ProgramInfo programInfo) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVInfo#updateOSDProgramInfo - programInfo = ").append(programInfo.toString()).toString());
        }
        this.currentVideoFormat = programInfo.getVideoFormat();
        this.currentServiceInfo = programInfo.getServiceInfo();
        this.currentStationNamePID = this.currentServiceInfo.getNamePID();
        this.currentStationServicePID = this.currentServiceInfo.getServicePID();
        this.currentStationSType = this.currentServiceInfo.getSType();
        this.currentNormArea = programInfo.getNormArea();
        this.setChannelAndStationName(programInfo);
        this.setCurrentProgramInfo(programInfo);
        this.updateCASStatus(programInfo.getCasStatus());
        this.setCurrentStationLogo();
        int n = this.currentStationSType;
        if (this.currentStationSType == 15) {
            int n2 = TVTunerObjectAccessor.getPresetListHandler().getPresetSType(this.currentStationNamePID, this.currentStationServicePID);
            if (n2 != -1) {
                n = n2;
            }
            this.sTypeDummyService = new ServiceInfo(this.currentStationNamePID, this.currentStationServicePID, this.currentStationName, n, this.currentServiceInfo.getContentGroup());
        } else {
            this.sTypeDummyService = null;
        }
        if (this.currentStationSType != 15) {
            // empty if block
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2472, n);
        this.setTVInfoBarStatusIcons(programInfo);
        TVTunerObjectAccessor.getTvTunerSettings().updateAspectRatio(this.currentVideoFormat);
        TVTunerObjectAccessor.getPresetListHandler().setPresetListIndex(this.currentServiceInfo);
        TVTunerObjectAccessor.getStationListHandler().updateServiceInfo();
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistLastStation(this.currentStationNamePID, this.currentStationServicePID, this.currentStationSType);
        TVTunerObjectAccessor.getTvBAP().updateBAPIndices();
    }

    public ServiceInfo getCurrentServiceInfo() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVInfo#getCurrentServiceInfo called");
        }
        return this.currentServiceInfo;
    }

    private void setTVInfoBarStatusIcons(ProgramInfo programInfo) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVInfo#setTVInfoBarStatusIcons called");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(2474, programInfo.getBwsFlag() == 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(2473, programInfo.getSlsFlag() == 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(2430, programInfo.getAvailableAudioChannels().length > 1);
        ServiceManager.aslPropertyManager.valueChangedBoolean(2431, programInfo.getEpgFlag() == 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(2432, programInfo.getTeletextFlag() == 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(2429, programInfo.getSubtitleFlag() == 2);
    }

    private void setChannelAndStationName(ProgramInfo programInfo) {
        String string;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVInfo#setChannelAndStationName called");
        }
        this.currentStationName = "";
        this.currentStationName = this.currentStationSType == 15 ? ((string = TVTunerObjectAccessor.getPresetListHandler().getPresetStationName(this.currentStationNamePID, this.currentStationServicePID)) != null ? string : programInfo.getChannelName()) : programInfo.getServiceInfo().getName();
        ServiceManager.aslPropertyManager.valueChangedString(2314, this.currentStationName);
        ServiceManager.aslPropertyManager.valueChangedString(2488, programInfo.getChannelName());
        TVTunerObjectAccessor.getTileService().updateCurrentStationName(this.currentStationName);
    }

    private void setCurrentProgramInfo(ProgramInfo programInfo) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVInfo#setCurrentProgramInfo called");
        }
        String string = programInfo.getNowProgramInfo();
        int n = TVTunerHelper.convertBcdToInt(programInfo.getNowStartTime().hour);
        int n2 = TVTunerHelper.convertBcdToInt(programInfo.getNowStartTime().minute);
        int n3 = TVTunerHelper.convertBcdToInt(programInfo.getNowEndTime().hour);
        int n4 = TVTunerHelper.convertBcdToInt(programInfo.getNowEndTime().minute);
        ServiceManager.aslPropertyManager.valueChangedString(2316, string);
        ServiceManager.aslPropertyManager.valueChangedInteger(2317, n);
        ServiceManager.aslPropertyManager.valueChangedInteger(2318, n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(2319, n3);
        ServiceManager.aslPropertyManager.valueChangedInteger(2320, n4);
        TVTunerObjectAccessor.getTileService().updateProgramInfo(string, n, n2, n3, n4);
    }

    private void setCurrentStationLogo() {
        ResourceLocator resourceLocator;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVInfo#setCurrentStationLogo called");
        }
        if ((resourceLocator = TVTunerObjectAccessor.getLogoHandler().getStationLogo(this.currentStationNamePID)) != null) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("TVInfo#setCurrentStationLogo - stationlogo for NamePID ").append(this.currentStationNamePID).append(" : ").append(resourceLocator.getUrl()).toString());
            }
        } else {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("TVInfo#setCurrentStationLogo - no stationlogo available for NamePID ").append(this.currentStationNamePID).toString());
            }
            resourceLocator = TVTunerConstants.EMPTY_STATION_LOGO;
        }
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(2494, resourceLocator);
    }

    private void updateCASStatus(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVInfo#updateCASStatus - cas status =  ").append(n).toString());
        }
        boolean bl = false;
        StartUpConfig startUpConfig = TVTunerObjectAccessor.getStartUpConfigHandler().getLastStartupConfig();
        if (startUpConfig != null && startUpConfig.isTmCASAvail() && TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource() == 0) {
            switch (n) {
                case 2: 
                case 9: {
                    bl = true;
                    TVTunerObjectAccessor.getTargetTVTuner().sendHMIEvent(492);
                    break;
                }
                case 3: 
                case 4: 
                case 7: 
                case 8: 
                case 10: 
                case 11: 
                case 14: {
                    bl = true;
                    TVTunerObjectAccessor.getTargetTVTuner().sendHMIEvent(493);
                    break;
                }
                case 5: {
                    bl = true;
                    if (TVTunerObjectAccessor.getTMHandler().getCurrentTerminalMode() == 12) break;
                    TVTunerObjectAccessor.getTargetTVTuner().sendHMIEvent(494);
                    break;
                }
            }
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(3346, bl);
        ServiceManager.aslPropertyManager.valueChangedInteger(2626, n);
        TVTunerObjectAccessor.getTvTunerSettings().setCasStatus(n);
    }

    public void updateMuteState(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVInfo#updateMuteState called - muteState = ").append(n).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2573, n);
        TVTunerObjectAccessor.getTvTunerAudio().setVolumeLockNeeded(n != 0);
        TVTunerObjectAccessor.getTvTunerAudio().checkVolumeLock();
        TVTunerObjectAccessor.getTileService().updateTVMuteIconVisible(n != 0);
    }

    public long getCurrentStationNamePID() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVInfo#getCurrentStationNamePID called - currentStationNamePID = ").append(this.currentStationNamePID).toString());
        }
        return this.currentStationNamePID;
    }

    public int getCurrentStationServicePID() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVInfo#getCurrentStationServicePID called - currentStationServicePID = ").append(this.currentStationServicePID).toString());
        }
        return this.currentStationServicePID;
    }

    public int getCurrentNormArea() {
        return this.currentNormArea;
    }

    public int getVideoFormat() {
        return this.currentVideoFormat;
    }

    public int getCurrentStationSType() {
        return this.currentStationSType;
    }

    public ServiceInfo getsTypeDummyService() {
        return this.sTypeDummyService;
    }

    public String getCurrentStationName() {
        return this.currentStationName;
    }
}

