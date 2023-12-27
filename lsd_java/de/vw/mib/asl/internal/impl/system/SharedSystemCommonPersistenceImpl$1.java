/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.system.SharedSystemCommonPersistenceImpl;

class SharedSystemCommonPersistenceImpl$1
implements ProfileChangeCallback {
    private final /* synthetic */ ProfileChangeListener val$childListener;
    private final /* synthetic */ SharedSystemCommonPersistenceImpl this$0;

    SharedSystemCommonPersistenceImpl$1(SharedSystemCommonPersistenceImpl sharedSystemCommonPersistenceImpl, ProfileChangeListener profileChangeListener) {
        this.this$0 = sharedSystemCommonPersistenceImpl;
        this.val$childListener = profileChangeListener;
    }

    @Override
    public void notifyReadyForProfileChange() {
        this.this$0.onReadyForProfileChangeCallback(this.val$childListener);
    }

    @Override
    public void notifyProfileChanged(boolean bl) {
    }
}

