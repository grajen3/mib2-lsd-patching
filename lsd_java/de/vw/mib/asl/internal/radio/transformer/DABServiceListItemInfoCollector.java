/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DABServiceListItemInfoCollector {
    private int mAutocompare;
    private boolean mSupportsSlideShow = false;
    private final ServiceInfo mService;
    private final FrequencyInfo mFrequency;
    private static byte[] mNullPty = new byte[0];
    public ResourceLocator mImage = null;
    private boolean mActivatedFromList;

    public DABServiceListItemInfoCollector(ServiceInfo serviceInfo) {
        this.mAutocompare = RadioData.getDabDatabase().dabPresetList.serviceIsOnPreset(serviceInfo) ? 1 : 0;
        this.mService = serviceInfo;
        this.mFrequency = null;
        this.calcSlsAvailable();
    }

    public DABServiceListItemInfoCollector(ServiceInfo serviceInfo, boolean bl) {
        this(serviceInfo);
        this.mActivatedFromList = bl;
    }

    public String getName() {
        if (this.mFrequency != null) {
            return "no Ensemble";
        }
        if (this.mService != null) {
            return this.mService.fullName;
        }
        return "";
    }

    public String getShortName() {
        if (this.mFrequency != null) {
            return "no Ensemble";
        }
        if (this.mService != null) {
            return this.mService.shortName;
        }
        return "";
    }

    public int getAutocompare() {
        return this.mAutocompare;
    }

    public byte[] getPty() {
        if (this.mService != null) {
            return this.mService.ptyCodes;
        }
        return mNullPty;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int getState() {
        if (this.mService != null) {
            EnsembleInfo ensembleInfo;
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mPersistable.getCurrentService();
            if (serviceInfo != null) {
                if (DabTunerState.compare(this.mService, serviceInfo)) {
                    return RadioData.getDabDatabase().mTunerState.getCurrentServiceState();
                }
                if (serviceInfo2 != null && DabTunerState.compare(serviceInfo2, this.mService) && this.mActivatedFromList) {
                    EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mTunerState.getEnsembleById(this.mService.getEnsID(), this.mService.getEnsECC());
                    RadioData.getDabDatabase().mTunerState.setEnsembleStatus(ensembleInfo2, 4);
                    return 4;
                }
            }
            if ((ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(this.mService.ensID, this.mService.ensECC)) == null) return 1;
            EnsembleInfo ensembleInfo3 = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            if (ensembleInfo3 != null && DabTunerState.compare(ensembleInfo, ensembleInfo3)) {
                switch (RadioData.getDabDatabase().mTunerState.getEnsembleStatus()) {
                    case 1: 
                    case 2: {
                        return 1;
                    }
                }
            } else {
                if (RadioData.getDabDatabase().mTunerState.findServiceInList(this.mService) == null) {
                    return 1;
                }
                if (!ensembleInfo.potentiallyReceivable) {
                    return 2;
                }
                int n = RadioData.getDabDatabase().mTunerState.mEnsembleSyncStateList.getSyncState(ensembleInfo);
                switch (n) {
                    case 1: 
                    case 2: {
                        return 1;
                    }
                }
                return 0;
            }
        }
        if (this.mFrequency == null) return 0;
        return 1;
    }

    public int getAdditionalServiceState() {
        if (this.mService == null) {
            return 0;
        }
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        if (serviceInfo != null && DabTunerState.compare(this.mService, serviceInfo) && RadioData.getDabDatabase().mTunerState.getCurrentComponent() != null) {
            return 2;
        }
        if (RadioData.getDabDatabase().mTunerState.hasComponents(this.mService)) {
            return 1;
        }
        return 0;
    }

    public void calcSlsAvailable() {
        this.mSupportsSlideShow = RadioData.getDabDatabase().mTunerState.hasSlideShowServices(this.mService);
    }

    public void calcAutocompare() {
        this.mAutocompare = RadioData.getDabDatabase().dabPresetList.serviceIsOnPreset(this.mService) ? 1 : 0;
    }

    public boolean isSlsAvailable() {
        return this.mSupportsSlideShow;
    }

    public ServiceInfo getService() {
        return this.mService;
    }

    public FrequencyInfo getFrequency() {
        return this.mFrequency;
    }

    public String getIdString() {
        if (this.mService != null) {
            return Long.toString(DabTunerState.calcServiceId(this.mService.ensID, this.mService.ensECC, this.mService.sID));
        }
        return "";
    }

    public String toString() {
        String string = new StringBuffer().append("Name[").append(this.getName()).append("] ").toString();
        string = new StringBuffer().append(string).append("EID[").append(this.getService().ensID).append("] ").toString();
        string = new StringBuffer().append(string).append("SID[").append(this.getService().sID).append("] ").toString();
        string = new StringBuffer().append(string).append("AutoCompare[").append(this.getAutocompare()).append("] ").toString();
        string = new StringBuffer().append(string).append("PTY[").append(this.getPty()).append("] ").toString();
        string = new StringBuffer().append(string).append("State[").append(this.getState()).append("]").toString();
        return string;
    }

    public void setImage(ResourceLocator resourceLocator) {
        this.mImage = resourceLocator;
    }

    public ResourceLocator getImage() {
        return this.mImage;
    }

    public boolean getTpState() {
        if (this.mService != null) {
            return this.mService.tp;
        }
        return false;
    }
}

