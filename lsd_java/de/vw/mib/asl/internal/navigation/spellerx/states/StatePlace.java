/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.states;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.states.NavReflectionState;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.CommonMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.JapanMatchTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StatePlace
extends NavReflectionState {
    private XSpellerTarget target;

    public StatePlace(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addSubject(new CommonMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, xSpellerTarget.modelStreetPreviewList, 147, false, false, true));
        this.addSubject(new JapanMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, xSpellerTarget.modelStreetPreviewList, 147, false, false, true));
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(12);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.postalcodeField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.postalcodeField.getSpellerData(), 12);
        this.target.getSpellerContext().setState(12);
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }

    public void evtHSM_EXIT(AbstractReflectionContext abstractReflectionContext) {
        this.target.postalcodeField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

