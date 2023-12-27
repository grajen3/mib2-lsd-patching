/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.dispatcher;

import de.vw.mib.list.update.ListItemControlUpdater;
import de.vw.mib.timer.Invoker;

public interface DatapoolEventDispatcher
extends Invoker {
    default public void createAndSubmitDatapoolUpdateEvent(int n, boolean bl) {
    }

    default public void createAndSubmitDatapoolUpdateEvent(int n, float f2) {
    }

    default public void createAndSubmitDatapoolUpdateEvent(int n, int n2) {
    }

    default public void createAndSubmitDatapoolUpdateEvent(int n, long l) {
    }

    default public void createAndSubmitDatapoolUpdateEvent(int n, Object object) {
    }

    default public void createAndSubmitListItemControlUpdateEvent_activatedIndexChanged(ListItemControlUpdater listItemControlUpdater, int n) {
    }

    default public void createAndSubmitListItemControlUpdateEvent_itemsChanged(ListItemControlUpdater listItemControlUpdater, int n, int n2) {
    }

    default public void createAndSubmitListItemControlUpdateEvent_itemsInserted(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3) {
    }

    default public void createAndSubmitListItemControlUpdateEvent_itemsRemoved(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3) {
    }

    default public void createAndSubmitListItemControlUpdateEvent_listChanged(ListItemControlUpdater listItemControlUpdater, int n) {
    }

    default public void createAndSubmitListItemControlUpdateEvent_listContentChanged(ListItemControlUpdater listItemControlUpdater) {
    }

    default public void createAndSubmitListItemControlUpdateEvent_stringIndexChanged(ListItemControlUpdater listItemControlUpdater) {
    }
}

