/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceLanguageChangeListener;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.AnnouncementInfo_Status;

public class AnnouncementInfo
extends Function
implements Property,
ASLAudioSDConstants,
RadioServiceListener,
ConfigurationServiceLanguageChangeListener {
    protected static final int[] RADIO_LISTENER_IDS = new int[]{1326, 1429, 1441, 1448, 1424, 1328, 1325, 3007, 1327, 3006, 1366, 1426, 2482, 2397};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementInfo_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getConfigurationService().addLanguageChangeListener(this);
        return this.computeAnnouncementInfoStatus();
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    protected final AnnouncementInfo_Status dequeueBAPEntity() {
        return (AnnouncementInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementInfo_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementInfo_Status = AnnouncementInfo.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.AnnouncementInfo_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementInfo_Status);
    }

    @Override
    public int getFunctionId() {
        return 28;
    }

    protected String formattedFMAnnouncementFrequency(int n) {
        String string = this.getRadioService().getFMFrequencyScale() == 1 ? this.getFixFormatter().fmtIcFrequencyNAR(n, 0, -1) : this.getFixFormatter().fmtIcFrequency(n, 0, this.getConfigurationService().getCurrentGUILanguage());
        return string;
    }

    protected String getFMAnnouncementStationName(String string, int n) {
        String string2 = string.length() != 0 && this.getRadioService().isPiCodingActivated() ? string : this.formattedFMAnnouncementFrequency(n);
        return string2;
    }

    private int mapDABAnnouncementType() {
        int n;
        switch (this.getRadioService().getCurrentDABAnnouncementType()) {
            case 0: {
                n = 1;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            case 3: {
                n = 11;
                break;
            }
            case 4: {
                n = 4;
                break;
            }
            case 5: {
                n = 5;
                break;
            }
            case 6: {
                n = 6;
                break;
            }
            case 7: {
                n = 7;
                break;
            }
            case 8: {
                n = 8;
                break;
            }
            case 9: {
                n = 9;
                break;
            }
            case 10: {
                n = 10;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private void setAnnouncementTypeAndStationName(AnnouncementInfo_Status announcementInfo_Status) {
        RadioService radioService = this.getRadioService();
        if (radioService.isTrafficAnnouncementActive()) {
            switch (radioService.getTrafficAnnouncementSource()) {
                case 0: {
                    announcementInfo_Status.announcementType = 2;
                    announcementInfo_Status.stationName.setContent(this.getFMAnnouncementStationName(radioService.getCurrentTAStationName(), radioService.getCurrentTAFrequency()));
                    break;
                }
                case 1: {
                    announcementInfo_Status.announcementType = this.mapDABAnnouncementType();
                    announcementInfo_Status.stationName.setContent(radioService.getCurrentDABAnnouncementStationName());
                    break;
                }
                default: {
                    announcementInfo_Status.announcementType = 0;
                    announcementInfo_Status.stationName.setContent("");
                    break;
                }
            }
        } else if (radioService.isPTYAnnouncementActive()) {
            announcementInfo_Status.announcementType = radioService.isDABAnnouncementActive() ? this.mapDABAnnouncementType() : 1;
            announcementInfo_Status.stationName.setContent(this.getFMAnnouncementStationName(radioService.getCurrentPTYAnnouncementStationName(), radioService.getCurrentPTYAnnouncementFrequency()));
        } else if (radioService.isDABAnnouncementActive()) {
            announcementInfo_Status.announcementType = this.mapDABAnnouncementType();
            announcementInfo_Status.stationName.setContent(radioService.getCurrentDABAnnouncementStationName());
        } else if (radioService.isTrafficInformationActive()) {
            announcementInfo_Status.announcementType = 13;
            if (radioService.getTrafficInformationFrequencyType() == 0) {
                announcementInfo_Status.stationName.setContent(this.getFixFormatter().fmtIcFrequency(1620, 1, this.getConfigurationService().getCurrentGUILanguage()));
            } else {
                announcementInfo_Status.stationName.setContent(this.getFixFormatter().fmtIcFrequency(1629, 1, this.getConfigurationService().getCurrentGUILanguage()));
            }
        } else {
            announcementInfo_Status.announcementType = 0;
            announcementInfo_Status.stationName.setContent("");
        }
    }

    private void sendAnnouncementInfoStatus(AnnouncementInfo_Status announcementInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(announcementInfo_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getConfigurationService().removeLanguageChangeListener(this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendAnnouncementInfoStatus(this.computeAnnouncementInfoStatus());
    }

    private AnnouncementInfo_Status computeAnnouncementInfoStatus() {
        AnnouncementInfo_Status announcementInfo_Status = this.dequeueBAPEntity();
        this.setAnnouncementTypeAndStationName(announcementInfo_Status);
        return announcementInfo_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }

    @Override
    public void languageChanged() {
        this.process(-1);
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

