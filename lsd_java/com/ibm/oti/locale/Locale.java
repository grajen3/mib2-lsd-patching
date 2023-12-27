/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.locale;

import com.ibm.oti.util.ExtendedResourceBundle;

public class Locale
extends ExtendedResourceBundle {
    public static final Integer FIRST_DAY = new Integer(0);
    public static final Integer MINIMAL_DAYS = new Integer(1);
    public static final Integer LOCALE_PATTERN_CHARS = new Integer(2);
    public static final Integer AM_PM = new Integer(3);
    public static final Integer ERAS = new Integer(4);
    public static final Integer MONTHS = new Integer(5);
    public static final Integer SHORT_MONTHS = new Integer(6);
    public static final Integer WEEK_DAYS = new Integer(7);
    public static final Integer SHORT_WEEK_DAYS = new Integer(8);
    public static final Integer TIMEZONES = new Integer(9);
    public static final Integer DATE_SHORT = new Integer(10);
    public static final Integer DATE_MEDIUM = new Integer(11);
    public static final Integer DATE_LONG = new Integer(12);
    public static final Integer DATE_FULL = new Integer(13);
    public static final Integer TIME_SHORT = new Integer(14);
    public static final Integer TIME_MEDIUM = new Integer(15);
    public static final Integer TIME_LONG = new Integer(16);
    public static final Integer TIME_FULL = new Integer(17);
    public static final Integer DECIMAL_PATTERN_CHARS = new Integer(18);
    public static final Integer INFINITY = new Integer(19);
    public static final Integer NAN = new Integer(20);
    public static final Integer CURRENCY_SYMBOL = new Integer(21);
    public static final Integer INTL_CURRENCY_SYMBOL = new Integer(22);
    public static final Integer NUMBER = new Integer(23);
    public static final Integer INTEGER = new Integer(24);
    public static final Integer CURRENCY = new Integer(25);
    public static final Integer PERCENT = new Integer(26);
    public static final Integer COLLATION = new Integer(27);
    public static final Integer COUNTRYNAME = new Integer(28);
    public static final Integer LANGUAGENAME = new Integer(29);
    public static final Integer COLLATIONDECOMP = new Integer(30);

    /*
     * Exception decompiling
     */
    @Override
    protected Object[][] getContents() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op2rewriters.Op02RedundantStoreRewriter.removeOverwrittenStores(Op02RedundantStoreRewriter.java:92)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op2rewriters.Op02RedundantStoreRewriter.rewrite(Op02RedundantStoreRewriter.java:197)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:426)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

