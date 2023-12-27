/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DelegatingPersonalizedAppAdapter;

class DelegatingPersonalizedAppAdapter$1
implements Runnable {
    private final /* synthetic */ PersonalizedAppListener val$delegate;
    private final /* synthetic */ DelegatingPersonalizedAppAdapter this$0;

    DelegatingPersonalizedAppAdapter$1(DelegatingPersonalizedAppAdapter delegatingPersonalizedAppAdapter, PersonalizedAppListener personalizedAppListener) {
        this.this$0 = delegatingPersonalizedAppAdapter;
        this.val$delegate = personalizedAppListener;
    }

    @Override
    public void run() {
        this.val$delegate.updateProfileState(this.this$0.lastMessage.state, this.this$0.lastMessage.profile, 1);
    }
}

