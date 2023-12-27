/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.api.vicsetc.ASLVicsEtcListener;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar;
import generated.de.vw.mib.asl.internal.ListManager;

class TargetASLStatusbar$2
implements ASLVicsEtcListener {
    private final /* synthetic */ TargetASLStatusbar this$0;

    TargetASLStatusbar$2(TargetASLStatusbar targetASLStatusbar) {
        this.this$0 = targetASLStatusbar;
    }

    @Override
    public void updateEtcCardStateAndPaymentAmount(int n, int n2) {
        TargetASLStatusbar.access$000()[0].statusbar_etc_state = n;
        TargetASLStatusbar.access$000()[0].statusbar_etc_payment = n2;
        if (n == 3) {
            this.this$0.retriggerOrStartTimer(-1585053440, (long)0, false);
        } else {
            this.this$0.stopTimer(-1585053440);
        }
        ListManager.getGenericASLList(-117945088).updateList(TargetASLStatusbar.access$000());
    }

    @Override
    public void updateVicsStatusBarInfo(int n, int n2, int n3) {
        TargetASLStatusbar.access$100()[0].statusbar_vics_state = n;
        TargetASLStatusbar.access$100()[0].statusbar_vics_time_hours = n2;
        TargetASLStatusbar.access$100()[0].statusbar_vics_time_minutes = n3;
        ListManager.getGenericASLList(-134722304).updateList(TargetASLStatusbar.access$100());
    }
}

