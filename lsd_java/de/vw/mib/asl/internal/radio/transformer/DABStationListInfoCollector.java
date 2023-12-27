/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DABStationListInfoCollector {
    private String mName;
    private int mReceptionState;
    private int mEnsembleState;
    private boolean mTpState;
    private final EnsembleInfo mEnsemble;
    private final FrequencyInfo mFrequency;
    private final ServiceInfo mService;

    public DABStationListInfoCollector(EnsembleInfo ensembleInfo) {
        this.mName = ensembleInfo.fullName;
        this.mTpState = ensembleInfo.tp;
        this.mEnsemble = ensembleInfo;
        this.mFrequency = null;
        this.mService = null;
        this.calcReceptionState();
        this.calcEnsembleState();
    }

    public DABStationListInfoCollector(FrequencyInfo frequencyInfo) {
        this.mName = frequencyInfo.label;
        this.mReceptionState = 1;
        this.mTpState = false;
        this.mEnsemble = null;
        this.mFrequency = frequencyInfo;
        this.mService = null;
        this.calcReceptionState();
        this.calcEnsembleState();
    }

    public DABStationListInfoCollector(ServiceInfo serviceInfo) {
        this.mName = "No Ensemble";
        if (RadioData.getDabDatabase().mTunerState.getCurrentEnsemble() != null) {
            this.mName = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble().fullName;
        }
        this.mReceptionState = 0;
        this.mTpState = false;
        this.mEnsemble = null;
        this.mFrequency = null;
        this.mService = serviceInfo;
        this.calcReceptionState();
        this.calcEnsembleState();
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String string) {
        this.mName = string;
    }

    public int getReceptionState() {
        this.calcReceptionState();
        return this.mReceptionState;
    }

    public void setReceptionState(int n) {
        this.mReceptionState = n;
    }

    public int getEnsembleState() {
        this.calcEnsembleState();
        return this.mEnsembleState;
    }

    public void setEnsembleState(int n) {
        this.mEnsembleState = n;
    }

    public boolean getTPState() {
        return this.mTpState;
    }

    public void setTPState(boolean bl) {
        this.mTpState = bl;
    }

    public EnsembleInfo getEnsemble() {
        return this.mEnsemble;
    }

    public FrequencyInfo getFrequency() {
        return this.mFrequency;
    }

    public ServiceInfo getService() {
        return this.mService;
    }

    public long getEnsembleId() {
        if (this.mEnsemble != null) {
            return this.mEnsemble.getEnsID();
        }
        if (this.mService != null) {
            return this.mService.getEnsID();
        }
        return 0L;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.mEnsemble == null ? 0 : this.mEnsemble.hashCode());
        n2 = 31 * n2 + (this.mFrequency == null ? 0 : this.mFrequency.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof DABStationListInfoCollector)) {
            return false;
        }
        DABStationListInfoCollector dABStationListInfoCollector = (DABStationListInfoCollector)object;
        if (this.mEnsemble == null ? dABStationListInfoCollector.mEnsemble != null : this.mEnsemble != null && dABStationListInfoCollector.mEnsemble != null && !DabTunerState.compare(this.mEnsemble, dABStationListInfoCollector.mEnsemble)) {
            return false;
        }
        if (this.mFrequency == null) {
            return dABStationListInfoCollector.mFrequency == null;
        }
        return this.mFrequency.frequency == dABStationListInfoCollector.mFrequency.frequency;
    }

    public String toString() {
        String string = new StringBuffer().append("Name[").append(this.getName()).append("] ").toString();
        string = new StringBuffer().append(string).append("ECC[").append(this.getEnsemble().ensECC).append("] ").toString();
        string = new StringBuffer().append(string).append("EID[").append(this.getEnsemble().ensID).append("] ").toString();
        string = new StringBuffer().append(string).append("Frequency[").append(this.getFrequency()).append("] ").toString();
        string = new StringBuffer().append(string).append("State[").append(this.getEnsembleState()).append("] ").toString();
        string = new StringBuffer().append(string).append("Reception[").append(this.getReceptionState()).append("] ").toString();
        string = new StringBuffer().append(string).append("TP[").append(this.getTPState()).append("] ").toString();
        return string;
    }

    public void calcReceptionState() {
        this.mReceptionState = 0;
        if (this.mFrequency != null) {
            this.mReceptionState = 1;
        } else if (this.mService != null) {
            this.mReceptionState = 1;
        } else {
            EnsembleInfo ensembleInfo;
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            if (serviceInfo != null && (ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble()) != null && this.mEnsemble != null && DabTunerState.compare(ensembleInfo, this.mEnsemble)) {
                int n = RadioData.getDabDatabase().mTunerState.getEnsembleStatus();
                switch (n) {
                    case 1: 
                    case 2: {
                        this.mReceptionState = 1;
                        return;
                    }
                }
                this.mReceptionState = 0;
                n = RadioData.getDabDatabase().mTunerState.getCurrentServiceState();
                if (n == 3) {
                    this.mReceptionState = 3;
                }
                return;
            }
            this.mReceptionState = this.mEnsemble == null ? 1 : (!this.mEnsemble.potentiallyReceivable ? 2 : 0);
        }
    }

    public void calcEnsembleState() {
        this.mEnsembleState = 0;
        if (this.mEnsemble != null && !RadioData.getDabDatabase().mTunerState.hasAudioServices(this.mEnsemble)) {
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            if (serviceInfo == null || ensembleInfo == null || serviceInfo != null && !DabTunerState.compare(serviceInfo, ensembleInfo)) {
                this.mEnsembleState = 2;
            }
        }
        if (this.mFrequency != null) {
            this.mEnsembleState = 1;
        }
    }
}

