/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.Normalizer;
import com.ibm.oti.text.Normalizer$Mode;
import java.text.CharacterIterator;
import java.text.CollationElementIterator;
import java.text.CollationKey;
import java.text.Collator;
import java.text.RBCollationTables;

public class RuleBasedCollator
extends Collator {
    static final int CHARINDEX;
    static final int EXPANDCHARINDEX;
    static final int CONTRACTCHARINDEX;
    static final int UNMAPPED;
    private static final int COLLATIONKEYOFFSET;
    private RBCollationTables tables = null;
    private StringBuffer primResult = null;
    private StringBuffer secResult = null;
    private StringBuffer terResult = null;
    private CollationElementIterator sourceCursor = null;
    private CollationElementIterator targetCursor = null;
    static /* synthetic */ Class class$0;

    public RuleBasedCollator(String string) {
        this(string, 1);
    }

    RuleBasedCollator(String string, int n) {
        this.setStrength(2);
        this.setDecomposition(n);
        this.tables = new RBCollationTables(string, n);
    }

    private RuleBasedCollator(RuleBasedCollator ruleBasedCollator) {
        this.setStrength(ruleBasedCollator.getStrength());
        this.setDecomposition(ruleBasedCollator.getDecomposition());
        this.tables = ruleBasedCollator.tables;
    }

    public String getRules() {
        return this.tables.getRules();
    }

    public CollationElementIterator getCollationElementIterator(String string) {
        return new CollationElementIterator(string, this);
    }

    public CollationElementIterator getCollationElementIterator(CharacterIterator characterIterator) {
        return new CollationElementIterator(characterIterator, this);
    }

    @Override
    public synchronized int compare(String string, String string2) {
        boolean bl;
        int n = 0;
        if (this.sourceCursor == null) {
            this.sourceCursor = this.getCollationElementIterator(string);
        } else {
            this.sourceCursor.setText(string);
        }
        if (this.targetCursor == null) {
            this.targetCursor = this.getCollationElementIterator(string2);
        } else {
            this.targetCursor.setText(string2);
        }
        int n2 = 0;
        int n3 = 0;
        boolean bl2 = bl = this.getStrength() >= 1;
        boolean bl3 = this.getStrength() >= 2;
        boolean bl4 = true;
        boolean bl5 = true;
        while (true) {
            short s;
            short s2;
            short s3;
            if (bl4) {
                n2 = this.sourceCursor.next();
            } else {
                bl4 = true;
            }
            if (bl5) {
                n3 = this.targetCursor.next();
            } else {
                bl5 = true;
            }
            if (n2 == -1 || n3 == -1) break;
            int n4 = CollationElementIterator.primaryOrder(n2);
            int n5 = CollationElementIterator.primaryOrder(n3);
            if (n2 == n3) {
                if (!this.tables.isFrenchSec() || n4 == 0 || bl2) continue;
                bl2 = bl;
                bl3 = false;
                continue;
            }
            if (n4 != n5) {
                if (n2 == 0) {
                    bl5 = false;
                    continue;
                }
                if (n3 == 0) {
                    bl4 = false;
                    continue;
                }
                if (n4 == 0) {
                    if (bl2) {
                        n = 1;
                        bl2 = false;
                    }
                    bl5 = false;
                    continue;
                }
                if (n5 == 0) {
                    if (bl2) {
                        n = -1;
                        bl2 = false;
                    }
                    bl4 = false;
                    continue;
                }
                if (n4 < n5) {
                    return -1;
                }
                return 1;
            }
            if (!bl2) continue;
            short s4 = CollationElementIterator.secondaryOrder(n2);
            if (s4 != (s3 = CollationElementIterator.secondaryOrder(n3))) {
                n = s4 < s3 ? -1 : 1;
                bl2 = false;
                continue;
            }
            if (!bl3 || (s2 = CollationElementIterator.tertiaryOrder(n2)) == (s = CollationElementIterator.tertiaryOrder(n3))) continue;
            n = s2 < s ? -1 : 1;
            bl3 = false;
        }
        if (n2 != -1) {
            do {
                if (CollationElementIterator.primaryOrder(n2) != 0) {
                    return 1;
                }
                if (CollationElementIterator.secondaryOrder(n2) == 0 || !bl2) continue;
                n = 1;
                bl2 = false;
            } while ((n2 = this.sourceCursor.next()) != -1);
        } else if (n3 != -1) {
            do {
                if (CollationElementIterator.primaryOrder(n3) != 0) {
                    return -1;
                }
                if (CollationElementIterator.secondaryOrder(n3) == 0 || !bl2) continue;
                n = -1;
                bl2 = false;
            } while ((n3 = this.targetCursor.next()) != -1);
        }
        if (n == 0 && this.getStrength() == 3) {
            Normalizer$Mode normalizer$Mode = Normalizer.getMode(this.getDecomposition());
            String string3 = Normalizer.normalize(string, normalizer$Mode, 0);
            String string4 = Normalizer.normalize(string2, normalizer$Mode, 0);
            n = string3.compareTo(string4);
        }
        return n;
    }

    @Override
    public synchronized CollationKey getCollationKey(String string) {
        if (string == null) {
            return null;
        }
        if (this.primResult == null) {
            this.primResult = new StringBuffer();
            this.secResult = new StringBuffer();
            this.terResult = new StringBuffer();
        } else {
            this.primResult.setLength(0);
            this.secResult.setLength(0);
            this.terResult.setLength(0);
        }
        int n = 0;
        boolean bl = this.getStrength() >= 1;
        boolean bl2 = this.getStrength() >= 2;
        int n2 = -1;
        int n3 = -1;
        int n4 = 0;
        if (this.sourceCursor == null) {
            this.sourceCursor = this.getCollationElementIterator(string);
        } else {
            this.sourceCursor.setText(string);
        }
        while ((n = this.sourceCursor.next()) != -1) {
            n2 = CollationElementIterator.secondaryOrder(n);
            n3 = CollationElementIterator.tertiaryOrder(n);
            if (!CollationElementIterator.isIgnorable(n)) {
                this.primResult.append((char)(CollationElementIterator.primaryOrder(n) + 1));
                if (bl) {
                    if (this.tables.isFrenchSec() && n4 < this.secResult.length()) {
                        RBCollationTables.reverse(this.secResult, n4, this.secResult.length());
                    }
                    this.secResult.append((char)(n2 + 1));
                    n4 = this.secResult.length();
                }
                if (!bl2) continue;
                this.terResult.append((char)(n3 + 1));
                continue;
            }
            if (bl && n2 != 0) {
                this.secResult.append((char)(n2 + this.tables.getMaxSecOrder() + 1));
            }
            if (!bl2 || n3 == 0) continue;
            this.terResult.append((char)(n3 + this.tables.getMaxTerOrder() + 1));
        }
        if (this.tables.isFrenchSec()) {
            if (n4 < this.secResult.length()) {
                RBCollationTables.reverse(this.secResult, n4, this.secResult.length());
            }
            RBCollationTables.reverse(this.secResult, 0, this.secResult.length());
        }
        this.primResult.append('\u0000');
        this.secResult.append('\u0000');
        this.secResult.append(this.terResult.toString());
        this.primResult.append(this.secResult.toString());
        if (this.getStrength() == 3) {
            this.primResult.append('\u0000');
            Normalizer$Mode normalizer$Mode = Normalizer.getMode(this.getDecomposition());
            this.primResult.append(Normalizer.normalize(string, normalizer$Mode, 0));
        }
        return new CollationKey(string, this.primResult.toString());
    }

    @Override
    public Object clone() {
        Class clazz = super.getClass();
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.text.RuleBasedCollator");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if (clazz == clazz2) {
            return new RuleBasedCollator(this);
        }
        RuleBasedCollator ruleBasedCollator = (RuleBasedCollator)super.clone();
        ruleBasedCollator.primResult = null;
        ruleBasedCollator.secResult = null;
        ruleBasedCollator.terResult = null;
        ruleBasedCollator.sourceCursor = null;
        ruleBasedCollator.targetCursor = null;
        return ruleBasedCollator;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        RuleBasedCollator ruleBasedCollator = (RuleBasedCollator)object;
        return this.getRules().equals(ruleBasedCollator.getRules());
    }

    @Override
    public int hashCode() {
        return this.getRules().hashCode();
    }

    RBCollationTables getTables() {
        return this.tables;
    }
}

