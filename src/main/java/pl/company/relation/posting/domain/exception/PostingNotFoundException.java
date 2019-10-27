package pl.company.relation.posting.domain.exception;

import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(errorCode = "posting.notFound", statusCode = HttpStatus.NOT_FOUND)
public class PostingNotFoundException extends RuntimeException {
}
