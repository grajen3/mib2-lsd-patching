/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.writer;

import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigDictionary;

public interface IConfigExporter {
    default public void beginDictionary(ConfigDictionary configDictionary, int n) {
    }

    default public void endDictionary() {
    }

    default public void beginArray(ConfigArray configArray, int n) {
    }

    default public void endArray() {
    }

    default public void beginDictEntry(int n, String string) {
    }

    default public void endDictEntry(boolean bl) {
    }

    default public void beginArrayEntry(int n) {
    }

    default public void endArrayEntry(boolean bl) {
    }

    default public void writeString(String string) {
    }

    default public void writeInteger(int n) {
    }

    default public void writeDouble(double d2) {
    }

    default public void writeNull() {
    }

    default public void writeBoolean(boolean bl) {
    }
}

