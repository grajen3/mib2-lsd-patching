/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.TemplateListController;

public interface FlowListController
extends TemplateListController {
    default public void fireQueuedOutEvents() {
    }

    default public void fireAbsSelectionChanged() {
    }
}

