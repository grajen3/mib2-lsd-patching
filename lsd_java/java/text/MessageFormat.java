/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.text.AttributedCharacterIterator;
import java.text.AttributedCharacterIterator$Attribute;
import java.text.AttributedString;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat$Field;
import java.text.MessageFormat$FieldContainer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

public class MessageFormat
extends Format {
    private static final long serialVersionUID;
    private Locale locale = Locale.getDefault();
    private transient String[] strings;
    private int[] argumentNumbers;
    private Format[] formats;
    private int maxOffset;
    private transient int maxArgumentIndex;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;
    static /* synthetic */ Class class$3;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[6];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("[I");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("argumentNumbers", clazz);
        Class clazz2 = class$1;
        if (clazz2 == null) {
            try {
                clazz2 = class$1 = Class.forName("[Ljava.text.Format;");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[1] = new ObjectStreamField("formats", clazz2);
        Class clazz3 = class$2;
        if (clazz3 == null) {
            try {
                clazz3 = class$2 = Class.forName("java.util.Locale");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[2] = new ObjectStreamField("locale", clazz3);
        objectStreamFieldArray[3] = new ObjectStreamField("maxOffset", Integer.TYPE);
        Class clazz4 = class$0;
        if (clazz4 == null) {
            try {
                clazz4 = class$0 = Class.forName("[I");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[4] = new ObjectStreamField("offsets", clazz4);
        Class clazz5 = class$3;
        if (clazz5 == null) {
            try {
                clazz5 = class$3 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[5] = new ObjectStreamField("pattern", clazz5);
        serialPersistentFields = objectStreamFieldArray;
    }

    public MessageFormat(String string, Locale locale) {
        this.locale = locale;
        this.applyPattern(string);
    }

    public MessageFormat(String string) {
        this.applyPattern(string);
    }

    public void applyPattern(String string) {
        int n;
        int n2 = string.length();
        StringBuffer stringBuffer = new StringBuffer();
        ParsePosition parsePosition = new ParsePosition(0);
        Vector vector = new Vector();
        int n3 = 0;
        int[] nArray = new int[10];
        int n4 = -1;
        Vector vector2 = new Vector();
        while (parsePosition.getIndex() < n2) {
            block8: {
                int n5;
                block10: {
                    block9: {
                        if (!Format.upTo(string, parsePosition, stringBuffer, '{')) break block8;
                        n5 = parsePosition.getIndex();
                        if (n5 >= n2) break block9;
                        byte by = (byte)Character.digit(string.charAt(n5++), 10);
                        n = by;
                        if (by != -1) break block10;
                    }
                    throw new IllegalArgumentException(Msg.getString("K001d"));
                }
                parsePosition.setIndex(n5);
                vector2.addElement(this.parseVariable(string, parsePosition));
                if (n3 >= nArray.length) {
                    int[] nArray2 = new int[nArray.length * 2];
                    System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, nArray.length);
                    nArray = nArray2;
                }
                nArray[n3++] = n;
                if (n > n4) {
                    n4 = n;
                }
            }
            vector.addElement(stringBuffer.toString());
            stringBuffer.setLength(0);
        }
        this.strings = new String[vector.size()];
        n = 0;
        while (n < vector.size()) {
            this.strings[n] = (String)vector.elementAt(n);
            ++n;
        }
        this.argumentNumbers = nArray;
        this.formats = new Format[n3];
        n = 0;
        while (n < n3) {
            this.formats[n] = (Format)vector2.elementAt(n);
            ++n;
        }
        this.maxOffset = n3 - 1;
        this.maxArgumentIndex = n4;
    }

    @Override
    public Object clone() {
        MessageFormat messageFormat = (MessageFormat)super.clone();
        Format[] formatArray = new Format[this.formats.length];
        int n = this.formats.length;
        while (--n >= 0) {
            if (this.formats[n] == null) continue;
            formatArray[n] = (Format)this.formats[n].clone();
        }
        messageFormat.formats = formatArray;
        return messageFormat;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MessageFormat)) {
            return false;
        }
        MessageFormat messageFormat = (MessageFormat)object;
        if (this.maxOffset != messageFormat.maxOffset) {
            return false;
        }
        int n = 0;
        while (n <= this.maxOffset) {
            if (this.argumentNumbers[n] != messageFormat.argumentNumbers[n]) {
                return false;
            }
            ++n;
        }
        return this.locale.equals(messageFormat.locale) && Arrays.equals(this.strings, messageFormat.strings) && Arrays.equals(this.formats, messageFormat.formats);
    }

    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        this.formatImpl((Object[])object, stringBuffer, new FieldPosition(0), vector);
        AttributedString attributedString = new AttributedString(stringBuffer.toString());
        int n = 0;
        while (n < vector.size()) {
            MessageFormat$FieldContainer messageFormat$FieldContainer = (MessageFormat$FieldContainer)vector.elementAt(n);
            attributedString.addAttribute(messageFormat$FieldContainer.attribute, messageFormat$FieldContainer.value, messageFormat$FieldContainer.start, messageFormat$FieldContainer.end);
            ++n;
        }
        return attributedString.getIterator();
    }

    public final StringBuffer format(Object[] objectArray, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.formatImpl(objectArray, stringBuffer, fieldPosition, null);
    }

    /*
     * Unable to fully structure code
     */
    private StringBuffer formatImpl(Object[] var1_1, StringBuffer var2_2, FieldPosition var3_3, Vector var4_4) {
        var5_5 = new FieldPosition(0);
        var6_6 = 0;
        while (var6_6 <= this.maxOffset) {
            block7: {
                block8: {
                    block6: {
                        var2_2.append(this.strings[var6_6]);
                        var7_7 = var2_2.length();
                        if (var1_1 != null && this.argumentNumbers[var6_6] < var1_1.length) break block6;
                        var2_2.append('{');
                        var2_2.append(this.argumentNumbers[var6_6]);
                        var2_2.append('}');
                        this.handleArgumentField(var7_7, var2_2.length(), this.argumentNumbers[var6_6], var3_3, var4_4);
                        break block7;
                    }
                    var8_8 = var1_1[this.argumentNumbers[var6_6]];
                    var9_9 = this.formats[var6_6];
                    if (var9_9 != null && var8_8 != null) ** GOTO lbl30
                    if (!(var8_8 instanceof Number)) break block8;
                    var9_9 = NumberFormat.getInstance();
                    ** GOTO lbl30
                }
                if (!(var8_8 instanceof Date)) {
                    var2_2.append(var8_8);
                    this.handleArgumentField(var7_7, var2_2.length(), this.argumentNumbers[var6_6], var3_3, var4_4);
                } else {
                    var9_9 = DateFormat.getInstance();
lbl30:
                    // 3 sources

                    if (var9_9 instanceof ChoiceFormat) {
                        var10_10 = var9_9.format(var8_8);
                        var11_11 = new MessageFormat(var10_10);
                        var11_11.setLocale(this.locale);
                        var11_11.format(var1_1, var2_2, var5_5);
                        this.handleArgumentField(var7_7, var2_2.length(), this.argumentNumbers[var6_6], var3_3, var4_4);
                        this.handleformat(var9_9, var8_8, var7_7, var4_4);
                    } else {
                        var9_9.format(var8_8, var2_2, var5_5);
                        this.handleArgumentField(var7_7, var2_2.length(), this.argumentNumbers[var6_6], var3_3, var4_4);
                        this.handleformat(var9_9, var8_8, var7_7, var4_4);
                    }
                }
            }
            ++var6_6;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            var2_2.append(this.strings[this.maxOffset + 1]);
        }
        return var2_2;
    }

    private void handleArgumentField(int n, int n2, int n3, FieldPosition fieldPosition, Vector vector) {
        if (vector != null) {
            vector.add(new MessageFormat$FieldContainer(n, n2, MessageFormat$Field.ARGUMENT, new Integer(n3)));
        } else if (fieldPosition != null && fieldPosition.getFieldAttribute() == MessageFormat$Field.ARGUMENT && fieldPosition.getEndIndex() == 0) {
            fieldPosition.setBeginIndex(n);
            fieldPosition.setEndIndex(n2);
        }
    }

    private void handleformat(Format format, Object object, int n, Vector vector) {
        if (vector != null) {
            AttributedCharacterIterator attributedCharacterIterator = format.formatToCharacterIterator(object);
            while (attributedCharacterIterator.getIndex() != attributedCharacterIterator.getEndIndex()) {
                int n2 = attributedCharacterIterator.getRunStart();
                int n3 = attributedCharacterIterator.getRunLimit();
                Iterator iterator = attributedCharacterIterator.getAttributes().keySet().iterator();
                while (iterator.hasNext()) {
                    AttributedCharacterIterator$Attribute attributedCharacterIterator$Attribute = (AttributedCharacterIterator$Attribute)iterator.next();
                    Object object2 = attributedCharacterIterator.getAttribute(attributedCharacterIterator$Attribute);
                    vector.add(new MessageFormat$FieldContainer(n + n2, n + n3, attributedCharacterIterator$Attribute, object2));
                }
                attributedCharacterIterator.setIndex(n3);
            }
        }
    }

    @Override
    public final StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format((Object[])object, stringBuffer, fieldPosition);
    }

    public static String format(String string, Object[] objectArray) {
        return new MessageFormat(string).format(objectArray);
    }

    public Format[] getFormats() {
        return (Format[])this.formats.clone();
    }

    public Format[] getFormatsByArgumentIndex() {
        Format[] formatArray = new Format[this.maxArgumentIndex + 1];
        int n = 0;
        while (n < this.maxOffset + 1) {
            formatArray[this.argumentNumbers[n]] = this.formats[n];
            ++n;
        }
        return formatArray;
    }

    public void setFormatByArgumentIndex(int n, Format format) {
        int n2 = 0;
        while (n2 < this.maxOffset + 1) {
            if (this.argumentNumbers[n2] == n) {
                this.formats[n2] = format;
            }
            ++n2;
        }
    }

    public void setFormatsByArgumentIndex(Format[] formatArray) {
        int n = 0;
        while (n < formatArray.length) {
            int n2 = 0;
            while (n2 < this.maxOffset + 1) {
                if (this.argumentNumbers[n2] == n) {
                    this.formats[n2] = formatArray[n];
                }
                ++n2;
            }
            ++n;
        }
    }

    public Locale getLocale() {
        return this.locale;
    }

    public int hashCode() {
        int n = 0;
        int n2 = 0;
        while (n2 <= this.maxOffset) {
            n += this.argumentNumbers[n2] + this.strings[n2].hashCode();
            if (this.formats[n2] != null) {
                n += this.formats[n2].hashCode();
            }
            ++n2;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            n += this.strings[this.maxOffset + 1].hashCode();
        }
        return n + this.locale.hashCode();
    }

    public Object[] parse(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        Object[] objectArray = this.parse(string, parsePosition);
        if (parsePosition.getErrorIndex() != -1 || parsePosition.getIndex() == 0) {
            throw new ParseException(null, parsePosition.getErrorIndex());
        }
        return objectArray;
    }

    public Object[] parse(String string, ParsePosition parsePosition) {
        if (string == null) {
            return new Object[0];
        }
        ParsePosition parsePosition2 = new ParsePosition(0);
        int n = parsePosition.getIndex();
        Object[] objectArray = new Object[this.maxArgumentIndex + 1];
        int n2 = 0;
        while (n2 <= this.maxOffset) {
            Object object;
            String string2 = this.strings[n2];
            if (!string.startsWith(string2, n)) {
                parsePosition.setErrorIndex(n);
                return null;
            }
            n += string2.length();
            Format format = this.formats[n2];
            if (format == null) {
                if (n2 + 1 < this.strings.length) {
                    int n3 = string.indexOf(this.strings[n2 + 1], n);
                    if (n3 == -1) {
                        parsePosition.setErrorIndex(n);
                        return null;
                    }
                    object = string.substring(n, n3);
                    n = n3;
                } else {
                    object = string.substring(n);
                    n = string.length();
                }
            } else {
                parsePosition2.setIndex(n);
                object = format.parseObject(string, parsePosition2);
                if (parsePosition2.getErrorIndex() != -1) {
                    parsePosition.setErrorIndex(n);
                    return null;
                }
                n = parsePosition2.getIndex();
            }
            objectArray[this.argumentNumbers[n2]] = object;
            ++n2;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            String string3 = this.strings[this.maxOffset + 1];
            if (!string.startsWith(string3, n)) {
                parsePosition.setErrorIndex(n);
                return null;
            }
            n += string3.length();
        }
        parsePosition.setIndex(n);
        return objectArray;
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        return this.parse(string, parsePosition);
    }

    private int match(String string, ParsePosition parsePosition, boolean bl, String[] stringArray) {
        int n = string.length();
        int n2 = parsePosition.getIndex();
        int n3 = -1;
        while (n2 < n && Character.isWhitespace(string.charAt(n2))) {
            ++n2;
        }
        int n4 = stringArray.length;
        while (--n4 >= 0) {
            if (!string.regionMatches(true, n2, stringArray[n4], 0, stringArray[n4].length())) continue;
            n3 = n4;
            break;
        }
        if (n3 == -1) {
            return -1;
        }
        n2 += stringArray[n3].length();
        while (n2 < n && Character.isWhitespace(string.charAt(n2))) {
            ++n2;
        }
        if (n2 < n) {
            char c2 = string.charAt(n2);
            n4 = c2;
            if (c2 == '}' || !bl && n4 == 44) {
                parsePosition.setIndex(n2 + 1);
                return n3;
            }
        }
        return -1;
    }

    private Format parseVariable(String string, ParsePosition parsePosition) {
        char c2;
        int n = string.length();
        int n2 = parsePosition.getIndex();
        if (n2 >= n || (c2 = string.charAt(n2++)) != '}' && c2 != ',') {
            throw new IllegalArgumentException(Msg.getString("K001e"));
        }
        parsePosition.setIndex(n2);
        if (c2 == '}') {
            return null;
        }
        int n3 = this.match(string, parsePosition, false, new String[]{"time", "date", "number", "choice"});
        if (n3 == -1) {
            throw new IllegalArgumentException(Msg.getString("K001f"));
        }
        StringBuffer stringBuffer = new StringBuffer();
        c2 = string.charAt(parsePosition.getIndex() - 1);
        switch (n3) {
            case 0: 
            case 1: {
                if (c2 == '}') {
                    return n3 == 1 ? DateFormat.getDateInstance(2, this.locale) : DateFormat.getTimeInstance(2, this.locale);
                }
                int n4 = this.match(string, parsePosition, true, new String[]{"full", "long", "medium", "short"});
                if (n4 == -1) {
                    Format.upToWithQuotes(string, parsePosition, stringBuffer, '}', '{');
                    return new SimpleDateFormat(stringBuffer.toString(), this.locale);
                }
                switch (n4) {
                    case 0: {
                        n4 = 0;
                        break;
                    }
                    case 1: {
                        n4 = 1;
                        break;
                    }
                    case 2: {
                        n4 = 2;
                        break;
                    }
                    case 3: {
                        n4 = 3;
                    }
                }
                return n3 == 1 ? DateFormat.getDateInstance(n4, this.locale) : DateFormat.getTimeInstance(n4, this.locale);
            }
            case 2: {
                if (c2 == '}') {
                    return NumberFormat.getInstance();
                }
                int n5 = this.match(string, parsePosition, true, new String[]{"currency", "percent", "integer"});
                if (n5 == -1) {
                    Format.upToWithQuotes(string, parsePosition, stringBuffer, '}', '{');
                    return new DecimalFormat(stringBuffer.toString(), new DecimalFormatSymbols(this.locale));
                }
                switch (n5) {
                    case 0: {
                        return NumberFormat.getCurrencyInstance(this.locale);
                    }
                    case 1: {
                        return NumberFormat.getPercentInstance(this.locale);
                    }
                }
                return NumberFormat.getIntegerInstance(this.locale);
            }
        }
        try {
            Format.upToWithQuotes(string, parsePosition, stringBuffer, '}', '{');
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        return new ChoiceFormat(stringBuffer.toString());
    }

    public void setFormat(int n, Format format) {
        this.formats[n] = format;
    }

    public void setFormats(Format[] formatArray) {
        int n = this.formats.length;
        if (formatArray.length < n) {
            n = formatArray.length;
        }
        int n2 = 0;
        while (n2 < n) {
            this.formats[n2] = formatArray[n2];
            ++n2;
        }
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        int n = 0;
        while (n <= this.maxOffset) {
            Format format = this.formats[n];
            if (format instanceof DecimalFormat) {
                this.formats[n] = new DecimalFormat(((DecimalFormat)format).toPattern(), new DecimalFormatSymbols(locale));
            } else if (format instanceof SimpleDateFormat) {
                this.formats[n] = new SimpleDateFormat(((SimpleDateFormat)format).toPattern(), locale);
            }
            ++n;
        }
    }

    private String decodeDecimalFormat(StringBuffer stringBuffer, Format format) {
        stringBuffer.append(",number");
        if (!format.equals(NumberFormat.getNumberInstance(this.locale))) {
            if (format.equals(NumberFormat.getIntegerInstance(this.locale))) {
                stringBuffer.append(",integer");
            } else if (format.equals(NumberFormat.getCurrencyInstance(this.locale))) {
                stringBuffer.append(",currency");
            } else if (format.equals(NumberFormat.getPercentInstance(this.locale))) {
                stringBuffer.append(",percent");
            } else {
                stringBuffer.append(',');
                return ((DecimalFormat)format).toPattern();
            }
        }
        return null;
    }

    private String decodeSimpleDateFormat(StringBuffer stringBuffer, Format format) {
        if (format.equals(DateFormat.getTimeInstance(2, this.locale))) {
            stringBuffer.append(",time");
        } else if (format.equals(DateFormat.getDateInstance(2, this.locale))) {
            stringBuffer.append(",date");
        } else if (format.equals(DateFormat.getTimeInstance(3, this.locale))) {
            stringBuffer.append(",time,short");
        } else if (format.equals(DateFormat.getDateInstance(3, this.locale))) {
            stringBuffer.append(",date,short");
        } else if (format.equals(DateFormat.getTimeInstance(1, this.locale))) {
            stringBuffer.append(",time,long");
        } else if (format.equals(DateFormat.getDateInstance(1, this.locale))) {
            stringBuffer.append(",date,long");
        } else if (format.equals(DateFormat.getTimeInstance(0, this.locale))) {
            stringBuffer.append(",time,full");
        } else if (format.equals(DateFormat.getDateInstance(0, this.locale))) {
            stringBuffer.append(",date,full");
        } else {
            stringBuffer.append(",date,");
            return ((SimpleDateFormat)format).toPattern();
        }
        return null;
    }

    public String toPattern() {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n <= this.maxOffset) {
            this.appendQuoted(stringBuffer, this.strings[n]);
            stringBuffer.append('{');
            stringBuffer.append(this.argumentNumbers[n]);
            Format format = this.formats[n];
            String string = null;
            if (format instanceof ChoiceFormat) {
                stringBuffer.append(",choice,");
                string = ((ChoiceFormat)format).toPattern();
            } else if (format instanceof DecimalFormat) {
                string = this.decodeDecimalFormat(stringBuffer, format);
            } else if (format instanceof SimpleDateFormat) {
                string = this.decodeSimpleDateFormat(stringBuffer, format);
            } else if (format != null) {
                throw new IllegalArgumentException(Msg.getString("K0020"));
            }
            if (string != null) {
                boolean bl = false;
                int n2 = 0;
                int n3 = string.length();
                int n4 = 0;
                while (n2 < n3) {
                    int n5;
                    if ((n5 = string.charAt(n2++)) == 39) {
                        boolean bl2 = bl = !bl;
                    }
                    if (!bl) {
                        if (n5 == 123) {
                            ++n4;
                        }
                        if (n5 == 125) {
                            if (n4 > 0) {
                                --n4;
                            } else {
                                stringBuffer.append("'}");
                                n5 = 39;
                            }
                        }
                    }
                    stringBuffer.append((char)n5);
                }
            }
            stringBuffer.append('}');
            ++n;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            this.appendQuoted(stringBuffer, this.strings[this.maxOffset + 1]);
        }
        return stringBuffer.toString();
    }

    private void appendQuoted(StringBuffer stringBuffer, String string) {
        int n = string.length();
        int n2 = 0;
        while (n2 < n) {
            char c2 = string.charAt(n2);
            if (c2 == '{' || c2 == '}') {
                stringBuffer.append('\'');
                stringBuffer.append(c2);
                stringBuffer.append('\'');
            } else {
                stringBuffer.append(c2);
            }
            ++n2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("argumentNumbers", this.argumentNumbers);
        Format[] formatArray = this.formats;
        objectOutputStream$PutField.put("formats", formatArray);
        objectOutputStream$PutField.put("locale", this.locale);
        objectOutputStream$PutField.put("maxOffset", this.maxOffset);
        int n = 0;
        int n2 = this.maxOffset + 1;
        int[] nArray = new int[n2];
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = 0;
        while (n3 <= this.maxOffset) {
            nArray[n3] = n += this.strings[n3].length();
            stringBuffer.append(this.strings[n3]);
            ++n3;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            stringBuffer.append(this.strings[this.maxOffset + 1]);
        }
        objectOutputStream$PutField.put("offsets", nArray);
        objectOutputStream$PutField.put("pattern", stringBuffer.toString());
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        this.argumentNumbers = (int[])objectInputStream$GetField.get("argumentNumbers", null);
        this.formats = (Format[])objectInputStream$GetField.get("formats", null);
        this.locale = (Locale)objectInputStream$GetField.get("locale", null);
        this.maxOffset = objectInputStream$GetField.get("maxOffset", 0);
        int[] nArray = (int[])objectInputStream$GetField.get("offsets", null);
        String string = (String)objectInputStream$GetField.get("pattern", null);
        int n = this.maxOffset < 0 ? (string.length() > 0 ? 1 : 0) : this.maxOffset + (nArray[this.maxOffset] == string.length() ? 1 : 2);
        this.strings = new String[n];
        int n2 = 0;
        int n3 = 0;
        while (n3 <= this.maxOffset) {
            this.strings[n3] = string.substring(n2, nArray[n3]);
            n2 = nArray[n3];
            ++n3;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            this.strings[this.strings.length - 1] = string.substring(n2, string.length());
        }
    }
}

