/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.targets.abstracts;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractASLHsmPhoneTarget
extends AbstractASLHsmTarget {
    public AbstractASLHsmPhoneTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 4;
    }
}

