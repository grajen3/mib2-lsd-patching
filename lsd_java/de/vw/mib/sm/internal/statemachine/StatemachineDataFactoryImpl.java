/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.error.HMIException;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.StatemachineFactory;
import de.vw.mib.sm.internal.SubStatemachineFactory;
import de.vw.mib.sm.internal.statemachine.InactiveDummyTopStatemachine;
import de.vw.mib.sm.internal.statemachine.MainStatemachineOrder;
import de.vw.mib.sm.internal.statemachine.MainStatemachineOrderUserDefinedBuilder;
import de.vw.mib.sm.internal.statemachine.StatemachineActivationGuardEvaluator;
import de.vw.mib.sm.internal.statemachine.StatemachinesResDataAccess;
import de.vw.mib.sm.internal.statemachine.SubStatemachine;
import de.vw.mib.sm.internal.statemachine.SubStatemachineDataImpl;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import de.vw.mib.sm.internal.statemachine.TopStatemachineDataImpl;
import java.io.File;
import java.io.IOException;

public class StatemachineDataFactoryImpl
implements StatemachineFactory,
SubStatemachineFactory {
    private static final short SPEECH_NONE;
    private final Logger logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
    private final StatemachinesResDataAccess dataAccess;

    public StatemachineDataFactoryImpl() {
        try {
            this.dataAccess = this.loadFactoryData();
        }
        catch (IOException iOException) {
            LogMessage logMessage = this.logger.error(1);
            logMessage.append("Failed to load Statemachine data from object swap: ");
            logMessage.append(ResData.getResFile(ServiceManagerCommon.configurationManager, "statemachines.res").getPath());
            logMessage.attachThrowable(iOException);
            logMessage.log();
            throw new HMIException("Failed to initialize 'statemachines'.", iOException);
        }
    }

    public StatemachinesResDataAccess getDataAccess() {
        return this.dataAccess;
    }

    private StatemachinesResDataAccess loadFactoryData() {
        File file = ResData.getResFile(ServiceManagerCommon.configurationManager, "statemachines.res");
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(3, 2, 1);
        }
        Object[] objectArray = ResData.loadAndCheck(ServiceManagerCommon.fileManager, file, MagicNumber.STATEMACHINES_RES, ServiceManagerStatemachine.smChecksum, 0xEEEAE0A, this.logger, 4);
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(3, 2, 2);
        }
        return new StatemachinesResDataAccess(objectArray);
    }

    @Override
    public TopStatemachine[] createStatemachines(boolean bl, StatemachineActivationGuardEvaluator statemachineActivationGuardEvaluator) {
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(3, 1, 1);
        }
        int n = this.dataAccess.getTopStatemachines_size();
        TopStatemachine[] topStatemachineArray = new TopStatemachine[n];
        byte[] byArray = this.dataAccess.getTopStatemachines_Kind();
        short s = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            if (statemachineActivationGuardEvaluator.statemachineShallBeStarted(i2)) {
                this.debug(new StringBuffer().append("Creating statemachine ").append(i2).append(".").toString());
                if (StatemachineDataFactoryImpl.isSet(byArray[i2], 8)) {
                    short s2 = s;
                    s = (short)(s + 1);
                    topStatemachineArray[i2] = new TopStatemachineDataImpl(i2, this.dataAccess, s2, bl);
                    continue;
                }
                topStatemachineArray[i2] = new TopStatemachineDataImpl(i2, this.dataAccess, -1, bl);
                continue;
            }
            this.debug(new StringBuffer().append("Statemachine ").append(i2).append(" is not being created due to guard evaluating to false.").toString());
            topStatemachineArray[i2] = InactiveDummyTopStatemachine.INSTANCE;
        }
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(3, 1, 2);
        }
        return topStatemachineArray;
    }

    private void debug(String string) {
        if (this.logger.isTraceEnabled(3)) {
            this.logger.trace(3, string);
        }
    }

    private static boolean isSet(int n, int n2) {
        return (n & n2) == n2;
    }

    @Override
    public SubStatemachine createSubStatemachine(int n, TopStatemachine topStatemachine) {
        return new SubStatemachineDataImpl(n, this.dataAccess, topStatemachine);
    }

    @Override
    public MainStatemachineOrder createMainStatemachineOrder() {
        short[] sArray;
        Object object;
        String string = System.getProperty("main.statemachine.start.and.dispatch.order");
        if (string != null && (object = (Object)new MainStatemachineOrderUserDefinedBuilder(this.logger).build(string, sArray = this.dataAccess.getTopStatemachines_StatemachineId())) != null) {
            return object;
        }
        sArray = this.dataAccess.getTopStatemachines_Category();
        object = this.dataAccess.getTopStatemachines_SubPriority();
        MainStatemachineOrder mainStatemachineOrder = new MainStatemachineOrder(sArray, (short[])object);
        return mainStatemachineOrder;
    }
}

