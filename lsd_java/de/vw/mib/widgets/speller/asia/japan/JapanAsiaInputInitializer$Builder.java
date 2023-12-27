/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$Builder;
import de.vw.mib.widgets.speller.asia.japan.JapanAsiaInputInitializer;

public final class JapanAsiaInputInitializer$Builder
extends AbstractAsiaInputInitializer$Builder {
    protected boolean nameInput = false;

    public JapanAsiaInputInitializer$Builder() {
        this.type = -1;
        this.typeName = "NONE";
        this.inputMode = 9;
        this.inputModeName = "HIRAGANA";
    }

    public JapanAsiaInputInitializer$Builder(JapanAsiaInputInitializer japanAsiaInputInitializer) {
        super(japanAsiaInputInitializer);
        if (japanAsiaInputInitializer != null) {
            // empty if block
        }
    }

    public JapanAsiaInputInitializer build() {
        return new JapanAsiaInputInitializer(this);
    }

    public JapanAsiaInputInitializer renew() {
        if (this.initializer == null) {
            throw new IllegalStateException("No initializer instance to renew passed before!");
        }
        boolean bl = false;
        super.renewInternal(bl);
        return (JapanAsiaInputInitializer)this.initializer;
    }

    public JapanAsiaInputInitializer$Builder nameInput(boolean bl) {
        this.nameInput = bl;
        return this;
    }

    @Override
    public AbstractAsiaInputInitializer$Builder inputMode(int n) {
        switch (n) {
            case 9: {
                this.inputMode = n;
                this.inputModeName = "HIRAGANA";
                break;
            }
            case 8: {
                this.inputMode = n;
                this.inputModeName = "KATAKANA";
                break;
            }
            default: {
                return super.inputMode(n);
            }
        }
        return this;
    }
}

