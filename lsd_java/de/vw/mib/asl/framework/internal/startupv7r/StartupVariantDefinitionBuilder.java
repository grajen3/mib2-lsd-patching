/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.IntegerInputStream;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.activators.ASLBasicActivator;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.SpecialWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodInitialStartupProfileReady;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodLumReady;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodReadCoding;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForCodingWasRead;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForLateLoadFinished;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForNavToFinish;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import java.util.StringTokenizer;

public class StartupVariantDefinitionBuilder {
    private final StartupServices startupServices;
    private final Logger logger;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private IntObjectOptHashMap workUnitPreconditionsMap = new IntObjectOptHashMap();
    private IntIntOptHashMap idMapping = new IntIntOptHashMap(3);
    private AbstractWorkUnit[] workUnitPool;

    public StartupVariantDefinitionBuilder(StartupServices startupServices) {
        this.startupServices = startupServices;
        this.logger = startupServices.getLogger();
        this.configurationManagerDiag = startupServices.getConfigurationManagerDiag();
    }

    public AbstractWorkUnit[] buildStartupDefinitionFromStream(int[] nArray) {
        this.readIdMappingsFromProperties();
        IntegerInputStream integerInputStream = new IntegerInputStream(nArray);
        int n = -integerInputStream.read();
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1).append("Reading startup work unit data (version ").append(n).append(")").log();
        }
        this.workUnitPool = new AbstractWorkUnit[integerInputStream.read()];
        int n2 = 0;
        IntBooleanOptHashMap intBooleanOptHashMap = new IntBooleanOptHashMap();
        while (integerInputStream.available() > 0) {
            ContextWorkUnit contextWorkUnit = new ContextWorkUnit();
            int n3 = this.readSpecialMethodDeclaration(integerInputStream);
            this.readFeatureFlag(integerInputStream, contextWorkUnit);
            this.readDSI(integerInputStream, contextWorkUnit, n);
            this.readASLTargets(integerInputStream, contextWorkUnit, n);
            this.readASLComponents(integerInputStream, contextWorkUnit);
            this.readDomain(integerInputStream, contextWorkUnit);
            this.readDatapoolValue(integerInputStream, contextWorkUnit);
            this.readPersistence(integerInputStream, contextWorkUnit, intBooleanOptHashMap);
            this.readMultiplePreconditions(integerInputStream, n2);
            SpecialWorkUnit specialWorkUnit = this.overrideIfSpecialWorkUnit(n2, n3);
            this.readExitCondition(integerInputStream, contextWorkUnit);
            this.readEntryCondition(integerInputStream, contextWorkUnit, n2, n3);
            if (n > 6) {
                this.readDynamicFlag(integerInputStream, contextWorkUnit);
            }
            if (specialWorkUnit != null) {
                specialWorkUnit.setFeatureFlag(contextWorkUnit.getFeatureFlag());
            }
            ++n2;
        }
        this.linkWorkUnitPreconditions();
        return this.workUnitPool;
    }

    private void readDynamicFlag(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit) {
        boolean bl = integerInputStream.readBoolean();
        contextWorkUnit.setDynamic(bl);
    }

    private void readMultiplePreconditions(IntegerInputStream integerInputStream, int n) {
        int n2 = integerInputStream.read();
        if (n2 == 0) {
            return;
        }
        int[] nArray = new int[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = integerInputStream.read();
            if (n3 == 0) continue;
            nArray[i2] = n3 - 1;
        }
        this.workUnitPreconditionsMap.put(n, nArray);
    }

    private void readSinglePrecondition(IntegerInputStream integerInputStream, int n) {
        int n2 = integerInputStream.read();
        if (n2 != 0) {
            this.workUnitPreconditionsMap.put(n, new int[]{n2 - 1});
        }
    }

    private void linkWorkUnitPreconditions() {
        for (int i2 = 0; i2 < this.workUnitPool.length; ++i2) {
            if (!this.workUnitPreconditionsMap.containsKey(i2)) continue;
            int[] nArray = (int[])this.workUnitPreconditionsMap.get(i2);
            AbstractWorkUnit[] abstractWorkUnitArray = new AbstractWorkUnit[nArray.length];
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                abstractWorkUnitArray[i3] = this.workUnitPool[nArray[i3]];
            }
            this.workUnitPool[i2].setPreconditions(abstractWorkUnitArray);
        }
    }

    private int readSpecialMethodDeclaration(IntegerInputStream integerInputStream) {
        int n = integerInputStream.read();
        return n;
    }

    private SpecialWorkUnit overrideIfSpecialWorkUnit(int n, int n2) {
        if (n2 != 0) {
            SpecialWorkUnit specialWorkUnit = this.dispatchSpecialMethodUnitDeclaration(n2 - 1);
            if (specialWorkUnit == null) {
                this.logger.fatal(1, "ASLStartupV8: SpecialMethodUnit was not recognized!!!- Startup compromised .. HALTING HERE");
            } else {
                this.workUnitPool[n] = specialWorkUnit;
                return specialWorkUnit;
            }
        }
        return null;
    }

    private void readEntryCondition(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit, int n, int n2) {
        contextWorkUnit.setBitmaskToCheckForSpecialEntryConditions(integerInputStream.read());
        if (n2 == 0) {
            contextWorkUnit.setName(this.configurationManagerDiag.getWorkUnitName(n + 1));
            this.workUnitPool[n] = contextWorkUnit;
        }
    }

    private void readFeatureFlag(IntegerInputStream integerInputStream, AbstractWorkUnit abstractWorkUnit) {
        abstractWorkUnit.setFeatureFlag(integerInputStream.read());
    }

    private void readExitCondition(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit) {
        contextWorkUnit.setBitmaskToCheckForSpecialExitConditions(integerInputStream.read());
    }

    private void readPersistence(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit, IntBooleanMap intBooleanMap) {
        int n = integerInputStream.read();
        if (n > 0) {
            int[] nArray = new int[n];
            for (int i2 = 0; i2 < n; ++i2) {
                int n2 = integerInputStream.read();
                boolean bl = integerInputStream.readBoolean();
                nArray[i2] = n2;
                intBooleanMap.put(n2, bl);
            }
            contextWorkUnit.setPersistenceIdsForContext(nArray);
        }
    }

    private void readDomain(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit) {
        int n = integerInputStream.read();
        if (n > 0) {
            int[] nArray = new int[n];
            int[] nArray2 = new int[n];
            boolean[] blArray = new boolean[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nArray[i2] = integerInputStream.read();
                nArray2[i2] = integerInputStream.read();
                blArray[i2] = integerInputStream.readBoolean();
            }
            contextWorkUnit.setDomainToStart(nArray);
            contextWorkUnit.setDomainStateToReach(nArray2);
            contextWorkUnit.setDomainDoNotWaitFlags(blArray);
        }
    }

    private void readDatapoolValue(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit) {
        contextWorkUnit.setListenerConstantForUpdateToHmi(integerInputStream.read());
    }

    private void readASLComponents(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit) {
        int n = integerInputStream.read();
        if (n > 0) {
            String[] stringArray = new String[n];
            String[] stringArray2 = new String[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stringArray[i2] = this.configurationManagerDiag.getAslStartupString(integerInputStream.read());
                stringArray2[i2] = this.configurationManagerDiag.getAslStartupString(integerInputStream.read());
            }
            contextWorkUnit.setAslComponentQualifiedNames(stringArray);
            contextWorkUnit.setAslComponentNames(stringArray2);
        }
    }

    private void readASLTargets(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit, int n) {
        int n2 = integerInputStream.read();
        if (n2 > 0) {
            int[] nArray = new int[n2];
            int[] nArray2 = new int[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                nArray[i2] = integerInputStream.read();
                nArray2[i2] = integerInputStream.read();
                if (n > 7) {
                    integerInputStream.read();
                }
                ASLBasicActivator.fillTargetId2ClassNameMatchingTable(nArray2[i2], this.configurationManagerDiag.getAslTargetQualifiedName(nArray[i2]));
            }
            contextWorkUnit.setAslTargetsToStart(nArray2);
        }
    }

    private void readDSI(IntegerInputStream integerInputStream, ContextWorkUnit contextWorkUnit, int n) {
        int n2 = integerInputStream.read();
        if (n2 > 0) {
            boolean[] blArray = new boolean[n2];
            int[] nArray = new int[n2 * 2];
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                nArray[n3++] = integerInputStream.read();
                nArray[n3++] = integerInputStream.read();
                blArray[i2] = integerInputStream.readBoolean();
                if (n <= 7) continue;
                integerInputStream.read();
            }
            contextWorkUnit.setDsiDoNotWaitFlags(blArray);
            contextWorkUnit.setDsiInterfacesToStart(nArray);
        }
    }

    private SpecialWorkUnit dispatchSpecialMethodUnitDeclaration(int n) {
        switch (n) {
            case 1: {
                return this.createSpecialWorkUnit("SPECIAL_METHOD_GET_LUM__GENERIC", new SpecialMethodLumReady(this.startupServices));
            }
            case 5: {
                return this.createSpecialWorkUnit("SPECIAL_METHOD_WAIT_FOR_LATELOAD_FINISHED_TO_START_ONLINE_SERVICES__HIGH_ESO", new SpecialMethodWaitForLateLoadFinished(this.startupServices.getLogger(), this.startupServices.getStartupStateService()));
            }
            case 12: {
                return this.createSpecialWorkUnit("SPECIAL_METHOD_WAITFOR_NAV_TO_FINISH_TO_CONTINUE_STARTUP__HIGH_ESO", new SpecialMethodWaitForNavToFinish(this.startupServices));
            }
            case 11: {
                return this.createSpecialWorkUnit("SPECIAL_METHOD_WAITFOR_NAV_TO_FINISH_TO_CONTINUE_STARTUP__STD_SOP1U_SOP2", new SpecialMethodWaitForNavToFinish(this.startupServices));
            }
            case 14: {
                return this.createSpecialWorkUnit("SPECIAL_METHOD_WAIT_FOR_CODING_WAS_READ__GENERIC", new SpecialMethodWaitForCodingWasRead(this.startupServices));
            }
            case 15: {
                return this.createSpecialWorkUnit("SPECIAL_METHOD_READ_CODING__GENERIC", new SpecialMethodReadCoding(this.startupServices.getDiagnosisAPI(), this.startupServices.getLogger()));
            }
            case 16: {
                return this.createSpecialWorkUnit("SPECIAL_METHOD_INITIAL_STARTUP_PROFILE_READY", new SpecialMethodInitialStartupProfileReady(this.startupServices));
            }
        }
        return null;
    }

    private SpecialWorkUnit createSpecialWorkUnit(String string, AbstractStartupTask abstractStartupTask) {
        SpecialWorkUnit specialWorkUnit = new SpecialWorkUnit();
        specialWorkUnit.setSpecialMethod(abstractStartupTask);
        specialWorkUnit.setName(string);
        return specialWorkUnit;
    }

    private void readIdMappingsFromProperties() {
        String string = System.getProperty("de.vw.mib.asl.framework.internal.startupv8.mapped.ids");
        if (null == string) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String string2 = stringTokenizer.nextToken();
            this.idMapping.put(Integer.parseInt(string2.substring(0, string2.indexOf("|"))), Integer.parseInt(string2.substring(string2.indexOf("|") + 1)));
        }
    }
}

