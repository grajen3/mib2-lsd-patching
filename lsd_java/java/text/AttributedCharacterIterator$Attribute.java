/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.io.Serializable;

public class AttributedCharacterIterator$Attribute
implements Serializable {
    private static final long serialVersionUID;
    public static final AttributedCharacterIterator$Attribute INPUT_METHOD_SEGMENT;
    public static final AttributedCharacterIterator$Attribute LANGUAGE;
    public static final AttributedCharacterIterator$Attribute READING;
    private String name;
    static /* synthetic */ Class class$0;

    static {
        INPUT_METHOD_SEGMENT = new AttributedCharacterIterator$Attribute("input_method_segment");
        LANGUAGE = new AttributedCharacterIterator$Attribute("language");
        READING = new AttributedCharacterIterator$Attribute("reading");
    }

    protected AttributedCharacterIterator$Attribute(String string) {
        this.name = string;
    }

    public final boolean equals(Object object) {
        return this == object;
    }

    protected String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    protected Object readResolve() {
        Class clazz = super.getClass();
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.text.AttributedCharacterIterator$Attribute");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if (clazz != clazz2) {
            throw new InvalidObjectException(Msg.getString("K000c"));
        }
        if (AttributedCharacterIterator$Attribute.INPUT_METHOD_SEGMENT.name.equals(this.name)) {
            return INPUT_METHOD_SEGMENT;
        }
        if (AttributedCharacterIterator$Attribute.LANGUAGE.name.equals(this.name)) {
            return LANGUAGE;
        }
        if (AttributedCharacterIterator$Attribute.READING.name.equals(this.name)) {
            return READING;
        }
        throw new InvalidObjectException(Msg.getString("K000d"));
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append('(').append(this.getName()).append(')').toString();
    }
}

