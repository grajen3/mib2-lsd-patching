/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class OIDDatabase$DBEntry {
    private List equivalents = new LinkedList();
    private String value;

    OIDDatabase$DBEntry(String string) {
        this.value = string;
    }

    void addEquivalent(OIDDatabase$DBEntry oIDDatabase$DBEntry) {
        this.equivalents.add(oIDDatabase$DBEntry);
    }

    String getValue() {
        return this.value;
    }

    Set getAllEquivalents() {
        return new HashSet(this.equivalents);
    }
}

