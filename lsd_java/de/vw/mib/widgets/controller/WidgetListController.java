/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.TemplateListController;

public interface WidgetListController
extends TemplateListController {
    public static final String IN_SELECTNEXTPAGE_NAME;
    public static final String IN_SELECTPREVIOUSPAGE_NAME;
    public static final String IN_ACTIVATEBROWSING_NAME;
    public static final String OUT_PAGECHANGED_NAME;
    public static final String OUT_ITEMEXPANDED_NAME;
    public static final String OUT_ITEMCOLLAPSED_NAME;

    default public void fire_selectNextPage() {
    }

    default public void fire_selectPreviousPage() {
    }

    default public void fire_activateBrowsing() {
    }

    default public void fire_pageChanged(int n) {
    }

    default public void fire_itemExpanded() {
    }

    default public void fire_itemCollapsed() {
    }
}

