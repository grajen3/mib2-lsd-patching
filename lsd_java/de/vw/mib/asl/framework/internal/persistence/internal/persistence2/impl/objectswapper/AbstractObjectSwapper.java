/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.objectswapper;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.objectswapper.ObjectSwapper;

public abstract class AbstractObjectSwapper
implements ObjectSwapper {
    protected static final int OBJSWAP_TYPE_STRING;
    protected static final int OBJSWAP_TYPE_STRING_ARRAY;
    protected static final int OBJSWAP_TYPE_BYTE_ARRAY;
    protected static final int OBJSWAP_TYPE_CHAR_ARRAY;
    protected static final int OBJSWAP_TYPE_SHORT_ARRAY;
    protected static final int OBJSWAP_TYPE_INT_ARRAY;
    protected static final int OBJSWAP_TYPE_LONG_ARRAY;
    protected static final int OBJSWAP_TYPE_FLOAT_ARRAY;
    protected static final int OBJSWAP_TYPE_DOUBLE_ARRAY;
    protected static final int OBJSWAP_TYPE_NULL;
    protected static final int BYTE_SIZE;
    protected static final int CHAR_SIZE;
    protected static final int SHORT_SIZE;
    protected static final int INT_SIZE;
    protected static final int LONG_SIZE;
    protected static final int FLOAT_SIZE;
    protected static final int DOUBLE_SIZE;
    protected static final int INITIAL_BUFFER_SIZE;

    protected static int getPrimitiveElementByteSize(int n) {
        switch (n) {
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 8;
            }
            case 7: {
                return 4;
            }
            case 8: {
                return 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Invalid type ").append(n).toString());
    }
}

