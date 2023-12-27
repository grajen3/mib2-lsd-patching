/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.startup;

import de.vw.mib.asl.api.navigation.startup.AbstractNaviResettableTargetDelegator;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import java.util.HashMap;

public class NaviResettableAslHsmTargetDelegator
extends AbstractNaviResettableTargetDelegator {
    public NaviResettableAslHsmTargetDelegator(AbstractResettableAslHsmTarget abstractResettableAslHsmTarget, String string) {
        super(abstractResettableAslHsmTarget, string);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.subject instanceof AbstractResettableAslHsmTarget) {
            ((AbstractResettableAslHsmTarget)this.subject).reset(hashMap);
        }
    }
}

