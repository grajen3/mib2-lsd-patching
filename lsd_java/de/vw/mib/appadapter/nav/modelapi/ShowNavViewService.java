/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.nav.modelapi;

import de.vw.mib.appadapter.nav.NavAdapter;
import generated.de.vw.mib.appadapter.nav.ShowNavViewModelApiService;

public class ShowNavViewService
implements ShowNavViewModelApiService {
    @Override
    public void _mda_setNavView(boolean bl) {
        NavAdapter.getExecutor().updateShowNavView(bl);
    }
}

