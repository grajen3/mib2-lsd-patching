/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractASLSoundTarget
extends AbstractASLTarget {
    public AbstractASLSoundTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 16;
    }
}

