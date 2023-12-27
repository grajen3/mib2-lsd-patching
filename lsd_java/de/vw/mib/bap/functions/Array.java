/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunction;

public interface Array
extends BAPFunction {
    default public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
    }

    default public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
    }
}

