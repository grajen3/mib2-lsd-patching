/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.PreferredList;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.PreferredList_Status;

public class PreferredListNar
extends PreferredList {
    @Override
    protected void setPreferredMode(PreferredList_Status preferredList_Status) {
        if (this.getSoundService().getCurrentAudioComponent() == 5) {
            switch (this.getTvTunerService().getTvScopeOfArrowKeyMode()) {
                case 0: {
                    preferredList_Status.list = 2;
                    break;
                }
                case 1: {
                    preferredList_Status.list = 1;
                    break;
                }
                default: {
                    preferredList_Status.list = 0;
                    break;
                }
            }
        } else {
            switch (this.getRadioService().getScopeOfArrowKeyMode()) {
                case 0: {
                    preferredList_Status.list = 2;
                    break;
                }
                case 1: {
                    preferredList_Status.list = 1;
                    break;
                }
                default: {
                    preferredList_Status.list = 0;
                }
            }
        }
    }
}

