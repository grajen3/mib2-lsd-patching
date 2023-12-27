/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.nav.modelapi;

import de.vw.mib.appadapter.nav.NavAdapter;
import generated.de.vw.mib.appadapter.nav.HomeAddressInputModelApiService;

public class HomeAddressInputService
implements HomeAddressInputModelApiService {
    @Override
    public void _mda_returnToSetupWizard(int n) {
        NavAdapter.getExecutor().returnFromInput(n);
    }
}

