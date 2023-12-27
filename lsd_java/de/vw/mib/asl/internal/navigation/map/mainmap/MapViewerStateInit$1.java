/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerStateInit;

class MapViewerStateInit$1
implements DialogStateConsumer {
    private final /* synthetic */ MapViewerStateInit this$0;

    MapViewerStateInit$1(MapViewerStateInit mapViewerStateInit) {
        this.this$0 = mapViewerStateInit;
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 0) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainSpeechRecognizerActive();
            MapViewerStateInit.access$000((MapViewerStateInit)this.this$0).datapoolShared.setSpeechRecognitionActive(true);
        }
        if (n == 1) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainSpeechRecognizerInactive();
            MapViewerStateInit.access$000((MapViewerStateInit)this.this$0).datapoolShared.setSpeechRecognitionActive(false);
        }
        if (n == 2) {
            MapViewerStateInit.access$100(this.this$0).trace("Speech active");
            MapViewerStateInit.access$000((MapViewerStateInit)this.this$0).datapool.setSpeechActive(true);
        }
        if (n == 8) {
            MapViewerStateInit.access$100(this.this$0).trace("Speech inactive");
            MapViewerStateInit.access$000((MapViewerStateInit)this.this$0).datapool.setSpeechActive(false);
        }
    }
}

