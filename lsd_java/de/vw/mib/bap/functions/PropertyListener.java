/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;

public interface PropertyListener
extends BAPFunctionListener {
    default public boolean statusProperty(BAPEntity bAPEntity, Property property) {
    }

    default public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
    }
}

