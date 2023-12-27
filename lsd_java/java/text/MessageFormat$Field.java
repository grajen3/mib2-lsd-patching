/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.text.Format$Field;

public class MessageFormat$Field
extends Format$Field {
    public static final MessageFormat$Field ARGUMENT = new MessageFormat$Field("message argument field");

    protected MessageFormat$Field(String string) {
        super(string);
    }

    @Override
    protected Object readResolve() {
        String string = this.getName();
        if (string == null) {
            throw new InvalidObjectException(Msg.getString("K0344", "MessageFormat.Field"));
        }
        if (string.equals(ARGUMENT.getName())) {
            return ARGUMENT;
        }
        throw new InvalidObjectException(Msg.getString("K0344", "MessageFormat.Field"));
    }
}

