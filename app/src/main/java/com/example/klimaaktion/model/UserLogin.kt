package com.example.klimaaktion.model

data class UserLoginInput(
    val username: String,
    val password: String
) {
    fun validate(): String? {
        // Check if either field is empty
        if (username.isBlank()) {
            return "Brugernavn skal udfyldes"
        }

        if (password.isBlank()) {
            return "Adgangskode skal udfyldes"
        }

        // Check password length
        if (password.length < 6) {
            return "Adgangskoden skal være mindst 6 tegn"
        }

        // Disallow spaces in password
        if (password.contains(" ")) {
            return "Adgangskoden må ikke indeholde mellemrum"
        }

        // All good
        return null
    }
}
