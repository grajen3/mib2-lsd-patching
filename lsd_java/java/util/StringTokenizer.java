/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class StringTokenizer
implements Enumeration {
    private final String string;
    private String delimiters;
    private final boolean returnDelimiters;
    private int position;

    public StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
    }

    public StringTokenizer(String string, String string2) {
        this(string, string2, false);
    }

    public StringTokenizer(String string, String string2, boolean bl) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.string = string;
        this.delimiters = string2;
        this.returnDelimiters = bl;
        this.position = 0;
    }

    public int countTokens() {
        int n = 0;
        boolean bl = false;
        int n2 = this.position;
        int n3 = this.string.length();
        while (n2 < n3) {
            if (this.delimiters.indexOf(this.string.charAt(n2), 0) >= 0) {
                if (this.returnDelimiters) {
                    ++n;
                }
                if (bl) {
                    ++n;
                    bl = false;
                }
            } else {
                bl = true;
            }
            ++n2;
        }
        if (bl) {
            ++n;
        }
        return n;
    }

    @Override
    public boolean hasMoreElements() {
        return this.hasMoreTokens();
    }

    public boolean hasMoreTokens() {
        int n = this.string.length();
        if (this.position < n) {
            if (this.returnDelimiters) {
                return true;
            }
            int n2 = this.position;
            while (n2 < n) {
                if (this.delimiters.indexOf(this.string.charAt(n2), 0) == -1) {
                    return true;
                }
                ++n2;
            }
        }
        return false;
    }

    @Override
    public Object nextElement() {
        return this.nextToken();
    }

    /*
     * Unable to fully structure code
     */
    public String nextToken() {
        block7: {
            var1_1 = this.position;
            var2_2 = this.string.length();
            if (var1_1 >= var2_2) break block7;
            if (!this.returnDelimiters) ** GOTO lbl15
            if (this.delimiters.indexOf(this.string.charAt(this.position), 0) >= 0) {
                return String.valueOf(this.string.charAt(this.position++));
            }
            ++this.position;
            while (this.position < var2_2) {
                if (this.delimiters.indexOf(this.string.charAt(this.position), 0) >= 0) {
                    return this.string.substring(var1_1, this.position);
                }
                ++this.position;
            }
            return this.string.substring(var1_1);
lbl-1000:
            // 1 sources

            {
                ++var1_1;
lbl15:
                // 2 sources

                ** while (var1_1 < var2_2 && this.delimiters.indexOf((int)this.string.charAt((int)var1_1), (int)0) >= 0)
            }
lbl16:
            // 1 sources

            this.position = var1_1;
            if (var1_1 < var2_2) {
                ++this.position;
                while (this.position < var2_2) {
                    if (this.delimiters.indexOf(this.string.charAt(this.position), 0) >= 0) {
                        return this.string.substring(var1_1, this.position);
                    }
                    ++this.position;
                }
                return this.string.substring(var1_1);
            }
        }
        throw new NoSuchElementException();
    }

    public String nextToken(String string) {
        this.delimiters = string;
        return this.nextToken();
    }
}

