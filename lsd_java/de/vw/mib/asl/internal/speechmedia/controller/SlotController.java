/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController$1;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController$2;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController$3;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController$4;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController$5;
import de.vw.mib.asl.internal.speechmedia.controller.SlotStateListener;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SlotController {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[SlotController] ");
    public static final int AVDC_AUDIO_CD_DA_TRACKNUMBERS;
    public static final int AVDC_AUDIO_COMPRESSEDAUDIO_ALBUMS;
    public static final int AVDC_AUDIO_COMPRESSEDAUDIO_ARTISTS;
    public static final int AVDC_AUDIO_COMPRESSEDAUDIO_GENRES;
    public static final int AVDC_AUDIO_COMPRESSEDAUDIO_TITLES;
    private final SlotStateRouter slotStateRouter;
    protected int trackState = -1;
    protected int albumState = -1;
    protected int artistState = -1;
    protected int genreState = -1;
    protected int titleState = -1;
    protected Set slotStateListeners;
    private SlotStateConsumer trackConsumer = new SlotController$1(this);
    private SlotStateConsumer albumConsumer = new SlotController$2(this);
    private SlotStateConsumer artistConsumer = new SlotController$3(this);
    private SlotStateConsumer genreConsumer = new SlotController$4(this);
    private SlotStateConsumer titleConsumer = new SlotController$5(this);

    public SlotController(SlotStateRouter slotStateRouter) {
        this.slotStateRouter = slotStateRouter;
        this.slotStateListeners = new HashSet();
        this.slotStateRouter.register(1, this.trackConsumer);
        this.slotStateRouter.register(2, this.albumConsumer);
        this.slotStateRouter.register(3, this.artistConsumer);
        this.slotStateRouter.register(4, this.genreConsumer);
        this.slotStateRouter.register(5, this.titleConsumer);
    }

    protected void notifySlotStateChanged(int n, int n2) {
        Iterator iterator = this.slotStateListeners.iterator();
        while (iterator.hasNext()) {
            SlotStateListener slotStateListener = (SlotStateListener)iterator.next();
            slotStateListener.onSlotStateChanged(n, n2);
        }
    }

    public void registerSlotStateListener(SlotStateListener slotStateListener) {
        this.slotStateListeners.add(slotStateListener);
    }

    public int getAlbumState() {
        return this.albumState;
    }

    public int getArtistState() {
        return this.artistState;
    }

    public int getGenreState() {
        return this.genreState;
    }

    public int getTrackState() {
        return this.trackState;
    }

    public int getTitleState() {
        return this.titleState;
    }
}

