/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.ASLListUpdates;
import de.vw.mib.log4mib.Loggable;

interface GenericASLList$DataStrategy
extends ASLListUpdates,
Loggable {
    default public void disableWindowing() {
    }

    default public void enableWindowing(ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
    }

    default public boolean isWindowingEnabled() {
    }

    default public int getItemCount() {
    }

    default public Object[] getAllItems() {
    }

    default public void getLoadedListItems(int n, Object[] objectArray) {
    }

    default public void getItems(int n, Object[] objectArray) {
    }

    default public Object getListItemByIdCacheOnly(long l) {
    }

    default public Object getRowItem(int n) {
    }

    default public Object getRowItemCacheOnly(int n) {
    }

    default public void updateList(Object[] objectArray) {
    }

    default public void setSize(int n) {
    }

    default public void refetch(int n, int n2) {
    }

    default public void setSizeClearCache(int n) {
    }

    default public void notifyExecutingQueueFinished() {
    }

    default public StringBuffer append(StringBuffer stringBuffer) {
    }
}

