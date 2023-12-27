/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestListEntry;

public class NBestList {
    public GraphemicGroup[] graphemicGroups;
    public NBestListEntry[] entries;
    public int nBestListID;

    public NBestList() {
        this.graphemicGroups = null;
        this.entries = null;
        this.nBestListID = -1;
    }

    public NBestList(GraphemicGroup[] graphemicGroupArray, NBestListEntry[] nBestListEntryArray, int n) {
        this.graphemicGroups = graphemicGroupArray;
        this.entries = nBestListEntryArray;
        this.nBestListID = n;
    }

    public GraphemicGroup[] getGraphemicGroups() {
        return this.graphemicGroups;
    }

    public NBestListEntry[] getEntries() {
        return this.entries;
    }

    public int getNBestListID() {
        return this.nBestListID;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("NBestList");
        stringBuffer.append('(');
        stringBuffer.append("graphemicGroups");
        stringBuffer.append('[');
        if (this.graphemicGroups != null) {
            stringBuffer.append(this.graphemicGroups.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.graphemicGroups != null) {
            n3 = this.graphemicGroups.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.graphemicGroups[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.graphemicGroups);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("entries");
        stringBuffer.append('[');
        if (this.entries != null) {
            stringBuffer.append(this.entries.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.entries != null) {
            n3 = this.entries.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.entries[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.entries);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("nBestListID");
        stringBuffer.append('=');
        stringBuffer.append(this.nBestListID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

