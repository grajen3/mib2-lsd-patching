/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.datatypes.BAPArrayElement;

class FsgArrayListComplete$BAPArrayListElement {
    int prevBapPosID;
    int nextBapPosID;
    int bapPosID;
    int absPosition;
    long elementAnchorID;
    BAPArrayElement listElement;

    FsgArrayListComplete$BAPArrayListElement() {
    }

    public void takeParams(int n, int n2, int n3, int n4, long l, BAPArrayElement bAPArrayElement) {
        this.prevBapPosID = n;
        this.nextBapPosID = n2;
        this.bapPosID = n3;
        this.absPosition = n4;
        this.elementAnchorID = l;
        this.listElement = bAPArrayElement;
    }
}

