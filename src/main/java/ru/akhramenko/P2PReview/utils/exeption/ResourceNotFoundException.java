package ru.akhramenko.P2PReview.utils.exeption;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    private static final String ID_PREFIX = "Resource wasn't found by id: %s";

    public ResourceNotFoundException(UUID id) {
        super(String.format(ID_PREFIX, id));
    }
}
