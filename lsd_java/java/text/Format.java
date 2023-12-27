/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.Serializable;
import java.security.AccessController;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Format
implements Serializable,
Cloneable {
    private static final long serialVersionUID;

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    static ResourceBundle getBundle(Locale locale) {
        return (ResourceBundle)AccessController.doPrivileged(new PriviAction("com.ibm.oti.locale.Locale", locale));
    }

    static ResourceBundle getCollationBundle(Locale locale) {
        return (ResourceBundle)AccessController.doPrivileged(new PriviAction("com.ibm.oti.locale.Collation", locale));
    }

    String convertPattern(String string, String string2, String string3, boolean bl) {
        if (!bl && string2.equals(string3)) {
            return string;
        }
        boolean bl2 = false;
        StringBuffer stringBuffer = new StringBuffer();
        int n = string.length();
        int n2 = 0;
        while (n2 < n) {
            int n3;
            char c2 = string.charAt(n2);
            if (c2 == '\'') {
                boolean bl3 = bl2 = !bl2;
            }
            if (!bl2 && (n3 = string2.indexOf(c2)) != -1) {
                stringBuffer.append(string3.charAt(n3));
            } else {
                if (bl && !bl2 && (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z')) {
                    throw new IllegalArgumentException(Msg.getString("K001c", String.valueOf(c2), string));
                }
                stringBuffer.append(c2);
            }
            ++n2;
        }
        if (bl2) {
            throw new IllegalArgumentException(Msg.getString("K0019"));
        }
        return stringBuffer.toString();
    }

    public final String format(Object object) {
        return this.format(object, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
    }

    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        return new AttributedString(this.format(object)).getIterator();
    }

    public Object parseObject(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        Object object = this.parseObject(string, parsePosition);
        if (parsePosition.getErrorIndex() != -1 || parsePosition.getIndex() == 0) {
            throw new ParseException(null, parsePosition.getErrorIndex());
        }
        return object;
    }

    public abstract Object parseObject(String string, ParsePosition parsePosition) {
    }

    static boolean upTo(String string, ParsePosition parsePosition, StringBuffer stringBuffer, char c2) {
        int n = parsePosition.getIndex();
        int n2 = string.length();
        boolean bl = false;
        boolean bl2 = false;
        while (n < n2) {
            char c3;
            if ((c3 = string.charAt(n++)) == '\'') {
                if (bl) {
                    stringBuffer.append('\'');
                }
                bl2 = !bl2;
                bl = true;
                continue;
            }
            if (c3 == c2 && !bl2) {
                parsePosition.setIndex(n);
                return true;
            }
            bl = false;
            stringBuffer.append(c3);
        }
        parsePosition.setIndex(n);
        return false;
    }

    static boolean upToWithQuotes(String string, ParsePosition parsePosition, StringBuffer stringBuffer, char c2, char c3) {
        int n = parsePosition.getIndex();
        int n2 = string.length();
        int n3 = 1;
        boolean bl = false;
        while (n < n2) {
            char c4;
            if ((c4 = string.charAt(n++)) == '\'') {
                boolean bl2 = bl = !bl;
            }
            if (!bl) {
                if (c4 == c2) {
                    --n3;
                }
                if (n3 == 0) {
                    parsePosition.setIndex(n);
                    return true;
                }
                if (c4 == c3) {
                    ++n3;
                }
            }
            stringBuffer.append(c4);
        }
        throw new IllegalArgumentException(Msg.getString("K0346"));
    }
}

