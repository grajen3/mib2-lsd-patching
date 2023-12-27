/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface ASGArrayList {
    public static final int ARRAY_ERROR_CODE_REQUEST_TIME_OUT;
    public static final int ARRAY_ERROR_CODE_HEART_BEAT_TIME_OUT;
    public static final int ARRAY_ERROR_CODE_MAX_DATA_LENGTH_EXCEEDED;
    public static final int ARRAY_ERROR_CODE_TEMPORARY_NOT_AVAILABLE;
    public static final int HIGH_LEVEL_RETRY_TYPE_A;
    public static final int HIGH_LEVEL_RETRY_TYPE_B;

    default public void changedArray(BAPChangedArray bAPChangedArray) {
    }

    default public void statusArray(BAPStatusArray bAPStatusArray) {
    }

    default public void error(int n) {
    }

    default public void insertArrayElements(BAPArrayDataList bAPArrayDataList, int n, int n2) {
    }

    default public void deleteArrayElements(BAPArrayDataList bAPArrayDataList, int n) {
    }

    default public void modifyArrayElement(BAPArrayElement bAPArrayElement, int n) {
    }

    default public void reloadData() {
    }

    default public void refreshElements(BAPArrayElement bAPArrayElement, int n, int n2) {
    }

    default public void stopFetchingData() {
    }

    default public void clearList() {
    }

    default public boolean isLoading() {
    }

    default public boolean isLoadingError() {
    }

    default public boolean isModifyRequestPending() {
    }

    default public int getListId() {
    }

    default public int getAsgId() {
    }

    default public int size() {
    }

    default public int getBapArrayListSize() {
    }

    default public int getHighLevelRetryType() {
    }

    default public BAPArrayElement get(int n) {
    }

    default public BAPArrayDataList getElements(int n, int n2) {
    }

    default public BAPArrayDataList getAllElements() {
    }

    default public ASGArrayListDelegate getDelegate() {
    }

    default public ASGArrayListChangeNotifier getChangeNotifier() {
    }

    default public ASGArrayListFactory getFactory() {
    }
}

