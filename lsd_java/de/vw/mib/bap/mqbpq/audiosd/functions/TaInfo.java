/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.TaInfoStage;
import de.vw.mib.bap.mqbpq.common.api.adapter.LanguageUtil;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TaInfo_Status;

public class TaInfo
extends TaInfoStage {
    private BAPStageInitializer _stageInitializer;
    private LanguageUtil _languageUtil;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.setStageInitializer(bAPStageInitializer);
        return this.computeAnnouncementInfoStatus();
    }

    private BAPStageInitializer getStageInitializer() {
        return this._stageInitializer;
    }

    private void setStageInitializer(BAPStageInitializer bAPStageInitializer) {
        this._stageInitializer = bAPStageInitializer;
    }

    protected LanguageUtil getLanguageUtil() {
        if (this._languageUtil == null) {
            this._languageUtil = this.getStageInitializer().createLanguageUtil(this);
        }
        return this._languageUtil;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getLanguageUtil().uninitialize();
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeAnnouncementInfoStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    protected String formattedFMAnnouncementFrequency(int n) {
        String string = this.getFmFrequencyScale() == 1 ? this.getLanguageUtil().formatFrequencyNAR(n, 0, -1) : this.getLanguageUtil().formatFrequency(n, 0);
        return string;
    }

    protected String getFMAnnouncementStationName(String string, int n) {
        String string2 = string.length() != 0 && this.getPiCodingActivated() ? string : this.formattedFMAnnouncementFrequency(n);
        return string2;
    }

    private void setAnnouncementTypeAndStationName(TaInfo_Status taInfo_Status) {
        if (this.getTrafficAnnouncementActive()) {
            switch (this.getTrafficAnnouncementSource()) {
                case 0: {
                    taInfo_Status.taMessageOnOff.taMessageActive = true;
                    taInfo_Status.sendername.setContent(this.getFMAnnouncementStationName(this.getCurrentTAStationName(), this.getCurrentTAFrequency()));
                    break;
                }
                case 1: {
                    taInfo_Status.taMessageOnOff.taMessageActive = true;
                    taInfo_Status.sendername.setContent(this.getCurrentDABAnnouncementStationName());
                    break;
                }
                default: {
                    taInfo_Status.taMessageOnOff.taMessageActive = false;
                    taInfo_Status.sendername.setContent("");
                    break;
                }
            }
        } else if (this.getPtyAnnouncementActive()) {
            taInfo_Status.sendername.setContent(this.getFMAnnouncementStationName(this.getCurrentPTYAnnouncementStationName(), this.getCurrentPTYAnnouncementFrequency()));
            taInfo_Status.taMessageOnOff.taMessageActive = true;
        } else if (this.getDabAnnouncementPlaying()) {
            taInfo_Status.sendername.setContent(this.getCurrentDABAnnouncementStationName());
            taInfo_Status.taMessageOnOff.taMessageActive = true;
        } else if (this.getTrafficInformationActive()) {
            if (this.getTrafficInformationFrequencyType() == 0) {
                taInfo_Status.sendername.setContent(this.getLanguageUtil().formatFrequency(1620, 1));
            } else {
                taInfo_Status.sendername.setContent(this.getLanguageUtil().formatFrequency(1629, 1));
            }
            taInfo_Status.taMessageOnOff.taMessageActive = true;
        } else {
            taInfo_Status.sendername.setContent("");
            taInfo_Status.taMessageOnOff.taMessageActive = false;
        }
    }

    private TaInfo_Status computeAnnouncementInfoStatus() {
        TaInfo_Status taInfo_Status = this.dequeueBAPEntity();
        this.setAnnouncementTypeAndStationName(taInfo_Status);
        return taInfo_Status;
    }
}

