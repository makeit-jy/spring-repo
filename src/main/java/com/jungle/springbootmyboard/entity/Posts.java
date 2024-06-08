package com.jungle.springbootmyboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter // entity 에 Setter 사용하지 않는 것이 좋다. @Builder 고려하기
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id, @GeneratedValue 동시 사용 시, JPA가 기본 키를 자동 생성해줌.
    private Long id;

    @Column(nullable = false) // @Column: 객체 필드를 테이블의 컬럼으로 맵핑시키기
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 65535)
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}


