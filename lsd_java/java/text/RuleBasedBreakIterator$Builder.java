/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.CompactByteArray;
import com.ibm.oti.util.Msg;
import java.text.CharSet;
import java.text.RuleBasedBreakIterator;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class RuleBasedBreakIterator$Builder {
    protected Vector categories = null;
    protected Hashtable expressions = null;
    protected CharSet ignoreChars = null;
    protected Vector tempStateTable = null;
    protected Vector decisionPointList = null;
    protected Stack decisionPointStack = null;
    protected Vector loopingStates = null;
    protected Vector statesToBackfill = null;
    protected Vector mergeList = null;
    protected boolean clearLoopingStates = false;
    protected static final int END_STATE_FLAG;
    protected static final int DONT_LOOP_FLAG;
    protected static final int LOOKAHEAD_STATE_FLAG;
    protected static final int ALL_FLAGS;
    final /* synthetic */ RuleBasedBreakIterator this$0;

    public RuleBasedBreakIterator$Builder(RuleBasedBreakIterator ruleBasedBreakIterator) {
        this.this$0 = ruleBasedBreakIterator;
    }

    public void buildBreakIterator() {
        Vector vector = this.buildRuleList(RuleBasedBreakIterator.access$0(this.this$0));
        this.buildCharCategories(vector);
        this.buildStateTable(vector);
        this.buildBackwardsStateTable(vector);
    }

    private Vector buildRuleList(String string) {
        Vector vector = new Vector();
        Stack stack = new Stack();
        int n = 0;
        int n2 = 0;
        char c2 = '\u0000';
        int n3 = 0;
        int n4 = 0;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (string.length() != 0 && string.charAt(string.length() - 1) != ';') {
            string = new StringBuffer(String.valueOf(string)).append(";").toString();
        }
        while (n < string.length()) {
            c2 = string.charAt(n);
            switch (c2) {
                case '(': 
                case '<': 
                case '[': 
                case '{': {
                    if (n4 == 60) {
                        this.error(Msg.getString("K00b8"), n, string);
                    }
                    if (n4 == 91 && c2 != '[') {
                        this.error(Msg.getString("K00b9"), n, string);
                    }
                    if (c2 == '<' && (bl || bl2)) {
                        this.error(Msg.getString("K00ba"), n, string);
                    }
                    n4 = c2;
                    stack.push(new Character(c2));
                    if (c2 != '<') break;
                    bl3 = true;
                    break;
                }
                case ')': 
                case '>': 
                case ']': 
                case '}': {
                    char c3 = '\u0000';
                    switch (n4) {
                        case 123: {
                            c3 = '}';
                            break;
                        }
                        case 91: {
                            c3 = ']';
                            break;
                        }
                        case 40: {
                            c3 = ')';
                            break;
                        }
                        case 60: {
                            c3 = '>';
                        }
                    }
                    if (c2 != c3) {
                        this.error(Msg.getString("K00bb"), n, string);
                    }
                    if (n3 == n4) {
                        this.error(Msg.getString("K00bc"), n, string);
                    }
                    stack.pop();
                    if (!stack.empty()) {
                        n4 = ((Character)stack.peek()).charValue();
                        break;
                    }
                    n4 = 0;
                    break;
                }
                case '*': {
                    if ("=/{(|}*;\u0000".indexOf(n3) == -1) break;
                    this.error(Msg.getString("K00bd"), n, string);
                    break;
                }
                case '?': {
                    if (n3 == 42) break;
                    this.error(Msg.getString("K00be"), n, string);
                    break;
                }
                case '=': {
                    if (bl || bl2) {
                        this.error(Msg.getString("K00bf"), n, string);
                    }
                    bl = true;
                    break;
                }
                case '/': {
                    if (bl || bl2) {
                        this.error(Msg.getString("K00bf"), n, string);
                    }
                    if (bl3) {
                        this.error(Msg.getString("K00ba"), n, string);
                    }
                    bl2 = true;
                    break;
                }
                case '!': {
                    if (n3 == 59 || n3 == 0) break;
                    this.error(Msg.getString("K00c0"), n, string);
                    break;
                }
                case '\\': {
                    ++n;
                    break;
                }
                case '.': {
                    break;
                }
                case '-': 
                case ':': 
                case '^': {
                    if (n4 == 91 || n4 == 60) break;
                    this.error(Msg.getString("K00c1"), n, string);
                    break;
                }
                case ';': {
                    if (n3 == 59 || n3 == 0) {
                        this.error(Msg.getString("K00c2"), n, string);
                    }
                    if (!stack.empty()) {
                        this.error(Msg.getString("K00bb"), n, string);
                    }
                    if (!stack.empty()) break;
                    if (bl) {
                        string = this.processSubstitution(string.substring(n2, n), string, n + 1);
                    } else {
                        if (bl3) {
                            this.error(Msg.getString("K00ba"), n, string);
                        }
                        vector.addElement(string.substring(n2, n));
                    }
                    n2 = n + 1;
                    bl3 = false;
                    bl2 = false;
                    bl = false;
                    break;
                }
                case '|': {
                    if (n3 == 124) {
                        this.error(Msg.getString("K00c4"), n, string);
                    }
                    if (!stack.empty() && n4 == 40) break;
                    this.error(Msg.getString("K00c5"), n, string);
                    break;
                }
                default: {
                    if (c2 < ' ' || c2 >= '\u007f' || Character.isLetter(c2) || Character.isDigit(c2)) break;
                    this.error("Illegal character", n, string);
                }
            }
            n3 = c2;
            ++n;
        }
        if (vector.size() == 0) {
            this.error(Msg.getString("K00c6"), n, string);
        }
        return vector;
    }

    protected String processSubstitution(String string, String string2, int n) {
        int n2 = string.indexOf(61);
        String string3 = string.substring(0, n2);
        String string4 = string.substring(n2 + 1);
        this.handleSpecialSubstitution(string3, string4, n, string2);
        if (string4.length() == 0) {
            this.error(Msg.getString("K00c7"), n, string2);
        }
        if (string3.length() == 0) {
            this.error(Msg.getString("K00c8"), n, string2);
        }
        if (string3.length() == 2 && string3.charAt(0) != '\\') {
            this.error(Msg.getString("K00c9"), n, string2);
        }
        if (string3.length() >= 3 && string3.charAt(0) != '<' && string3.charAt(n2 - 1) != '>') {
            this.error(Msg.getString("K00c9"), n, string2);
        }
        if (!(string4.charAt(0) == '[' && string4.charAt(string4.length() - 1) == ']' || string4.charAt(0) == '(' && string4.charAt(string4.length() - 1) == ')')) {
            this.error(Msg.getString("K00ca"), n, string2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string2.substring(0, n));
        int n3 = n;
        int n4 = string2.indexOf(string3, n);
        while (n4 != -1) {
            stringBuffer.append(string2.substring(n3, n4));
            stringBuffer.append(string4);
            n3 = n4 + string3.length();
            n4 = string2.indexOf(string3, n3);
        }
        stringBuffer.append(string2.substring(n3));
        return stringBuffer.toString();
    }

    protected void handleSpecialSubstitution(String string, String string2, int n, String string3) {
        if (string.equals("<ignore>")) {
            if (string2.charAt(0) == '(') {
                this.error(Msg.getString("K00cb"), n, string3);
            }
            this.ignoreChars = CharSet.parseString(string2);
        }
    }

    protected void buildCharCategories(Vector vector) {
        Object object;
        CharSet charSet;
        Object object2;
        int n;
        Object object3;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        this.expressions = new Hashtable();
        while (n4 < vector.size()) {
            object3 = (String)vector.elementAt(n4);
            n3 = 0;
            while (n3 < ((String)object3).length()) {
                char c2 = ((String)object3).charAt(n3);
                switch (c2) {
                    case '!': 
                    case '(': 
                    case ')': 
                    case '*': 
                    case '.': 
                    case '/': 
                    case ';': 
                    case '?': 
                    case '{': 
                    case '|': 
                    case '}': {
                        break;
                    }
                    case '[': {
                        n = n3 + 1;
                        ++n2;
                        while (n < ((String)object3).length() && n2 != 0) {
                            c2 = ((String)object3).charAt(n);
                            switch (c2) {
                                case '\\': {
                                    ++n;
                                    break;
                                }
                                case '[': {
                                    ++n2;
                                    break;
                                }
                                case ']': {
                                    --n2;
                                }
                            }
                            ++n;
                        }
                        if (this.expressions.get(((String)object3).substring(n3, n)) == null) {
                            this.expressions.put(((String)object3).substring(n3, n), CharSet.parseString(((String)object3).substring(n3, n)));
                        }
                        n3 = n - 1;
                        break;
                    }
                    case '\\': {
                        c2 = ((String)object3).charAt(++n3);
                    }
                    default: {
                        this.expressions.put(((String)object3).substring(n3, n3 + 1), CharSet.parseString(((String)object3).substring(n3, n3 + 1)));
                    }
                }
                ++n3;
            }
            ++n4;
        }
        CharSet.releaseExpressionCache();
        this.categories = new Vector();
        if (this.ignoreChars != null) {
            this.categories.addElement(this.ignoreChars);
        } else {
            this.categories.addElement(new CharSet());
        }
        this.ignoreChars = null;
        this.mungeExpressionList(this.expressions);
        object3 = this.expressions.elements();
        while (object3.hasMoreElements()) {
            CharSet charSet2 = (CharSet)object3.nextElement();
            n = this.categories.size() - 1;
            while (!charSet2.empty() && n > 0) {
                object2 = (CharSet)this.categories.elementAt(n);
                if (!((CharSet)object2).intersection(charSet2).empty()) {
                    charSet = ((CharSet)object2).difference(charSet2);
                    if (!charSet.empty()) {
                        this.categories.addElement(charSet);
                    }
                    charSet = charSet2.intersection((CharSet)object2);
                    charSet2 = charSet2.difference((CharSet)object2);
                    if (!charSet.equals(object2)) {
                        this.categories.setElementAt(charSet, n);
                    }
                }
                --n;
            }
            if (charSet2.empty()) continue;
            this.categories.addElement(charSet2);
        }
        CharSet charSet3 = new CharSet();
        n = 1;
        while (n < this.categories.size()) {
            charSet3 = charSet3.union((CharSet)this.categories.elementAt(n));
            ++n;
        }
        CharSet charSet4 = (CharSet)this.categories.elementAt(0);
        charSet4 = charSet4.difference(charSet3);
        this.categories.setElementAt(charSet4, 0);
        object3 = this.expressions.keys();
        while (object3.hasMoreElements()) {
            object2 = (String)object3.nextElement();
            charSet = (CharSet)this.expressions.get(object2);
            object = new StringBuffer();
            int n5 = 0;
            while (n5 < this.categories.size()) {
                CharSet charSet5 = charSet.intersection((CharSet)this.categories.elementAt(n5));
                if (!charSet5.empty()) {
                    ((StringBuffer)object).append((char)(256 + n5));
                    if (charSet5.equals(charSet)) break;
                }
                ++n5;
            }
            this.expressions.put(object2, ((StringBuffer)object).toString());
        }
        RuleBasedBreakIterator.access$1(this.this$0, new CompactByteArray(0));
        int n6 = 0;
        while (n6 < this.categories.size()) {
            charSet = (CharSet)this.categories.elementAt(n6);
            object = charSet.getChars();
            while (object.hasMoreElements()) {
                char[] cArray = (char[])object.nextElement();
                if (n6 != 0) {
                    RuleBasedBreakIterator.access$2(this.this$0).setElementAt(cArray[0], cArray[1], (byte)n6);
                    continue;
                }
                RuleBasedBreakIterator.access$2(this.this$0).setElementAt(cArray[0], cArray[1], (byte)-1);
            }
            ++n6;
        }
        RuleBasedBreakIterator.access$2(this.this$0).compact();
        RuleBasedBreakIterator.access$3(this.this$0, this.categories.size());
    }

    protected void mungeExpressionList(Hashtable hashtable) {
    }

    private void buildStateTable(Vector vector) {
        this.tempStateTable = new Vector();
        this.tempStateTable.addElement(new short[RuleBasedBreakIterator.access$4(this.this$0) + 1]);
        this.tempStateTable.addElement(new short[RuleBasedBreakIterator.access$4(this.this$0) + 1]);
        int n = 0;
        while (n < vector.size()) {
            String string = (String)vector.elementAt(n);
            if (string.charAt(0) != '!') {
                this.parseRule(string, true);
            }
            ++n;
        }
        this.finishBuildingStateTable(true);
    }

    private void parseRule(String string, boolean bl) {
        short[] sArray;
        int n;
        int n2;
        int n3 = 0;
        int n4 = n2 = 1;
        String string2 = "";
        this.decisionPointStack = new Stack();
        this.decisionPointList = new Vector();
        this.loopingStates = new Vector();
        this.statesToBackfill = new Vector();
        boolean bl2 = false;
        if (!bl) {
            this.loopingStates.addElement(new Integer(1));
        }
        this.decisionPointList.addElement(new Integer(n2));
        n2 = this.tempStateTable.size() - 1;
        while (n3 < string.length()) {
            int n5;
            n = string.charAt(n3);
            this.clearLoopingStates = false;
            if (n == 91 || n == 92 || Character.isLetter((char)n) || Character.isDigit((char)n) || n < 32 || n == 46 || n >= 127) {
                int n6;
                if (n != 46) {
                    n6 = n3;
                    if (n == 92) {
                        n6 = n3 + 2;
                        ++n3;
                    } else if (n == 91) {
                        int n7 = 1;
                        while (n7 > 0) {
                            if ((n = string.charAt(++n6)) == 91) {
                                ++n7;
                                continue;
                            }
                            if (n == 93) {
                                --n7;
                                continue;
                            }
                            if (n != 92) continue;
                            ++n6;
                        }
                        ++n6;
                    } else {
                        n6 = n3 + 1;
                    }
                    string2 = (String)this.expressions.get(string.substring(n3, n6));
                    n3 = n6 - 1;
                } else {
                    n6 = (Integer)this.decisionPointList.lastElement();
                    sArray = (short[])this.tempStateTable.elementAt(n6);
                    if (n3 + 1 < string.length() && string.charAt(n3 + 1) == '*' && sArray[0] != 0) {
                        this.decisionPointList.addElement(new Integer(sArray[0]));
                        string2 = "";
                        ++n3;
                    } else {
                        StringBuffer stringBuffer = new StringBuffer();
                        n5 = 0;
                        while (n5 < RuleBasedBreakIterator.access$4(this.this$0)) {
                            stringBuffer.append((char)(n5 + 256));
                            ++n5;
                        }
                        string2 = stringBuffer.toString();
                    }
                }
                if (string2.length() != 0) {
                    if (n3 + 1 < string.length() && string.charAt(n3 + 1) == '*') {
                        this.decisionPointStack.push(this.decisionPointList.clone());
                    }
                    n6 = this.tempStateTable.size();
                    if (this.loopingStates.size() != 0) {
                        this.statesToBackfill.addElement(new Integer(n6));
                    }
                    sArray = new short[RuleBasedBreakIterator.access$4(this.this$0) + 1];
                    if (bl2) {
                        sArray[RuleBasedBreakIterator.access$4((RuleBasedBreakIterator)this.this$0)] = 16384;
                    }
                    this.tempStateTable.addElement(sArray);
                    this.updateStateTable(this.decisionPointList, string2, (short)n6);
                    this.decisionPointList.removeAllElements();
                    n4 = n2;
                    do {
                        this.decisionPointList.addElement(new Integer(++n2));
                    } while (n2 + 1 < this.tempStateTable.size());
                }
            } else if (n == 123) {
                this.decisionPointStack.push(this.decisionPointList.clone());
            } else if (n == 125 || n == 42) {
                if (n == 42) {
                    int n8 = n4 + 1;
                    while (n8 < this.tempStateTable.size()) {
                        Vector vector = new Vector();
                        vector.addElement(new Integer(n8));
                        this.updateStateTable(vector, string2, (short)(n4 + 1));
                        ++n8;
                    }
                }
                Vector vector = (Vector)this.decisionPointStack.pop();
                int n9 = 0;
                while (n9 < this.decisionPointList.size()) {
                    vector.addElement(this.decisionPointList.elementAt(n9));
                    ++n9;
                }
                this.decisionPointList = vector;
            } else if (n == 63) {
                this.setLoopingStates(this.decisionPointList, this.decisionPointList);
            } else if (n == 40) {
                this.tempStateTable.addElement(new short[RuleBasedBreakIterator.access$4(this.this$0) + 1]);
                n4 = n2++;
                this.decisionPointList.insertElementAt(new Integer(n2), 0);
                this.decisionPointStack.push(this.decisionPointList.clone());
                this.decisionPointStack.push(new Vector());
            } else if (n == 124) {
                Vector vector = (Vector)this.decisionPointStack.pop();
                Vector vector2 = (Vector)this.decisionPointStack.peek();
                this.decisionPointStack.push(vector);
                n5 = 0;
                while (n5 < this.decisionPointList.size()) {
                    vector.addElement(this.decisionPointList.elementAt(n5));
                    ++n5;
                }
                this.decisionPointList = (Vector)vector2.clone();
            } else if (n == 41) {
                Vector vector = (Vector)this.decisionPointStack.pop();
                int n10 = 0;
                while (n10 < this.decisionPointList.size()) {
                    vector.addElement(this.decisionPointList.elementAt(n10));
                    ++n10;
                }
                this.decisionPointList = vector;
                if (n3 + 1 >= string.length() || string.charAt(n3 + 1) != '*') {
                    this.decisionPointStack.pop();
                } else {
                    vector = (Vector)this.decisionPointList.clone();
                    Vector vector3 = (Vector)this.decisionPointStack.pop();
                    n5 = (Integer)vector3.firstElement();
                    short[] sArray2 = (short[])this.tempStateTable.elementAt(n5);
                    int n11 = 0;
                    while (n11 < this.decisionPointList.size()) {
                        vector3.addElement(this.decisionPointList.elementAt(n11));
                        ++n11;
                    }
                    this.decisionPointList = vector3;
                    n11 = 0;
                    while (n11 < sArray2.length) {
                        if (sArray2[n11] > n5) {
                            this.updateStateTable(vector, new Character((char)(n11 + 256)).toString(), sArray2[n11]);
                        }
                        ++n11;
                    }
                    n4 = n2;
                    n2 = this.tempStateTable.size() - 1;
                    ++n3;
                }
            } else if (n == 47) {
                bl2 = true;
                int n12 = 0;
                while (n12 < this.decisionPointList.size()) {
                    sArray = (short[])this.tempStateTable.elementAt((Integer)this.decisionPointList.elementAt(n12));
                    int n13 = RuleBasedBreakIterator.access$4(this.this$0);
                    sArray[n13] = (short)(sArray[n13] | 0x2000);
                    ++n12;
                }
            }
            if (this.clearLoopingStates) {
                this.setLoopingStates(null, this.decisionPointList);
            }
            ++n3;
        }
        this.setLoopingStates(null, this.decisionPointList);
        n = 0;
        while (n < this.decisionPointList.size()) {
            int n14 = (Integer)this.decisionPointList.elementAt(n);
            sArray = (short[])this.tempStateTable.elementAt(n14);
            int n15 = RuleBasedBreakIterator.access$4(this.this$0);
            sArray[n15] = (short)(sArray[n15] | 0x800000);
            if (bl2) {
                int n16 = RuleBasedBreakIterator.access$4(this.this$0);
                sArray[n16] = (short)(sArray[n16] | 0x2000);
            }
            ++n;
        }
    }

    private void updateStateTable(Vector vector, String string, short s) {
        short[] sArray = new short[RuleBasedBreakIterator.access$4(this.this$0) + 1];
        int n = 0;
        while (n < string.length()) {
            sArray[string.charAt((int)n) - 256] = s;
            ++n;
        }
        n = 0;
        while (n < vector.size()) {
            this.mergeStates((Integer)vector.elementAt(n), sArray, vector);
            ++n;
        }
    }

    private void mergeStates(int n, short[] sArray, Vector vector) {
        short[] sArray2 = (short[])this.tempStateTable.elementAt(n);
        boolean bl = this.loopingStates.contains(new Integer(n));
        int n2 = 0;
        while (n2 < sArray2.length) {
            if (sArray2[n2] != sArray[n2]) {
                if (bl && this.loopingStates.contains(new Integer(sArray2[n2]))) {
                    if (sArray[n2] != 0) {
                        if (sArray2[n2] == 0) {
                            this.clearLoopingStates = true;
                        }
                        sArray2[n2] = sArray[n2];
                    }
                } else if (sArray2[n2] == 0) {
                    sArray2[n2] = sArray[n2];
                } else if (n2 == RuleBasedBreakIterator.access$4(this.this$0)) {
                    sArray2[n2] = (short)(sArray[n2] & 0xE00000 | sArray2[n2]);
                } else if (sArray2[n2] != 0 && sArray[n2] != 0) {
                    int n3 = this.searchMergeList(sArray2[n2], sArray[n2]);
                    if (n3 != 0) {
                        sArray2[n2] = (short)n3;
                    } else {
                        int n4 = sArray2[n2];
                        int n5 = sArray[n2];
                        n3 = this.tempStateTable.size();
                        if (this.mergeList == null) {
                            this.mergeList = new Vector();
                        }
                        this.mergeList.addElement(new int[]{n4, n5, n3});
                        short[] sArray3 = new short[RuleBasedBreakIterator.access$4(this.this$0) + 1];
                        short[] sArray4 = (short[])this.tempStateTable.elementAt(n4);
                        System.arraycopy((Object)sArray4, 0, (Object)sArray3, 0, RuleBasedBreakIterator.access$4(this.this$0) + 1);
                        this.tempStateTable.addElement(sArray3);
                        sArray2[n2] = (short)n3;
                        if ((this.decisionPointList.contains(new Integer(n4)) || this.decisionPointList.contains(new Integer(n5))) && !this.decisionPointList.contains(new Integer(n3))) {
                            this.decisionPointList.addElement(new Integer(n3));
                        }
                        if ((vector.contains(new Integer(n4)) || vector.contains(new Integer(n5))) && !vector.contains(new Integer(n3))) {
                            this.decisionPointList.addElement(new Integer(n3));
                        }
                        int n6 = 0;
                        while (n6 < this.decisionPointStack.size()) {
                            Vector vector2 = (Vector)this.decisionPointStack.elementAt(n6);
                            if ((vector2.contains(new Integer(n4)) || vector2.contains(new Integer(n5))) && !vector2.contains(new Integer(n3))) {
                                vector2.addElement(new Integer(n3));
                            }
                            ++n6;
                        }
                        this.mergeStates(n3, (short[])this.tempStateTable.elementAt(sArray[n2]), vector);
                    }
                }
            }
            ++n2;
        }
    }

    private int searchMergeList(int n, int n2) {
        if (this.mergeList == null) {
            return 0;
        }
        int n3 = 0;
        while (n3 < this.mergeList.size()) {
            int[] nArray = (int[])this.mergeList.elementAt(n3);
            if (nArray[0] == n && nArray[1] == n2 || nArray[0] == n2 && nArray[1] == n) {
                return nArray[2];
            }
            if (nArray[2] == n && (nArray[0] == n2 || nArray[1] == n2)) {
                return nArray[2];
            }
            if (nArray[2] == n2 && (nArray[0] == n || nArray[1] == n)) {
                return nArray[2];
            }
            ++n3;
        }
        return 0;
    }

    private void setLoopingStates(Vector vector, Vector vector2) {
        if (!this.loopingStates.isEmpty()) {
            int n = (Integer)this.loopingStates.lastElement();
            int n2 = 0;
            while (n2 < vector2.size()) {
                this.eliminateBackfillStates((Integer)vector2.elementAt(n2));
                ++n2;
            }
            n2 = 0;
            while (n2 < this.statesToBackfill.size()) {
                int n3 = (Integer)this.statesToBackfill.elementAt(n2);
                short[] sArray = (short[])this.tempStateTable.elementAt(n3);
                sArray[RuleBasedBreakIterator.access$4((RuleBasedBreakIterator)this.this$0)] = (short)(sArray[RuleBasedBreakIterator.access$4(this.this$0)] & 0xE00000 | n);
                ++n2;
            }
            this.statesToBackfill.removeAllElements();
            this.loopingStates.removeAllElements();
        }
        if (vector != null) {
            this.loopingStates = (Vector)vector.clone();
        }
    }

    private void eliminateBackfillStates(int n) {
        if (this.statesToBackfill.contains(new Integer(n))) {
            this.statesToBackfill.removeElement(new Integer(n));
            short[] sArray = (short[])this.tempStateTable.elementAt(n);
            int n2 = 0;
            while (n2 < RuleBasedBreakIterator.access$4(this.this$0)) {
                if (sArray[n2] != 0) {
                    this.eliminateBackfillStates(sArray[n2]);
                }
                ++n2;
            }
        }
    }

    private void backfillLoopingStates() {
        short[] sArray = null;
        int n = 0;
        int n2 = 0;
        while (n2 < this.tempStateTable.size()) {
            short[] sArray2 = (short[])this.tempStateTable.elementAt(n2);
            int n3 = sArray2[RuleBasedBreakIterator.access$4(this.this$0)] & 0xFF1FFFFF;
            if (n3 > 0) {
                if (n3 != n) {
                    n = n3;
                    sArray = (short[])this.tempStateTable.elementAt(n);
                }
                int n4 = RuleBasedBreakIterator.access$4(this.this$0);
                sArray2[n4] = (short)(sArray2[n4] & 0xE00000);
                int n5 = 0;
                while (n5 < sArray2.length) {
                    if (sArray2[n5] == 0) {
                        sArray2[n5] = sArray[n5];
                    } else if (sArray2[n5] == 16384) {
                        sArray2[n5] = 0;
                    }
                    ++n5;
                }
            }
            ++n2;
        }
    }

    private void finishBuildingStateTable(boolean bl) {
        int n;
        int n2;
        short[] sArray;
        int n3;
        Object[] objectArray;
        int n4;
        this.backfillLoopingStates();
        int[] nArray = new int[this.tempStateTable.size()];
        Stack stack = new Stack();
        stack.push(new Integer(1));
        nArray[1] = 1;
        while (stack.size() != 0) {
            n4 = (Integer)stack.pop();
            objectArray = (short[])this.tempStateTable.elementAt(n4);
            n3 = 0;
            while (n3 < RuleBasedBreakIterator.access$4(this.this$0)) {
                if (objectArray[n3] != 0 && nArray[objectArray[n3]] == 0) {
                    nArray[objectArray[n3]] = objectArray[n3];
                    stack.push(new Integer(objectArray[n3]));
                }
                ++n3;
            }
        }
        objectArray = new int[this.tempStateTable.size()];
        n3 = RuleBasedBreakIterator.access$4(this.this$0) + 1;
        int n5 = 1;
        while (n5 < objectArray.length) {
            if (nArray[n5] != 0) {
                sArray = (short[])this.tempStateTable.elementAt(n5);
                n2 = 0;
                while (n2 < RuleBasedBreakIterator.access$4(this.this$0)) {
                    if (sArray[n2] != 0) {
                        int n6 = n5;
                        objectArray[n6] = objectArray[n6] + 1;
                    }
                    ++n2;
                }
                if (objectArray[n5] == 0) {
                    objectArray[n5] = n3;
                }
            }
            ++n5;
        }
        ++n3;
        do {
            n5 = 1;
            n2 = n3;
            while (n5 < n3) {
                short[] sArray2;
                boolean bl2 = false;
                sArray = sArray2 = (short[])null;
                int n7 = 0;
                while (n7 < objectArray.length) {
                    if (objectArray[n7] == n5) {
                        if (sArray == null) {
                            sArray = (short[])this.tempStateTable.elementAt(n7);
                        } else {
                            sArray2 = (short[])this.tempStateTable.elementAt(n7);
                            n = 0;
                            while (n < sArray2.length) {
                                if (n == RuleBasedBreakIterator.access$4(this.this$0) && sArray[n] != sArray2[n] && bl || n != RuleBasedBreakIterator.access$4(this.this$0) && objectArray[sArray[n]] != objectArray[sArray2[n]]) {
                                    objectArray[n7] = n3;
                                    bl2 = true;
                                    break;
                                }
                                ++n;
                            }
                        }
                    }
                    ++n7;
                }
                if (bl2) {
                    ++n3;
                }
                ++n5;
            }
        } while (n2 != n3);
        int[] nArray2 = new int[n3];
        n = 1;
        while (n < objectArray.length) {
            if (nArray2[objectArray[n]] == 0) {
                nArray2[objectArray[n]] = n;
            } else {
                nArray[n] = nArray2[objectArray[n]];
            }
            ++n;
        }
        n = 1;
        while (n < nArray.length) {
            if (nArray[n] != n) {
                this.tempStateTable.setElementAt(null, n);
            }
            ++n;
        }
        n4 = 1;
        n = 1;
        while (n < nArray.length) {
            if (this.tempStateTable.elementAt(n) != null) {
                nArray[n] = n4++;
            }
            ++n;
        }
        n = 1;
        while (n < nArray.length) {
            if (this.tempStateTable.elementAt(n) == null) {
                nArray[n] = nArray[nArray[n]];
            }
            ++n;
        }
        if (bl) {
            RuleBasedBreakIterator.access$5(this.this$0, new boolean[n4]);
            RuleBasedBreakIterator.access$6(this.this$0, new boolean[n4]);
            RuleBasedBreakIterator.access$7(this.this$0, new short[n4 * RuleBasedBreakIterator.access$4(this.this$0)]);
            n = 0;
            int n8 = 0;
            int n9 = 0;
            while (n9 < this.tempStateTable.size()) {
                short[] sArray3 = (short[])this.tempStateTable.elementAt(n9);
                if (sArray3 != null) {
                    int n10 = 0;
                    while (n10 < RuleBasedBreakIterator.access$4(this.this$0)) {
                        RuleBasedBreakIterator.access$8((RuleBasedBreakIterator)this.this$0)[n] = (short)nArray[sArray3[n10]];
                        ++n;
                        ++n10;
                    }
                    RuleBasedBreakIterator.access$9((RuleBasedBreakIterator)this.this$0)[n8] = (sArray3[RuleBasedBreakIterator.access$4(this.this$0)] & 0x800000) != 0;
                    RuleBasedBreakIterator.access$10((RuleBasedBreakIterator)this.this$0)[n8] = (sArray3[RuleBasedBreakIterator.access$4(this.this$0)] & 0x2000) != 0;
                    ++n8;
                }
                ++n9;
            }
        } else {
            RuleBasedBreakIterator.access$11(this.this$0, new short[n4 * RuleBasedBreakIterator.access$4(this.this$0)]);
            n = 0;
            int n11 = 0;
            while (n11 < this.tempStateTable.size()) {
                short[] sArray4 = (short[])this.tempStateTable.elementAt(n11);
                if (sArray4 != null) {
                    int n12 = 0;
                    while (n12 < RuleBasedBreakIterator.access$4(this.this$0)) {
                        RuleBasedBreakIterator.access$12((RuleBasedBreakIterator)this.this$0)[n] = (short)nArray[sArray4[n12]];
                        ++n;
                        ++n12;
                    }
                }
                ++n11;
            }
        }
    }

    private void buildBackwardsStateTable(Vector vector) {
        int n;
        this.tempStateTable = new Vector();
        this.tempStateTable.addElement(new short[RuleBasedBreakIterator.access$4(this.this$0) + 1]);
        this.tempStateTable.addElement(new short[RuleBasedBreakIterator.access$4(this.this$0) + 1]);
        int n2 = 0;
        while (n2 < vector.size()) {
            String string = (String)vector.elementAt(n2);
            if (string.charAt(0) == '!') {
                this.parseRule(string.substring(1), false);
            }
            ++n2;
        }
        this.backfillLoopingStates();
        n2 = this.tempStateTable.size();
        if (n2 > 2) {
            ++n2;
        }
        int n3 = 0;
        while (n3 < RuleBasedBreakIterator.access$4(this.this$0) + 1) {
            this.tempStateTable.addElement(new short[RuleBasedBreakIterator.access$4(this.this$0) + 1]);
            ++n3;
        }
        short[] sArray = (short[])this.tempStateTable.elementAt(n2 - 1);
        int n4 = 0;
        while (n4 < RuleBasedBreakIterator.access$4(this.this$0)) {
            sArray[n4] = (short)(n4 + n2);
            ++n4;
        }
        n4 = RuleBasedBreakIterator.access$8(this.this$0).length / RuleBasedBreakIterator.access$4(this.this$0);
        int n5 = 0;
        while (n5 < RuleBasedBreakIterator.access$4(this.this$0)) {
            int n6 = 0;
            while (n6 < n4) {
                n = this.this$0.lookupState(n6, n5);
                if (n != 0) {
                    int n7 = 0;
                    while (n7 < RuleBasedBreakIterator.access$4(this.this$0)) {
                        int n8 = this.this$0.lookupState(n, n7);
                        if (n8 != 0) {
                            sArray = (short[])this.tempStateTable.elementAt(n7 + n2);
                            sArray[n5] = (short)(n5 + n2);
                        }
                        ++n7;
                    }
                }
                ++n6;
            }
            ++n5;
        }
        if (n2 > 1) {
            sArray = (short[])this.tempStateTable.elementAt(1);
            n5 = n2 - 1;
            while (n5 < this.tempStateTable.size()) {
                short[] sArray2 = (short[])this.tempStateTable.elementAt(n5);
                n = 0;
                while (n < RuleBasedBreakIterator.access$4(this.this$0)) {
                    if (sArray[n] != 0 && sArray2[n] != 0) {
                        sArray2[n] = sArray[n];
                    }
                    ++n;
                }
                ++n5;
            }
            sArray = (short[])this.tempStateTable.elementAt(n2 - 1);
            n5 = 1;
            while (n5 < n2 - 1) {
                short[] sArray3 = (short[])this.tempStateTable.elementAt(n5);
                if ((sArray3[RuleBasedBreakIterator.access$4(this.this$0)] & 0x800000) == 0) {
                    n = 0;
                    while (n < RuleBasedBreakIterator.access$4(this.this$0)) {
                        if (sArray3[n] == 0) {
                            sArray3[n] = sArray[n];
                        }
                        ++n;
                    }
                }
                ++n5;
            }
        }
        this.finishBuildingStateTable(false);
    }

    protected void error(String string, int n, String string2) {
        throw new IllegalArgumentException(Msg.getString("K033b", new Object[]{new Integer(n), string, string2.substring(0, n), string2.substring(n)}));
    }
}

