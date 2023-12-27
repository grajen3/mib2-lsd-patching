/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.states;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.states.NavReflectionState;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.ChinaMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.CommonMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.EUMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NARMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateCountry
extends NavReflectionState {
    private XSpellerTarget target;
    private MatchTextSubjectUtil mtsUtil = new MatchTextSubjectUtil();

    public StateCountry(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addVariantSpecificSubjects();
    }

    private void addVariantSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3025, 3024, this.target.modelCountryList, null, 1, true, true, true));
        if (this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.addSubject(new NARMatchTextSubject(this.target, 3025, 3024, this.target.modelCountryList, null, 1, true, true, true));
        } else if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            this.addSubject(new ChinaMatchTextSubject(this.target, 3025, 3024, this.target.modelCountryList, null, 1, true, true, true));
        } else {
            this.addSubject(new EUMatchTextSubject(this.target, 3025, 3024, this.target.modelCountryList, null, 1, true, true, true));
        }
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(1);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.countryField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.countryField.getSpellerData(), 1);
        this.target.getSpellerContext().setState(1);
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }

    public void evtHSM_EXIT(AbstractReflectionContext abstractReflectionContext) {
        this.target.countryField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

