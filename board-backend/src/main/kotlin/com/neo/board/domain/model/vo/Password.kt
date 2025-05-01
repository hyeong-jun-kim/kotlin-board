package com.neo.board.domain.model.vo

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

data class Password private constructor(val hash: String) {
    companion object {
        private val encoder = BCryptPasswordEncoder
        fun of(hash: String): Password {
            return Password(hash)
        }
    }

    override fun toString(): String {
        return hash
    }
}
