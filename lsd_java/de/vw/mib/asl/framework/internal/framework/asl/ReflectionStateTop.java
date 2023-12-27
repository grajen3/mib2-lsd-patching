/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionHsmTarget;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionState;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class ReflectionStateTop
extends AbstractReflectionState {
    public ReflectionStateTop(AbstractReflectionHsmTarget abstractReflectionHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(abstractReflectionHsmTarget, hsm, string, hsmState);
    }

    public void evtHSM_ENTRY(EventGeneric eventGeneric) {
    }
}

