/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

public class Grammar {
    public int grammarType;
    public int commandHierarchy;
    public boolean publicGrammar;
    public String[] listData;
    public long[] listIdData;
    public int listSourceId;
    public int grammarId;
    public String grammarText;
    public int nBestGraphemicGroupIndex;
    public int nBestListID;

    public Grammar() {
        this.grammarType = 1;
        this.commandHierarchy = -1;
        this.publicGrammar = true;
        this.listData = null;
        this.listIdData = null;
        this.listSourceId = -1;
        this.grammarId = -1;
        this.grammarText = "";
        this.nBestGraphemicGroupIndex = 0;
        this.nBestListID = -1;
    }

    public Grammar(int n, int n2, boolean bl, String[] stringArray, long[] lArray, int n3, int n4, String string, int n5, int n6) {
        this.grammarType = n;
        this.commandHierarchy = n2;
        this.publicGrammar = bl;
        this.listData = stringArray;
        this.listIdData = lArray;
        this.listSourceId = n3;
        this.grammarId = n4;
        this.grammarText = string;
        this.nBestGraphemicGroupIndex = n5;
        this.nBestListID = n6;
    }

    public int getCommandHierarchy() {
        return this.commandHierarchy;
    }

    public boolean isPublicGrammar() {
        return this.publicGrammar;
    }

    public String[] getListData() {
        return this.listData;
    }

    public int getListSourceId() {
        return this.listSourceId;
    }

    public int getGrammarId() {
        return this.grammarId;
    }

    public String getGrammarText() {
        return this.grammarText;
    }

    public int getGrammarType() {
        return this.grammarType;
    }

    public long[] getListIdData() {
        return this.listIdData;
    }

    public int getNBestGraphemicGroupIndex() {
        return this.nBestGraphemicGroupIndex;
    }

    public int getNBestListID() {
        return this.nBestListID;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("Grammar");
        stringBuffer.append('(');
        stringBuffer.append("grammarType");
        stringBuffer.append('=');
        stringBuffer.append(this.grammarType);
        stringBuffer.append(',');
        stringBuffer.append("commandHierarchy");
        stringBuffer.append('=');
        stringBuffer.append(this.commandHierarchy);
        stringBuffer.append(',');
        stringBuffer.append("publicGrammar");
        stringBuffer.append('=');
        stringBuffer.append(this.publicGrammar);
        stringBuffer.append(',');
        stringBuffer.append("listData");
        stringBuffer.append('[');
        if (this.listData != null) {
            stringBuffer.append(this.listData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.listData != null) {
            n3 = this.listData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.listData[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.listData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("listIdData");
        stringBuffer.append('[');
        if (this.listIdData != null) {
            stringBuffer.append(this.listIdData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.listIdData != null) {
            n3 = this.listIdData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.listIdData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.listIdData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("listSourceId");
        stringBuffer.append('=');
        stringBuffer.append(this.listSourceId);
        stringBuffer.append(',');
        stringBuffer.append("grammarId");
        stringBuffer.append('=');
        stringBuffer.append(this.grammarId);
        stringBuffer.append(',');
        stringBuffer.append("grammarText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.grammarText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("nBestGraphemicGroupIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.nBestGraphemicGroupIndex);
        stringBuffer.append(',');
        stringBuffer.append("nBestListID");
        stringBuffer.append('=');
        stringBuffer.append(this.nBestListID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

