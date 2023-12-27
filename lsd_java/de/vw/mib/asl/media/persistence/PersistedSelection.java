/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.List;

public interface PersistedSelection
extends Persistable {
    default public int getPlaymode() {
    }

    default public void setPlaymode(int n) {
    }

    default public String getUniqeMediaId() {
    }

    default public void setUniqeMediaId(String string) {
    }

    default public int getInstanceId() {
    }

    default public void setInstanceId(int n) {
    }

    default public boolean isCompositeSelection() {
    }

    default public void setCompositeSelection(boolean bl) {
    }

    default public int getSelectionScope() {
    }

    default public void setSelectionScope(int n) {
    }

    default public List getSelectionPath() {
    }

    default public boolean isRecursive() {
    }

    default public void setRecursive(boolean bl) {
    }

    default public boolean isSelected() {
    }

    default public void setSelected(boolean bl) {
    }

    default public int getSelectionResult() {
    }

    default public void setSelectionResult(int n) {
    }

    default public int getSelectionState() {
    }

    default public void setSelectionState(int n) {
    }

    default public long getSizeAvailable() {
    }

    default public void setSizeAvailable(long l) {
    }

    default public long getSizeSelected() {
    }

    default public void setSizeSelected(long l) {
    }

    default public long getEntriesAvailable() {
    }

    default public void setEntriesAvailable(long l) {
    }

    default public long getEntriesSelected() {
    }

    default public void setEntriesSelected(long l) {
    }
}

