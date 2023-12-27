/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.tester;

import de.vw.mib.debug.service.debuginterface.tester.TesterTargetCodecListener;

public class TesterTargetCodecAdapter
implements TesterTargetCodecListener {
    public void errorGettingWidgetCoordinates() {
    }

    public void gotWidgetCoordinates(int n, int n2, int n3, int n4) {
    }

    public void errorGettingWidgetProperty() {
    }

    @Override
    public void pressSpellerButton(int n) {
    }

    @Override
    public void getWidgetCoordinates(int n, int n2) {
    }

    @Override
    public void getWidgetProperty(int n, int n2, String string) {
    }

    @Override
    public void getASLListValues(int n) {
    }

    public void gotASLListValues(int n, String[][] stringArray) {
    }

    @Override
    public void gotStartTestStatement(String string) {
    }

    @Override
    public void gotStopTestStatement(String string) {
    }

    @Override
    public void gotStartTestSuite(String string) {
    }

    @Override
    public void gotStopTestSuite(String string) {
    }

    @Override
    public void getStatemachineState(int n) {
    }

    public void gotStatemachineState(int n, int n2, int n3) {
    }

    public void gotWidgetProperty(Object object) {
    }

    public void unknownRequestTypeReceived(byte by) {
    }

    public void gotUnknownRequestTypeAnswer(byte by) {
    }

    public void errorWidgetInvisible() {
    }

    @Override
    public void gotFailTestStatement(String string) {
    }
}

