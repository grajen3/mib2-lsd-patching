/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.CompactIntArray;
import com.ibm.oti.text.IntHashtable;
import java.text.RBCollationTables;
import java.util.Vector;

final class RBCollationTables$BuildAPI {
    final /* synthetic */ RBCollationTables this$0;

    private RBCollationTables$BuildAPI(RBCollationTables rBCollationTables) {
        this.this$0 = rBCollationTables;
    }

    void fillInTables(boolean bl, boolean bl2, CompactIntArray compactIntArray, Vector vector, Vector vector2, IntHashtable intHashtable, short s, short s2) {
        RBCollationTables.access$0(this.this$0, bl);
        RBCollationTables.access$1(this.this$0, bl2);
        RBCollationTables.access$2(this.this$0, compactIntArray);
        RBCollationTables.access$3(this.this$0, vector);
        RBCollationTables.access$4(this.this$0, vector2);
        RBCollationTables.access$5(this.this$0, intHashtable);
        RBCollationTables.access$6(this.this$0, s);
        RBCollationTables.access$7(this.this$0, s2);
    }

    /* synthetic */ RBCollationTables$BuildAPI(RBCollationTables rBCollationTables, RBCollationTables$BuildAPI rBCollationTables$BuildAPI) {
        this(rBCollationTables);
    }
}

