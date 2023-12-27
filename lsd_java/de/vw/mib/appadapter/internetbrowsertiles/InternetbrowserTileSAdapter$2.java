/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.internetbrowsertiles;

import de.vw.mib.appadapter.internetbrowsertiles.InternetbrowserTileSAdapter;
import de.vw.mib.cio.CioIntent;
import generated.de.vw.mib.appadapter.internetbrowsertiles.InformationModelApiService;

class InternetbrowserTileSAdapter$2
implements InformationModelApiService {
    private final /* synthetic */ InternetbrowserTileSAdapter this$0;

    InternetbrowserTileSAdapter$2(InternetbrowserTileSAdapter internetbrowserTileSAdapter) {
        this.this$0 = internetbrowserTileSAdapter;
    }

    @Override
    public void _mda_internetbrowserTileSShowInternetbrowser() {
        CioIntent cioIntent = InternetbrowserTileSAdapter.access$200(this.this$0).getCioDictionary().getCioIntent("ShowContent", "HMI_INTERNETBROWSER");
        InternetbrowserTileSAdapter.access$300(this.this$0).getCioDispatcher().dispatch(cioIntent);
    }
}

