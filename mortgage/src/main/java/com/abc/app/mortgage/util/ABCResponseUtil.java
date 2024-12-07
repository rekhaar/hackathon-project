package com.abc.app.mortgage.util;

import com.abc.app.mortgage.dto.ABCError;
import com.abc.app.mortgage.dto.ABCResponse;

public class ABCResponseUtil {
    public static ABCResponse error(ABCError abcError) {
        return new ABCResponse(abcError);
    }
}
