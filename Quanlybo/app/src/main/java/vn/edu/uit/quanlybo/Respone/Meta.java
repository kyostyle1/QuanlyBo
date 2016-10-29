package vn.edu.uit.quanlybo.Respone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by phuc9 on 10/28/2016.
 */
public class Meta {
    @SerializedName("totalCount")
    @Expose
    public Integer totalCount;
    @SerializedName("pageCount")
    @Expose
    public Integer pageCount;
    @SerializedName("currentPage")
    @Expose
    public Integer currentPage;
    @SerializedName("perPage")
    @Expose
    public Integer perPage;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }
}
