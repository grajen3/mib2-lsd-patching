/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.targets.abstracts;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractASLPhoneTarget
extends AbstractASLTarget {
    public AbstractASLPhoneTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 4;
    }
}

