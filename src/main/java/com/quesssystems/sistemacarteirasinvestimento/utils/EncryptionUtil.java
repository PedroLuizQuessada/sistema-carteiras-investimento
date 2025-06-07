package com.quesssystems.sistemacarteirasinvestimento.utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class EncryptionUtil {
    public static String encodeSha256(String originalString) {
        return Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();
    }
}
