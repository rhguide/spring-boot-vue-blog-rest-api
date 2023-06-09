package com.codelaninja.blog.tag;

import com.codelaninja.blog.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "TAGS",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Tag {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts;
}
