/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;
import java.util.Iterator;

class PersistableServiceImpl$5
implements ProfileChanger$Task {
    private final /* synthetic */ byte val$profileId;
    private final /* synthetic */ Iterator val$moduleIterator;
    private final /* synthetic */ PersistableServiceImpl this$0;

    PersistableServiceImpl$5(PersistableServiceImpl persistableServiceImpl, byte by, Iterator iterator) {
        this.this$0 = persistableServiceImpl;
        this.val$profileId = by;
        this.val$moduleIterator = iterator;
    }

    @Override
    public void run(ProfileChanger$Context profileChanger$Context) {
        this.this$0.performProfileSwitch(this.val$profileId, this.val$moduleIterator);
        profileChanger$Context.markTaskFinished();
    }
}

