/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.traffic.INavRectangle;
import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.navigation.traffic.ITmcPhoneme;

public class VicsVenmMessage {
    private final boolean isUrgent;
    private final ITmcMessage message;
    private final INavRectangle rectangle;
    private final int soundID;
    private final ITmcPhoneme phoneme;

    public VicsVenmMessage(boolean bl, ITmcMessage iTmcMessage, INavRectangle iNavRectangle, int n, ITmcPhoneme iTmcPhoneme) {
        this.isUrgent = bl;
        this.message = iTmcMessage;
        this.rectangle = iNavRectangle;
        this.soundID = n;
        this.phoneme = iTmcPhoneme;
    }

    public ITmcMessage getMessage() {
        return this.message;
    }

    public INavRectangle getRectangle() {
        return this.rectangle;
    }

    public int getSoundID() {
        return this.soundID;
    }

    public ITmcPhoneme getPhoneme() {
        return this.phoneme;
    }

    public boolean isUrgent() {
        return this.isUrgent;
    }
}

