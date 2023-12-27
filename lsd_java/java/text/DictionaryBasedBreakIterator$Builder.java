/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.text.CharSet;
import java.text.DictionaryBasedBreakIterator;
import java.text.RuleBasedBreakIterator$Builder;
import java.util.Hashtable;
import java.util.Vector;

public class DictionaryBasedBreakIterator$Builder
extends RuleBasedBreakIterator$Builder {
    private CharSet dictionaryChars;
    private String dictionaryExpression;
    final /* synthetic */ DictionaryBasedBreakIterator this$0;

    public DictionaryBasedBreakIterator$Builder(DictionaryBasedBreakIterator dictionaryBasedBreakIterator) {
        DictionaryBasedBreakIterator dictionaryBasedBreakIterator2 = dictionaryBasedBreakIterator;
        super(dictionaryBasedBreakIterator2);
        this.this$0 = dictionaryBasedBreakIterator;
        this.dictionaryChars = new CharSet();
        this.dictionaryExpression = "";
    }

    @Override
    protected void handleSpecialSubstitution(String string, String string2, int n, String string3) {
        super.handleSpecialSubstitution(string, string2, n, string3);
        if (string.equals("<dictionary>")) {
            if (string2.charAt(0) == '(') {
                this.error(Msg.getString("K00c3"), n, string3);
            }
            this.dictionaryExpression = string2;
            this.dictionaryChars = CharSet.parseString(string2);
        }
    }

    @Override
    protected void buildCharCategories(Vector vector) {
        super.buildCharCategories(vector);
        DictionaryBasedBreakIterator.access$0(this.this$0, new boolean[this.categories.size()]);
        int n = 0;
        while (n < this.categories.size()) {
            CharSet charSet = (CharSet)this.categories.elementAt(n);
            if (!charSet.intersection(this.dictionaryChars).empty()) {
                DictionaryBasedBreakIterator.access$1((DictionaryBasedBreakIterator)this.this$0)[n] = true;
            }
            ++n;
        }
    }

    @Override
    protected void mungeExpressionList(Hashtable hashtable) {
        hashtable.put(this.dictionaryExpression, this.dictionaryChars);
    }
}

