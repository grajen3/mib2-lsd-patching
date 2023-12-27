/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main.rc;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.main.rc.ASLCalculatedRouteListElement;
import de.vw.mib.asl.internal.navigation.guidance.main.rc.RCAlternativeRouteDetailsModelNotifier;
import de.vw.mib.asl.internal.navigation.guidance.main.rc.RCProgressModelNotifier;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class RCProgressHandling {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(32, super.getClass().toString(), true);
    protected RCProgressModelNotifier rcProgressModelNotifier = new RCProgressModelNotifier();
    protected RCAlternativeRouteDetailsModelNotifier rcAlternativeRouteDetailModelNotifier = new RCAlternativeRouteDetailsModelNotifier();
    private ASLCalculatedRouteListElement[] aslElements;
    private boolean isCalculationFinished = false;
    private boolean isCalculationError = false;

    public void updateRouteCalculation(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.logger.trace(" updateRouteCalculation()");
        this.updateProgressAllRoutes(calculatedRouteListElementArray);
        if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0) {
            int n;
            if (this.aslElements == null || this.aslElements.length != calculatedRouteListElementArray.length) {
                this.aslElements = new ASLCalculatedRouteListElement[calculatedRouteListElementArray.length];
                for (n = 0; n < calculatedRouteListElementArray.length; ++n) {
                    this.aslElements[n] = this.createASLCalculatedRouteListElement(calculatedRouteListElementArray[n], n, calculatedRouteListElementArray.length == 1);
                    this.updateASLCalculatedRouteListElement(calculatedRouteListElementArray[n], n);
                    this.rcProgressModelNotifier.updateASLElementProgress(this.aslElements[n]);
                }
            } else {
                for (n = 0; n < this.aslElements.length; ++n) {
                    this.updateASLCalculatedRouteListElement(calculatedRouteListElementArray[n], n);
                    this.rcProgressModelNotifier.updateASLElementProgress(this.aslElements[n]);
                }
            }
            this.rcProgressModelNotifier.notifyModel();
            this.rcAlternativeRouteDetailModelNotifier.notifyModel();
            this.checkAllElementsFinished();
        }
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("ASLElements: [");
            for (int i2 = 0; i2 < this.aslElements.length; ++i2) {
                logMessage.append(this.aslElements[i2].toString());
            }
            logMessage.append("]");
            logMessage.log();
        }
    }

    private void updateProgressAllRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        if (calculatedRouteListElementArray != null) {
            int n = 0;
            for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                if (calculatedRouteListElementArray[i2] == null) continue;
                n += calculatedRouteListElementArray[i2].calculationPercentage;
            }
            if (calculatedRouteListElementArray.length > 0) {
                n /= calculatedRouteListElementArray.length;
            }
            AbstractASLHsmTarget.writeIntegerToDatapool(2112884736, n);
        }
    }

    private void updateASLCalculatedRouteListElement(CalculatedRouteListElement calculatedRouteListElement, int n) {
        this.logger.trace(" updateASLCalculatedRouteListElement()");
        this.aslElements[n].setCalculatedRouteListElement(calculatedRouteListElement);
        this.aslElements[n].setCalculationProgress(calculatedRouteListElement.calculationPercentage);
        int n2 = calculatedRouteListElement.getCalculationState();
        switch (n2) {
            case 3: {
                this.aslElements[n].setCalculationStateId(2);
                if (!this.aslElements[n].isNotify()) break;
                AbstractASLHsmTarget.writeIntegerToDatapool(803, this.aslElements[n].getCalculationStateFinishedId());
                this.aslElements[n].setNotify(false);
                break;
            }
            case 1: {
                this.aslElements[n].setCalculationStateId(1);
                break;
            }
            case 4: {
                this.aslElements[n].setCalculationStateId(0);
                this.isCalculationError = true;
                break;
            }
        }
        this.rcAlternativeRouteDetailModelNotifier.updateDetails(this.aslElements[n]);
        this.rcAlternativeRouteDetailModelNotifier.updateIcons(calculatedRouteListElement, this.aslElements[n].getModelCalculationIndex());
    }

    private ASLCalculatedRouteListElement createASLCalculatedRouteListElement(CalculatedRouteListElement calculatedRouteListElement, int n, boolean bl) {
        this.logger.trace(" createASLCalculatedRouteListElement()");
        ASLCalculatedRouteListElement aSLCalculatedRouteListElement = new ASLCalculatedRouteListElement();
        aSLCalculatedRouteListElement.setDsiCalculationIndex(n);
        if (bl) {
            aSLCalculatedRouteListElement.setModelCalculationIndex(0);
        } else {
            aSLCalculatedRouteListElement.setModelCalculationIndex(this.getModelIndexOfElement(n));
        }
        aSLCalculatedRouteListElement.setCalculationStateFinishedId(this.getModelCalculationStateId(n));
        aSLCalculatedRouteListElement.setNotify(true);
        return aSLCalculatedRouteListElement;
    }

    private int getModelIndexOfElement(int n) {
        int n2 = 0;
        n2 = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getModelIndexFromDsiIndex(n);
        return n2;
    }

    private int getModelCalculationStateId(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 5;
                break;
            }
            case 2: {
                n2 = 6;
                break;
            }
            case 3: {
                n2 = 7;
                break;
            }
            case 4: {
                n2 = 8;
                break;
            }
        }
        return n2;
    }

    private void checkAllElementsFinished() {
        this.logger.trace(" checkAllElementsFinished()");
        this.isCalculationFinished = true;
        if (this.aslElements != null) {
            for (int i2 = 0; i2 < this.aslElements.length; ++i2) {
                if (this.aslElements[i2].getCalculationStateId() == 2) continue;
                this.isCalculationFinished = false;
                break;
            }
        }
        if (this.logger.isTraceEnabled() && this.isCalculationFinished) {
            this.logger.trace(" All elements are calculted!");
        }
    }

    public void resetDefaults() {
        this.logger.trace(" resetDefaults()");
        this.rcAlternativeRouteDetailModelNotifier.resetToDefaultValues();
        this.rcProgressModelNotifier.reset();
        this.aslElements = null;
        this.isCalculationFinished = false;
        this.isCalculationError = false;
    }

    public boolean isCalculationFinished() {
        return this.isCalculationFinished;
    }

    public boolean isCalculationError() {
        return this.isCalculationError;
    }
}

