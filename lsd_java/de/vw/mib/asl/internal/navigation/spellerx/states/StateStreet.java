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

public class StateStreet
extends NavReflectionState {
    private XSpellerTarget target;

    public StateStreet(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addVariantSpecificSubjects();
    }

    private void addVariantSpecificSubjects() {
        if (this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.useNarSpecificSubjects();
        } else if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
            this.useJpySpecificSubjects();
        } else if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            this.useChnSpecificSubjects();
        } else {
            this.useEUSpecificSubjects();
        }
    }

    private void useJpySpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 144, false, false, true));
        this.addSubject(new JapanMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 144, false, false, true));
    }

    private void useNarSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 141, true, true, true));
        this.addSubject(new NARMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 141, true, true, true));
    }

    private void useChnSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 3, false, false, true));
        this.addSubject(new ChinaMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 3, false, false, true));
    }

    private void useEUSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 3, false, false, true));
        this.addSubject(new EUMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 3, false, false, true));
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(3);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3097, true);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.streetField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.streetField.getSpellerData(), 3);
        this.target.getSpellerContext().setState(3);
        SpellerContext.ACTIVE_HISTORY_MODE = 10003;
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.target.streetField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

