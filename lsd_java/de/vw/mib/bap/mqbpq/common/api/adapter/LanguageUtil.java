/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.configuration.NvListener;

public class LanguageUtil
implements NvListener {
    public static final int RADIO_BAND_AM;
    public static final int RADIO_BAND_FM;
    public static final int RADIO_HD_NO_SUBCHANNEL;
    public static final int RADIO_HD_ANALOG_STATION;
    private String currentLanguage;
    private BAPStage stage;
    private final int logicalControlUnitID;

    public LanguageUtil(BAPStage bAPStage, int n) {
        this.logicalControlUnitID = n;
        this.stage = bAPStage;
        ServiceManager.serviceManager.configurationManager.addNvListener(this, 2);
        this.setInternalParameters();
    }

    public void uninitialize() {
    }

    private void setInternalParameters() {
        this.currentLanguage = ServiceManager.serviceManager.configurationManager.getCurrentGuiLanguage();
    }

    public String formatFrequency(int n, int n2) {
        return ServiceManager.serviceManager.fixFormat.fmtIcFrequency(n, n2, this.currentLanguage);
    }

    public String formatFrequencyNAR(int n, int n2, int n3) {
        return ServiceManager.serviceManager.fixFormat.fmtIcFrequencyNAR(n, n2, n3);
    }

    @Override
    public void notifyNvListener(int n) {
        this.setInternalParameters();
        ServiceManager.serviceManager.bapDispatcher.informHmiLanguageChange(this.logicalControlUnitID, this.stage.getFunctionId());
    }
}

