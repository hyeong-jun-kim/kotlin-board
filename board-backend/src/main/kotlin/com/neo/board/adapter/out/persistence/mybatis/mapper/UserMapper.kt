package com.neo.board.adapter.out.persistence.mybatis.mapper

import com.neo.board.adapter.out.persistence.mybatis.record.UserRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun insert(record: UserRecord): Long

    fun selectById(id: Long): UserRecord?

    fun update(record: UserRecord): Long

    fun delete(id: Long): Long
}