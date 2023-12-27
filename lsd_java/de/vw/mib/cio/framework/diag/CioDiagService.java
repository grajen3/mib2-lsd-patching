/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.framework.diag;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.framework.diag.CioIntentDiag;
import java.util.List;
import java.util.Map;

public interface CioDiagService {
    default public CioParametersCreator createActionParams(CioIntentDiag cioIntentDiag) {
    }

    default public void dispatch(CioIntent cioIntent, CioActionParameters cioActionParameters) {
    }

    default public List getRegisteredCioIntents() {
    }

    default public Map getCioIntentClasses() {
    }
}

