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
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NARMatchTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateStreet1stCity
extends NavReflectionState {
    private XSpellerTarget target;

    public StateStreet1stCity(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addSubject(new CommonMatchTextSubject(xSpellerTarget, 3050, 3049, xSpellerTarget.modelCityList, xSpellerTarget.modelCityPreviewList, 2, true, true, false));
        this.addSubject(new NARMatchTextSubject(xSpellerTarget, 3050, 3049, xSpellerTarget.modelCityList, xSpellerTarget.modelCityPreviewList, 2, true, true, false));
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(2);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.cityField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.cityField.getSpellerData(), 2);
        this.target.getSpellerContext().setState(2);
        SpellerContext.ACTIVE_HISTORY_MODE = 10002;
    }

    public void evtHSM_EXIT(AbstractReflectionContext abstractReflectionContext) {
        this.target.cityField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

