/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayListComplete$BAPArrayListElement;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface FsgArrayListIterator {
    default public BAPArrayElement next() {
    }

    default public FsgArrayListComplete$BAPArrayListElement nextArrayListElement() {
    }

    default public FsgArrayListComplete$BAPArrayListElement currentArrayListElement() {
    }

    default public boolean hasNext() {
    }
}

