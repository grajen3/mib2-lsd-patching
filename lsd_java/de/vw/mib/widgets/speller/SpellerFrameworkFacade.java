/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.speller.SpellerController;
import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.SpellerFrameworkFacade$BypassSpellerFilter;
import de.vw.mib.widgets.speller.SpellerFrameworkFacade$SpellerFilterHandler;
import de.vw.mib.widgets.speller.SpellerFrameworkFacade$SpellerFrameworkFacadeHolder;

public final class SpellerFrameworkFacade {
    private static final int LOG_CLASSIFIER;
    private static final String LOG_PREFIX;
    private static final Logger LOGGER;
    protected SpellerFilter filter;
    protected SpellerFrameworkFacade$SpellerFilterHandler filterHandler;
    protected AbstractSpellerModel speller;
    protected de.vw.mib.widgets.controller.SpellerController spellerController;
    protected SpellerController spellerService;

    public static SpellerFrameworkFacade getFacade(AbstractSpellerModel abstractSpellerModel) {
        return SpellerFrameworkFacade$SpellerFrameworkFacadeHolder.FACADE.setSpellerService(ServiceManager.spellerController).setSpeller(abstractSpellerModel);
    }

    protected SpellerFrameworkFacade() {
    }

    public SpellerFrameworkFacade setSpeller(AbstractSpellerModel abstractSpellerModel) {
        this.speller = abstractSpellerModel;
        this.spellerController = abstractSpellerModel != null ? (de.vw.mib.widgets.controller.SpellerController)abstractSpellerModel.getController() : null;
        return this;
    }

    public SpellerFrameworkFacade setSpellerService(SpellerController spellerController) {
        this.spellerService = spellerController;
        if (spellerController == null) {
            this.warn().append("'de.vw.mib.speller.SpellerController' undefined!").log();
        }
        return this;
    }

    public void deInitFilter() {
        if (this.filter != null) {
            this.filter.releaseFilter();
            this.filter = null;
            if (this.isTraceEnabled()) {
                this.trace().append("Filter released by '").append(this.speller.getQualifiedName()).append("'.").log();
            }
        }
        this.filterHandler = null;
    }

    public void filter(String[] stringArray) {
        if (this.filter == null) {
            this.initFilter();
        }
        if (this.filterHandler != null) {
            this.filterHandler.setNoneFilteredCharacters(stringArray);
        }
        if (stringArray != null && stringArray.length == 0 && this.filterHandler != null) {
            this.filterHandler.setFilteredCharacters(stringArray);
        } else if (this.filter != null) {
            this.filter.filterCharacters(stringArray);
        } else {
            this.error().append("No filter defined!").log();
        }
    }

    public void initFilter() {
        if (this.spellerService != null) {
            if (this.speller instanceof AsiaSpellerModel) {
                AsiaSpellerModel asiaSpellerModel = (AsiaSpellerModel)this.speller;
                this.filterHandler = new SpellerFrameworkFacade$SpellerFilterHandler(this, (AsiaSpellerController)asiaSpellerModel.getController());
                if (asiaSpellerModel.get_filterId() != -1) {
                    this.filter = this.spellerService.initSpellerFilter(asiaSpellerModel.get_filterId(), this.filterHandler);
                }
                if (this.filter == null) {
                    this.filter = new SpellerFrameworkFacade$BypassSpellerFilter();
                    this.filter.initFilter(this.filterHandler);
                    if (this.isTraceEnabled()) {
                        this.trace().append("No filter registered! Use local bypass filter instead.").log();
                    }
                } else if (this.isTraceEnabled()) {
                    this.trace().append("Filter initialized by '").append(asiaSpellerModel.getQualifiedName()).append("'.").log();
                }
            } else {
                this.warn().append("Speller undefined or filtering is supported by Asian spellers only!").log();
            }
        } else {
            this.warn().append("Unable to initialze speller filter, because of the missing service!").log();
        }
    }

    protected boolean isTraceEnabled() {
        return LOGGER.isTraceEnabled(64);
    }

    protected LogMessage trace() {
        return LOGGER.trace(64).append("[SpellerFrameworkFacade]: ");
    }

    protected LogMessage warn() {
        return LOGGER.warn(64).append("[SpellerFrameworkFacade]: ");
    }

    protected LogMessage error() {
        return LOGGER.error(64).append("[SpellerFrameworkFacade]: ");
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}

