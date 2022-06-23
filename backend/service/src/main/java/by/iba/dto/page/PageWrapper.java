package by.iba.dto.page;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageWrapper<T> {

    private List<T> objects;

    private int totalPages;

    private long totalElements;
}
