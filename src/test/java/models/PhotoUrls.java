package models;

import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.xjc.reader.Ring.add;

public class PhotoUrls {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public PhotoUrls(String url) {
        List<PhotoUrls> photoUrls = new ArrayList<PhotoUrls>();
        photoUrls.add(new PhotoUrls(url));
    }



}
