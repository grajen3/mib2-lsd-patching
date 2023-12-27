/*
 * Decompiled with CFR 0.152.
 */
package java.text;

class PatternEntry {
    static final int RESET;
    static final int UNSET;
    int strength = -1;
    String chars = "";
    String extension = "";

    public void appendQuotedExtension(StringBuffer stringBuffer) {
        PatternEntry.appendQuoted(this.extension, stringBuffer);
    }

    public void appendQuotedChars(StringBuffer stringBuffer) {
        PatternEntry.appendQuoted(this.chars, stringBuffer);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        PatternEntry patternEntry = (PatternEntry)object;
        boolean bl = this.chars.equals(patternEntry.chars);
        return bl;
    }

    public int hashCode() {
        return this.chars.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        this.addToBuffer(stringBuffer, true, false, null);
        return stringBuffer.toString();
    }

    final int getStrength() {
        return this.strength;
    }

    final String getExtension() {
        return this.extension;
    }

    final String getChars() {
        return this.chars;
    }

    void addToBuffer(StringBuffer stringBuffer, boolean bl, boolean bl2, PatternEntry patternEntry) {
        if (bl2 && stringBuffer.length() > 0) {
            if (this.strength == 0 || patternEntry != null) {
                stringBuffer.append('\n');
            } else {
                stringBuffer.append(' ');
            }
        }
        if (patternEntry != null) {
            stringBuffer.append('&');
            if (bl2) {
                stringBuffer.append(' ');
            }
            patternEntry.appendQuotedChars(stringBuffer);
            this.appendQuotedExtension(stringBuffer);
            if (bl2) {
                stringBuffer.append(' ');
            }
        }
        switch (this.strength) {
            case 3: {
                stringBuffer.append('=');
                break;
            }
            case 2: {
                stringBuffer.append(',');
                break;
            }
            case 1: {
                stringBuffer.append(';');
                break;
            }
            case 0: {
                stringBuffer.append('<');
                break;
            }
            case -2: {
                stringBuffer.append('&');
                break;
            }
            case -1: {
                stringBuffer.append('?');
            }
        }
        if (bl2) {
            stringBuffer.append(' ');
        }
        PatternEntry.appendQuoted(this.chars, stringBuffer);
        if (bl && this.extension.length() != 0) {
            stringBuffer.append('/');
            PatternEntry.appendQuoted(this.extension, stringBuffer);
        }
    }

    static void appendQuoted(String string, StringBuffer stringBuffer) {
        boolean bl = false;
        char c2 = string.charAt(0);
        if (Character.isSpaceChar(c2)) {
            bl = true;
            stringBuffer.append('\'');
        } else if (PatternEntry.isSpecialChar(c2)) {
            bl = true;
            stringBuffer.append('\'');
        } else {
            switch (c2) {
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case '\u0010': 
                case '@': {
                    bl = true;
                    stringBuffer.append('\'');
                    break;
                }
                case '\'': {
                    bl = true;
                    stringBuffer.append('\'');
                    break;
                }
                default: {
                    if (!bl) break;
                    bl = false;
                    stringBuffer.append('\'');
                }
            }
        }
        stringBuffer.append(string);
        if (bl) {
            stringBuffer.append('\'');
        }
    }

    PatternEntry(int n, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        this.strength = n;
        this.chars = stringBuffer.toString();
        this.extension = stringBuffer2.length() > 0 ? stringBuffer2.toString() : "";
    }

    static boolean isSpecialChar(char c2) {
        return c2 == ' ' || c2 <= '/' && c2 >= '\"' || c2 <= '?' && c2 >= ':' || c2 <= '`' && c2 >= '[' || c2 <= '~' && c2 >= '{';
    }
}

