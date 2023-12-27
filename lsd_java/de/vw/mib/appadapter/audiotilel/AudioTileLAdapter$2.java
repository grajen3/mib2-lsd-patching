/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.audiotilel;

import de.vw.mib.appadapter.audiotilel.AudioTileLAdapter;
import de.vw.mib.cio.CioIntent;
import generated.de.vw.mib.appadapter.audiotilel.EntertainmentButtonsModelApiService;

class AudioTileLAdapter$2
implements EntertainmentButtonsModelApiService {
    private final /* synthetic */ AudioTileLAdapter this$0;

    AudioTileLAdapter$2(AudioTileLAdapter audioTileLAdapter) {
        this.this$0 = audioTileLAdapter;
    }

    @Override
    public void _mda_buttonMediaPressed() {
        CioIntent cioIntent = (CioIntent)AudioTileLAdapter.access$000(this.this$0).get(0);
        if (cioIntent != null) {
            AudioTileLAdapter.access$100(this.this$0).getCioDispatcher().dispatch(cioIntent);
        }
    }

    @Override
    public void _mda_buttonTunerPressed() {
        CioIntent cioIntent = (CioIntent)AudioTileLAdapter.access$000(this.this$0).get(1);
        if (cioIntent != null) {
            AudioTileLAdapter.access$200(this.this$0).getCioDispatcher().dispatch(cioIntent);
        }
    }

    @Override
    public void _mda_buttonTvTunerPressed() {
        CioIntent cioIntent = (CioIntent)AudioTileLAdapter.access$000(this.this$0).get(2);
        if (cioIntent != null) {
            AudioTileLAdapter.access$300(this.this$0).getCioDispatcher().dispatch(cioIntent);
        }
    }
}

