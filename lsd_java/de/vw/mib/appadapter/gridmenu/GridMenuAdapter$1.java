/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.gridmenu;

import de.vw.mib.appadapter.gridmenu.GridMenuAdapter;
import generated.de.vw.mib.appadapter.gridmenu.GesturesModelApiService;

class GridMenuAdapter$1
implements GesturesModelApiService {
    private final /* synthetic */ GridMenuAdapter this$0;

    GridMenuAdapter$1(GridMenuAdapter gridMenuAdapter) {
        this.this$0 = gridMenuAdapter;
    }

    @Override
    public void _mda_showSpaceGestureAvailableAnimation() {
        this.this$0.showSpaceGestureAvailableAnimation();
    }

    @Override
    public void _mda_showSpaceGestureRegisteredAnimation(int n, boolean bl) {
        this.this$0.showSpaceGestureRegisteredAnimation(n, bl);
    }
}

