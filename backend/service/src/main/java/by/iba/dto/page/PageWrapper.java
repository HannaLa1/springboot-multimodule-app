package by.iba.dto.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageWrapper<T> {

    private List<T> objects;
    private int totalPages;
    private long totalElements;
    private int page;
    private int elementsCount;

    public static <T> PageWrapper<T> of(List<T> objects,
                                        int totalPages,
                                        long totalElements,
                                        int page,
                                        int elementsCount) {
        return new PageWrapper<>(objects, totalPages, totalElements, page, elementsCount);
    }

}
