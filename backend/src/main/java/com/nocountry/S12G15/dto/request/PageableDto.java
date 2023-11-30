package com.nocountry.S12G15.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageableDto implements Pageable, Serializable {

    /*Para Cuando Implementos Swagger
     @Schema(description = "Página", example = "0",defaultValue = "0")
    private Integer page;
    @Schema(description = "Elementos por pagina",defaultValue = "4")
    private Integer size;
    @Schema(description = "Orden de los elementos",example = "0 DESC - 1 ASC",defaultValue = "0")
    private Integer order;
    @Schema(description = "Campo de la entidad a ordenar",defaultValue = "id")
    private String field;
    * */
    private Integer page;
    private Integer size;
    private Integer order;
    private String field;

    @JsonIgnore
    public Sort getSort() {
        if (field != null) {
            Sort.Direction direction = order == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
            return Sort.by(direction, field);
        }
        return Sort.unsorted();
    }

    @JsonIgnore
    @Override
    public Pageable next() {
        return null;
    }

    @JsonIgnore
    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @JsonIgnore
    @Override
    public Pageable first() {
        return null;
    }

    @JsonIgnore
    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @JsonIgnore
    @Override
    public boolean hasPrevious() {
        return false;
    }

    @JsonIgnore
    @Override
    public int getPageNumber() {
        return page;
    }

    @JsonIgnore
    @Override
    public boolean isPaged() {
        return Pageable.super.isPaged();
    }

    @JsonIgnore
    @Override
    public boolean isUnpaged() {
        return Pageable.super.isUnpaged();
    }

    @JsonIgnore
    @Override
    public Sort getSortOr(Sort sort) {
        return Pageable.super.getSortOr(sort);
    }

    @JsonIgnore
    @Override
    public int getPageSize() {
        return size;
    }

    @JsonIgnore
    @Override
    public long getOffset() {
        return (long) page * (long) size;
    }

}
