/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

public interface ASIHMISyncMediaC {
    default public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData) {
    }

    default public void resume() {
    }

    default public void pause() {
    }

    default public void skip(byte by) {
    }

    default public void seek(boolean bl) {
    }

    default public void stopSeek() {
    }

    default public void mix(boolean bl) {
    }

    default public void repeatTitle(boolean bl) {
    }

    default public void toggleRepeatState() {
    }

    default public void toggleShuffleState() {
    }

    default public void setEntry(long l) {
    }

    default public void setTimePosition(int n) {
    }

    default public void touchEvent(int n, int n2, int n3, int n4, int n5) {
    }

    default public void executeDvdVideoCommand(int n) {
    }

    default public void requestPlayList(int n, long l, int n2) {
    }

    default public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData) {
    }

    default public void playMoreFrom(long l, int n) {
    }

    default public void setNotification() {
    }

    default public void setNotification(long l) {
    }

    default public void setNotification(long[] lArray) {
    }

    default public void clearNotification() {
    }

    default public void clearNotification(long l) {
    }

    default public void clearNotification(long[] lArray) {
    }
}

