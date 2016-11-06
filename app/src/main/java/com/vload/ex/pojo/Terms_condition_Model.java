package com.vload.ex.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

/**
 * Created by DELL on 06/11/2016.
 */

//public class Terms_condition_Model implements Serializable {

    @Generated("org.jsonschema2pojo")
    public class Terms_condition_Model {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;

        /**
         *
         * @return
         *     The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         *     The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         *     The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         *     The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

    }
