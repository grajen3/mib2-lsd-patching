/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.controller;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;

public interface ControllerDelegate {
    default public Category getCategory(Controller controller, int n) {
    }
}

