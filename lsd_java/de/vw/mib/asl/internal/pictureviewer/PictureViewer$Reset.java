/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer;

final class PictureViewer$Reset
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ PictureViewer this$0;

    PictureViewer$Reset(PictureViewer pictureViewer) {
        this.this$0 = pictureViewer;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.getSettings().factoryReset();
        this.this$0.displaySettings();
        if (factoryResetCallback != null) {
            factoryResetCallback.notifyResetDone();
        }
    }
}

