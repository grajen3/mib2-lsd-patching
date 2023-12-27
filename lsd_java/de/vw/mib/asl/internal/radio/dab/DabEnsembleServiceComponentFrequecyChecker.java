/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class DabEnsembleServiceComponentFrequecyChecker {
    public boolean checkServiceAndName(ServiceInfo serviceInfo) {
        if (null == serviceInfo) {
            return false;
        }
        if (null == serviceInfo.fullName) {
            serviceInfo.fullName = "";
        }
        if (null == serviceInfo.shortName) {
            serviceInfo.shortName = "";
        }
        return true;
    }

    public boolean checkEnsembleAndName(EnsembleInfo ensembleInfo) {
        if (null == ensembleInfo) {
            return false;
        }
        if (null == ensembleInfo.fullName) {
            ensembleInfo.fullName = "";
        }
        if (null == ensembleInfo.shortName) {
            ensembleInfo.shortName = "";
        }
        return true;
    }

    public boolean checkComponentAndName(ComponentInfo componentInfo) {
        if (null == componentInfo) {
            return false;
        }
        if (null == componentInfo.fullName) {
            componentInfo.fullName = "";
        }
        if (null == componentInfo.shortName) {
            componentInfo.shortName = "";
        }
        return true;
    }

    public boolean checkFrequencyAndName(FrequencyInfo frequencyInfo) {
        if (null == frequencyInfo) {
            return false;
        }
        if (null == frequencyInfo.label) {
            frequencyInfo.label = "";
        }
        return true;
    }
}

