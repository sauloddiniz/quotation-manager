package br.com.quotationmanager.exceptions;

import br.com.quotationmanager.utils.MessageUtils;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4485521137413783556L;

    public NotFoundException() {
        super(MessageUtils.NOT_FOUND_ERROR);
    }

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public NotFoundException(Exception ex) {
        super(ex);
    }
}