/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import org.dsi.ifc.media.ListEntry;

public interface DSIMediaBrowserC {
    default public void setContentFilter(int n) {
    }

    default public void setBrowseMode(int n) {
    }

    default public void setBrowseMedia(long l, long l2) {
    }

    default public void changeFolder(ListEntry[] listEntryArray) {
    }

    default public void requestList(long l, int n, int n2, int n3) {
    }

    default public void requestPickList(long[] lArray) {
    }

    default public void enableRecurseSubdirectories(boolean bl) {
    }

    default public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
    }

    default public void undoLastSelection() {
    }

    default public void resetSelection() {
    }

    default public void setSearchString(String string) {
    }

    default public void setSearchCriteria(int n) {
    }

    default public void activateSearchSpeller() {
    }

    default public void deactivateSearchSpeller() {
    }

    default public void selectSearchResult(long l) {
    }

    default public void requestSearchList(long l, int n, int n2) {
    }

    default public void resetSearchString() {
    }

    default public void requestSearchListExt(long l, int n, int n2) {
    }

    default public void requestFullyQualifiedName(long l) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

