/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl;
import java.util.Iterator;

class PersistableServiceImpl$3
implements Runnable {
    private final /* synthetic */ byte val$profileId;
    private final /* synthetic */ Iterator val$descriptorIterator;
    private final /* synthetic */ PersistableServiceImpl this$0;

    PersistableServiceImpl$3(PersistableServiceImpl persistableServiceImpl, byte by, Iterator iterator) {
        this.this$0 = persistableServiceImpl;
        this.val$profileId = by;
        this.val$descriptorIterator = iterator;
    }

    @Override
    public void run() {
        this.this$0.performProfileSwitch(this.val$profileId, this.val$descriptorIterator);
    }
}

