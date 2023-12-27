/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PreChangeOperation;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ProfileResetServiceImpl;

class ProfileResetServiceImpl$1
implements PreChangeOperation {
    private final /* synthetic */ int val$currentAction;
    private final /* synthetic */ byte val$profile;
    private final /* synthetic */ ProfileResetServiceImpl this$0;

    ProfileResetServiceImpl$1(ProfileResetServiceImpl profileResetServiceImpl, int n, byte by) {
        this.this$0 = profileResetServiceImpl;
        this.val$currentAction = n;
        this.val$profile = by;
    }

    @Override
    public int getCurrentAction() {
        return this.val$currentAction;
    }

    @Override
    public void run(int n) {
        this.this$0.resetUserSpecificData(this.val$profile, n);
    }
}

