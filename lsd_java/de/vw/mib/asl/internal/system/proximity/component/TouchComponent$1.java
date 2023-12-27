/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.component;

import de.vw.mib.asl.internal.system.abtfeatures.DsiKeyPanelListenerAdapter;
import de.vw.mib.asl.internal.system.proximity.component.TouchComponent;

class TouchComponent$1
extends DsiKeyPanelListenerAdapter {
    private final /* synthetic */ TouchComponent this$0;

    TouchComponent$1(TouchComponent touchComponent) {
        this.this$0 = touchComponent;
    }

    @Override
    public void updateGesture2(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7, int n8, int n9) {
        if (n9 == 1) {
            if (n2 == 4) {
                this.this$0.installProximityValue(true);
            } else if (n2 == 1 || n2 == 3) {
                this.this$0.installProximityValue(false);
            }
        }
    }
}

