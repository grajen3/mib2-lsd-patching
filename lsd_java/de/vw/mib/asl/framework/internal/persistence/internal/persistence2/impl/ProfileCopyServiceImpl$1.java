/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.PersonalizedAppAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ProfileCopyServiceImpl;

class ProfileCopyServiceImpl$1
extends PersonalizedAppAdapter {
    private final /* synthetic */ AbstractPersonalizedAppDsiAdapter val$dsiAdapter;
    private final /* synthetic */ ProfileCopyServiceImpl this$0;

    ProfileCopyServiceImpl$1(ProfileCopyServiceImpl profileCopyServiceImpl, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        this.this$0 = profileCopyServiceImpl;
        this.val$dsiAdapter = abstractPersonalizedAppDsiAdapter;
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        if (n3 != 0) {
            this.this$0.logWarning(new StringBuffer().append("Copy profile >").append(n).append("->").append(n2).append("< for DSI adapter >").append(super.getClass().getName()).append("< was not successful. Return value was >").append(n3).append("<.").toString());
        }
    }
}

