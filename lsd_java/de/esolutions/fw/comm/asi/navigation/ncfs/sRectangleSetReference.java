/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sOLRLocationReference;
import java.util.Arrays;

public class sRectangleSetReference {
    public sOLRLocationReference[] rectangle;

    public sOLRLocationReference[] getRectangle() {
        return this.rectangle;
    }

    public void setRectangle(sOLRLocationReference[] sOLRLocationReferenceArray) {
        this.rectangle = sOLRLocationReferenceArray;
    }

    public sRectangleSetReference() {
        this.rectangle = null;
    }

    public sRectangleSetReference(sOLRLocationReference[] sOLRLocationReferenceArray) {
        this.rectangle = sOLRLocationReferenceArray;
    }

    public String toString() {
        return new StringBuffer("sRectangleSetReference{").append("rectangle=").append("[").append(this.rectangle == null ? "null" : Arrays.asList(this.rectangle).toString()).append("]").append("}").toString();
    }
}

