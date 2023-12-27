/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.Font;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractFont
implements Font {
    private static final int RANGE_START;
    private static final int RANGE_END;
    private final Logger logger;
    private final String name;

    public AbstractFont(Logger logger, String string) {
        this.logger = logger;
        this.name = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[name=").append(this.getName());
        stringBuilder.append(",familyName=").append(this.getFamilyName());
        stringBuilder.append(",styleName=").append(this.getStyleName());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public abstract void dispose() {
    }

    protected final Logger getLogger() {
        return this.logger;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public abstract String getFamilyName() {
    }

    @Override
    public abstract String getStyleName() {
    }

    @Override
    public abstract int getAscender(int n) {
    }

    @Override
    public abstract int getDescender(int n) {
    }

    @Override
    public abstract int getHeight(int n) {
    }

    @Override
    public abstract int getMaxAdvanceWidth(int n) {
    }

    @Override
    public int getLeading(int n) {
        return this.getHeight(n) - (this.getAscender(n) - this.getDescender(n));
    }

    protected static final boolean containsChar(char[][] cArray, char c2) {
        if (cArray != null) {
            for (int i2 = 0; i2 < cArray.length; ++i2) {
                if (c2 < cArray[i2][0] || c2 > cArray[i2][1]) continue;
                return true;
            }
        }
        return false;
    }
}

