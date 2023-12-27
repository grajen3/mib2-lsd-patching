/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.audiotilel;

import de.vw.mib.appadapter.audiotilel.AudioTileLAdapter;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;

public class AudioTileLEntertainmentButtonCioListener
implements CioRegistrationListener {
    private int[] registrationCounts = new int[]{0, 0, 0};
    private final AudioTileLAdapter audioTileLAdapter;

    public AudioTileLEntertainmentButtonCioListener(AudioTileLAdapter audioTileLAdapter) {
        this.audioTileLAdapter = audioTileLAdapter;
    }

    @Override
    public void cioRegistered(String string, CioIntent cioIntent) {
        int n = this.audioTileLAdapter.getButtonIndex(cioIntent);
        if (n < 0 || n >= this.registrationCounts.length) {
            return;
        }
        this.audioTileLAdapter.updateEntertainmentCio(cioIntent, n);
        this.registrationCounts[n] = this.registrationCounts[n] + 1;
    }

    @Override
    public void cioUnregistered(String string, CioIntent cioIntent) {
        int n = this.audioTileLAdapter.getButtonIndex(cioIntent);
        if (n < 0 || n >= this.registrationCounts.length) {
            return;
        }
        int n2 = this.registrationCounts[n];
        if (n2 == 1) {
            this.audioTileLAdapter.updateEntertainmentCio(null, n);
        }
        this.registrationCounts[n] = n2 > 1 ? n2 - 1 : 0;
    }

    public void increaseRegistrationCount(int n) {
        if (n < 0 || n >= this.registrationCounts.length) {
            return;
        }
        this.registrationCounts[n] = this.registrationCounts[n] + 1;
    }
}

