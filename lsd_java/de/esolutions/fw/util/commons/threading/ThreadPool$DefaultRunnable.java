/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

import de.esolutions.fw.util.commons.threading.ThreadPool;

class ThreadPool$DefaultRunnable
implements Runnable {
    private final ThreadPool pool;
    private Runnable job;
    private int priority;
    private final int nr;

    ThreadPool$DefaultRunnable(ThreadPool threadPool, Runnable runnable, int n, int n2) {
        this.pool = threadPool;
        this.job = runnable;
        this.priority = n;
        this.nr = n2;
    }

    String getBaseThreadName() {
        return new StringBuffer().append("fw[").append(ThreadPool.access$100(this.pool)).append(':').append(this.nr).append(']').toString();
    }

    private void changeThreadName(Thread thread, boolean bl) {
        String string = "(idle)";
        if (bl) {
            thread.setName(new StringBuffer().append(this.getBaseThreadName()).append(string).toString());
        } else {
            thread.setName(this.getBaseThreadName());
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[TRYBLOCK]], but top level block is 28[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

