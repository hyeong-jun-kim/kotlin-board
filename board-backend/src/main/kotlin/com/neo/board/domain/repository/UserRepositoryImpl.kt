package com.neo.board.domain.repository

import com.neo.board.adapter.out.persistence.mapper.toDomain
import com.neo.board.adapter.out.persistence.mapper.toRecord
import com.neo.board.adapter.out.persistence.mybatis.mapper.UserMapper
import com.neo.board.domain.model.entity.User
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userMapper: UserMapper
) : UserRepository {

    override fun save(user: User): Long {
        val record = user.toRecord()
        userMapper.insert(record)
        return record.id!!
    }

    override fun findById(id: Long): User? {
        val record = userMapper.selectById(id)
        return record?.toDomain()
    }

    override fun update(user: User): Long {
        val record = user.toRecord()
        userMapper.update(record)
        return record.id!!
    }

    override fun deleteById(id: Long): Long {
        return userMapper.delete(id)
    }
}