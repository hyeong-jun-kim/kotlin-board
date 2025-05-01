package com.neo.board.adapter.out.persistence.mapper

import com.neo.board.adapter.out.persistence.mybatis.record.UserRecord
import com.neo.board.domain.model.entity.User

fun UserRecord.toDomain(): User {
    return User(id = this.id, name = this.name, email = this.email)
}

fun User.toRecord(): UserRecord {
    return UserRecord(id = this.id, name = this.name, email = this.email)
}