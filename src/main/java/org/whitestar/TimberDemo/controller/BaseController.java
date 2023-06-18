package org.whitestar.TimberDemo.controller;

import java.util.Optional;

public class BaseController {
    <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
