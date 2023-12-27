/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;

final class DnUpQueue {
    private final AbsoluteActivation root = AbsoluteActivation.INVALID;

    DnUpQueue() {
    }

    public boolean pop(AbsoluteActivation absoluteActivation) {
        for (AbsoluteActivation absoluteActivation2 = this.root.getNextInserted(); absoluteActivation2 != null; absoluteActivation2 = absoluteActivation2.getNextInserted()) {
            if (!absoluteActivation2.equals(absoluteActivation)) continue;
            this.root.setNextInserted(absoluteActivation2.getNextInserted());
            return true;
        }
        return false;
    }

    public void add(AbsoluteActivation absoluteActivation) {
        this.remove(absoluteActivation).setNextInserted(absoluteActivation);
    }

    public AbsoluteActivation remove(AbsoluteActivation absoluteActivation) {
        AbsoluteActivation absoluteActivation2 = this.root;
        for (AbsoluteActivation absoluteActivation3 = this.root.getNextInserted(); absoluteActivation3 != null; absoluteActivation3 = absoluteActivation3.getNextInserted()) {
            if (absoluteActivation3.equals(absoluteActivation)) {
                absoluteActivation2.setNextInserted(absoluteActivation3.getNextInserted());
                continue;
            }
            absoluteActivation2 = absoluteActivation3;
        }
        return absoluteActivation2;
    }

    public void empty() {
        this.root.setNextInserted(null);
    }
}

