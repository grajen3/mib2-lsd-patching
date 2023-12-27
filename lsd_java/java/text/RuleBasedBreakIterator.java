/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.CompactByteArray;
import com.ibm.oti.util.Msg;
import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.text.RuleBasedBreakIterator$Builder;
import java.text.RuleBasedBreakIterator$SafeCharIterator;
import java.text.StringCharacterIterator;

class RuleBasedBreakIterator
extends BreakIterator {
    protected static final byte IGNORE;
    private static final short START_STATE;
    private static final short STOP_STATE;
    private String description;
    private CompactByteArray charCategoryTable = null;
    private short[] stateTable = null;
    private short[] backwardsStateTable = null;
    private boolean[] endStates = null;
    private boolean[] lookaheadStates = null;
    private int numCategories;
    private CharacterIterator text = null;

    public RuleBasedBreakIterator(String string) {
        this.description = string;
        RuleBasedBreakIterator$Builder ruleBasedBreakIterator$Builder = this.makeBuilder();
        ruleBasedBreakIterator$Builder.buildBreakIterator();
    }

    protected RuleBasedBreakIterator$Builder makeBuilder() {
        return new RuleBasedBreakIterator$Builder(this);
    }

    @Override
    public Object clone() {
        RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator)super.clone();
        if (this.text != null) {
            ruleBasedBreakIterator.text = (CharacterIterator)this.text.clone();
        }
        return ruleBasedBreakIterator;
    }

    public boolean equals(Object object) {
        try {
            RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator)object;
            if (!this.description.equals(ruleBasedBreakIterator.description)) {
                return false;
            }
            if (this.text == null) {
                return ruleBasedBreakIterator.text == null;
            }
            return this.text.equals(ruleBasedBreakIterator.text);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public String toString() {
        return this.description;
    }

    public int hashCode() {
        return this.description.hashCode();
    }

    @Override
    public int first() {
        CharacterIterator characterIterator = this.getText();
        characterIterator.first();
        return characterIterator.getIndex();
    }

    @Override
    public int last() {
        CharacterIterator characterIterator = this.getText();
        characterIterator.setIndex(characterIterator.getEndIndex());
        return characterIterator.getIndex();
    }

    @Override
    public int next(int n) {
        int n2 = this.current();
        while (n > 0) {
            n2 = this.handleNext();
            --n;
        }
        while (n < 0) {
            n2 = this.previous();
            ++n;
        }
        return n2;
    }

    @Override
    public int next() {
        return this.handleNext();
    }

    @Override
    public int previous() {
        int n;
        CharacterIterator characterIterator = this.getText();
        if (this.current() == characterIterator.getBeginIndex()) {
            return -1;
        }
        int n2 = this.current();
        characterIterator.previous();
        int n3 = n = this.handlePrevious();
        while (n3 != -1 && n3 < n2) {
            n = n3;
            n3 = this.handleNext();
        }
        characterIterator.setIndex(n);
        return n;
    }

    protected static final void checkOffset(int n, CharacterIterator characterIterator) {
        if (n < characterIterator.getBeginIndex() || n >= characterIterator.getEndIndex()) {
            throw new IllegalArgumentException(Msg.getString("K002e"));
        }
    }

    @Override
    public int following(int n) {
        CharacterIterator characterIterator = this.getText();
        RuleBasedBreakIterator.checkOffset(n, characterIterator);
        characterIterator.setIndex(n);
        if (n == characterIterator.getBeginIndex()) {
            return this.handleNext();
        }
        int n2 = this.handlePrevious();
        while (n2 != -1 && n2 <= n) {
            n2 = this.handleNext();
        }
        return n2;
    }

    @Override
    public int preceding(int n) {
        CharacterIterator characterIterator = this.getText();
        RuleBasedBreakIterator.checkOffset(n, characterIterator);
        characterIterator.setIndex(n);
        return this.previous();
    }

    @Override
    public boolean isBoundary(int n) {
        CharacterIterator characterIterator = this.getText();
        RuleBasedBreakIterator.checkOffset(n, characterIterator);
        if (n == characterIterator.getBeginIndex()) {
            return true;
        }
        return this.following(n - 1) == n;
    }

    @Override
    public int current() {
        return this.getText().getIndex();
    }

    @Override
    public CharacterIterator getText() {
        if (this.text == null) {
            this.text = new StringCharacterIterator("");
        }
        return this.text;
    }

    @Override
    public void setText(CharacterIterator characterIterator) {
        boolean bl;
        int n = characterIterator.getEndIndex();
        try {
            characterIterator.setIndex(n);
            bl = characterIterator.getIndex() == n;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            bl = false;
        }
        this.text = bl ? characterIterator : new RuleBasedBreakIterator$SafeCharIterator(characterIterator);
        this.text.first();
    }

    /*
     * Unable to fully structure code
     */
    protected int handleNext() {
        var1_1 = this.getText();
        if (var1_1.getIndex() == var1_1.getEndIndex()) {
            return -1;
        }
        var2_2 = var1_1.getIndex() + 1;
        var3_3 = 0;
        var4_4 = 1;
        var7_6 = var6_5 = var1_1.current();
        var8_7 = 0;
        if (this.lookupCategory(var6_5) != -1) ** GOTO lbl30
        while (this.lookupCategory(var6_5) == -1) {
            var6_5 = var1_1.next();
        }
        if (Character.getType(var6_5) != 6 && Character.getType(var6_5) != 7) ** GOTO lbl30
        return var1_1.getIndex();
lbl-1000:
        // 1 sources

        {
            var5_8 = this.lookupCategory(var6_5);
            if (var5_8 != -1) {
                var4_4 = this.lookupState(var4_4, var5_8);
            }
            if (this.lookaheadStates[var4_4]) {
                if (this.endStates[var4_4]) {
                    var2_2 = var3_3;
                } else {
                    var3_3 = var1_1.getIndex() + 1;
                }
            } else if (this.endStates[var4_4]) {
                var2_2 = var1_1.getIndex() + 1;
            }
            if (var5_8 != -1 && var4_4 != 0) {
                var7_6 = var6_5;
                var8_7 = var1_1.getIndex();
            }
            var6_5 = var1_1.next();
lbl30:
            // 3 sources

            ** while (var6_5 != '\uffff0000' && var4_4 != 0)
        }
lbl31:
        // 1 sources

        if (var6_5 == '\uffff0000' && var3_3 == var1_1.getEndIndex()) {
            var2_2 = var3_3;
        } else if ("\n\r\f\u2028\u2029".indexOf(var7_6) != -1) {
            var2_2 = var8_7 + 1;
        }
        var1_1.setIndex(var2_2);
        return var2_2;
    }

    protected int handlePrevious() {
        CharacterIterator characterIterator = this.getText();
        int n = 1;
        int n2 = 0;
        int n3 = 0;
        char c2 = characterIterator.current();
        while (c2 != '\uffff0000' && n != 0) {
            n3 = n2;
            n2 = this.lookupCategory(c2);
            if (n2 != -1) {
                n = this.lookupBackwardState(n, n2);
            }
            c2 = characterIterator.previous();
        }
        if (c2 != '\uffff0000') {
            if (n3 != -1) {
                characterIterator.setIndex(characterIterator.getIndex() + 2);
            } else {
                characterIterator.next();
            }
        }
        return characterIterator.getIndex();
    }

    protected int lookupCategory(char c2) {
        return this.charCategoryTable.elementAt(c2);
    }

    protected int lookupState(int n, int n2) {
        return this.stateTable[n * this.numCategories + n2];
    }

    protected int lookupBackwardState(int n, int n2) {
        return this.backwardsStateTable[n * this.numCategories + n2];
    }

    static /* synthetic */ String access$0(RuleBasedBreakIterator ruleBasedBreakIterator) {
        return ruleBasedBreakIterator.description;
    }

    static /* synthetic */ void access$1(RuleBasedBreakIterator ruleBasedBreakIterator, CompactByteArray compactByteArray) {
        ruleBasedBreakIterator.charCategoryTable = compactByteArray;
    }

    static /* synthetic */ CompactByteArray access$2(RuleBasedBreakIterator ruleBasedBreakIterator) {
        return ruleBasedBreakIterator.charCategoryTable;
    }

    static /* synthetic */ void access$3(RuleBasedBreakIterator ruleBasedBreakIterator, int n) {
        ruleBasedBreakIterator.numCategories = n;
    }

    static /* synthetic */ int access$4(RuleBasedBreakIterator ruleBasedBreakIterator) {
        return ruleBasedBreakIterator.numCategories;
    }

    static /* synthetic */ void access$5(RuleBasedBreakIterator ruleBasedBreakIterator, boolean[] blArray) {
        ruleBasedBreakIterator.endStates = blArray;
    }

    static /* synthetic */ void access$6(RuleBasedBreakIterator ruleBasedBreakIterator, boolean[] blArray) {
        ruleBasedBreakIterator.lookaheadStates = blArray;
    }

    static /* synthetic */ void access$7(RuleBasedBreakIterator ruleBasedBreakIterator, short[] sArray) {
        ruleBasedBreakIterator.stateTable = sArray;
    }

    static /* synthetic */ short[] access$8(RuleBasedBreakIterator ruleBasedBreakIterator) {
        return ruleBasedBreakIterator.stateTable;
    }

    static /* synthetic */ boolean[] access$9(RuleBasedBreakIterator ruleBasedBreakIterator) {
        return ruleBasedBreakIterator.endStates;
    }

    static /* synthetic */ boolean[] access$10(RuleBasedBreakIterator ruleBasedBreakIterator) {
        return ruleBasedBreakIterator.lookaheadStates;
    }

    static /* synthetic */ void access$11(RuleBasedBreakIterator ruleBasedBreakIterator, short[] sArray) {
        ruleBasedBreakIterator.backwardsStateTable = sArray;
    }

    static /* synthetic */ short[] access$12(RuleBasedBreakIterator ruleBasedBreakIterator) {
        return ruleBasedBreakIterator.backwardsStateTable;
    }
}

