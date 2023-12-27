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
import de.vw.mib.asl.internal.navigation.spellerx.subjects.JapanMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NARMatchTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateCity
extends NavReflectionState {
    private XSpellerTarget target;

    public StateCity(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addVariantSpecificSubjects();
    }

    private void addVariantSpecificSubjects() {
        int n;
        int n2 = n = this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES || NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE || NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE ? 2 : 133;
        if (this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.addSubject(new CommonMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, true, true, true));
            this.addSubject(new NARMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, true, true, true));
        } else if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
            this.addSubject(new CommonMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, false, false, true));
            this.addSubject(new JapanMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, false, false, true));
        } else if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            this.addSubject(new CommonMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, true, true, true));
            this.addSubject(new ChinaMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, true, true, true));
        } else {
            this.addSubject(new CommonMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, true, true, true));
            this.addSubject(new EUMatchTextSubject(this.target, 3050, 3049, this.target.modelCityList, this.target.modelCityPreviewList, n, true, true, true));
        }
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

