/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.model;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;

public interface ResultCollection {
    public static final int NO_PARENT_ID;

    default public int getEventId() {
    }

    default public int getSize() {
    }

    default public ResultItem getItem() {
    }

    default public ResultItem[] getItems() {
    }

    default public ResultItem select(ResultItem resultItem) {
    }

    default public ResultItem[] expand(ResultItem resultItem) {
    }

    default public ResultItem select(int n) {
    }

    default public ResultItem[] expand(int n) {
    }

    default public int[] getGroupsId() {
    }
}

