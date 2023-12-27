/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.AbstractDsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DsiAwareProfileChangeListenerAdapter$2
extends AbstractDsiAwareProfileChangeListenerCallback {
    private final /* synthetic */ String val$stepId;
    private final /* synthetic */ List val$dsiAdapters;
    private final /* synthetic */ int val$localCurrentAction;
    private final /* synthetic */ byte val$localNewProfileId;
    private final /* synthetic */ DsiAwareProfileChangeListenerAdapter this$0;

    DsiAwareProfileChangeListenerAdapter$2(DsiAwareProfileChangeListenerAdapter dsiAwareProfileChangeListenerAdapter, Logger logger, String string, String string2, List list, int n, byte by) {
        this.this$0 = dsiAwareProfileChangeListenerAdapter;
        this.val$stepId = string2;
        this.val$dsiAdapters = list;
        this.val$localCurrentAction = n;
        this.val$localNewProfileId = by;
        super(logger, string);
    }

    @Override
    protected void processCallbackTask(boolean bl) {
        if (!bl) {
            this.this$0.logWarning().append(new StringBuffer().append(this.val$stepId).append(" was not successful.").toString()).log();
        }
        this.this$0.setPendingDsiAdapterCallbacks(new ArrayList(this.val$dsiAdapters));
        switch (this.val$localCurrentAction) {
            case 1: {
                Iterator iterator = this.val$dsiAdapters.iterator();
                while (iterator.hasNext()) {
                    AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
                    abstractPersonalizedAppDsiAdapter.profileChange(this.val$localNewProfileId);
                }
                break;
            }
            case 2: {
                Iterator iterator = this.val$dsiAdapters.iterator();
                while (iterator.hasNext()) {
                    AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
                    abstractPersonalizedAppDsiAdapter.profileReset(this.val$localNewProfileId);
                }
                break;
            }
            case 3: {
                Iterator iterator = this.val$dsiAdapters.iterator();
                while (iterator.hasNext()) {
                    AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter = (AbstractPersonalizedAppDsiAdapter)iterator.next();
                    abstractPersonalizedAppDsiAdapter.profileResetAll();
                }
                break;
            }
            default: {
                this.this$0.logError().append("Undefined profile action with id: ").append(this.val$localCurrentAction).log();
            }
        }
    }
}

