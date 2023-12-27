/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.ParseException;
import java.text.PatternEntry;
import java.text.PatternEntry$Parser;
import java.util.ArrayList;

final class MergeCollation {
    ArrayList patterns = new ArrayList();
    private transient PatternEntry saveEntry = null;
    private transient PatternEntry lastEntry = null;
    private transient StringBuffer excess = new StringBuffer();
    private transient byte[] statusArray = new byte[8192];
    private final byte BITARRAYMASK;
    private final int BYTEPOWER;
    private final int BYTEMASK;

    public MergeCollation(String string) {
        this.BITARRAYMASK = 1;
        this.BYTEPOWER = 3;
        this.BYTEMASK = 7;
        int n = 0;
        while (n < this.statusArray.length) {
            this.statusArray[n] = 0;
            ++n;
        }
        this.setPattern(string);
    }

    public String getPattern() {
        return this.getPattern(true);
    }

    public String getPattern(boolean bl) {
        PatternEntry patternEntry;
        StringBuffer stringBuffer = new StringBuffer();
        PatternEntry patternEntry2 = null;
        ArrayList arrayList = null;
        int n = 0;
        while (n < this.patterns.size()) {
            patternEntry = (PatternEntry)this.patterns.get(n);
            if (patternEntry.extension.length() != 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(patternEntry);
            } else {
                if (arrayList != null) {
                    PatternEntry patternEntry3 = this.findLastWithNoExtension(n - 1);
                    int n2 = arrayList.size() - 1;
                    while (n2 >= 0) {
                        patternEntry2 = (PatternEntry)arrayList.get(n2);
                        patternEntry2.addToBuffer(stringBuffer, false, bl, patternEntry3);
                        --n2;
                    }
                    arrayList = null;
                }
                patternEntry.addToBuffer(stringBuffer, false, bl, null);
            }
            ++n;
        }
        if (arrayList != null) {
            patternEntry = this.findLastWithNoExtension(n - 1);
            int n3 = arrayList.size() - 1;
            while (n3 >= 0) {
                patternEntry2 = (PatternEntry)arrayList.get(n3);
                patternEntry2.addToBuffer(stringBuffer, false, bl, patternEntry);
                --n3;
            }
            arrayList = null;
        }
        return stringBuffer.toString();
    }

    private final PatternEntry findLastWithNoExtension(int n) {
        --n;
        while (n >= 0) {
            PatternEntry patternEntry = (PatternEntry)this.patterns.get(n);
            if (patternEntry.extension.length() == 0) {
                return patternEntry;
            }
            --n;
        }
        return null;
    }

    public String emitPattern() {
        return this.emitPattern(true);
    }

    public String emitPattern(boolean bl) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < this.patterns.size()) {
            PatternEntry patternEntry = (PatternEntry)this.patterns.get(n);
            if (patternEntry != null) {
                patternEntry.addToBuffer(stringBuffer, true, bl, null);
            }
            ++n;
        }
        return stringBuffer.toString();
    }

    public void setPattern(String string) {
        this.patterns.clear();
        this.addPattern(string);
    }

    public void addPattern(String string) {
        if (string == null) {
            return;
        }
        PatternEntry$Parser patternEntry$Parser = new PatternEntry$Parser(string);
        PatternEntry patternEntry = patternEntry$Parser.next();
        while (patternEntry != null) {
            this.fixEntry(patternEntry);
            patternEntry = patternEntry$Parser.next();
        }
    }

    public int getCount() {
        return this.patterns.size();
    }

    public PatternEntry getItemAt(int n) {
        return (PatternEntry)this.patterns.get(n);
    }

    private final void fixEntry(PatternEntry patternEntry) {
        if (this.lastEntry != null && patternEntry.chars.equals(this.lastEntry.chars) && patternEntry.extension.equals(this.lastEntry.extension)) {
            if (patternEntry.strength != 3 && patternEntry.strength != -2) {
                throw new ParseException(Msg.getString("K01ac", this.lastEntry, patternEntry), -1);
            }
            return;
        }
        boolean bl = true;
        if (patternEntry.strength != -2) {
            int n;
            int n2 = -1;
            if (patternEntry.chars.length() == 1) {
                n = patternEntry.chars.charAt(0);
                int n3 = n >> 3;
                byte by = this.statusArray[n3];
                byte by2 = (byte)(1 << (n & 7));
                if (by != 0 && (by & by2) != 0) {
                    n2 = this.patterns.lastIndexOf(patternEntry);
                } else {
                    this.statusArray[n3] = (byte)(by | by2);
                }
            } else {
                n2 = this.patterns.lastIndexOf(patternEntry);
            }
            if (n2 != -1) {
                this.patterns.remove(n2);
            }
            this.excess.setLength(0);
            n = this.findLastEntry(this.lastEntry, this.excess);
            if (this.excess.length() != 0) {
                patternEntry.extension = new StringBuffer().append((Object)this.excess).append(patternEntry.extension).toString();
                if (n != this.patterns.size()) {
                    this.lastEntry = this.saveEntry;
                    bl = false;
                }
            }
            if (n == this.patterns.size()) {
                this.patterns.add(patternEntry);
                this.saveEntry = patternEntry;
            } else {
                this.patterns.add(n, patternEntry);
            }
        }
        if (bl) {
            this.lastEntry = patternEntry;
        }
    }

    private final int findLastEntry(PatternEntry patternEntry, StringBuffer stringBuffer) {
        if (patternEntry == null) {
            return 0;
        }
        if (patternEntry.strength != -2) {
            int n = -1;
            if (patternEntry.chars.length() == 1) {
                int n2 = patternEntry.chars.charAt(0) >> 3;
                if ((this.statusArray[n2] & 1 << (patternEntry.chars.charAt(0) & 7)) != 0) {
                    n = this.patterns.lastIndexOf(patternEntry);
                }
            } else {
                n = this.patterns.lastIndexOf(patternEntry);
            }
            if (n == -1) {
                throw new ParseException(Msg.getString("K01aa", patternEntry), n);
            }
            return n + 1;
        }
        int n = this.patterns.size() - 1;
        while (n >= 0) {
            PatternEntry patternEntry2 = (PatternEntry)this.patterns.get(n);
            if (patternEntry2.chars.regionMatches(0, patternEntry.chars, 0, patternEntry2.chars.length())) {
                stringBuffer.append(patternEntry.chars.substring(patternEntry2.chars.length(), patternEntry.chars.length()));
                break;
            }
            --n;
        }
        if (n == -1) {
            throw new ParseException(Msg.getString("K01ab", patternEntry), n);
        }
        return n + 1;
    }
}

