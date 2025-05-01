package com.neo.board.adapter.out.persistence.mybatis.record

data class UserRecord(
    var id: Long? = null,
    var name: String,
    var email: String
)
