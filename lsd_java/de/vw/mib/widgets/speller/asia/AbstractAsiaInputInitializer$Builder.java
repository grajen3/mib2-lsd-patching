/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import java.util.Arrays;

public abstract class AbstractAsiaInputInitializer$Builder {
    protected AbstractAsiaInputInitializer initializer;
    protected int inputMode = -1;
    protected String inputModeName = "NONE";
    protected int type = 0;
    protected String typeName = "DEFAULT";
    protected boolean userDatabase = false;
    protected String[] wordDatabaseNames = new String[0];

    protected AbstractAsiaInputInitializer$Builder() {
    }

    public AbstractAsiaInputInitializer$Builder(AbstractAsiaInputInitializer abstractAsiaInputInitializer) {
        this.initializer = abstractAsiaInputInitializer;
        if (abstractAsiaInputInitializer != null) {
            this.inputMode = abstractAsiaInputInitializer.inputMode;
            this.type = abstractAsiaInputInitializer.type;
            this.userDatabase = abstractAsiaInputInitializer.userDatabase;
            this.wordDatabaseNames = abstractAsiaInputInitializer.wordDatabaseNames;
        }
    }

    protected final void renewInternal(boolean bl) {
        if (this.initializer == null) {
            throw new IllegalStateException("No initializer instance to renew passed before!");
        }
        if (this.initializer.inputMode != this.inputMode) {
            this.initializer.inputMode = this.inputMode;
            bl |= true;
        }
        if (this.initializer.type != this.type) {
            this.initializer.type = this.type;
            bl |= true;
        }
        if (this.initializer.userDatabase != this.userDatabase) {
            this.initializer.userDatabase = this.userDatabase;
            bl |= true;
        }
        if (!Arrays.equals(this.initializer.wordDatabaseNames, this.wordDatabaseNames)) {
            this.initializer.wordDatabaseNames = this.wordDatabaseNames;
            bl |= true;
        }
        if (bl) {
            this.initializer.reset();
        }
    }

    public AbstractAsiaInputInitializer$Builder inputMode(int n) {
        throw new IllegalArgumentException("Input mode is invalid!");
    }

    public AbstractAsiaInputInitializer$Builder type(int n) {
        switch (n) {
            case 0: {
                this.type = n;
                this.typeName = "DEFAULT";
                break;
            }
            default: {
                throw new IllegalArgumentException("Type is invalid!");
            }
        }
        return this;
    }

    public final AbstractAsiaInputInitializer$Builder userDatabase(boolean bl) {
        this.userDatabase = bl;
        return this;
    }

    public AbstractAsiaInputInitializer$Builder wordDatabaseNames(String[] stringArray) {
        if (stringArray != null) {
            this.wordDatabaseNames = stringArray;
        }
        return this;
    }
}

