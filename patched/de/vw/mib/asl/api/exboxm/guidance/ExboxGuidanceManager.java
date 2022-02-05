/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm.guidance;

import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceListener;
import de.vw.mib.asl.api.exboxm.guidance.GuidanceState;

public interface ExboxGuidanceManager {
    /*default*/ public void addListener(ExboxGuidanceListener exboxGuidanceListener) ;

    /*default*/ public void removeListener(ExboxGuidanceListener exboxGuidanceListener) ;

    /*default*/ public GuidanceState getGuidanceState() ;

    /*default*/ public void changeSmartphoneGuidanceStateTo(GuidanceState guidanceState) ;
}

