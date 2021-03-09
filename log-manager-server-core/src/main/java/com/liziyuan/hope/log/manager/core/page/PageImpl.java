package com.liziyuan.hope.log.manager.core.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PageImpl<T> implements Page<T>, Serializable {
    private final List<T> content = new ArrayList<T>();
    private final Pageable pageable;
    private final long total;


    /**
     * Constructor of {@code PageImpl}.
     *
     * @param content	the content of this page
     * @param pageable the paging information
     * @param total		the total amount of items available
     */
    public PageImpl(List<T> content, Pageable pageable, long total) {

        if (null == content) {
            throw new IllegalArgumentException("Content must not be null!");
        }

        this.content.addAll(content);
        this.total = total;
        this.pageable = pageable;
    }


    /**
     * Creates a new {@link PageImpl} with the given content. This will result
     * in the created {@link Page} being identical to the entire {@link List}.
     *
     * @param content
     */
    public PageImpl(List<T> content) {

        this(content, null, (null == content) ? 0 : content.size());
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#getNumber()
     */
    public int getNumber() {

        return pageable == null ? 0 : pageable.getPageNumber();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#getSize()
     */
    public int getSize() {

        return pageable == null ? 0 : pageable.getPageSize();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#getTotalPages()
     */
    public int getTotalPages() {

        return getSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getSize());
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#getNumberOfElements()
     */
    public int getNumberOfElements() {

        return content.size();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#getTotalElements()
     */
    public long getTotalElements() {

        return total;
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#hasPreviousPage()
     */
    public boolean hasPreviousPage() {

        return getNumber() > 1;
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#isFirstPage()
     */
    public boolean isFirstPage() {

        return !hasPreviousPage();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#hasNextPage()
     */
    public boolean hasNextPage() {

        return ((getNumber() + 1) * getSize()) < total;
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#isLastPage()
     */
    public boolean isLastPage() {

        return !hasNextPage();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#iterator()
     */
    public Iterator<T> iterator() {

        return content.iterator();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#asList()
     */
    public List<T> getContent() {

        return Collections.unmodifiableList(content);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#hasContent()
     */
    public boolean hasContent() {

        return !content.isEmpty();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.liziyuan.platform.page.Page#getSort()
     */
    public Sort getSort() {

        return pageable == null ? null : pageable.getSort();
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String contentType = "UNKNOWN";

        if (content.size() > 0) {
            contentType = content.get(0).getClass().getName();
        }

        return String.format("Page %s of %d containing %s instances",
                getNumber(), getTotalPages(), contentType);
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageImpl<?>)) {
            return false;
        }

        PageImpl<?> that = (PageImpl<?>) obj;

        boolean totalEqual = this.total == that.total;
        boolean contentEqual = this.content.equals(that.content);
        boolean pageableEqual = this.pageable == null ? that.pageable == null : this.pageable.equals(that.pageable);

        return totalEqual && contentEqual && pageableEqual;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + (int) (total ^ total >>> 32);
        result = 31 * result + (pageable == null ? 0 : pageable.hashCode());
        result = 31 * result + content.hashCode();

        return result;
    }
}
