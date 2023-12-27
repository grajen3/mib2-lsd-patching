/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.ParseException;
import java.text.PatternEntry;

class PatternEntry$Parser {
    private String pattern;
    private int i;
    private StringBuffer newChars = new StringBuffer();
    private StringBuffer newExtension = new StringBuffer();

    public PatternEntry$Parser(String string) {
        this.pattern = string;
        this.i = 0;
    }

    public PatternEntry next() {
        int n = -1;
        this.newChars.setLength(0);
        this.newExtension.setLength(0);
        boolean bl = true;
        boolean bl2 = false;
        block10: while (this.i < this.pattern.length()) {
            char c2 = this.pattern.charAt(this.i);
            if (bl2) {
                if (c2 == '\'') {
                    bl2 = false;
                } else if (this.newChars.length() == 0) {
                    this.newChars.append(c2);
                } else if (bl) {
                    this.newChars.append(c2);
                } else {
                    this.newExtension.append(c2);
                }
            } else {
                switch (c2) {
                    case '=': {
                        if (n != -1) break block10;
                        n = 3;
                        break;
                    }
                    case ',': {
                        if (n != -1) break block10;
                        n = 2;
                        break;
                    }
                    case ';': {
                        if (n != -1) break block10;
                        n = 1;
                        break;
                    }
                    case '<': {
                        if (n != -1) break block10;
                        n = 0;
                        break;
                    }
                    case '&': {
                        if (n != -1) break block10;
                        n = -2;
                        break;
                    }
                    case '\t': 
                    case '\n': 
                    case '\f': 
                    case '\r': 
                    case ' ': {
                        break;
                    }
                    case '/': {
                        bl = false;
                        break;
                    }
                    case '\'': {
                        bl2 = true;
                        c2 = this.pattern.charAt(++this.i);
                        if (this.newChars.length() == 0) {
                            this.newChars.append(c2);
                            break;
                        }
                        if (bl) {
                            this.newChars.append(c2);
                            break;
                        }
                        this.newExtension.append(c2);
                        break;
                    }
                    default: {
                        if (n == -1) {
                            throw new ParseException(Msg.getString("K01ae", this.pattern.substring(this.i, this.i + 10 < this.pattern.length() ? this.i + 10 : this.pattern.length())), this.i);
                        }
                        if (PatternEntry.isSpecialChar(c2) && !bl2) {
                            throw new ParseException(Msg.getString("K01af", Integer.toString(c2, 16)), this.i);
                        }
                        if (bl) {
                            this.newChars.append(c2);
                            break;
                        }
                        this.newExtension.append(c2);
                    }
                }
            }
            ++this.i;
        }
        if (n == -1) {
            return null;
        }
        if (this.newChars.length() == 0) {
            throw new ParseException(Msg.getString("K01ae", this.pattern.substring(this.i, this.i + 10 < this.pattern.length() ? this.i + 10 : this.pattern.length())), this.i);
        }
        return new PatternEntry(n, this.newChars, this.newExtension);
    }
}

