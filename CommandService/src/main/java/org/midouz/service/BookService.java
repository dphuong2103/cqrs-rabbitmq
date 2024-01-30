package org.midouz.service;

import lombok.RequiredArgsConstructor;
import org.midouz.config.RabbitMQConfig;
import org.midouz.dto.BookCreatedEvent;
import org.midouz.dto.CreateBookRequest;
import org.midouz.entity.Book;
import org.midouz.repository.BookRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    private final RabbitTemplate rabbitTemplate;
    public Book createBook(CreateBookRequest request){
        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .build();
        bookRepository.save(book);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY, BookCreatedEvent.fromEntity(book));
        return book;
    }
}
