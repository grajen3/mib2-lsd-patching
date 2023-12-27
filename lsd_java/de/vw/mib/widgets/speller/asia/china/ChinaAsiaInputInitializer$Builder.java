/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$Builder;
import de.vw.mib.widgets.speller.asia.china.ChinaAsiaInputInitializer;

public final class ChinaAsiaInputInitializer$Builder
extends AbstractAsiaInputInitializer$Builder {
    protected boolean firstLetter = false;
    protected boolean nameInput = false;
    protected boolean smartPunctuation = false;

    public ChinaAsiaInputInitializer$Builder() {
        this.type = 2;
        this.typeName = "SIMPLIFIED";
    }

    public ChinaAsiaInputInitializer$Builder(ChinaAsiaInputInitializer chinaAsiaInputInitializer) {
        super(chinaAsiaInputInitializer);
        if (chinaAsiaInputInitializer != null) {
            this.firstLetter = chinaAsiaInputInitializer.firstLetter;
            this.nameInput = chinaAsiaInputInitializer.nameInput;
            this.smartPunctuation = chinaAsiaInputInitializer.smartPunctuation;
        }
    }

    public ChinaAsiaInputInitializer build() {
        return new ChinaAsiaInputInitializer(this);
    }

    public ChinaAsiaInputInitializer renew() {
        if (this.initializer == null) {
            throw new IllegalStateException("No initializer instance to renew passed before!");
        }
        boolean bl = false;
        if (((ChinaAsiaInputInitializer)this.initializer).firstLetter != this.firstLetter) {
            ((ChinaAsiaInputInitializer)this.initializer).firstLetter = this.firstLetter;
            bl |= true;
        }
        if (((ChinaAsiaInputInitializer)this.initializer).nameInput != this.nameInput) {
            ((ChinaAsiaInputInitializer)this.initializer).nameInput = this.nameInput;
            bl |= true;
        }
        if (((ChinaAsiaInputInitializer)this.initializer).smartPunctuation != this.smartPunctuation) {
            ((ChinaAsiaInputInitializer)this.initializer).smartPunctuation = this.smartPunctuation;
            bl |= true;
        }
        super.renewInternal(bl);
        return (ChinaAsiaInputInitializer)this.initializer;
    }

    public ChinaAsiaInputInitializer$Builder firstLetter(boolean bl) {
        this.firstLetter = bl;
        return this;
    }

    public ChinaAsiaInputInitializer$Builder nameInput(boolean bl) {
        this.nameInput = bl;
        return this;
    }

    @Override
    public AbstractAsiaInputInitializer$Builder inputMode(int n) {
        switch (n) {
            case 0: {
                this.inputMode = n;
                this.inputModeName = "BoPoMoFo";
                break;
            }
            case 1: {
                this.inputMode = n;
                this.inputModeName = "CANGJIE";
                break;
            }
            case 2: {
                this.inputMode = n;
                this.inputModeName = "PINYIN";
                break;
            }
            case 3: {
                this.inputMode = n;
                this.inputModeName = "QUICKCANGJIE";
                break;
            }
            case 4: {
                this.inputMode = n;
                this.inputModeName = "STROKE";
                break;
            }
            default: {
                return super.inputMode(n);
            }
        }
        return this;
    }

    public ChinaAsiaInputInitializer$Builder smartPunctuation(boolean bl) {
        this.smartPunctuation = bl;
        return this;
    }

    @Override
    public AbstractAsiaInputInitializer$Builder type(int n) {
        switch (n) {
            case 1: {
                this.type = n;
                this.typeName = "HONGKONG";
                break;
            }
            case 2: {
                this.type = n;
                this.typeName = "SIMPLIFIED";
                break;
            }
            case 3: {
                this.type = n;
                this.typeName = "SINGAPURE";
                break;
            }
            case 4: {
                this.type = n;
                this.typeName = "TRADITIONAL";
                break;
            }
            default: {
                return super.type(n);
            }
        }
        return this;
    }
}

