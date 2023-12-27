/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;

class PersistableServiceImpl$1
implements ProfileChanger$Task {
    private final /* synthetic */ PersistableServiceImpl this$0;

    PersistableServiceImpl$1(PersistableServiceImpl persistableServiceImpl) {
        this.this$0 = persistableServiceImpl;
    }

    @Override
    public void run(ProfileChanger$Context profileChanger$Context) {
        String string = profileChanger$Context.getModule().getName();
        profileChanger$Context.getServices().getPersistenceLogger().info(new StringBuffer().append("Skipping proifle change of module ").append(string).append(" because there are no listeners for it").toString());
        profileChanger$Context.markTaskFinished();
    }
}

