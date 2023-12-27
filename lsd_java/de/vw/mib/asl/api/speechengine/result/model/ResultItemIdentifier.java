/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.model;

public interface ResultItemIdentifier {
    default public int getId() {
    }

    default public long getObjectId() {
    }

    default public int getObjectIndex() {
    }

    default public String getObjectStringId() {
    }

    default public String getRecognizedString() {
    }

    default public int compareTo(ResultItemIdentifier resultItemIdentifier) {
    }
}

