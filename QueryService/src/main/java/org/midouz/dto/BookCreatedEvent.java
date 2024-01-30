package org.midouz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.midouz.entity.Book;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreatedEvent {
    private Long id;
    private String title;
    private String author;

    public static BookCreatedEvent fromEntity(Book book) {
        return BookCreatedEvent.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }
}
