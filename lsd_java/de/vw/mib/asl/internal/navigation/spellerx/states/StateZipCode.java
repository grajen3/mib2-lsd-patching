/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.states;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.states.NavReflectionState;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.ChinaMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.CommonMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.EUMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NARMatchTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateZipCode
extends NavReflectionState {
    private XSpellerTarget target;
    public static boolean restore = false;

    public StateZipCode(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        if (xSpellerTarget.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.addSubject(new CommonMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, null, 6, true, true, true));
            this.addSubject(new NARMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, null, 6, true, true, true));
        } else if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            this.addSubject(new CommonMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, null, 6, true, true, true));
            this.addSubject(new ChinaMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, null, 6, true, true, true));
        } else {
            this.addSubject(new CommonMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, null, 6, true, true, true));
            this.addSubject(new EUMatchTextSubject(xSpellerTarget, 3044, 3043, xSpellerTarget.modelPostalcodeList, null, 6, true, true, true));
        }
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(6);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.postalcodeField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.postalcodeField.getSpellerData(), 6);
        this.target.getSpellerContext().setState(6);
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.target.postalcodeField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

