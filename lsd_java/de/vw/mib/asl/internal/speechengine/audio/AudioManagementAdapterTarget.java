/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioManagementAdapter;
import de.vw.mib.asl.internal.speechengine.audio.AudioManagementAdapterListener;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderParameters;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;

public final class AudioManagementAdapterTarget
extends AbstractTarget
implements AudioManagementAdapter {
    private AudioManagementAdapterListener adapterListeners;
    private final EventFactory eventFactory;
    public static final int EV_SPEECH_INTERNAL_HOLD_AUDIO_CONNECTION_TIMEOUT;
    static final int[] OBSERVER;

    public AudioManagementAdapterTarget(AudioProviderParameters audioProviderParameters) {
        super(audioProviderParameters.getGenericEvents(), audioProviderParameters.getTargetId(), audioProviderParameters.getTaskId());
        this.eventFactory = audioProviderParameters.getEventFactory();
        this.addObservers(OBSERVER);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100302: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getResult();
                if (this.adapterListeners == null) break;
                this.adapterListeners.resultRequestConnection(n, this.getMappedResultCode(n2));
                break;
            }
            case 100305: {
                int n = eventGeneric.getInt(0);
                int n3 = eventGeneric.getResult();
                if (this.adapterListeners == null) break;
                this.adapterListeners.resultReleaseConnection(n, this.getMappedResultCode(n3));
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                if (this.adapterListeners == null) break;
                this.adapterListeners.updateLossOfConnection(n);
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                this.updateAudioManagementStatus(n);
                break;
            }
        }
    }

    private int getMappedResultCode(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 12: {
                n2 = 1;
                break;
            }
            case 11: {
                n2 = 11;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    private void updateAudioManagementStatus(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        if (this.adapterListeners != null) {
            this.adapterListeners.updateAudioManagementState(n2);
        }
    }

    @Override
    public void requestConnection(int n) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(34159872);
        eventGeneric.setSenderTargetId(this.getTargetId());
        eventGeneric.setSenderEventId(-830013184);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, false);
        eventGeneric.setBoolean(2, false);
        this.sendSafe(eventGeneric);
    }

    @Override
    public void releaseConnection(int n) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(67714304);
        eventGeneric.setSenderTargetId(this.getTargetId());
        eventGeneric.setSenderEventId(-779681536);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, false);
        eventGeneric.setBoolean(2, false);
        this.sendSafe(eventGeneric);
    }

    @Override
    public void setAdapterListener(AudioManagementAdapterListener audioManagementAdapterListener) {
        this.adapterListeners = audioManagementAdapterListener;
    }

    static {
        OBSERVER = new int[]{252263680, 352926976};
    }
}

