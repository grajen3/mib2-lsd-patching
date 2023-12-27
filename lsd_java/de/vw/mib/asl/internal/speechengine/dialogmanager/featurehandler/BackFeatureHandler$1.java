/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStack;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStackListener;

class BackFeatureHandler$1
implements BackStackListener {
    private final /* synthetic */ BackFeatureHandler this$0;

    BackFeatureHandler$1(BackFeatureHandler backFeatureHandler) {
        this.this$0 = backFeatureHandler;
    }

    @Override
    public void onBackStackChanged(BackStack backStack) {
        if (backStack.isEmpty()) {
            this.this$0.setBackstackState(0);
        } else {
            this.this$0.setBackstackState(1);
        }
    }
}

