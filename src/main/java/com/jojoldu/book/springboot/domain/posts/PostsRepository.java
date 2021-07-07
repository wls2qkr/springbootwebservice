package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//보통 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자이며 JPA에선 Repository라고 부르며 인터페이스로 생성한다 <Entity, PK타입>
// Entity와 기본 Entity Repository는 함께 위치해야한다
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
