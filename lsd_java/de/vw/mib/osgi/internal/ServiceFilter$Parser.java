/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Comparison$Equals;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Operation;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Operation$And;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Operation$Not;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Operation$Or;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Value;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Value$WildcardValue;
import java.util.Set;
import org.osgi.framework.InvalidSyntaxException;

class ServiceFilter$Parser {
    private int pos = 0;
    private char[] raw;
    private Set svcInterfaces;

    ServiceFilter$Parser() {
    }

    ServiceFilter$Condition parse(String string, Set set) {
        this.svcInterfaces = set;
        this.raw = string.toCharArray();
        this.skipWhitespace();
        ServiceFilter$Condition serviceFilter$Condition = this.parseTerm();
        if (!serviceFilter$Condition.hasDistinctServiceInterfaces()) {
            this.svcInterfaces.clear();
        }
        return serviceFilter$Condition;
    }

    private boolean isComparator() {
        return "=<>~".indexOf(this.raw[this.pos]) != -1;
    }

    private boolean isOperator() {
        return "&|!".indexOf(this.raw[this.pos]) != -1;
    }

    private boolean isWhitespace() {
        return Character.isWhitespace(this.raw[this.pos]);
    }

    private ServiceFilter$Condition parseComparison() {
        ServiceFilter$Condition$Comparison$Equals serviceFilter$Condition$Comparison$Equals;
        String string = this.parseProperty();
        this.skipWhitespace();
        switch (this.raw[this.pos]) {
            case '=': {
                ++this.pos;
                serviceFilter$Condition$Comparison$Equals = new ServiceFilter$Condition$Comparison$Equals();
                serviceFilter$Condition$Comparison$Equals.setProperty(string);
                break;
            }
            case '<': {
                throw new InvalidSyntaxException("filter syntax invalid: SMALLER-comparator '<' not supported", new String(this.raw));
            }
            case '>': {
                throw new InvalidSyntaxException("filter syntax invalid: GREATER-comparator '>' not supported", new String(this.raw));
            }
            case '~': {
                throw new InvalidSyntaxException("filter syntax invalid: SIMILAR-comparator '~' not supported", new String(this.raw));
            }
            default: {
                throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: comparator (i.e. '=', '<', '>' or '~') expected at position ").append(this.pos).toString(), new String(this.raw));
            }
        }
        this.skipWhitespace();
        ServiceFilter$Condition$Value value = this.parseValue();
        serviceFilter$Condition$Comparison$Equals.setValue(value);
        this.skipWhitespace();
        if (serviceFilter$Condition$Comparison$Equals.hasDistinctServiceInterfaces()) {
            this.svcInterfaces.add(serviceFilter$Condition$Comparison$Equals.getServiceInterface());
        }
        return serviceFilter$Condition$Comparison$Equals;
    }

    private ServiceFilter$Condition parseOperation() {
        ServiceFilter$Condition$Operation serviceFilter$Condition$Operation;
        int n = this.pos;
        char c2 = this.raw[this.pos];
        ++this.pos;
        this.skipWhitespace();
        if (c2 == '!') {
            serviceFilter$Condition$Operation = new ServiceFilter$Condition$Operation$Not();
            serviceFilter$Condition$Operation.addTerm(this.parseTerm());
            this.skipWhitespace();
            if (!this.termEnds()) {
                throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: ')' expected at position ").append(this.pos).toString(), new String(this.raw));
            }
        } else {
            if (c2 == '&') {
                serviceFilter$Condition$Operation = new ServiceFilter$Condition$Operation$And();
            } else if (c2 == '|') {
                serviceFilter$Condition$Operation = new ServiceFilter$Condition$Operation$Or();
            } else {
                throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: unsupported operator '").append(c2).append("'at position ").append(n).toString(), new String(this.raw));
            }
            while (!this.termEnds()) {
                serviceFilter$Condition$Operation.addTerm(this.parseTerm());
            }
        }
        return serviceFilter$Condition$Operation;
    }

    private String parseProperty() {
        int n = this.pos;
        while (!(this.isOperator() || this.isComparator() || this.termStarts() || this.termEnds() || this.isWhitespace())) {
            ++this.pos;
        }
        return new String(this.raw, n, this.pos - n);
    }

    private ServiceFilter$Condition parseTerm() {
        if (!this.termStarts()) {
            throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: '(' expected at position ").append(this.pos).toString(), new String(this.raw));
        }
        ++this.pos;
        this.skipWhitespace();
        ServiceFilter$Condition serviceFilter$Condition = this.isOperator() ? this.parseOperation() : this.parseComparison();
        this.skipWhitespace();
        if (!this.termEnds()) {
            throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: ')' expected at position ").append(this.pos).toString(), new String(this.raw));
        }
        ++this.pos;
        this.skipWhitespace();
        return serviceFilter$Condition;
    }

    private ServiceFilter$Condition$Value parseValue() {
        String string = this.parseProperty();
        if (string.indexOf(42) != -1) {
            return new ServiceFilter$Condition$Value$WildcardValue(new String(this.raw), string);
        }
        return new ServiceFilter$Condition$Value(string);
    }

    private void skipWhitespace() {
        while (this.pos < this.raw.length && this.isWhitespace()) {
            ++this.pos;
        }
    }

    private boolean termEnds() {
        return this.raw[this.pos] == ')';
    }

    private boolean termStarts() {
        return this.raw[this.pos] == '(';
    }
}

