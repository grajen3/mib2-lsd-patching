/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.testmode;

import de.vw.mib.asl.internal.impl.testmode.TestModeServicesImpl;
import de.vw.mib.asl.internal.testmode.TestModeServices;

public class TestModeServicesProvider {
    private static TestModeServices testModeServices;

    private TestModeServicesProvider() {
    }

    public static TestModeServices getTestModeServices() {
        if (testModeServices == null) {
            testModeServices = new TestModeServicesImpl();
        }
        return testModeServices;
    }

    public static void setTestModeServices(TestModeServices testModeServices) {
        TestModeServicesProvider.testModeServices = testModeServices;
    }
}

