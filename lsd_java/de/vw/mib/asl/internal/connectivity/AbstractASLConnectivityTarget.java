/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractASLConnectivityTarget
extends AbstractASLTarget {
    public AbstractASLConnectivityTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }
}

