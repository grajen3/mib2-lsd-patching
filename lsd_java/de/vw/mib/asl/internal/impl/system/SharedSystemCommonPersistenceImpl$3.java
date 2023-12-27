/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.impl.system.SharedSystemCommonPersistenceImpl;

class SharedSystemCommonPersistenceImpl$3
extends AbstractProfileChangeHandler {
    private final /* synthetic */ SharedSystemCommonPersistenceImpl this$0;

    SharedSystemCommonPersistenceImpl$3(SharedSystemCommonPersistenceImpl sharedSystemCommonPersistenceImpl) {
        this.this$0 = sharedSystemCommonPersistenceImpl;
    }

    @Override
    protected void changeProfile() {
        this.this$0.unloadData();
        this.this$0.changeProfileForChildListeners();
    }

    @Override
    protected void prepareForProfileChange() {
        this.this$0.prepareProfileChangeForChildListeners();
    }
}

