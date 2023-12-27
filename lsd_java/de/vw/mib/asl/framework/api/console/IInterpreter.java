/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.console;

import de.vw.mib.asl.framework.api.console.IItem;
import de.vw.mib.asl.framework.api.console.IObject;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;

public interface IInterpreter {
    default public void setStdin(InputStream inputStream) {
    }

    default public void setStdout(OutputStream outputStream) {
    }

    default public void setStderr(OutputStream outputStream) {
    }

    default public IObject eval(String string) {
    }

    default public IObject eval(IItem iItem) {
    }

    default public IItem compile(String string) {
    }

    default public boolean runInteractive(String string) {
    }

    default public void runInteractive() {
    }

    default public boolean execStream(InputStream inputStream) {
    }

    default public List getCompletionProposals(StringBuffer stringBuffer, int n) {
    }

    default public List getCompletionProposals(StringBuffer stringBuffer, int n, boolean bl) {
    }

    default public String[] stripOffLastCompletable(StringBuffer stringBuffer, int n) {
    }

    default public IObject makeString(String string) {
    }

    default public IObject makeInt(int n) {
    }

    default public IObject makeLong(long l) {
    }

    default public IObject makeLong(BigInteger bigInteger) {
    }

    default public IObject makeDict() {
    }

    default public IObject makeList() {
    }
}

