package org.example.backend;

import io.swagger.v3.oas.annotations.media.Schema;

public record GeneratePostRequestDto(@Schema(defaultValue = """
        I am taking part in Hacknarök in programming section with my team of 4 members,
        Adam, Karolia, Michał and Patryk. The It is 04 April 2024.
        The topic of category of programming section is -utrzymaj uwagę wikinga-
        """) String message, Boolean myStyle) {
}
