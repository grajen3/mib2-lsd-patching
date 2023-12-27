/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.states;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.states.NavReflectionState;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.ChinaMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.CommonMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.JapanMatchTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateProvince
extends NavReflectionState {
    private XSpellerTarget target;

    public StateProvince(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
            this.addSubject(new CommonMatchTextSubject(xSpellerTarget, 3037, 3036, xSpellerTarget.modelProvinceList, xSpellerTarget.modelProvincePreviewList, 138, false, false, true));
            this.addSubject(new JapanMatchTextSubject(xSpellerTarget, 3037, 3036, xSpellerTarget.modelProvinceList, xSpellerTarget.modelProvincePreviewList, 138, false, false, true));
        } else {
            this.addSubject(new CommonMatchTextSubject(xSpellerTarget, 3037, 3036, xSpellerTarget.modelProvinceList, xSpellerTarget.modelProvincePreviewList, 138, true, true, true));
            this.addSubject(new ChinaMatchTextSubject(xSpellerTarget, 3037, 3036, xSpellerTarget.modelProvinceList, xSpellerTarget.modelProvincePreviewList, 138, true, true, true));
        }
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(8);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3096, true);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.provinceField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.provinceField.getSpellerData(), 8);
        this.target.getSpellerContext().setState(8);
        SpellerContext.ACTIVE_HISTORY_MODE = NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE ? 10002 : 10001;
    }

    public void evtHSM_EXIT(AbstractReflectionContext abstractReflectionContext) {
        this.target.provinceField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE ? 10002 : 10001;
    }
}

