/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class DictationValueSentenceElement {
    public String[] words;

    public DictationValueSentenceElement() {
        this.words = null;
    }

    public DictationValueSentenceElement(String[] stringArray) {
        this.words = stringArray;
    }

    public String[] getWords() {
        return this.words;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("DictationValueSentenceElement");
        stringBuffer.append('(');
        stringBuffer.append("words");
        stringBuffer.append('[');
        if (this.words != null) {
            stringBuffer.append(this.words.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.words != null) {
            int n = this.words.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.words[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.words);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

