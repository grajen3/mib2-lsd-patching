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
import de.vw.mib.asl.internal.navigation.spellerx.subjects.JPMapCodeMatchTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateMapCode
extends NavReflectionState {
    public static boolean restore;
    public static boolean restored;
    private XSpellerTarget target;

    public StateMapCode(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addVariantSpecificSubjects();
    }

    private void addVariantSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, -873459712, -890236928, this.target.modelMapcodeList, null, 142, true, true, true));
        this.addSubject(new JPMapCodeMatchTextSubject(this.target, -873459712, -890236928, this.target.modelMapcodeList, null, 142, true, true, true));
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(15);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.mapcodeField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.mapcodeField.getSpellerData(), 15);
        this.target.getSpellerContext().setState(15);
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }

    public void evtHSM_EXIT(AbstractReflectionContext abstractReflectionContext) {
        restore = false;
        restored = false;
        this.target.mapcodeField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

