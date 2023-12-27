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
import de.vw.mib.asl.internal.navigation.spellerx.subjects.JPPhoneNumberMatchTextSubject;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StatePhoneNumber
extends NavReflectionState {
    public static boolean restore;
    public static boolean restored;
    private XSpellerTarget target;

    public StatePhoneNumber(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
        this.addVariantSpecificSubjects();
    }

    private void addVariantSpecificSubjects() {
        this.addSubject(new CommonMatchTextSubject(this.target, -940568576, -957345792, this.target.modelPhoneNumberList, null, 8, true, true, true));
        this.addSubject(new JPPhoneNumberMatchTextSubject(this.target, -940568576, -957345792, this.target.modelPhoneNumberList, null, 8, true, true, true));
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        this.target.getSpellerContext().setState(14);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.target.phoneNumberField.clearDSIState();
        ModelUpdater.updateSpellerData(this.target.phoneNumberField.getSpellerData(), 14);
        this.target.getSpellerContext().setState(14);
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }

    public void evtHSM_EXIT(AbstractReflectionContext abstractReflectionContext) {
        restore = false;
        restored = false;
        this.target.phoneNumberField = this.target.getSpellerContext().getActiveField();
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }
}

