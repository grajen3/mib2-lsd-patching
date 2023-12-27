/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.PuckController;

public interface ScrollbarController
extends PuckController {
    public static final String IN_SELECTNEXTPAGE_NAME;
    public static final String IN_SELECTPREVIOUSPAGE_NAME;
    public static final String IN_SELECTLASTPAGE_NAME;
    public static final String IN_SELECTFIRSTPAGE_NAME;
    public static final String OUT_NEXTPAGESELECTEDFAILED_NAME;
    public static final String OUT_NEXTPAGESELECTED_NAME;
    public static final String OUT_PREVIOUSPAGESELECTEDFAILED_NAME;
    public static final String OUT_PREVIOUSPAGESELECTED_NAME;
    public static final String OUT_LASTPAGESELECTEDFAILED_NAME;
    public static final String OUT_LASTPAGESELECTED_NAME;
    public static final String OUT_FIRSTPAGESELECTEDFAILED_NAME;
    public static final String OUT_FIRSTPAGESELECTED_NAME;
    public static final String OUT_ONLYONEPAGEAVAILABLE_NAME;

    default public void fire_selectNextPage() {
    }

    default public void fire_selectPreviousPage() {
    }

    default public void fire_selectLastPage() {
    }

    default public void fire_selectFirstPage() {
    }

    default public void fire_nextPageSelectedFailed() {
    }

    default public void fire_nextPageSelected() {
    }

    default public void fire_previousPageSelectedFailed() {
    }

    default public void fire_previousPageSelected() {
    }

    default public void fire_lastPageSelectedFailed() {
    }

    default public void fire_lastPageSelected() {
    }

    default public void fire_firstPageSelectedFailed() {
    }

    default public void fire_firstPageSelected() {
    }

    default public void fire_onlyOnePageAvailable() {
    }
}

