/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.states;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
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

public class StateCrossing
extends NavReflectionState {
    private XSpellerTarget target;

    public StateCrossing(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addVariantSpecificSubjects();
    }

    private void addVariantSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3070, 3069, this.target.modelCrossingList, this.target.modelCrossingPreviewList, 4, false, false, false));
        if (this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.addSubject(new NARMatchTextSubject(this.target, 3070, 3069, this.target.modelCrossingList, this.target.modelCrossingPreviewList, 4, false, false, false));
        } else if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
            this.addSubject(new JapanMatchTextSubject(this.target, 3070, 3069, this.target.modelCrossingList, this.target.modelCrossingPreviewList, 5, false, false, false));
        } else if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            this.addSubject(new ChinaMatchTextSubject(this.target, 3070, 3069, this.target.modelCrossingList, this.target.modelCrossingPreviewList, 4, false, false, false));
        } else {
            this.addSubject(new EUMatchTextSubject(this.target, 3070, 3069, this.target.modelCrossingList, this.target.modelCrossingPreviewList, 4, false, false, false));
        }
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(5);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3100, true);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.crossingField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.crossingField.getSpellerData(), 5);
        this.target.getSpellerContext().setState(5);
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
        ServiceManager.aslPropertyManager.valueChangedBoolean(3100, true);
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.target.crossingField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

