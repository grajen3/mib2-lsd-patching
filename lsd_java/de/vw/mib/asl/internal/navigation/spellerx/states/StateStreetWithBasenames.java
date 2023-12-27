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

public class StateStreetWithBasenames
extends NavReflectionState {
    private XSpellerTarget target;

    public StateStreetWithBasenames(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addVariantSpecificSubjects();
    }

    private void addVariantSpecificSubjects() {
        if (this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.useNarSpecificSubjects();
        } else if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            this.useChnSpecificSubjects();
        } else {
            this.useEUSpecificSubjects();
        }
    }

    private void useNarSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3438, 3437, this.target.modelStreetWithBasenamesList, null, 3, false, false, true));
        this.addSubject(new NARMatchTextSubject(this.target, 3438, 3437, this.target.modelStreetWithBasenamesList, null, 3, false, false, true));
    }

    private void useChnSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 3, false, false, true));
        this.addSubject(new ChinaMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, this.target.modelStreetPreviewList, 3, false, false, true));
    }

    private void useEUSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, null, 3, false, false, true));
        this.addSubject(new EUMatchTextSubject(this.target, 3057, 3056, this.target.modelStreetList, null, 3, false, false, true));
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(10);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.streetWithBasenamesField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.streetWithBasenamesField.getSpellerData(), 10);
        this.target.getSpellerContext().setState(10);
        SpellerContext.ACTIVE_HISTORY_MODE = 10003;
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.target.streetField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

