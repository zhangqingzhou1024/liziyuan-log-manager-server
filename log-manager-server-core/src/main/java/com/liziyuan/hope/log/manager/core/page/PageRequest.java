package com.liziyuan.hope.log.manager.core.page;

import java.io.Serializable;

public class PageRequest implements Pageable, Serializable {
    private final int page;
    private final int size;
    private final Sort sort;


    /**
     * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing
     * 0 for {@code page} will return the first page.
     *
     * @param size
     * @param page
     */
    public PageRequest(int page, int size) {

        this(page, size, null);
    }


    /**
     * Creates a new {@link PageRequest} with sort parameters applied.
     *
     * @param page
     * @param size
     * @param direction
     * @param properties
     */
    public PageRequest(int page, int size, Sort.Direction direction,
                       String... properties) {

        this(page, size, new Sort(direction, properties));
    }


    /**
     * Creates a new {@link PageRequest} with sort parameters applied.
     *
     * @param page
     * @param size
     * @param sort
     */
    public PageRequest(int page, int size, Sort sort) {

/*        if (0 > page) {
            throw new IllegalArgumentException(
                    "Page index must not be less than zero!");
        }

        if (0 >= size) {
            throw new IllegalArgumentException(
                    "Page size must not be less than or equal to zero!");
        }*/

        this.page = page;
        this.size = size;
        this.sort = sort;
    }


    /*
     * (non-Javadoc)
     *
     */
    public int getPageSize() {

        return size;
    }


    /*
     * (non-Javadoc)
     *
     */
    public int getPageNumber() {

        return page;
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Pageable#getFirstItem()
     */
    public int getOffset() {

        return page * size;
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Pageable#getSort()
     */
    public Sort getSort() {

        return sort;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageRequest)) {
            return false;
        }

        PageRequest that = (PageRequest) obj;

        boolean pageEqual = this.page == that.page;
        boolean sizeEqual = this.size == that.size;

        boolean sortEqual =
                this.sort == null ? that.sort == null : this.sort
                        .equals(that.sort);

        return pageEqual && sizeEqual && sortEqual;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + page;
        result = 31 * result + size;
        result = 31 * result + (null == sort ? 0 : sort.hashCode());

        return result;
    }
}
