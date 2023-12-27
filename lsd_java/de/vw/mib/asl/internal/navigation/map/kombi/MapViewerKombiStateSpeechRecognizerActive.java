/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerKombiStateSpeechRecognizerActive
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateSpeechRecognizerActive]");
    private final MapViewerKombiTargetHSM target;

    public MapViewerKombiStateSpeechRecognizerActive(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
        super(mapViewerKombiTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerKombiTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1074841846: {
                this.handleMapKombiSetInvisible();
                break;
            }
            case 1074841845: {
                this.handleMapKombiSetVisible();
                break;
            }
            case 3499064: {
                this.handleSpeechRecognizerInactive();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleMapKombiSetInvisible() {
        this.logger.trace("handleMapKombiSetInvisible() - the Kombi MapViewer is already invisible, the event will be ignored");
        this.target.datapool.setMapViewerVisibleAfterRecognizerFinished(false);
        this.target.notifierModel.notifyKombiMapInvisible();
    }

    private void handleMapKombiSetVisible() {
        this.logger.trace("handleMapKombiSetVisible() - the SpeechRecognizer is active we can't set the MapViewer to visible, event will be ignored, we'll set the mapviewer visible after the recognizer has finished");
        this.target.datapool.setMapViewerVisibleAfterRecognizerFinished(true);
        this.target.notifierModel.notifyKombiMapVisible();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierDSI.viewSetInvisible();
    }

    private void handleSpeechRecognizerInactive() {
        this.logger.makeInfo().append("handleSpeechRecognitionInactive()").log();
        if (this.target.datapool.isMapViewerVisibleAfterRecognizerFinished()) {
            this.target.transStateVisible();
        } else {
            this.target.transStateInvisible();
        }
    }
}

