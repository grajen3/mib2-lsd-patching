/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DABAdditionalServicesListCollector {
    private String mName;
    private ComponentInfo mComponent = null;
    private ServiceInfo mService = null;

    public DABAdditionalServicesListCollector(ComponentInfo componentInfo) {
        if (componentInfo != null) {
            this.mName = componentInfo.fullName;
        }
        this.mComponent = componentInfo;
    }

    public DABAdditionalServicesListCollector(ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            this.mName = serviceInfo.fullName;
        }
        this.mService = serviceInfo;
    }

    public ServiceInfo getService() {
        return this.mService;
    }

    public int getCurrentReceptionState() {
        int n;
        int n2;
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
        if (this.mComponent != null && ensembleInfo != null && DabTunerState.compare(ensembleInfo, this.mComponent) ? (n2 = RadioData.getDabDatabase().mTunerState.getCurrentServiceState()) != 0 : this.mService != null && ensembleInfo != null && DabTunerState.compare(this.mService, ensembleInfo) && (n = RadioData.getDabDatabase().mTunerState.getCurrentServiceState()) != 0) {
            return 1;
        }
        return 0;
    }

    public boolean supportsSlideshow() {
        ServiceInfo serviceInfo = this.mService;
        if (serviceInfo == null) {
            serviceInfo = RadioData.getDabDatabase().mTunerState.getServiceById(this.mComponent.ensID, this.mComponent.ensECC, this.mComponent.sID);
        }
        return RadioData.getDabDatabase().mTunerState.hasSlideShowServices(serviceInfo);
    }

    public ComponentInfo getComponent() {
        return this.mComponent;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String string) {
        this.mName = string;
    }

    public String toString() {
        String string = new StringBuffer().append("Name[").append(this.getName()).append("] ").toString();
        if (this.mService != null) {
            string = new StringBuffer().append(string).append("Primary[true] ").toString();
            string = new StringBuffer().append(string).append("EID[").append(this.mService.ensID).append("] ").toString();
            string = new StringBuffer().append(string).append("ECC[").append(this.mService.ensECC).append("] ").toString();
            string = new StringBuffer().append(string).append("SID[").append(this.mService.sID).append("] ").toString();
        } else if (this.mComponent != null) {
            string = new StringBuffer().append(string).append("Primary[false]").toString();
            string = new StringBuffer().append(string).append("EID[").append(this.mComponent.ensID).append("] ").toString();
            string = new StringBuffer().append(string).append("ECC[").append(this.mComponent.ensECC).append("] ").toString();
            string = new StringBuffer().append(string).append("SID[").append(this.mComponent.sID).append("] ").toString();
            string = new StringBuffer().append(string).append("SCIDI[").append(this.mComponent.sCIDI).append("] ").toString();
        }
        return string;
    }
}

