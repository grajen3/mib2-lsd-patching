/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.soundtiles;

import de.vw.mib.appadapter.soundtiles.SoundTileSAdapter;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

class SoundTileSAdapter$2
implements CioExecutor {
    private final /* synthetic */ SoundTileSAdapter this$0;

    SoundTileSAdapter$2(SoundTileSAdapter soundTileSAdapter) {
        this.this$0 = soundTileSAdapter;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                CioIntent cioIntent = SoundTileSAdapter.access$000(this.this$0).getCioDictionary().getCioIntent("ShowContent", "HMI_SYSTEMSETUP");
                SoundTileSAdapter.access$100(this.this$0).getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return !this.this$0.isDynaudioCharacterPresetsAvailable;
    }
}

