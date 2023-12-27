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
import de.vw.mib.asl.internal.navigation.spellerx.subjects.ChinaMatchTextHnrSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.CommonFreeTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.CommonMatchTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.EUFreeTextSubject;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NARFreeTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateHousenumber
extends NavReflectionState {
    private XSpellerTarget target;

    public StateHousenumber(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.startVariantSpecificSpeller();
    }

    private void startVariantSpecificSpeller() {
        if (this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.useNARSpeller(136);
        } else if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE) {
            this.useCHNSpeller(5);
        } else {
            this.useEUSpeller(136);
        }
    }

    private void useEUSpeller(int n) {
        this.addSubject(new CommonFreeTextSubject(this.target, 3077, 3076, this.target.modelHousenumberList, null, n, false, false, false));
        this.addSubject(new EUFreeTextSubject(this.target, 3077, 3076, this.target.modelHousenumberList, null, n, false, false, false));
    }

    private void useNARSpeller(int n) {
        this.addSubject(new CommonFreeTextSubject(this.target, 3077, 3076, this.target.modelHousenumberList, null, n, false, false, false));
        this.addSubject(new NARFreeTextSubject(this.target, 3077, 3076, this.target.modelHousenumberList, null, n, false, false, false));
    }

    private void useCHNSpeller(int n) {
        SpellerContext.isPointLocation = true;
        this.addSubject(new CommonMatchTextSubject(this.target, 3077, 3076, this.target.modelHousenumberList, null, n, false, false, false));
        this.addSubject(new ChinaMatchTextHnrSubject(this.target, 3077, 3076, this.target.modelHousenumberList, null, n, false, false, false));
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(4);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.housenumberField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.housenumberField.getSpellerData(), 4);
        this.target.getSpellerContext().setState(4);
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
        ServiceManager.aslPropertyManager.valueChangedBoolean(3098, true);
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        this.target.housenumberField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

