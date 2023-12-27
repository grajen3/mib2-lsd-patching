/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.datatypes.BAPArrayDataList;

public interface ASGArrayListChangeNotifier {
    default public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
    }

    default public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
    }

    default public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
    }

    default public void reloaded(ASGArrayList aSGArrayList) {
    }
}

