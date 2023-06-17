package com.vagdeviitsol.fitwala;

public class SpecSearchCriteria<SearchOperation> {

	private String key;
    private SearchOperation operation;
    private Object value;
    private boolean orPredicate;

    public boolean isOrPredicate() {
        return orPredicate;
    }
}
