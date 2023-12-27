/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.StaticImageModel;

public interface ListModel
extends ContainerModel {
    public static final int PID_BASE;
    public static final int PID_SELECTED_INDEX;
    public static final int PID_CURSOR_IMAGE_REF;
    public static final int PID_CYCLIC_SCROLLING;
    public static final int PID_INTERACTIVE;
    public static final int PID_COUNT_ABSTRACT_LIST;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_LIST;
    public static final int SELECTED_INDEX_NONE;
    public static final int SID_BASE;
    public static final int SID_CYCLIC_SCROLLING;
    public static final int SID_INTERACTIVE;
    public static final int SID_COUNT_LIST;

    default public int get_selectedIndex() {
    }

    default public void set_selectedIndex(int n) {
    }

    default public StaticImageModel get_cursorImageRef() {
    }

    default public void set_cursorImageRef(StaticImageModel staticImageModel) {
    }

    default public boolean is_cyclicScrolling() {
    }

    default public void set_cyclicScrolling(boolean bl) {
    }

    default public boolean is_interactive() {
    }

    default public void set_interactive(boolean bl) {
    }
}

