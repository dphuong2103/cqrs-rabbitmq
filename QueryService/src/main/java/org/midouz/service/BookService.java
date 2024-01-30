package org.midouz.service;

import lombok.RequiredArgsConstructor;
import org.midouz.config.RabbitMQConfig;
import org.midouz.dto.BookCreatedEvent;
import org.midouz.entity.Book;
import org.midouz.repository.BookRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    private final RabbitTemplate rabbitTemplate;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumer(BookCreatedEvent createdBook){
        Book book = Book.builder()
                .id(createdBook.getId())
                .title(createdBook.getTitle())
                .author(createdBook.getAuthor())
                .build();
        bookRepository.save(book);
    }
}
