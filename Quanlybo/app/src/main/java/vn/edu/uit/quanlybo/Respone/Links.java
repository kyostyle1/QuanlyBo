package vn.edu.uit.quanlybo.Respone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by phuc9 on 10/28/2016.
 */
public class Links {

    @SerializedName("self")
    @Expose
    public Self self;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public class Self {

        @SerializedName("href")
        @Expose
        public String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}

