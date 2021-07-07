package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 롬복의 어노테이션 @Getter, @NoArgsConstructor : 코드를 단순화 시켜 주지만 필수 어노테이션은 아니다
@Getter
@NoArgsConstructor
// @Entity -> JPA의 어노테이션
@Entity
//Posts -> DB 테이블과 매칭될 클래스 Entity 클래스라고도 함
public class Posts {

    // @Id -> 해당 테이블의 PK 필드를 나타냄
    @Id
    // @GeneratedValue -> PK의 생성 규칙을 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column -> 테이블의 컬럼을 나타내며 굳이 선언하지 않아도 되지만, 기본값 외에 추가로 변경이 필요한 옵션에 사용한다
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // @Builder -> 해당 클래스의 빌더 패턴 클래스를 생성
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
