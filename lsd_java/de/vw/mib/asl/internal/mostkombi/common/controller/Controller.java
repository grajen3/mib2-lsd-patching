/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.controller;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.controller.ControllerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;

public interface Controller {
    default public void setControllerDelegate(ControllerDelegate controllerDelegate) {
    }

    default public Category getCategory(int n) {
    }

    default public Sequence getSequence(int n) {
    }
}

