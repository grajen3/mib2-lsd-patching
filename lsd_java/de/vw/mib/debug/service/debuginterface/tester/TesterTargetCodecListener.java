/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.tester;

public interface TesterTargetCodecListener {
    default public void getWidgetCoordinates(int n, int n2) {
    }

    default public void getWidgetProperty(int n, int n2, String string) {
    }

    default public void pressSpellerButton(int n) {
    }

    default public void gotStartTestStatement(String string) {
    }

    default public void gotStopTestStatement(String string) {
    }

    default public void gotFailTestStatement(String string) {
    }

    default public void gotStartTestSuite(String string) {
    }

    default public void gotStopTestSuite(String string) {
    }

    default public void getStatemachineState(int n) {
    }

    default public void getASLListValues(int n) {
    }
}

