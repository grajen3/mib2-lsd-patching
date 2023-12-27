/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.startup;

import de.vw.mib.asl.api.navigation.startup.AbstractNaviResettableTargetDelegator;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import java.util.HashMap;

public class NaviResettableAslTargetDelegator
extends AbstractNaviResettableTargetDelegator {
    public NaviResettableAslTargetDelegator(AbstractResettableAslTarget abstractResettableAslTarget, String string) {
        super(abstractResettableAslTarget, string);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.subject instanceof AbstractResettableAslTarget) {
            ((AbstractResettableAslTarget)this.subject).reset(hashMap);
        }
    }
}

