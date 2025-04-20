package com.shop.productservice.dto.response;

public class CloudinaryResponse {
    private String publicId;
    private String url;

    // Private constructor để sử dụng với Builder
    private CloudinaryResponse(Builder builder) {
        this.publicId = builder.publicId;
        this.url = builder.url;
    }

    public String getPublicId() {
        return publicId;
    }

    public String getUrl() {
        return url;
    }

    // Builder class
    public static class Builder {
        private String publicId;
        private String url;

        public Builder publicId(String publicId) {
            this.publicId = publicId;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public CloudinaryResponse build() {
            return new CloudinaryResponse(this);
        }
    }

    // Phương thức tĩnh để tạo Builder
    public static Builder builder() {
        return new Builder();
    }
}