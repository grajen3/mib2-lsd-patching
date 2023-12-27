/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.PropertyListener;

public interface Property
extends BAPFunction {
    default public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    default public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    default public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }
}

