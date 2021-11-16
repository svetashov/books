package com.example.books.specification;

import com.example.books.entity.Book;
import com.example.books.entity.Book_;
import com.example.books.model.BookSearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BookSpecification implements Specification<Book> {

    private final BookSearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        /*
            criteriaQuery = {
                SELECT ...
                FROM { root }
                ...
                WHERE { predicate (созданный с помощью criteriaBuilder) }
                ...
            }
        */
        Predicate predicate = criteriaBuilder.conjunction();
        if (criteria.getName() != null) {
            predicate.getExpressions().add(criteriaBuilder.like(root.get(Book_.NAME), "%" + criteria.getName() + "%"));
        }
        if (criteria.getYear() != null) {
            predicate.getExpressions().add(criteriaBuilder.equal(root.get(Book_.YEAR), criteria.getYear()));
        }
        if (criteria.getAuthorId() != null) {
            predicate.getExpressions().add(criteriaBuilder.equal(root.get(Book_.AUTHOR), criteria.getAuthorId()));
        }
        return predicate;
    }

}
