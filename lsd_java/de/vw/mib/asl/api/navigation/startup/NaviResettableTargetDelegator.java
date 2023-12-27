/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.startup;

import de.vw.mib.asl.api.navigation.startup.AbstractNaviResettableTargetDelegator;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import java.util.HashMap;

public class NaviResettableTargetDelegator
extends AbstractNaviResettableTargetDelegator {
    public NaviResettableTargetDelegator(AbstractResettableTarget abstractResettableTarget, String string) {
        super(abstractResettableTarget, string);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.subject instanceof AbstractResettableTarget) {
            ((AbstractResettableTarget)this.subject).reset(hashMap);
        }
    }
}

