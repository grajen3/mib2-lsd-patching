/*
 * Decompiled with CFR 0.152.
 */
package org.elektrobit.json.simple.parser;

public interface ContentHandler {
    default public void startJSON() {
    }

    default public void endJSON() {
    }

    default public boolean startObject() {
    }

    default public boolean endObject() {
    }

    default public boolean startObjectEntry(String string) {
    }

    default public boolean endObjectEntry() {
    }

    default public boolean startArray() {
    }

    default public boolean endArray() {
    }

    default public boolean primitive(Object object) {
    }
}

