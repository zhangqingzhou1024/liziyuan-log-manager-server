package com.liziyuan.hope.log.manager.core.page;

public interface Pageable {
    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    int getPageNumber();


    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page
     */
    int getPageSize();


    /**
     * Returns the offset to be taken according to the underlying page and page
     * size.
     *
     * @return the offset to be taken
     */
    int getOffset();


    /**
     * Returns the sorting parameters.
     *
     * @return
     */
    Sort getSort();
}
