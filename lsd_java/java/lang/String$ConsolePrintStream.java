/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.io.CharacterConverter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

class String$ConsolePrintStream
extends PrintStream {
    private static CharacterConverter converter;

    static {
        String string = System.getProperty("console.encoding");
        if (string == null) {
            string = "ISO8859_1";
        }
        converter = CharacterConverter.getDefaultConverter(string);
    }

    public String$ConsolePrintStream(OutputStream outputStream) {
        super(outputStream, true);
    }

    @Override
    public void print(String string) {
        if (string == null) {
            string = "null";
        }
        try {
            this.write(converter.convert(String.access$0(string), String.access$1(string), String.access$2(string)));
        }
        catch (IOException iOException) {
            this.setError();
        }
    }
}

