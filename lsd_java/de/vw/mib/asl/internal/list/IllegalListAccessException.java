/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

public class IllegalListAccessException
extends IllegalArgumentException {
    private static final long serialVersionUID;
    private static final String BOOM;

    public IllegalListAccessException(String string) {
        super(new StringBuffer().append(string).append("\n     _.-^^---....,,--\n _--                  --_\n<                        >)\n|                         |\n \\._                   _./\n    ```--. . , ; .--'''\n          | |   |\n       .-=||  | |=-.\n       `-=#$%&%$#=-'\n          | ;  :|\n _____.,-#%&$@%#&#~,._____").toString());
    }
}

