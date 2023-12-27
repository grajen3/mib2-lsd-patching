/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;
import de.vw.mib.list.update.ListItemControlUpdater;

public interface ListItemControlUpdateEvent
extends Event {
    public static final int ACTIVATED_INDEX_CHANGED;
    public static final int ITEMS_CHANGED;
    public static final int ITEMS_INSERTED;
    public static final int ITEMS_REMOVED;
    public static final int LIST_CHANGED;
    public static final int LIST_CONTENT_CHANGED;
    public static final int STRING_INDEX_CHANGED;

    default public ListItemControlUpdater getListItemControlUpdater() {
    }

    default public int getParameter_1() {
    }

    default public int getParameter_2() {
    }

    default public int getParameter_3() {
    }

    default public int getType() {
    }
}

