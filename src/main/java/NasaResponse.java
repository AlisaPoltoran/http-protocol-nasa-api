import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.*;

public class NasaResponse {
    public final String copyright;
    public final String date;
    public final String explanation;
    public final String hdurl;
    public final String media_type;
    public final String service_version;
    public final String title;
    public final String url;

    public NasaResponse(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return "NasaResponse{" +
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", media_type='" + media_type + '\'' +
                ", service_version='" + service_version + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}

//{"copyright":"Peter Kohlmann",
// "date":"2022-09-01",
// "explanation":"Framing a bright emission region, this telescopic view looks out along the plane
// of our Milky Way Galaxy toward the nebula rich constellation Cygnus the Swan. Popularly called the Tulip Nebula,
// the reddish glowing cloud of interstellar gas and dust is also found in the 1959 catalog by astronomer Stewart
// Sharpless as Sh2-101. Nearly 70 light-years across, the complex and beautiful Tulip Nebula blossoms about 8,000
// light-years away. Ultraviolet radiation from young energetic stars at the edge of the Cygnus OB3 association,
// including O star HDE 227018, ionizes the atoms and powers the emission from the Tulip Nebula. Also in the field of
// view is microquasar Cygnus X-1, one of the strongest X-ray sources in planet Earth's sky. Blasted by powerful jets
// from a lurking black hole its fainter bluish curved shock front is only just visible though, beyond the cosmic
// Tulip's petals near the right side of the frame.   Back to School? Learn Science with NASA",
// "hdurl":"https://apod.nasa.gov/apod/image/2209/TulipCygX-1.jpg",
// "media_type":"image",
// "service_version":"v1",
// "title":"The Tulip and Cygnus X-1",
// "url":"https://apod.nasa.gov/apod/image/2209/TulipCygX-1_1024.jpg"}